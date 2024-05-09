package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "PATROCINADOR_EQUIPO", schema = "EQDAW03", catalog = "")
@IdClass(PatrocinadorEquipoPK.class)
public class PatrocinadorEquipo {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PATROCINADOR")
    private byte idPatrocinador;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO")
    private byte idEquipo;
    @ManyToOne
    @JoinColumn(name = "ID_PATROCINADOR", referencedColumnName = "ID_PATROCINADOR", nullable = false)
    private Patrocinador patrocinadorByIdPatrocinador;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo;

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

        PatrocinadorEquipo that = (PatrocinadorEquipo) o;

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
}
