package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "EQUIPO_COMPETICION", schema = "EQDAW03", catalog = "")
@IdClass(EquipoCompeticionPK.class)
public class EquipoCompeticion {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO")
    private byte idEquipo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COMPETICION")
    private byte idCompeticion;
    @Basic
    @Column(name = "VICTORIAS")
    private Short victorias;
    @Basic
    @Column(name = "PUNTOS")
    private Short puntos;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo;
    @ManyToOne
    @JoinColumn(name = "ID_COMPETICION", referencedColumnName = "ID_COMPETICION", nullable = false)
    private Competicion competicionByIdCompeticion;

    public byte getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    public byte getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(byte idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public Short getVictorias() {
        return victorias;
    }

    public void setVictorias(Short victorias) {
        this.victorias = victorias;
    }

    public Short getPuntos() {
        return puntos;
    }

    public void setPuntos(Short puntos) {
        this.puntos = puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipoCompeticion that = (EquipoCompeticion) o;

        if (idEquipo != that.idEquipo) return false;
        if (idCompeticion != that.idCompeticion) return false;
        if (victorias != null ? !victorias.equals(that.victorias) : that.victorias != null) return false;
        if (puntos != null ? !puntos.equals(that.puntos) : that.puntos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idEquipo;
        result = 31 * result + (int) idCompeticion;
        result = 31 * result + (victorias != null ? victorias.hashCode() : 0);
        result = 31 * result + (puntos != null ? puntos.hashCode() : 0);
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
}
