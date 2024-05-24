package Controlador.ControladoresBD;

import Modelo.Equipo;

import javax.swing.*;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ControladorEquipos que gestiona las consultas sobre los equipos.
 *
 * <p>Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre los equipos en la base de datos.</p>
 *
 * @author Julen, Lorena, Ibai
 * @version 1.0
 */
public class ControladorEquipos {
    private Connection con;
    private Equipo e;

    /**
     * Constructor de la clase ControladorEquipos.
     *
     * @param con Es la conexión con la base de datos que se ejecuta junto con el constructor.
     */
    public ControladorEquipos(Connection con) {
        this.con = con;
    }

    /**
     * Función para insertar un equipo pasandole todos sus valores.
     *
     * @param e Es el objeto equipo que vamos a insertar en la base de datos
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarEquipo(Equipo e) throws Exception {
        try {
            String plantilla = "INSERT INTO equipos (nom_equipo, fecha_fundacion, logo , color) VALUES (?,?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setString(1,e.getNomEquipo());
            sentenciaPre.setDate(2,e.getFechaFundacion());
            sentenciaPre.setString(3,e.getLogo());
            sentenciaPre.setString(4,e.getColor());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1) {
                throw new Exception("No se ha podido insertar el equipo.");
            }

        }
        catch (SQLIntegrityConstraintViolationException ex) {
            throw new Exception("Ya hay registrado una equipo con esos datos.");
        }
    }

    /**
     * Función para borrar una competicion pasandole el id.
     *
     * @param idEquipo Es el id del equipo y sirve para identificar el equipo que queremos borrar
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarEquipo(int idEquipo) throws Exception {
        try {
            String plantilla = "DELETE FROM equipos WHERE UPPER(id_equipo) = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1, idEquipo);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha podido eliminar ningún equipo.");
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("No hay registrado ningún equipo con ese ID para poderlo borrar.");
        }
    }

    /**
     * Función para buscar datos sobre un equipo pasandole su id.
     *
     * @param idEquipo Es el id del equipo que sirve para identificar al equipo que queremos buscar
     * @return Se devuelve el objeto equipo con todos sus valores.
     * @throws Exception Si no se encuentra el equipo o si ocurre un error durante la búsqueda.
     */
    public Equipo buscarEquipo(int idEquipo) throws Exception {
        try {
            String plantilla = "SELECT * FROM equipos WHERE id_equipo = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,idEquipo);

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next()) {
                e = new Equipo();
                e.setIdEquipo(idEquipo);
                e.setNomEquipo(rs.getString("nom_equipo"));
                e.setFechaFundacion(rs.getDate("fecha_fundacion"));
                e.setLogo(rs.getString("logo"));
                e.setColor(rs.getString("color"));
            }
            else {
                throw new Exception("No hay ningún equipo registrado con ese ID.");
            }
            sentenciaPre.close();
            return e;
        }
        catch (Exception e) {
            throw new Exception("Error al buscar equipo por ID.");
        }
    }

    /**
     * Función para modificar el equipo .
     *
     * @param e Es el objeto equipo del cual queremos actualizar uno o varios valores suyos buscandolo por nombre.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarEquipo(Equipo e) throws Exception {
        String plantilla = "UPDATE equipos SET fecha_fundacion = ?, logo = ?, color = ? WHERE nom_equipo = ?";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setDate(1, e.getFechaFundacion());
        sentenciaPre.setString(2, e.getLogo());
        sentenciaPre.setString(3, e.getColor());
        sentenciaPre.setString(4, e.getNomEquipo());

        int n = sentenciaPre.executeUpdate();
        if (n != 1){
            throw new Exception("No se ha podido actualizar ningún equipo.");
        }
    }

    /**
     * Función para buscar el id, fecha de fundacion, logo y color sobre un equipo pasándole su nombre.
     *
     * @param nombre Es el nombre del equipo que sirve para identificar al equipo que queremos buscar
     * @return Se devuelve el objeto equipo con los valores que le hemos dicho.
     * @throws Exception Si no se encuentra el equipo o si ocurre un error durante la búsqueda.
     */
    public Equipo buscarEquipoPorNombre(String nombre) throws Exception{

        try {
            String plantilla = "SELECT id_equipo, nom_equipo, fecha_fundacion, logo, color FROM equipos WHERE UPPER(nom_equipo) = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setString(1,nombre.toUpperCase());

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next()) {
                e = new Equipo();
                e.setIdEquipo(rs.getInt("id_equipo"));
                e.setNomEquipo(rs.getString("nom_equipo"));
                e.setFechaFundacion(rs.getDate("fecha_fundacion"));
                e.setLogo(rs.getString("logo"));
                e.setColor(rs.getString("color"));
            }
            else {
                throw new Exception("No hay ningún equipo registrado con ese nombre.");
            }

            sentenciaPre.close();
            return e;
        }
        catch (Exception e) {
            throw new Exception("Error al buscar equipo por nombre.");
        }

    }

    /**
     * Función para buscar el id, nombre y logo de todos los equipos.
     *
     * @return Se devuelve una lista con todos los Equipos.
     * @throws Exception Si ocurre un error durante la carga de equipos.
     */
    public List<Equipo> cargarEquiposDesdeBD() throws Exception {
        try {
            ArrayList<Equipo> listaEquipos = new ArrayList<>();

            String plantilla = "SELECT ID_EQUIPO, NOM_EQUIPO, LOGO FROM EQUIPOS";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            ResultSet rs = sentenciaPre.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOM_EQUIPO");
                String logoUrl = rs.getString("LOGO");

                Equipo e = new Equipo();
                e.setIdEquipo(id);
                e.setNomEquipo(nombre);
                e.setLogo(logoUrl);

                listaEquipos.add(e);
            }
            return listaEquipos;
        }
        catch (Exception e){
            throw new Exception("Error al cargar equipos desde base de datos.");
        }
    }
}
