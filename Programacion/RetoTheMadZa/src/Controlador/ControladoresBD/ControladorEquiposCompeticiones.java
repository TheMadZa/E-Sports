package Controlador.ControladoresBD;

import Modelo.Competicion;
import Modelo.EquipoCompeticion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
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
            String plantilla = "SELECT * FROM equipos_competiciones";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            ResultSet rs = sentenciaPre.executeQuery();
            while (rs.next()) {
                ec = new EquipoCompeticion();
                ec.getEquipo().setIdEquipo(rs.getInt("id_equipo"));
                ec.getCompeticion().setIdCompeticion(rs.getInt("id_competicion"));
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
}
