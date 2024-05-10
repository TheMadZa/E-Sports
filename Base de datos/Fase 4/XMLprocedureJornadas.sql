DECLARE
    result CLOB;
BEGIN
    -- Construir el XML
    SELECT
        XMLELEMENT(
            "jornadas",-- Elemento raíz
            XMLAGG(
                XMLELEMENT(
                    "jornada",
                    XMLATTRIBUTES(JORNADA.ID_JORNADA AS "id"),
                    XMLFOREST(
                        JORNADA.NUM_JORNADA AS "numero_jornada",
                        JORNADA.FECHA_JORNADA AS "fecha_jornada",
                        XMLELEMENT(
                            "competicion",
                            XMLATTRIBUTES(COMPETICION.ID_COMPETICION AS "id"),
                            XMLFOREST(
                                COMPETICION.NOMBRE_COM AS "nombre-competicion",
                                COMPETICION.FECHA_INICIO AS "fecha-inicio",
                                COMPETICION.FECHA_FIN AS "fecha-fin",
                                COMPETICION.ETAPA AS "etapa",
                                (SELECT NOMBRE FROM JUEGO WHERE ID_JUEGO = COMPETICION.ID_JUEGO) AS "juego",
                                COMPETICION.ID_EQUIPO_GANADOR AS "ganador"
                            )
                        ) AS "competicion-info"
                    )
                )
            )
        ).getClobVal() INTO result  -- Obtener el resultado como CLOB
    FROM COMPETICION, JORNADA
    WHERE JORNADA.ID_COMPETICION = COMPETICION.ID_COMPETICION;

    -- Insertar el resultado en la tabla temp_clob_tab
    INSERT INTO temp_clob_tab (resultado) VALUES (result);

    DBMS_OUTPUT.PUT_LINE('XML generado correctamente');  -- Confirmación de éxito
END;

/
DROP TABLE temp_clob_tab

CREATE TABLE temp_clob_tab (
    resultado CLOB
);

select * from temp_clob_tab;