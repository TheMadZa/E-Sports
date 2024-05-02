SET SERVEROUTPUT ON;
DECLARE
  c_obtenerInfoCompeticion SYS_REFCURSOR;
  nombreCom COMPETICION.NOMBRE_COM%TYPE;
  nombre JUEGO.nombre%TYPE;
  hora_enfrentamiento ENFRENTAMIENTO.hora_enfrentamiento%TYPE;
  equipo_1 EQUIPO.nom_equipo%TYPE;
  cantidad_jugadores_equipo_1 NUMBER;
  cantidad_staff_equipo_1 NUMBER;
  equipo_2 EQUIPO.nom_equipo%TYPE;
  cantidad_jugadores_equipo_2 NUMBER;
  cantidad_staff_equipo_2 NUMBER;
BEGIN
  OBTENER_INFORMACION_COMPETICION(c_obtenerInfoCompeticion);
  LOOP
    FETCH c_obtenerInfoCompeticion INTO
      nombreCom,
      nombre,
      hora_enfrentamiento,
      equipo_1,
      cantidad_jugadores_equipo_1,
      cantidad_staff_equipo_1,
      equipo_2,
      cantidad_jugadores_equipo_2,
      cantidad_staff_equipo_2;
    EXIT WHEN c_obtenerInfoCompeticion%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Nombre Competicion: ' || nombreCom || '
    Nombre del Juego: ' || nombre || '
    Fecha y hora: ' || TO_CHAR(hora_enfrentamiento,'DD-MM-YY HH24:MI') ||'
    Equipo 1: ' || equipo_1 ||'
    Cantidad de jugadores del Equipo 1: ' || cantidad_jugadores_equipo_1 ||'
    Cantidad de staff del Equipo 1: ' || cantidad_staff_equipo_1 ||'
    Equipo 2: ' || equipo_2 ||'
    Cantidad de jugadores del Equipo 2: ' || cantidad_jugadores_equipo_2 ||'
    Cantidad de staff del Equipo 2: ' || cantidad_staff_equipo_2 ||'
    ');
  END LOOP;
  CLOSE c_obtenerInfoCompeticion;
END;
