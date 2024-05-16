package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

public class Equipo {

    private int idEquipo;
    private String nomEquipo;
    private Date fechaFundacion;
    private String logo;
    private String color;
    private Collection<Jugador> jugadores;
    private Collection<Staff> entrenadores;

    // Constructors
    public Equipo() {
    }

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

    public Collection<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Collection<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Collection<Staff> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(Collection<Staff> entrenadores) {
        this.entrenadores = entrenadores;
    }

    // Add single jugador
    public void addJugador(Jugador jugador) {
        if (jugadores == null)
            jugadores = new ArrayList<>();
        jugadores.add(jugador);
    }

    // Add single entrenador
    public void addEntrenador(Staff entrenador) {
        if (entrenadores == null)
            entrenadores = new ArrayList<>();
        entrenadores.add(entrenador);
    }

    // equals and hashCode
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
