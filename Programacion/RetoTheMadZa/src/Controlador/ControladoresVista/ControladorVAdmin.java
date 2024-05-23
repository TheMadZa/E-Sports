package Controlador.ControladoresVista;

import Modelo.Equipo;
import Modelo.Juego;
import Vista.VentanaAdmin;
import Vista.VentanaInicioSesion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControladorVAdmin {

    private VentanaAdmin va;
    private ControladorVista cv;
    private String tablaElegida;
    private String accionElegida;
    private boolean datosRellenados = false;
    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yy");

    public ControladorVAdmin(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(VentanaInicioSesion vis) {
        va = new VentanaAdmin(vis);

        // Action Listeners de los botones y demás.
        va.addMiCrudAL(new MiCrudAL());
        va.addBAccionesAL(new BAccionesAL());
        va.addMiVisualizarEquiposAL(new MiVisualizarEquiposAL());
        va.addMiVisualizarJornadasAL(new MiVisualizarJornadasAL());
        va.addMiClasificacionJornadasAL(new MiClasificacionJornadasAL());
        va.addMGenerarXmlAL(new MGenerarXmlAL());
        va.addBInicioAL(new BInicioAL());
        va.addBSalirAL(new BSalirAL());
        va.addBFacebookAL(new BFacebookAL());
        va.addBInstagramAL(new BInstagramAL());
        va.addBTwitterAL(new BTwitterAL());
    }

    public class MiCrudAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            va.getpDatos().removeAll();

            tablaElegida = e.getActionCommand();
            switch (tablaElegida){
                case "CRUD Equipos" -> {
                    va.mostrarDatosEquipos();
                    datosRellenados = false;
                }
                case "CRUD Jugadores" -> {
                    va.mostrarDatosJugadores();
                    datosRellenados = false;
                }
                case "CRUD Staff" -> {
                    va.mostrarDatosStaff();
                    datosRellenados = false;
                }
                case "CRUD Patrocinadores" -> {
                    va.mostrarDatosPatrocinadores();
                    datosRellenados = false;
                }
                case "CRUD Juegos" -> {
                    va.mostrarDatosJuegos();
                    datosRellenados = false;
                }
                case "CRUD Competiciones" -> {
                    va.mostrarDatosCompeticiones();
                    datosRellenados = false;
                }
                case "CRUD Enfrentamientos" -> {
                    va.mostrarDatosEnfrentamientos();
                    datosRellenados = false;
                }
                case "CRUD Jornadas" -> {
                    va.mostrarDatosJornadas();
                    datosRellenados = false;
                }
            }

            if (!va.getPanelCRUD().isVisible())
                va.getPanelCRUD().setVisible(true);

        }
    }
    public class BAccionesAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                accionElegida = e.getActionCommand();

                // Dependiendo de la tabla sobre la que queramos hacer una acción, y la acción en la BD que sea:
                switch (tablaElegida){

                    case "CRUD Equipos" -> {

                        // El equipo tendrá nombre, fecha, logo, color, y puede que el id de la competición.

                        // Obtener lista con los JTextFields para poder obtener los datos introducidos.
                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        String nombre = listaTextFieldsDinamicos.get(0).getText();
                        String fechaFundacionS = listaTextFieldsDinamicos.get(1).getText();
                        LocalDate fechaFundacionLD = LocalDate.parse(fechaFundacionS, formatoFecha);
                        Date fechaFundacion = Date.valueOf(fechaFundacionLD);
                        String logo = listaTextFieldsDinamicos.get(2).getText();
                        String color = listaTextFieldsDinamicos.get(3).getText();
                        int idCompeticion = Integer.parseInt(listaTextFieldsDinamicos.get(4).getText());

                        switch (accionElegida){
                            case "Insertar" -> insertarEquipo(nombre, fechaFundacion, logo, color, idCompeticion,
                                    listaTextFieldsDinamicos);
                            case "Eliminar" -> borrarEquipo(nombre, logo, color, listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarEquipo(nombre, fechaFundacion, logo, color, idCompeticion,
                                    listaTextFieldsDinamicos);
                            case "Consultar" -> consultarEquipo(nombre, logo, color, listaTextFieldsDinamicos);
                        }

                    }
                    case "CRUD Jugadores" -> {

                        // El jugador tendrá nombre, nickname, nacionalidad, rol, fecha de nacimiento, sueldo e id del equipo.

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        String nombre = listaTextFieldsDinamicos.get(0).getText();
                        String nickname = listaTextFieldsDinamicos.get(1).getText();
                        String nacionalidad = listaTextFieldsDinamicos.get(2).getText();
                        String rol = listaTextFieldsDinamicos.get(3).getText();
                        String fechaNacimientoS = listaTextFieldsDinamicos.get(4).getText();
                        LocalDate fechaNacimientoLD = LocalDate.parse(fechaNacimientoS, formatoFecha);
                        Date fechaNacimiento = Date.valueOf(fechaNacimientoLD);
                        int idEquipo = Integer.parseInt(listaTextFieldsDinamicos.get(5).getText());

                        switch (accionElegida){
                            case "Insertar" -> insertarJugador(nombre, nickname, nacionalidad, rol, fechaNacimiento,
                                    idEquipo, listaTextFieldsDinamicos);
                            case "Eliminar" -> borrarJugador(nombre, nickname, nacionalidad, rol, fechaNacimiento,
                                    idEquipo, listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarJugador(nombre, nickname, nacionalidad, rol, fechaNacimiento,
                                    idEquipo, listaTextFieldsDinamicos);
                            case "Consultar" -> consultarJugador(nombre, nickname, nacionalidad, rol, fechaNacimiento,
                                    idEquipo, listaTextFieldsDinamicos);
                        }

                        /*
                        switch (accionElegida){
                            case "Insertar" -> {

                                Jugador jugador = new Jugador();
                                jugador.setNombre(listaTextFieldsDinamicos.get(0).getText());
                                jugador.setNickname(listaTextFieldsDinamicos.get(1).getText());
                                jugador.setNacionalidad(listaTextFieldsDinamicos.get(2).getText());
                                jugador.setRol(listaTextFieldsDinamicos.get(3).getText());
                                jugador.setFechaNac(Date.valueOf(listaTextFieldsDinamicos.get(4).getText()));
                                jugador.setSueldo(Double.parseDouble(listaTextFieldsDinamicos.get(5).getText()));
                                Equipo equipo = cv.bus
                                jugador.setEquipo(equipo.get);
                                cv.insertarEquipo(equipo);
                                // Ahora obtener el ID del equipo insertado.
                                Equipo equipoInsertado = cv.buscarEquipoPorNombre(listaTextFieldsDinamicos.get(0).getText());
                                va.mostrarMensaje("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                                System.out.println("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                            }
                            case "Eliminar" -> {
                                // Eliminar por nombre del equipo.
                                cv.borrarEquipo(listaTextFieldsDinamicos.get(0).getText());
                            }
                            case "Actualizar" -> {
                                // Actualizar equipo.
                                Equipo equipo = new Equipo();
                                equipo.setNomEquipo(listaTextFieldsDinamicos.get(0).getText());
                                equipo.setFechaFundacion(Date.valueOf(listaTextFieldsDinamicos.get(1).getText()));
                                equipo.setLogo(listaTextFieldsDinamicos.get(2).getText());
                                equipo.setColor(listaTextFieldsDinamicos.get(3).getText());
                                cv.modificarEquipo(equipo);
                            }
                            case "Consultar" -> {
                                // Consultar por nombre del equipo.
                                Equipo equipo =  cv.buscarEquipoPorNombre(listaTextFieldsDinamicos.get(0).getText());
                                listaTextFieldsDinamicos.get(1).setText(String.valueOf(equipo.getFechaFundacion()));
                                listaTextFieldsDinamicos.get(2).setText(equipo.getLogo());
                                listaTextFieldsDinamicos.get(3).setText(equipo.getColor());
                            }
                        }
                         */

                    }
                    case "CRUD Staff" -> {

                        // El miembro del staff tendrá .

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        // todo

                        switch (accionElegida) {
                            case "Insertar" -> insertarStaff();
                            case "Eliminar" -> borrarStaff();
                            case "Actualizar" -> modificarStaff();
                            case "Consultar" -> consultarStaff();
                        }

                    }
                    case "CRUD Patrocinadores" -> {

                        // El patrocinador tendrá .

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        // todo

                        switch (accionElegida) {
                            case "Insertar" -> insertarPatrocinador();
                            case "Eliminar" -> borrarPatrocinador();
                            case "Actualizar" -> modificarPatrocinador();
                            case "Consultar" -> consultarPatrocinador();
                        }

                    }
                    case "CRUD Juegos" -> {

                        // El juego tendrá nombre, empresa y fecha de lanzamiento.
  
                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();
                        String nombre = listaTextFieldsDinamicos.get(0).getText();
                        String empresa = listaTextFieldsDinamicos.get(1).getText();

                        switch (accionElegida){
                            case "Insertar" -> insertarJuego(nombre, empresa, listaTextFieldsDinamicos);
                            case "Eliminar" -> borrarJuego(nombre, empresa, listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarJuego(nombre, empresa, listaTextFieldsDinamicos);
                            case "Consultar" -> consultarJuego(nombre, listaTextFieldsDinamicos);
                        }

                    }
                    case "CRUD Competiciones" -> {

                        // La competición tendrá .

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        // todo

                        switch (accionElegida) {
                            case "Insertar" -> insertarCompeticion();
                            case "Eliminar" -> borrarCompeticion();
                            case "Actualizar" -> modificarCompeticion();
                            case "Consultar" -> consultarCompeticion();
                        }

                    }
                    case "CRUD Enfrentamientos" -> {

                        // El enfrentamiento tendrá .

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        // todo

                        switch (accionElegida) {
                            case "Insertar" -> insertarEnfrentamiento();
                            case "Eliminar" -> borrarEnfrentamiento();
                            case "Actualizar" -> modificarEnfrentamiento();
                            case "Consultar" -> consultarEnfrentamiento();
                        }
                        
                    }
                    case "CRUD Jornadas" -> {

                        // La jornada tendrá .

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        // todo

                        switch (accionElegida) {
                            case "Insertar" -> insertarJornada();
                            case "Eliminar" -> borrarJornada();
                            case "Actualizar" -> modificarJornada();
                            case "Consultar" -> consultarJornada();
                        }

                    }

                }

            }
            catch (Exception ex){
                va.mostrarMensaje(ex.getMessage());
            }

        }
    }
    public class MiVisualizarEquiposAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(va);
        }
    }
    public class MiVisualizarJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarJornadas(va);
        }
    }
    public class MiClasificacionJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(va);
        }
    }
    public class MGenerarXmlAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarXML(va);
        }
    }
    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(va);
        }
    }

    public static class BSalirAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static class BFacebookAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String enlace = "https://www.facebook.com/?locale=es_ES";
            try {
                Desktop.getDesktop().browse(java.net.URI.create(enlace));
            } catch (java.io.IOException ex) {
                System.out.println("Error al abrir el enlace: " + ex.getMessage());
            }
        }
    }
    public static class BInstagramAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String enlace = "https://www.instagram.com";
            try {
                Desktop.getDesktop().browse(java.net.URI.create(enlace));
            } catch (java.io.IOException ex) {
                System.out.println("Error al abrir el enlace: " + ex.getMessage());
            }
        }
    }
    public static class BTwitterAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String enlace = "https://twitter.com/?logout=1715768138184";
            try {
                Desktop.getDesktop().browse(java.net.URI.create(enlace));
            } catch (java.io.IOException ex) {
                System.out.println("Error al abrir el enlace: " + ex.getMessage());
            }
        }
    }

    // Funciones

    // Operaciones con equipos
    public void insertarEquipo(String nombre, Date fechaFundacion, String logo, String color, int idCompeticion,
                               ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // VERIFICAR LO DEL ID_COMPETICION.
            // Verificar si la posición 4 del ArrayList existe y no es null. Si existe, entonces habrá que buscar el equipo y añadirlo a la competición.
            if (listaTextFieldsDinamicos.size() == 5 && listaTextFieldsDinamicos.get(4) != null) {

                if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty() && !logo.isEmpty() &&
                        !color.isEmpty() && !listaTextFieldsDinamicos.get(4).getText().isEmpty()){

                    Equipo equipoExistir = cv.buscarEquipoPorNombre(nombre);

                    // Si el equipo ya existe:
                    if (equipoExistir != null) {
                        // Mostrar datos e insertarlo en la competición.
                        LocalDate fechaFundacionLD = equipoExistir.getFechaFundacion().toLocalDate();
                        String fechaS = fechaFundacionLD.format(formatoFecha);
                        listaTextFieldsDinamicos.get(1).setText(fechaS);
                        listaTextFieldsDinamicos.get(2).setText(equipoExistir.getLogo());
                        listaTextFieldsDinamicos.get(3).setText(equipoExistir.getColor());
                        cv.insertarEquipoCompeticion(equipoExistir.getIdEquipo(),idCompeticion);
                    }
                    else {
                        // Insertar equipo e insertarlo en la competición.
                        Equipo equipo = new Equipo();
                        equipo.setNomEquipo(nombre);
                        equipo.setFechaFundacion(fechaFundacion);
                        equipo.setLogo(logo);
                        equipo.setColor(color);
                        cv.insertarEquipo(equipo);

                        Equipo equipoInsertado = cv.buscarEquipoPorNombre(equipo.getNomEquipo());
                        cv.insertarEquipoCompeticion(equipoInsertado.getIdEquipo(),idCompeticion);
                        // Ahora obtener el ID del equipo insertado.
                        va.mostrarMensaje("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                        System.out.println("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                        limpiarCasillasClase(listaTextFieldsDinamicos);
                    }
                    
                }
                else
                    va.mostrarMensaje("Por favor, rellene todas las casillas.");

            }
            else {
                if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty() && !logo.isEmpty() &&
                        !color.isEmpty()){
                    // Crear un nuevo equipo y añadirle los atributos necesarios.
                    Equipo equipo = new Equipo();
                    equipo.setNomEquipo(nombre);
                    equipo.setFechaFundacion(fechaFundacion);
                    equipo.setLogo(logo);
                    equipo.setColor(color);
                    cv.insertarEquipo(equipo);
                    // Ahora obtener el ID del equipo insertado.
                    Equipo equipoInsertado = cv.buscarEquipoPorNombre(nombre);
                    va.mostrarMensaje("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                    System.out.println("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                    limpiarCasillasClase(listaTextFieldsDinamicos);
                }
                else
                    va.mostrarMensaje("Por favor, rellene todas las casillas.");
            }

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un equipo.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un equipo.\n" +ex.getMessage());
        }
    }
    public void borrarEquipo(String nombre, String logo, String color, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Con solo la casilla del nombre rellenada.
            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty() && logo.isEmpty() &&
                    color.isEmpty() && listaTextFieldsDinamicos.get(4).getText().isEmpty()){
                Equipo equipo = cv.buscarEquipoPorNombre(nombre);
                cv.borrarEquipo(equipo.getIdEquipo());
                va.mostrarMensaje("Equipo eliminado correctamente.");
                System.out.println("Equipo eliminado correctamente.");
                limpiarCasillasClase(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un equipo.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un equipo.\n" +ex.getMessage());
        }
    }
    public void modificarEquipo(String nombre, Date fechaFundacion, String logo, String color, int idCompeticion,
                                ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Si el id_competicion ha sido seleccionado:
            // TODO : hacer para que se pueda modificar el id de la competición en la que está ese equipo también.

            // Con la casilla del nombre rellenada, se clica en "Actualizar" y aparecen los datos
            //  del objeto existente. Cuando se vuelva a clicar deben estar las casillas rellendas para modificar el objeto.
            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty() && logo.isEmpty()
                    && color.isEmpty()){
                if (!datosRellenados){
                    Equipo equipo =  cv.buscarEquipoPorNombre(nombre);
                    LocalDate fechaFundacionLD = equipo.getFechaFundacion().toLocalDate();
                    String fechaS = fechaFundacionLD.format(formatoFecha);
                    listaTextFieldsDinamicos.get(1).setText(fechaS);
                    listaTextFieldsDinamicos.get(2).setText(equipo.getLogo());
                    listaTextFieldsDinamicos.get(3).setText(equipo.getColor());
                    datosRellenados = true;
                }
            } else if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty() &&
                    !listaTextFieldsDinamicos.get(2).getText().isEmpty()) {
                if (datosRellenados){
                    // Modificar un equipo solo.
                    Equipo equipo = new Equipo();
                    equipo.setNomEquipo(nombre);
                    equipo.setFechaFundacion(fechaFundacion);
                    equipo.setLogo(logo);
                    equipo.setColor(color);
                    cv.modificarEquipo(equipo);
                    va.mostrarMensaje("Equipo modificado correctamente.");
                    System.out.println("Equipo modificado correctamente.");
                    limpiarCasillasClase(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene correctamente las casillas.");
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla del nombre para poder clicar en el " +
                        "botón `Actualizar´ y obtener los demás datos.");

        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un equipo.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un equipo.\n" +ex.getMessage());
        }
    }
    public void consultarEquipo(String nombre, String logo, String color,
                                ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Limpiar 3 casillas.
            listaTextFieldsDinamicos.get(1).setText("");
            listaTextFieldsDinamicos.get(2).setText("");
            listaTextFieldsDinamicos.get(3).setText("");

            // Con la casilla del nombre rellenada, se clica en "Consultar" y aparecen los demás datos del objeto existente.
            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty() && logo.isEmpty()
                    && color.isEmpty()){
                Equipo equipo =  cv.buscarEquipoPorNombre(nombre);
                LocalDate fechaFundacionLD = equipo.getFechaFundacion().toLocalDate();
                String fechaS = fechaFundacionLD.format(formatoFecha);
                listaTextFieldsDinamicos.get(1).setText(fechaS);
                listaTextFieldsDinamicos.get(2).setText(equipo.getLogo());
                listaTextFieldsDinamicos.get(3).setText(equipo.getColor());
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un equipo.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un equipo.\n" +ex.getMessage());
        }
    }

    // Operaciones con jugadores
    public void insertarJugador(String nombre, String nickname, String nacionalidad, String rol, Date fechaNacimiento,
                                int idEquipo, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un jugador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un jugador.\n" +ex.getMessage());
        }
    }
    public void borrarJugador(String nombre, String nickname, String nacionalidad, String rol, Date fechaNacimiento,
                              int idEquipo, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un jugador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un jugador.\n" +ex.getMessage());
        }
    }
    public void modificarJugador(String nombre, String nickname, String nacionalidad, String rol, Date fechaNacimiento,
                                 int idEquipo, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un jugador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un jugador.\n" +ex.getMessage());
        }
    }
    public void consultarJugador(String nombre, String nickname, String nacionalidad, String rol, Date fechaNacimiento,
                                 int idEquipo, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un jugador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un jugador.\n" +ex.getMessage());
        }
    }

    // Operaciones con staff
    public void insertarStaff(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un staff.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un staff.\n" +ex.getMessage());
        }
    }
    public void borrarStaff(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un staff.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un staff.\n" +ex.getMessage());
        }
    }
    public void modificarStaff(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un staff.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un staff.\n" +ex.getMessage());
        }
    }
    public void consultarStaff(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un staff.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un staff.\n" +ex.getMessage());
        }
    }

    // Operaciones con patrocinadores
    public void insertarPatrocinador(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un patrocinador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un patrocinador.\n" +ex.getMessage());
        }
    }
    public void borrarPatrocinador(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un patrocinador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un patrocinador.\n" +ex.getMessage());
        }
    }
    public void modificarPatrocinador(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un patrocinador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un patrocinador.\n" +ex.getMessage());
        }
    }
    public void consultarPatrocinador(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un patrocinador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un patrocinador.\n" +ex.getMessage());
        }
    }

    // Operaciones con juegos
    public void insertarJuego(String nombre, String empresa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Con todos los datos rellenados.
            if (!nombre.isEmpty() && !empresa.isEmpty() && !listaTextFieldsDinamicos.get(2).getText().isEmpty()) {
                Juego juego = new Juego();
                juego.setNombre(nombre);
                juego.setEmpresa(empresa);
                LocalDate fechaLanzamientoLD = LocalDate.parse(listaTextFieldsDinamicos.get(2).getText(),
                                                DateTimeFormatter.ofPattern("dd-MM-yy"));
                Date fechaLanzamiento = Date.valueOf(fechaLanzamientoLD);
                juego.setFechaLanzamiento(fechaLanzamiento);
                cv.insertarJuego(juego);
                Juego juegoInsertado = cv.buscarJuegoPorNombre(nombre);
                va.mostrarMensaje("El juego insertado tiene el ID ➤ " + juegoInsertado.getIdJuego() + ".");
                System.out.println("El juego insertado tiene el ID ➤ " + juegoInsertado.getIdJuego() + ".");
                limpiarCasillasClase(listaTextFieldsDinamicos);
            }
            else {
                va.mostrarMensaje("Por favor, rellene todas las casillas.");
            }

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un juego.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un juego.\n" +ex.getMessage());
        }
    }
    public void borrarJuego(String nombre, String empresa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Con solo la casilla del nombre rellenada.
            if (!nombre.isEmpty() && empresa.isEmpty() && listaTextFieldsDinamicos.get(2).getText().isEmpty()){
                Juego juego = cv.buscarJuegoPorNombre(nombre);
                cv.borrarJuego(juego.getIdJuego());
                va.mostrarMensaje("Juego eliminado correctamente.");
                System.out.println("Juego eliminado correctamente.");
                limpiarCasillasClase(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un juego.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un juego.\n" +ex.getMessage());
        }
    }
    public void modificarJuego(String nombre, String empresa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Con la casilla del nombre rellenada, se clica en "Actualizar" y aparecen los datos
            //  del objeto existente. Cuando se vuelva a clicar deben estar las casillas rellendas para modificar el objeto.
            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty() &&
                    listaTextFieldsDinamicos.get(2).getText().isEmpty()){
                if (!datosRellenados){
                    Juego juego = cv.buscarJuegoPorNombre(nombre);
                    listaTextFieldsDinamicos.get(1).setText(juego.getEmpresa());
                    LocalDate fechaLanzamientoLD = juego.getFechaLanzamiento().toLocalDate();
                    String fechaS = fechaLanzamientoLD.format(formatoFecha);
                    listaTextFieldsDinamicos.get(2).setText(fechaS);
                    datosRellenados = true;
                }
            } else if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty() &&
                    !listaTextFieldsDinamicos.get(2).getText().isEmpty()) {
                if (datosRellenados){
                    Juego juego = new Juego();
                    juego.setNombre(nombre);
                    juego.setEmpresa(empresa);
                    LocalDate fechaLanzamientoLD = LocalDate.parse(listaTextFieldsDinamicos.get(2).getText(),
                                                    formatoFecha);
                    Date fechaLanzamiento = Date.valueOf(fechaLanzamientoLD);
                    juego.setFechaLanzamiento(fechaLanzamiento);
                    cv.modificarJuego(juego);
                    va.mostrarMensaje("Juego modificado correctamente.");
                    System.out.println("Juego modificado correctamente.");
                    limpiarCasillasClase(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene correctamente las casillas.");
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla del nombre para poder clicar en el " +
                        "botón `Actualizar´ y obtener los demás datos.");

        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un juego.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un juego.\n" +ex.getMessage());
        }
    }
    public void consultarJuego(String nombre, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Limpiar 2 casillas.
            listaTextFieldsDinamicos.get(1).setText("");
            listaTextFieldsDinamicos.get(2).setText("");
            // Con la casilla del nombre rellenada, se clica en "Consultar" y aparecen los demás datos del objeto existente.
            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty() &&
                    listaTextFieldsDinamicos.get(2).getText().isEmpty()){
                Juego juego = cv.buscarJuegoPorNombre(nombre);
                listaTextFieldsDinamicos.get(1).setText(juego.getEmpresa());
                LocalDate fechaLanzamientoLD = juego.getFechaLanzamiento().toLocalDate();
                String fechaS = fechaLanzamientoLD.format(formatoFecha);
                listaTextFieldsDinamicos.get(2).setText(fechaS);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un juego.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un juego.\n" +ex.getMessage());
        }
    }

    // Operaciones con competiciones
    public void insertarCompeticion(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un competición.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un competición.\n" +ex.getMessage());
        }
    }
    public void borrarCompeticion(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un competición.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un competición.\n" +ex.getMessage());
        }
    }
    public void modificarCompeticion(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un competición.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un competición.\n" +ex.getMessage());
        }
    }
    public void consultarCompeticion(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un competición.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un competición.\n" +ex.getMessage());
        }
    }

    // Operaciones con enfrentamientos
    public void insertarEnfrentamiento(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un enfrentamiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un enfrentamiento.\n" +ex.getMessage());
        }
    }
    public void borrarEnfrentamiento(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un enfrentamiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un enfrentamiento.\n" +ex.getMessage());
        }
    }
    public void modificarEnfrentamiento(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un enfrentamiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un enfrentamiento.\n" +ex.getMessage());
        }
    }
    public void consultarEnfrentamiento(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un enfrentamiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un enfrentamiento.\n" +ex.getMessage());
        }
    }

    // Operaciones con jornadas
    public void insertarJornada(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un jornada.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un jornada.\n" +ex.getMessage());
        }
    }
    public void borrarJornada(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un jornada.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un jornada.\n" +ex.getMessage());
        }
    }
    public void modificarJornada(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un jornada.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un jornada.\n" +ex.getMessage());
        }
    }
    public void consultarJornada(){
        try {

            //

        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un jornada.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un jornada.\n" +ex.getMessage());
        }
    }

    /**
     * Función para limpiar todas las casillas que hay en los CRUD.
     * Eliminará el contenido de todos los textfield que hay dentro del ArrayList correspondiente a las casillas
     * de las columnas de una tabla de la BD.
     *
     * @author Lorena
     * @param listaTextFieldsDinamicos
     */
    public void limpiarCasillasClase(ArrayList<JTextField> listaTextFieldsDinamicos) {
        for (JTextField textField : listaTextFieldsDinamicos) {
            textField.setText("");
        }
    }

}
