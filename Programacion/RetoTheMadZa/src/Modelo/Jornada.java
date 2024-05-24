package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Clase que representa una jornada en una competición deportiva.
 * Cada jornada tiene un número, una fecha y una lista de enfrentamientos entre equipos.
 * Está asociada a una competición específica.
 *
 * @author Lorena, Ibai
 * @version 1.0
 */
public class Jornada {
    private int idJornada;
    private int numJornada;
    private Date fechaJornada;
    private Collection<Enfrentamiento> listaEnfrentamientos;
    private Competicion competicion;

    // Constructores

    /**
     * Constructor vacío de la clase Jornada.
     * Crea una instancia de Jornada con valores predeterminados.
     */
    public Jornada() {
    }

    /**
     * Constructor de la clase Jornada con parámetros.
     *
     * @param idJornada    Identificador único de la jornada.
     * @param numJornada   Número de la jornada dentro de la competición.
     * @param fechaJornada Fecha en la que tiene lugar la jornada.
     * @param competicion  Competición a la que pertenece esta jornada.
     */
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

    public Collection<Enfrentamiento> getListaEnfrentamientos() {
        return listaEnfrentamientos;
    }

    public void setListaEnfrentamientos(Collection<Enfrentamiento> listaEnfrentamientos) {
        this.listaEnfrentamientos = listaEnfrentamientos;
    }

    public Competicion getCompeticion() {
        return competicion;
    }

    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
    }

    // Add single enfrentamiento

    /**
     * Añade un enfrentamiento a la lista de enfrentamientos de la jornada.
     *
     * @param enfrentamiento Enfrentamiento a añadir.
     */
    public void addEnfrentamiento(Enfrentamiento enfrentamiento) {
        if (listaEnfrentamientos == null)
            listaEnfrentamientos = new ArrayList<>();
        listaEnfrentamientos.add(enfrentamiento);
    }

    // equals and hashCode

    /**
     * Compara esta jornada con otro objeto para verificar si son iguales.
     * Dos jornadas se consideran iguales si tienen el mismo identificador,
     * el mismo número y la misma fecha.
     *
     * @param o Objeto a comparar con esta jornada.
     * @return true si el objeto dado es igual a esta jornada, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jornada jornada = (Jornada) o;

        if (idJornada != jornada.idJornada) return false;
        if (numJornada != jornada.numJornada) return false;
        return fechaJornada != null ? fechaJornada.equals(jornada.fechaJornada) : jornada.fechaJornada == null;
    }

    /**
     * Calcula el código hash de esta jornada.
     *
     * @return Código hash de esta jornada.
     */
    @Override
    public int hashCode() {
        int result = idJornada;
        result = 31 * result + numJornada;
        result = 31 * result + (fechaJornada != null ? fechaJornada.hashCode() : 0);
        return result;
    }
}
