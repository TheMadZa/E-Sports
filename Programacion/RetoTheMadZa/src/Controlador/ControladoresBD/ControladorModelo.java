package Controlador.ControladoresBD;

import Controlador.ControladorPrincipal;
import Modelo.*;

import java.sql.Connection;
import java.sql.DriverManager;
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
    private ControladorEquiposCompeticiones cec;

    public ControladorModelo() {
        abrirConexion();

        cc = new ControladorCompeticiones(con);
        ce = new ControladorEquipos(con);
        cjo = new ControladorJornadas(con);
        cjue = new ControladorJuegos(con);
        cjug = new ControladorJugadores(con);
        cp = new ControladorPatrocinadores(con);
        cs = new ControladorStaff(con);
        cec = new ControladorEquiposCompeticiones(con);

        System.out.println("ControladorModelo inicializado correctamente.");
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

    public void borrarEquipo(int idEquipo) throws Exception {
        ce.borrarEquipo(idEquipo);
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

    public void borrarJornada(int idJornada) throws Exception {
        cjo.borrarJornada(idJornada);
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

    //EQUIPO_COMPETICION
    public List<EquipoCompeticion> buscarTodosEquiposCompeticiones() throws Exception {
        return cec.buscarTodosEquiposCompeticiones();
    }

    //ABRIR LA CONEXION CON LA BASE DE DATOS
    public void abrirConexion()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/aerolinea";
            String user = "root";
            String passwd = "usbw";
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
        catch (Exception e)
        {
            System.out.println("Problemas con la base de datos");
        }
    }

    public void cerrarConexion() throws Exception
    {
        con.close();
    }
}
