package Controlador.ControladoresBD;

import Controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Modelo.*;


public class ControladorModelo {
    private ControladorCompeticiones cc;
    private ControladorEquipos ce;
    private ControladorJornadas cjo;
    private ControladorJuegos cjue;
    private ControladorJugadores cjug;
    private ControladorPatrocinadores cp;
    private ControladorStaff cs;
    private EntityManagerFactory emf;
    private EntityManager em;

    public ControladorModelo() {

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        cc = new ControladorCompeticiones(this);
        ce = new ControladorEquipos(this);
        cjo = new ControladorJornadas(this);
        cjue = new ControladorJuegos(this);
        cjug = new ControladorJugadores(this);
        cp = new ControladorPatrocinadores(this);
        cs = new ControladorStaff(this);
    }

    //COMPETICION
    public void insertarCompeticion(Competicion c) throws Exception {
        cc.insertarCompeticion(c);
    }

    public void borrarCompeticion() throws Exception{
        cc.borrarCompeticion();
    }

    public Competicion buscarCompeticion(Integer id_competicion) throws Exception {
        return cc.buscarCompeticion(id_competicion);
    }

    public Competicion buscarCompeticionNombre(String nombre) throws Exception {
        return cc.buscarCompeticionNombre(nombre);
    }

    public void modificarCompeticion(Competicion c) throws Exception{
        cc.modificarCompeticion(c);
    }


    //EQUIPO
    public void insertarEquipo(Equipo e) throws Exception {
        ce.insertarEquipo(e);
    }

    public void borrarEquipo() throws Exception{
        ce.borrarEquipo();
    }

    public Equipo buscarEquipo(Integer id_equipo) throws Exception {
        return ce.buscarEquipo(id_equipo);
    }

    public void modificarEquipo(Equipo e) throws Exception{
        ce.modificarEquipo(e);
    }


    //JORNADA
    public void insertarJornada(Jornada j) throws Exception {
        cjo.insertarJornada(j);
    }

    public void borrarJornada() throws Exception{
        cjo.borrarJornada();
    }

    public Jornada buscarJornada(Integer id_jornada) throws Exception {
        return cjo.buscarJornada(id_jornada);
    }

    public void modificarJornada(Jornada j) throws Exception{
        cjo.modificarJornada(j);
    }


    //JUEGO
    public void insertarJuego(Juego j) throws Exception {
        cjue.insertarJuego(j);
    }

    public void borrarJuego() throws Exception{
        cjue.borrarJuego();
    }

    public Juego buscarJuego(Integer id_juego) throws Exception {
        return cjue.buscarJuego(id_juego);
    }

    public void modificarJuego(Juego j) throws Exception{
        cjue.modificarJuego(j);
    }


    //JUGADOR
    public void insertarJugador(Jugador j) throws Exception {
        cjug.insertarJugador(j);
    }

    public void borrarJugador() throws Exception{
        cjug.borrarJugador();
    }

    public Jugador buscarJugador(Integer id_jugador) throws Exception {
        return cjug.buscarJugador(id_jugador);
    }

    public void modificarJugador(Jugador j) throws Exception{
        cjug.modificarJugador(j);
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
        cs.insertarStaff(s);
    }

    public void borrarStaff() throws Exception{
        cs.borrarStaff();
    }

    public Staff buscarStaff(Integer id_staff) throws Exception {
        return cs.buscarStaff(id_staff);
    }

    public void modificarStaff(Staff s) throws Exception{
        cs.modificarStaff(s);
    }
}
