SET SERVEROUTPUT ON;


CREATE OR REPLACE PACKAGE PAQUETE_XML
is
    PROCEDURE XML_CLASIFI_DTD;
    PROCEDURE XML_CLASIFI_XSD;
    PROCEDURE XML_JORNADAS_DTD;
    PROCEDURE XML_JORNADAS_XSD;
    PROCEDURE XML_ULTIMA_JORNADA_DTD;
    PROCEDURE XML_ULTIMA_JORNADA_XSD;
    
end PAQUETE_XML;

CREATE OR REPLACE PACKAGE BODY PAQUETE_XML
AS
PROCEDURE XML_CLASIFI_DTD AS
    RESULT CLOB;
BEGIN
    RESULT := '<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE clasificacion SYSTEM "clasificaciondtd.dtd">
<clasificacion>';

    FOR comp IN (SELECT C.ID_COMPETICION, C.NOMBRE_COM, J.NOMBRE 
                 FROM COMPETICIONES C 
                 INNER JOIN JUEGOS J ON J.ID_JUEGO = C.ID_JUEGO) LOOP
        RESULT := RESULT || '
    <competicion id="' || comp.ID_COMPETICION || '">
        <nombre_competicion>' || comp.NOMBRE_COM || '</nombre_competicion>
        <nombre_juego>' || comp.NOMBRE || '</nombre_juego>';
        

        FOR equipo_info IN (SELECT EC.ID_EQUIPO, E.NOM_EQUIPO, EC.VICTORIAS, EC.PUNTOS
                            FROM EQUIPOS_COMPETICIONES EC
                            INNER JOIN EQUIPOS E ON EC.ID_EQUIPO = E.ID_EQUIPO
                            WHERE EC.ID_COMPETICION = comp.ID_COMPETICION
                            ORDER BY EC.VICTORIAS DESC, EC.PUNTOS DESC) LOOP
            RESULT := RESULT || '
        <equipo id_equipo="' || equipo_info.ID_EQUIPO || '">
            <nombre_equipo>' || equipo_info.NOM_EQUIPO || '</nombre_equipo>
            <victorias>' || equipo_info.VICTORIAS || '</victorias>
            <puntos>' || equipo_info.PUNTOS || '</puntos>
        </equipo>';
        END LOOP;

        RESULT := RESULT || '
    </competicion>';
    END LOOP;

    RESULT := RESULT || '
</clasificacion>';

    -- Insertar el resultado en la tabla temp_clob_tab
    INSERT INTO XML_Clasificacion (result) VALUES (RESULT);

    DBMS_OUTPUT.PUT_LINE('XML generado correctamente');  -- Confirmación de éxito
    DBMS_OUTPUT.PUT_LINE(RESULT);

END XML_CLASIFI_DTD;
PROCEDURE XML_CLASIFI_XSD AS
    RESULT CLOB;
BEGIN
    RESULT := '<?xml version="1.0" encoding="UTF-8"?>
<clasificacion 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:noNamespaceSchemaLocation="clasificacionxsd.xsd">';

    FOR comp IN (SELECT C.ID_COMPETICION, C.NOMBRE_COM, J.NOMBRE 
                 FROM COMPETICIONES C 
                 INNER JOIN JUEGOS J ON J.ID_JUEGO = C.ID_JUEGO) LOOP
        RESULT := RESULT || '
    <competicion id="' || comp.ID_COMPETICION || '">
        <nombre_competicion>' || comp.NOMBRE_COM || '</nombre_competicion>
        <nombre_juego>' || comp.NOMBRE || '</nombre_juego>';
        

        FOR equipo_info IN (SELECT EC.ID_EQUIPO, E.NOM_EQUIPO, EC.VICTORIAS, EC.PUNTOS
                            FROM EQUIPOS_COMPETICIONES EC
                            INNER JOIN EQUIPOS E ON EC.ID_EQUIPO = E.ID_EQUIPO
                            WHERE EC.ID_COMPETICION = comp.ID_COMPETICION
                            ORDER BY EC.VICTORIAS DESC, EC.PUNTOS DESC) LOOP
            RESULT := RESULT || '
        <equipo id_equipo="' || equipo_info.ID_EQUIPO || '">
            <nombre_equipo>' || equipo_info.NOM_EQUIPO || '</nombre_equipo>
            <victorias>' || equipo_info.VICTORIAS || '</victorias>
            <puntos>' || equipo_info.PUNTOS || '</puntos>
        </equipo>';
        END LOOP;

        RESULT := RESULT || '
    </competicion>';
    END LOOP;

    RESULT := RESULT || '
