package Test;

import static org.junit.Assert.*;

import Controlador.ControladoresBD.ControladorUsuarios;
import Modelo.Usuario;
import org.junit.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControladorUsuariosTest {
    private Connection connection;
    private ControladorUsuarios controladorUsuarios;

    @Before
    public void setUp() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@SrvOracle:1521:ORCL", "eqdaw03", "eqdaw03");
        controladorUsuarios = new ControladorUsuarios(connection);
    }

    @After
    public void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testValidarUsuarioExistente() throws Exception {
        // Arrange
        String usuario = "usuario_existente";
        String contrasena = "contrasena";

        // Act
        boolean resultado = controladorUsuarios.validarUsuario(usuario, contrasena);

        // Assert
        assertTrue(resultado);
    }

    @Test(expected = Exception.class)
    public void testValidarUsuarioNoExistente() throws Exception {
        // Arrange
        String usuario = "usuario_no_existente";
        String contrasena = "contrasena";

        // Act
        controladorUsuarios.validarUsuario(usuario, contrasena);
    }

    @Test
    public void testInsertarUsuarioExitoso() throws Exception {
        // Arrange
        Usuario usuario = new Usuario("nuevo_usuario", "contrasena", "tipo");

        // Act
        boolean resultado = controladorUsuarios.insertarUsuario(usuario);

        // Assert
        assertTrue(resultado);
    }

    @Test(expected = Exception.class)
    public void testInsertarUsuarioExistente() throws Exception {
        // Arrange
        Usuario usuario = new Usuario("usuario_existente", "contrasena", "tipo");

        // Act
        controladorUsuarios.insertarUsuario(usuario);
    }

    @Test
    public void testBorrarUsuarioExistente() throws Exception {
        // Arrange
        String nomUsuario = "usuario_existente";

        // Act
        controladorUsuarios.borrarUsuario(nomUsuario);

        // Assert: No exceptions thrown
    }

    @Test(expected = Exception.class)
    public void testBorrarUsuarioNoExistente() throws Exception {
        // Arrange
        String nomUsuario = "usuario_no_existente";

        // Act
        controladorUsuarios.borrarUsuario(nomUsuario);
    }

    @Test
    public void testBuscarUsuarioExistente() throws Exception {
        // Arrange
        String nomUsuario = "usuario_existente";

        // Act
        Usuario usuario = controladorUsuarios.buscarUsuario(nomUsuario);

        // Assert
        assertNotNull(usuario);
    }

    @Test(expected = Exception.class)
    public void testBuscarUsuarioNoExistente() throws Exception {
        // Arrange
        String nomUsuario = "usuario_no_existente";

        // Act
        controladorUsuarios.buscarUsuario(nomUsuario);
    }

    @Test
    public void testModificarUsuarioExistente() throws Exception {
        // Arrange
        Usuario usuario = new Usuario("usuario_existente", "nueva_contrasena", "nuevo_tipo");

        // Act
        controladorUsuarios.modificarUsuario(usuario);

        // Assert: No exceptions thrown
    }

    @Test(expected = Exception.class)
    public void testModificarUsuarioNoExistente() throws Exception {
        // Arrange
        Usuario usuario = new Usuario("usuario_no_existente", "nueva_contrasena", "nuevo_tipo");

        // Act
        controladorUsuarios.modificarUsuario(usuario);
    }
}
