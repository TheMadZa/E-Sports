package Controlador.ControladoresBD;

import Modelo.Patrocinador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Clase ControladorPatrocinadores que gestiona las consultas sobre los patrocinadores.
 *
 * <p>Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los patrocinadores
 * en la base de datos.</p>
 *
 * @author Julen, Ibai, Lorena
 * @version 1.0
 */
public class ControladorPatrocinadores {
    private Connection con;
    private Patrocinador p;

    /**
     * Constructor de la clase ControladorPatrocinadores.
     *
     * @param con Es la conexión con la base de datos que se ejecuta junto con el constructor.
     */
    public ControladorPatrocinadores(Connection con) {
        this.con = con;
    }

    /**
     * Función para insertar un patrocinador pasándole todos sus valores.
     *
     * @param p Es el objeto patrocinador que vamos a insertar en la base de datos
     * @throws Exception Si ocurre un error durante la inserción.
     * @throws SQLIntegrityConstraintViolationException Si ya existe un patrocinador con el mismo ID.
     */
    public void insertarPatrocinador(Patrocinador p) throws Exception {
        try {
            String plantilla = "INSERT INTO patrocinadores (nombre) VALUES (?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setString(1,p.getNombre());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1) {
                throw new Exception("No se ha podido insertar el patrocinador.");
            }

        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Ya hay un patrocinador con ese nombre.");
        }
    }

    /**
     * Función para borrar un patrocinador pasandole su id.
     *
     * @param idPatrocinador Es el id del patrocinador y sirve para identificar el patrocinador que queremos borrar
     * @throws Exception Si ocurre un error durante la eliminación.
     * @throws SQLIntegrityConstraintViolationException Si no existe un patrocinador con el ID especificado.
     */
    public void borrarPatrocinador(int idPatrocinador) throws Exception {
        try {
            String plantilla = "DELETE FROM patrocinadores WHERE id_patrocinador = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1, idPatrocinador);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha podido eliminar ningún patrocinador.");
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("No hay ningún patrocinador registrado con esos datos para borrar.");
        }
    }

    /**
     * Función para buscar datos sobre un patrocinador pasandole su id.
     *
     * @param idPatrocinador Es el id del patrocinador que sirve para identificar el patrocinador que queremos buscar.
     * @return Se devuelve el objeto patrocinador con todos sus valores.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Patrocinador buscarPatrocinador(int idPatrocinador) throws Exception
    {
        try
        {
            String plantilla = "SELECT * FROM patrocinadores WHERE id_patrocinador = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,idPatrocinador);

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next())
            {
                p = new Patrocinador();
                p.setIdPatrocinador(idPatrocinador);
                p.setNombre(rs.getString("nombre"));
            }
            else
            {
                throw new Exception("No hay ningún patrocinador con ese id");
            }
            sentenciaPre.close();
            return p;
        }
        catch (Exception e)
        {
            throw new Exception("Error");
        }
    }

    /**
     * Función para modificar uno o más datos sobre el patrocinador que identifiquemos con su id.
     *
     * @param p Es el objeto patrocinador del cual queremos actualizar uno o varios valores suyos buscandolo por id.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarPatrocinador(int idEquipo, int idPatrocinador) throws Exception {
        String plantilla = "UPDATE patrocinadores_equipo SET id_equipo = ? WHERE id_patrocinador = ?";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setInt(1, idEquipo);
        sentenciaPre.setInt(2, idPatrocinador);

        int n = sentenciaPre.executeUpdate();
        if (n != 1) {
            throw new Exception("No se ha podido actualizar ningún patrocinador.");
        }
    }

    // TODO : JAVADOC
    public Patrocinador buscarPatrocinadorPorNombre(String nombre) throws Exception{

        try {
            p = null;

            String plantilla = "SELECT id_patrocinador, nombre FROM patrocinadores WHERE UPPER(nombre) = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setString(1,nombre.toUpperCase());

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next()) {
                p = new Patrocinador();
                p.setIdPatrocinador(rs.getInt("id_patrocinador"));
                p.setNombre(rs.getString("nombre"));
            }

            sentenciaPre.close();
            return p;
        }
        catch (Exception e) {
            throw new Exception("Error al buscar patrocinador por nombre.");
        }

    }
}
