package Controlador.ControladoresVista;

import Vista.VentanaInicial;
import Vista.VentanaJornadas;

public class ControladorVJornadas {

    private VentanaJornadas vj;
    private ControladorVista cv;

    public ControladorVJornadas(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(VentanaInicial vi) {

        vj = new VentanaJornadas(vi);

        //

    }

}
