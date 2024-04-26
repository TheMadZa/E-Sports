SET SERVEROUTPUT ON;

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