package modelo;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Patrocinador {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PATROCINADOR")
    private byte idPatrocinador;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "patrocinadorByIdPatrocinador")
    private Collection<PatrocinadorEquipo> patrocinadorEquiposByIdPatrocinador;

    public byte getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(byte idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patrocinador that = (Patrocinador) o;

        if (idPatrocinador != that.idPatrocinador) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idPatrocinador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    public Collection<PatrocinadorEquipo> getPatrocinadorEquiposByIdPatrocinador() {
        return patrocinadorEquiposByIdPatrocinador;
    }

    public void setPatrocinadorEquiposByIdPatrocinador(Collection<PatrocinadorEquipo> patrocinadorEquiposByIdPatrocinador) {
        this.patrocinadorEquiposByIdPatrocinador = patrocinadorEquiposByIdPatrocinador;
    }
}
