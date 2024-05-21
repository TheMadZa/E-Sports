package Controlador.ControladoresBD;

import Modelo.Equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}
