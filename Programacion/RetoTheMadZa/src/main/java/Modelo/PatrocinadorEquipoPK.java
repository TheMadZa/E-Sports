package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class PatrocinadorEquipoPK implements Serializable {
    @Column(name = "ID_PATROCINADOR")
    @Id
    private int idPatrocinador;
    @Column(name = "ID_EQUIPO")
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipo;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatrocinadorEquipoPK that = (PatrocinadorEquipoPK) o;

        if (idPatrocinador != that.idPatrocinador) return false;
        if (idEquipo != that.idEquipo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPatrocinador;
        result = 31 * result + idEquipo;
        return result;
    }
}
