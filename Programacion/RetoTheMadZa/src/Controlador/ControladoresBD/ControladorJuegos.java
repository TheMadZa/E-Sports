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

public class ControladorJuegos {
    private Connection con;
    private Juego j;

    public ControladorJuegos(Connection con) {
        this.con = con;
    }

    public void insertarJuego(Juego j) throws Exception
    {
        try
        {
            String plantilla = "INSERT INTO juegos VALUES (?,?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,j.getIdJuego());
            sentenciaPre.setString(2,j.getNombre());
            sentenciaPre.setString(3,j.getEmpresa());
            sentenciaPre.setDate(4,j.getFechaLanzamiento());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1)
            {
                throw new Exception("No se ha insertado el juego");
            }

        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("Ya hay un juego con ese id");
        }
    }

    public void borrarJuego(int idJuego) throws Exception
    {
        try
        {
            String plantilla = "DELETE FROM juegos WHERE id_juego = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1, idJuego);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha eliminado ninguna juego");
            }
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("No existe un juego con ese id para borrar");
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
