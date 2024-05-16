package Controlador.ControladoresVista;


import Controlador.ControladorPrincipal;
import Modelo.*;

import java.util.List;

public class ControladorVista {

    //CONTROLADORES DE LAS VENTANAS
    private ControladorVI cvi;
    private ControladorVIS cvis;
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
        cvi = new ControladorVI(this);
        cvis = new ControladorVIS(this);
        cvc = new ControladorVCompeticiones(this);
        cve = new ControladorVEquipos(this);
        cvjo = new ControladorVJornadas(this);
        cvjue = new ControladorVJuegos(this);
        cvjug = new ControladorVJugadores(this);
        cvpa = new ControladorVPatrocinadores(this);
        cvs = new ControladorVStaff(this);

        cvi.crearMostrar();
    }

    public void mostrarInicioSesion(){
        cvis.crearMostrar();
    }



    //COMPETICION
    public void insertarCompeticion(Competicion c) throws Exception {
        cp.insertarCompeticion(c);
    }

    public void borrarCompeticion() throws Exception{
        cp.borrarCompeticion();
    }

    public Competicion buscarCompeticion(Integer id_competicion) throws Exception {
        return cp.buscarCompeticion(id_competicion);
    }

    public Competicion buscarCompeticionNombre(String nombre) throws Exception {
        return cp.buscarCompeticionNombre(nombre);
    }

    public List<Competicion> buscarTodasCompeticiones() throws Exception {
        return cp.buscarTodasCompeticiones();
    }

    public void modificarCompeticion(Competicion c) throws Exception{
        cp.modificarCompeticion(c);
    }


    //EQUIPO
    public void insertarEquipo(Equipo e) throws Exception {
        cp.insertarEquipo(e);
    }

    public void borrarEquipo() throws Exception{
        cp.borrarEquipo();
    }

    public Equipo buscarEquipo(Integer id_equipo) throws Exception {
        return cp.buscarEquipo(id_equipo);
    }

    public void modificarEquipo(Equipo e) throws Exception{
        cp.modificarEquipo(e);
    }


    //JORNADA
    public void insertarJornada(Jornada j) throws Exception {
        cp.insertarJornada(j);
    }

    public void borrarJornada() throws Exception{
        cp.borrarJornada();
    }

    public Jornada buscarJornada(Integer id_jornada) throws Exception {
        return cp.buscarJornada(id_jornada);
    }

    public void modificarJornada(Jornada j) throws Exception{
        cp.modificarJornada(j);
    }


    //JUEGO
    public void insertarJuego(Juego j) throws Exception {
        cp.insertarJuego(j);
    }

    public void borrarJuego() throws Exception{
        cp.borrarJuego();
    }

    public Juego buscarJuego(Integer id_juego) throws Exception {
        return cp.buscarJuego(id_juego);
    }

    public void modificarJuego(Juego j) throws Exception{
        cp.modificarJuego(j);
    }


    //JUGADOR
    public void insertarJugador(Jugador j) throws Exception {
        cp.insertarJugador(j);
    }

    public void borrarJugador() throws Exception{
        cp.borrarJugador();
    }

    public Jugador buscarJugador(Integer id_jugador) throws Exception {
        return cp.buscarJugador(id_jugador);
    }

    public void modificarJugador(Jugador j) throws Exception{
        cp.modificarJugador(j);
    }


    //PATROCINADOR
    public void insertarPatrocinador(Patrocinador p) throws Exception {
        cp.insertarPatrocinador(p);
    }

    public void borrarPatrocinador() throws Exception{
        cp.borrarPatrocinador();
    }

    public Patrocinador buscarPatrocinador(Integer id_patrocinador) throws Exception {
        return cp.buscarPatrocinador(id_patrocinador);
    }

    public void modificarPatrocinador(Patrocinador p) throws Exception{
        cp.modificarPatrocinador(p);
    }


    //STAFF
    public void insertarStaff(Staff s) throws Exception {
        cp.insertarStaff(s);
    }

    public void borrarStaff() throws Exception{
        cp.borrarStaff();
    }

    public Staff buscarStaff(Integer id_staff) throws Exception {
        return cp.buscarStaff(id_staff);
    }

    public void modificarStaff(Staff s) throws Exception{
        cp.modificarStaff(s);
    }

    //EQUIPO_COMPETICION
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        return cp.buscarTodosEquiposCompeticiones();
    }

}
