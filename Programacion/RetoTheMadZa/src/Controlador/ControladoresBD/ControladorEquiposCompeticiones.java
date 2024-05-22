package Controlador.ControladoresBD;

import Modelo.EquipoCompeticion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ControladorEquiposCompeticiones {
    private Connection con;
    private EquipoCompeticion ec;

    public ControladorEquiposCompeticiones(Connection con) {
        this.con = con;
    }

    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception
    {
        List<EquipoCompeticion> equiposCompeticiones = new ArrayList<>();
        try
        {
            String plantilla = "SELECT victorias, puntos FROM equipos_competiciones";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            ResultSet rs = sentenciaPre.executeQuery();
            while (rs.next()) {
                ec = new EquipoCompeticion();

                ec.setVictorias(rs.getInt("victorias"));
                ec.setPuntos(rs.getInt("puntos"));
                equiposCompeticiones.add(ec);
            }
            sentenciaPre.close();
            return equiposCompeticiones;
        }
        catch (Exception e)
        {
            throw new Exception("Error al buscar equipos en competiciones");
        }
    }

    public void insertarEquipoCompeticion(int idEquipo, int idCompeticion) throws Exception {

        try
        {
            String plantilla = "INSERT INTO equipos_competiciones VALUES (?,?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            // PONER VICTORIAS Y PUNTOS = 0
            sentenciaPre.setInt(1,idEquipo);
            sentenciaPre.setInt(2,idCompeticion);
            sentenciaPre.setInt(3,0);
            sentenciaPre.setInt(4,0);

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1) {
                throw new Exception("No se ha insertado ninguna fila en `equipos_competiciones´.");
            }

        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Ya hay registrada una fila en `equipos_competiciones´.");
        }

    }
}
