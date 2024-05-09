package Modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Juego {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_JUEGO")
    private byte idJuego;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "EMPRESA")
    private String empresa;
    @Basic
    @Column(name = "FECHA_LANZAMIENTO")
    private Date fechaLanzamiento;
    @OneToMany(mappedBy = "juegoByIdJuego")
    private Collection<Competicion> competicionsByIdJuego;

    public byte getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(byte idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Juego juego = (Juego) o;

        if (idJuego != juego.idJuego) return false;
        if (nombre != null ? !nombre.equals(juego.nombre) : juego.nombre != null) return false;
        if (empresa != null ? !empresa.equals(juego.empresa) : juego.empresa != null) return false;
        if (fechaLanzamiento != null ? !fechaLanzamiento.equals(juego.fechaLanzamiento) : juego.fechaLanzamiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idJuego;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (empresa != null ? empresa.hashCode() : 0);
        result = 31 * result + (fechaLanzamiento != null ? fechaLanzamiento.hashCode() : 0);
        return result;
    }

    public Collection<Competicion> getCompeticionsByIdJuego() {
        return competicionsByIdJuego;
    }

    public void setCompeticionsByIdJuego(Collection<Competicion> competicionsByIdJuego) {
        this.competicionsByIdJuego = competicionsByIdJuego;
    }
}
