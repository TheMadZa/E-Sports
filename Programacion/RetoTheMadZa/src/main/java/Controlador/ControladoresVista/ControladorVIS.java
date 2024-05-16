package Controlador.ControladoresVista;

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

    public void crearMostrar() {
        vis = new VentanaInicioSesion();

        // Action Listeners de los botones y demás.
        vis.addBIniciarSesionAL(new BIniciarSesionAL());
        vis.addBRegistroAL(new BRegistroAL());

        vis.setVisible(true);
        vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vis.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vis.setResizable(true);
    }

    public class BIniciarSesionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarVAdmin();
        }
    }

    public class BRegistroAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO : que aparezca un dialog para meter los datos de un nuevo usuario y se pueda hacer un insert
        }
    }

}
