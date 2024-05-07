CREATE OR REPLACE PROCEDURE OBTENER_INFORMACION
(c_obtenerInfo out SYS_REFCURSOR) AS
BEGIN
    OPEN c_obtenerInfo for
        SELECT nom_equipo,COUNT(DISTINCT s.id_staff) AS "cantidadStaff",
            COUNT(DISTINCT j.id_jugador) AS "cantidadJugadores"
        FROM EQUIPO e
        LEFT JOIN STAFF s ON e.id_equipo = s.id_equipo
        LEFT JOIN JUGADOR j ON e.id_equipo = j.id_equipo
        --WHERE e.nom_equipo = e_nom
        GROUP BY nom_equipo;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontro informacion para ' ||
        'el equipo especificado.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
END;
