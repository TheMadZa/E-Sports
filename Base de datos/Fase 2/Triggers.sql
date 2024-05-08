/*Scripts de borrado y creación de los TRIGGERS*/
DROP TRIGGER CANTIDAD_EQUIPO;
DROP TRIGGER GENERAR_CALENDARIO;
DROP TRIGGER NOMODIFICAR_EQUIPO;
DROP TRIGGER NOMODIFICAR_JUGADOR;
DROP TRIGGER MAXSALARIO_EQUIPO;

/*Controlar que no haya más de 6 ni menos de 2 jugadores en un equipo.*/
CREATE OR REPLACE TRIGGER CANTIDAD_EQUIPO
BEFORE INSERT OR UPDATE OR DELETE ON JUGADOR
FOR EACH ROW
DECLARE
    v_cantidad NUMBER;
    v_cantidad_new NUMBER;
    v_cantidad_old NUMBER;
BEGIN
    IF INSERTING THEN
        SELECT COUNT(*) INTO v_cantidad
        FROM JUGADOR
        WHERE id_equipo = :new.id_equipo;
        
        IF v_cantidad >= 6 THEN
          RAISE_APPLICATION_ERROR('-20001','No puede haber mas de 6 jugadores');
        END IF;
        
    ELSIF DELETING THEN
        SELECT COUNT(*) INTO v_cantidad
        FROM JUGADOR
        WHERE id_equipo = :old.id_equipo;
        
        IF v_cantidad <= 2 THEN
            RAISE_APPLICATION_ERROR('-20002',
                'No puede haber menos de 2 jugadores');
        END IF;
        
    ELSIF UPDATING THEN
        SELECT COUNT(*) INTO v_cantidad_new
        FROM JUGADOR
        WHERE id_equipo = :new.id_equipo;
        
        SELECT COUNT(*) INTO v_cantidad_old
        FROM JUGADOR
        WHERE id_equipo = :old.id_equipo;
        
        IF v_cantidad_new >= 6 THEN
          RAISE_APPLICATION_ERROR('-20003','No puede haber mas de 6 jugadores');
          
        ELSIF v_cantidad <= 2 THEN
            RAISE_APPLICATION_ERROR('-20002',
                'No puede haber menos de 2 jugadores');
        END IF;
        
    END IF;
END CANTIDAD_EQUIPO;

--Trigger CANTIDAD_EQUIPO compilado

/*PROBAMOS EL TRIGGER*/
--Insertamos un jugador en un equipo con 0 jugadores (FUNCIONA)

/*
DELETE FROM EQUIPO WHERE ID_EQUIPO = 35;

INSERT INTO EQUIPO VALUES(DEFAULT,'PruebaTrigger',
    TO_DATE('01/01/85','DD/MM/YY'),'A','Rojo');

COMMIT;

SELECT * FROM EQUIPO WHERE NOM_EQUIPO = 'PruebaTrigger';
*/
SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
LEFT JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
WHERE E.ID_EQUIPO = 35
GROUP BY E.ID_EQUIPO
ORDER BY E.ID_EQUIPO;

