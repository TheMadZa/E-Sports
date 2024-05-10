package Modelo;

import jakarta.persistence.*;

@Entity
public class Patrocinador {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PATROCINADOR")
    private int idPatrocinador;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(byte idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
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
        int result = idPatrocinador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    public Patrocinador() {
    }

    public Patrocinador(int idPatrocinador, String nombre) {
        this.idPatrocinador = idPatrocinador;
        this.nombre = nombre;
    }
}
