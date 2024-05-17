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

public class ControladorJugadores {
    private Connection con;
    private Jugador j;

    public ControladorJugadores(Connection con) {
        this.con = con;
    }

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
