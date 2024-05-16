package Modelo;

public class EquipoCompeticion {

    private int idEquipo;
    private int idCompeticion;
    private int victorias;
    private int puntos;
    private Equipo equipo;
    private Competicion competicion;

    // Constructors
    public EquipoCompeticion() {
    }

    public EquipoCompeticion(int idEquipo, int idCompeticion, int victorias, int puntos) {
        this.idEquipo = idEquipo;
        this.idCompeticion = idCompeticion;
        this.victorias = victorias;
        this.puntos = puntos;
    }

    // Getters and Setters
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Competicion getCompeticion() {
        return competicion;
    }

    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipoCompeticion that = (EquipoCompeticion) o;

        if (idEquipo != that.idEquipo) return false;
        if (idCompeticion != that.idCompeticion) return false;
        if (victorias != that.victorias) return false;
        return puntos == that.puntos;
    }

    @Override
    public int hashCode() {
        int result = idEquipo;
        result = 31 * result + idCompeticion;
        result = 31 * result + victorias;
        result = 31 * result + puntos;
        return result;
    }
}
