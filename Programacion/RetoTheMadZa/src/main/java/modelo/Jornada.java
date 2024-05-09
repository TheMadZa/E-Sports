package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Jornada {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_JORNADA")
    private byte idJornada;
    @Basic
    @Column(name = "NUM_JORNADA")
    private byte numJornada;
    @Basic
    @Column(name = "FECHA_JORNADA")
    private Date fechaJornada;
    @Basic
    @Column(name = "ID_COMPETICION")
    private byte idCompeticion;
    @OneToMany(mappedBy = "jornadaByIdJornada")
    private Collection<Enfrentamiento> enfrentamientosByIdJornada;
    @ManyToOne
    @JoinColumn(name = "ID_COMPETICION", referencedColumnName = "ID_COMPETICION", nullable = false)
    private Competicion competicionByIdCompeticion;

    public byte getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(byte idJornada) {
        this.idJornada = idJornada;
    }

    public byte getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(byte numJornada) {
        this.numJornada = numJornada;
    }

    public Date getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    public byte getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(byte idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jornada jornada = (Jornada) o;

        if (idJornada != jornada.idJornada) return false;
        if (numJornada != jornada.numJornada) return false;
        if (idCompeticion != jornada.idCompeticion) return false;
        if (fechaJornada != null ? !fechaJornada.equals(jornada.fechaJornada) : jornada.fechaJornada != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idJornada;
        result = 31 * result + (int) numJornada;
        result = 31 * result + (fechaJornada != null ? fechaJornada.hashCode() : 0);
        result = 31 * result + (int) idCompeticion;
        return result;
    }

    public Collection<Enfrentamiento> getEnfrentamientosByIdJornada() {
        return enfrentamientosByIdJornada;
    }

    public void setEnfrentamientosByIdJornada(Collection<Enfrentamiento> enfrentamientosByIdJornada) {
        this.enfrentamientosByIdJornada = enfrentamientosByIdJornada;
    }

    public Competicion getCompeticionByIdCompeticion() {
        return competicionByIdCompeticion;
    }

    public void setCompeticionByIdCompeticion(Competicion competicionByIdCompeticion) {
        this.competicionByIdCompeticion = competicionByIdCompeticion;
    }
}
