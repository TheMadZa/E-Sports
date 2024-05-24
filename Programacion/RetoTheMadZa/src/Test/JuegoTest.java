//package Test;
//
//import static org.junit.Assert.*;
//
//import Modelo.Juego;
//import org.junit.*;
//import java.sql.Date;
//
//public class JuegoTest {
//
//    @Test
//    public void testConstructorVacio() {
//        // Arrange
//        Juego juego = new Juego();
//
//        // Assert
//        assertNotNull(juego);
//        assertEquals(0, juego.getIdJuego());
//        assertNull(juego.getNombre());
//        assertNull(juego.getEmpresa());
//        assertNull(juego.getFechaLanzamiento());
//    }
//
//    @Test
//    public void testConstructorConParametros() {
//        // Arrange
//        int idJuego = 1;
//        String nombre = "Nombre del Juego";
//        String empresa = "Empresa de Juegos";
//        Date fechaLanzamiento = Date.valueOf("2024-05-24");
//
//        // Act
//        Juego juego = new Juego(idJuego, nombre, empresa, fechaLanzamiento);
//
//        // Assert
//        assertNotNull(juego);
//        assertEquals(idJuego, juego.getIdJuego());
//        assertEquals(nombre, juego.getNombre());
//        assertEquals(empresa, juego.getEmpresa());
//        assertEquals(fechaLanzamiento, juego.getFechaLanzamiento());
//    }
//
//    @Test
//    public void testEqualsMismoObjeto() {
//        // Arrange
//        Juego juego = new Juego(1, "Nombre", "Empresa", Date.valueOf("2024-05-24"));
//
//        // Assert
//        assertTrue(juego.equals(juego));
//    }
//
//    @Test
//    public void testEqualsObjetoNulo() {
//        // Arrange
//        Juego juego = new Juego(1, "Nombre", "Empresa", Date.valueOf("2024-05-24"));
//
//        // Assert
//        assertFalse(juego.equals(null));
//    }
//
//    @Test
//    public void testEqualsObjetoDiferenteClase() {
//        // Arrange
//        Juego juego = new Juego(1, "Nombre", "Empresa", Date.valueOf("2024-05-24"));
//        Object obj = new Object();
//
//        // Assert
//        assertFalse(juego.equals(obj));
//    }
//
//    @Test
//    public void testEqualsDiferentesAtributos() {
//        // Arrange
//        Juego juego1 = new Juego(1, "Nombre1", "Empresa1", Date.valueOf("2024-05-24"));
//        Juego juego2 = new Juego(1, "Nombre2", "Empresa2", Date.valueOf("2024-05-24"));
//
//        // Assert
//        assertFalse(juego1.equals(juego2));
//    }
//
//    @Test
//    public void testHashCode() {
//        // Arrange
//        Juego juego = new Juego(1, "Nombre", "Empresa", Date.valueOf("2024-05-24"));
//        int expectedHashCode = 1254156164;
//
//        // Act
//        int hashCode = juego.hashCode();
//
//        // Assert
//        assertEquals(expectedHashCode, hashCode);
//    }
//}
