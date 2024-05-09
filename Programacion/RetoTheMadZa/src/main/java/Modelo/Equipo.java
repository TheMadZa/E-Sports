package Modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Equipo {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO")
    private byte idEquipo;
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
    @OneToMany(mappedBy = "equipoByIdEquipoGanador")
    private Collection<Competicion> competicionsByIdEquipo;
    @OneToMany(mappedBy = "equipoByIdEquipo1")
    private Collection<Enfrentamiento> enfrentamientosByIdEquipo;
    @OneToMany(mappedBy = "equipoByIdEquipo2")
    private Collection<Enfrentamiento> enfrentamientosByIdEquipo_0;
    @OneToMany(mappedBy = "equipoByIdEquipo")
    private Collection<EquipoCompeticion> equipoCompeticionsByIdEquipo;
    @OneToMany(mappedBy = "equipoByIdEquipo")
    private Collection<Jugador> jugadorsByIdEquipo;
    @OneToMany(mappedBy = "equipoByIdEquipo")
    private Collection<PatrocinadorEquipo> patrocinadorEquiposByIdEquipo;
    @OneToMany(mappedBy = "equipoByIdEquipo")
    private Collection<Staff> staffByIdEquipo;

    public byte getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
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
        int result = (int) idEquipo;
        result = 31 * result + (nomEquipo != null ? nomEquipo.hashCode() : 0);
        result = 31 * result + (fechaFundacion != null ? fechaFundacion.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    public Collection<Competicion> getCompeticionsByIdEquipo() {
        return competicionsByIdEquipo;
    }

    public void setCompeticionsByIdEquipo(Collection<Competicion> competicionsByIdEquipo) {
        this.competicionsByIdEquipo = competicionsByIdEquipo;
    }

    public Collection<Enfrentamiento> getEnfrentamientosByIdEquipo() {
        return enfrentamientosByIdEquipo;
    }

    public void setEnfrentamientosByIdEquipo(Collection<Enfrentamiento> enfrentamientosByIdEquipo) {
        this.enfrentamientosByIdEquipo = enfrentamientosByIdEquipo;
    }

    public Collection<Enfrentamiento> getEnfrentamientosByIdEquipo_0() {
        return enfrentamientosByIdEquipo_0;
    }

    public void setEnfrentamientosByIdEquipo_0(Collection<Enfrentamiento> enfrentamientosByIdEquipo_0) {
        this.enfrentamientosByIdEquipo_0 = enfrentamientosByIdEquipo_0;
    }

    public Collection<EquipoCompeticion> getEquipoCompeticionsByIdEquipo() {
        return equipoCompeticionsByIdEquipo;
    }

    public void setEquipoCompeticionsByIdEquipo(Collection<EquipoCompeticion> equipoCompeticionsByIdEquipo) {
        this.equipoCompeticionsByIdEquipo = equipoCompeticionsByIdEquipo;
    }

    public Collection<Jugador> getJugadorsByIdEquipo() {
        return jugadorsByIdEquipo;
    }

    public void setJugadorsByIdEquipo(Collection<Jugador> jugadorsByIdEquipo) {
        this.jugadorsByIdEquipo = jugadorsByIdEquipo;
    }

    public Collection<PatrocinadorEquipo> getPatrocinadorEquiposByIdEquipo() {
        return patrocinadorEquiposByIdEquipo;
    }

    public void setPatrocinadorEquiposByIdEquipo(Collection<PatrocinadorEquipo> patrocinadorEquiposByIdEquipo) {
        this.patrocinadorEquiposByIdEquipo = patrocinadorEquiposByIdEquipo;
    }

    public Collection<Staff> getStaffByIdEquipo() {
        return staffByIdEquipo;
    }

    public void setStaffByIdEquipo(Collection<Staff> staffByIdEquipo) {
        this.staffByIdEquipo = staffByIdEquipo;
    }
}
