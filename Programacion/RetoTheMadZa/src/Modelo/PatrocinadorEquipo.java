package Modelo;

public class PatrocinadorEquipo {
    private Patrocinador patrocinador;
    private Equipo equipo;

    // Constructors
    public PatrocinadorEquipo() {
    }

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
