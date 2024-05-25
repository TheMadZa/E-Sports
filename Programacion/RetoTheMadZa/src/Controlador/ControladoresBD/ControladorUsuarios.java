package Controlador.ControladoresBD;

import Modelo.Equipo;
import Modelo.Juego;
import Modelo.Usuario;

import java.sql.*;

/**
 * Clase ControladorUsuarios que gestiona las consultas sobre los usuarios.
 *
 * <p>Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los usuarios
 * en la base de datos.</p>
 *
 * @author Lorena
 * @version 1.0
 */
public class ControladorUsuarios {

    private Connection con;
    private Usuario u;

    /**
     * Constructor de la clase ControladorUsuarios.
     *
     * @param con Es la conexión con la base de datos que se ejecuta junto con el constructor.
     */
    public ControladorUsuarios(Connection con) {
        this.con = con;
    }

    /**
     * Función para validar un usuario obteniendo su tipo con su nombre y contraseña.
     *
     * @param usuario Es el nombre del usuario para validar si existe.
     * @param contrasena Es la contraseña que servirá para saber si esa es la contraseña del usuario.
     * @return Devuelve un valor boolean para saber si el usuario existe o no.
     * @throws Exception Si ocurre un error durante la validación.
     */
    public boolean validarUsuario(String usuario, String contrasena) throws Exception {

        try {

            boolean userAdmin;

            String plantilla = "SELECT tipo FROM usuarios WHERE nom_usuario = ? and contrasena = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setString(1,usuario);
            sentenciaPre.setString(2,contrasena);

            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next()) {
                String tipoUser = rs.getString("tipo");
                userAdmin = tipoUser.equals("A");
                /* Es lo mismo que:
                if (tipoUser.equals("A"))
                    userAdmin=true;
                else
                    userAdmin=false;
                 */
            }
            else {
                throw new Exception("No hay ningún usuario registrado con esos datos.");
            }
            sentenciaPre.close();
            return userAdmin;

        }
        catch (Exception e) {
            throw new Exception("Error de credenciales.");
        }

    }

    /**
     * Función para insertar un usuario pasándole todos sus valores.
     *
     * @param usuario Es el objeto usuario que vamos a insertar en la base de datos
     * @return Devuelve un valor boolean para saber si la inserción ha ido bien o no
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public boolean insertarUsuario(Usuario usuario) throws Exception {

        try {
            boolean insercionHecha;

            String plantilla = "INSERT INTO usuarios VALUES (?,?,?)";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);

            sentenciaPre.setString(1, usuario.getNomUsuario());
            sentenciaPre.setString(2, usuario.getContrasena());
            sentenciaPre.setString(3, usuario.getTipo());

            int n = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if (n != 1)
                throw new Exception("No se ha podido insertar el usuario.");
            else
                insercionHecha = true;

            return insercionHecha;
        }
        catch (SQLException ex) {
            throw new Exception("Error al insertar el usuario: " + ex.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Función para borrar un usuario pasandole su nombre.
     *
     * @param nomUsuario Es el nombre del usuario y sirve para identificar el usuario que queremos borrar
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarUsuario(String nomUsuario) throws Exception {
        PreparedStatement sentenciaPre = null;
        try {
            String plantilla = "DELETE FROM usuarios WHERE nom_usuario = ?";
            sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nomUsuario);
            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha podido eliminar ningún usuario.");
            }
        }
        catch (SQLException e) {
            throw new Exception("Error al borrar el usuario: " + e.getMessage());
        }
        finally {
            if (sentenciaPre != null) {
                try {
                    sentenciaPre.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Función para buscar datos sobre un usuario pasandole su nombre.
     *
     * @param nomUsuario Es el nombre del usuario que sirve para identificar el usuario que queremos buscar.
     * @return Se devuelve el objeto usuario con todos sus valores.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Usuario buscarUsuario(String nomUsuario) throws Exception {
        try {
            String plantilla = "SELECT * FROM usuarios WHERE nom_usuario = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nomUsuario);
            ResultSet rs = sentenciaPre.executeQuery();
            Usuario usuario = null;
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setTipo(rs.getString("tipo"));
            }
            else {
                throw new Exception("No hay ningún usuario registrado con ese nombre.");
            }
            sentenciaPre.close();
            return usuario;
        } catch (SQLException e) {
            throw new Exception("Error al buscar el usuario: " + e.getMessage());
        }
    }

    /**
     * Función para modificar uno o más datos sobre el usuario que identifiquemos con su nombre.
     *
     * @param usuario Es el objeto usuario del cual queremos actualizar uno o varios valores suyos buscandolo por nombre
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarUsuario(Usuario usuario) throws Exception {
        try {
            String plantilla = "UPDATE usuarios SET contrasena = ?, tipo = ? WHERE nom_usuario = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, usuario.getContrasena());
            sentenciaPre.setString(2, usuario.getTipo());
            sentenciaPre.setString(3, usuario.getNomUsuario());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n != 1) {
                throw new Exception("No se ha podido actualizar ningún usuario.");
            }
        } catch (SQLException e) {
            throw new Exception("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    // TODO : JAVADOC
    public Usuario buscarUsuarioPorNombre(String nombreUsuario) throws Exception {

        try {
            String plantilla = "SELECT nom_usuario, contrasena, tipo FROM usuarios WHERE UPPER(nom_usuario) = ?";

            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreUsuario.toUpperCase());
            ResultSet rs = sentenciaPre.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setNomUsuario(rs.getString("nom_usuario"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTipo(rs.getString("tipo"));
            }
            else {
                throw new Exception("No hay ningún usuario registrado con ese nombre.");
            }
            sentenciaPre.close();
            return u;
        }
        catch (Exception e) {
            throw new Exception("Error al buscar usuario por nombre.");
        }

    }

}
