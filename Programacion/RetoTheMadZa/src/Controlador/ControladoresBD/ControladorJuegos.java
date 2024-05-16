package Controlador.ControladoresBD;

import Modelo.Juego;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorJuegos {
    private final List<Juego> juegos;

    public ControladorJuegos() {
        this.juegos = new ArrayList<>();
        System.out.println("Elementos creados de ControladorJuegos.");
    }

    public void insertarJuego(Juego j) throws Exception {
        try {
            juegos.add(j);
        } catch (Exception ex) {
            throw new Exception("Error al insertar el juego: " + ex.getMessage());
        }
    }

    public void borrarJuego(Juego j) throws Exception {
        if (juegos.remove(j)) {
            System.out.println("Juego eliminado.");
        } else {
            throw new Exception("No se encontró el juego a eliminar.");
        }
    }

    public Juego buscarJuego(Integer id_juego) throws Exception {
        for (Juego juego : juegos) {
            if (juego.getIdJuego() == id_juego) {
                return juego;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ningún juego con ese ID.");
        return null;
    }

    public void modificarJuego(Juego juego) throws Exception {
        Juego j = buscarJuego(juego.getIdJuego());
        if (j != null) {
            j.setNombre(juego.getNombre());
            j.setEmpresa(juego.getEmpresa());
            j.setFechaLanzamiento(juego.getFechaLanzamiento());
        } else {
            throw new Exception("No se encontró ningún juego con el ID provisto: " + juego.getIdJuego());
        }
    }
}
