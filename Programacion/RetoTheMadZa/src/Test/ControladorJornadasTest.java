//package Test;
//
//import static org.junit.Assert.*;
//
//import Controlador.ControladoresBD.ControladorJornadas;
//import Modelo.Jornada;
//import org.junit.*;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ControladorJornadasTest {
//
//    private Connection connection;
//
//    @Before
//    public void setUp() throws Exception {
//        // Configurar la conexión a una base de datos de prueba
//        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@SrvOracle:1521:ORCL", "eqdaw03", "eqdaw03");
//        // Cargar datos de prueba en la base de datos si es necesario
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        // Cerrar la conexión después de cada prueba
//        if (connection != null) {
//            connection.close();
//        }
//    }
//
//    @Test
//    public void testInsertarJornada() throws Exception {
//        // Crear instancia del controlador con la conexión de prueba
//        ControladorJornadas controladorJornadas = new ControladorJornadas(connection);
//        // Crear una nueva jornada para insertar
//        Jornada jornada = new Jornada();
//        // Establecer valores de la jornada
//        // ...
//
//        // Probar el método insertarJornada
//        controladorJornadas.insertarJornada(jornada);
//
//        // Verificar que la jornada se haya insertado correctamente en la base de datos
//        // Realizar una consulta a la base de datos para comprobar que la jornada está presente
//        // ...
//    }
//
//    @Test
//    public void testBorrarJornada() throws Exception {
//        // Crear instancia del controlador con la conexión de prueba
//        ControladorJornadas controladorJornadas = new ControladorJornadas(connection);
//        // Crear una nueva jornada para borrar
//        // Establecer valores de la jornada
//        int idJornada = 1; // Establecer el ID de la jornada a borrar
//
//        // Probar el método borrarJornada
//        controladorJornadas.borrarJornada(idJornada);
//
//        // Verificar que la jornada se haya borrado correctamente de la base de datos
//        // Realizar una consulta a la base de datos para comprobar que la jornada ya no está presente
//        // ...
//    }
//
//    @Test
//    public void testBuscarJornada() throws Exception {
//        // Crear instancia del controlador con la conexión de prueba
//        ControladorJornadas controladorJornadas = new ControladorJornadas(connection);
//        // ID de la jornada a buscar
//        int idJornada = 1; // Establecer el ID de la jornada a buscar
//
//        // Probar el método buscarJornada
//        Jornada jornada = controladorJornadas.buscarJornada(idJornada);
//
//        // Verificar que se haya encontrado la jornada correctamente
//        assertNotNull(jornada);
//        // Realizar más verificaciones sobre los atributos de la jornada recuperada si es necesario
//    }
//
//    // Métodos similares para cada función de la clase ControladorJornadas
//
//}
