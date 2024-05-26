package Controlador.ControladoresBD;

import Modelo.Enfrentamiento;
import Modelo.Equipo;
import Modelo.Jornada;

import java.sql.*;

/**
 * ControladorEnfrentamientos maneja las operaciones relacionadas con la base de datos
 * para los enfrentamientos, incluyendo borrar, buscar y modificar enfrentamientos.
 *
 * @author Lorena
 */
public class ControladorEnfrentamientos {

    private final Connection con;

    /**
     * Constructor de la clase ControladorEnfrentamientos.
     *
     * @param con la conexión a la base de datos.
     */
    public ControladorEnfrentamientos(Connection con) {
        this.con = con;
    }

    /**
     * Borra un enfrentamiento de la base de datos por su ID.
     *
     * @param idEnfrentamiento el ID del enfrentamiento a borrar.
     * @throws Exception si ocurre un error al borrar el enfrentamiento o si no se puede
     * eliminar debido a restricciones de integridad.
     */
    public void borrarEnfrentamiento(int idEnfrentamiento) throws Exception{

        PreparedStatement sentenciaPre = null;
        try {
            String plantilla = "DELETE FROM enfrentamientos WHERE id_enfrentamiento = ?";
            sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, idEnfrentamiento);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha podido eliminar ningún enfrentamiento.");
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("No se puede eliminar el enfrentamiento debido a restricciones de integridad.", e);
        }
        catch (Exception e) {
            throw new Exception("Error al borrar el enfrentamiento.", e);
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

    /**
     * Busca un enfrentamiento en la base de datos por su ID.
     *
     * @param idEnfrentamiento el ID del enfrentamiento a buscar.
     * @return el enfrentamiento encontrado.
     * @throws Exception si ocurre un error al buscar el enfrentamiento o si no se encuentra
     * ningún enfrentamiento con el ID proporcionado.
     */
    public Enfrentamiento buscarEnfrentamiento(int idEnfrentamiento) throws Exception {

        try {
            String plantilla = "SELECT * FROM enfrentamientos WHERE id_enfrentamiento = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1,idEnfrentamiento);

            ResultSet rs = sentenciaPre.executeQuery();
            Enfrentamiento e;
            if (rs.next()) {
                e = new Enfrentamiento();
                e.setIdEnfrentamiento(idEnfrentamiento);
                e.setHoraEnfrentamiento(rs.getTimestamp("hora_enfrentamiento"));
                e.setResultado1(rs.getInt("resultado1"));
                e.setResultado2(rs.getInt("resultado2"));
                Equipo equipo1 = new Equipo();
                equipo1.setIdEquipo(rs.getInt("id_equipo1"));
                e.setEquipo1(equipo1);
                Equipo equipo2 = new Equipo();
                equipo2.setIdEquipo(rs.getInt("id_equipo2"));
                e.setEquipo2(equipo2);
                Jornada jornada = new Jornada();
                jornada.setIdJornada(rs.getInt("id_jornada"));
                e.setJornada(jornada);
            }
            else {
                throw new Exception("No hay ningún enfrentamiento registrado con ese ID.");
            }
            sentenciaPre.close();
            return e;
        }
        catch (Exception e) {
            throw new Exception("Error al buscar enfrentamiento.");
        }

    }

    /**
     * Modifica un enfrentamiento existente en la base de datos.
     *
     * @param e el enfrentamiento a modificar.
     * @throws Exception si ocurre un error al actualizar el enfrentamiento.
     */
    public void modificarEnfrentamiento(Enfrentamiento e) throws Exception {
        PreparedStatement sentenciaPre = null;

        try {
            String plantilla = "UPDATE enfrentamientos SET hora_enfrentamiento = ?, resultado1 = ?, resultado2 = ?, " +
                                "id_equipo1 = ?, id_equipo2 = ?, id_jornada = ? WHERE id_enfrentamiento = ?";
            sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setTimestamp(1, e.getHoraEnfrentamiento());
            sentenciaPre.setInt(2, e.getResultado1());
            sentenciaPre.setInt(3, e.getResultado2());
            sentenciaPre.setInt(4, e.getEquipo1().getIdEquipo());
            sentenciaPre.setInt(5, e.getEquipo2().getIdEquipo());
            sentenciaPre.setInt(6, e.getJornada().getIdJornada());
            sentenciaPre.setInt(7, e.getIdEnfrentamiento());

            int n = sentenciaPre.executeUpdate();

            if (n != 1) {
                throw new Exception("No se ha podido actualizar ningún enfrentamiento.");
            }
        } catch (SQLException sqlEx) {
            throw new Exception("Error al actualizar el enfrentamiento en la base de datos.", sqlEx);
        } catch (Exception ex) {
            throw new Exception("Error al actualizar el enfrentamiento.", ex);
        } finally {
            if (sentenciaPre != null) {
                try {
                    sentenciaPre.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar PreparedStatement: " + ex.getMessage());
                }
            }
        }
    }


}
