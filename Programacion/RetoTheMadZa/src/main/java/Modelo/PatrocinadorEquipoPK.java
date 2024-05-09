package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class PatrocinadorEquipoPK implements Serializable {
    @Column(name = "ID_PATROCINADOR")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte idPatrocinador;
    @Column(name = "ID_EQUIPO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte idEquipo;

    public byte getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(byte idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public byte getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
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
        int result = (int) idPatrocinador;
        result = 31 * result + (int) idEquipo;
        return result;
    }
}
