/*
Funcion para obtener el nombre del lider de un equipo, pasandole como
parametro el id del equipo.
*/
CREATE OR REPLACE FUNCTION FUNCION_LIDER(p_id_equipo IN equipo.id_equipo%type)
RETURN VARCHAR2
IS
    nombre_lider VARCHAR2(50);
    nombre_equipo VARCHAR2(50);
BEGIN
    SELECT J.NOMBRE, E.NOM_EQUIPO
    INTO nombre_lider, nombre_equipo
    FROM JUGADOR J
    JOIN EQUIPO E ON J.ID_EQUIPO = E.ID_EQUIPO
    WHERE J.ID_EQUIPO = p_id_equipo AND lower(J.ROL) = 'lider';

    RETURN 'El líder del equipo ' || nombre_equipo || ' es ' || nombre_lider || '.';
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontró un líder para el equipo especificado.';
    WHEN OTHERS THEN
        RETURN 'Ocurrió un error inesperado.';
END FUNCION_LIDER;
