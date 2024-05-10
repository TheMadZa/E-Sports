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

    public void crearMostrar() throws MalformedURLException {
        vi = new VentanaInicial();

        vi.setVisible(true);
    }
}
