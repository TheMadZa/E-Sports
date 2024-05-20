package Controlador.ControladoresVista;

import Vista.VentanaEquipos;
import Vista.VentanaInicial;

public class ControladorVEquipos {

    private VentanaEquipos ve;
    private ControladorVista cv;

    public ControladorVEquipos(ControladorVista cv)
    {
        this.cv = cv;
    }

    public void crearMostrar(VentanaInicial vi) {

        ve = new VentanaEquipos(vi);

        //

    }

}
