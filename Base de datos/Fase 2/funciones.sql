/*
Función para obtener la cantidad de jugadores de un equipo
a partir del ID de ese equipo.
Obtendrá el valor del resultado de un COUNT de "JUGADOR"
en base al argumento "ID_EQUIPO".
*/
CREATE OR REPLACE FUNCTION OBTENER_CANTIDAD_JUGADORES(a_id_equipo IN
    EQUIPOS.ID_EQUIPO%TYPE)
RETURN NUMBER
IS
    v_cantidad_jugadores NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_cantidad_jugadores
	FROM JUGADORES
	WHERE id_equipo = a_id_equipo;

    RETURN v_cantidad_jugadores;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR('-20008','No se han encontrado datos');

END OBTENER_CANTIDAD_JUGADORES;


-- Esta funcion no la utilizaremos de momento.
/*
Función para obtener el valor/estado de la etapa de una
competición en la que participa un equipo, a partir del
ID de ese equipo.
Obtendrá el valor de la etapa en base al argumento "ID_EQUIPO".
*/
/*
CREATE OR REPLACE FUNCTION OBTENER_ETAPA_COMPETICION(a_id_equipo IN EQUIPOS.ID_EQUIPO%TYPE)
RETURN VARCHAR2
IS
    v_etapa_competicion COMPETICIONES.ETAPA%TYPE;
BEGIN
    SELECT ETAPA INTO v_etapa_competicion
	FROM COMPETICIONES
	WHERE id_competicion = (SELECT id_competicion
	                        FROM equipos_competiciones
	                        WHERE id_equipo = a_id_equipo);
	
    RETURN v_etapa_competicion;
END OBTENER_ETAPA_COMPETICION;
*/
