package Modelo;

/**
 * Clase que representa la relación entre un patrocinador y un equipo en el sistema.
 * Esta clase asocia un patrocinador con un equipo.
 *
 * @author Ibai, Lorena
 * @version 1.0
 */
public class PatrocinadorEquipo {
    private Patrocinador patrocinador;
    private Equipo equipo;

    // Constructores

    /**
     * Constructor vacío de la clase PatrocinadorEquipo.
     * Crea una instancia de PatrocinadorEquipo sin inicializar sus atributos.
     */
    public PatrocinadorEquipo() {
    }

    /**
     * Constructor de la clase PatrocinadorEquipo con parámetros.
     * Crea una instancia de PatrocinadorEquipo con el patrocinador y el equipo proporcionados.
     *
     * @param patrocinador El patrocinador asociado al equipo.
     * @param equipo       El equipo asociado al patrocinador.
     */
    public PatrocinadorEquipo(Patrocinador patrocinador, Equipo equipo) {
        this.patrocinador = patrocinador;
        this.equipo = equipo;
    }

    // Getters and Setters
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
}
