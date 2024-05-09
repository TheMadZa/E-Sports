package Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "VISTA_EQUIPOS_COMPETICION", schema = "EQDAW03", catalog = "")
public class VistaEquiposCompeticion {
    @Basic
    @Column(name = "NOMBRE_JUEGO")
    private String nombreJuego;
    @Basic
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;
    @Basic
    @Column(name = "FECHA_FIN")
    private Date fechaFin;
    @Basic
    @Column(name = "NOMBRE_EQUIPO")
    private String nombreEquipo;
    @Basic
    @Column(name = "NOMBRE_STAFF")
    private String nombreStaff;
    @Basic
    @Column(name = "NUMERO_JUGADORES")
    private BigInteger numeroJugadores;

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreStaff() {
        return nombreStaff;
    }

    public void setNombreStaff(String nombreStaff) {
        this.nombreStaff = nombreStaff;
    }

    public BigInteger getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(BigInteger numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VistaEquiposCompeticion that = (VistaEquiposCompeticion) o;

        if (nombreJuego != null ? !nombreJuego.equals(that.nombreJuego) : that.nombreJuego != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (nombreEquipo != null ? !nombreEquipo.equals(that.nombreEquipo) : that.nombreEquipo != null) return false;
        if (nombreStaff != null ? !nombreStaff.equals(that.nombreStaff) : that.nombreStaff != null) return false;
        if (numeroJugadores != null ? !numeroJugadores.equals(that.numeroJugadores) : that.numeroJugadores != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombreJuego != null ? nombreJuego.hashCode() : 0;
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (nombreEquipo != null ? nombreEquipo.hashCode() : 0);
        result = 31 * result + (nombreStaff != null ? nombreStaff.hashCode() : 0);
        result = 31 * result + (numeroJugadores != null ? numeroJugadores.hashCode() : 0);
        return result;
    }
}
