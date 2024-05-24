package Modelo;

/**
 * Esta clase representa la relación entre un equipo y una competición,
 * incluyendo el número de victorias y puntos obtenidos por el equipo en esa competición.
 *
 * @author Lorena, Ibai
 * @version 1.0
 */
public class EquipoCompeticion {

    private Equipo equipo;
    private Competicion competicion;
    private int victorias;
    private int puntos;

    /**
     * Constructor por defecto de la clase EquipoCompeticion.
     * Crea una instancia de EquipoCompeticion con valores predeterminados para los atributos.
     */
    // Constructores
    public EquipoCompeticion() {
    }

    /**
     * Constructor de la clase EquipoCompeticion.
     *
     * @param equipo      El equipo asociado a la competición.
     * @param competicion La competición en la que participa el equipo.
     * @param victorias   El número de victorias del equipo en la competición.
     * @param puntos      El número de puntos acumulados por el equipo en la competición.
     */
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

    /**
     * Compara esta relación de equipo y competición con otro objeto para verificar si son iguales.
     * Dos relaciones se consideran iguales si tienen el mismo equipo, la misma competición,
     * el mismo número de victorias y el mismo número de puntos.
     *
     * @param o Objeto a comparar con esta relación de equipo y competición.
     * @return true si el objeto dado es igual a esta relación, false de lo contrario.
     */
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
