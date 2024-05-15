package Controlador.ControladoresVista;


import Controlador.ControladorPrincipal;

public class ControladorVista {

    //CONTROLADORES DE LAS VENTANAS
    private ControladorVI cvp;
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
        cvp = new ControladorVI(this);
        cvc = new ControladorVCompeticiones(this);
        cve = new ControladorVEquipos(this);
        cvjo = new ControladorVJornadas(this);
        cvjue = new ControladorVJuegos(this);
        cvjug = new ControladorVJugadores(this);
        cvpa = new ControladorVPatrocinadores(this);
        cvs = new ControladorVStaff(this);

        cvp.crearMostrar();
    }
}
