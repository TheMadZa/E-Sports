package Controlador.ControladoresVista;

import Controlador.ControladorPrincipal;
import Modelo.*;

import java.util.List;

public class ControladorVista {

    //CONTROLADORES DE LAS VENTANAS
    private ControladorVI cvi;
    private ControladorVTienda cvt;
    private ControladorVIS cvis;
    private ControladorVAdmin cva;
    private ControladorVCompeticiones cvc;
    private ControladorVEquipos cve;
    private ControladorVJornadas cvjo;
    private ControladorVJuegos cvjue;
    private ControladorVJugadores cvjug;
    private ControladorVPatrocinadores cvpa;
    private ControladorVStaff cvs;

    private final ControladorPrincipal cp;

    public ControladorVista(ControladorPrincipal cp) {
        this.cp = cp;

        //Creación de los controladores de las ventanas

        cvi = new ControladorVI(this);
        cvt = new ControladorVTienda(this);
        cvis = new ControladorVIS(this);
        cva = new ControladorVAdmin(this);
        cvc = new ControladorVCompeticiones(this);
        cve = new ControladorVEquipos(this);
        cvjo = new ControladorVJornadas(this);
        cvjue = new ControladorVJuegos(this);
        cvjug = new ControladorVJugadores(this);
        cvpa = new ControladorVPatrocinadores(this);
        cvs = new ControladorVStaff(this);

        cvi.crearMostrar();
    }

    public void mostrarTienda(){
        cvt.crearMostrar();
    }

    public void mostrarInicioSesion(){
        cvis.crearMostrar();
    }

    public void mostrarVAdmin(){
        cva.crearMostrar();
    }

    //COMPETICION
    public void insertarCompeticion(Competicion c) throws Exception {
        cp.insertarCompeticion(c);
    }

    public void borrarCompeticion(int idCompeticion) throws Exception{
        cp.borrarCompeticion(idCompeticion);
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

    public void borrarEquipo(int idEquipo) throws Exception{
        cp.borrarEquipo(idEquipo);
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

    public void borrarJornada(Jornada j) throws Exception{
        cp.borrarJornada(j);
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

    public void borrarJuego(Juego j) throws Exception{
        cp.borrarJuego(j);
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

    public void borrarJugador(Jugador j) throws Exception{
        cp.borrarJugador(j);
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

    public void borrarPatrocinador(Patrocinador p) throws Exception{
        cp.borrarPatrocinador(p);
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

    public void borrarStaff(Staff s) throws Exception{
        cp.borrarStaff(s);
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

    //CONEXION
    public void cerrarConexion() throws Exception{
        cp.cerrarConexion();
    }
}
