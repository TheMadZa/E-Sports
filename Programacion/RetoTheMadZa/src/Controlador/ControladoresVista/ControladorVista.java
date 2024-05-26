package Controlador.ControladoresVista;

import Controlador.ControladorPrincipal;
import Modelo.*;
import Vista.VentanaInicioSesion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para gestionar las vistas y la interacción con el modelo.
 *
 * @author Ibai, Lorena, Zahir, Julen
 */
public class ControladorVista {

    //CONTROLADORES DE LAS VENTANAS
    private ControladorVI cvi;
    private ControladorVTienda cvt;
    private ControladorVIS cvis;
    private ControladorVAdmin cva;
    private ControladorVUser cvu;
    private ControladorVCompeticiones cvco;
    private ControladorVEquipos cve;
    private ControladorVJornadas cvj;
    private ControladorDUsuario cdu;

    private ControladorVxml cxl;

    private final ControladorPrincipal cp;
    /**
     * Constructor para el controlador de la vista.
     * @param cp Controlador principal.
     */
    public ControladorVista(ControladorPrincipal cp) {
        this.cp = cp;

        //Creación de los controladores de las ventanas

        cvi = new ControladorVI(this);
        cvis = new ControladorVIS(this);
        cva = new ControladorVAdmin(this);
        cvu = new ControladorVUser(this);
        cvco = new ControladorVCompeticiones(this);
        cve = new ControladorVEquipos(this);
        cvj = new ControladorVJornadas(this);
        cdu = new ControladorDUsuario(this);
        cvt = new ControladorVTienda(this);
        cxl = new ControladorVxml(this);

        cvi.crearMostrar();
    }
    /**
     * Muestra la ventana de inicio de sesión.
     * @param ventanaEliminar Ventana actual.
     */
    public void mostrarInicioSesion(JFrame ventanaEliminar){
        cvis.crearMostrar(ventanaEliminar);
    }

    /**
     * Muestra la ventana de usuario utilizando la ventana de inicio de sesión proporcionada.
     * @param vis La ventana de inicio de sesión desde la cual se muestra la ventana de usuario.
     */
    public void mostrarUser(VentanaInicioSesion vis){
        cvu.crearMostrar(vis);
    }

    /**
     * Muestra la ventana de administrador utilizando la ventana de inicio de sesión proporcionada.
     * @param vis La ventana de inicio de sesión desde la cual se muestra la ventana de administrador.
     */
    public void mostrarVAdmin(VentanaInicioSesion vis){
        cva.crearMostrar(vis);
    }

    /**
     * Muestra la ventana de jornadas.
     * @param ventanaEliminar La ventana que se debe eliminar antes de mostrar la ventana de jornadas.
     */
    public void mostrarJornadas(JFrame ventanaEliminar){
        cvj.crearMostrar(ventanaEliminar);
    }

    /**
     * Muestra la ventana de clasificación.
     * @param ventanaEliminar La ventana que se debe eliminar antes de mostrar la ventana de clasificación.
     */
    public void mostrarClasificacion(JFrame ventanaEliminar){
        cvco.crearMostrar(ventanaEliminar);
    }

    /**
     * Muestra la ventana de equipos.
     * @param ventanaEliminar La ventana que se debe eliminar antes de mostrar la ventana de equipos.
     */
    public void mostrarEquipos(JFrame ventanaEliminar){
        cve.crearMostrar(ventanaEliminar);
    }

    /**
     * Muestra la ventana de la tienda.
     * @param ventanaEliminar La ventana que se debe eliminar antes de mostrar la ventana de la tienda.
     */
    public void mostrarTienda(JFrame ventanaEliminar){
        cvt.crearMostrar(ventanaEliminar);
    }

    /**
     * Muestra la ventana de datos de usuario.
     */
    public void mostrarDUsuario(){
        cdu.crearMostrar();
    }

    /**
     * Muestra la ventana XML.
     * @param ventanaEliminar La ventana que se debe eliminar antes de mostrar la ventana XML.
     */
    public void mostrarXML(JFrame ventanaEliminar){
        cxl.crearMostrar(ventanaEliminar);
    }


