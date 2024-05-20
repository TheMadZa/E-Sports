package Controlador.ControladoresVista;

import Vista.VentanaInicial;
import Vista.VentanaInicioSesion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVIS {

    private VentanaInicioSesion vis;
    private ControladorVista cv;

    public ControladorVIS(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(VentanaInicial vi) {
        vis = new VentanaInicioSesion(vi);

        // Action Listeners de los botones y demás.
        vis.addBIniciarSesionAL(new BIniciarSesionAL());
        vis.addBRegistroAL(new BRegistroAL());

    }

    public class BIniciarSesionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarVAdmin(vis);
        }
    }

    public class BRegistroAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO : Aparecerá un dialog para meter los datos de un nuevo usuario (solo podrá ser "Normal) y se hará un insert.
            cv.mostrarDUsuario();
        }
    }

}
