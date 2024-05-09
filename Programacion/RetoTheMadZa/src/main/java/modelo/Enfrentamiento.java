package modelo;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Enfrentamiento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_ENFRENTAMIENTO")
    private int idEnfrentamiento;

    public int getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(int idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    @Basic
    @Column(name = "HORA_ENFRENTAMIENTO")
    private Timestamp horaEnfrentamiento;

    public Timestamp getHoraEnfrentamiento() {
        return horaEnfrentamiento;
    }

    public void setHoraEnfrentamiento(Timestamp horaEnfrentamiento) {
        this.horaEnfrentamiento = horaEnfrentamiento;
    }

    @Basic
    @Column(name = "RESULTADO1")
    private byte resultado1;

    public byte getResultado1() {
        return resultado1;
    }

    public void setResultado1(byte resultado1) {
        this.resultado1 = resultado1;
    }

    @Basic
    @Column(name = "RESULTADO2")
    private byte resultado2;

    public byte getResultado2() {
        return resultado2;
    }

    public void setResultado2(byte resultado2) {
        this.resultado2 = resultado2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enfrentamiento that = (Enfrentamiento) o;

        if (idEnfrentamiento != that.idEnfrentamiento) return false;
        if (resultado1 != that.resultado1) return false;
        if (resultado2 != that.resultado2) return false;
        if (horaEnfrentamiento != null ? !horaEnfrentamiento.equals(that.horaEnfrentamiento) : that.horaEnfrentamiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEnfrentamiento;
        result = 31 * result + (horaEnfrentamiento != null ? horaEnfrentamiento.hashCode() : 0);
        result = 31 * result + (int) resultado1;
        result = 31 * result + (int) resultado2;
        return result;
    }
}
