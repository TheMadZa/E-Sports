package Modelo;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Clase que representa un equipo en un evento deportivo.
 * Cada equipo tiene un nombre, una fecha de fundación, un logo, un color y una lista de jugadores y entrenadores.
 *
 * @author Ibai, Lorena
 * @version 1.0
 */
public class Equipo {

    private int idEquipo;
    private String nomEquipo;
    private Date fechaFundacion;
    private String logo;
    private String color;
    private Collection<Jugador> listaJugadores;
    private Collection<Staff> listaEntrenadores;

    /**
     * Constructor vacío de la clase Equipo.
     * Crea una instancia de Equipo con valores predeterminados.
     */
    // Constructores
    public Equipo() {
    }

    /**
     * Constructor de la clase Equipo con parámetros.
     * Crea una instancia de Equipo con los valores proporcionados.
     *
     * @param idEquipo        Identificador único del equipo.
     * @param nomEquipo       Nombre del equipo.
     * @param fechaFundacion  Fecha de fundación del equipo.
     * @param logo            URL del logo del equipo.
     * @param color           Color representativo del equipo.
     */
    public Equipo(int idEquipo, String nomEquipo, Date fechaFundacion, String logo, String color) {
        this.idEquipo = idEquipo;
        this.nomEquipo = nomEquipo;
        this.fechaFundacion = fechaFundacion;
        this.logo = logo;
        this.color = color;
    }

    // Getters and Setters
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }


    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Collection<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(Collection<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Collection<Staff> getListaEntrenadores() {
        return listaEntrenadores;
    }

    public void setListaEntrenadores(Collection<Staff> listaEntrenadores) {
        this.listaEntrenadores = listaEntrenadores;
    }

    // Add single jugador
    /**
     * Agrega un jugador a la lista de jugadores del equipo.
     *
     * @param jugador El jugador a agregar.
     */
    public void addJugador(Jugador jugador) {
        if (listaJugadores == null)
            listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador);
    }

    // Add single entrenador
    /**
     * Agrega un entrenador a la lista de entrenadores del equipo.
     *
     * @param entrenador El entrenador a agregar.
     */
    public void addEntrenador(Staff entrenador) {
        if (listaEntrenadores == null)
            listaEntrenadores = new ArrayList<>();
        listaEntrenadores.add(entrenador);
    }

    // equals and hashCode

    /**
     * Compara este equipo con otro objeto para verificar si son iguales.
     * Dos equipos se consideran iguales si tienen el mismo identificador de equipo,
     * el mismo nombre, la misma fecha de fundación, el mismo logo y el mismo color.
     *
     * @param o Objeto a comparar con este equipo.
     * @return true si el objeto dado es igual a este equipo, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (idEquipo != equipo.idEquipo) return false;
        if (nomEquipo != null ? !nomEquipo.equals(equipo.nomEquipo) : equipo.nomEquipo != null) return false;
        if (fechaFundacion != null ? !fechaFundacion.equals(equipo.fechaFundacion) : equipo.fechaFundacion != null)
            return false;
        if (logo != null ? !logo.equals(equipo.logo) : equipo.logo != null) return false;
        return color != null ? color.equals(equipo.color) : equipo.color == null;
    }

    /**
     * Calcula el código hash para este equipo.
     *
     * @return El código hash calculado para este equipo.
     */
    @Override
    public int hashCode() {
        int result = idEquipo;
        result = 31 * result + (nomEquipo != null ? nomEquipo.hashCode() : 0);
        result = 31 * result + (fechaFundacion != null ? fechaFundacion.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}