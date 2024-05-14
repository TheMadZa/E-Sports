/*Scripts de borrado y creaciOn de los TRIGGERS*/
DROP TRIGGER CANTIDAD_EQUIPO_INSERT;
DROP TRIGGER CANTIDAD_EQUIPO_DELETE;
DROP TRIGGER CANTIDAD_EQUIPO_UPDATE;
DROP TRIGGER GENERAR_CALENDARIO;
DROP TRIGGER NOMODIFICAR_EQUIPO;
DROP TRIGGER NOMODIFICAR_JUGADOR;
DROP TRIGGER MAXSALARIO_EQUIPO_INSERT;
DROP TRIGGER MAXSALARIO_EQUIPO_UPDATE;
DROP TRIGGER ACTUALIZAR_RESULTADOS;


/*Controlar que no haya más de 6 ni menos de 2 jugadores en un equipo.*/
CREATE OR REPLACE TRIGGER CANTIDAD_EQUIPO_INSERT
BEFORE INSERT ON JUGADOR
FOR EACH ROW
DECLARE
    v_cantidad NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_cantidad
    FROM JUGADOR
    WHERE id_equipo = :new.id_equipo;
        
    IF v_cantidad >= 6 THEN
        RAISE_APPLICATION_ERROR('-20001','No puede haber mas de 6 jugadores');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR('-20002','Error al encontrar informacion.');

END CANTIDAD_EQUIPO_INSERT;

CREATE OR REPLACE NONEDITIONABLE TRIGGER CANTIDAD_EQUIPO_DELETE
FOR DELETE ON JUGADOR
COMPOUND TRIGGER
    equipo_id NUMBER;
    v_cantidad NUMBER;
    
    BEFORE EACH ROW IS
        BEGIN
            equipo_id:= :OLD.ID_EQUIPO;
    END BEFORE EACH ROW;
    
    AFTER STATEMENT IS
        BEGIN
            SELECT COUNT(*) INTO v_cantidad
            FROM JUGADOR
            WHERE id_equipo = equipo_id;

            IF v_cantidad < 2 THEN
                RAISE_APPLICATION_ERROR('-20002',
                    'No puede haber menos de 2 jugadores.');
            END IF;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RAISE_APPLICATION_ERROR('-20001','No se han encontrado datos');
    END AFTER STATEMENT;
END CANTIDAD_EQUIPO_DELETE;