    //COMPETICION
    /**
     * Inserta una competición en la base de datos.
     * @param c La competición a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarCompeticion(Competicion c) throws Exception {
        cp.insertarCompeticion(c);
    }

    /**
     * Borra una competición de la base de datos dado su identificador.
     * @param idCompeticion El identificador de la competición a borrar.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarCompeticion(int idCompeticion) throws Exception{
        cp.borrarCompeticion(idCompeticion);
    }

    /**
     * Busca una competición en la base de datos dado su identificador.
     * @param id_competicion El identificador de la competición a buscar.
     * @return La competición encontrada.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Competicion buscarCompeticion(Integer id_competicion) throws Exception {
        return cp.buscarCompeticion(id_competicion);
    }

    /**
     * Busca los equipos asociados a una competición por su nombre.
     * @param nombre El nombre de la competición.
     * @return Una matriz de String con los nombres de los equipos asociados a la competición.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public String[][] buscarEquiposPorNombreCom(String nombre) throws Exception {
        return cp.buscarEquiposPorNombreCom(nombre);
    }

    /**
     * Busca todas las competiciones en la base de datos.
     * @return Una lista de todas las competiciones encontradas.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public List<Competicion> buscarTodasCompeticiones() throws Exception {
        return cp.buscarTodasCompeticiones();
    }

    /**
     * Modifica una competición en la base de datos.
     * @param c La competición modificada.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarCompeticion(Competicion c) throws Exception{
        cp.modificarCompeticion(c);
    }

    /**
     * Busca una competición en la base de datos por su nombre.
     * @param nombre El nombre de la competición a buscar.
     * @return La competición encontrada.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Competicion buscarCompeticionPorNombre(String nombre) throws Exception{
        return cp.buscarCompeticionPorNombre(nombre);
    }


    //ENFRENTAMIENTO
    /**
     * Borra un enfrentamiento de la base de datos dado su identificador.
     * @param idEnfrentamiento El identificador del enfrentamiento a borrar.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarEnfrentamiento(int idEnfrentamiento) throws Exception{
        cp.borrarEnfrentamiento(idEnfrentamiento);
    }

    /**
     * Busca un enfrentamiento en la base de datos dado su identificador.
     * @param idEnfrentamiento El identificador del enfrentamiento a buscar.
     * @return El enfrentamiento encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Enfrentamiento buscarEnfrentamiento(int idEnfrentamiento) throws Exception {
        return cp.buscarEnfrentamiento(idEnfrentamiento);
    }

    /**
     * Modifica un enfrentamiento en la base de datos.
     * @param e El enfrentamiento modificado.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarEnfrentamiento(Enfrentamiento e) throws Exception{
        cp.modificarEnfrentamiento(e);
    }

//EQUIPO

    /**
     * Inserta un equipo en la base de datos.
     * @param e El equipo a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarEquipo(Equipo e) throws Exception {
        cp.insertarEquipo(e);
    }

    /**
     * Borra un equipo de la base de datos dado su identificador.
     * @param idEquipo El identificador del equipo a borrar.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarEquipo(int idEquipo) throws Exception{
        cp.borrarEquipo(idEquipo);
    }

    /**
     * Busca un equipo en la base de datos dado su identificador.
     * @param id_equipo El identificador del equipo a buscar.
     * @return El equipo encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Equipo buscarEquipo(Integer id_equipo) throws Exception {
        return cp.buscarEquipo(id_equipo);
    }

    /**
     * Modifica un equipo en la base de datos.
     * @param e El equipo modificado.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarEquipo(Equipo e) throws Exception{
        cp.modificarEquipo(e);
    }

    /**
     * Busca un equipo en la base de datos por su nombre.
     * @param nombre El nombre del equipo a buscar.
     * @return El equipo encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Equipo buscarEquipoPorNombre(String nombre) throws Exception{
        return cp.buscarEquipoPorNombre(nombre);
    }

    /**
     * Carga todos los equipos desde la base de datos.
     * @return Una lista de todos los equipos encontrados.
     * @throws Exception Si ocurre un error durante la carga.
     */
    public List<Equipo> cargarEquiposDesdeBD() throws Exception {
        return cp.cargarEquiposDesdeBD();
    }

    //JORNADA
    /**
     * Borra una jornada de la base de datos dado su identificador.
     * @param idJornada El identificador de la jornada a borrar.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarJornada(int idJornada) throws Exception{
        cp.borrarJornada(idJornada);
    }

    /**
     * Busca una jornada en la base de datos dado su identificador.
     * @param id_jornada El identificador de la jornada a buscar.
     * @return La jornada encontrada.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Jornada buscarJornada(Integer id_jornada) throws Exception {
        return cp.buscarJornada(id_jornada);
    }

    /**
     * Modifica una jornada en la base de datos.
     * @param j La jornada modificada.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarJornada(Jornada j) throws Exception{
        cp.modificarJornada(j);
    }

    /**
     * Obtiene los resultados de la última jornada de una competición.
     * @param nombreCom El nombre de la competición.
     * @return Una matriz con los resultados de la última jornada.
     * @throws Exception Si ocurre un error durante la obtención de los resultados.
     */
    public String[][] obtenerResultadosUltimaJornada(String nombreCom) throws Exception {
        return cp.obtenerResultadosUltimaJornada(nombreCom);
    }

//JUEGO

