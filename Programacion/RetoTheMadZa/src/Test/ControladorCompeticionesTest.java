package Test;

import static org.junit.jupiter.api.Assertions.*;

import Controlador.ControladoresBD.ControladorCompeticiones;
import Modelo.Competicion;
import org.junit.jupiter.api.Test;
import java.sql.*;
import java.util.List;

public class ControladorCompeticionesTest {

    // Simulamos una conexión a la base de datos para las pruebas
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@SrvOracle:1521:ORCL", "eqdaw03", "eqdaw03");
    ControladorCompeticiones controlador = new ControladorCompeticiones(con);

    public ControladorCompeticionesTest() throws SQLException {
    }

    @Test
    void testInsertarCompeticion() {
        // Creamos una competición de prueba
        Competicion competicion = new Competicion();
        competicion.setIdCompeticion(1); // Supongamos que el ID es único
        competicion.setNombreCom("Competición de Prueba");
        competicion.setFechaInicio(Date.valueOf("2024-01-01"));
        competicion.setFechaFin(Date.valueOf("2024-02-01"));
        competicion.setEtapa("Etapa de Prueba");
        // Supongamos que hay un juego y un equipo existentes con IDs válidos
        competicion.getJuego().setIdJuego(1);
        competicion.getEquipoGanador().setIdEquipo(1);

        // Probamos la inserción
        assertDoesNotThrow(() -> controlador.insertarCompeticion(competicion));
    }

    @Test
    void testBorrarCompeticion() {
        // Suponemos que hay una competición con ID 1 para borrar
        int idCompeticion = 1;

        // Probamos el borrado
        assertDoesNotThrow(() -> controlador.borrarCompeticion(idCompeticion));
    }

    @Test
    void testBuscarCompeticion() {
        // Suponemos que hay una competición con ID 1 para buscar
        int idCompeticion = 1;

        // Probamos la búsqueda
        assertDoesNotThrow(() -> {
            Competicion competicionEncontrada = controlador.buscarCompeticion(idCompeticion);
            assertNotNull(competicionEncontrada);
        });
    }

    @Test
    void testBuscarEquiposPorNombreCom() {
        // Suponemos que hay una competición con nombre "Competición de Prueba" para buscar equipos
        String nombreCom = "Competición de Prueba";

        // Probamos la búsqueda de equipos por nombre de competición
        assertDoesNotThrow(() -> {
            String[][] equipos = controlador.buscarEquiposPorNombreCom(nombreCom);
            assertNotNull(equipos);
            // Verificamos que al menos haya una fila de datos
            assertTrue(equipos.length > 0);
        });
    }

    @Test
    void testBuscarTodasCompeticiones() {
        // Probamos la búsqueda de todas las competiciones
        assertDoesNotThrow(() -> {
            List<Competicion> competiciones = controlador.buscarTodasCompeticiones();
            assertNotNull(competiciones);
            assertFalse(competiciones.isEmpty());
        });
    }

    @Test
    void testModificarCompeticion() {
        // Creamos una competición de prueba con valores modificados
        Competicion competicion = new Competicion();
        competicion.setIdCompeticion(1); // Supongamos que el ID es único
        competicion.setNombreCom("Competición de Prueba Modificada");
        competicion.setFechaInicio(Date.valueOf("2024-01-02"));
        competicion.setFechaFin(Date.valueOf("2024-02-02"));
        competicion.setEtapa("Etapa de Prueba Modificada");
        // Supongamos que hay un juego y un equipo existentes con IDs válidos
        competicion.getJuego().setIdJuego(1);
        competicion.getEquipoGanador().setIdEquipo(1);

        // Probamos la modificación
        assertDoesNotThrow(() -> controlador.modificarCompeticion(competicion));
    }
}
