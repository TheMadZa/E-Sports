package Modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Jugador {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_JUGADOR")
    private int idJugador;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "NICKNAME")
    private String nickname;
    @Basic
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Basic
    @Column(name = "ROL")
    private String rol;
    @Basic
    @Column(name = "FECHA_NAC")
    private Date fechaNac;
    @Basic
    @Column(name = "SUELDO")
    private double sueldo;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(byte idJugador) {
        this.idJugador = idJugador;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (idJugador != jugador.idJugador) return false;
        if (sueldo != jugador.sueldo) return false;
        if (nombre != null ? !nombre.equals(jugador.nombre) : jugador.nombre != null) return false;
        if (nickname != null ? !nickname.equals(jugador.nickname) : jugador.nickname != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(jugador.nacionalidad) : jugador.nacionalidad != null)
            return false;
        if (rol != null ? !rol.equals(jugador.rol) : jugador.rol != null) return false;
        if (fechaNac != null ? !fechaNac.equals(jugador.fechaNac) : jugador.fechaNac != null) return false;

        return true;
    }

    public Equipo getEquipoByIdEquipo() {
        return equipoByIdEquipo;
    }

    public void setEquipoByIdEquipo(Equipo equipoByIdEquipo) {
        this.equipoByIdEquipo = equipoByIdEquipo;
    }

    public Jugador() {
    }

    public Jugador(int idJugador, String nombre, String nickname, String nacionalidad, String rol, Date fechaNac,
                   double sueldo, Equipo equipoByIdEquipo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.nickname = nickname;
        this.nacionalidad = nacionalidad;
        this.rol = rol;
        this.fechaNac = fechaNac;
        this.sueldo = sueldo;
        this.equipoByIdEquipo = equipoByIdEquipo;
    }
}
