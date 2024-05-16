package Controlador.ControladoresBD;

import Modelo.Jornada;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorJornadas {
    private final List<Jornada> jornadas;

    public ControladorJornadas() {
        this.jornadas = new ArrayList<>();
        System.out.println("Elementos creados de ControladorJornadas.");
    }

    public void insertarJornada(Jornada j) throws Exception {
        try {
            jornadas.add(j);
        } catch (Exception ex) {
            throw new Exception("Error al insertar la jornada: " + ex.getMessage());
        }
    }

    public void borrarJornada(Jornada j) throws Exception {
        if (jornadas.remove(j)) {
            System.out.println("Jornada eliminada.");
        } else {
            throw new Exception("No se encontró la jornada a eliminar.");
        }
    }

    public Jornada buscarJornada(Integer id_jornada) throws Exception {
        for (Jornada jornada : jornadas) {
            if (jornada.getIdJornada() == id_jornada) {
                return jornada;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ninguna jornada con ese ID.");
        return null;
    }

    public void modificarJornada(Jornada jornada) throws Exception {
        Jornada j = buscarJornada(jornada.getIdJornada());
        if (j != null) {
            j.setNumJornada(jornada.getNumJornada());
            j.setFechaJornada(jornada.getFechaJornada());
            j.setCompeticion(jornada.getCompeticion());
        } else {
            throw new Exception("No se encontró ninguna jornada con el ID provisto: " + jornada.getIdJornada());
        }
    }
}