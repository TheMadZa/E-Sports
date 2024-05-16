package Modelo;

public class Usuario {
    private String nomUsuario;
    private String contrasena;
    private String tipo;

    // Constructors
    public Usuario() {
    }

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (nomUsuario != null ? !nomUsuario.equals(usuario.nomUsuario) : usuario.nomUsuario != null) return false;
        if (contrasena != null ? !contrasena.equals(usuario.contrasena) : usuario.contrasena != null) return false;
        return tipo != null ? tipo.equals(usuario.tipo) : usuario.tipo == null;
    }

    @Override
    public int hashCode() {
        int result = nomUsuario != null ? nomUsuario.hashCode() : 0;
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }
}
