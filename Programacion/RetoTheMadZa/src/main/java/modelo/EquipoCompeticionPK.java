package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class EquipoCompeticionPK implements Serializable {
    @Column(name = "ID_EQUIPO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte idEquipo;
    @Column(name = "ID_COMPETICION")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte idCompeticion;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipoCompeticionPK that = (EquipoCompeticionPK) o;

        if (idEquipo != that.idEquipo) return false;
        if (idCompeticion != that.idCompeticion) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idEquipo;
        result = 31 * result + (int) idCompeticion;
        return result;
    }
}
