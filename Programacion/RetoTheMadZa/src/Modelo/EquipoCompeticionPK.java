package Modelo;

import java.io.Serializable;

public class EquipoCompeticionPK implements Serializable {
    private int idEquipo;
    private int idCompeticion;

    // Constructors
    public EquipoCompeticionPK() {
    }

    public EquipoCompeticionPK(int idEquipo, int idCompeticion) {
        this.idEquipo = idEquipo;
        this.idCompeticion = idCompeticion;
    }

    // Getters and Setters
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

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipoCompeticionPK that = (EquipoCompeticionPK) o;

        if (idEquipo != that.idEquipo) return false;
        return idCompeticion == that.idCompeticion;
    }

    @Override
    public int hashCode() {
        int result = idEquipo;
        result = 31 * result + idCompeticion;
        return result;
    }
}
