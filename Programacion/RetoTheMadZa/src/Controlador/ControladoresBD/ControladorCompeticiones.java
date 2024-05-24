package Controlador.ControladoresBD;

import Modelo.Competicion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ControladorCompeticiones que gestiona las consultas sobre las competiciones.
 *
 * <p>Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre las competiciones en la base de datos.</p>
 *
 * @author Julen, Lorena, Zahir, Ibai
 * @version 1.0
 */
public class ControladorCompeticiones {
    private final Connection con;
    private Competicion c;

    /**
     * Constructor de la clase ControladorCompeticiones.
     *
     * @param con Es la conexión con la base de datos que se ejecuta junto con el constructor.
     */
    public ControladorCompeticiones(Connection con) {
        this.con = con;
    }

    /**
     * Función para insertar una competicion pasandole todos sus valores.
     *
     * @param c Es el objeto competicion que vamos a insertar en la base de datos
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarCompeticion(Competicion c) throws Exception {
        try {
            String plantilla = "INSERT INTO competiciones VALUES (?,?,?,?,?,?,?)";

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

    /**
     * Función para borrar una competicion pasandole el id.
     *
     * @param idCompeticion Es el id de la competición y sirve para identificar la competición que queremos borrar
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarCompeticion(int idCompeticion) throws Exception {
        try {
            String plantilla = "DELETE FROM competiciones WHERE id_competicion = ?";
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

    /**
     * Función para buscar datos sobre una competicion pasandole su id.
     *
     * @param idCompeticion Es el id de la competición que sirve para identificar la competición que queremos buscar
     * @return Se devuelve el objeto competicion con todos sus valores.
     * @throws Exception Si no se encuentra la competición o si ocurre un error durante la búsqueda.
     */
    public Competicion buscarCompeticion(int idCompeticion) throws Exception {
        try {
            String plantilla = "SELECT * FROM competiciones WHERE id_competicion = ?";
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

    /**
     * Función para buscar equipos por nombre de la competición
     *
     * <p>Devuelve para obtener logo, victorias y puntos de un equipo en una competición.
     * Se buscarán los logos, las victorias, los puntos totales, los nombres de los equipos, los nombres de los
     * jugadores y los id de los equipos que participan en una determinada competición, filtrada por el nombre de
     * la misma.</p>
     *
     * @param nombreCom Es el nombre de la competición que se utiliza para buscar los equipos de una competición en
     * concreto.
     * @return Se devuelve un array bidimensional con datos de los Equipos.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public String[][] buscarEquiposPorNombreCom(String nombreCom) throws Exception {
        try {
            String plantilla = "SELECT e.logo, ec.victorias, ec.puntos, e.nom_equipo, j.nombre, e.ID_EQUIPO " +
                                "FROM equipos e " +
                                "JOIN equipos_competiciones ec ON e.id_equipo = ec.id_equipo " +
                                "JOIN competiciones c ON ec.id_competicion = c.id_competicion " +
                                "JOIN juegos j ON c.id_juego = j.id_juego " +
                                "WHERE UPPER(c.nombre_com) = ? " +
                                "ORDER BY ec.victorias DESC, ec.puntos DESC";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreCom.toUpperCase());
            ResultSet rs = sentenciaPre.executeQuery();

            // Array multidimensional con 10 filas y 5 columnas
            String[][] listaCompeticiones = new String[10][6];

            int i = 0;
            while (rs.next()) {

                // Array para almacenar los datos de una fila
                String[] fila = new String[6];

                fila[0] = rs.getString("logo");
                fila[1] = Integer.toString(rs.getInt("victorias"));
                fila[2] = Integer.toString(rs.getInt("puntos"));
                fila[3] = rs.getString("nom_equipo");
                fila[4] = rs.getString("nombre");
                fila[5] = rs.getString("ID_EQUIPO");

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

    /**
     * Función para buscar todos los nombres de cada competicion.
     *
     * @return Se devuelve una lista con todas las Competiciones.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
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

    /**
     * Función para modificar la competicion .
     *
     * @param c Es el objeto competicion del cual queremos actualizar uno o varios valores suyos.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarCompeticion(Competicion c) throws Exception {
        String plantilla = "UPDATE competiciones SET nombre_com = ?, fecha_inicio = ?, fecha_fin = ?, etapa = ?, " +
                            "id_juego = ?, id_equipo_ganador = ? WHERE id_competicion = ?";

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