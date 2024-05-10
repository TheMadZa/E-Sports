package Modelo;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Enfrentamiento {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ENFRENTAMIENTO")
    private int idEnfrentamiento;
    @Basic
    @Column(name = "HORA_ENFRENTAMIENTO")
    private Timestamp horaEnfrentamiento;
    @Basic
    @Column(name = "RESULTADO1")
    private int resultado1;
    @Basic
    @Column(name = "RESULTADO2")
    private int resultado2;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO1", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo1;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO2", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo2;
    @ManyToOne
    @JoinColumn(name = "ID_JORNADA", referencedColumnName = "ID_JORNADA", nullable = false)
    private Jornada jornadaByIdJornada;

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

    public void setResultado1(byte resultado1) {
        this.resultado1 = resultado1;
    }

    public int getResultado2() {
        return resultado2;
    }

    public void setResultado2(int resultado2) {
        this.resultado2 = resultado2;
    }

    public void setResultado2(byte resultado2) {
        this.resultado2 = resultado2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enfrentamiento that = (Enfrentamiento) o;

        if (idEnfrentamiento != that.idEnfrentamiento) return false;
        if (resultado1 != that.resultado1) return false;
        if (resultado2 != that.resultado2) return false;
        if (horaEnfrentamiento != null ? !horaEnfrentamiento.equals(that.horaEnfrentamiento) : that.horaEnfrentamiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEnfrentamiento;
        result = 31 * result + (horaEnfrentamiento != null ? horaEnfrentamiento.hashCode() : 0);
        result = 31 * result + (int) resultado1;
        result = 31 * result + (int) resultado2;
        return result;
    }

    public Equipo getEquipoByIdEquipo1() {
        return equipoByIdEquipo1;
    }

    public void setEquipoByIdEquipo1(Equipo equipoByIdEquipo1) {
        this.equipoByIdEquipo1 = equipoByIdEquipo1;
    }

    public Equipo getEquipoByIdEquipo2() {
        return equipoByIdEquipo2;
    }

    public void setEquipoByIdEquipo2(Equipo equipoByIdEquipo2) {
        this.equipoByIdEquipo2 = equipoByIdEquipo2;
    }

    public Jornada getJornadaByIdJornada() {
        return jornadaByIdJornada;
    }

    public void setJornadaByIdJornada(Jornada jornadaByIdJornada) {
        this.jornadaByIdJornada = jornadaByIdJornada;
    }
}
