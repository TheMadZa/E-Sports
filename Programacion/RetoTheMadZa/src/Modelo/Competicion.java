package Modelo;

import java.sql.Date;

/**
 * Clase que representa una competición en el sistema.
 * Una competición es un evento deportivo en el que varios equipos compiten entre sí
 * siguiendo un conjunto de reglas establecidas.
 *
 * @author Ibai, Lorena
 * @version 1.0
 */
public class Competicion {

    private int idCompeticion;
    private String nombreCom;
    private Date fechaInicio;
    private Date fechaFin;
    private String etapa;
    private Juego juego;
    private Equipo equipoGanador;

    /**
     * Constructor vacío de la clase Competicion.
     * Crea una instancia de Competicion con valores predeterminados.
     */
    // Constructores
    public Competicion() {
    }

    /**
     * Constructor de la clase Competicion con parámetros.
     * Crea una instancia de Competicion con los valores proporcionados.
     *
     * @param idCompeticion Identificador único de la competición.
     * @param nombreCom     Nombre de la competición.
     * @param fechaInicio   Fecha de inicio de la competición.
     * @param fechaFin      Fecha de fin de la competición.
     * @param etapa         Etapa actual de la competición.
     * @param juego         Juego asociado a la competición.
     * @param equipoGanador Equipo ganador de la competición (puede ser null si no se ha determinado aún).
     */
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

    /**
     * Compara esta competición con otro objeto para verificar si son iguales.
     * Dos competiciones se consideran iguales si tienen el mismo identificador de competición,
     * el mismo nombre, la misma fecha de inicio, la misma fecha de fin, la misma etapa, el mismo juego
     * y el mismo equipo ganador.
     *
     * @param o Objeto a comparar con esta competición.
     * @return true si el objeto dado es igual a esta competición, false de lo contrario.
     */
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

    /**
     * Calcula el código hash para esta competición.
     *
     * @return El código hash calculado para esta competición.
     */
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
