package Controlador.ControladoresBD;

import Modelo.Patrocinador;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorPatrocinadores {
    private final List<Patrocinador> patrocinadores;

    public ControladorPatrocinadores() {
        this.patrocinadores = new ArrayList<>();
        System.out.println("Elementos creados de ControladorPatrocinadores.");
    }

    public void insertarPatrocinador(Patrocinador p) throws Exception {
        try {
            patrocinadores.add(p);
        } catch (Exception ex) {
            throw new Exception("Error al insertar el patrocinador: " + ex.getMessage());
        }
    }

    public void borrarPatrocinador(Patrocinador p) throws Exception {
        if (patrocinadores.remove(p)) {
            System.out.println("Patrocinador eliminado.");
        } else {
            throw new Exception("No se encontró el patrocinador a eliminar.");
        }
    }

    public Patrocinador buscarPatrocinador(Integer id_patrocinador) throws Exception {
        for (Patrocinador patrocinador : patrocinadores) {
            if (patrocinador.getIdPatrocinador() == id_patrocinador) {
                return patrocinador;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ningún patrocinador con ese ID.");
        return null;
    }

    public void modificarPatrocinador(Patrocinador patrocinador) throws Exception {
        Patrocinador p = buscarPatrocinador(patrocinador.getIdPatrocinador());
        if (p != null) {
            p.setNombre(patrocinador.getNombre());
        } else {
            throw new Exception("No se encontró ningún patrocinador con el ID provisto: " +
                    patrocinador.getIdPatrocinador());
        }
    }
}