</clasificacion>';

    -- Insertar el resultado en la tabla temp_clob_tab
    INSERT INTO XML_Clasificacion (result) VALUES (RESULT);

    DBMS_OUTPUT.PUT_LINE('XML generado correctamente');  -- Confirmación de éxito
    DBMS_OUTPUT.PUT_LINE(RESULT);

END XML_CLASIFI_XSD;

PROCEDURE XML_JORNADAS_DTD AS
    result CLOB;
BEGIN
    result := '<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE competiciones SYSTEM "jornadasdtd.dtd">
<competiciones>';

    -- Bucle para las competiciones
    FOR comp IN (SELECT C.ID_COMPETICION, C.NOMBRE_COM, C.FECHA_INICIO, C.FECHA_FIN, J.NOMBRE 
                 FROM COMPETICIONES C 
                 INNER JOIN JUEGOS J ON J.ID_JUEGO = C.ID_JUEGO
                 ORDER BY C.ID_COMPETICION) LOOP

        -- Agregar información de la competición al XML
        result := result || '
    <competicion id="' || TO_CHAR(comp.ID_COMPETICION) || '">
        <nombre_competicion>' || comp.NOMBRE_COM || '</nombre_competicion>
        <fecha_inicio>' || TO_CHAR(comp.FECHA_INICIO, 'YYYY-MM-DD') || '</fecha_inicio>
        <fecha_fin>' || TO_CHAR(comp.FECHA_FIN, 'YYYY-MM-DD') || '</fecha_fin>
        <nombre_juego>' || comp.NOMBRE || '</nombre_juego>
        <jornadas>';

        -- Bucle para las jornadas de la competición
        FOR jornadas IN (SELECT J.ID_JORNADA, J.NUM_JORNADA, J.FECHA_JORNADA
                         FROM JORNADAS J
                         WHERE J.ID_COMPETICION = comp.ID_COMPETICION
                         ORDER BY J.ID_JORNADA DESC) LOOP

            -- Inicializar contador
            DECLARE
                contador NUMBER := 0;
            BEGIN

                -- Agregar información de la jornada al XML
                result := result || '
            <jornada id_jornada="' || TO_CHAR(jornadas.ID_JORNADA) || '">
                <numero_jornada>' || TO_CHAR(jornadas.NUM_JORNADA) || '</numero_jornada>
                <fecha_jornada>' || TO_CHAR(jornadas.FECHA_JORNADA, 'YYYY-MM-DD') || '</fecha_jornada>';

                -- Bucle para los enfrentamientos de la jornada
                FOR enfrentamiento IN (SELECT EF.ID_EQUIPO1, EF.ID_EQUIPO2, EF.RESULTADO1, EF.RESULTADO2, EF.ID_ENFRENTAMIENTO
                                       FROM ENFRENTAMIENTOS EF
                                       WHERE EF.ID_JORNADA = jornadas.ID_JORNADA
                                       AND ROWNUM <= 4
                                       ORDER BY EF.ID_ENFRENTAMIENTO) LOOP

                    -- Agregar información del enfrentamiento al XML
                    result := result || '
                <enfrentamiento id="' || TO_CHAR(enfrentamiento.ID_ENFRENTAMIENTO) || '">
                    <resultados>' || TO_CHAR(enfrentamiento.RESULTADO1) ||' - '|| TO_CHAR(enfrentamiento.RESULTADO2) || '</resultados>
                </enfrentamiento>';

                END LOOP; -- Fin del bucle de enfrentamientos

                -- Cerrar la sección de jornada en el XML
                result := result || '
            </jornada>';

            END; -- Fin del bloque declarativo

        END LOOP; -- Fin del bucle de jornadas

        -- Cerrar la sección de jornadas y competición en el XML
        result := result || '
        </jornadas>
    </competicion>';

    END LOOP; -- Fin del bucle de competiciones

    -- Cerrar la sección de competiciones en el XML
    result := result || '
</competiciones>';

    -- Insertar el resultado en la tabla XML_JORNADAS
    INSERT INTO XML_JORNADAS (result) VALUES (result);

    DBMS_OUTPUT.PUT_LINE('XML generado correctamente');
    DBMS_OUTPUT.PUT_LINE(result);
END XML_JORNADAS_DTD;
PROCEDURE XML_JORNADAS_XSD AS
    result CLOB;
BEGIN
    result := '<?xml version="1.0" encoding="UTF-8"?>
