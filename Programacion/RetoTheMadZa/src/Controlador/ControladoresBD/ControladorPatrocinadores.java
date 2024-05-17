package Controlador.ControladoresBD;

import Modelo.Jugador;
import Modelo.Patrocinador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ControladorPatrocinadores {
    private Connection con;
    private Patrocinador p;

    public ControladorPatrocinadores(Connection con) {
        this.con = con;
    }

    public void insertarPatrocinador(Patrocinador p) throws Exception
    {
        try
        {
            String plantilla = "INSERT INTO patrocinadores VALUES (?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,p.getIdPatrocinador());
            sentenciaPre.setString(2,p.getNombre());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1)
            {
                throw new Exception("No se ha insertado el patrocinador");
            }

        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("Ya hay un patrocinador con ese id");
        }
    }

    public void borrarPatrocinador(int idPatrocinador) throws Exception
    {
        try
        {
            String plantilla = "DELETE FROM patrocinadores WHERE id_patrocinador = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1, idPatrocinador);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha eliminado ningún patrocinador");
            }
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("No existe un patrocinador con ese id para borrar");
        }
    }

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

    public void modificarPatrocinador(Patrocinador p) throws Exception
    {
        String plantilla = "UPDATE jugadores SET nombre = ?, WHERE id_patrocinador = ?";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setString(1, p.getNombre());
        sentenciaPre.setInt(2, p.getIdPatrocinador());

        int n = sentenciaPre.executeUpdate();
        if (n != 1){
            throw new Exception("No se ha actualizado ningún patrocinador");
        }
    }
}
