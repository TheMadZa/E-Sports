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

    public Juego buscarJuego(int idJuego) throws Exception
    {
        try
        {
            String plantilla = "SELECT * FROM juegos WHERE id_juego = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,idJuego);

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next())
            {
                j = new Juego();
                j.setIdJuego(idJuego);
                j.setNombre(rs.getString("nombre"));
                j.setEmpresa(rs.getString("empresa"));
                j.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
            }
            else
            {
                throw new Exception("No hay ningún juego con ese id");
            }
            sentenciaPre.close();
            return j;
        }
        catch (Exception e)
        {
            throw new Exception("Error");
        }
    }

    public void modificarJuego(Juego j) throws Exception
    {
        String plantilla = "UPDATE juegos SET nombre = ?, empresa = ?, fecha_lanzamiento = ?, " +
                "WHERE id_juego = ?";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setString(1, j.getNombre());
        sentenciaPre.setString(2, j.getEmpresa());
        sentenciaPre.setDate(3, j.getFechaLanzamiento());
        sentenciaPre.setInt(4, j.getIdJuego());

        int n = sentenciaPre.executeUpdate();
        if (n != 1){
            throw new Exception("No se ha actualizado ningún juego");
        }
    }
}
