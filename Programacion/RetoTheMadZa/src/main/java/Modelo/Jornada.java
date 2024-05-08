package Modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Jornada {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_JORNADA")
    private byte idJornada;

    public byte getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(byte idJornada) {
        this.idJornada = idJornada;
    }

    @Basic
    @Column(name = "NUM_JORNADA")
    private byte numJornada;

    public byte getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(byte numJornada) {
        this.numJornada = numJornada;
    }

    @Basic
    @Column(name = "FECHA_JORNADA")
    private Date fechaJornada;

    public Date getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    @Basic
    @Column(name = "ID_COMPETICION")
    private byte idCompeticion;

    public byte getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(byte idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jornada jornada = (Jornada) o;

        if (idJornada != jornada.idJornada) return false;
        if (numJornada != jornada.numJornada) return false;
        if (idCompeticion != jornada.idCompeticion) return false;
        if (fechaJornada != null ? !fechaJornada.equals(jornada.fechaJornada) : jornada.fechaJornada != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idJornada;
        result = 31 * result + (int) numJornada;
        result = 31 * result + (fechaJornada != null ? fechaJornada.hashCode() : 0);
        result = 31 * result + (int) idCompeticion;
        return result;
    }
}
