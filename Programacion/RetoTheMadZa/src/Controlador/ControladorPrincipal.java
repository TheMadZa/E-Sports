package Controlador;

import Controlador.ControladoresBD.ControladorModelo;
import Controlador.ControladoresVista.ControladorVista;
import Modelo.*;

import java.util.List;

public class ControladorPrincipal {
    private final ControladorModelo cm;

    public ControladorPrincipal() {
        ControladorVista cv = new ControladorVista(this);
        cm = new ControladorModelo(this);
    }

    //COMPETICION
    public void insertarCompeticion(Competicion c) throws Exception {
        cm.insertarCompeticion(c);
    }

    public void borrarCompeticion(Competicion c) throws Exception {
        cm.borrarCompeticion(c);
    }

    public Competicion buscarCompeticion(Integer id_competicion) throws Exception {
        return cm.buscarCompeticion(id_competicion);
    }

    public Competicion buscarCompeticionNombre(String nombre) throws Exception {
        return cm.buscarCompeticionNombre(nombre);
    }

    public List<Competicion> buscarTodasCompeticiones() throws Exception {
        return cm.buscarTodasCompeticiones();
    }

    public void modificarCompeticion(Competicion c) throws Exception {
        cm.modificarCompeticion(c);
    }

    //EQUIPO
    public void insertarEquipo(Equipo e) throws Exception {
        cm.insertarEquipo(e);
    }

    public void borrarEquipo(Equipo e) throws Exception {
        cm.borrarEquipo(e);
    }

    public Equipo buscarEquipo(Integer id_equipo) throws Exception {
        return cm.buscarEquipo(id_equipo);
    }

    public void modificarEquipo(Equipo e) throws Exception {
        cm.modificarEquipo(e);
    }

    //JORNADA
    public void insertarJornada(Jornada j) throws Exception {
        cm.insertarJornada(j);
    }

    public void borrarJornada(Jornada j) throws Exception {
        cm.borrarJornada(j);
    }

    public Jornada buscarJornada(Integer id_jornada) throws Exception {
        return cm.buscarJornada(id_jornada);
    }

    public void modificarJornada(Jornada j) throws Exception {
        cm.modificarJornada(j);
    }

    //JUEGO
    public void insertarJuego(Juego j) throws Exception {
        cm.insertarJuego(j);
    }

    public void borrarJuego(Juego j) throws Exception {
        cm.borrarJuego(j);
    }

    public Juego buscarJuego(Integer id_juego) throws Exception {
        return cm.buscarJuego(id_juego);
    }

    public void modificarJuego(Juego j) throws Exception {
        cm.modificarJuego(j);
    }

    //JUGADOR
    public void insertarJugador(Jugador j) throws Exception {
        cm.insertarJugador(j);
    }

    public void borrarJugador(Jugador j) throws Exception {
        cm.borrarJugador(j);
    }

    public Jugador buscarJugador(Integer id_jugador) throws Exception {
        return cm.buscarJugador(id_jugador);
    }

    public void modificarJugador(Jugador j) throws Exception {
        cm.modificarJugador(j);
    }

    //PATROCINADOR
    public void insertarPatrocinador(Patrocinador p) throws Exception {
        cm.insertarPatrocinador(p);
    }

    public void borrarPatrocinador(Patrocinador p) throws Exception {
        cm.borrarPatrocinador(p);
    }

    public Patrocinador buscarPatrocinador(Integer id_patrocinador) throws Exception {
        return cm.buscarPatrocinador(id_patrocinador);
    }

    public void modificarPatrocinador(Patrocinador p) throws Exception {
        cm.modificarPatrocinador(p);
    }

    //STAFF
    public void insertarStaff(Staff s) throws Exception {
        cm.insertarStaff(s);
    }

    public void borrarStaff(Staff s) throws Exception {
        cm.borrarStaff(s);
    }

    public Staff buscarStaff(Integer id_staff) throws Exception {
        return cm.buscarStaff(id_staff);
    }

    public void modificarStaff(Staff s) throws Exception {
        cm.modificarStaff(s);
    }

    //EQUIPO_COMPETICION
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        return cm.buscarTodosEquiposCompeticiones();
    }
}
