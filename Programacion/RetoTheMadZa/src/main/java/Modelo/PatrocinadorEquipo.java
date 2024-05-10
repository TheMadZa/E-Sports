package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "PATROCINADOR_EQUIPO", schema = "EQDAW03")
@IdClass(PatrocinadorEquipoPK.class)
public class PatrocinadorEquipo {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PATROCINADOR")
    private int idPatrocinador;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO")
    private int idEquipo;
    @ManyToOne
    @JoinColumn(name = "ID_PATROCINADOR", referencedColumnName = "ID_PATROCINADOR", nullable = false)
    private Patrocinador patrocinadorByIdPatrocinador;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo;

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(byte idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
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

    public Patrocinador getPatrocinadorByIdPatrocinador() {
        return patrocinadorByIdPatrocinador;
    }

    public void setPatrocinadorByIdPatrocinador(Patrocinador patrocinadorByIdPatrocinador) {
        this.patrocinadorByIdPatrocinador = patrocinadorByIdPatrocinador;
    }

    public Equipo getEquipoByIdEquipo() {
        return equipoByIdEquipo;
    }

    public void setEquipoByIdEquipo(Equipo equipoByIdEquipo) {
        this.equipoByIdEquipo = equipoByIdEquipo;
    }

    public PatrocinadorEquipo() {
    }

    public PatrocinadorEquipo(int idPatrocinador, int idEquipo) {
        this.idPatrocinador = idPatrocinador;
        this.idEquipo = idEquipo;
    }
}
