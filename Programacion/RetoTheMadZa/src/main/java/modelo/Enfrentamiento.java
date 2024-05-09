package modelo;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Enfrentamiento {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ENFRENTAMIENTO")
    private byte idEnfrentamiento;
    @Basic
    @Column(name = "HORA_ENFRENTAMIENTO")
    private Timestamp horaEnfrentamiento;
    @Basic
    @Column(name = "RESULTADO1")
    private byte resultado1;
    @Basic
    @Column(name = "RESULTADO2")
    private byte resultado2;
    @Basic
    @Column(name = "ID_EQUIPO1")
    private byte idEquipo1;
    @Basic
    @Column(name = "ID_EQUIPO2")
    private byte idEquipo2;
    @Basic
    @Column(name = "ID_JORNADA")
    private byte idJornada;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO1", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo1;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO2", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo2;
    @ManyToOne
    @JoinColumn(name = "ID_JORNADA", referencedColumnName = "ID_JORNADA", nullable = false)
    private Jornada jornadaByIdJornada;

    public byte getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(byte idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public Timestamp getHoraEnfrentamiento() {
        return horaEnfrentamiento;
    }

    public void setHoraEnfrentamiento(Timestamp horaEnfrentamiento) {
        this.horaEnfrentamiento = horaEnfrentamiento;
    }

    public byte getResultado1() {
        return resultado1;
    }

    public void setResultado1(byte resultado1) {
        this.resultado1 = resultado1;
    }

    public byte getResultado2() {
        return resultado2;
    }

    public void setResultado2(byte resultado2) {
        this.resultado2 = resultado2;
    }

    public byte getIdEquipo1() {
        return idEquipo1;
    }

    public void setIdEquipo1(byte idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    public byte getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(byte idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    public byte getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(byte idJornada) {
        this.idJornada = idJornada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enfrentamiento that = (Enfrentamiento) o;

        if (idEnfrentamiento != that.idEnfrentamiento) return false;
        if (resultado1 != that.resultado1) return false;
        if (resultado2 != that.resultado2) return false;
        if (idEquipo1 != that.idEquipo1) return false;
        if (idEquipo2 != that.idEquipo2) return false;
        if (idJornada != that.idJornada) return false;
        if (horaEnfrentamiento != null ? !horaEnfrentamiento.equals(that.horaEnfrentamiento) : that.horaEnfrentamiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idEnfrentamiento;
        result = 31 * result + (horaEnfrentamiento != null ? horaEnfrentamiento.hashCode() : 0);
        result = 31 * result + (int) resultado1;
        result = 31 * result + (int) resultado2;
        result = 31 * result + (int) idEquipo1;
        result = 31 * result + (int) idEquipo2;
        result = 31 * result + (int) idJornada;
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
