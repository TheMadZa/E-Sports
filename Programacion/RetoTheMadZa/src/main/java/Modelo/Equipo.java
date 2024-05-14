package Modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Equipo {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO")
    private int idEquipo;
    @Basic
    @Column(name = "NOM_EQUIPO")
    private String nomEquipo;
    @Basic
    @Column(name = "FECHA_FUNDACION")
    private Date fechaFundacion;
    @Basic
    @Column(name = "LOGO")
    private String logo;
    @Basic
    @Column(name = "COLOR")
    private String color;
    @OneToMany(mappedBy = "equipoByIdEquipo")
    private Collection<Jugador> jugadorsByIdEquipo;
    @OneToMany(mappedBy = "equipoByIdEquipo")
    private Collection<Staff> entrenadorByIdEquipo;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (idEquipo != equipo.idEquipo) return false;
        if (nomEquipo != null ? !nomEquipo.equals(equipo.nomEquipo) : equipo.nomEquipo != null) return false;
        if (fechaFundacion != null ? !fechaFundacion.equals(equipo.fechaFundacion) : equipo.fechaFundacion != null)
            return false;
        if (logo != null ? !logo.equals(equipo.logo) : equipo.logo != null) return false;
        if (color != null ? !color.equals(equipo.color) : equipo.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEquipo;
        result = 31 * result + (nomEquipo != null ? nomEquipo.hashCode() : 0);
        result = 31 * result + (fechaFundacion != null ? fechaFundacion.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    public Collection<Jugador> getJugadorsByIdEquipo() {
        return jugadorsByIdEquipo;
    }

    public void setJugadorsByIdEquipo(Collection<Jugador> jugadorsByIdEquipo) {
        this.jugadorsByIdEquipo = jugadorsByIdEquipo;
    }

    public Collection<Staff> getEntrenadorByIdEquipo() {
        return entrenadorByIdEquipo;
    }

    public void setEntrenadorByIdEquipo(Collection<Staff> staffByIdEquipo) {
        this.entrenadorByIdEquipo = staffByIdEquipo;
    }

    public Equipo() {
    }

    public Equipo(int idEquipo, String nomEquipo, Date fechaFundacion, String logo, String color) {
        this.idEquipo = idEquipo;
        this.nomEquipo = nomEquipo;
        this.fechaFundacion = fechaFundacion;
        this.logo = logo;
        this.color = color;
    }

    public void setJugador(Jugador j){
        if (jugadorsByIdEquipo == null)
            jugadorsByIdEquipo = new ArrayList<>();
        jugadorsByIdEquipo.add(j);
    }

    public void setEntrenador(Staff s){
        if (entrenadorByIdEquipo == null)
            entrenadorByIdEquipo = new ArrayList<>();
        entrenadorByIdEquipo.add(s);
    }
}
