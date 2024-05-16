package Controlador.ControladoresBD;

import Modelo.Competicion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorCompeticiones {
    private final List<Competicion> competiciones;

    public ControladorCompeticiones() {
        this.competiciones = new ArrayList<>();
        System.out.println("Elementos creados de ControladorCompeticiones.");
    }

    public void insertarCompeticion(Competicion c) throws Exception {
        try {
            competiciones.add(c);
        } catch (Exception e) {
            throw new Exception("Error al insertar la competición: " + e.getMessage());
        }
    }

    public void borrarCompeticion(Competicion c) throws Exception {
        if (competiciones.remove(c)) {
            System.out.println("Competición eliminada.");
        } else {
            throw new Exception("No se encontró la competición a eliminar.");
        }
    }

    public Competicion buscarCompeticion(Integer id_competicion) throws Exception {
        for (Competicion comp : competiciones) {
            if (comp.getIdCompeticion() == id_competicion) {
                return comp;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ninguna competición con ese ID.");
        return null;
    }

    public Competicion buscarCompeticionNombre(String nombre_com) throws Exception {
        for (Competicion comp : competiciones) {
            if (comp.getNombreCom().equals(nombre_com)) {
                return comp;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ninguna competición con ese nombre.");
        return null;
    }

    public List<Competicion> buscarTodasCompeticiones() throws Exception {
        return new ArrayList<>(competiciones);
    }

    public void modificarCompeticion(Competicion competicion) throws Exception {
        Competicion c = buscarCompeticion(competicion.getIdCompeticion());
        if (c != null) {
            c.setNombreCom(competicion.getNombreCom());
            c.setFechaInicio(competicion.getFechaInicio());
            c.setFechaFin(competicion.getFechaFin());
            c.setEtapa(competicion.getEtapa());
            c.setJuego(competicion.getJuego());  // Asumiendo que el método correcto es setJuego
            c.setEquipoGanador(competicion.getEquipoGanador());  // Asumiendo que el método correcto es setEquipoGanador
        } else {
            throw new Exception("No se encontró ninguna competición con el ID provisto: " +
                    competicion.getIdCompeticion());
        }
    }
}
