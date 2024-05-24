package Modelo;

import java.sql.Date;

/**
 * Clase que representa un juego en el sistema.
 * Un juego tiene un nombre, una empresa desarrolladora y una fecha de lanzamiento.
 *
 * @author Ibai, Lorena
 * @version 1.0
 */

public class Juego {
    private int idJuego;
    private String nombre;
    private String empresa;
    private Date fechaLanzamiento;

    // Constructores

    /**
     * Constructor vacío de la clase Juego.
     * Crea una instancia de Juego con valores predeterminados.
     */
    public Juego() {
    }

    /**
     * Constructor de la clase Juego con parámetros.
     *
     * @param idJuego          Identificador único del juego.
     * @param nombre           Nombre del juego.
     * @param empresa          Empresa desarrolladora del juego.
     * @param fechaLanzamiento Fecha de lanzamiento del juego.
     */
    public Juego(int idJuego, String nombre, String empresa, Date fechaLanzamiento) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.empresa = empresa;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    // Getters and Setters
    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    // equals and hashCode

    /**
     * Compara este juego con otro objeto para verificar si son iguales.
     * Dos juegos se consideran iguales si tienen el mismo identificador,
     * el mismo nombre, la misma empresa y la misma fecha de lanzamiento.
     *
     * @param o Objeto a comparar con este juego.
     * @return true si el objeto dado es igual a este juego, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Juego juego = (Juego) o;

        if (idJuego != juego.idJuego) return false;
        if (nombre != null ? !nombre.equals(juego.nombre) : juego.nombre != null) return false;
        if (empresa != null ? !empresa.equals(juego.empresa) : juego.empresa != null) return false;
        return fechaLanzamiento != null ? fechaLanzamiento.equals(juego.fechaLanzamiento) : juego.fechaLanzamiento == null;
    }

    /**
     * Calcula el código hash de este juego.
     *
     * @return Código hash de este juego.
     */
    @Override
    public int hashCode() {
        int result = idJuego;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (empresa != null ? empresa.hashCode() : 0);
        result = 31 * result + (fechaLanzamiento != null ? fechaLanzamiento.hashCode() : 0);
        return result;
    }
}
