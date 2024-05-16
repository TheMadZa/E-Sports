package Modelo;

import java.sql.Date;

public class Competicion {

    private int idCompeticion;
    private String nombreCom;
    private Date fechaInicio;
    private Date fechaFin;
    private String etapa;
    private Juego juego;
    private Equipo equipoGanador;

    // Constructors
    public Competicion() {
    }

    public Competicion(int idCompeticion, String nombreCom, Date fechaInicio, Date fechaFin, String etapa,
                       Juego juego, Equipo equipoGanador) {
        this.idCompeticion = idCompeticion;
        this.nombreCom = nombreCom;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.etapa = etapa;
        this.juego = juego;
        this.equipoGanador = equipoGanador;
    }

    // Getters and Setters
    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public String getNombreCom() {
        return nombreCom;
    }

    public void setNombreCom(String nombreCom) {
        this.nombreCom = nombreCom;
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

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competicion that = (Competicion) o;

        if (idCompeticion != that.idCompeticion) return false;
        if (!nombreCom.equals(that.nombreCom)) return false;
        if (!fechaInicio.equals(that.fechaInicio)) return false;
        if (!fechaFin.equals(that.fechaFin)) return false;
        if (!etapa.equals(that.etapa)) return false;
        if (!juego.equals(that.juego)) return false;
        return equipoGanador.equals(that.equipoGanador);
    }

    @Override
    public int hashCode() {
        int result = idCompeticion;
        result = 31 * result + nombreCom.hashCode();
        result = 31 * result + fechaInicio.hashCode();
        result = 31 * result + fechaFin.hashCode();
        result = 31 * result + etapa.hashCode();
        result = 31 * result + juego.hashCode();
        result = 31 * result + equipoGanador.hashCode();
        return result;
    }
}
