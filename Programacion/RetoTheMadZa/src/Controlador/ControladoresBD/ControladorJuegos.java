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
                throw new Exception("No se ha insertado el juego.");
            }

        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Ya existe un juego con esos datos.");
        }
    }

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
