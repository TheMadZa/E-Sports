package Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "VISTA_ENFRENTAMIENTOS_JORNADA", schema = "EQDAW03", catalog = "")
public class VistaEnfrentamientosJornada {
    @Basic
    @Column(name = "ID_ENFRENTAMIENTO")
    private byte idEnfrentamiento;
    @Basic
    @Column(name = "HORA_ENFRENTAMIENTO")
    private String horaEnfrentamiento;
    @Basic
    @Column(name = "ID_EQUIPO_1")
    private byte idEquipo1;
    @Basic
    @Column(name = "RESULTADO_EQUIPO_1")
    private byte resultadoEquipo1;
    @Basic
    @Column(name = "ID_EQUIPO_2")
    private byte idEquipo2;
    @Basic
    @Column(name = "RESULTADO_EQUIPO_2")
    private byte resultadoEquipo2;
    @Basic
    @Column(name = "NÚMERO_JORNADA")
    private byte númeroJornada;
    @Basic
    @Column(name = "FECHA_JORNADA")
    private Date fechaJornada;
    @Basic
    @Column(name = "ID_COMPETICION")
    private byte idCompeticion;
    @Basic
    @Column(name = "NOMBRE_COMPETICION")
    private String nombreCompeticion;

    public byte getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(byte idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public String getHoraEnfrentamiento() {
        return horaEnfrentamiento;
    }

    public void setHoraEnfrentamiento(String horaEnfrentamiento) {
        this.horaEnfrentamiento = horaEnfrentamiento;
    }

    public byte getIdEquipo1() {
        return idEquipo1;
    }

    public void setIdEquipo1(byte idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    public byte getResultadoEquipo1() {
        return resultadoEquipo1;
    }

    public void setResultadoEquipo1(byte resultadoEquipo1) {
        this.resultadoEquipo1 = resultadoEquipo1;
    }

    public byte getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(byte idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    public byte getResultadoEquipo2() {
        return resultadoEquipo2;
    }

    public void setResultadoEquipo2(byte resultadoEquipo2) {
        this.resultadoEquipo2 = resultadoEquipo2;
    }

    public byte getNúmeroJornada() {
        return númeroJornada;
    }

    public void setNúmeroJornada(byte númeroJornada) {
        this.númeroJornada = númeroJornada;
    }

    public Date getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    public byte getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(byte idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public String getNombreCompeticion() {
        return nombreCompeticion;
    }

    public void setNombreCompeticion(String nombreCompeticion) {
        this.nombreCompeticion = nombreCompeticion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VistaEnfrentamientosJornada that = (VistaEnfrentamientosJornada) o;

        if (idEnfrentamiento != that.idEnfrentamiento) return false;
        if (idEquipo1 != that.idEquipo1) return false;
        if (resultadoEquipo1 != that.resultadoEquipo1) return false;
        if (idEquipo2 != that.idEquipo2) return false;
        if (resultadoEquipo2 != that.resultadoEquipo2) return false;
        if (númeroJornada != that.númeroJornada) return false;
        if (idCompeticion != that.idCompeticion) return false;
        if (horaEnfrentamiento != null ? !horaEnfrentamiento.equals(that.horaEnfrentamiento) : that.horaEnfrentamiento != null)
            return false;
        if (fechaJornada != null ? !fechaJornada.equals(that.fechaJornada) : that.fechaJornada != null) return false;
        if (nombreCompeticion != null ? !nombreCompeticion.equals(that.nombreCompeticion) : that.nombreCompeticion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idEnfrentamiento;
        result = 31 * result + (horaEnfrentamiento != null ? horaEnfrentamiento.hashCode() : 0);
        result = 31 * result + (int) idEquipo1;
        result = 31 * result + (int) resultadoEquipo1;
        result = 31 * result + (int) idEquipo2;
        result = 31 * result + (int) resultadoEquipo2;
        result = 31 * result + (int) númeroJornada;
        result = 31 * result + (fechaJornada != null ? fechaJornada.hashCode() : 0);
        result = 31 * result + (int) idCompeticion;
        result = 31 * result + (nombreCompeticion != null ? nombreCompeticion.hashCode() : 0);
        return result;
    }
}
