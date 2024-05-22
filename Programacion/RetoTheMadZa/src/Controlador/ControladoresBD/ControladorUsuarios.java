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
                throw new Exception("No hay ningun usuario con esos datos.");
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
                throw new Exception("No se ha insertado el usuario.");
            else
                insercionHecha = true;

            return insercionHecha;
        }
        catch (SQLException ex) {
            throw new Exception("Error al insertar la competición: " + ex.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

}