<competiciones 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:noNamespaceSchemaLocation="jornadasxsd.xsd">';

    -- Bucle para las competiciones
    FOR comp IN (SELECT C.ID_COMPETICION, C.NOMBRE_COM, C.FECHA_INICIO, C.FECHA_FIN, J.NOMBRE 
                 FROM COMPETICIONES C 
                 INNER JOIN JUEGOS J ON J.ID_JUEGO = C.ID_JUEGO
                 ORDER BY C.ID_COMPETICION) LOOP

        -- Agregar información de la competición al XML
        result := result || '
    <competicion id="' || TO_CHAR(comp.ID_COMPETICION) || '">
        <nombre_competicion>' || comp.NOMBRE_COM || '</nombre_competicion>
        <fecha_inicio>' || TO_CHAR(comp.FECHA_INICIO, 'YYYY-MM-DD') || '</fecha_inicio>
        <fecha_fin>' || TO_CHAR(comp.FECHA_FIN, 'YYYY-MM-DD') || '</fecha_fin>
        <nombre_juego>' || comp.NOMBRE || '</nombre_juego>
        <jornadas>';

        -- Bucle para las jornadas de la competición
        FOR jornadas IN (SELECT J.ID_JORNADA, J.NUM_JORNADA, J.FECHA_JORNADA
                         FROM JORNADAS J
                         WHERE J.ID_COMPETICION = comp.ID_COMPETICION
                         ORDER BY J.ID_JORNADA DESC) LOOP

            -- Inicializar contador
            DECLARE
                contador NUMBER := 0;
            BEGIN

                -- Agregar información de la jornada al XML
                result := result || '
            <jornada id_jornada="' || TO_CHAR(jornadas.ID_JORNADA) || '">
                <numero_jornada>' || TO_CHAR(jornadas.NUM_JORNADA) || '</numero_jornada>
                <fecha_jornada>' || TO_CHAR(jornadas.FECHA_JORNADA, 'YYYY-MM-DD') || '</fecha_jornada>';

                -- Bucle para los enfrentamientos de la jornada
                FOR enfrentamiento IN (SELECT EF.ID_EQUIPO1, EF.ID_EQUIPO2, EF.RESULTADO1, EF.RESULTADO2, EF.ID_ENFRENTAMIENTO
                                       FROM ENFRENTAMIENTOS EF
                                       WHERE EF.ID_JORNADA = jornadas.ID_JORNADA
                                       AND ROWNUM <= 4
                                       ORDER BY EF.ID_ENFRENTAMIENTO) LOOP

                    -- Agregar información del enfrentamiento al XML
                    result := result || '
                <enfrentamiento id="' || TO_CHAR(enfrentamiento.ID_ENFRENTAMIENTO) || '">
                    <resultados>' || TO_CHAR(enfrentamiento.RESULTADO1) ||' - '|| TO_CHAR(enfrentamiento.RESULTADO2) || '</resultados>
                </enfrentamiento>';

                END LOOP; -- Fin del bucle de enfrentamientos

                -- Cerrar la sección de jornada en el XML
                result := result || '
            </jornada>';

            END; -- Fin del bloque declarativo

        END LOOP; -- Fin del bucle de jornadas

        -- Cerrar la sección de jornadas y competición en el XML
        result := result || '
        </jornadas>
    </competicion>';

    END LOOP; -- Fin del bucle de competiciones

    -- Cerrar la sección de competiciones en el XML
    result := result || '
</competiciones>';

    -- Insertar el resultado en la tabla XML_JORNADAS
    INSERT INTO XML_JORNADAS (result) VALUES (result);

    DBMS_OUTPUT.PUT_LINE('XML generado correctamente');
    DBMS_OUTPUT.PUT_LINE(result);
END XML_JORNADAS_XSD;
PROCEDURE XML_ULTIMA_JORNADA_XSD AS
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

PROCEDURE XML_ULTIMA_JORNADA_DTD AS
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

END PAQUETE_XML;

/
--PROCESO ANONIMO PARA PROBAR EL PACQUETE

--PROCEDIMIENTO XML PARA CLASIFICACIONES
DECLARE
BEGIN
    PAQUETE_XML.XML_CLASIFI_DTD;
    PAQUETE_XML.XML_CLASIFI_XSD;
end;
/
--PROCEDIMIENTO XML PARA JORNADAS
DECLARE
BEGIN
    PAQUETE_XML.XML_JORNADAS_DTD;
    PAQUETE_XML.XML_JORNADAS_XSD;
END;
/
--PROCEDIMIENTO XML PARA LA ULTIMA JORNADA
DECLARE
BEGIN
    PAQUETE_XML.XML_ULTIMA_JORNADA_DTD;
    PAQUETE_XML.XML_ULTIMA_JORNADA_XSD;
end;
/

SELECT * FROM XML_CLASIFICACION;
SELECT * FROM XML_JORNADAS;
SELECT * FROM  XML_ULTIMA_JORNADA;
