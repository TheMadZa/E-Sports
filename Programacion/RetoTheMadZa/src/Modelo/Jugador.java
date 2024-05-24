package Modelo;

import java.sql.Date;

/**
 * Clase que representa un jugador en el sistema.
 * Cada jugador tiene un nombre, un apodo, una nacionalidad, un rol, una fecha de nacimiento,
 * un sueldo y pertenece a un equipo.
 *
 * @author Ibai, Lorena, Zahir
 * @version 1.0
 */
public class Jugador {
    private int idJugador;
    private String nombre;
    private String nickname;
    private String nacionalidad;
    private String rol;
    private Date fechaNac;
    private double sueldo;
    private Equipo equipo;

    // Constructores

    /**
     * Constructor vacío de la clase Jugador.
     * Crea una instancia de Jugador con valores predeterminados.
     */
    public Jugador() {
    }

    /**
     * Constructor de la clase Jugador con parámetros.
     *
     * @param idJugador   Identificador único del jugador.
     * @param nombre      Nombre completo del jugador.
     * @param nickname    Apodo del jugador.
     * @param nacionalidad Nacionalidad del jugador.
     * @param rol         Rol o posición del jugador en el equipo.
     * @param fechaNac    Fecha de nacimiento del jugador.
     * @param sueldo      Sueldo del jugador.
     * @param equipo      Equipo al que pertenece el jugador.
     */
    public Jugador(int idJugador, String nombre, String nickname, String nacionalidad, String rol, Date fechaNac,
                   double sueldo, Equipo equipo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.nickname = nickname;
        this.nacionalidad = nacionalidad;
        this.rol = rol;
        this.fechaNac = fechaNac;
        this.sueldo = sueldo;
        this.equipo = equipo;
    }

    // Getters and Setters
    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    // equals and hashCode

    /**
     * Compara este jugador con otro objeto para verificar si son iguales.
     * Dos jugadores se consideran iguales si tienen el mismo identificador,
     * el mismo nombre, el mismo apodo, la misma nacionalidad, el mismo rol,
     * la misma fecha de nacimiento y el mismo sueldo.
     *
     * @param o Objeto a comparar con este jugador.
     * @return true si el objeto dado es igual a este jugador, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (idJugador != jugador.idJugador) return false;
        if (Double.compare(jugador.sueldo, sueldo) != 0) return false;
        if (nombre != null ? !nombre.equals(jugador.nombre) : jugador.nombre != null) return false;
        if (nickname != null ? !nickname.equals(jugador.nickname) : jugador.nickname != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(jugador.nacionalidad) : jugador.nacionalidad != null)
            return false;
        if (rol != null ? !rol.equals(jugador.rol) : jugador.rol != null) return false;
        return fechaNac != null ? fechaNac.equals(jugador.fechaNac) : jugador.fechaNac == null;
    }

    /**
     * Calcula el código hash de este jugador.
     *
     * @return Código hash de este jugador.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idJugador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + (fechaNac != null ? fechaNac.hashCode() : 0);
        temp = Double.doubleToLongBits(sueldo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
