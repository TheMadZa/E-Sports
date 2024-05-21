CREATE OR REPLACE PROCEDURE XML_ULTIMA_JORNADA_XSD AS
    result CLOB;
BEGIN
    -- Construir el XML
    SELECT XMLELEMENT(
                "ultimaJornada",  -- Elemento raíz
                XMLATTRIBUTES('http://www.w3.org/2001/XMLSchema-instance' AS "xmlns:xsi",
                              'ultimaJornadaxsd.xsd' AS "xsi:noNamespaceSchemaLocation"),
                XMLAGG(
                    XMLELEMENT(
                        "competicion",
                        XMLATTRIBUTES(C.ID_COMPETICION AS "id"),
                        XMLFOREST(
                            C.NOMBRE_COM AS "nombre_competicion",
                            TO_CHAR(C.FECHA_INICIO, 'YYYY-MM-DD') AS "fecha_inicio",
                            TO_CHAR(C.FECHA_FIN, 'YYYY-MM-DD') AS "fecha_fin",
                            J.NOMBRE AS "nombre_juego"
                        ),
                        XMLELEMENT(
                            "jornadas",
                            (SELECT XMLAGG(
                                XMLELEMENT(
                                    "jornada",
                                    XMLATTRIBUTES(JR.ID_JORNADA AS "id_jornada"),
                                    XMLFOREST(
                                        JR.NUM_JORNADA AS "numero_jornada",
                                        TO_CHAR(JR.FECHA_JORNADA, 'YYYY-MM-DD') AS "fecha_jornada"
                                    ),
                                    (SELECT XMLAGG(
                                        XMLELEMENT(
                                            "enfrentamiento",
                                            XMLATTRIBUTES(EF.ID_ENFRENTAMIENTO AS "id"),
                                            XMLFOREST(
                                                EF.ID_EQUIPO1 AS "equipo1",
                                                EF.RESULTADO1 AS "resultado1",
                                                EF.ID_EQUIPO2 AS "equipo2",
                                                EF.RESULTADO2 AS "resultado2"
                                            )
                                        )
                                    ) FROM ENFRENTAMIENTOS EF
                                    WHERE EF.ID_JORNADA = JR.ID_JORNADA
                                    AND ROWNUM <= 2)  -- Limitar a 2 enfrentamientos
                                )
                            ) 
                            FROM JORNADAS JR
                            WHERE JR.ID_COMPETICION = C.ID_COMPETICION
                            AND JR.FECHA_JORNADA = (
                                SELECT MAX(JR2.FECHA_JORNADA)
                                FROM JORNADAS JR2
                                WHERE JR2.ID_COMPETICION = C.ID_COMPETICION
                            ))
                        )
                    )
                )
            ).getClobVal() INTO result  -- Obtener el resultado como CLOB
    FROM COMPETICIONES C
    INNER JOIN JUEGOS J ON J.ID_JUEGO = C.ID_JUEGO;
    
    
    RESULT := '<?xml version="1.0" encoding="UTF-8"?>'|| result;

    -- Insertar el resultado en la tabla XML_JORNADAS
    INSERT INTO XML_ULTIMA_JORNADA (RESULT) VALUES (result);

    DBMS_OUTPUT.PUT_LINE('XML generado correctamente');
    DBMS_OUTPUT.PUT_LINE(result);
END XML_ULTIMA_JORNADA_XSD;
/
CREATE OR REPLACE PROCEDURE XML_ULTIMA_JORNADA_DTD AS
    result CLOB;
BEGIN
    -- Construir el XML
    SELECT XMLELEMENT(
                "ultimaJornada",  -- Elemento raíz
                XMLAGG(
                    XMLELEMENT(
                        "competicion",
                        XMLATTRIBUTES(C.ID_COMPETICION AS "id"),
                        XMLFOREST(
                            C.NOMBRE_COM AS "nombre_competicion",
                            TO_CHAR(C.FECHA_INICIO, 'YYYY-MM-DD') AS "fecha_inicio",
                            TO_CHAR(C.FECHA_FIN, 'YYYY-MM-DD') AS "fecha_fin",
                            J.NOMBRE AS "nombre_juego"
                        ),
                        XMLELEMENT(
                            "jornadas",
                            (SELECT XMLAGG(
                                XMLELEMENT(
                                    "jornada",
                                    XMLATTRIBUTES(JR.ID_JORNADA AS "id_jornada"),
                                    XMLFOREST(
                                        JR.NUM_JORNADA AS "numero_jornada",
                                        TO_CHAR(JR.FECHA_JORNADA, 'YYYY-MM-DD') AS "fecha_jornada"
                                    ),
                                    (SELECT XMLAGG(
                                        XMLELEMENT(
                                            "enfrentamiento",
                                            XMLATTRIBUTES(EF.ID_ENFRENTAMIENTO AS "id"),
                                            XMLFOREST(
                                                EF.ID_EQUIPO1 AS "equipo1",
                                                EF.RESULTADO1 AS "resultado1",
                                                EF.ID_EQUIPO2 AS "equipo2",
                                                EF.RESULTADO2 AS "resultado2"
                                            )
                                        )
                                    ) FROM ENFRENTAMIENTOS EF
                                    WHERE EF.ID_JORNADA = JR.ID_JORNADA
                                    AND ROWNUM <= 2)  -- Limitar a 2 enfrentamientos
                                )
                            ) 
                            FROM JORNADAS JR
                            WHERE JR.ID_COMPETICION = C.ID_COMPETICION
                            AND JR.FECHA_JORNADA = (
                                SELECT MAX(JR2.FECHA_JORNADA)
                                FROM JORNADAS JR2
                                WHERE JR2.ID_COMPETICION = C.ID_COMPETICION
                            ))
                        )
                    )
                )
            ).getClobVal() INTO result  -- Obtener el resultado como CLOB
    FROM COMPETICIONES C
    INNER JOIN JUEGOS J ON J.ID_JUEGO = C.ID_JUEGO;
    
    
    RESULT := '<?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE ultimaJornada SYSTEM "ultimaJornadadtd.dtd">'|| result;

    -- Insertar el resultado en la tabla XML_JORNADAS
    INSERT INTO XML_ULTIMA_JORNADA (RESULT) VALUES (result);

    DBMS_OUTPUT.PUT_LINE('XML generado correctamente');
    DBMS_OUTPUT.PUT_LINE(result);
END XML_ULTIMA_JORNADA_DTD;
/

SELECT * FROM  XML_ULTIMA_JORNADA;

DECLARE
BEGIN
    XML_ULTIMA_JORNADA_DTD;
    XML_ULTIMA_JORNADA_XSD;
end;
/
DELETE FROM XML_ULTIMA_JORNADA;