package Modelo;

public class EquipoCompeticion {

    private Equipo equipo;
    private Competicion competicion;
    private int victorias;
    private int puntos;

    // Constructors
    public EquipoCompeticion() {
    }

    public EquipoCompeticion(Equipo equipo, Competicion competicion, int victorias, int puntos) {
        this.equipo = equipo;
        this.competicion = competicion;
        this.victorias = victorias;
        this.puntos = puntos;
    }

    // Getters and Setters
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

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipoCompeticion that = (EquipoCompeticion) o;

        if (equipo != that.equipo) return false;
        if (competicion != that.competicion) return false;
        if (victorias != that.victorias) return false;
        return puntos == that.puntos;
    }
}
