package Controlador.ControladoresBD;

import Modelo.Competicion;
import Modelo.Equipo;
import Modelo.PatrocinadorEquipo;
import Modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;

// TODO : JAVADOC
public class ControladorPatrocinadoresEquipos {

    private Connection con;
    private PatrocinadorEquipo pe;

    public ControladorPatrocinadoresEquipos(Connection con) {
        this.con = con;
    }

    public void insertarPatrocinadorEquipo(int idPatrocinador, int idEquipo) throws Exception {

        try {
            String plantilla = "INSERT INTO patrocinadores_equipos (id_patrocinador, id_equipo) VALUES (?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,idPatrocinador);
            sentenciaPre.setInt(2,idEquipo);

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1) {
                throw new Exception("No se ha insertado ninguna fila en `patrocinadores_equipos´.");
            }

        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Ya hay registrada una fila en `patrocinadores_equipos´.");
        }

    }

    public ArrayList<Integer> buscarEquiposPatrocinador(int idPatrocinador) throws Exception {

        try {
            ArrayList<Integer> listaEquiposPatrocinador;
            String plantilla = "SELECT id_equipo FROM patrocinadores_equipos WHERE id_patrocinador = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, idPatrocinador);
            ResultSet rs = sentenciaPre.executeQuery();
            listaEquiposPatrocinador = new ArrayList<>();
            if (rs.next()) {
                listaEquiposPatrocinador.add(rs.getInt("id_equipo"));
            }
            else {
                throw new Exception("No hay ningún patrocinador registrado con ese ID.");
            }
            sentenciaPre.close();
            return listaEquiposPatrocinador;
        } catch (SQLException e) {
            throw new Exception("Error al buscar en `patrocinadores_equipos´: " + e.getMessage());
        }

    }

    public void borrarPatrocinadorEquipo(int idPatrocinador, int idEquipo) throws Exception {

        try {
            String plantilla = "DELETE FROM patrocinadores_equipos WHERE id_patrocinador = ? and id_equipo = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, idPatrocinador);
            sentenciaPre.setInt(2, idEquipo);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha podido eliminar ningúna fila de `patrocinadores_equipos´.");
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("No hay ningúna fila registrada en `patrocinadores_equipos´ con esos datos para borrar.");
        }

    }

}
