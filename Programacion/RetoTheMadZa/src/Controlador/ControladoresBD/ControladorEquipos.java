package Controlador.ControladoresBD;

import Modelo.Equipo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorEquipos {
    private final List<Equipo> equipos;
    private Equipo e;

    public ControladorEquipos() {
        this.equipos = new ArrayList<>();
        System.out.println("Elementos creados de ControladorEquipos.");
    }

    public void insertarEquipo(Equipo e) throws Exception {
        try {
            equipos.add(e);
        } catch (Exception ex) {
            throw new Exception("Error al insertar el equipo: " + ex.getMessage());
        }
    }

    public void borrarEquipo(Equipo e) throws Exception {
        if (equipos.remove(e)) {
            System.out.println("Equipo eliminado.");
        } else {
            throw new Exception("No se encontró el equipo a eliminar.");
        }
    }

    public Equipo buscarEquipo(Integer id_equipo) throws Exception {
        for (Equipo equipo : equipos) {
            if (equipo.getIdEquipo() == id_equipo) {
                return equipo;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ningún equipo con ese ID.");
        return null;
    }

    public void modificarEquipo(Equipo equipo) throws Exception {
        Equipo e = buscarEquipo(equipo.getIdEquipo());
        if (e != null) {
            e.setNomEquipo(equipo.getNomEquipo());
            e.setFechaFundacion(equipo.getFechaFundacion());
            e.setLogo(equipo.getLogo());
            e.setColor(equipo.getColor());
        } else {
            throw new Exception("No se encontró ningún equipo con el ID provisto: " + equipo.getIdEquipo());
        }
    }
}
