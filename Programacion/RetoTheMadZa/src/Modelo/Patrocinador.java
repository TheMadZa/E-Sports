package Modelo;

/**
 * Clase que representa un patrocinador en el sistema.
 * Cada patrocinador tiene un identificador único y un nombre.
 *
 * @author Ibai, Lorena
 * @version 1.0
 */
public class Patrocinador {
    private int idPatrocinador;
    private String nombre;

    // Constructores

    /**
     * Constructor vacío de la clase Patrocinador.
     * Crea una instancia de Patrocinador con valores predeterminados.
     */
    public Patrocinador() {
    }

    /**
     * Constructor de la clase Patrocinador con parámetros.
     *
     * @param idPatrocinador Identificador único del patrocinador.
     * @param nombre         Nombre del patrocinador.
     */
    public Patrocinador(int idPatrocinador, String nombre) {
        this.idPatrocinador = idPatrocinador;
        this.nombre = nombre;
    }

    // Getters and Setters
    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // equals and hashCode

    /**
     * Compara este patrocinador con otro objeto para verificar si son iguales.
     * Dos patrocinadores se consideran iguales si tienen el mismo identificador y el mismo nombre.
     *
     * @param o Objeto a comparar con este patrocinador.
     * @return true si el objeto dado es igual a este patrocinador, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patrocinador that = (Patrocinador) o;

        if (idPatrocinador != that.idPatrocinador) return false;
        return nombre != null ? nombre.equals(that.nombre) : that.nombre == null;
    }

    /**
     * Calcula el código hash de este patrocinador.
     *
     * @return Código hash de este patrocinador.
     */
    @Override
    public int hashCode() {
        int result = idPatrocinador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