CREATE OR REPLACE NONEDITIONABLE TRIGGER CANTIDAD_EQUIPO_UPDATE
FOR UPDATE ON JUGADOR
COMPOUND TRIGGER
    equipo_id_old NUMBER;
    equipo_id_new NUMBER;
    v_cantidad NUMBER;
    BEFORE EACH ROW IS
        BEGIN
            equipo_id_new := :NEW.ID_EQUIPO;
            equipo_id_old := :OLD.ID_EQUIPO;
    END BEFORE EACH ROW;
    
    AFTER STATEMENT IS
        BEGIN
            SELECT COUNT(*) INTO v_cantidad
            FROM JUGADOR
            WHERE id_equipo = equipo_id_new;

            IF v_cantidad > 6 THEN
                RAISE_APPLICATION_ERROR('-20003','No puede haber mas de
                    6 jugadores.');
            END IF;
            
            SELECT COUNT(*) INTO v_cantidad
            FROM JUGADOR
            WHERE id_equipo = equipo_id_old;
            
            IF v_cantidad <= 2 THEN
                RAISE_APPLICATION_ERROR('-20002',
                    'No puede haber menos de 2 jugadores.');
            END IF;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RAISE_APPLICATION_ERROR('-20001','No se han encontrado datos');
    END AFTER STATEMENT;

END CANTIDAD_EQUIPO_UPDATE;

--Trigger CANTIDAD_EQUIPO_INSERT compilado
--Trigger CANTIDAD_EQUIPO_UPDATE compilado
--Trigger CANTIDAD_EQUIPO_DELETE compilado

/*Controlar que para poder generar el calendario de una competicion
todos los equipos tienen que tener un mínimo de 2 jugadores.*/
CREATE OR REPLACE TRIGGER GENERAR_CALENDARIO
BEFORE INSERT ON JORNADA
FOR EACH ROW
DECLARE
    v_cantidad_min NUMBER;
    v_equipo_id EQUIPO.ID_EQUIPO%TYPE;
BEGIN
    
    FOR lista_equipos IN (SELECT id_equipo FROM EQUIPO)
    LOOP
        v_cantidad_min := 0;
        v_equipo_id := lista_equipos.id_equipo;

        v_cantidad_min := OBTENER_CANTIDAD_JUGADORES(v_equipo_id);
        
        IF v_cantidad_min < 2 THEN
            RAISE_APPLICATION_ERROR('-20001','Hay menos de 2 jugadores.');
        END IF;
    END LOOP;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR('-20002','No se han encontrado equipos.');
END GENERAR_CALENDARIO;

--Trigger GENERAR_CALENDARIO compilado

/*Controlar que una vez generado el calendario de la competicion, no se
pueden modificar los equipos.*/
CREATE OR REPLACE TRIGGER NOMODIFICAR_EQUIPO
BEFORE INSERT OR DELETE OR UPDATE ON EQUIPO_COMPETICION
FOR EACH ROW
DECLARE
    v_etapa_competicion COMPETICION.etapa%TYPE;
    e_etapa_cerrada EXCEPTION;
BEGIN
    IF INSERTING THEN
        SELECT C.etapa INTO v_etapa_competicion
        FROM COMPETICION C
        WHERE C.id_competicion = :new.id_competicion;
    
        IF v_etapa_competicion = 'C' THEN
            RAISE e_etapa_cerrada;
        END IF;
        
    ELSIF DELETING THEN
        SELECT C.etapa INTO v_etapa_competicion
        FROM COMPETICION C
        WHERE C.id_competicion = :old.id_competicion;
    
        IF v_etapa_competicion = 'C' THEN
            RAISE e_etapa_cerrada;
        END IF;
    
    ELSIF UPDATING THEN
        SELECT C.etapa INTO v_etapa_competicion
        FROM COMPETICION C
        WHERE C.id_competicion = :new.id_competicion;
        
        IF v_etapa_competicion = 'C' THEN
            RAISE e_etapa_cerrada;
        END IF;
        
        SELECT C.etapa INTO v_etapa_competicion
        FROM COMPETICION C
        WHERE C.id_competicion = :old.id_competicion;
        
        IF v_etapa_competicion = 'C' THEN
            RAISE e_etapa_cerrada;
        END IF;
    END IF;
    
EXCEPTION
    WHEN e_etapa_cerrada THEN
        RAISE_APPLICATION_ERROR('-20001','La etapa está cerrada.');
END NOMODIFICAR_EQUIPO;

--Trigger NOMODIFICAR_EQUIPO compilado

/*Controlar que una vez generado el calendario de la competicion, no se
pueden modificar los jugadores de cada equipo.*/
CREATE OR REPLACE TRIGGER NOMODIFICAR_JUGADOR
BEFORE INSERT OR DELETE OR UPDATE ON JUGADOR
FOR EACH ROW
DECLARE
    v_etapa_competicion COMPETICION.ETAPA%TYPE;
    v_competencia_cerrada BOOLEAN := FALSE;
    e_competencia_cerrada EXCEPTION;
BEGIN

    IF INSERTING THEN
        FOR comp IN (SELECT C.etapa
                  FROM EQUIPO_COMPETICION EC
                  JOIN COMPETICION C ON EC.id_competicion = C.id_competicion
                  WHERE EC.id_equipo = :new.id_equipo)
        LOOP
            IF comp.etapa = 'C' THEN
                v_competencia_cerrada := TRUE;
                EXIT;
            END IF;
        END LOOP;
        
        IF v_competencia_cerrada THEN
            RAISE_APPLICATION_ERROR('-20001', 'Al menos una competicion asociada
                al equipo esta cerrada. No se pueden modificar los jugadores.');
        END IF;
    
    ELSIF DELETING THEN
        FOR comp IN (SELECT C.etapa
                  FROM EQUIPO_COMPETICION EC
                  JOIN COMPETICION C ON EC.id_competicion = C.id_competicion
                  WHERE EC.id_equipo = :old.id_equipo)
        LOOP
            IF comp.etapa = 'C' THEN
                v_competencia_cerrada := TRUE;
                EXIT;
            END IF;
        END LOOP;
        
        IF v_competencia_cerrada THEN
            RAISE_APPLICATION_ERROR('-20002', 'Al menos una competicion asociada
                al equipo esta cerrada. No se pueden modificar los jugadores.');
        END IF;
    
    ELSIF UPDATING THEN
        FOR comp IN (SELECT C.etapa
                  FROM EQUIPO_COMPETICION EC
                  JOIN COMPETICION C ON EC.id_competicion = C.id_competicion
                  WHERE EC.id_equipo = :new.id_equipo)
        LOOP
            IF comp.etapa = 'C' THEN
                v_competencia_cerrada := TRUE;
                EXIT;
            END IF;
        END LOOP;
        
        IF v_competencia_cerrada THEN
            RAISE_APPLICATION_ERROR('-20003', 'Al menos una competicion asociada
                al equipo esta cerrada. No se pueden modificar los jugadores.');
        END IF;
        
        FOR comp IN (SELECT C.etapa
                  FROM EQUIPO_COMPETICION EC
                  JOIN COMPETICION C ON EC.id_competicion = C.id_competicion
                  WHERE EC.id_equipo = :old.id_equipo)
        LOOP
            IF comp.etapa = 'C' THEN
                v_competencia_cerrada := TRUE;
                EXIT;
            END IF;
        END LOOP;
        
        IF v_competencia_cerrada THEN
            RAISE_APPLICATION_ERROR('-20004', 'Al menos una competicion asociada
                al equipo esta cerrada. No se pueden modificar los jugadores.');
        END IF;
        
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR('-20005','No se han encontrado datos.');
END NOMODIFICAR_JUGADOR;

--Trigger NOMODIFICAR_JUGADOR compilado

/*Controlar que el salario total de los jugadores del equipo no podra ser
superior a 200.000€ anuales.*/
CREATE OR REPLACE TRIGGER MAXSALARIO_EQUIPO_INSERT
BEFORE INSERT ON JUGADOR
FOR EACH ROW
DECLARE
    v_salarioanual_total NUMBER;
BEGIN
    SELECT NVL(SUM(SUELDO * 12),0) INTO v_salarioanual_total
    FROM JUGADOR
    WHERE id_equipo = :new.id_equipo;
    
    IF v_salarioanual_total + :new.sueldo * 12 > 200000 THEN
        RAISE_APPLICATION_ERROR('-20001','El salario del equipo es más
            de 200000');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR('-20002','No se han encontrado datos');
END MAXSALARIO_EQUIPO_INSERT;

CREATE OR REPLACE NONEDITIONABLE TRIGGER MAXSALARIO_EQUIPO_UPDATE
FOR UPDATE ON JUGADOR
COMPOUND TRIGGER
    v_salarioanual_total NUMBER;
    equipo_id NUMBER;
    BEFORE EACH ROW IS
        BEGIN
            equipo_id := :NEW.ID_EQUIPO;
    END BEFORE EACH ROW;
    
    AFTER STATEMENT IS
        BEGIN
            SELECT NVL(SUM(SUELDO * 12),0) INTO v_salarioanual_total
            FROM JUGADOR
            WHERE id_equipo = equipo_id;

            IF v_salarioanual_total > 200000 THEN
                RAISE_APPLICATION_ERROR('-20001','El salario del equipo es más 
                    de 200000');
            END IF;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RAISE_APPLICATION_ERROR('-20001','Error al encontrar informacion.');
    END AFTER STATEMENT;

END MAXSALARIO_EQUIPO_UPDATE;

--Trigger MAXSALARIO_EQUIPO_INSERT compilado
--Trigger MAXSALARIO_EQUIPO_UPDATE compilado

/*Controlar que los resultados de los enfrentamientos estén correctos*/
CREATE OR REPLACE TRIGGER ACTUALIZAR_RESULTADOS
AFTER INSERT ON ENFRENTAMIENTO
FOR EACH ROW
DECLARE
    v_equipo1 NUMBER(2);
    v_equipo2 NUMBER(2);
    v_resultado1 NUMBER(2);
    v_resultado2 NUMBER(2);
BEGIN
    -- Obtener los datos del enfrentamiento insertado
    v_equipo1 := :NEW.ID_EQUIPO1;
    v_equipo2 := :NEW.ID_EQUIPO2;
    v_resultado1 := :NEW.RESULTADO1;
    v_resultado2 := :NEW.RESULTADO2;
    
    -- Actualizar los puntos del equipo 1 y 2 sumando el resultado obtenido
    UPDATE EQUIPO_COMPETICION
    SET PUNTOS = PUNTOS + v_resultado1
    WHERE ID_EQUIPO IN (v_equipo1, v_equipo2);

    -- Si el equipo 1 ha ganado, se le suma una victoria
    IF v_resultado1 > v_resultado2 THEN
        UPDATE EQUIPO_COMPETICION
        SET VICTORIAS = VICTORIAS + 1
        WHERE ID_EQUIPO = v_equipo1;
    -- Si el equipo 2 ha ganado, se le suma una victoria
    ELSIF v_resultado1 < v_resultado2 THEN
        UPDATE EQUIPO_COMPETICION
        SET VICTORIAS = VICTORIAS + 1
        WHERE ID_EQUIPO = v_equipo2;
    END IF;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR('-20001','Error al encontrar informacion.');
END ACTUALIZAR_RESULTADOS;

--Trigger ACTUALIZAR_RESULTADOS compilado
