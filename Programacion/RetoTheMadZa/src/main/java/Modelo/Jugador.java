package Modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Jugador {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_JUGADOR")
    private byte idJugador;

    public byte getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(byte idJugador) {
        this.idJugador = idJugador;
    }

    @Basic
    @Column(name = "NOMBRE")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "NICKNAME")
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Basic
    @Column(name = "ROL")
    private String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Basic
    @Column(name = "FECHA_NAC")
    private Date fechaNac;

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Basic
    @Column(name = "SUELDO")
    private int sueldo;

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Basic
    @Column(name = "ID_EQUIPO")
    private byte idEquipo;

    public byte getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (idJugador != jugador.idJugador) return false;
        if (sueldo != jugador.sueldo) return false;
        if (idEquipo != jugador.idEquipo) return false;
        if (nombre != null ? !nombre.equals(jugador.nombre) : jugador.nombre != null) return false;
        if (nickname != null ? !nickname.equals(jugador.nickname) : jugador.nickname != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(jugador.nacionalidad) : jugador.nacionalidad != null)
            return false;
        if (rol != null ? !rol.equals(jugador.rol) : jugador.rol != null) return false;
        if (fechaNac != null ? !fechaNac.equals(jugador.fechaNac) : jugador.fechaNac != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idJugador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + (fechaNac != null ? fechaNac.hashCode() : 0);
        result = 31 * result + sueldo;
        result = 31 * result + (int) idEquipo;
        return result;
    }
}
