SET SERVEROUTPUT ON;

/*
Prueba del procedimiento almacenado "OBTENER_INFO_COMPETICION".

Muestra datos sobre la competici�n y su juego, los enfrentamientos jugados,
y la cantidad de jugadores y de staff de cada equipo.

Se utilizar� como consulta en la ventana del administrador para visualizar las
competiciones con sus datos.
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
Prueba del procedimiento almacenado "".

Muestra .

Se utilizar� en .
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



-- EL ADMIN CONSULTE LAS COMPETICIONES CON SUS DATOS Y EL OTRO PARA LOS USUARIOS, CONSULTAS CON MENOS DATOS



select * from user_procedures;