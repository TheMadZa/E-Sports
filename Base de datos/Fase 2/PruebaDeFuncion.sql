SET SERVEROUTPUT ON;

-- Prueba de las funciones que estan en un script:

DECLARE
    resultado NUMBER;
    e_error_consulta EXCEPTION;
BEGIN
    -- Probar la funcion con un equipo que tiene 6 jugadores.
    resultado := OBTENER_CANTIDAD_JUGADORES(1);
    IF resultado=0 THEN
        DBMS_OUTPUT.PUT_LINE('El equipo no tiene jugadores.' ||
            ' Puede que no exista el equipo especificado.');
    ELSIF resultado IS NULL THEN
        RAISE e_error_consulta;
    ELSE
        DBMS_OUTPUT.PUT_LINE('El equipo tiene ' || resultado || ' jugadores.');
    END IF;

    -- Probar la funcion con un equipo que no existe.
    resultado := OBTENER_CANTIDAD_JUGADORES(80);
    IF resultado=0 THEN
        DBMS_OUTPUT.PUT_LINE('El equipo no tiene jugadores.' ||
            ' Puede que no exista el equipo especificado.');
    ELSIF resultado IS NULL THEN
        RAISE e_error_consulta;
    ELSE
        DBMS_OUTPUT.PUT_LINE('El equipo tiene ' || resultado || ' jugadores.');
    END IF;
EXCEPTION
    WHEN e_error_consulta THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion. ');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Se produjo un error desconocido.');
END;


-- Prueba de las funciones que estan en el paquete "PAQUETE_DATOS":

DECLARE
    resultado NUMBER;
    e_error_consulta EXCEPTION;
BEGIN
    -- Probar la funcion con un equipo que tiene 6 jugadores.
    resultado := PAQUETE_DATOS.OBTENER_CANTIDAD_JUGADORES(1);
    IF resultado=0 THEN
        DBMS_OUTPUT.PUT_LINE('El equipo no tiene jugadores.' ||
            ' Puede que no exista el equipo especificado.');
    ELSIF resultado IS NULL THEN
        RAISE e_error_consulta;
    ELSE
        DBMS_OUTPUT.PUT_LINE('El equipo tiene ' || resultado || ' jugadores.');
    END IF;

    -- Probar la funcion con un equipo que no existe.
    resultado := PAQUETE_DATOS.OBTENER_CANTIDAD_JUGADORES(80);
    IF resultado=0 THEN
        DBMS_OUTPUT.PUT_LINE('El equipo no tiene jugadores.' ||
            ' Puede que no exista el equipo especificado.');
    ELSIF resultado IS NULL THEN
        RAISE e_error_consulta;
    ELSE
        DBMS_OUTPUT.PUT_LINE('El equipo tiene ' || resultado || ' jugadores.');
    END IF;
EXCEPTION
    WHEN e_error_consulta THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar informacion. ');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Se produjo un error desconocido.');
END;
