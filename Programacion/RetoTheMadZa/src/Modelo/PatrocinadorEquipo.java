package Modelo;

public class PatrocinadorEquipo {
    private int idPatrocinador;
    private int idEquipo;
    private Patrocinador patrocinador;
    private Equipo equipo;

    // Constructors
    public PatrocinadorEquipo() {
    }

    public PatrocinadorEquipo(int idPatrocinador, int idEquipo) {
        this.idPatrocinador = idPatrocinador;
        this.idEquipo = idEquipo;
    }

    // Getters and Setters
    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatrocinadorEquipo that = (PatrocinadorEquipo) o;

        if (idPatrocinador != that.idPatrocinador) return false;
        return idEquipo == that.idEquipo;
    }

    @Override
    public int hashCode() {
        int result = idPatrocinador;
        result = 31 * result + idEquipo;
        return result;
    }
}
