package controlador.ControladoresVista;

import controlador.ControladorPrincipal;

public class ControladorVista {

    //CONTROLADORES DE LAS VENTANAS
    private ControladorVP cvp;
    private ControladorVCompeticiones cvc;
    private ControladorVEquipos cve;
    private ControladorVJornadas cvjo;
    private ControladorVJuegos cvjue;
    private ControladorVJugadores cvjug;
    private ControladorVPatrocinadores cvpa;
    private ControladorVStaff cvs;

    private ControladorPrincipal cp;

    public ControladorVista(ControladorPrincipal cp) {
        this.cp = cp;

        //Creación de los controladores de las ventanas
        cvp = new ControladorVP(this);
        cvc = new ControladorVCompeticiones();
        cve = new ControladorVEquipos();
        cvjo = new ControladorVJornadas();
        cvjue = new ControladorVJuegos();
        cvjug = new ControladorVJugadores();
        cvpa = new ControladorVPatrocinadores();
        cvs = new ControladorVStaff();

        //cvp.crearMostrar();
    }
}
