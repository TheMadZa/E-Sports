/*PROBAMOS LOS TRIGGER PARA CONTROLAR LA CANTIDAD DE JUGADORES DE UN EQUIPO*/
--Insertamos un jugador en un equipo con 0 jugadores (FUNCIONA)
INSERT INTO EQUIPO VALUES(DEFAULT,'PruebaTrigger',
    TO_DATE('01/01/85','DD/MM/YY'),'A','Rojo');

COMMIT;

SELECT ID_EQUIPO FROM EQUIPO WHERE NOM_EQUIPO = 'PruebaTrigger';

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
LEFT JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
WHERE E.ID_EQUIPO = 1
GROUP BY E.ID_EQUIPO
ORDER BY E.ID_EQUIPO;

INSERT INTO JUGADOR VALUES(DEFAULT,'Juan','JuanGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1);

COMMIT;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
LEFT JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
WHERE E.ID_EQUIPO = 1
GROUP BY E.ID_EQUIPO
ORDER BY E.ID_EQUIPO;

/*Resultado:

1 fila insertadas.

Confirmación terminada.

 ID_EQUIPO
----------
         1

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
         1                  0

1 fila insertadas.

Confirmación terminada.

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
         1                  1
*/

--Insertamos un jugador en un equipo con 6 jugadores (FUNCIONA)
/*LLENAMOS EL EQUIPO CREADO ANTERIORMENTE PARA LA PRUEBA*/
INSERT INTO JUGADOR VALUES(DEFAULT,'Luis','LuisGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1);
INSERT INTO JUGADOR VALUES(DEFAULT,'David','DavidGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1);
INSERT INTO JUGADOR VALUES(DEFAULT,'Zahir','ZaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1);
INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','YaleroGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1);
INSERT INTO JUGADOR VALUES(DEFAULT,'Lorena','LorenaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1);

COMMIT;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 1
ORDER BY ID_EQUIPO;

INSERT INTO JUGADOR VALUES(DEFAULT,'DIOS','DIOSGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1);

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 1
ORDER BY ID_EQUIPO;

/*Resultado:

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
         1                  6

Error que empieza en la línea: 291 del comando -
INSERT INTO JUGADOR VALUES(DEFAULT,'DIOS','DIOSGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1)
Error en la línea de comandos : 291 Columna : 13
Informe de error -
Error SQL: ORA-20001: No puede haber mas de 6 jugadores
ORA-06512: en "DAW06.CANTIDAD_EQUIPO_INSERT", línea 9
ORA-04088: error durante la ejecución del disparador 'DAW06.CANTIDAD_EQUIPO_INSERT'

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
         1                  6

*/
--Borramos un jugador de un equipo con 2 jugadores (FUNCIONA)
SELECT ID_JUGADOR
FROM JUGADOR
WHERE ID_EQUIPO = 1;

DELETE FROM
JUGADOR WHERE ID_JUGADOR = 1;
DELETE FROM
JUGADOR WHERE ID_JUGADOR = 2;
DELETE FROM
JUGADOR WHERE ID_JUGADOR = 3;
DELETE FROM
JUGADOR WHERE ID_JUGADOR = 4;

COMMIT;

SELECT ID_JUGADOR
FROM JUGADOR
WHERE ID_EQUIPO = 1;

DELETE FROM JUGADOR
WHERE ID_JUGADOR = 5;

/*Resultado:

ID_JUGADOR
----------
         1
         2
         3
         4
         5
         6

1 fila eliminado

1 fila eliminado

1 fila eliminado

1 fila eliminado

Confirmación terminada.

ID_JUGADOR
----------
         5
         6

Error que empieza en la línea: 341 del comando -
DELETE FROM JUGADOR
WHERE ID_JUGADOR = 5
Error en la línea de comandos : 341 Columna : 13
Informe de error -
Error SQL: ORA-20002: No puede haber menos de 2 jugadores.
ORA-06512: en "DAW06.CANTIDAD_EQUIPO_DELETE", línea 17
ORA-04088: error durante la ejecución del disparador 'DAW06.CANTIDAD_EQUIPO_DELETE'

*/

/*Actualizamos el id_equipo de un jugador de un equipo con 2 jugadores a un
equipo con 6 jugadores*/

--FUNCIONA

INSERT INTO EQUIPO VALUES(DEFAULT,'PruebaTrigger2',
    TO_DATE('01/01/85','DD/MM/YY'),'A','Rojo');

INSERT INTO JUGADOR VALUES(DEFAULT,'Luis','LuisGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,2);
INSERT INTO JUGADOR VALUES(DEFAULT,'David','DavidGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,2);
INSERT INTO JUGADOR VALUES(DEFAULT,'Zahir','ZaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,2);
INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','YaleroGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,2);
INSERT INTO JUGADOR VALUES(DEFAULT,'Lorena','LorenaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,2);
INSERT INTO JUGADOR VALUES(DEFAULT,'DIOS','DIOSGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,2);
    
COMMIT;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 2
ORDER BY ID_EQUIPO;

SELECT ID_JUGADOR, ID_EQUIPO
FROM JUGADOR
ORDER BY ID_EQUIPO;

UPDATE JUGADOR
SET id_equipo = 2
WHERE id_jugador = 5;

COMMIT;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 2
ORDER BY ID_EQUIPO;

SELECT ID_JUGADOR FROM JUGADOR WHERE ID_EQUIPO = 2;

/*Resultados

1 fila insertadas.

1 fila insertadas.

1 fila insertadas.

1 fila insertadas.

1 fila insertadas.

1 fila insertadas.

1 fila insertadas.

Confirmación terminada.

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
         2                  6

ID_JUGADOR  ID_EQUIPO
---------- ----------
         5          1
         6          1
        10          2
        13          2
        12          2
         9          2
         8          2
        11          2

Error que empieza en la línea: 411 del comando -
UPDATE JUGADOR
SET id_equipo = 2
WHERE id_jugador = 5
Error en la línea de comandos : 411 Columna : 8
Informe de error -
Error SQL: ORA-20003: No puede haber mas de 6 jugadores.
ORA-06512: en "DAW06.CANTIDAD_EQUIPO_UPDATE", línea 21
ORA-04088: error durante la ejecución del disparador 'DAW06.CANTIDAD_EQUIPO_UPDATE'
*/

/*Actualizamos el id_equipo de un jugador de un equipo con 2 jugadores a un
equipo con 5 jugadores (FUNCIONA)*/

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 1
ORDER BY ID_EQUIPO;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 2
ORDER BY ID_EQUIPO;

SELECT ID_JUGADOR, ID_EQUIPO
FROM JUGADOR
ORDER BY ID_EQUIPO;

UPDATE JUGADOR
SET ID_EQUIPO = 2
WHERE ID_JUGADOR = 14;

/*Resultado:

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
         1                  2

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
         2                  5

ID_JUGADOR  ID_EQUIPO
---------- ----------
         5          1
        14          1
        11          2
        12          2
         6          2
         9          2
         8          2

Error que empieza en la línea: 495 del comando -
UPDATE JUGADOR
SET ID_EQUIPO = 2
WHERE ID_JUGADOR = 14
Error en la línea de comandos : 495 Columna : 8
Informe de error -
Error SQL: ORA-20002: No puede haber menos de 2 jugadores.
ORA-06512: en "DAW06.CANTIDAD_EQUIPO_UPDATE", línea 27
ORA-04088: error durante la ejecución del disparador 'DAW06.CANTIDAD_EQUIPO_UPDATE'
*/

/*Actualizamos el id_equipo de un jugador de un equipo con 4 jugadores a un
equipo con 5 jugadores (FUNCIONA)*/

INSERT INTO JUGADOR VALUES(DEFAULT,'Luis','LuisGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1);
INSERT INTO JUGADOR VALUES(DEFAULT,'David','DavidGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),3500,1);

DELETE FROM JUGADOR
WHERE ID_JUGADOR = 10;

COMMIT;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 1
ORDER BY ID_EQUIPO;

SELECT E.ID_EQUIPO, NVL(COUNT(J.ID_JUGADOR),0) AS "CANTIDAD JUGADORES"
FROM EQUIPO E
JOIN JUGADOR J ON E.ID_EQUIPO = J.ID_EQUIPO
GROUP BY E.ID_EQUIPO
HAVING E.ID_EQUIPO = 2
ORDER BY ID_EQUIPO;

SELECT ID_JUGADOR, ID_EQUIPO
FROM JUGADOR
ORDER BY ID_EQUIPO;

UPDATE JUGADOR
SET id_equipo = 2
WHERE id_jugador = 6;

COMMIT;

/*Resultado:

1 fila insertadas.

1 fila insertadas.

1 fila eliminado

Confirmación terminada.

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
         1                  4

 ID_EQUIPO CANTIDAD JUGADORES
---------- ------------------
         2                  5

ID_JUGADOR  ID_EQUIPO
---------- ----------
         6          1
        14          1
        15          1
         5          1
        13          2
        12          2
        11          2
         9          2
         8          2

1 fila actualizadas.

Confirmación terminada.

ID_JUGADOR  ID_EQUIPO
---------- ----------
        14          1
        15          1
         5          1
        12          2
        13          2
        11          2
         9          2
         8          2
         6          2
*/


/*PROBAMOS EL TRIGGER GENERAR_CALENDARIO*/
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


/*PROBAMOS EL TRIGGER NOMODIFICAR_EQUIPO*/
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


/*PROBAMOS EL TRIGGER NOMODIFICAR_JUGADOR*/
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


/*PROBAMOS LOS TRIGGERS PARA CONTROLAR EL SALARIO ANUAL DE CADA EQUIPO*/
--Insertamos un jugador con un sueldo suficiente para que no salte error (FUNCIONA)
/*Creamos un equipo con jugadores que tengan menos de 200k anuales*/

INSERT INTO EQUIPO VALUES(DEFAULT,'PruebaTrigger6',
    TO_DATE('01/01/85','DD/MM/YY'),'A','Rojo');

SELECT ID_EQUIPO
FROM EQUIPO
WHERE NOM_EQUIPO = 'PruebaTrigger6';

COMMIT;

INSERT INTO JUGADOR VALUES(DEFAULT,'Luis','LuisGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),2000,3);
INSERT INTO JUGADOR VALUES(DEFAULT,'David','DavidGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),2000,3);
INSERT INTO JUGADOR VALUES(DEFAULT,'Zahir','ZaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),2000,3);

COMMIT;

SELECT ID_JUGADOR
FROM JUGADOR
WHERE ID_EQUIPO = 3;

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 3;

INSERT INTO JUGADOR VALUES(DEFAULT,'Lorena','LorenaGOD','Colombia','Jugador',
    TO_DATE('02/03/98','DD/MM/YY'),2000,3);

COMMIT;

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 3;

/*Resultado:

1 fila insertadas.

 ID_EQUIPO
----------
         3

Confirmación terminada.

1 fila insertadas.

1 fila insertadas.

1 fila insertadas.

Confirmación terminada.

ID_JUGADOR
----------
        16
        17
        18

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
WHERE id_equipo = 3;

INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','Yalero','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),50000,3);

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 3;

/*Resultado:

SUM(SUELDO*12)
--------------
         96000

Error que empieza en la línea: 1.279 del comando -
INSERT INTO JUGADOR VALUES(DEFAULT,'Ibai','Yalero','Colombia','Jugador',
    TO_DATE('01/04/98','DD/MM/YY'),50000,3)
Error en la línea de comandos : 1.279 Columna : 13
Informe de error -
Error SQL: ORA-20001: El salario del equipo es más
            de 200000
ORA-06512: en "DAW06.MAXSALARIO_EQUIPO_INSERT", línea 9
ORA-04088: error durante la ejecución del disparador 'DAW06.MAXSALARIO_EQUIPO_INSERT'

SUM(SUELDO*12)
--------------
         96000

*/

--Actualizamos el sueldo de un jugador para que no salte error (NO FUNCIONA)
SELECT ID_JUGADOR, SUELDO
FROM JUGADOR
WHERE id_equipo = 3;

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 3;

UPDATE JUGADOR
SET sueldo = 3000
WHERE id_jugador = 19;

commit;

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 3;

SELECT ID_JUGADOR, SUELDO
FROM JUGADOR
WHERE id_equipo = 3;

/*Resultado:

ID_JUGADOR     SUELDO
---------- ----------
        16       2000
        17       2000
        18       2000
        19       2000

SUM(SUELDO*12)
--------------
         96000

1 fila actualizadas.

Confirmación terminada.

SUM(SUELDO*12)
--------------
        108000

ID_JUGADOR     SUELDO
---------- ----------
        16       2000
        17       2000
        18       2000
        19       3000

*/

--Actualizamos el sueldo de un jugador para que salte error (FUNCIONA)
SELECT ID_JUGADOR, SUELDO
FROM JUGADOR
WHERE id_equipo = 3;

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 3;

UPDATE JUGADOR
SET sueldo = 60000
WHERE id_jugador = 16;

SELECT ID_JUGADOR, SUELDO
FROM JUGADOR
WHERE id_equipo = 3;

SELECT SUM(SUELDO * 12)
FROM JUGADOR
WHERE id_equipo = 3;

/*Resultado:

ID_JUGADOR     SUELDO
---------- ----------
        16       2000
        17       2000
        18       2000
        19       3000

SUM(SUELDO*12)
--------------
        108000

Error que empieza en la línea: 1.370 del comando -
UPDATE JUGADOR
SET sueldo = 60000
WHERE id_jugador = 16
Error en la línea de comandos : 1.370 Columna : 8
Informe de error -
Error SQL: ORA-20001: El salario del equipo es más 
                    de 200000
ORA-06512: en "DAW06.MAXSALARIO_EQUIPO_UPDATE", línea 16
ORA-04088: error durante la ejecución del disparador 'DAW06.MAXSALARIO_EQUIPO_UPDATE'

ID_JUGADOR     SUELDO
---------- ----------
        16       2000
        17       2000
        18       2000
        19       3000


SUM(SUELDO*12)
--------------
        108000

*/

/*PRUEBA PARA EL TRIGGER ACTUALIZAR_RESULTADOS*/
SELECT *
FROM EQUIPO_COMPETICION
Where ID_COMPETICION = 1
ORDER BY VICTORIAS DESC, PUNTOS DESC;

/*Resultado:

 ID_EQUIPO ID_COMPETICION  VICTORIAS     PUNTOS
---------- -------------- ---------- ----------
        17              1          9         45
         3              1          8         18
        20              1          6         21
        10              1          5         29
        16              1          5         26
         7              1          4         53
        13              1          4         23
         4              1          4         19
         1              1          4         15
         2              1          2         16

10 filas seleccionadas. 

*/
