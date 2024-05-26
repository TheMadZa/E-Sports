package Controlador.ControladoresBD;

import Modelo.PatrocinadorEquipo;

import java.sql.*;
import java.util.ArrayList;

/**
 * ControladorPatrocinadoresEquipos maneja las operaciones relacionadas con la tabla
 * `patrocinadores_equipos` en la base de datos, incluyendo insertar, buscar y borrar registros.
 *
 * @author Julen, Lorena
 */
public class ControladorPatrocinadoresEquipos {

    private final Connection con;
    private PatrocinadorEquipo pe;

    /**
     * Constructor de la clase ControladorPatrocinadoresEquipos.
     *
     * @param con la conexión a la base de datos.
     */
    public ControladorPatrocinadoresEquipos(Connection con) {
        this.con = con;
    }

    /**
     * Inserta un nuevo registro en la tabla `patrocinadores_equipos`.
     *
     * @param idPatrocinador el ID del patrocinador.
     * @param idEquipo el ID del equipo.
     * @throws Exception si ocurre un error al insertar el registro o si ya existe un registro
     * con los mismos datos.
     */
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

    /**
     * Busca todos los equipos patrocinados por un patrocinador específico.
     *
     * @param idPatrocinador el ID del patrocinador.
     * @return una lista de IDs de los equipos patrocinados por el patrocinador.
     * @throws Exception si ocurre un error al buscar los equipos patrocinados o si el
     * patrocinador no patrocina ningún equipo.
     */
    public ArrayList<Integer> buscarEquiposPatrocinador(int idPatrocinador) throws Exception {
        ArrayList<Integer> listaEquiposPatrocinador = new ArrayList<>();
        try {
            String plantilla = "SELECT id_equipo FROM patrocinadores_equipos WHERE id_patrocinador = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, idPatrocinador);
            ResultSet rs = sentenciaPre.executeQuery();
            while (rs.next()) {
                listaEquiposPatrocinador.add(rs.getInt("id_equipo"));
            }
            sentenciaPre.close();
            if (listaEquiposPatrocinador.isEmpty()) {
                throw new Exception("El patrocinador no patrocina ningún equipo.");
            }
            return listaEquiposPatrocinador;
        } catch (SQLException e) {
            throw new Exception("Error al buscar en `patrocinadores_equipos´: " + e.getMessage());
        }
    }

    /**
     * Borra un registro de la tabla `patrocinadores_equipos`.
     *
     * @param idPatrocinador el ID del patrocinador.
     * @param idEquipo el ID del equipo.
     * @throws Exception si ocurre un error al borrar el registro o si no existe un registro
     * con los datos proporcionados.
     */
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
