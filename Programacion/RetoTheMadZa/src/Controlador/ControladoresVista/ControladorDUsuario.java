package Controlador.ControladoresVista;

import Modelo.Usuario;
import Vista.DialogoUsuario;
import Vista.VentanaInicial;
import Vista.VentanaInicioSesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorDUsuario {

    private DialogoUsuario du;
    private ControladorVista cv;

    public ControladorDUsuario(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        du = new DialogoUsuario();

        du.addButtonOkAL(new ButtonOkAL());
        du.addButtonCancelAL(new ButtonCancelAL());
    }

    // TODO : NO VA
    public class ButtonOkAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Usuario usuario = new Usuario(du.getTfUsuario(),du.getFtfContrasena(),"N");

                boolean insercionHecha = cv.insertarUsuario(usuario);

                if (insercionHecha)
                    du.dispose();

            }
            catch (Exception ex) {
                du.mostrarMensaje(ex.getMessage());
            }
        }
    }

    public class ButtonCancelAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            du.mostrarMensaje("Debe registrar un usuario.");
        }
    }

}
