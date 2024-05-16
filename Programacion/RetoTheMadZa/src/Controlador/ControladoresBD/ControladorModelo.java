package Controlador.ControladoresBD;

import Controlador.ControladorPrincipal;
import Modelo.*;

import java.util.List;

public class ControladorModelo {
    private final ControladorCompeticiones cc;
    private final ControladorEquipos ce;
    private final ControladorJornadas cjo;
    private final ControladorJuegos cjue;
    private final ControladorJugadores cjug;
    private final ControladorPatrocinadores cp;
    private final ControladorStaff cs;
    private final ControladorEquiposCompeticiones cec;

    public ControladorModelo(ControladorPrincipal c) {
        cc = new ControladorCompeticiones();
        ce = new ControladorEquipos();
        cjo = new ControladorJornadas();
        cjue = new ControladorJuegos();
        cjug = new ControladorJugadores();
        cp = new ControladorPatrocinadores();
        cs = new ControladorStaff();
        cec = new ControladorEquiposCompeticiones();

        System.out.println("ControladorModelo inicializado correctamente.");
    }

    //COMPETICION
    public void insertarCompeticion(Competicion c) throws Exception {
        cc.insertarCompeticion(c);
    }

    public void borrarCompeticion(Competicion c) throws Exception {
        cc.borrarCompeticion(c);
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

    public void modificarCompeticion(Competicion c) throws Exception {
        cc.modificarCompeticion(c);
    }

    //EQUIPO
    public void insertarEquipo(Equipo e) throws Exception {
        ce.insertarEquipo(e);
    }

    public void borrarEquipo(Equipo e) throws Exception {
        ce.borrarEquipo(e);
    }

    public Equipo buscarEquipo(Integer id_equipo) throws Exception {
        return ce.buscarEquipo(id_equipo);
    }

    public void modificarEquipo(Equipo e) throws Exception {
        ce.modificarEquipo(e);
    }

    //JORNADA
    public void insertarJornada(Jornada j) throws Exception {
        cjo.insertarJornada(j);
    }

    public void borrarJornada(Jornada j) throws Exception {
        cjo.borrarJornada(j);
    }

    public Jornada buscarJornada(Integer id_jornada) throws Exception {
        return cjo.buscarJornada(id_jornada);
    }

    public void modificarJornada(Jornada j) throws Exception {
        cjo.modificarJornada(j);
    }

    //JUEGO
    public void insertarJuego(Juego j) throws Exception {
        cjue.insertarJuego(j);
    }

    public void borrarJuego(Juego j) throws Exception {
        cjue.borrarJuego(j);
    }

    public Juego buscarJuego(Integer id_juego) throws Exception {
        return cjue.buscarJuego(id_juego);
    }

    public void modificarJuego(Juego j) throws Exception {
        cjue.modificarJuego(j);
    }

    //JUGADOR
    public void insertarJugador(Jugador j) throws Exception {
        cjug.insertarJugador(j);
    }

    public void borrarJugador(Jugador j) throws Exception {
        cjug.borrarJugador(j);
    }

    public Jugador buscarJugador(Integer id_jugador) throws Exception {
        return cjug.buscarJugador(id_jugador);
    }

    public void modificarJugador(Jugador j) throws Exception {
        cjug.modificarJugador(j);
    }

    //PATROCINADOR
    public void insertarPatrocinador(Patrocinador p) throws Exception {
        cp.insertarPatrocinador(p);
    }

    public void borrarPatrocinador(Patrocinador p) throws Exception {
        cp.borrarPatrocinador(p);
    }

    public Patrocinador buscarPatrocinador(Integer id_patrocinador) throws Exception {
        return cp.buscarPatrocinador(id_patrocinador);
    }

    public void modificarPatrocinador(Patrocinador p) throws Exception {
        cp.modificarPatrocinador(p);
    }

    //STAFF
    public void insertarStaff(Staff s) throws Exception {
        cs.insertarStaff(s);
    }

    public void borrarStaff(Staff s) throws Exception {
        cs.borrarStaff(s);
    }

    public Staff buscarStaff(Integer id_staff) throws Exception {
        return cs.buscarStaff(id_staff);
    }

    public void modificarStaff(Staff s) throws Exception {
        cs.modificarStaff(s);
    }

    //EQUIPO_COMPETICION
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        return cec.buscarTodosEquiposCompeticiones();
    }
}
