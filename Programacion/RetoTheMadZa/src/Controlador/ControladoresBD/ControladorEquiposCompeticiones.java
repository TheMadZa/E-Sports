package Controlador.ControladoresBD;

import Modelo.EquipoCompeticion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ControladorEquiposCompeticiones {
    private final List<EquipoCompeticion> equiposCompeticiones;

    public ControladorEquiposCompeticiones() {
        this.equiposCompeticiones = new ArrayList<>();
        System.out.println("Elementos creados de ControladorEquiposCompeticiones.");
    }

    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        equiposCompeticiones.sort(Comparator.comparingInt(EquipoCompeticion::getPuntos));
        return new ArrayList<>(equiposCompeticiones);
    }
}
