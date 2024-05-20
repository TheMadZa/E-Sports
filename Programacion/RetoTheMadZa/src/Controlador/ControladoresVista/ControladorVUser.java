package Controlador.ControladoresVista;

import Vista.VentanaInicioSesion;
import Vista.VentanaUser;

public class ControladorVUser {

    private VentanaUser vu;
    private ControladorVista cv;

    public ControladorVUser(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(VentanaInicioSesion vis) {
        vu = new VentanaUser(vis);

        //

    }

}
