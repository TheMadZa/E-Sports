package Controlador.ControladoresBD;

import Modelo.Equipo;
import Modelo.Juego;
import Modelo.Jugador;

import javax.swing.*;
import java.rmi.ConnectIOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ControladorJugadores que gestiona las consultas sobre los jugadores.
 *
 * <p>Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los jugadores
 * en la base de datos.</p>
 *
 * @author Julen, Lorena
 * @version 1.0
 */
public class ControladorJugadores {
    private Connection con;
    private Jugador j;

    /**
     * Constructor de la clase ControladorJugadores.
     *
     * @param con Es la conexión con la base de datos que se ejecuta junto con el constructor.
     */
    public ControladorJugadores(Connection con) {
        this.con = con;
    }

    /**
     * Función para insertar un jugador pasándole todos sus valores.
     *
     * @param j Es el objeto jugador que vamos a insertar en la base de datos
     * @throws Exception Si ocurre un error durante la inserción.
     * @throws SQLIntegrityConstraintViolationException Si ya existe un jugador con el mismo ID.
     */
    public void insertarJugador(Jugador j) throws Exception {
        try {
            String plantilla = "INSERT INTO jugadores (nombre, nickname, nacionalidad, rol, fecha_nac, sueldo, " +
                                "id_equipo) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setString(1,j.getNombre());
            sentenciaPre.setString(2,j.getNickname());
            sentenciaPre.setString(3,j.getNacionalidad());
            sentenciaPre.setString(4,j.getRol());
            sentenciaPre.setDate(5,j.getFechaNac());
            sentenciaPre.setDouble(6,j.getSueldo());
            sentenciaPre.setInt(7,j.getEquipo().getIdEquipo());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1) {
                throw new Exception("No se ha podido insertar el jugador.");
            }

        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Algún dato es incorrecto y/o no cumple con las restricciones requeridas.");
        }
    }

    /**
     * Función para borrar un jugador pasandole su id.
     *
     * @param idJugador Es el id del jugador y sirve para identificar el jugador que queremos borrar
     * @throws Exception Si ocurre un error durante la eliminación.
     * @throws SQLIntegrityConstraintViolationException Si no existe un jugador con el ID especificado.
     */
    public void borrarJugador(int idJugador) throws Exception {
        PreparedStatement sentenciaPre = null;
        try {
            String plantilla = "DELETE FROM jugadores WHERE id_jugador = ?";
            sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, idJugador);

            int n = sentenciaPre.executeUpdate();
            if (n == 0) {
                throw new Exception("No hay ningún jugador registrado con el ID proporcionado.");
            }
        } catch (SQLException e) {
            throw new Exception("Error al borrar el jugador: " + e.getMessage(), e);
        } finally {
            if (sentenciaPre != null) {
                try {
                    sentenciaPre.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la sentencia preparada: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Función para modificar uno o más datos sobre el jugador que identifiquemos con su id.
     *
     * @param j Es el objeto jugador del cual queremos actualizar uno o varios valores suyos buscandolo por id.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarJugador(Jugador j) throws Exception {
        String plantilla = "UPDATE jugadores SET nickname = ?, nacionalidad = ?, rol = ?, fecha_nac = ?, " +
                "sueldo = ?, id_equipo = ? WHERE nombre = ?";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setString(1, j.getNickname());
        sentenciaPre.setString(2, j.getNacionalidad());
        sentenciaPre.setString(3, j.getRol());
        sentenciaPre.setDate(4, j.getFechaNac());
        sentenciaPre.setDouble(5, j.getSueldo());
        sentenciaPre.setInt(6, j.getEquipo().getIdEquipo());
        sentenciaPre.setString(7, j.getNombre());

        int n = sentenciaPre.executeUpdate();
        if (n != 1){
            throw new Exception("No se ha podido actualizar ningún jugador.");
        }
    }

    /**
     * Función para buscar los datos sobre el jugador que identifiquemos con su nombre.
     *
     * @param nombre Es el nombre del jugador con el cual obtendremos los demás datos.
     * @return El objeto Jugador obtenido.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Jugador buscarJugadorPorNombre(String nombre) throws Exception{

        try {
            String plantilla = "SELECT id_jugador, nombre, nickname, nacionalidad, rol, fecha_nac, sueldo, id_equipo " +
                                "FROM JUGADORES WHERE UPPER(nombre) = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombre.toUpperCase());
            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next()) {
                j = new Jugador();
                j.setIdJugador(rs.getInt("id_jugador"));
                j.setNombre(rs.getString("nombre"));
                j.setNickname(rs.getString("nickname"));
                j.setNacionalidad(rs.getString("nacionalidad"));
                j.setRol(rs.getString("rol"));
                j.setFechaNac(rs.getDate("fecha_nac"));
                j.setSueldo(rs.getDouble("sueldo"));
                Equipo e = new Equipo();
                e.setIdEquipo(rs.getInt("id_equipo"));
                j.setEquipo(e);
            }
            else {
                throw new Exception("No hay ningún jugador registrado con ese nombre.");
            }
            sentenciaPre.close();
            return j;
        }
        catch (Exception e) {
            throw new Exception("Error al buscar jugador por nombre.");
        }

    }
}
