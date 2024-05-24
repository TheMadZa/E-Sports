package Controlador.ControladoresBD;

import Modelo.Jornada;
import Modelo.Juego;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ControladorJuegos que gestiona las consultas sobre los juegos.
 *
 * <p>Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los juegos
 * en la base de datos.</p>
 *
 * @author Julen, Lorena
 * @version 1.0
 */
public class ControladorJuegos {
    private Connection con;
    private Juego j;

    /**
     * Constructor de la clase ControladorJuegos.
     *
     * @param con Es la conexión con la base de datos que se ejecuta junto con el constructor.
     */
    public ControladorJuegos(Connection con) {
        this.con = con;
    }

    /**
     * Función para insertar un juego pasándole todos sus valores.
     *
     * @param j Es el objeto jornada que vamos a insertar en la base de datos
     * @throws Exception Si ocurre un error durante la inserción.
     * @throws SQLIntegrityConstraintViolationException Si ya existe un juego con el mismo nombre.
     */
    public void insertarJuego(Juego j) throws Exception {
        try {
            String plantilla = "INSERT INTO JUEGOS (nombre, empresa, fecha_lanzamiento) VALUES (?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setString(1,j.getNombre());
            sentenciaPre.setString(2,j.getEmpresa());
            sentenciaPre.setDate(3,j.getFechaLanzamiento());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1) {
                throw new Exception("No se ha podido insertar el juego.");
            }

        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Ya hay registrado un juego con esos datos.");
        }
    }

    /**
     * Función para borrar un juego pasandole su id.
     *
     * @param idJuego Es el id del juego y sirve para identificar el juego que queremos borrar
     * @throws Exception Si ocurre un error durante la eliminación.
     * @throws SQLIntegrityConstraintViolationException Si no existe un juego con el ID especificado.
     */
    public void borrarJuego(int idJuego) throws Exception {
        PreparedStatement sentenciaPre = null;
        try {
            String plantilla = "DELETE FROM juegos WHERE id_juego = ?";
            sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, idJuego);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha eliminado ningún juego.");
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("No se puede eliminar el juego debido a restricciones de integridad.", e);
        }
        catch (Exception e) {
            throw new Exception("Error al borrar el juego.", e);
        }
        finally {
            if (sentenciaPre != null) {
                try {
                    sentenciaPre.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Función para buscar datos sobre un juego pasandole su id.
     *
     * @param idJuego Es el id del juego que sirve para identificar el juego que queremos buscar.
     * @return Se devuelve el objeto juego con todos sus valores.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Juego buscarJuego(int idJuego) throws Exception {
        try {
            String plantilla = "SELECT * FROM juegos WHERE id_juego = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,idJuego);

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next()) {
                j = new Juego();
                j.setIdJuego(idJuego);
                j.setNombre(rs.getString("nombre"));
                j.setEmpresa(rs.getString("empresa"));
                j.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
            }
            else {
                throw new Exception("No hay ningún juego registrado con ese ID.");
            }
            sentenciaPre.close();
            return j;
        }
        catch (Exception e) {
            throw new Exception("Error al buscar juego.");
        }
    }

    /**
     * Función para modificar uno o más datos sobre el juego que identifiquemos con su nombre.
     *
     * @param j Es el objeto juego del cual queremos actualizar uno o varios valores suyos buscandolo por nombre.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarJuego(Juego j) throws Exception {
        String plantilla = "UPDATE juegos SET empresa = ?, fecha_lanzamiento = ? WHERE nombre = ?";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setString(1, j.getEmpresa());
        sentenciaPre.setDate(2, j.getFechaLanzamiento());
        sentenciaPre.setString(3, j.getNombre());

        int n = sentenciaPre.executeUpdate();

        sentenciaPre.close();

        if (n != 1){
            throw new Exception("No se ha actualizado ningún juego.");
        }
    }

    /**
     * Función para buscar el id, empresa y fecha de lanzamiento sobre un juego pasándole su nombre.
     *
     * @param nombre Es el nombre del juego que sirve para identificar al juego que queremos buscar
     * @return Se devuelve el objeto juego con los valores que le hemos dicho.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Juego buscarJuegoPorNombre(String nombre) throws Exception {

        try {
            String plantilla = "SELECT id_juego, empresa, fecha_lanzamiento FROM juegos WHERE UPPER(nombre) = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombre.toUpperCase());
            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next()) {
                j = new Juego();
                j.setIdJuego(rs.getInt("id_juego"));
                j.setEmpresa(rs.getString("empresa"));
                j.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
            }
            else {
                throw new Exception("No hay ningún juego registrado con ese nombre.");
            }
            sentenciaPre.close();
            return j;
        }
        catch (Exception e) {
            throw new Exception("Error al buscar juego por nombre.");
        }

    }
}
