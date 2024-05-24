package Controlador.ControladoresBD;

import Modelo.Juego;
import Modelo.Jugador;

import javax.swing.*;
import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ControladorJugadores que gestiona las consultas sobre los jugadores.
 *
 * <p>Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los jugadores
 * en la base de datos.</p>
 *
 * @author Julen
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
    public void insertarJugador(Jugador j) throws Exception
    {
        try
        {
            String plantilla = "INSERT INTO jugadores VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,j.getIdJugador());
            sentenciaPre.setString(2,j.getNombre());
            sentenciaPre.setString(3,j.getNickname());
            sentenciaPre.setString(4,j.getNacionalidad());
            sentenciaPre.setString(5,j.getRol());
            sentenciaPre.setDate(6,j.getFechaNac());
            sentenciaPre.setDouble(7,j.getSueldo());
            sentenciaPre.setInt(8,j.getEquipo().getIdEquipo());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1)
            {
                throw new Exception("No se ha insertado el jugador");
            }

        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("Ya hay un jugador con ese id");
        }
    }

    /**
     * Función para borrar un jugador pasandole su id.
     *
     * @param idJugador Es el id del jugador y sirve para identificar el jugador que queremos borrar
     * @throws Exception Si ocurre un error durante la eliminación.
     * @throws SQLIntegrityConstraintViolationException Si no existe un jugador con el ID especificado.
     */
    public void borrarJugador(int idJugador) throws Exception
    {
        try
        {
            String plantilla = "DELETE FROM jugadores WHERE id_jugador = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1, idJugador);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha eliminado ningún jugador");
            }
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("No existe un jugador con ese id para borrar");
        }
    }

    /**
     * Función para buscar datos sobre un jugador pasandole su id.
     *
     * @param idJugador Es el id del jugador que sirve para identificar el jugador que queremos buscar.
     * @return Se devuelve el objeto jugador con todos sus valores.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Jugador buscarJugador(int idJugador) throws Exception
    {
        try
        {
            String plantilla = "SELECT * FROM jugadores WHERE id_jugador = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,idJugador);

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next())
            {
                j = new Jugador();
                j.setIdJugador(idJugador);
                j.setNombre(rs.getString("nombre"));
                j.setNickname(rs.getString("nickname"));
                j.setNacionalidad(rs.getString("nacionalidad"));
                j.setRol(rs.getString("rol"));
                j.setFechaNac(rs.getDate("fecha_nac"));
                j.setSueldo(rs.getDouble("sueldo"));
                j.getEquipo().setIdEquipo(rs.getInt("id_equipo"));
            }
            else
            {
                throw new Exception("No hay ningún jugador con ese id");
            }
            sentenciaPre.close();
            return j;
        }
        catch (Exception e)
        {
            throw new Exception("Error");
        }
    }

    /**
     * Función para modificar uno o más datos sobre el jugador que identifiquemos con su id.
     *
     * @param j Es el objeto jugador del cual queremos actualizar uno o varios valores suyos buscandolo por id.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarJugador(Jugador j) throws Exception
    {
        String plantilla = "UPDATE jugadores SET nombre = ?, nickname = ?, nacionalidad = ?, rol = ?, fecha_nac = ?," +
                "sueldo = ?, id_equipo = ? WHERE id_jugador = ?";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setString(1, j.getNombre());
        sentenciaPre.setString(2, j.getNickname());
        sentenciaPre.setString(3, j.getNacionalidad());
        sentenciaPre.setString(4, j.getRol());
        sentenciaPre.setDate(5, j.getFechaNac());
        sentenciaPre.setDouble(6, j.getSueldo());
        sentenciaPre.setInt(7, j.getEquipo().getIdEquipo());
        sentenciaPre.setInt(8, j.getIdJugador());

        int n = sentenciaPre.executeUpdate();
        if (n != 1){
            throw new Exception("No se ha actualizado ningún jugador");
        }
    }
}
