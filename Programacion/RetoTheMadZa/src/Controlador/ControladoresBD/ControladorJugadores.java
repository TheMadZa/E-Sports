package Controlador.ControladoresBD;

import Modelo.Jugador;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorJugadores {
    private final List<Jugador> jugadores;

    public ControladorJugadores() {
        this.jugadores = new ArrayList<>();
        System.out.println("Elementos creados de ControladorJugadores.");
    }

    public void insertarJugador(Jugador j) throws Exception {
        try {
            jugadores.add(j);
        } catch (Exception ex) {
            throw new Exception("Error al insertar el jugador: " + ex.getMessage());
        }
    }

    public void borrarJugador(Jugador j) throws Exception {
        if (jugadores.remove(j)) {
            System.out.println("Jugador eliminado.");
        } else {
            throw new Exception("No se encontró el jugador a eliminar.");
        }
    }

    public Jugador buscarJugador(Integer id_jugador) throws Exception {
        for (Jugador jugador : jugadores) {
            if (jugador.getIdJugador() == id_jugador) {
                return jugador;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ningún jugador con ese ID.");
        return null;
    }

    public void modificarJugador(Jugador jugador) throws Exception {
        Jugador j = buscarJugador(jugador.getIdJugador());
        if (j != null) {
            j.setNombre(jugador.getNombre());
            j.setNickname(jugador.getNickname());
            j.setNacionalidad(jugador.getNacionalidad());
            j.setRol(jugador.getRol());
            j.setFechaNac(jugador.getFechaNac());
            j.setSueldo(jugador.getSueldo());
            j.setEquipo(jugador.getEquipo());
        } else {
            throw new Exception("No se encontró ningún jugador con el ID provisto: " + jugador.getIdJugador());
        }
    }
}
