package Controlador.ControladoresBD;

import Modelo.Competicion;
import Modelo.Equipo;
import Modelo.EquipoCompeticion;
import Modelo.Juego;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorCompeticiones {
    private Connection con;
    private Competicion c;

    public ControladorCompeticiones(Connection con) {
        this.con = con;
    }

    public void insertarCompeticion(Competicion c) throws Exception
    {
        try
        {
            String plantilla = "INSERT INTO competiciones VALUES (?,?,?,?,?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,c.getIdCompeticion());
            sentenciaPre.setString(2,c.getNombreCom());
            sentenciaPre.setDate(3,c.getFechaInicio());
            sentenciaPre.setDate(4,c.getFechaFin());
            sentenciaPre.setString(5,c.getEtapa());
            sentenciaPre.setInt(6,c.getJuego().getIdJuego());
            sentenciaPre.setInt(7,c.getEquipoGanador().getIdEquipo());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1)
            {
                throw new Exception("No se ha insertado la competicion");
            }
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("Error al insertar la competición: " + e.getMessage());
        }
    }

    public void borrarCompeticion(int idCompeticion) throws Exception
    {
        try {
            String plantilla = "DELETE FROM competiciones WHERE id_competicion = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1, idCompeticion);

            int n = sentenciaPre.executeUpdate();

            if (n != 1) {
                throw new Exception("No se ha eliminado la competicion");
            }
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("No existe una competicion con ese id");
        }
    }

    public Competicion buscarCompeticion(int idCompeticion) throws Exception
    {
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
            } else {
                throw new Exception("No hay ninguna competicion con ese id");
            }
            sentenciaPre.close();
            return c;
        }
        catch (Exception e)
        {
            throw new Exception("Error");
        }
    }

    public String[][] buscarCompeticionNombre(String nombreCom) throws Exception
    {

        try
        {
            String plantilla = "SELECT e.logo, ec.victorias, ec.puntos FROM equipos e JOIN equipos_competiciones ec " +
                    "ON e.id_equipo = ec.id_equipo WHERE ec.id_competicion IN (SELECT id_competicion FROM competiciones "
                    +"WHERE UPPER(nombre_com) = ?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setString(1, nombreCom);

            ResultSet rs = sentenciaPre.executeQuery();


            String[][] listaCompeticiones = new String[10][3]; // Array multidimensional con 10 filas y 3 columnas

            int i = 0;
            while (rs.next() && i < 10) { // Iterar sobre las filas y limitar a 10 filas
                String[] fila = new String[3]; // Array para almacenar los datos de una fila

                fila[0] = rs.getString("logo"); // Obtener el logo del equipo
                fila[1] = Integer.toString(rs.getInt("victorias")); // Obtener las victorias
                fila[2] = Integer.toString(rs.getInt("puntos")); // Obtener los puntos

                listaCompeticiones[i] = fila; // Agregar la fila al array multidimensional
                i++;
            }


            sentenciaPre.close();


            if (i == 0) {
                throw new Exception("No hay ninguna competición con ese nombre");
            }


            return listaCompeticiones;
        }
        catch (Exception e)
        {
            throw new Exception("Error");
        }
    }

    public List<Competicion> buscarTodasCompeticiones() throws Exception
    {
        List<Competicion> competiciones = new ArrayList<>();
        try
        {
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
        catch (Exception e)
        {
            throw new Exception("Error al buscar competiciones");
        }
    }

    public void modificarCompeticion(Competicion c) throws Exception
    {
        String plantilla = "UPDATE competiciones SET nombre_com = ?, fecha_inicio = ?, fecha_fin = ?, etapa = ?," +
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
            throw new Exception("No se ha actualizado ninguna competición");
        }
    }
}
