package Controlador.ControladoresBD;

import Modelo.Competicion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ControladorCompeticiones que gestiona las consultas sobre las competiciones.
 *
 * @author Julen
 */
public class ControladorCompeticiones {
    private final Connection con;
    private Competicion c;

    public ControladorCompeticiones(Connection con) {
        this.con = con;
    }

    public void insertarCompeticion(Competicion c) throws Exception {
        try {
            String plantilla = "INSERT INTO competiciones VALUES (?,?,?,?,?,?,?);";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1, c.getIdCompeticion());
            sentenciaPre.setString(2, c.getNombreCom());
            sentenciaPre.setDate(3, c.getFechaInicio());
            sentenciaPre.setDate(4, c.getFechaFin());
            sentenciaPre.setString(5, c.getEtapa());
            sentenciaPre.setInt(6, c.getJuego().getIdJuego());
            sentenciaPre.setInt(7, c.getEquipoGanador().getIdEquipo());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1) {
                throw new Exception("No se ha insertado la competición.");
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Error al insertar la competición: " + e.getMessage());
        }
    }

    public void borrarCompeticion(int idCompeticion) throws Exception {
        try {
            String plantilla = "DELETE FROM competiciones WHERE id_competicion = ?;";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, idCompeticion);
            int n = sentenciaPre.executeUpdate();

            if (n != 1) {
                throw new Exception("No se ha eliminado la competición.");
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("No existe una competición con ese ID.");
        }
    }

    public Competicion buscarCompeticion(int idCompeticion) throws Exception {
        try {
            String plantilla = "SELECT * FROM competiciones WHERE id_competicion = ?;";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, idCompeticion);

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next()) {
                c = new Competicion();
                c.setIdCompeticion(idCompeticion);
                c.setNombreCom(rs.getString("nombre_com"));
                c.setFechaInicio(rs.getDate("fecha_inicio"));
                c.setFechaFin(rs.getDate("fecha_fin"));
                c.setEtapa(rs.getString("etapa"));
                c.getJuego().setIdJuego(rs.getInt("id_juego"));
                c.getEquipoGanador().setIdEquipo(rs.getInt("id_equipo_ganador"));
            }
            else {
                throw new Exception("No hay ninguna competición con ese ID.");
            }
            sentenciaPre.close();
            return c;
        }
        catch (Exception e) {
            throw new Exception("Error al obtener una competición.");
        }
    }

    // TODO : IGUAL HABRÍA QUE HACER QUE DEVUELVA LOS EQUIPOS CON MÁS VICTORIAS? (ORDER BY ec.victorias DESC)
    /**
     * Función para obtener logo, victorias y puntos de un equipo en una competición.
     * Se buscarán los logos, las victorias y los puntos totales de los equipos que participan
     * en una determinada competición, filtrada por el nombre de la misma.
     *
     * @author Julen
     * @author Lorena
     * @param nombreCom
     * @return String[][]
     * @throws Exception
     */
    public String[][] buscarEquiposPorNombreCom(String nombreCom) throws Exception {
        try {
            String plantilla = "SELECT e.logo, ec.victorias, ec.puntos " +
                                "FROM equipos e " +
                                "JOIN equipos_competiciones ec ON e.id_equipo = ec.id_equipo " +
                                "WHERE ec.id_competicion IN (SELECT id_competicion FROM competiciones "+
                                "WHERE UPPER(nombre_com) = ?) order by ec.puntos";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreCom.toUpperCase());
            ResultSet rs = sentenciaPre.executeQuery();

            // Array multidimensional con 10 filas y 3 columnas
            String[][] listaCompeticiones = new String[10][3];

            int i = 0;
            while (rs.next()) {

                // Array para almacenar los datos de una fila
                String[] fila = new String[3];

                fila[0] = rs.getString("logo");
                fila[1] = Integer.toString(rs.getInt("victorias"));
                fila[2] = Integer.toString(rs.getInt("puntos"));

                // Agregar la fila al array multidimensional
                listaCompeticiones[i] = fila;
                i++;

            }

            sentenciaPre.close();

            if (i == 0) {
                throw new Exception("No hay ninguna competición con ese nombre.");
            }

            return listaCompeticiones;
        }
        catch (Exception e) {
            throw new Exception("Error al obtener los datos de los equipos de una competición.");
        }
    }

    // TODO : SEGURAMENTE SE PUEDA PONER QUE DEVUELVA UN ARRAYLIST PERO DE STRING nombre_com
    public List<Competicion> buscarTodasCompeticiones() throws Exception {
        List<Competicion> competiciones = new ArrayList<>();
        try {
            String plantilla = "SELECT nombre_com FROM competiciones";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            ResultSet rs = sentenciaPre.executeQuery();
            while (rs.next()) {
                c = new Competicion();
                c.setNombreCom(rs.getString("nombre_com"));
                competiciones.add(c);
            }
            sentenciaPre.close();
            return competiciones;
        }
        catch (Exception e) {
            throw new Exception("Error al buscar los nombres de las competiciones.");
        }
    }

    public void modificarCompeticion(Competicion c) throws Exception {
        String plantilla = "UPDATE competiciones SET nombre_com = ?, fecha_inicio = ?, fecha_fin = ?, etapa = ?, " +
                            "id_juego = ?, id_equipo_ganador = ? WHERE id_competicion = ?;";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setString(1, c.getNombreCom());
        sentenciaPre.setDate(2, c.getFechaInicio());
        sentenciaPre.setDate(3, c.getFechaFin());
        sentenciaPre.setString(4, c.getEtapa());
        sentenciaPre.setInt(5, c.getJuego().getIdJuego());
        sentenciaPre.setInt(6, c.getEquipoGanador().getIdEquipo());
        sentenciaPre.setInt(7, c.getIdCompeticion());

        int n = sentenciaPre.executeUpdate();
        if (n != 1){
            throw new Exception("No se ha actualizado ninguna competición.");
        }
    }
}