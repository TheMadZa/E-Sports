-- Eliminar el paquete.
DROP PACKAGE PAQUETE_DATOS;

-- Crear la cabecera del paquete.
CREATE OR REPLACE PACKAGE PAQUETE_DATOS
IS
	PROCEDURE OBTENER_INFO_COMPETICION(c_obtenerInfoCompeticion
                                        OUT SYS_REFCURSOR);
	PROCEDURE OBTENER_INFORMACION(c_obtenerInfo OUT SYS_REFCURSOR);
    PROCEDURE listarEquiposCompeticion(v_id_competicion IN
                                        COMPETICIONES.ID_COMPETICION%TYPE);
    FUNCTION OBTENER_CANTIDAD_JUGADORES(a_id_equipo IN EQUIPOS.ID_EQUIPO%TYPE)
        RETURN NUMBER;
END PAQUETE_DATOS;


-- Crear el cuerpo del paquete.
CREATE OR REPLACE PACKAGE BODY PAQUETE_DATOS
AS
	
	-- Pocedimientos:
    
    PROCEDURE OBTENER_INFO_COMPETICION(c_obtenerInfoCompeticion
                                        OUT SYS_REFCURSOR)
	AS
	BEGIN
    
        OPEN c_obtenerInfoCompeticion FOR
            SELECT
                C.NOMBRE_COM,
                J.NOMBRE,
                EF.HORA_ENFRENTAMIENTO AS HORA,
                E1.NOM_EQUIPO AS EQUIPO_1,
                COUNT(DISTINCT J1.ID_JUGADOR) AS CANTIDAD_JUGADORES_EQUIPO_1,
                COUNT(DISTINCT S1.ID_STAFF) AS CANTIDAD_STAFF_EQUIPO_1,
                E2.NOM_EQUIPO AS EQUIPO_2,
                COUNT(DISTINCT J2.ID_JUGADOR) AS CANTIDAD_JUGADORES_EQUIPO_2,
                COUNT(DISTINCT S2.ID_STAFF) AS CANTIDAD_STAFF_EQUIPO_2
            FROM 
                ENFRENTAMIENTOS EF
            INNER JOIN EQUIPOS E1 ON EF.ID_EQUIPO1 = E1.ID_EQUIPO
            INNER JOIN EQUIPOS E2 ON EF.ID_EQUIPO2 = E2.ID_EQUIPO
            INNER JOIN COMPETICIONES C ON C.ID_JUEGO = C.ID_JUEGO
            INNER JOIN JUEGOS J ON C.ID_JUEGO = J.ID_JUEGO
            LEFT JOIN JUGADORES J1 ON EF.ID_EQUIPO1 = J1.ID_EQUIPO
            LEFT JOIN STAFFS S1 ON EF.ID_EQUIPO1 = S1.ID_EQUIPO
            LEFT JOIN JUGADORES J2 ON EF.ID_EQUIPO2 = J2.ID_EQUIPO
            LEFT JOIN STAFFS S2 ON EF.ID_EQUIPO2 = S2.ID_EQUIPO 
            GROUP BY
                C.NOMBRE_COM,
                J.NOMBRE,
                EF.HORA_ENFRENTAMIENTO,
                E1.NOM_EQUIPO,
                E2.NOM_EQUIPO;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontro informacion especificada.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
            
    END OBTENER_INFO_COMPETICION;


	PROCEDURE OBTENER_INFORMACION(c_obtenerInfo OUT SYS_REFCURSOR)
    AS
    BEGIN

        OPEN c_obtenerInfo for
            SELECT nom_equipo,COUNT(DISTINCT s.id_staff) AS "cantidadStaff",
                COUNT(DISTINCT j.id_jugador) AS "cantidadJugadores"
            FROM EQUIPOS e
            LEFT JOIN STAFFS s ON e.id_equipo = s.id_equipo
            LEFT JOIN JUGADORES j ON e.id_equipo = j.id_equipo
            --WHERE e.nom_equipo = e_nom
            GROUP BY nom_equipo;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontro informacion para ' ||
            'el equipo especificado.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
            
    END OBTENER_INFORMACION;


    PROCEDURE listarEquiposCompeticion(v_id_competicion IN
                                        COMPETICIONES.ID_COMPETICION%TYPE)
    AS
    v_nombre_competicion COMPETICIONES.NOMBRE_COM%TYPE;
    v_id_equipo EQUIPOS_COMPETICIONES.ID_EQUIPO%TYPE;
    v_nombre_equipo EQUIPOS.NOM_EQUIPO%TYPE;
    v_victorias EQUIPOS_COMPETICIONES.VICTORIAS%TYPE;
    v_puntos EQUIPOS_COMPETICIONES.PUNTOS%TYPE;
    v_juego VARCHAR2(50);
    BEGIN
        FOR comp IN (SELECT C.NOMBRE_COM, EC.ID_EQUIPO, E.NOM_EQUIPO, EC.VICTORIAS,
                        EC.PUNTOS, J.NOMBRE AS NOMBRE_JUEGO
                     FROM COMPETICIONES C
                     INNER JOIN EQUIPOS_COMPETICIONES EC ON
                     C.ID_COMPETICION = EC.ID_COMPETICION
                     INNER JOIN EQUIPOS E ON EC.ID_EQUIPO = E.ID_EQUIPO
                     INNER JOIN JUEGOS J ON C.ID_JUEGO = J.ID_JUEGO
                     WHERE C.ID_COMPETICION = v_id_competicion
                     ORDER BY EC.VICTORIAS DESC, EC.PUNTOS DESC)
        LOOP
            v_nombre_competicion := comp.NOMBRE_COM;
            v_id_equipo := comp.ID_EQUIPO;
            v_nombre_equipo := comp.NOM_EQUIPO;
            v_victorias := comp.VICTORIAS;
            v_puntos := comp.PUNTOS;
            v_juego := comp.NOMBRE_JUEGO; -- Asignar el nombre del juego
    
            DBMS_OUTPUT.PUT_LINE('Competición: ' || v_nombre_competicion
            || ', Juego: ' || v_juego || ', Equipo: ' || v_nombre_equipo
            || ', Victorias: ' || v_victorias || ', Puntos: ' || v_puntos);
        END LOOP;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
    END listarEquiposCompeticion;


    -- Funciones:
    
    FUNCTION OBTENER_CANTIDAD_JUGADORES(a_id_equipo IN EQUIPOS.ID_EQUIPO%TYPE)
    RETURN NUMBER
    IS
        v_cantidad_jugadores NUMBER;
    BEGIN
        SELECT COUNT(*) INTO v_cantidad_jugadores
        FROM JUGADORES
        WHERE id_equipo = a_id_equipo;

        RETURN v_cantidad_jugadores;

    END OBTENER_CANTIDAD_JUGADORES;

END PAQUETE_DATOS;
