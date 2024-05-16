package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

public class Jornada {
    private int idJornada;
    private int numJornada;
    private Date fechaJornada;
    private Collection<Enfrentamiento> enfrentamientos;
    private Competicion competicion;

    // Constructors
    public Jornada() {
    }

    public Jornada(int idJornada, int numJornada, Date fechaJornada, Competicion competicion) {
        this.idJornada = idJornada;
        this.numJornada = numJornada;
        this.fechaJornada = fechaJornada;
        this.competicion = competicion;
    }

    // Getters and Setters
    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public Date getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    public Collection<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    public void setEnfrentamientos(Collection<Enfrentamiento> enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }

    public Competicion getCompeticion() {
        return competicion;
    }

    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
    }

    // Add single enfrentamiento
    public void addEnfrentamiento(Enfrentamiento enfrentamiento) {
        if (enfrentamientos == null)
            enfrentamientos = new ArrayList<>();
        enfrentamientos.add(enfrentamiento);
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jornada jornada = (Jornada) o;

        if (idJornada != jornada.idJornada) return false;
        if (numJornada != jornada.numJornada) return false;
        return fechaJornada != null ? fechaJornada.equals(jornada.fechaJornada) : jornada.fechaJornada == null;
    }

    @Override
    public int hashCode() {
        int result = idJornada;
        result = 31 * result + numJornada;
        result = 31 * result + (fechaJornada != null ? fechaJornada.hashCode() : 0);
        return result;
    }
}
