package Modelo;

import java.sql.Date;

/**
 * Clase que representa al personal de un equipo deportivo.
 * Cada miembro del personal tiene un puesto, un nombre, una fecha de nacimiento, un sueldo y puede estar asociado a un equipo.
 *
 * @author Ibai, Zahir, Lorena
 * @version 1.0
 */
public class Staff {
    private int idStaff;
    private String puesto;
    private String nombre;
    private Date fechaNac;
    private double sueldo;
    private Equipo equipo;

    // Constructores

    /**
     * Constructor vacío de la clase Staff.
     * Crea una instancia de Staff sin inicializar sus atributos.
     */
    public Staff() {
    }

    /**
     * Constructor de la clase Staff con parámetros.
     * Crea una instancia de Staff con los atributos proporcionados.
     *
     * @param idStaff   Identificador único del miembro del personal.
     * @param puesto    El puesto del miembro del personal.
     * @param nombre    El nombre del miembro del personal.
     * @param fechaNac  La fecha de nacimiento del miembro del personal.
     * @param sueldo    El sueldo del miembro del personal.
     * @param equipo    El equipo al que está asociado el miembro del personal.
     */
    public Staff(int idStaff, String puesto, String nombre, Date fechaNac, double sueldo, Equipo equipo) {
        this.idStaff = idStaff;
        this.puesto = puesto;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sueldo = sueldo;
        this.equipo = equipo;
    }

    // Getters and Setters
    public int getIdStaff() {
        return idStaff;
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

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    // equals and hashCode

    /**
     * Compara este objeto con otro para determinar si son iguales.
     *
     * @param o El objeto con el que comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (idStaff != staff.idStaff) return false;
        if (Double.compare(staff.sueldo, sueldo) != 0) return false;
        if (puesto != null ? !puesto.equals(staff.puesto) : staff.puesto != null) return false;
        if (nombre != null ? !nombre.equals(staff.nombre) : staff.nombre != null) return false;
        return fechaNac != null ? fechaNac.equals(staff.fechaNac) : staff.fechaNac == null;
    }

    /**
     * Calcula el valor hash de este objeto.
     *
     * @return El valor hash del objeto.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idStaff;
        result = 31 * result + (puesto != null ? puesto.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fechaNac != null ? fechaNac.hashCode() : 0);
        temp = Double.doubleToLongBits(sueldo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
