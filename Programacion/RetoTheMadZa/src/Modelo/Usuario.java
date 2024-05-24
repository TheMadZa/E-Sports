package Modelo;

/**
 * Clase que representa a un usuario del sistema.
 * Cada usuario tiene un nombre de usuario, una contraseña y un tipo de usuario.
 *
 * @author Ibai
 * @version 1.0
 */
public class Usuario {
    private String nomUsuario;
    private String contrasena;
    private String tipo;

    // Constructores

    /**
     * Constructor vacío de la clase Usuario.
     * Crea una instancia de Usuario sin inicializar sus atributos.
     */
    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario con parámetros.
     * Crea una instancia de Usuario con los atributos proporcionados.
     *
     * @param nomUsuario El nombre de usuario.
     * @param contrasena La contraseña.
     * @param tipo       El tipo de usuario.
     */
    public Usuario(String nomUsuario, String contrasena, String tipo) {
        this.nomUsuario = nomUsuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    // Getters and Setters
    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

        Usuario usuario = (Usuario) o;

        if (nomUsuario != null ? !nomUsuario.equals(usuario.nomUsuario) : usuario.nomUsuario != null) return false;
        if (contrasena != null ? !contrasena.equals(usuario.contrasena) : usuario.contrasena != null) return false;
        return tipo != null ? tipo.equals(usuario.tipo) : usuario.tipo == null;
    }

    /**
     * Calcula el valor hash de este objeto.
     *
     * @return El valor hash del objeto.
     */
    @Override
    public int hashCode() {
        int result = nomUsuario != null ? nomUsuario.hashCode() : 0;
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }
}
