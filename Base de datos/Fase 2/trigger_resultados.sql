CREATE OR REPLACE TRIGGER actualizar_resultados
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

    -- Si el equipo 1 ganó, se le suma una victoria
    IF v_resultado1 > v_resultado2 THEN
        UPDATE EQUIPO_COMPETICION
        SET VICTORIAS = VICTORIAS + 1
        WHERE ID_EQUIPO = v_equipo1;
    -- Si el equipo 2 ganó, se le suma una victoria
    ELSIF v_resultado1 < v_resultado2 THEN
        UPDATE EQUIPO_COMPETICION
        SET VICTORIAS = VICTORIAS + 1
        WHERE ID_EQUIPO = v_equipo2;
    END IF;
END;