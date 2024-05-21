SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE XML_CLASIFI_DTD AS
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
/
CREATE OR REPLACE PROCEDURE XML_CLASIFI_XSD AS
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
/

SELECT * FROM XML_CLASIFICACION;

DECLARE
BEGIN
    XML_CLASIFI_DTD;
    XML_CLASIFI_XSD;
end;
/
DELETE FROM XML_CLASIFICACION;