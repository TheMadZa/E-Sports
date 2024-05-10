package controlador.ControladoresVista;

import ;

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
