package Controlador.ControladoresBD;

import Controlador.ControladoresVista.ControladorVUser;
import Modelo.*;

import java.sql.*;
import java.util.List;

public class ControladorModelo {
    private Connection con;
    private ControladorCompeticiones cc;
    private ControladorEquipos ce;
    private ControladorJornadas cjo;
    private ControladorJuegos cjue;
    private ControladorJugadores cjug;
    private ControladorPatrocinadores cp;
    private ControladorStaff cs;
    private ControladorUsuarios cu;
    private ControladorEquiposCompeticiones cec;

    private ControladorXML cxm;

    public ControladorModelo() {
        abrirConexion();

        cc = new ControladorCompeticiones(con);
        ce = new ControladorEquipos(con);
        cjo = new ControladorJornadas(con);
        cjue = new ControladorJuegos(con);
        cjug = new ControladorJugadores(con);
        cp = new ControladorPatrocinadores(con);
        cs = new ControladorStaff(con);
        cu = new ControladorUsuarios(con);
        cec = new ControladorEquiposCompeticiones(con);
        cxm = new ControladorXML(con);
    }

    //COMPETICION
    public void insertarCompeticion(Competicion c) throws Exception {
        cc.insertarCompeticion(c);
    }

    public void borrarCompeticion(int idCompeticion) throws Exception {
        cc.borrarCompeticion(idCompeticion);
    }

    public Competicion buscarCompeticion(Integer id_competicion) throws Exception {
        return cc.buscarCompeticion(id_competicion);
    }

    public String[][] buscarEquiposPorNombreCom(String nombre) throws Exception {
        return cc.buscarEquiposPorNombreCom(nombre);
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

    public void borrarEquipo(String nombre) throws Exception {
        ce.borrarEquipo(nombre);
    }

    public Equipo buscarEquipo(Integer id_equipo) throws Exception {
        return ce.buscarEquipo(id_equipo);
    }

    public void modificarEquipo(Equipo e) throws Exception {
        ce.modificarEquipo(e);
    }

    public Equipo buscarEquipoPorNombre(String nombre) throws Exception{
        return ce.buscarEquipoPorNombre(nombre);
    }

    public List<Equipo> cargarEquiposDesdeBD() throws Exception {
        return ce.cargarEquiposDesdeBD();
    }

    //JORNADA
    public void insertarJornada(Jornada j) throws Exception {
        cjo.insertarJornada(j);
    }

    public void borrarJornada(int idJornada) throws Exception {
        cjo.borrarJornada(idJornada);
    }

    public Jornada buscarJornada(Integer id_jornada) throws Exception {
        return cjo.buscarJornada(id_jornada);
    }

    public void modificarJornada(Jornada j) throws Exception {
        cjo.modificarJornada(j);
    }

    public String[][] obtenerResultadosUltimaJornada(String nombreCom) throws Exception {
        return cjo.obtenerResultadosUltimaJornadaPorNombreCom(nombreCom);
    }

    //JUEGO
    public void insertarJuego(Juego j) throws Exception {
        cjue.insertarJuego(j);
    }

    public void borrarJuego(int idJuego) throws Exception {
        cjue.borrarJuego(idJuego);
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

    public void borrarJugador(int idJugador) throws Exception {
        cjug.borrarJugador(idJugador);
    }

    public Jugador buscarJugador(int idJugador) throws Exception {
        return cjug.buscarJugador(idJugador);
    }

    public void modificarJugador(Jugador j) throws Exception {
        cjug.modificarJugador(j);
    }

    //PATROCINADOR
    public void insertarPatrocinador(Patrocinador p) throws Exception {
        cp.insertarPatrocinador(p);
    }

    public void borrarPatrocinador(int idPatrocinador) throws Exception {
        cp.borrarPatrocinador(idPatrocinador);
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

    public void borrarStaff(int idStaff) throws Exception {
        cs.borrarStaff(idStaff);
    }

    public Staff buscarStaff(Integer id_staff) throws Exception {
        return cs.buscarStaff(id_staff);
    }

    public void modificarStaff(Staff s) throws Exception {
        cs.modificarStaff(s);
    }

    //USUARIO
    public boolean validarUsuario(String usuario, String contrasena) throws Exception {
        return cu.validarUsuario(usuario, contrasena);
    }

    //EQUIPO_COMPETICION
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        return cec.buscarTodosEquiposCompeticiones();
    }
    //XML
    public String obtenerXMLClasificacionDTD () throws Exception{
        return cxm.obtenerXMLClasificacionDTD();
    }
    public String  obtenerXMLClasificacionXSD() throws Exception{
        return cxm.obtenerXMLClasificacionXSD();
    }
    public String obtenerXMLJornadasDTD () throws Exception{
        return cxm.obtenerXMLJornadasDTD();
    }
    public String  obtenerXMLJornadasXSD() throws Exception{
        return cxm.obtenerXMLJornadasXSD();
    }
    public String obtenerXMLUltimaJornadaDTD () throws Exception{
        return cxm.obtenerXMLUltimaJornadaDTD();
    }
    public String  obtenerXMLUltimaJornadaXSD() throws Exception{
        return cxm.obtenerXMLUltimaJornadaXSD();
    }







    //ABRIR LA CONEXION CON LA BASE DE DATOS
    public void abrirConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //String url = "jdbc:oracle:thin:@SrvOracle:1521:ORCL"; // TODO : para conexion ordenador
            //String url = "jdbc:oracle:thin:@172.20.225.114:1521:ORCL"; // TODO : para conexion portatil
            String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";//TODO : para conexion en casa
            //String user = "C##eqdaw03";
            String user = "eqdaw03";
            String passwd = "eqdaw03";
            con = DriverManager.getConnection(url, user, passwd);
            System.out.println("Conexión abierta");

            cc = new ControladorCompeticiones(con);
            ce = new ControladorEquipos(con);
            cjo = new ControladorJornadas(con);
            cjue = new ControladorJuegos(con);
            cjug = new ControladorJugadores(con);
            cp = new ControladorPatrocinadores(con);
            cs = new ControladorStaff(con);
            cec = new ControladorEquiposCompeticiones(con);
        }
        catch (Exception e) {
            System.out.println("Problemas con la base de datos");
        }
    }

    public void cerrarConexion() throws Exception {
        con.close();
    }
}
