package Modelo;

import java.sql.Timestamp;

public class Enfrentamiento {

    private int idEnfrentamiento;
    private Timestamp horaEnfrentamiento;
    private int resultado1;
    private int resultado2;
    private Equipo equipo1;
    private Equipo equipo2;
    private Jornada jornada;

    // Constructors
    public Enfrentamiento() {
    }

    public Enfrentamiento(int idEnfrentamiento, Timestamp horaEnfrentamiento, int resultado1, int resultado2,
                          Equipo equipo1, Equipo equipo2, Jornada jornada) {
        this.idEnfrentamiento = idEnfrentamiento;
        this.horaEnfrentamiento = horaEnfrentamiento;
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.jornada = jornada;
    }

    // Getters and Setters
    public int getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(int idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public Timestamp getHoraEnfrentamiento() {
        return horaEnfrentamiento;
    }

    public void setHoraEnfrentamiento(Timestamp horaEnfrentamiento) {
        this.horaEnfrentamiento = horaEnfrentamiento;
    }

    public int getResultado1() {
        return resultado1;
    }

    public void setResultado1(int resultado1) {
        this.resultado1 = resultado1;
    }

    public int getResultado2() {
        return resultado2;
    }

    public void setResultado2(int resultado2) {
        this.resultado2 = resultado2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enfrentamiento that = (Enfrentamiento) o;

        if (idEnfrentamiento != that.idEnfrentamiento) return false;
        if (resultado1 != that.resultado1) return false;
        if (resultado2 != that.resultado2) return false;
        return horaEnfrentamiento != null ? horaEnfrentamiento.equals(that.horaEnfrentamiento) : that.horaEnfrentamiento == null;
    }

    @Override
    public int hashCode() {
        int result = idEnfrentamiento;
        result = 31 * result + (horaEnfrentamiento != null ? horaEnfrentamiento.hashCode() : 0);
        result = 31 * result + resultado1;
        result = 31 * result + resultado2;
        return result;
    }
}