    /**
     * Inserta un juego en la base de datos.
     * @param j El juego a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarJuego(Juego j) throws Exception {
        cp.insertarJuego(j);
    }

    /**
     * Borra un juego de la base de datos dado su identificador.
     * @param idJuego El identificador del juego a borrar.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarJuego(int idJuego) throws Exception{
        cp.borrarJuego(idJuego);
    }

    /**
     * Busca un juego en la base de datos dado su identificador.
     * @param id_juego El identificador del juego a buscar.
     * @return El juego encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Juego buscarJuego(Integer id_juego) throws Exception {
        return cp.buscarJuego(id_juego);
    }

    /**
     * Modifica un juego en la base de datos.
     * @param j El juego modificado.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarJuego(Juego j) throws Exception{
        cp.modificarJuego(j);
    }

    /**
     * Busca un juego en la base de datos por su nombre.
     * @param nombre El nombre del juego a buscar.
     * @return El juego encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Juego buscarJuegoPorNombre(String nombre) throws Exception{
        return cp.buscarJuegoPorNombre(nombre);
    }

//JUGADOR

    /**
     * Inserta un jugador en la base de datos.
     * @param j El jugador a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarJugador(Jugador j) throws Exception {
        cp.insertarJugador(j);
    }

    /**
     * Borra un jugador de la base de datos dado su identificador.
     * @param idJugador El identificador del jugador a borrar.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarJugador(int idJugador) throws Exception{
        cp.borrarJugador(idJugador);
    }

    /**
     * Modifica un jugador en la base de datos.
     * @param j El jugador modificado.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarJugador(Jugador j) throws Exception{
        cp.modificarJugador(j);
    }

    /**
     * Busca un jugador en la base de datos por su nombre.
     * @param nombre El nombre del jugador a buscar.
     * @return El jugador encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Jugador buscarJugadorPorNombre(String nombre) throws Exception{
        return cp.buscarJugadorPorNombre(nombre);
    }

//PATROCINADOR

    /**
     * Inserta un patrocinador en la base de datos.
     * @param p El patrocinador a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarPatrocinador(Patrocinador p) throws Exception {
        cp.insertarPatrocinador(p);
    }

    /**
     * Borra un patrocinador de la base de datos dado su identificador.
     * @param idPatrocinador El identificador del patrocinador a borrar.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarPatrocinador(int idPatrocinador) throws Exception{
        cp.borrarPatrocinador(idPatrocinador);
    }

    /**
     * Busca un patrocinador en la base de datos por su nombre.
     * @param nombre El nombre del patrocinador a buscar.
     * @return El patrocinador encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Patrocinador buscarPatrocinadorPorNombre(String nombre) throws Exception{
        return cp.buscarPatrocinadorPorNombre(nombre);
    }

//STAFF

    /**
     * Inserta un miembro del staff en la base de datos.
     * @param s El miembro del staff a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarStaff(Staff s) throws Exception {
        cp.insertarStaff(s);
    }

    /**
     * Borra un miembro del staff de la base de datos dado su identificador.
     * @param idStaff El identificador del miembro del staff a borrar.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarStaff(int idStaff) throws Exception{
        cp.borrarStaff(idStaff);
    }

    /**
     * Modifica un miembro del staff en la base de datos.
     * @param s El miembro del staff modificado.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarStaff(Staff s) throws Exception{
        cp.modificarStaff(s);
    }

    /**
     * Busca un miembro del staff en la base de datos por su nombre.
     * @param nombre El nombre del miembro del staff a buscar.
     * @return El miembro del staff encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Staff buscarStaffPorNombre(String nombre) throws Exception {
        return cp.buscarStaffPorNombre(nombre);
    }


    //USUARIO
    /**
     * Valida las credenciales de un usuario en la base de datos.
     * @param usuario El nombre de usuario.
     * @param contrasena La contraseña del usuario.
     * @return true si las credenciales son válidas, false en caso contrario.
     * @throws Exception Si ocurre un error durante la validación.
     */
    public boolean validarUsuario(String usuario, String contrasena) throws Exception {
        return cp.validarUsuario(usuario, contrasena);
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param usuario El usuario a insertar.
     * @return true si se inserta correctamente, false en caso contrario.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public boolean insertarUsuario(Usuario usuario) throws Exception {
        return cp.insertarUsuario(usuario);
    }

    /**
     * Borra un usuario de la base de datos dado su nombre.
     * @param nombreUsuario El nombre del usuario a borrar.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarUsuario(String nombreUsuario) throws Exception {
        cp.borrarUsuario(nombreUsuario);
    }

    /**
     * Modifica un usuario en la base de datos.
     * @param u El usuario modificado.
     * @throws Exception Si ocurre un error durante la modificación.
     */
    public void modificarUsuario(Usuario u) throws Exception {
        cp.modificarUsuario(u);
    }

    /**
     * Busca un usuario en la base de datos por su nombre.
     * @param nombreUsuario El nombre del usuario a buscar.
     * @return El usuario encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Usuario buscarUsuarioPorNombre(String nombreUsuario) throws Exception {
        return cp.buscarUsuarioPorNombre(nombreUsuario);
    }

//EQUIPO_COMPETICION

    /**
     * Busca todos los equipos participantes en competiciones en la base de datos.
     * @return Una lista de objetos EquipoCompeticion.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        return cp.buscarTodosEquiposCompeticiones();
    }

    /**
     * Inserta un equipo en una competición en la base de datos.
     * @param idEquipo El identificador del equipo.
     * @param idCompeticion El identificador de la competición.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarEquipoCompeticion(int idEquipo, int idCompeticion) throws Exception {
        cp.insertarEquipoCompeticion(idEquipo, idCompeticion);
    }

//PATROCINADOR_EQUIPO

    /**
     * Inserta un patrocinador para un equipo en la base de datos.
     * @param idPatrocinador El identificador del patrocinador.
     * @param idEquipo El identificador del equipo.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarPatrocinadorEquipo(int idPatrocinador, int idEquipo) throws Exception {
        cp.insertarPatrocinadorEquipo(idPatrocinador, idEquipo);
    }

    /**
     * Busca los equipos asociados a un patrocinador en la base de datos.
     * @param idPatrocinador El identificador del patrocinador.
     * @return Una lista de identificadores de equipos asociados al patrocinador.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public ArrayList<Integer> buscarEquiposPatrocinador(int idPatrocinador) throws Exception {
        return cp.buscarEquiposPatrocinador(idPatrocinador);
    }

    /**
     * Borra la asociación de un patrocinador con un equipo de la base de datos.
     * @param idPatrocinador El identificador del patrocinador.
     * @param idEquipo El identificador del equipo.
     * @throws Exception Si ocurre un error durante el borrado.
     */
    public void borrarPatrocinadorEquipo(int idPatrocinador, int idEquipo) throws Exception {
        cp.borrarPatrocinadorEquipo(idPatrocinador, idEquipo);
    }

    //XML
    /**
     * Obtiene el XML de la clasificación en formato DTD.
     * @return El XML de la clasificación en formato DTD.
     * @throws Exception Si ocurre un error durante la obtención.
     */
    public String obtenerXMLClasificacionDTD() throws Exception{
        return cp.obtenerXMLClasificacionDTD();
    }

    /**
     * Obtiene el XML de la clasificación en formato XSD.
     * @return El XML de la clasificación en formato XSD.
     * @throws Exception Si ocurre un error durante la obtención.
     */
    public String obtenerXMLClasificacionXSD() throws Exception{
        return cp.obtenerXMLClasificacionXSD();
    }

    /**
     * Obtiene el XML de las jornadas en formato DTD.
     * @return El XML de las jornadas en formato DTD.
     * @throws Exception Si ocurre un error durante la obtención.
     */
    public String obtenerXMLJornadasDTD() throws Exception{
        return cp.obtenerXMLJornadasDTD();
    }

    /**
     * Obtiene el XML de las jornadas en formato XSD.
     * @return El XML de las jornadas en formato XSD.
     * @throws Exception Si ocurre un error durante la obtención.
     */
    public String obtenerXMLJornadasXSD() throws Exception{
        return cp.obtenerXMLJornadasXSD();
    }

    /**
     * Obtiene el XML de la última jornada en formato DTD.
     * @return El XML de la última jornada en formato DTD.
     * @throws Exception Si ocurre un error durante la obtención.
     */
    public String obtenerXMLUltimaJornadaDTD() throws Exception{
        return cp.obtenerXMLUltimaJornadaDTD();
    }

    /**
     * Obtiene el XML de la última jornada en formato XSD.
     * @return El XML de la última jornada en formato XSD.
     * @throws Exception Si ocurre un error durante la obtención.
     */
    public String obtenerXMLUltimaJornadaXSD() throws Exception{
        return cp.obtenerXMLUltimaJornadaXSD();
    }

    /**
     * Cierra la conexión a la base de datos.
     * @throws Exception Si ocurre un error durante el cierre de la conexión.
     */
    public void cerrarConexion() throws Exception{
        cp.cerrarConexion();
    }

}
