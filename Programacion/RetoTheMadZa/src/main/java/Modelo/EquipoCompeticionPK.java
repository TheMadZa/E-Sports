package Modelo;

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
    private int idEquipo;
    @Column(name = "ID_COMPETICION")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompeticion;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
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
        int result = idEquipo;
        result = 31 * result + idCompeticion;
        return result;
    }
}
