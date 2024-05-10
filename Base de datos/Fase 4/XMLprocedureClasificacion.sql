--muestra la clasifiacion de los equipos y el primero es el ganador con mas puntos
DECLARE
    result CLOB;
    v_nombre_competicion VARCHAR2(100);  -- Variable para almacenar el nombre de la competición
BEGIN
    -- Obtener el nombre de la competición
    SELECT C.NOMBRE_COM INTO v_nombre_competicion
    FROM COMPETICION C
    WHERE C.ID_COMPETICION = 1; -- Puedes cambiar el valor por el ID de la competición deseada

    -- Construir el XML
    SELECT
        XMLELEMENT(
            "clasificacion",-- Elemento raíz
            XMLATTRIBUTES(1 AS "id"),  -- Asignar el ID de la competición
            XMLFOREST(
                v_nombre_competicion AS "nombre_competicion",  -- Elemento del nombre de la competición
                (SELECT J.NOMBRE FROM JUEGO J INNER JOIN COMPETICION C ON J.ID_JUEGO = C.ID_JUEGO WHERE C.ID_COMPETICION = 1) AS "nombre_juego"  -- Subconsulta para obtener el nombre del juego
            ),
            (SELECT
                XMLAGG(
                    XMLELEMENT(
                        "equipo",
                        XMLATTRIBUTES(EC.ID_EQUIPO AS "id_equipo"),
                        XMLFOREST(
                            E.NOM_EQUIPO AS "nombre_equipo",
                            EC.VICTORIAS AS "victorias",
                            EC.PUNTOS AS "puntos"
                        )
                    )
                    ORDER BY EC.VICTORIAS DESC, EC.PUNTOS DESC  -- Ordenar por victorias y puntos
                )
            FROM EQUIPO_COMPETICION EC
            INNER JOIN EQUIPO E ON EC.ID_EQUIPO = E.ID_EQUIPO
            WHERE EC.ID_COMPETICION = 1 -- Puedes cambiar el valor por el ID de la competición deseada
            )
        ).getClobVal() INTO result  -- Obtener el resultado como CLOB
    FROM DUAL;

    -- Insertar el resultado en la tabla temp_clob_tab
    INSERT INTO temp_clob_tab (id_competicion, resultado) VALUES (1, result); -- Asigna el ID de la competición

    DBMS_OUTPUT.PUT_LINE('XML generado correctamente');  -- Confirmación de éxito
END;

DROP TABLE temp_clob_tab

CREATE TABLE temp_clob_tab (
    id_competicion NUMBER,
    resultado CLOB
);

select * from temp_clob_tab;
