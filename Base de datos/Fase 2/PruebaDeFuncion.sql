DECLARE
    resultado VARCHAR2(200);
BEGIN
    -- Probar la función con un equipo que tiene un líder
    resultado := FUNCION_LIDER(2);
    DBMS_OUTPUT.PUT_LINE(resultado);

    -- Probar la función con un equipo que no tiene líder
    --resultado := FUNCION_LIDER();
    --DBMS_OUTPUT.PUT_LINE(resultado);

    -- Probar la función con un equipo que no existe
    resultado := FUNCION_LIDER(31);
    DBMS_OUTPUT.PUT_LINE(resultado);
END;
