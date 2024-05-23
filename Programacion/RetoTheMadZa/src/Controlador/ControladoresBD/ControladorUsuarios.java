package Controlador.ControladoresBD;

import Modelo.Equipo;
import Modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorUsuarios {

    private Connection con;
    private Equipo e;

    public ControladorUsuarios(Connection con) {
        this.con = con;
    }

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

}
