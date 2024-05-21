SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE XML_JORNADAS_DTD AS
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

/

CREATE OR REPLACE PROCEDURE XML_JORNADAS_XSD AS
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
/

SELECT * FROM XML_JORNADAS;
/
-- Ejecutar el procedimiento
BEGIN
    XML_JORNADAS_DTD;
    XML_JORNADAS_XSD;
END;
/
DELETE FROM XML_JORNADAS;
