package Controlador;

import Controlador.ControladoresBD.ControladorModelo;
import Controlador.ControladoresVista.ControladorImagenes;
import Controlador.ControladoresVista.ControladorVista;
import Modelo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador principal que actúa como intermediario entre la vista y el modelo.
 *
 * Gestiona las operaciones relacionadas con la interacción de la vista con los datos del modelo.
 *
 * @author Ibai, Lorena, Zahir, Julen
 * @version 1.0
 */
public class ControladorPrincipal {
    private ControladorVista cv;
    private final ControladorModelo cm;
    private ControladorImagenes ci;

    /**
     * Constructor de la clase ControladorPrincipal.
     * Inicializa los controladores de vista y modelo, y carga las imágenes.
     *
     * @see ControladorModelo
     * @see ControladorImagenes
     * @see ControladorVista
     */
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

    public Equipo buscarEquipoPorNombre(String nombre) throws Exception{
        return cm.buscarEquipoPorNombre(nombre);
    }

    public List<Equipo> cargarEquiposDesdeBD() throws Exception {
        return cm.cargarEquiposDesdeBD();
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

    public String[][] obtenerResultadosUltimaJornada(String nombreCom) throws Exception {
        return cm.obtenerResultadosUltimaJornada(nombreCom);
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

    public Juego buscarJuegoPorNombre(String nombre) throws Exception{
        return cm.buscarJuegoPorNombre(nombre);
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

    public void modificarPatrocinador(int idEquipo, int idPatrocinador) throws Exception {
        cm.modificarPatrocinador(idEquipo, idPatrocinador);
    }

    public Patrocinador buscarPatrocinadorPorNombre(String nombre) throws Exception{
        return cm.buscarPatrocinadorPorNombre(nombre);
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

    public Staff buscarStaffPorNombre(String nombre) throws Exception {
        return cm.buscarStaffPorNombre(nombre);
    }

    //USUARIO
    public boolean validarUsuario(String usuario, String contrasena) throws Exception {
        return cm.validarUsuario(usuario, contrasena);
    }

    public boolean insertarUsuario(Usuario usuario) throws Exception {
        return cm.insertarUsuario(usuario);
    }

    //EQUIPO_COMPETICION
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        return cm.buscarTodosEquiposCompeticiones();
    }

    public void insertarEquipoCompeticion(int idEquipo, int idCompeticion) throws Exception {
        cm.insertarEquipoCompeticion(idEquipo, idCompeticion);
    }

    //PATROCINADOR_EQUIPO
    public void insertarPatrocinadorEquipo(int idPatrocinador, int idEquipo) throws Exception {
        cm.insertarPatrocinadorEquipo(idPatrocinador, idEquipo);
    }

    public ArrayList<Integer> buscarEquiposPatrocinador(int idPatrocinador) throws Exception {
        return cm.buscarEquiposPatrocinador(idPatrocinador);
    }

    public void borrarPatrocinadorEquipo(int idPatrocinador, int idEquipo) throws Exception {
        cm.borrarPatrocinadorEquipo(idPatrocinador, idEquipo);
    }

    //XML
    public String obtenerXMLClasificacionDTD () throws Exception{
        return cm.obtenerXMLClasificacionDTD();
    }
    public String obtenerXMLClasificacionXSD () throws Exception{
        return cm.obtenerXMLClasificacionXSD();
    }
    public String obtenerXMLJornadasDTD () throws Exception{
        return cm.obtenerXMLJornadasDTD();
    }
    public String  obtenerXMLJornadasXSD() throws Exception{
        return cm.obtenerXMLJornadasXSD();
    }
    public String obtenerXMLUltimaJornadaDTD () throws Exception{
        return cm.obtenerXMLUltimaJornadaDTD();
    }
    public String  obtenerXMLUltimaJornadaXSD() throws Exception{
        return cm.obtenerXMLUltimaJornadaXSD();
    }

    //CONEXION
    public void cerrarConexion() throws Exception{
        cm.cerrarConexion();
    }
}