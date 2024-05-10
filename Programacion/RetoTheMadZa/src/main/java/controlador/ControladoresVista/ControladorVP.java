package Controlador.ControladoresVista;

import Vista.VentanaInicial;

public class ControladorVP {
    private VentanaInicial vi;
    private ControladorVista cv;

    public ControladorVP(ControladorVista cv)
    {
        this.cv = cv;
    }

    public void crearMostrar()
    {
        vi = new VentanaInicial();

        vi.setVisible(true);
    }
}
