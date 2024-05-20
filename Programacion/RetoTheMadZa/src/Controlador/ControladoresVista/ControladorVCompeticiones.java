package Controlador.ControladoresVista;

import Vista.VentanaClasificacion;
import Vista.VentanaInicial;

public class ControladorVCompeticiones {

    private VentanaClasificacion vc;
    private ControladorVista cv;

    public ControladorVCompeticiones(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(VentanaInicial vi) {

        vc = new VentanaClasificacion(vi);

        //

    }

}
