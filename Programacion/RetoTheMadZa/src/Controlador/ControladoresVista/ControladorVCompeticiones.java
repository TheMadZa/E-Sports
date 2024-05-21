package Controlador.ControladoresVista;

import Vista.VentanaClasificacion;
import Vista.VentanaInicial;
import Vista.VentanaUser;

public class ControladorVCompeticiones {

    private VentanaClasificacion vc;
    private ControladorVista cv;

    public ControladorVCompeticiones(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(VentanaUser vu) {

        vc = new VentanaClasificacion(vu);

        //

    }

}
