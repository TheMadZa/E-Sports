SET SERVEROUTPUT ON;

-- Pruebas de los procedimientos almacenados que estan en scripts separados:

/*
Prueba del procedimiento almacenado "OBTENER_INFO_COMPETICION".

Muestra datos sobre la competicion y su juego, los enfrentamientos jugados,
y la cantidad de jugadores y de staff de cada equipo.

Se utilizara como consulta en la ventana del administrador para visualizar las
competiciones con sus respectivos datos.
*/
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
  OBTENER_INFO_COMPETICION(c_obtenerInfoCompeticion);
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

/*
Prueba del procedimiento almacenado "OBTENER_INFORMACION".

Muestra el nombre de cada equipo con la cantidad de jugadores y staff que tiene.

Se utilizara como consulta en la ventana de un usuario corriente para
visualizar los equipos con el numero total de jugadores y de staff.
*/
DECLARE
  c_obtenerInfo SYS_REFCURSOR;
  nom_equipo EQUIPO.nom_equipo%TYPE;
  cantidadStaff NUMBER;
  cantidadJugadores NUMBER;
BEGIN
  OBTENER_INFORMACION(c_obtenerInfo);
  LOOP
    FETCH c_obtenerInfo INTO
      nom_equipo, 
      cantidadStaff,
      cantidadJugadores;
    EXIT WHEN c_obtenerInfo%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Nombre del Equipo: ' || nom_equipo ||
    ', Cantidad de Staff: ' || cantidadStaff ||
    ', Cantidad de jugadores: ' || cantidadJugadores);
  END LOOP;
  CLOSE c_obtenerInfo;
END;

/*
Prueba del procedimiento almacenado "listarEquiposCompeticion".

Muestra la clasifiacion de cada competicion en orden de victorias y de puntos.
Se puede elegir la competicion que se quiere ver, cambiando el ID.

Se utilizara como consulta en la ventana de clasificacion.
*/

DECLARE
    v_id_competicion COMPETICION.ID_COMPETICION%TYPE := 1;
BEGIN
    listarEquiposCompeticion(v_id_competicion);
END;


-- Pruebas de los procedimientos almacenados que estan en el paquete "PAQUETE_DATOS":

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
  PAQUETE_DATOS.OBTENER_INFO_COMPETICION(c_obtenerInfoCompeticion);
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

DECLARE
  c_obtenerInfo SYS_REFCURSOR;
  nom_equipo EQUIPO.nom_equipo%TYPE;
  cantidadStaff NUMBER;
  cantidadJugadores NUMBER;
BEGIN
  PAQUETE_DATOS.OBTENER_INFORMACION(c_obtenerInfo);
  LOOP
    FETCH c_obtenerInfo INTO
      nom_equipo, 
      cantidadStaff,
      cantidadJugadores;
    EXIT WHEN c_obtenerInfo%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Nombre del Equipo: ' || nom_equipo ||
    ', Cantidad de Staff: ' || cantidadStaff ||
    ', Cantidad de jugadores: ' || cantidadJugadores);
  END LOOP;
  CLOSE c_obtenerInfo;
END;

DECLARE
    v_id_competicion COMPETICION.ID_COMPETICION%TYPE := 1;
BEGIN
    PAQUETE_DATOS.listarEquiposCompeticion(v_id_competicion);
END;
