package Modelo;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "EQUIPO_COMPETICION", schema = "EQDAW03", catalog = "")
@IdClass(Modelo.EquipoCompeticionPK.class)
public class EquipoCompeticion {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_EQUIPO")
    private byte idEquipo;

    public byte getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_COMPETICION")
    private byte idCompeticion;

    public byte getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(byte idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    @Basic
    @Column(name = "VICTORIAS")
    private Short victorias;

    public Short getVictorias() {
        return victorias;
    }

    public void setVictorias(Short victorias) {
        this.victorias = victorias;
    }

    @Basic
    @Column(name = "PUNTOS")
    private Short puntos;

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
}
