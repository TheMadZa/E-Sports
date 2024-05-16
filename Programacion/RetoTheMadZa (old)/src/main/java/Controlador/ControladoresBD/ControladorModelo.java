package Controlador.ControladoresBD;

import Controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Modelo.*;

import java.util.List;

public class ControladorModelo {
    private ControladorCompeticiones cc;
    private final ControladorEquipos ce;
    private final ControladorJornadas cjo;
    private final ControladorJuegos cjue;
    private final ControladorJugadores cjug;
    private final ControladorPatrocinadores cp;
    private final ControladorStaff cs;
    private ControladorPrincipal c;
    private final ControladorEquiposCompeticiones cec;
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public ControladorModelo(ControladorPrincipal c) {
        this.c = c;

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        System.out.println("bien 1"); // TODO : QUITAR LOS "System.out.println"

        cc = new ControladorCompeticiones(em,transaction);
        System.out.println("bien 2");
        ce = new ControladorEquipos(em,transaction);
        System.out.println("bien 3");
        cjo = new ControladorJornadas(em,transaction);
        System.out.println("bien 4");
        cjue = new ControladorJuegos(em,transaction);
        System.out.println("bien 5");
        cjug = new ControladorJugadores(em,transaction);
        System.out.println("bien 6");
        cp = new ControladorPatrocinadores(em,transaction);
        System.out.println("bien 7");
        cs = new ControladorStaff(em,transaction);
        System.out.println("bien 8");
        cec = new ControladorEquiposCompeticiones(em,transaction);
        System.out.println("bien 9");
    }

    /*
    public void terminar() throws Exception{
        em.close();
        emf.close();
    }
    */

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

    public List<Competicion> buscarTodasCompeticiones() throws Exception {
        return cc.buscarTodasCompeticiones();
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

    //EQUIPO_COMPETICION
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        return cec.buscarTodosEquiposCompeticiones();
    }
}
