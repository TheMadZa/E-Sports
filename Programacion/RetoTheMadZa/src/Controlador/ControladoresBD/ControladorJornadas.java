package Controlador.ControladoresBD;

import Modelo.Equipo;
import Modelo.Jornada;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ControladorJornadas {
    private Connection con;
    private Jornada j;

    public ControladorJornadas(Connection con) {
        this.con = con;
    }

    public void insertarJornada(Jornada j) throws Exception
    {
        try
        {
            String plantilla = "INSERT INTO jornadas VALUES (?,?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,j.getIdJornada());
            sentenciaPre.setInt(2,j.getNumJornada());
            sentenciaPre.setDate(3,j.getFechaJornada());
            sentenciaPre.setInt(4,j.getCompeticion().getIdCompeticion());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1)
            {
                throw new Exception("No se ha insertado la jornada");
            }

        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("Ya hay una jornada con ese id");
        }
    }

    public void borrarJornada(int idJornada) throws Exception
    {
        try
        {
            String plantilla = "DELETE FROM jornadas WHERE id_jornada = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1, idJornada);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha eliminado ninguna jornada");
            }
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new Exception("No existe una jornada con ese id para borrar");
        }
    }

    public Jornada buscarJornada(int idJornada) throws Exception
    {
        try
        {
            String plantilla = "SELECT * FROM jornadas WHERE id_jornada = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setInt(1,idJornada);

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next())
            {
                j = new Jornada();
                j.setIdJornada(idJornada);
                j.setNumJornada(rs.getInt("num_jornada"));
                j.setFechaJornada(rs.getDate("fecha_jornada"));
                j.getCompeticion().setIdCompeticion(rs.getInt("id_competicion"));
            }
            else
            {
                throw new Exception("No hay ninguna jornada con ese id");
            }
            sentenciaPre.close();
            return j;
        }
        catch (Exception e)
        {
            throw new Exception("Error");
        }
    }

    public void modificarJornada(Jornada j) throws Exception
    {
        String plantilla = "UPDATE jornadas SET num_jornada = ?, fecha_jornada = ?, id_competicion = ?, " +
                "WHERE id_jornada = ?";

        PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

        sentenciaPre.setInt(1, j.getNumJornada());
        sentenciaPre.setDate(2, j.getFechaJornada());
        sentenciaPre.setInt(3, j.getCompeticion().getIdCompeticion());
        sentenciaPre.setInt(4, j.getIdJornada());

        int n = sentenciaPre.executeUpdate();
        if (n != 1){
            throw new Exception("No se ha actualizado ninguna jornada");
        }
    }

    public String[][] obtenerResultadosUltimaJornada(int idCompeticion) throws Exception {
        String[][] resultados = new String[4][4]; // Array multidimensional con 4 filas y 4 columnas

        String sql = "SELECT RESULTADO1, RESULTADO2, ID_EQUIPO1, ID_EQUIPO2 " +
                "FROM ENFRENTAMIENTOS " +
                "WHERE ID_JORNADA = (SELECT MAX(ID_JORNADA) " +
                "FROM JORNADAS " +
                "WHERE ID_COMPETICION = ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idCompeticion);
            ResultSet rs = stmt.executeQuery();
            int fila = 0;
            while (rs.next() && fila < 4) {
                int resultado1 = rs.getInt("RESULTADO1");
                int resultado2 = rs.getInt("RESULTADO2");
                int idEquipo1 = rs.getInt("ID_EQUIPO1");
                int idEquipo2 = rs.getInt("ID_EQUIPO2");
                resultados[fila][0] = Integer.toString(resultado1);
                resultados[fila][1] = Integer.toString(resultado2);
                resultados[fila][2] = Integer.toString(idEquipo1);
                resultados[fila][3] = Integer.toString(idEquipo2);
                fila++;
            }
        } catch (Exception e) {
            System.err.println("Error al obtener los resultados de la última jornada: " + e.getMessage());
            throw e;
        }
        return resultados;
    }

}