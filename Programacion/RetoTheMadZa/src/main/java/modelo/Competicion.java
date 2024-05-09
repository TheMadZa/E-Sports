package modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Competicion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_COMPETICION")
    private int idCompeticion;

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    @Basic
    @Column(name = "NOMBRE_COM")
    private String nombreCom;

    public String getNombreCom() {
        return nombreCom;
    }

    public void setNombreCom(String nombreCom) {
        this.nombreCom = nombreCom;
    }

    @Basic
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "FECHA_FIN")
    private Date fechaFin;

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "ETAPA")
    private String etapa;

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competicion that = (Competicion) o;

        if (idCompeticion != that.idCompeticion) return false;
        if (nombreCom != null ? !nombreCom.equals(that.nombreCom) : that.nombreCom != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (etapa != null ? !etapa.equals(that.etapa) : that.etapa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompeticion;
        result = 31 * result + (nombreCom != null ? nombreCom.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (etapa != null ? etapa.hashCode() : 0);
        return result;
    }
}
