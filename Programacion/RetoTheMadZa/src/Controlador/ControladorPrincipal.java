package Controlador;

import Controlador.ControladoresBD.ControladorModelo;
import Controlador.ControladoresVista.ControladorImagenes;
import Controlador.ControladoresVista.ControladorVista;
import Modelo.*;

import java.util.List;

public class ControladorPrincipal {
    private ControladorVista cv;
    private final ControladorModelo cm;
    private ControladorImagenes ci;

    public ControladorPrincipal() {
        cm = new ControladorModelo();
        ci = new ControladorImagenes(cm);
        ci.cargarImagenes();
        cv = new ControladorVista(this);
    }

    //COMPETICION
    public void insertarCompeticion(Competicion c) throws Exception {
        cm.insertarCompeticion(c);
    }

    public void borrarCompeticion(int idCompeticion) throws Exception {
        cm.borrarCompeticion(idCompeticion);
    }

    public Competicion buscarCompeticion(Integer id_competicion) throws Exception {
        return cm.buscarCompeticion(id_competicion);
    }

    public String[][] buscarEquiposPorNombreCom(String nombre) throws Exception {
        return cm.buscarEquiposPorNombreCom(nombre);
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

    public void borrarEquipo(int idEquipo) throws Exception {
        cm.borrarEquipo(idEquipo);
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

    public void borrarJornada(int idJornada) throws Exception {
        cm.borrarJornada(idJornada);
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

    public void borrarJuego(int idJuego) throws Exception {
        cm.borrarJuego(idJuego);
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

    public void borrarJugador(int idJugador) throws Exception {
        cm.borrarJugador(idJugador);
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

    public void borrarPatrocinador(int idPatrocinador) throws Exception {
        cm.borrarPatrocinador(idPatrocinador);
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

    public void borrarStaff(int idStaff) throws Exception {
        cm.borrarStaff(idStaff);
    }

    public Staff buscarStaff(Integer id_staff) throws Exception {
        return cm.buscarStaff(id_staff);
    }

    public void modificarStaff(Staff s) throws Exception {
        cm.modificarStaff(s);
    }

    //USUARIO
    public boolean validarUsuario(String usuario, String contrasena) throws Exception {
        return cm.validarUsuario(usuario, contrasena);
    }

    //EQUIPO_COMPETICION
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        return cm.buscarTodosEquiposCompeticiones();
    }

    //CONEXION
    public void cerrarConexion() throws Exception{
        cm.cerrarConexion();
    }
}