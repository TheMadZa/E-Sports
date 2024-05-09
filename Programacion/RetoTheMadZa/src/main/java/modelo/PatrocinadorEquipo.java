package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "PATROCINADOR_EQUIPO", schema = "EQDAW03", catalog = "")
@jakarta.persistence.IdClass(Modelo.PatrocinadorEquipoPK.class)
public class PatrocinadorEquipo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_PATROCINADOR")
    private int idPatrocinador;

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatrocinadorEquipo that = (PatrocinadorEquipo) o;

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
