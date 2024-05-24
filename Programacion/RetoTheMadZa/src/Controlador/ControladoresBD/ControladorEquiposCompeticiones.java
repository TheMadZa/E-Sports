package Controlador.ControladoresBD;

import Modelo.EquipoCompeticion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ControladorEquiposCompeticiones que gestiona las consultas sobre la relación entre equipos y competiciones.
 *
 * <p>Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre la relación entre equipos y competiciones en la base de datos.</p>
 *
 * @author Julen, Lorena
 * @version 1.0
 */
public class ControladorEquiposCompeticiones {
    private Connection con;
    private EquipoCompeticion ec;

    /**
     * Constructor de la clase ControladorEquiposCompeticiones.
     *
     * @param con Es la conexión con la base de datos que se ejecuta junto con el constructor.
     */
    public ControladorEquiposCompeticiones(Connection con) {
        this.con = con;
    }

    /**
     * Función para buscar todas las victorias y puntos de todos los equipos que estén en una competición como mínimo.
     *
     * <p>Esta función obtiene las victorias y los puntos de todos los equipos que están participando en al menos
     * una competición. Devuelve una lista de objetos EquipoCompeticion con estos datos.</p>
     *
     * @return Devuelve una lista con todos los equipos que están en una competición
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception
    {
        List<EquipoCompeticion> equiposCompeticiones = new ArrayList<>();
        try
        {
            String plantilla = "SELECT victorias, puntos FROM equipos_competiciones";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            ResultSet rs = sentenciaPre.executeQuery();
            while (rs.next()) {
                ec = new EquipoCompeticion();

                ec.setVictorias(rs.getInt("victorias"));
                ec.setPuntos(rs.getInt("puntos"));
                equiposCompeticiones.add(ec);
            }
            sentenciaPre.close();
            return equiposCompeticiones;
        }
        catch (Exception e)
        {
            throw new Exception("Error al buscar equipos en competiciones");
        }
    }

    /**
     * Función para insertar un equipo en una competición pasándole el id del equipo y el de la competición.
     *
     * <p>Esta función inserta un equipo en una competición específica. Se requiere el ID del equipo y el ID
     * de la competición.</p>
     *
     * @param idEquipo Es el id del equipo que vamos a insertar en la competicion.
     * @param idCompeticion Es el id de la competición que va a recibir el equipo.
     * @throws Exception Si ocurre un error durante la inserción.
     * @throws SQLIntegrityConstraintViolationException
     */
    public void insertarEquipoCompeticion(int idEquipo, int idCompeticion) throws Exception {

        try {
//            String plantilla = "INSERT INTO equipos_competiciones VALUES (?,?,?,?)";
            String plantilla = "INSERT INTO equipos_competiciones (id_equipo, id_competicion) VALUES (?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

//             PONER VICTORIAS Y PUNTOS = 0
            sentenciaPre.setInt(1,idEquipo);
            sentenciaPre.setInt(2,idCompeticion);
//            sentenciaPre.setInt(3,0);
//            sentenciaPre.setInt(4,0);

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1) {
                throw new Exception("No se ha insertado ninguna fila en `equipos_competiciones´.");
            }

        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Ya hay registrada una fila en `equipos_competiciones´.");
        }

    }
}
