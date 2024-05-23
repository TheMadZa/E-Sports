CREATE OR REPLACE PROCEDURE GENERAR_CALENDARIO(
    p_cod_compe IN NUMBER
)
AS
    CURSOR equipos_cur IS
        SELECT ID_EQUIPO
        FROM EQUIPOS_COMPETICIONES
        WHERE ID_COMPETICION = p_cod_compe;

    v_num_jornadas CONSTANT NUMBER := 10;  -- Número fijo de jornadas por competición
    v_jornada_date DATE := SYSDATE;
    v_cod_jornada NUMBER;
    TYPE equipo_tab IS TABLE OF NUMBER;
    equipos equipo_tab;
    v_temp_equipo NUMBER;
    v_last_jornada_id NUMBER;
    v_last_enfrentamiento_id NUMBER;

BEGIN
    -- Obtener el último ID de jornada y enfrentamiento
    SELECT NVL(MAX(ID_JORNADA), 0) INTO v_last_jornada_id FROM JORNADAS;
    SELECT NVL(MAX(ID_ENFRENTAMIENTO), 0) INTO v_last_enfrentamiento_id FROM ENFRENTAMIENTOS;

    -- Obtener los equipos en la competición
    OPEN equipos_cur;
    FETCH equipos_cur BULK COLLECT INTO equipos;
    CLOSE equipos_cur;

    IF equipos.COUNT < 8 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El número de equipos debe ser al menos 8 para garantizar 4 enfrentamientos por jornada.');
    END IF;

    FOR i IN 1..v_num_jornadas LOOP
        -- Insertar nueva jornada
        INSERT INTO JORNADAS (NUM_JORNADA, FECHA_JORNADA, ID_COMPETICION)
        VALUES (i, v_jornada_date, p_cod_compe);

        -- Generar enfrentamientos para la jornada
        FOR j IN 1..4 LOOP
            -- Enfrentamientos (circular)
            DECLARE
                v_local NUMBER := equipos(j);
                v_visitante NUMBER := equipos(equipos.COUNT - j + 1);
                v_hora_enfrentamiento DATE := v_jornada_date + (DBMS_RANDOM.VALUE(0, 1) / 24);
            BEGIN
                
                INSERT INTO ENFRENTAMIENTOS (HORA_ENFRENTAMIENTO, RESULTADO1, RESULTADO2, ID_EQUIPO1, ID_EQUIPO2, ID_JORNADA)
                VALUES (TO_TIMESTAMP(TO_CHAR(v_hora_enfrentamiento, 'DD-MM-YYYY HH24:MI'), 'DD-MM-YYYY HH24:MI'),
                        DBMS_RANDOM.VALUE(0, 5), DBMS_RANDOM.VALUE(0, 5), v_local, v_visitante, v_last_jornada_id);
            END;
        END LOOP;

        -- Rotar los equipos para la siguiente jornada (excepto el primer equipo)
        v_temp_equipo := equipos(2);
        FOR k IN 2..(equipos.COUNT - 1) LOOP
            equipos(k) := equipos(k + 1);
        END LOOP;
        equipos(equipos.COUNT) := v_temp_equipo;

        -- Incrementar la fecha de la jornada
        v_jornada_date := v_jornada_date + 7;
    END LOOP;
END;


CREATE OR REPLACE TRIGGER TRG_GENERATE_CALENDAR
AFTER UPDATE OF etapa ON competiciones
FOR EACH ROW
WHEN (NEW.etapa = 'C')
BEGIN
    GENERAR_CALENDARIO(:NEW.ID_COMPETICION);
END;