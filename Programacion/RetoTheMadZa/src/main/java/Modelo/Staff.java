package Modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Staff {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_STAFF")
    private int idStaff;
    @Basic
    @Column(name = "PUESTO")
    private String puesto;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "FECHA_NAC")
    private Date fechaNac;
    @Basic
    @Column(name = "SUELDO")
    private int sueldo;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equipoByIdEquipo;

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(byte idStaff) {
        this.idStaff = idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (idStaff != staff.idStaff) return false;
        if (sueldo != staff.sueldo) return false;
        if (puesto != null ? !puesto.equals(staff.puesto) : staff.puesto != null) return false;
        if (nombre != null ? !nombre.equals(staff.nombre) : staff.nombre != null) return false;
        if (fechaNac != null ? !fechaNac.equals(staff.fechaNac) : staff.fechaNac != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStaff;
        result = 31 * result + (puesto != null ? puesto.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fechaNac != null ? fechaNac.hashCode() : 0);
        result = 31 * result + sueldo;
        return result;
    }

    public Equipo getEquipoByIdEquipo() {
        return equipoByIdEquipo;
    }

    public void setEquipoByIdEquipo(Equipo equipoByIdEquipo) {
        this.equipoByIdEquipo = equipoByIdEquipo;
    }
}
