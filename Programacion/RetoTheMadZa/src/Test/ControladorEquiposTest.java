package Test;

import static org.junit.jupiter.api.Assertions.*;

import Controlador.ControladoresBD.ControladorEquipos;
import Modelo.Equipo;
import org.junit.jupiter.api.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorEquiposTest {

    // Simulamos una conexión a la base de datos para las pruebas
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@SrvOracle:1521:ORCL", "eqdaw03", "eqdaw03");
    ControladorEquipos controlador = new ControladorEquipos(con);

    ControladorEquiposTest() throws SQLException {
    }

    @Test
    void testInsertarEquipo() {
        // Creamos un equipo de prueba
        Equipo equipo = new Equipo();
        equipo.setNomEquipo("Equipo de Prueba");
        equipo.setFechaFundacion(Date.valueOf("2020-01-01"));
        equipo.setLogo("logo_url");
        equipo.setColor("rojo");

        // Probamos la inserción
        assertDoesNotThrow(() -> controlador.insertarEquipo(equipo));
    }

    @Test
    void testBorrarEquipo() {
        // Suponemos que hay un equipo con ID 1 para borrar
        int idEquipo = 1;

        // Probamos el borrado
        assertDoesNotThrow(() -> controlador.borrarEquipo(idEquipo));
    }

    @Test
    void testBuscarEquipo() {
        // Suponemos que hay un equipo con ID 1 para buscar
        int idEquipo = 1;

        // Probamos la búsqueda
        assertDoesNotThrow(() -> {
            Equipo equipoEncontrado = controlador.buscarEquipo(idEquipo);
            assertNotNull(equipoEncontrado);
        });
    }

    @Test
    void testModificarEquipo() {
        // Creamos un equipo de prueba
        Equipo equipo = new Equipo();
        equipo.setNomEquipo("Equipo de Prueba");
        equipo.setFechaFundacion(Date.valueOf("2020-01-01"));
        equipo.setLogo("logo_url");
        equipo.setColor("rojo");

        // Probamos la modificación
        assertDoesNotThrow(() -> controlador.modificarEquipo(equipo));
    }

    @Test
    void testBuscarEquipoPorNombre() {
        // Suponemos que hay un equipo con nombre "Equipo de Prueba" para buscar
        String nombreEquipo = "Equipo de Prueba";

        // Probamos la búsqueda por nombre
        assertDoesNotThrow(() -> {
            Equipo equipoEncontrado = controlador.buscarEquipoPorNombre(nombreEquipo);
            assertNotNull(equipoEncontrado);
        });
    }

    @Test
    void testCargarEquiposDesdeBD() {
        // Probamos la carga de equipos desde la base de datos
        assertDoesNotThrow(() -> {
            List<Equipo> equipos = controlador.cargarEquiposDesdeBD();
            assertNotNull(equipos);
            assertFalse(equipos.isEmpty());
        });
    }
}

