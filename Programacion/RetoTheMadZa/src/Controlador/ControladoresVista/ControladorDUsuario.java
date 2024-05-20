package Controlador.ControladoresVista;

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

        //

    }

}
