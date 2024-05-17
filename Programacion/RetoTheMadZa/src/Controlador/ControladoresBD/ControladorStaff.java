package Controlador.ControladoresBD;

import Modelo.Patrocinador;
import Modelo.Staff;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ControladorStaff {
    private Connection con;
    private Staff s;

    public ControladorStaff(Connection con) {
        this.con = con;
    }

    public void insertarStaff(Staff s) throws Exception
    {
        try
        {
            String plantilla = "INSERT INTO staffs VALUES (?,?,?,?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,s.getIdStaff());
            sentenciaPre.setString(2,s.getPuesto());
            sentenciaPre.setString(3,s.getNombre());
            sentenciaPre.setDate(4,s.getFechaNac());
            sentenciaPre.setDouble(5,s.getSueldo());
            sentenciaPre.setInt(6,s.getEquipo().getIdEquipo());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1)
            {
                throw new Exception("No se ha insertado el staff");
            }

        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("Ya hay un staff con ese id");
        }
    }

    public void borrarStaff(int idStaff) throws Exception
    {
        try
        {
            String plantilla = "DELETE FROM staffs WHERE id_staff = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1, idStaff);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha eliminado ningún staff");
            }
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("No existe un staff con ese id para borrar");
        }
    }

    public Staff buscarStaff(int idStaff) throws Exception
    {
        try
        {
            String plantilla = "SELECT * FROM staffs WHERE id_staff = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,idStaff);

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next())
            {
                s = new Staff();
                s.setIdStaff(idStaff);
                s.setPuesto(rs.getString("puesto"));
                s.setNombre(rs.getString("nombre"));
                s.setFechaNac(rs.getDate("fecha_nac"));
                s.setSueldo(rs.getDouble("sueldo"));
                s.getEquipo().setIdEquipo(rs.getInt("id_equipo"));
            }
            else
            {
                throw new Exception("No hay ningún staff con ese id");
            }
            sentenciaPre.close();
            return s;
        }
        catch (Exception e)
        {
            throw new Exception("Error");
        }
    }

    public void modificarStaff(Staff s) throws Exception
    {
        String plantilla = "UPDATE staffs SET puesto = ?, nombre = ?, fecha_nac = ?, sueldo = ?, id_equipo = ?" +
                "WHERE id_staff = ?";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setString(1, s.getPuesto());
        sentenciaPre.setString(2, s.getNombre());
        sentenciaPre.setDate(3, s.getFechaNac());
        sentenciaPre.setDouble(4, s.getSueldo());
        sentenciaPre.setInt(5, s.getEquipo().getIdEquipo());
        sentenciaPre.setInt(6, s.getIdStaff());

        int n = sentenciaPre.executeUpdate();
        if (n != 1){
            throw new Exception("No se ha actualizado ningún staff");
        }
    }
}