INSERT INTO JUGADOR VALUES(DEFAULT,'Juan','JuanGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,35);

COMMIT;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
LEFT JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
WHERE E.ID_EQUIPO = 35
GROUP BY E.ID_EQUIPO
ORDER BY E.ID_EQUIPO;

/*Resultado:

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
        35                  0

1 fila insertadas.

Confirmación terminada.

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
        35                  1
         
*/
--Insertamos un jugador en un equipo con 6 jugadores (FUNCIONA)
/*LLENAMOS EL EQUIPO CREADO ANTERIORMENTE PARA LA PRUEBA

INSERT INTO JUGADOR VALUES(DEFAULT,'Luis','LuisGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,35);
    COMMIT;
INSERT INTO JUGADOR VALUES(DEFAULT,'David','DavidGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,35);
    COMMIT;
INSERT INTO JUGADOR VALUES(DEFAULT,'Zahir','ZaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,35);
    COMMIT;
INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','YaleroGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,35);
    COMMIT;
INSERT INTO JUGADOR VALUES(DEFAULT,'Lorena','LorenaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,35);
    COMMIT;

*/
SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 35
ORDER BY ID_EQUIPO;

INSERT INTO JUGADOR VALUES(DEFAULT,'DIOS','DIOSGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,35);

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 33
ORDER BY ID_EQUIPO;

/*Resultado:

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
        35                  6

Error que empieza en la línea: 132 del comando -
INSERT INTO JUGADOR VALUES(DEFAULT,'DIOS','DIOSGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,35)
Error en la línea de comandos : 132 Columna : 13
Informe de error -
Error SQL: ORA-20001: No puede haber mas de 6 jugadores
ORA-06512: en "EQDAW03.CANTIDAD_EQUIPO", línea 12
ORA-04088: error durante la ejecución del disparador 'EQDAW03.CANTIDAD_EQUIPO'

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
        35                  6
        
*/

--Borramos un jugador de un equipo con 2 jugadores (NO FUNCIONA)
/*
SELECT ID_JUGADOR
FROM JUGADOR
WHERE ID_EQUIPO = 35;
commit;
DELETE FROM
JUGADOR WHERE ID_JUGADOR = 215;
DELETE FROM
JUGADOR WHERE ID_JUGADOR = 199;
DELETE FROM
JUGADOR WHERE ID_JUGADOR = 200;
DELETE FROM
JUGADOR WHERE ID_JUGADOR = 201;

SELECT ID_EQUIPO
FROM EQUIPO
WHERE NOM_EQUIPO = 'PruebaTrigger';

INSERT INTO JUGADOR VALUES(DEFAULT,'Juan','JuanGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,31);
    
INSERT INTO JUGADOR VALUES(DEFAULT,'Mati','ELMati','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),3500,31);

INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','Yalero','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),3500,31);
    
SELECT *
FROM JUGADOR
WHERE ID_EQUIPO = 33;

COMMIT;
*/
SELECT ID_JUGADOR
FROM JUGADOR
WHERE ID_EQUIPO = 35;

DELETE
FROM JUGADOR
WHERE id_jugador = 197;

COMMIT;

/*Resultado:

*/

--Actualizamos el id_equipo de un jugador de un equipo con 2 jugadores (NO FUNCIONA)

/*
INSERT INTO EQUIPO VALUES(DEFAULT,'PruebaTrigger2',
    TO_DATE('01/01/85','DD/MM/YY'),'A','Rojo');

COMMIT;

SELECT * FROM EQUIPO WHERE NOM_EQUIPO = 'PruebaTrigger2';

INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','Yalero','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),3500,36);
INSERT INTO JUGADOR VALUES(DEFAULT,'Mati','ELMati','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),3500,36);
COMMIT;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
ORDER BY ID_EQUIPO;

*/
UPDATE JUGADOR
SET id_equipo = 36
WHERE id_jugador = 215;

/*Controlar que para poder generar el calendario de una competición
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
    
        SELECT COUNT(*) INTO v_cantidad_min
        FROM JUGADOR
        WHERE id_equipo = v_equipo_id;
        
        IF v_cantidad_min < 2 THEN
            RAISE_APPLICATION_ERROR('-20001','Hay menos de 2 jugadores');
        END IF;
    END LOOP;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se han encontrado equipos');

END GENERAR_CALENDARIO;

/*PROBAMOS EL TRIGGER*/
--Insertamos una jornada y que todos los equipos tengan mínimo 2 jugadores (FUNCIONA)
INSERT INTO JORNADA VALUES(DEFAULT,'17',TO_DATE('30/08/24','DD/MM/YY'),2);

COMMIT;

SELECT * FROM JORNADA WHERE ID_JORNADA = 34;
/*Resultado:

1 fila insertadas.

Confirmación terminada.

ID_JORNADA NUM_JORNADA FECHA_JO ID_COMPETICION
---------- ----------- -------- --------------
        34          17 30/08/24              2

*/
--Insertamos una jornada y que algún equipo no tenga menos de 2 jugadores (FUNCIONA)
/*
Creamos un equipo vacío para la comprobación

INSERT INTO EQUIPO VALUES(DEFAULT,'PruebaTrigger3',
    TO_DATE('01/01/85','DD/MM/YY'),'A','Rojo');
    COMMIT;
*/
INSERT INTO JORNADA VALUES(DEFAULT,'18',TO_DATE('07/09/24','DD/MM/YY'),2);

/*Resultado:

Error que empieza en la línea: 294 del comando -
INSERT INTO JORNADA VALUES(DEFAULT,'18',TO_DATE('07/09/24','DD/MM/YY'),2)
Error en la línea de comandos : 294 Columna : 13
Informe de error -
Error SQL: ORA-20001: Hay menos de 2 jugadores
ORA-06512: en "EQDAW03.GENERAR_CALENDARIO", línea 16
ORA-04088: error durante la ejecución del disparador 'EQDAW03.GENERAR_CALENDARIO'

*/

/*Controlar que una vez generado el calendario de la competición, no se
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
        RAISE_APPLICATION_ERROR('-20001','La etapa está cerrada');
END NOMODIFICAR_EQUIPO;

/*PROBAMOS EL TRIGGER*/
--Insertamos un equipo en una competicion ABIERTA (FUNCIONA)
/*
SELECT * FROM COMPETICION WHERE ETAPA = 'A';
SELECT * FROM EQUIPO_COMPETICION;

Creamos un equipo con 6 jugadores
INSERT INTO EQUIPO VALUES(DEFAULT,'PruebaTrigger4',
    TO_DATE('01/01/85','DD/MM/YY'),'A','Rojo');
COMMIT;

SELECT ID_EQUIPO FROM EQUIPO WHERE NOM_EQUIPO = 'PruebaTrigger4';

INSERT INTO JUGADOR VALUES(DEFAULT,'Luis','LuisGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,38);
INSERT INTO JUGADOR VALUES(DEFAULT,'David','DavidGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,38);
INSERT INTO JUGADOR VALUES(DEFAULT,'Zahir','ZaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,38);
INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','YaleroGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,38);
INSERT INTO JUGADOR VALUES(DEFAULT,'Lorena','LorenaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,38);
INSERT INTO JUGADOR VALUES(DEFAULT,'Mati','ELMati','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),3500,38);
    
SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 38
ORDER BY ID_EQUIPO;
*/
SELECT * FROM COMPETICION WHERE ETAPA = 'A';

INSERT INTO EQUIPO_COMPETICION VALUES(38,1,0,0);

COMMIT;

SELECT * FROM EQUIPO_COMPETICION WHERE ID_EQUIPO = 38;

/*Resultado:
ID_COMPETICION NOMBRE_COM                                                                                           FECHA_IN FECHA_FI ET   ID_JUEGO ID_EQUIPO_GANADOR
-------------- ---------------------------------------------------------------------------------------------------- -------- -------- -- ---------- -----------------
             1 CS2 MAJOR COPENHAGEN 2024                                                                            05/05/24 05/06/24 A           3                  

1 fila insertadas.

Confirmación terminada.

 ID_EQUIPO ID_COMPETICION  VICTORIAS     PUNTOS
---------- -------------- ---------- ----------
        38              1          0          0

*/
--Insertamos un equipo en una competicion CERRADA (FUNCIONA)
/*
SELECT * FROM COMPETICION WHERE ETAPA = 'C';
SELECT * FROM EQUIPO_COMPETICION;

Creamos un equipo con 6 jugadores
INSERT INTO EQUIPO VALUES(DEFAULT,'PruebaTrigger5',
    TO_DATE('01/01/85','DD/MM/YY'),'A','Rojo');
COMMIT;

SELECT ID_EQUIPO FROM EQUIPO WHERE NOM_EQUIPO = 'PruebaTrigger5';

INSERT INTO JUGADOR VALUES(DEFAULT,'Luis','LuisGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,39);
INSERT INTO JUGADOR VALUES(DEFAULT,'David','DavidGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,39);
INSERT INTO JUGADOR VALUES(DEFAULT,'Zahir','ZaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,39);
INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','YaleroGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,39);
INSERT INTO JUGADOR VALUES(DEFAULT,'Lorena','LorenaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,39);
INSERT INTO JUGADOR VALUES(DEFAULT,'Mati','ELMati','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),3500,39);

COMMIT;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 39
ORDER BY ID_EQUIPO;
*/
INSERT INTO EQUIPO_COMPETICION VALUES(39,2,0,0);

COMMIT;

SELECT * FROM EQUIPO_COMPETICION WHERE ID_EQUIPO = 39;
/*Resultado:

ID_COMPETICION NOMBRE_COM                                                                                           FECHA_IN FECHA_FI ET   ID_JUEGO ID_EQUIPO_GANADOR
-------------- ---------------------------------------------------------------------------------------------------- -------- -------- -- ---------- -----------------
             2 LEC                                                                                                  01/01/24 01/06/24 C          12                  

Error que empieza en la línea: 442 del comando -
INSERT INTO EQUIPO_COMPETICION VALUES(39,2,0,0)
Error en la línea de comandos : 442 Columna : 13
Informe de error -
Error SQL: ORA-20001: La etapa está cerrada
ORA-06512: en "EQDAW03.NOMODIFICAR_EQUIPO", línea 27
ORA-04088: error durante la ejecución del disparador 'EQDAW03.NOMODIFICAR_EQUIPO'

no se ha seleccionado ninguna fila

*/
--Borramos un equipo de una competicion ABIERTA (FUNCIONA)
SELECT * FROM EQUIPO_COMPETICION;

DELETE
FROM EQUIPO_COMPETICION
WHERE id_equipo = 38;

COMMIT;

SELECT * FROM EQUIPO_COMPETICION WHERE ID_EQUIPO = 38;
/*Resultado:

1 fila eliminado

Confirmación terminada.

no se ha seleccionado ninguna fila
*/

--Borramos un equipo de una competicion CERRADA (FUNCIONA)
SELECT * FROM EQUIPO_COMPETICION WHERE ID_COMPETICION = 2;

DELETE
FROM EQUIPO_COMPETICION
WHERE id_equipo = 17
AND id_competicion = 2;

SELECT * FROM EQUIPO_COMPETICION
WHERE ID_EQUIPO = 17 AND id_competicion = 2;

/*Resultado:

Error que empieza en la línea: 485 del comando -
DELETE
FROM EQUIPO_COMPETICION
WHERE id_equipo = 17
AND id_competicion = 2
Error en la línea de comandos : 486 Columna : 6
Informe de error -
Error SQL: ORA-20001: La etapa está cerrada
ORA-06512: en "EQDAW03.NOMODIFICAR_EQUIPO", línea 27
ORA-04088: error durante la ejecución del disparador 'EQDAW03.NOMODIFICAR_EQUIPO'

 ID_EQUIPO ID_COMPETICION  VICTORIAS     PUNTOS
---------- -------------- ---------- ----------
        17              2          3         22

*/
--Actualizamos un equipo de una competicion ABIERTA (FUNCIONA)
SELECT * FROM EQUIPO_COMPETICION
WHERE ID_COMPETICION = 1
AND ID_EQUIPO = 20;

UPDATE EQUIPO_COMPETICION
SET victorias = 0
WHERE id_equipo = 20
AND id_competicion = 1;

COMMIT;

SELECT * FROM EQUIPO_COMPETICION
WHERE ID_COMPETICION = 1
AND ID_EQUIPO = 20;

/*Resultado:

 ID_EQUIPO ID_COMPETICION  VICTORIAS     PUNTOS
---------- -------------- ---------- ----------
        20              1          6         21

1 fila actualizadas.

Confirmación terminada.

 ID_EQUIPO ID_COMPETICION  VICTORIAS     PUNTOS
---------- -------------- ---------- ----------
        20              1          0         21
*/

--Actualizamos un equipo de una competicion CERRADA (FUNCIONA)
SELECT * FROM EQUIPO_COMPETICION
WHERE ID_COMPETICION = 2
AND ID_EQUIPO = 20;

UPDATE EQUIPO_COMPETICION
SET victorias = 0
WHERE id_equipo = 20
AND id_competicion = 2;

COMMIT;

SELECT * FROM EQUIPO_COMPETICION
WHERE ID_COMPETICION = 2
AND ID_EQUIPO = 20;

/*Resultado:

 ID_EQUIPO ID_COMPETICION  VICTORIAS     PUNTOS
---------- -------------- ---------- ----------
        20              2          1          6

Error que empieza en la línea: 547 del comando -
UPDATE EQUIPO_COMPETICION
SET victorias = 0
WHERE id_equipo = 20
AND id_competicion = 2
Error en la línea de comandos : 547 Columna : 8
Informe de error -
Error SQL: ORA-20001: La etapa está cerrada
ORA-06512: en "EQDAW03.NOMODIFICAR_EQUIPO", línea 43
ORA-04088: error durante la ejecución del disparador 'EQDAW03.NOMODIFICAR_EQUIPO'

Confirmación terminada.

 ID_EQUIPO ID_COMPETICION  VICTORIAS     PUNTOS
---------- -------------- ---------- ----------
        20              2          1          6
*/

/*Controlar que una vez generado el calendario de la competición, no se
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
            RAISE_APPLICATION_ERROR('-20001', 'Al menos una competición asociada
                al equipo está cerrada. No se pueden modificar los jugadores.');
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
            RAISE_APPLICATION_ERROR('-20002', 'Al menos una competición asociada
                al equipo está cerrada. No se pueden modificar los jugadores.');
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
            RAISE_APPLICATION_ERROR('-20003', 'Al menos una competición asociada
                al equipo está cerrada. No se pueden modificar los jugadores.');
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
            RAISE_APPLICATION_ERROR('-20004', 'Al menos una competición asociada
                al equipo está cerrada. No se pueden modificar los jugadores.');
        END IF;
        
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR('-20005','No se han encontrado datos');
END NOMODIFICAR_JUGADOR;


/*PROBAMOS EL TRIGGER*/
--Insertamos un jugador en un equipo que esté en una competicion ABIERTA (FUNCIONA)
SELECT * FROM EQUIPO_COMPETICION
WHERE ID_COMPETICION = 1
AND ID_EQUIPO = 20;

INSERT INTO JUGADOR VALUES(DEFAULT,'Mati','ELMati','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),3500,20);

COMMIT;

SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 20;

/*Resultado:

 ID_EQUIPO ID_COMPETICION  VICTORIAS     PUNTOS
---------- -------------- ---------- ----------
        20              1          6         21

1 fila insertadas.

Confirmación terminada.

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
       231 Mati                           ELMati                         Colombia                       Jugador    01/04/98       3500         20
       115 esteven                        SirSkullCandy07                Estados Unidos                 Lider      31/05/89    5671,68         20
       116 cyleigh                        iskos                          Australia                      Jugador    25/03/97    5737,45         20
       117 ayat                           Vengeos                        Francia                        Jugador    21/12/00     3882,6         20
       118 quintell                       3X0N                           Alemania                       Jugador    10/09/03    4408,87         20
       119 charlesetta                    ISuckedHitlerDry               Reino Unido                    Jugador    23/06/92    5454,75         20
       120 tyliyah                        Kripps                         Italia                         Jugador    19/06/94    6329,41         20

7 filas seleccionadas.
*/
--Insertamos un jugador en un equipo que esté en una competicion CERRADA (FUNCIONA)
SELECT * FROM EQUIPO_COMPETICION
WHERE ID_COMPETICION = 2
AND ID_EQUIPO = 20;

INSERT INTO JUGADOR VALUES(DEFAULT,'Mati','ELMati','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),3500,20);

SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 20;

/*Resultado:

 ID_EQUIPO ID_COMPETICION  VICTORIAS     PUNTOS
---------- -------------- ---------- ----------
        20              2          1          6

Error que empieza en la línea: 677 del comando -
INSERT INTO JUGADOR VALUES(DEFAULT,'Mati','ELMati','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),3500,20)
Error en la línea de comandos : 677 Columna : 13
Informe de error -
Error SQL: ORA-20001: Al menos una competición asociada al equipo está cerrada. No se pueden modificar los jugadores.
ORA-06512: en "EQDAW03.NOMODIFICAR_JUGADOR", línea 17
ORA-04088: error durante la ejecución del disparador 'EQDAW03.NOMODIFICAR_JUGADOR'

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
       115 esteven                        SirSkullCandy07                Estados Unidos                 Lider      31/05/89    5671,68         20
       116 cyleigh                        iskos                          Australia                      Jugador    25/03/97    5737,45         20
       117 ayat                           Vengeos                        Francia                        Jugador    21/12/00     3882,6         20
       118 quintell                       3X0N                           Alemania                       Jugador    10/09/03    4408,87         20
       119 charlesetta                    ISuckedHitlerDry               Reino Unido                    Jugador    23/06/92    5454,75         20
       120 tyliyah                        Kripps                         Italia                         Jugador    19/06/94    6329,41         20

6 filas seleccionadas. 
*/

--Borramos un jugador de un equipo que esté en una competicion ABIERTA (FUNCIONA)
SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 7;

DELETE
FROM JUGADOR
WHERE ID_JUGADOR = 42
AND ID_EQUIPO = 7;

COMMIT;

SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 7;

/*Resultado:

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
        37 orianna                        MustafaGaming_YT               Australia                      Lider      21/11/96    5873,69          7
        38 lakeasha                       Katymaty                       Rusia                          Jugador    05/08/99    5892,62          7
        39 amanuel                        itsDarkii                      Francia                        Jugador    10/02/99    5261,08          7
        40 yamin                          Dante19                        Italia                         Jugador    11/01/99    5877,92          7
        41 lamar                          OrlNi                          Corea del Sur                  Jugador    05/03/97    4659,73          7
        42 briya                          Hiiri132                       Brasil                         Jugador    11/08/91    6078,62          7

6 filas seleccionadas.

1 fila eliminado

Confirmación terminada.

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
        37 orianna                        MustafaGaming_YT               Australia                      Lider      21/11/96    5873,69          7
        38 lakeasha                       Katymaty                       Rusia                          Jugador    05/08/99    5892,62          7
        39 amanuel                        itsDarkii                      Francia                        Jugador    10/02/99    5261,08          7
        40 yamin                          Dante19                        Italia                         Jugador    11/01/99    5877,92          7
        41 lamar                          OrlNi                          Corea del Sur                  Jugador    05/03/97    4659,73          7

*/

--Borramos un jugador de un equipo que esté en una competicion CERRADA (FUNCIONA)
SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 6;

DELETE
FROM JUGADOR
WHERE ID_JUGADOR = 31
AND ID_EQUIPO = 6;

SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 6;

/*Resultado:

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
        31 matalin                        I_AteTheDonut125               China                          Lider      06/03/03    6358,45          6
        32 jalayna                        Xoky                           India                          Jugador    18/09/91    5556,55          6
        33 gaila                          Ober_Zombie23                  Rusia                          Jugador    20/10/04    4627,08          6
        34 srah                           Dagio20016                     India                          Jugador    04/07/00    5227,52          6
        35 creedence                      SortaCurious                   Rusia                          Jugador    08/01/05    3705,63          6
        36 anyea                          blazej2610                     Argentina                      Jugador    11/11/05     2067,5          6

6 filas seleccionadas. 

Error que empieza en la línea: 755 del comando -
DELETE
FROM JUGADOR
WHERE ID_JUGADOR = 31
AND ID_EQUIPO = 6
Error en la línea de comandos : 756 Columna : 6
Informe de error -
Error SQL: ORA-20002: Al menos una competición asociada
                al equipo está cerrada. No se pueden modificar los jugadores.
ORA-06512: en "EQDAW03.NOMODIFICAR_JUGADOR", línea 37
ORA-04088: error durante la ejecución del disparador 'EQDAW03.NOMODIFICAR_JUGADOR'

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
        31 matalin                        I_AteTheDonut125               China                          Lider      06/03/03    6358,45          6
        32 jalayna                        Xoky                           India                          Jugador    18/09/91    5556,55          6
        33 gaila                          Ober_Zombie23                  Rusia                          Jugador    20/10/04    4627,08          6
        34 srah                           Dagio20016                     India                          Jugador    04/07/00    5227,52          6
        35 creedence                      SortaCurious                   Rusia                          Jugador    08/01/05    3705,63          6
        36 anyea                          blazej2610                     Argentina                      Jugador    11/11/05     2067,5          6

6 filas seleccionadas. 
*/

--Actualizamos un jugador de un equipo que esté en una competicion ABIERTA (FUNCIONA)
SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 7;

UPDATE JUGADOR
SET NOMBRE = 'markel'
WHERE id_jugador = 37;

COMMIT;

SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 7;

/*Resultado:

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
        37 orianna                        MustafaGaming_YT               Australia                      Lider      21/11/96    5873,69          7
        38 lakeasha                       Katymaty                       Rusia                          Jugador    05/08/99    5892,62          7
        39 amanuel                        itsDarkii                      Francia                        Jugador    10/02/99    5261,08          7
        40 yamin                          Dante19                        Italia                         Jugador    11/01/99    5877,92          7
        41 lamar                          OrlNi                          Corea del Sur                  Jugador    05/03/97    4659,73          7

1 fila actualizadas.

Confirmación terminada.

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
        37 markel                         MustafaGaming_YT               Australia                      Lider      21/11/96    5873,69          7
        38 lakeasha                       Katymaty                       Rusia                          Jugador    05/08/99    5892,62          7
        39 amanuel                        itsDarkii                      Francia                        Jugador    10/02/99    5261,08          7
        40 yamin                          Dante19                        Italia                         Jugador    11/01/99    5877,92          7
        41 lamar                          OrlNi                          Corea del Sur                  Jugador    05/03/97    4659,73          7
*/

--Actualizamos un jugador de un equipo que esté en una competicion CERRADA (FUNCIONA)
SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 6;

UPDATE JUGADOR
SET NOMBRE = 'markel'
WHERE id_jugador = 31;

SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 6;

/*Resultado:

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
        31 matalin                        I_AteTheDonut125               China                          Lider      06/03/03    6358,45          6
        32 jalayna                        Xoky                           India                          Jugador    18/09/91    5556,55          6
        33 gaila                          Ober_Zombie23                  Rusia                          Jugador    20/10/04    4627,08          6
        34 srah                           Dagio20016                     India                          Jugador    04/07/00    5227,52          6
        35 creedence                      SortaCurious                   Rusia                          Jugador    08/01/05    3705,63          6
        36 anyea                          blazej2610                     Argentina                      Jugador    11/11/05     2067,5          6

6 filas seleccionadas. 

Error que empieza en la línea: 840 del comando -
UPDATE JUGADOR
SET NOMBRE = 'markel'
WHERE id_jugador = 31
Error en la línea de comandos : 840 Columna : 8
Informe de error -
Error SQL: ORA-20003: Al menos una competición asociada
                al equipo está cerrada. No se pueden modificar los jugadores.
ORA-06512: en "EQDAW03.NOMODIFICAR_JUGADOR", línea 54
ORA-04088: error durante la ejecución del disparador 'EQDAW03.NOMODIFICAR_JUGADOR'

ID_JUGADOR NOMBRE                         NICKNAME                       NACIONALIDAD                   ROL        FECHA_NA     SUELDO  ID_EQUIPO
---------- ------------------------------ ------------------------------ ------------------------------ ---------- -------- ---------- ----------
        31 matalin                        I_AteTheDonut125               China                          Lider      06/03/03    6358,45          6
        32 jalayna                        Xoky                           India                          Jugador    18/09/91    5556,55          6
        33 gaila                          Ober_Zombie23                  Rusia                          Jugador    20/10/04    4627,08          6
        34 srah                           Dagio20016                     India                          Jugador    04/07/00    5227,52          6
        35 creedence                      SortaCurious                   Rusia                          Jugador    08/01/05    3705,63          6
        36 anyea                          blazej2610                     Argentina                      Jugador    11/11/05     2067,5          6

6 filas seleccionadas.
*/

/*Controlar que el salario total de los jugadores del equipo no podrá ser
superior a 200.000€ anuales*/
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
        RAISE_APPLICATION_ERROR('-20001','El salario del equipo es más
            de 200000');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        NULL;
END MAXSALARIO_EQUIPO;
/

/*PROBAMOS EL TRIGGER*/
--Insertamos un jugador con un sueldo suficiente para que no salte error (FUNCIONA)
/*Creamos un equipo con jugadores que tengan menos de 200k anuales

INSERT INTO EQUIPO VALUES(DEFAULT,'PruebaTrigger6',
    TO_DATE('01/01/85','DD/MM/YY'),'A','Rojo');

SELECT ID_EQUIPO
FROM EQUIPO
WHERE NOM_EQUIPO = 'PruebaTrigger6';

COMMIT;

INSERT INTO JUGADOR VALUES(DEFAULT,'Luis','LuisGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),2000,40);
INSERT INTO JUGADOR VALUES(DEFAULT,'David','DavidGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),2000,40);
INSERT INTO JUGADOR VALUES(DEFAULT,'Zahir','ZaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),2000,40);

COMMIT;

SELECT * FROM JUGADOR
WHERE ID_EQUIPO = 40;

DELETE FROM JUGADOR
WHERE ID_JUGADOR = 255;

COMMIT;

*/
SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 40;

INSERT INTO JUGADOR VALUES(DEFAULT,'Lorena','LorenaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),2000,40);

COMMIT;

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 40;

/*Resultado:

SUM(SUELDO*12)
--------------
         72000

1 fila insertadas.

Confirmación terminada.

SUM(SUELDO*12)
--------------
         96000
*/

--Insertamos un jugador con un sueldo para que salte error (FUNCIONA)
SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 40;
--rollback commit
INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','Yalero','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),50000,40);

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 40;

/*Resultado:

SUM(SUELDO*12)
--------------
         96000

Error que empieza en la línea: 1.034 del comando -
INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','Yalero','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),50000,40)
Error en la línea de comandos : 1.034 Columna : 13
Informe de error -
Error SQL: ORA-20001: El salario del equipo es más
                de 200000
ORA-06512: en "EQDAW03.MAXSALARIO_EQUIPO", línea 11
ORA-04088: error durante la ejecución del disparador 'EQDAW03.MAXSALARIO_EQUIPO'

SUM(SUELDO*12)
--------------
         96000

*/

--Actualizamos el sueldo de un jugador para que no salte error (NO FUNCIONA)
SELECT ID_JUGADOR, SUELDO
FROM JUGADOR
WHERE id_equipo = 40;

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 40;

UPDATE JUGADOR
SET sueldo = 3000
WHERE id_jugador = 233;

commit;

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 40;

SELECT ID_JUGADOR, SUELDO
FROM JUGADOR
WHERE id_equipo = 40;

/*Resultado:



*/

--Actualizamos el sueldo de un jugador para que salte error (NO FUNCIONA)
UPDATE JUGADOR
SET sueldo = 1
WHERE id_jugador = 1;

/*Resultado:



*/
