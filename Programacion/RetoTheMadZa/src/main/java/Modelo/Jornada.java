package Modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Jornada {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_JORNADA")
    private int idJornada;
    @Basic
    @Column(name = "NUM_JORNADA")
    private int numJornada;
    @Basic
    @Column(name = "FECHA_JORNADA")
    private Date fechaJornada;
    @OneToMany(mappedBy = "jornadaByIdJornada")
    private Collection<Enfrentamiento> enfrentamientosByIdJornada;
    @ManyToOne
    @JoinColumn(name = "ID_COMPETICION", referencedColumnName = "ID_COMPETICION", nullable = false)
    private Competicion competicionByIdCompeticion;

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(byte idJornada) {
        this.idJornada = idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(byte numJornada) {
        this.numJornada = numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public Date getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jornada jornada = (Jornada) o;

        if (idJornada != jornada.idJornada) return false;
        if (numJornada != jornada.numJornada) return false;
        if (fechaJornada != null ? !fechaJornada.equals(jornada.fechaJornada) : jornada.fechaJornada != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJornada;
        result = 31 * result + numJornada;
        result = 31 * result + (fechaJornada != null ? fechaJornada.hashCode() : 0);
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
