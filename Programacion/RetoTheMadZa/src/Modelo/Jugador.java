package Modelo;

import java.sql.Date;

public class Jugador {
    private int idJugador;
    private String nombre;
    private String nickname;
    private String nacionalidad;
    private String rol;
    private Date fechaNac;
    private double sueldo;
    private Equipo equipo;

    // Constructors
    public Jugador() {
    }

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
