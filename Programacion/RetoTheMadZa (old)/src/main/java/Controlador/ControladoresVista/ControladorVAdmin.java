package Controlador.ControladoresVista;

import Vista.VentanaAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVAdmin {

    private VentanaAdmin va;
    private ControladorVista cv;

    public ControladorVAdmin(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        va = new VentanaAdmin();

        // Action Listeners de los botones y demás.
        va.addMiCrudAL(new MiCrudAL());
        va.addMiVisualizarJornadasAL(new MiVisualizarJornadasAL());
        va.addMiClasificacionJornadasAL(new MiClasificacionJornadasAL());
        va.addBAccionesAL(new BAccionesAL());
    }

    public class MiCrudAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
    public class MiVisualizarJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
    public class MiClasificacionJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
    public class BAccionesAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

}
