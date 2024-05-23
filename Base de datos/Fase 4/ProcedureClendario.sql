INSERT INTO COMPETICIONES (ID_COMPETICION, NOMBRE_COM, FECHA_INICIO, FECHA_FIN, ETAPA, ID_JUEGO, ID_EQUIPO_GANADOR)
VALUES (DEFAULT, 'ESL-R6', 
        TO_DATE('04-04-2029', 'DD-MM-YYYY'), 
        TO_DATE('04-04-2030', 'DD-MM-YYYY'), 'A', 11, NULL);

INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)
VALUES (4, 5, 0, 0);
INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)
VALUES (7, 5, 0, 0);
INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)            
VALUES (6, 5, 0, 0);
INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)
VALUES (8, 5, 0, 0);
INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)
VALUES (10, 5, 0, 0);
INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)
VALUES (9, 5, 0, 0);
INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)
VALUES (5, 5, 0, 0);
INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)
VALUES (3, 5, 0, 0);
INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)
VALUES (6, 5, 0, 0);
INSERT INTO EQUIPOS_COMPETICIONES (ID_EQUIPO, ID_COMPETICION, VICTORIAS, PUNTOS)
VALUES (7, 5, 0, 0);

/
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
        v_last_jornada_id := v_last_jornada_id + 1;
        INSERT INTO JORNADAS (ID_JORNADA, NUM_JORNADA, FECHA_JORNADA, ID_COMPETICION)
        VALUES (v_last_jornada_id, i, v_jornada_date, p_cod_compe);

        -- Generar enfrentamientos para la jornada
        FOR j IN 1..4 LOOP
            -- Enfrentamientos (circular)
            DECLARE
                v_local NUMBER := equipos(j);
                v_visitante NUMBER := equipos(equipos.COUNT - j + 1);
                v_hora_enfrentamiento DATE := v_jornada_date + (DBMS_RANDOM.VALUE(0, 1) / 24);
            BEGIN
                v_last_enfrentamiento_id := v_last_enfrentamiento_id + 1;
                INSERT INTO ENFRENTAMIENTOS (ID_ENFRENTAMIENTO, HORA_ENFRENTAMIENTO, RESULTADO1, RESULTADO2, ID_EQUIPO1, ID_EQUIPO2, ID_JORNADA)
                VALUES (v_last_enfrentamiento_id, TO_TIMESTAMP(TO_CHAR(v_hora_enfrentamiento, 'DD-MM-YYYY HH24:MI'), 'DD-MM-YYYY HH24:MI'),
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
/

CREATE OR REPLACE TRIGGER trg_generate_calendar
AFTER UPDATE OF etapa ON competiciones
FOR EACH ROW
WHEN (NEW.etapa = 'C')
BEGIN
    GENERAR_CALENDARIO(:NEW.ID_COMPETICION);
END;
/
DECLARE
BEGIN
    GENERAR_CALENDARIO(5);
END;
SELECT * FROM JORNADAS WHERE ID_COMPETICION = 5;

