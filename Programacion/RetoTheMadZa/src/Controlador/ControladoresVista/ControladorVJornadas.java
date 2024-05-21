package Controlador.ControladoresVista;

import Vista.VentanaInicial;
import Vista.VentanaJornadas;
import Vista.VentanaUser;

public class ControladorVJornadas {

    private VentanaJornadas vj;
    private ControladorVista cv;

    public ControladorVJornadas(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(VentanaUser vu) {

        vj = new VentanaJornadas(vu);

        //

    }

}
