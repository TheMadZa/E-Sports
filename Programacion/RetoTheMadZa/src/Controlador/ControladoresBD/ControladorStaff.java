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

/**
 * Clase ControladorStaffs que gestiona las consultas sobre los staffs.
 *
 * <p>Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre el staff
 * en la base de datos.</p>
 *
 * @author Julen, Ibai
 * @version 1.0
 */
public class ControladorStaff {
    private Connection con;
    private Staff s;

    /**
     * Constructor de la clase ControladorStaffs.
     *
     * @param con Es la conexión con la base de datos que se ejecuta junto con el constructor.
     */
    public ControladorStaff(Connection con) {
        this.con = con;
    }

    /**
     * Función para insertar un staff pasándole todos sus valores.
     *
     * @param s Es el objeto staff que vamos a insertar en la base de datos
     * @throws Exception Si ocurre un error durante la inserción.
     * @throws SQLIntegrityConstraintViolationException Si ya existe un miembro del staff con el mismo ID.
     */
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

    /**
     * Función para borrar un staff pasandole su id.
     *
     * @param idStaff Es el id del staff y sirve para identificar el staff que queremos borrar
     * @throws Exception Si ocurre un error durante la eliminación.
     * @throws SQLIntegrityConstraintViolationException Si no existe un miembro del staff con el ID especificado.
     */
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

    /**
     * Función para buscar datos sobre un staff pasandole su id.
     *
     * @param idStaff Es el id del staff que sirve para identificar el staff que queremos buscar.
     * @return Se devuelve el objeto staff con todos sus valores.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
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

    /**
     * Función para modificar uno o más datos sobre el staff que identifiquemos con su id.
     *
     * @param s Es el objeto staff del cual queremos actualizar uno o varios valores suyos buscandolo por id.
     * @throws Exception Si ocurre un error durante la modificación.
     */
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
