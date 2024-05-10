package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "EQUIPO_COMPETICION", schema = "EQDAW03")
@IdClass(EquipoCompeticionPK.class)
public class EquipoCompeticion {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO")
    private int idEquipo;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COMPETICION")
    private int idCompeticion;
    @Basic
    @Column(name = "VICTORIAS")
    private int victorias;
    @Basic
    @Column(name = "PUNTOS")
    private int puntos;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo;
    @ManyToOne
    @JoinColumn(name = "ID_COMPETICION", referencedColumnName = "ID_COMPETICION", nullable = false)
    private Competicion competicionByIdCompeticion;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(byte idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(Short victorias) {
        this.victorias = victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(Short puntos) {
        this.puntos = puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipoCompeticion that = (EquipoCompeticion) o;

        if (idEquipo != that.idEquipo) return false;
        if (idCompeticion != that.idCompeticion) return false;
        if (victorias != that.victorias) return false;
        if (puntos != that.puntos) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEquipo;
        result = 31 * result + idCompeticion;
        result = 31 * result + victorias;
        result = 31 * result + puntos;
        return result;
    }

    public Equipo getEquipoByIdEquipo() {
        return equipoByIdEquipo;
    }

    public void setEquipoByIdEquipo(Equipo equipoByIdEquipo) {
        this.equipoByIdEquipo = equipoByIdEquipo;
    }

    public Competicion getCompeticionByIdCompeticion() {
        return competicionByIdCompeticion;
    }

    public void setCompeticionByIdCompeticion(Competicion competicionByIdCompeticion) {
        this.competicionByIdCompeticion = competicionByIdCompeticion;
    }

    public EquipoCompeticion() {
    }

    public EquipoCompeticion(int idEquipo, int idCompeticion, int victorias, int puntos) {
        this.idEquipo = idEquipo;
        this.idCompeticion = idCompeticion;
        this.victorias = victorias;
        this.puntos = puntos;
    }
}
