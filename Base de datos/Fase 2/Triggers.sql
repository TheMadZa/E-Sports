/*Scripts de borrado y creaciOn de los TRIGGERS*/
DROP TRIGGER CANTIDAD_EQUIPO;
DROP TRIGGER GENERAR_CALENDARIO;
DROP TRIGGER NOMODIFICAR_EQUIPO;
DROP TRIGGER NOMODIFICAR_JUGADOR;
DROP TRIGGER MAXSALARIO_EQUIPO;
DROP TRIGGER ACTUALIZAR_RESULTADOS;


/*Controlar que no haya más de 6 ni menos de 2 jugadores en un equipo.*/
CREATE OR REPLACE TRIGGER CANTIDAD_EQUIPO
BEFORE INSERT OR UPDATE OR /*DELETE*/ ON JUGADOR
FOR EACH ROW
DECLARE
    v_cantidad NUMBER;
    v_cantidad_new NUMBER;
    v_cantidad_old NUMBER;
BEGIN
    IF INSERTING THEN

        v_cantidad := OBTENER_CANTIDAD_JUGADORES(:NEW.id_equipo);
        
        IF v_cantidad >= 6 THEN
          RAISE_APPLICATION_ERROR('-20001','No puede haber mas de 6 jugadores.');
        END IF;
    /*
    ELSIF DELETING THEN
        SELECT COUNT(*) INTO v_cantidad
        FROM JUGADOR
        WHERE id_equipo = :old.id_equipo;
        
        IF v_cantidad <= 2 THEN
            RAISE_APPLICATION_ERROR('-20002',
                'No puede haber menos de 2 jugadores.');
        END IF;
    */
        
    ELSIF UPDATING THEN
        v_cantidad_new := OBTENER_CANTIDAD_JUGADORES(:NEW.id_equipo);
        
        v_cantidad_old := OBTENER_CANTIDAD_JUGADORES(:OLD.id_equipo);
        
        IF v_cantidad_new >= 6 THEN
          RAISE_APPLICATION_ERROR('-20003','No puede haber mas de 6 jugadores.');
          
        ELSIF v_cantidad <= 2 THEN
            RAISE_APPLICATION_ERROR('-20002',
                'No puede haber menos de 2 jugadores.');
        END IF;
        
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
END CANTIDAD_EQUIPO;

-- Lo siguiente es el mismo trigger pero mejorado (hay que revisarlo/corregirlo).
/*
DROP TRIGGER controlar_jugadores_equipo;

CREATE OR REPLACE TRIGGER controlar_jugadores_equipo
BEFORE INSERT OR UPDATE OF ID_EQUIPO OR DELETE ON JUGADOR
FOR EACH ROW
DECLARE
    total_jugadores_new NUMBER;
    total_jugadores_old NUMBER;
BEGIN
    IF DELETING THEN
        -- Al eliminar un jugador, contar el número total de jugadores en el equipo del que se está eliminando
        SELECT COUNT(*)
        INTO total_jugadores_old
        FROM JUGADOR
        WHERE ID_EQUIPO = :OLD.ID_EQUIPO;

        -- Verificar si el equipo del que se está eliminando el jugador se queda sin jugadores después de la eliminación
        IF total_jugadores_old - 1 < 2 THEN
            -- Si el equipo se queda con menos de 2 jugadores, mostrar un mensaje de error
            RAISE_APPLICATION_ERROR(-20001, 'No se puede eliminar este jugador. El equipo debe tener al menos 2 jugadores.');
        END IF;
    ELSIF UPDATING THEN
        -- Al actualizar un jugador, contar el número total de jugadores en el equipo al que se va a agregar el jugador
        SELECT COUNT(*)
        INTO total_jugadores_new
        FROM JUGADOR
        WHERE ID_EQUIPO = :NEW.ID_EQUIPO;

        -- Verificar si el número de jugadores en el equipo al que se va a agregar el jugador es menor que 2 o mayor que 6
        IF total_jugadores_new > 6 THEN
            -- Si el equipo al que se va a agregar el jugador no tiene el número adecuado de jugadores, mostrar un mensaje de error
            RAISE_APPLICATION_ERROR(-20002, 'El equipo al que se va a agregar el jugador debe tener entre 2 y 6 jugadores.');
        END IF;

        -- Contar el número total de jugadores en el equipo del que se está quitando el jugador
        SELECT COUNT(*)
        INTO total_jugadores_old
        FROM JUGADOR
        WHERE ID_EQUIPO = :OLD.ID_EQUIPO;

        -- Verificar si el equipo del que se está quitando el jugador se quedaría con menos de 2 jugadores después de la actualización
        IF total_jugadores_old - 1 < 2 THEN
            -- Si el equipo se queda con menos de 2 jugadores, mostrar un mensaje de error
            RAISE_APPLICATION_ERROR(-20003, 'No se puede cambiar este jugador de equipo. El equipo actual debe tener al menos 2 jugadores.');
        END IF;
    ELSE -- Será insert.
        -- Al insertar un nuevo jugador, contar el número total de jugadores en el equipo al que se va a agregar el jugador
        SELECT COUNT(*)
        INTO total_jugadores_new
        FROM JUGADOR
        WHERE ID_EQUIPO = :NEW.ID_EQUIPO;

        -- Verificar si el número de jugadores en el equipo al que se va a agregar el jugador es menor que 2 o mayor que 6
        IF total_jugadores_new > 6 THEN
            -- Si el equipo al que se va a agregar el jugador no tiene el número adecuado de jugadores, mostrar un mensaje de error
            RAISE_APPLICATION_ERROR(-20004, 'El equipo al que se va a agregar el jugador debe tener entre 2 y 6 jugadores.');
        END IF;
    END IF;
END controlar_jugadores_equipo;
*/


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
        DBMS_OUTPUT.PUT_LINE('No se han encontrado equipos.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
END GENERAR_CALENDARIO;


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
        RAISE_APPLICATION_ERROR('-20001','La etapa esta cerrada.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
END NOMODIFICAR_EQUIPO;


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
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
END NOMODIFICAR_JUGADOR;


/*Controlar que el salario total de los jugadores del equipo no podra ser
superior a 200.000€ anuales.*/
CREATE OR REPLACE TRIGGER MAXSALARIO_EQUIPO
AFTER INSERT OR UPDATE ON JUGADOR
FOR EACH ROW
DECLARE
    v_salarioanual_total NUMBER;
BEGIN
    SELECT NVL(SUM(SUELDO * 12),0) INTO v_salarioanual_total
    FROM JUGADOR
    WHERE id_equipo = :new.id_equipo;
    
    v_salarioanual_total := v_salarioanual_total + :new.sueldo;
    
    IF v_salarioanual_total + :new.sueldo * 12 > 200000 THEN
        RAISE_APPLICATION_ERROR('-20001','El salario del equipo es mas
            de 200000.');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        NULL;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
END MAXSALARIO_EQUIPO;


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
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion.');
END;
