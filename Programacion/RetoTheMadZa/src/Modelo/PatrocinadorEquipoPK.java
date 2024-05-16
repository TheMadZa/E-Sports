package Modelo;

import java.io.Serializable;

public class PatrocinadorEquipoPK implements Serializable {
    private int idPatrocinador;
    private int idEquipo;

    // Constructors
    public PatrocinadorEquipoPK() {
    }

    public PatrocinadorEquipoPK(int idPatrocinador, int idEquipo) {
        this.idPatrocinador = idPatrocinador;
        this.idEquipo = idEquipo;
    }

    // Getters and Setters
    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatrocinadorEquipoPK that = (PatrocinadorEquipoPK) o;

        if (idPatrocinador != that.idPatrocinador) return false;
        return idEquipo == that.idEquipo;
    }

    @Override
    public int hashCode() {
        int result = idPatrocinador;
        result = 31 * result + idEquipo;
        return result;
    }
}
