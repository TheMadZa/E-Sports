package Controlador.ControladoresVista;

import Vista.VentanaInicial;

import java.net.MalformedURLException;

public class ControladorVP {
    private VentanaInicial vi;
    private ControladorVista cv;

    public ControladorVP(ControladorVista cv)
    {
        this.cv = cv;
    }

    public void crearMostrar() {
        vi = new VentanaInicial();

        // TODO : aquí estarían los action listeners de los botones y demás.

        vi.setVisible(true);
    }
}
