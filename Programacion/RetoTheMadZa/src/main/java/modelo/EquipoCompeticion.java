package modelo;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "EQUIPO_COMPETICION", schema = "EQDAW03", catalog = "")
@IdClass(Modelo.EquipoCompeticionPK.class)
public class EquipoCompeticion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_EQUIPO")
    private int idEquipo;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_COMPETICION")
    private int idCompeticion;

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    @Basic
    @Column(name = "VICTORIAS")
    private int victorias;

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    @Basic
    @Column(name = "PUNTOS")
    private int puntos;

    public int getPuntos() {
        return puntos;
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
}
