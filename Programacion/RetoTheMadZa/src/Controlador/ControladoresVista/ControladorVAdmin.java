package Controlador.ControladoresVista;

import Modelo.*;
import Vista.VentanaAdmin;
import Vista.VentanaInicioSesion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Controlador para la interfaz de administrador.
 */
public class ControladorVAdmin {

    private VentanaAdmin va;
    private ControladorVista cv;
    private String tablaElegida;
    private String accionElegida;
    private boolean datosRellenados = false;
    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yy");
    private final double salarioMinimo = 1134;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    /**
     * Constructor para el controlador de la interfaz de administrador.
     * @param cv Controlador de la vista principal.
     */

    public ControladorVAdmin(ControladorVista cv) {
        this.cv = cv;
    }
    /**
     * Crea y muestra la ventana de administrador.
     * @param vis Ventana de inicio de sesión.
     */
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

    /**
     * ActionListener para los botones CRUD en la interfaz de administrador.
     */
    public class MiCrudAL implements ActionListener {

        /**
         * Método que maneja los eventos de acción.
         * @param e El evento de acción.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Elimina todos los componentes del panel de datos.
            va.getpDatos().removeAll();

            // Obtiene el comando de acción del evento.
            tablaElegida = e.getActionCommand();

            // Realiza diferentes acciones según la tabla seleccionada.
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
                    // Los patrocinadores no se podrán modificar (no hace falta; con insertar y eliminar se
                    // puede obtener la misma funcionalidad).
                    va.getbActualizar().setEnabled(false);
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
                    // Los enfrentamientos no se podrán insertar (ya hay un procedimiento para ello).
                    va.getbInsertar().setEnabled(false);
                    datosRellenados = false;
                }
                case "CRUD Jornadas" -> {
                    va.mostrarDatosJornadas();
                    // Las jornadas no se podrán insertar (ya hay un procedimiento para ello).
                    va.getbInsertar().setEnabled(false);
                    datosRellenados = false;
                }
                case "CRUD Usuarios" -> {
                    va.mostrarDatosUsuarios();
                    datosRellenados = false;
                }
            }

            // Muestra el panel CRUD si está oculto.
            if (!va.getPanelCRUD().isVisible())
                va.getPanelCRUD().setVisible(true);
        }
    }
    /**
     * ActionListener para los botones de acciones en la interfaz de administrador.
     */
    public class BAccionesAL implements ActionListener {

        /**
         * Método que maneja los eventos de acción.
         * @param e El evento de acción.
         */

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
                        String logo = listaTextFieldsDinamicos.get(2).getText();
                        String color = listaTextFieldsDinamicos.get(3).getText();

                        switch (accionElegida){
                            case "Insertar" -> insertarEquipo(nombre, logo, color, listaTextFieldsDinamicos);
                            case "Eliminar" -> borrarEquipo(nombre, logo, color, listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarEquipo(nombre, logo, color, listaTextFieldsDinamicos);
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

                        switch (accionElegida){
                            case "Insertar" -> insertarJugador(nombre, nickname, nacionalidad, rol, listaTextFieldsDinamicos);
                            case "Eliminar" -> borrarJugador(nombre, nickname, nacionalidad, rol, listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarJugador(nombre, nickname, nacionalidad, rol, listaTextFieldsDinamicos);
                            case "Consultar" -> consultarJugador(nombre, nickname, nacionalidad, rol, listaTextFieldsDinamicos);
                        }

                    }
                    case "CRUD Staff" -> {

                        // El miembro del staff tendrá puesto, nombre, fecha de nacimiento, sueldo e id del equipo.

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        String puesto = listaTextFieldsDinamicos.get(0).getText();
                        String nombre = listaTextFieldsDinamicos.get(1).getText();

                        switch (accionElegida) {
                            case "Insertar" -> insertarStaff(puesto, nombre, listaTextFieldsDinamicos);
                            case "Eliminar" -> borrarStaff(nombre, listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarStaff(puesto, nombre, listaTextFieldsDinamicos);
                            case "Consultar" -> consultarStaff(nombre, listaTextFieldsDinamicos);
                        }

                    }
                    case "CRUD Patrocinadores" -> {

                        // El patrocinador tendrá nombre e id del equipo.

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        String nombre = listaTextFieldsDinamicos.get(0).getText();
                        int idEquipo = Integer.parseInt(listaTextFieldsDinamicos.get(1).getText());

                        switch (accionElegida) {
                            case "Insertar" -> insertarPatrocinador(nombre, idEquipo, listaTextFieldsDinamicos);
                            case "Eliminar" -> borrarPatrocinador(nombre, idEquipo, listaTextFieldsDinamicos);
                            case "Consultar" -> consultarPatrocinador(nombre, listaTextFieldsDinamicos);
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

                        // La competición tendrá nombre, fecha de inicio, fecha de fin, estado de la etapa, id del juego e id del posible equipo ganador.

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        String nombre = listaTextFieldsDinamicos.get(0).getText();
                        String etapa = listaTextFieldsDinamicos.get(3).getText();

                        switch (accionElegida) {
                            case "Insertar" -> insertarCompeticion(nombre, etapa, listaTextFieldsDinamicos);
                            case "Eliminar" -> borrarCompeticion(nombre, etapa, listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarCompeticion(nombre, etapa, listaTextFieldsDinamicos);
                            case "Consultar" -> consultarCompeticion(nombre, etapa, listaTextFieldsDinamicos);
                        }

                    }
                    case "CRUD Enfrentamientos" -> {

                        // El enfrentamiento tendrá id, hora, resultado del equipo 1, resultado del equipo 2, id del equipo 1, id del equipo 2 e id de la jornada.

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        switch (accionElegida) {
                            case "Eliminar" -> borrarEnfrentamiento(listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarEnfrentamiento(listaTextFieldsDinamicos);
                            case "Consultar" -> consultarEnfrentamiento(listaTextFieldsDinamicos);
                        }

                    }
                    case "CRUD Jornadas" -> {

                        // La jornada tendrá id, número de jornada, fecha e id de la competición.

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        switch (accionElegida) {
                            case "Eliminar" -> borrarJornada(listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarJornada(listaTextFieldsDinamicos);
                            case "Consultar" -> consultarJornada(listaTextFieldsDinamicos);
                        }

                    }
                    case "CRUD Usuarios" -> {

                        // El usuario tendrá nombre de usuario, contraseña y tipo de usuario.

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        String nombreUsuario = listaTextFieldsDinamicos.get(0).getText();
                        String contrasena = listaTextFieldsDinamicos.get(1).getText();
                        String tipo = listaTextFieldsDinamicos.get(2).getText();

                        switch (accionElegida) {
                            case "Insertar" -> insertarUsuario(nombreUsuario, contrasena, tipo, listaTextFieldsDinamicos);
                            case "Eliminar" -> borrarUsuario(nombreUsuario, contrasena, tipo, listaTextFieldsDinamicos);
                            case "Actualizar" -> modificarUsuario(nombreUsuario, contrasena, tipo, listaTextFieldsDinamicos);
                            case "Consultar" -> consultarUsuario(nombreUsuario, contrasena, tipo, listaTextFieldsDinamicos);
                        }

                    }

                }

            }
            catch (NumberFormatException ex){
                va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
            }
            catch (Exception ex){
                va.mostrarMensaje(ex.getMessage());
            }

        }
    }
    /**
     * ActionListener para visualizar equipos en la interfaz de administrador.
     */
    public class MiVisualizarEquiposAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Llama al método de la vista principal para mostrar equipos.
            cv.mostrarEquipos(va);
        }
    }

    /**
     * ActionListener para visualizar jornadas en la interfaz de administrador.
     */
    public class MiVisualizarJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Llama al método de la vista principal para mostrar jornadas.
            cv.mostrarJornadas(va);
        }
    }

    /**
     * ActionListener para mostrar la clasificación de jornadas en la interfaz de administrador.
     */
    public class MiClasificacionJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Llama al método de la vista principal para mostrar la clasificación.
            cv.mostrarClasificacion(va);
        }
    }

    /**
     * ActionListener para generar un archivo XML en la interfaz de administrador.
     */
    public class MGenerarXmlAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Llama al método de la vista principal para mostrar el XML.
            cv.mostrarXML(va);
        }
    }

    /**
     * ActionListener para volver a la pantalla de inicio en la interfaz de administrador.
     */
    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Llama al método de la vista principal para mostrar la pantalla de inicio de sesión.
            cv.mostrarInicioSesion(va);
        }
    }

    /**
     * ActionListener para salir de la aplicación en la interfaz de administrador.
     */
    public class BSalirAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Cierra la conexión y sale de la aplicación.
                cv.cerrarConexion();
                System.exit(0);
            } catch (Exception ex) {
                // Maneja cualquier excepción lanzando una RuntimeException.
                throw new RuntimeException(ex);
            }
        }
    }


    /**
     * ActionListener para abrir el enlace de Facebook en la interfaz de administrador.
     */
    public static class BFacebookAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Enlace de Facebook.
            String enlace = "https://www.facebook.com/?locale=es_ES";
            try {
                // Abre el enlace en el navegador web predeterminado.
                Desktop.getDesktop().browse(java.net.URI.create(enlace));
            } catch (java.io.IOException ex) {
                // Maneja cualquier excepción mostrando un mensaje de error en la consola.
                System.out.println("Error al abrir el enlace: " + ex.getMessage());
            }
        }
    }

    /**
     * ActionListener para abrir el enlace de Instagram en la interfaz de administrador.
     */
    public static class BInstagramAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Enlace de Instagram.
            String enlace = "https://www.instagram.com";
            try {
                // Abre el enlace en el navegador web predeterminado.
                Desktop.getDesktop().browse(java.net.URI.create(enlace));
            } catch (java.io.IOException ex) {
                // Maneja cualquier excepción mostrando un mensaje de error en la consola.
                System.out.println("Error al abrir el enlace: " + ex.getMessage());
            }
        }
    }

    /**
     * ActionListener para abrir el enlace de Twitter en la interfaz de administrador.
     */
    public static class BTwitterAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Enlace de Twitter.
            String enlace = "https://twitter.com/?logout=1715768138184";
            try {
                // Abre el enlace en el navegador web predeterminado.
                Desktop.getDesktop().browse(java.net.URI.create(enlace));
            } catch (java.io.IOException ex) {
                // Maneja cualquier excepción mostrando un mensaje de error en la consola.
                System.out.println("Error al abrir el enlace: " + ex.getMessage());
            }
        }
    }


    // Funciones

    // Operaciones con equipos
    /**
     * Inserta un equipo en la base de datos, opcionalmente asociándolo a una competición.
     * @param nombre El nombre del equipo.
     * @param logo El logo del equipo.
     * @param color El color del equipo.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos que contienen los datos del equipo.
     */
    public void insertarEquipo(String nombre, String logo, String color,
                               ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // VERIFICAR LO DEL ID_COMPETICION.
            // Verificar si la posición 4 del ArrayList existe y no es null. Si existe, entonces habrá que buscar el equipo y añadirlo a la competición.
            if (listaTextFieldsDinamicos.size() == 5 && !listaTextFieldsDinamicos.get(4).getText().isEmpty()) {

//                if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty() && !logo.isEmpty() &&
//                        !color.isEmpty() && !listaTextFieldsDinamicos.get(4).getText().isEmpty()){

                    Equipo equipoExistir = cv.buscarEquipoPorNombre(nombre);

                    // Con solo las casillas del nombre y del id de la competición rellenadas:
                    // Si el equipo ya existe:
                    if (equipoExistir != null && cv.buscarCompeticion(Integer.valueOf(
                            listaTextFieldsDinamicos.get(4).getText())) != null) {
                        // Mostrar datos e insertarlo en la competición.
//                        LocalDate fechaFundacionLD = equipoExistir.getFechaFundacion().toLocalDate();
//                        String fechaS = fechaFundacionLD.format(formatoFecha);
//                        listaTextFieldsDinamicos.get(1).setText(fechaS);
//                        listaTextFieldsDinamicos.get(2).setText(equipoExistir.getLogo());
//                        listaTextFieldsDinamicos.get(3).setText(equipoExistir.getColor());
                        cv.insertarEquipoCompeticion(equipoExistir.getIdEquipo(),
                                Integer.parseInt(listaTextFieldsDinamicos.get(4).getText()));
                        va.mostrarMensaje("Relación de equipo con competición implementada correctamente.");
                        System.out.println("Relación de equipo con competición implementada correctamente.");
                    }
                    else {
                        // Insertar equipo e insertarlo en la competición.
                        Equipo equipo = new Equipo();
                        equipo.setNomEquipo(nombre);
                        LocalDate fechaFundacionLD = LocalDate.parse(listaTextFieldsDinamicos.get(1).getText(),
                                formatoFecha);
                        Date fechaFundacion = Date.valueOf(fechaFundacionLD);
                        equipo.setFechaFundacion(fechaFundacion);
                        equipo.setLogo(logo);
                        equipo.setColor(color);
                        cv.insertarEquipo(equipo);

                        Equipo equipoInsertado = cv.buscarEquipoPorNombre(equipo.getNomEquipo());
                        cv.insertarEquipoCompeticion(equipoInsertado.getIdEquipo(),
                                Integer.parseInt(listaTextFieldsDinamicos.get(4).getText()));
                        // Ahora obtener el ID del equipo insertado.
                        va.mostrarMensaje("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                        System.out.println("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                        va.mostrarMensaje("Relación de equipo con competición implementada correctamente.");
                        System.out.println("Relación de equipo con competición implementada correctamente.");
                        limpiarCasillasVentana(listaTextFieldsDinamicos);
                    }

//                }
//                else
//                    va.mostrarMensaje("Por favor, rellene todas las casillas.");

            }
            else {
                if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty() && !logo.isEmpty() &&
                        !color.isEmpty()){
                    // Crear un nuevo equipo y añadirle los atributos necesarios.
                    Equipo equipo = new Equipo();
                    equipo.setNomEquipo(nombre);
                    LocalDate fechaFundacionLD = LocalDate.parse(listaTextFieldsDinamicos.get(1).getText(),
                            formatoFecha);
                    Date fechaFundacion = Date.valueOf(fechaFundacionLD);
                    equipo.setFechaFundacion(fechaFundacion);
                    equipo.setLogo(logo);
                    equipo.setColor(color);
                    cv.insertarEquipo(equipo);
                    // Ahora obtener el ID del equipo insertado.
                    Equipo equipoInsertado = cv.buscarEquipoPorNombre(nombre);
                    va.mostrarMensaje("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                    System.out.println("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                }
                else
                    va.mostrarMensaje("Por favor, rellene todas las casillas.");
            }

        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de fundación.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un equipo.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un equipo.\n" +ex.getMessage());
        }
    }
    /**
     * Elimina un equipo de la base de datos.
     * @param nombre El nombre del equipo a eliminar.
     * @param logo El logo del equipo (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param color El color del equipo (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void borrarEquipo(String nombre, String logo, String color, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Con solo la casilla del nombre rellenada.
            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty() && logo.isEmpty() &&
                    color.isEmpty() && listaTextFieldsDinamicos.get(4).getText().isEmpty()){
                Equipo equipo = cv.buscarEquipoPorNombre(nombre);
                cv.borrarEquipo(equipo.getIdEquipo());
                va.mostrarMensaje("Equipo eliminado correctamente.");
                System.out.println("Equipo eliminado correctamente.");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un equipo.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un equipo.\n" +ex.getMessage());
        }
    }
    /**
     * Modifica un equipo en la base de datos.
     * @param nombre El nombre del equipo a modificar.
     * @param logo El nuevo logo del equipo.
     * @param color El nuevo color del equipo.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos que contienen los datos del equipo.
     */
    public void modificarEquipo(String nombre, String logo, String color,
                                ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

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
                    Equipo equipo = new Equipo();
                    equipo.setNomEquipo(nombre);
                    LocalDate fechaFundacionLD = LocalDate.parse(listaTextFieldsDinamicos.get(1).getText(),
                            formatoFecha);
                    Date fechaFundacion = Date.valueOf(fechaFundacionLD);
                    equipo.setFechaFundacion(fechaFundacion);
                    equipo.setLogo(logo);
                    equipo.setColor(color);
                    cv.modificarEquipo(equipo);
                    va.mostrarMensaje("Equipo modificado correctamente.");
                    System.out.println("Equipo modificado correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene correctamente las casillas.");
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla del nombre para poder clicar en el " +
                        "botón `Actualizar´ y obtener los demás datos.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de fundación.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un equipo.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un equipo.\n" +ex.getMessage());
        }
    }
    /**
     * Consulta los datos de un equipo en la base de datos y los muestra en los campos de texto correspondientes.
     * @param nombre El nombre del equipo a consultar.
     * @param logo El logo del equipo (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param color El color del equipo (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
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
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de fundación.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un equipo.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un equipo.\n" +ex.getMessage());
        }
    }

    // Operaciones con jugadores
    /**
     * Inserta un nuevo jugador en la base de datos.
     * @param nombre El nombre del jugador.
     * @param nickname El apodo del jugador.
     * @param nacionalidad La nacionalidad del jugador.
     * @param rol El rol del jugador.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos que contienen los datos del jugador.
     */
    public void insertarJugador(String nombre, String nickname, String nacionalidad, String rol, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombre.isEmpty() && !nickname.isEmpty() && !nacionalidad.isEmpty() && !rol.isEmpty()
                    && !listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(5).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(6).getText().isEmpty()){

                // Validar dato 'Rol'
                if (rol.equals("Lider") || rol.equals("Jugador")){
                    // Validar dato 'Sueldo'
                    if (Double.parseDouble(listaTextFieldsDinamicos.get(5).getText()) > salarioMinimo){

                        Jugador jugador = new Jugador();
                        jugador.setNombre(nombre);
                        jugador.setNickname(nickname);
                        jugador.setNacionalidad(nacionalidad);
                        jugador.setRol(rol);

                        String fechaNacimientoS = listaTextFieldsDinamicos.get(4).getText();
                        LocalDate fechaNacimientoLD = LocalDate.parse(fechaNacimientoS, formatoFecha);
                        Date fechaNacimiento = Date.valueOf(fechaNacimientoLD);
                        jugador.setFechaNac(fechaNacimiento);

                        String sueldoS = listaTextFieldsDinamicos.get(5).getText();
                        double sueldo = Double.parseDouble(sueldoS);
                        jugador.setSueldo(sueldo);

                        Equipo equipo = cv.buscarEquipo(Integer.valueOf(listaTextFieldsDinamicos.get(6).getText()));
                        jugador.setEquipo(equipo);
                        cv.insertarJugador(jugador);
                        // Ahora obtener el ID del jugador insertado.
                        Jugador jugadorInsertado = cv.buscarJugadorPorNombre(nombre);
                        va.mostrarMensaje("El jugador insertado tiene el ID --> " +jugadorInsertado.getIdJugador()+ ".");
                        System.out.println("El jugador insertado tiene el ID --> " +jugadorInsertado.getIdJugador()+ ".");

                    }
                    else {
                        throw new Exception("EL sueldo debe ser mayor que " +salarioMinimo+ ".");
                    }
                }
                else {
                    throw new Exception("El rol debe ser `Lider´ o `Jugador´.");
                }

            }
            else {
                va.mostrarMensaje("Por favor, rellene todas las casillas.");
            }

        }
        catch (DateTimeParseException ex){
            System.out.println("Error relacionado con la fecha de nacimiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error relacionado con la fecha de nacimiento.\n" +ex.getMessage());
        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un jugador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un jugador.\n" +ex.getMessage());
        }
    }
    /**
     * Elimina un jugador de la base de datos.
     * @param nombre El nombre del jugador a eliminar.
     * @param nickname El apodo del jugador (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param nacionalidad La nacionalidad del jugador (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param rol El rol del jugador (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void borrarJugador(String nombre, String nickname, String nacionalidad, String rol, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombre.isEmpty() && nickname.isEmpty() && nacionalidad.isEmpty() && rol.isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(5).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(6).getText().isEmpty()){

                Jugador jugador = cv.buscarJugadorPorNombre(nombre);
                cv.borrarJugador(jugador.getIdJugador());
                va.mostrarMensaje("Jugador eliminado correctamente.");
                System.out.println("Jugador eliminado correctamente.");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un jugador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un jugador.\n" +ex.getMessage());
        }
    }
    /**
     * Modifica los datos de un jugador en la base de datos.
     * @param nombre El nombre del jugador.
     * @param nickname El apodo del jugador.
     * @param nacionalidad La nacionalidad del jugador.
     * @param rol El rol del jugador.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos que contienen los datos del jugador.
     */
    public void modificarJugador(String nombre, String nickname, String nacionalidad, String rol, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombre.isEmpty() && nickname.isEmpty() && nacionalidad.isEmpty() && rol.isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(5).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(6).getText().isEmpty()){
                if (!datosRellenados){
                    Jugador jugador = cv.buscarJugadorPorNombre(nombre);
                    listaTextFieldsDinamicos.get(1).setText(jugador.getNickname());
                    listaTextFieldsDinamicos.get(2).setText(jugador.getNacionalidad());
                    listaTextFieldsDinamicos.get(3).setText(jugador.getRol());
                    LocalDate fechaNacimientoLD = jugador.getFechaNac().toLocalDate();
                    String fechaNacimientoS = fechaNacimientoLD.format(formatoFecha);
                    listaTextFieldsDinamicos.get(4).setText(fechaNacimientoS);
                    listaTextFieldsDinamicos.get(5).setText(String.valueOf(jugador.getSueldo()));
                    Jugador j = cv.buscarJugadorPorNombre(nombre);
                    listaTextFieldsDinamicos.get(6).setText(String.valueOf(j.getEquipo().getIdEquipo()));
                    datosRellenados = true;
                }
            } else if (!nombre.isEmpty() && !nickname.isEmpty() && !nacionalidad.isEmpty() && !rol.isEmpty()
                    && !listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(5).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(6).getText().isEmpty()) {
                if (datosRellenados){
                    Jugador j = new Jugador();
                    j.setNombre(nombre);
                    j.setNickname(nickname);
                    j.setNacionalidad(nacionalidad);
                    j.setRol(rol);
                    LocalDate fechaNacimientoLD = LocalDate.parse(listaTextFieldsDinamicos.get(4).getText(),
                            formatoFecha);
                    Date fechaNacimiento = Date.valueOf(fechaNacimientoLD);
                    j.setFechaNac(fechaNacimiento);
                    j.setSueldo(Double.parseDouble(listaTextFieldsDinamicos.get(5).getText()));
                    Equipo e = new Equipo();
                    e.setIdEquipo(Integer.parseInt(listaTextFieldsDinamicos.get(6).getText()));
                    j.setEquipo(e);
                    cv.modificarJugador(j);
                    va.mostrarMensaje("Jugador modificado correctamente.");
                    System.out.println("Jugador modificado correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene correctamente las casillas.");
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla del nombre para poder clicar en el " +
                        "botón `Actualizar´ y obtener los demás datos.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de nacimiento.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un jugador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un jugador.\n" +ex.getMessage());
        }
    }
    /**
     * Consulta los datos de un jugador en la base de datos y los muestra en los campos de texto dinámicos.
     * @param nombre El nombre del jugador a consultar.
     * @param nickname El apodo del jugador (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param nacionalidad La nacionalidad del jugador (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param rol El rol del jugador (no se utiliza en esta operación pero se incluye para mantener la firma del método).
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void consultarJugador(String nombre, String nickname, String nacionalidad, String rol, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            listaTextFieldsDinamicos.get(1).setText("");
            listaTextFieldsDinamicos.get(2).setText("");
            listaTextFieldsDinamicos.get(3).setText("");
            listaTextFieldsDinamicos.get(4).setText("");
            listaTextFieldsDinamicos.get(5).setText("");
            listaTextFieldsDinamicos.get(6).setText("");

            if (!nombre.isEmpty() && nickname.isEmpty() && nacionalidad.isEmpty() && rol.isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(5).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(6).getText().isEmpty()){
                Jugador j = cv.buscarJugadorPorNombre(nombre);
                listaTextFieldsDinamicos.get(1).setText(j.getNickname());
                listaTextFieldsDinamicos.get(2).setText(j.getNacionalidad());
                listaTextFieldsDinamicos.get(3).setText(j.getRol());
                LocalDate fechaNacimientoLD = j.getFechaNac().toLocalDate();
                String fechaNacimientoS = fechaNacimientoLD.format(formatoFecha);
                listaTextFieldsDinamicos.get(4).setText(fechaNacimientoS);
                listaTextFieldsDinamicos.get(5).setText(String.valueOf(j.getSueldo()));
                listaTextFieldsDinamicos.get(6).setText(String.valueOf(j.getEquipo().getIdEquipo()));
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de nacimiento.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un jugador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un jugador.\n" +ex.getMessage());
        }
    }

    // Operaciones con staff
    /**
     * Inserta un miembro del staff en la base de datos.
     * @param puesto El puesto del miembro del staff.
     * @param nombre El nombre del miembro del staff.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void insertarStaff(String puesto, String nombre, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!puesto.isEmpty() && !nombre.isEmpty() && !listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(3).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(4).getText().isEmpty()) {
                Staff staff = new Staff();
                staff.setPuesto(puesto);
                staff.setNombre(nombre);
                String fechaNacimientoS = listaTextFieldsDinamicos.get(2).getText();
                LocalDate fechaNacimientoLD = LocalDate.parse(fechaNacimientoS, formatoFecha);
                Date fechaNacimiento = Date.valueOf(fechaNacimientoLD);
                staff.setFechaNac(fechaNacimiento);
                staff.setSueldo(Double.parseDouble(listaTextFieldsDinamicos.get(3).getText()));
                Equipo equipo = cv.buscarEquipo(Integer.valueOf(listaTextFieldsDinamicos.get(4).getText()));
                staff.setEquipo(equipo);
                cv.insertarStaff(staff);
                Staff staffInsertado = cv.buscarStaffPorNombre(nombre);
                va.mostrarMensaje("El staff insertado tiene el ID ➤ " + staffInsertado.getIdStaff() + ".");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else {
                va.mostrarMensaje("Por favor, rellene todas las casillas.");
            }

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de nacimiento.\n" +ex.getMessage());
        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un staff.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un staff.\n" +ex.getMessage());
        }
    }
    /**
     * Elimina un miembro del staff de la base de datos.
     * @param nombre El nombre del miembro del staff a eliminar.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void borrarStaff(String nombre, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombre.isEmpty()) {
                Staff staff = cv.buscarStaffPorNombre(nombre);
                cv.borrarStaff(staff.getIdStaff());
                va.mostrarMensaje("Staff eliminado correctamente.");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else {
                va.mostrarMensaje("Por favor, rellene la casilla correspondiente al nombre.");
            }

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un staff.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un staff.\n" +ex.getMessage());
        }
    }
    /**
     * Modifica un miembro del staff en la base de datos.
     * @param puesto El puesto actualizado del miembro del staff.
     * @param nombre El nombre del miembro del staff.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void modificarStaff(String puesto, String nombre, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombre.isEmpty() && puesto.isEmpty() && listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(3).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()) {
                if (!datosRellenados) {
                    Staff staff = cv.buscarStaffPorNombre(nombre);
                    listaTextFieldsDinamicos.get(0).setText(staff.getPuesto());
                    LocalDate fechaNacimientoLD = staff.getFechaNac().toLocalDate();
                    String fechaNacimientoS = fechaNacimientoLD.format(formatoFecha);
                    listaTextFieldsDinamicos.get(2).setText(fechaNacimientoS);
                    listaTextFieldsDinamicos.get(3).setText(String.valueOf(staff.getSueldo()));
                    listaTextFieldsDinamicos.get(4).setText(String.valueOf(staff.getEquipo().getIdEquipo()));
                    datosRellenados = true;
                }
            }
            else if (!nombre.isEmpty() && !puesto.isEmpty() && !listaTextFieldsDinamicos.get(2).getText().isEmpty() &&
                    !listaTextFieldsDinamicos.get(3).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(4).getText().isEmpty()) {
                if (datosRellenados) {
                    Staff staff = new Staff();
                    staff.setPuesto(puesto);
                    staff.setNombre(nombre);
                    String fechaNacimientoS = listaTextFieldsDinamicos.get(2).getText();
                    LocalDate fechaNacimientoLD = LocalDate.parse(fechaNacimientoS, formatoFecha);
                    Date fechaNacimiento = Date.valueOf(fechaNacimientoLD);
                    staff.setFechaNac(fechaNacimiento);
                    staff.setSueldo(Double.parseDouble(listaTextFieldsDinamicos.get(3).getText()));
                    Equipo equipo = new Equipo();
                    equipo.setIdEquipo(Integer.parseInt(listaTextFieldsDinamicos.get(4).getText()));
                    staff.setEquipo(equipo);
                    cv.modificarStaff(staff);
                    va.mostrarMensaje("Staff modificado correctamente.");
                    System.out.println("Staff modificado correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene las casillas correctamente.");
            }
            else
                va.mostrarMensaje("Por favor, rellene las casillas correctamente.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de nacimiento.\n" +ex.getMessage());
        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un staff.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un staff.\n" +ex.getMessage());
        }
    }
    /**
     * Consulta la información de un miembro del staff en la base de datos y muestra los detalles en los campos de texto.
     * @param nombre El nombre del miembro del staff a consultar.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void consultarStaff(String nombre, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            /*
            String fechaNacimientoS = listaTextFieldsDinamicos.get(2).getText();
                        LocalDate fechaNacimientoLD = LocalDate.parse(fechaNacimientoS, formatoFecha);
                        Date fechaNacimiento = Date.valueOf(fechaNacimientoLD);
                        double sueldo = Double.parseDouble(listaTextFieldsDinamicos.get(3).getText());
                        int idEquipo = Integer.parseInt(listaTextFieldsDinamicos.get(4).getText());
             */
            // El miembro del staff tendrá puesto, nombre, fecha de nacimiento, sueldo e id del equipo.

            listaTextFieldsDinamicos.get(0).setText("");
            listaTextFieldsDinamicos.get(2).setText("");
            listaTextFieldsDinamicos.get(3).setText("");
            listaTextFieldsDinamicos.get(4).setText("");
            if (!nombre.isEmpty()) {
                Staff staff = cv.buscarStaffPorNombre(nombre);
                listaTextFieldsDinamicos.get(0).setText(staff.getPuesto());
                LocalDate fechaNacimientoLD = staff.getFechaNac().toLocalDate();
                String fechaNacimientoS = fechaNacimientoLD.format(formatoFecha);
                listaTextFieldsDinamicos.get(2).setText(fechaNacimientoS);
                listaTextFieldsDinamicos.get(3).setText(String.valueOf(staff.getSueldo()));
                listaTextFieldsDinamicos.get(4).setText(String.valueOf(staff.getEquipo().getIdEquipo()));
            }
            else {
                va.mostrarMensaje("Por favor, rellene la casilla correspondiente al nombre.");
            }

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de nacimiento.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un staff.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un staff.\n" +ex.getMessage());
        }
    }

    // Operaciones con patrocinadores

    // Puede patrocinar más de un equipo. Así que puede que solo habría que añadirlo a PATROCINADORES_EQUIPOS
    //  (y no hay que insertar un nuevo patrocinador, ya que ese ya existe).
    /**
     * Inserta un patrocinador en la base de datos y establece su relación con un equipo.
     * @param nombre El nombre del patrocinador a insertar.
     * @param idEquipo El ID del equipo que el patrocinador patrocina.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void insertarPatrocinador(String nombre, int idEquipo, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty()) {
                // Insertar en Patrocinadores_equipos y puede que en Patrocinadores.

                Patrocinador patrocinadorExistente = cv.buscarPatrocinadorPorNombre(nombre);
                // Si el patrocinador no existe, hay que insertar en 2 tablas:
                if (patrocinadorExistente == null){
                    Patrocinador patrocinador = new Patrocinador();
                    patrocinador.setNombre(nombre);
                    cv.insertarPatrocinador(patrocinador);

                    Patrocinador patrocinadorInsertado = cv.buscarPatrocinadorPorNombre(nombre);
                    cv.insertarPatrocinadorEquipo(patrocinadorInsertado.getIdPatrocinador(),idEquipo);

                    va.mostrarMensaje("El patrocinador insertado tiene el ID ➤ " + patrocinadorInsertado.getIdPatrocinador() + ".");
                    System.out.println("El patrocinador insertado tiene el ID ➤ " + patrocinadorInsertado.getIdPatrocinador() + ".");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                }
                // Si el patrocinador sí existe, hay que insertar en 1 tabla:
                else {
                    cv.insertarPatrocinadorEquipo(patrocinadorExistente.getIdPatrocinador(),idEquipo);

                    va.mostrarMensaje("Relación de patrocinador con equipo implementada correctamente.");
                    System.out.println("Relación de patrocinador con equipo implementada correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                }
            }
            else
                va.mostrarMensaje("Por favor, rellene correctamente las 2 casillas.");

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un patrocinador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un patrocinador.\n" +ex.getMessage());
        }
    }
    /**
     * Elimina un patrocinador de la base de datos o su relación con un equipo.
     * @param nombre El nombre del patrocinador a eliminar.
     * @param idEquipo El ID del equipo cuya relación con el patrocinador
     */
    public void borrarPatrocinador(String nombre, int idEquipo, ArrayList<JTextField> listaTextFieldsDinamicos){
        // Se podrá desvincular con un equipo que patrocina (eliminar una fila de 'Patrocinadores_equipos') o eliminar un patrocinador.
        try {
            // Si solo hay que borrar un patrocinador:
            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty()) {
                Patrocinador patrocinador = cv.buscarPatrocinadorPorNombre(nombre);
                if (patrocinador != null){
                    cv.borrarPatrocinador(patrocinador.getIdPatrocinador());
                    va.mostrarMensaje("Patrocinador eliminado correctamente.");
                    System.out.println("Patrocinador eliminado correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                }
                else
                    va.mostrarMensaje("El patrocinador especificado no existe.");
            }
            // Si hay que borrar de 'Patrocinadores_equipos':
            else if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty()) {
                Patrocinador patrocinadorExistente = cv.buscarPatrocinadorPorNombre(nombre);
                if (patrocinadorExistente != null) {
                    cv.borrarPatrocinadorEquipo(patrocinadorExistente.getIdPatrocinador(),idEquipo);
                    va.mostrarMensaje("Relación de patrocinador con equipo eliminada correctamente.");
                    System.out.println("Relación de patrocinador con equipo eliminada correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                }
                else
                    va.mostrarMensaje("El patrocinador especificado no existe.");
            }
            else
                va.mostrarMensaje("Por favor, rellene las casillas correspondientes.");

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un patrocinador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un patrocinador.\n" +ex.getMessage());
        }
    }
    /**
     * Consulta la información de un patrocinador en la base de datos y muestra los detalles en los campos de texto.
     * @param nombre El nombre del patrocinador a consultar.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void consultarPatrocinador(String nombre, ArrayList<JTextField> listaTextFieldsDinamicos){
        // Obtendrá los ID de los equipos que patrocina.
        try {

            listaTextFieldsDinamicos.get(1).setText("");
            // TODO : hay que poner algo en la 2ª casilla; si no devuelve mal.
            if (!nombre.isEmpty()) {

                Patrocinador p = cv.buscarPatrocinadorPorNombre(nombre);
                if (p != null) {
                    ArrayList<Integer> listaEquiposPatrocinador = cv.buscarEquiposPatrocinador(p.getIdPatrocinador());

                    // Convertir la lista de IDs en una cadena separada por comas.
                    StringBuilder equiposTexto = new StringBuilder();
                    for (Integer idEquipo : listaEquiposPatrocinador) {
                        if (!equiposTexto.isEmpty()) {
                            equiposTexto.append(", ");
                        }
                        equiposTexto.append(idEquipo);
                    }
                    // Establecer el texto en el TextField.
                    listaTextFieldsDinamicos.get(1).setText(String.valueOf(equiposTexto));
                }
                else
                    va.mostrarMensaje("El patrocinador especificado no existe.");

            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");


        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un patrocinador.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un patrocinador.\n" +ex.getMessage());
        }
    }

    // Operaciones con juegos
    /**
     * Inserta un nuevo juego en la base de datos.
     * @param nombre El nombre del juego a insertar.
     * @param empresa La empresa desarrolladora del juego.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void insertarJuego(String nombre, String empresa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Con todos los datos rellenados.
            if (!nombre.isEmpty() && !empresa.isEmpty() && !listaTextFieldsDinamicos.get(2).getText().isEmpty()) {
                Juego juego = new Juego();
                juego.setNombre(nombre);
                juego.setEmpresa(empresa);
                LocalDate fechaLanzamientoLD = LocalDate.parse(listaTextFieldsDinamicos.get(2).getText(), formatoFecha);
                Date fechaLanzamiento = Date.valueOf(fechaLanzamientoLD);
                juego.setFechaLanzamiento(fechaLanzamiento);
                cv.insertarJuego(juego);
                Juego juegoInsertado = cv.buscarJuegoPorNombre(nombre);
                va.mostrarMensaje("El juego insertado tiene el ID ➤ " + juegoInsertado.getIdJuego() + ".");
                System.out.println("El juego insertado tiene el ID ➤ " + juegoInsertado.getIdJuego() + ".");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else {
                va.mostrarMensaje("Por favor, rellene todas las casillas.");
            }

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de lanzamiento.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un juego.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un juego.\n" +ex.getMessage());
        }
    }
    /**
     * Elimina un juego de la base de datos.
     * @param nombre El nombre del juego a eliminar.
     * @param empresa La empresa desarrolladora del juego.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void borrarJuego(String nombre, String empresa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Con solo la casilla del nombre rellenada.
            if (!nombre.isEmpty() && empresa.isEmpty() && listaTextFieldsDinamicos.get(2).getText().isEmpty()){
                Juego juego = cv.buscarJuegoPorNombre(nombre);
                cv.borrarJuego(juego.getIdJuego());
                va.mostrarMensaje("Juego eliminado correctamente.");
                System.out.println("Juego eliminado correctamente.");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un juego.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un juego.\n" +ex.getMessage());
        }
    }
    /**
     * Modifica los datos de un juego en la base de datos.
     * @param nombre El nombre del juego a modificar.
     * @param empresa La empresa desarrolladora del juego.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
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
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene correctamente las casillas.");
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla del nombre para poder clicar en el " +
                        "botón `Actualizar´ y obtener los demás datos.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de lanzamiento.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un juego.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un juego.\n" +ex.getMessage());
        }
    }
    /**
     * Consulta la información de un juego en la base de datos y muestra los detalles en los campos de texto.
     * @param nombre El nombre del juego a consultar.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
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
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha de lanzamiento.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un juego.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un juego.\n" +ex.getMessage());
        }
    }

    // Operaciones con competiciones
    /**
     * Inserta una nueva competición en la base de datos.
     * @param nombre El nombre de la competición.
     * @param etapa La etapa de la competición.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void insertarCompeticion(String nombre, String etapa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(2).getText().isEmpty() && !etapa.isEmpty()
                    && !listaTextFieldsDinamicos.get(4).getText().isEmpty()){
                Competicion c = new Competicion();
                c.setNombreCom(nombre);
                LocalDate fechaInicioLD = LocalDate.parse(listaTextFieldsDinamicos.get(1).getText(), formatoFecha);
                Date fechaInicio = Date.valueOf(fechaInicioLD);
                c.setFechaInicio(fechaInicio);
                LocalDate fechaFinLD = LocalDate.parse(listaTextFieldsDinamicos.get(2).getText(), formatoFecha);
                Date fechaFin = Date.valueOf(fechaFinLD);
                c.setFechaFin(fechaFin);
                c.setEtapa(etapa);
                Juego j = cv.buscarJuego(Integer.valueOf(listaTextFieldsDinamicos.get(4).getText()));
                c.setJuego(j);
//                Equipo e = cv.buscarEquipo(Integer.valueOf(listaTextFieldsDinamicos.get(5).getText()));
//                c.setEquipoGanador(e);
                cv.insertarCompeticion(c);
                Competicion competicion = cv.buscarCompeticionPorNombre(nombre);
                va.mostrarMensaje("La competición insertada tiene el ID ➤ " + competicion.getIdCompeticion() + ".");
                System.out.println("La competición insertada tiene el ID ➤ " + competicion.getIdCompeticion() + ".");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene todas las casillas.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con alguna fecha.\n" +ex.getMessage());
        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un competición.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un competición.\n" +ex.getMessage());
        }
    }
    /**
     * Elimina una competición de la base de datos.
     * @param nombre El nombre de la competición a eliminar.
     * @param etapa La etapa de la competición.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void borrarCompeticion(String nombre, String etapa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(2).getText().isEmpty() && etapa.isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()){
                Competicion c = cv.buscarCompeticionPorNombre(nombre);
                cv.borrarCompeticion(c.getIdCompeticion());
                va.mostrarMensaje("Competición eliminada correctamente.");
                System.out.println("Competición eliminada correctamente.");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un competición.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un competición.\n" +ex.getMessage());
        }
    }
    /**
     * Modifica una competición existente en la base de datos.
     * @param nombre El nombre de la competición.
     * @param etapa La etapa de la competición.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void modificarCompeticion(String nombre, String etapa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Se podrá añadir el equipo ganador y cambiar alguna columna.

            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(2).getText().isEmpty() && etapa.isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()){
                if (!datosRellenados){
                    Competicion c = cv.buscarCompeticionPorNombre(nombre);
                    LocalDate fechaInicioLD = c.getFechaInicio().toLocalDate();
                    String fechaInicioS = fechaInicioLD.format(formatoFecha);
                    listaTextFieldsDinamicos.get(1).setText(fechaInicioS);
                    LocalDate fechaFinLD = c.getFechaInicio().toLocalDate();
                    String fechaFinS = fechaFinLD.format(formatoFecha);
                    listaTextFieldsDinamicos.get(2).setText(fechaFinS);
                    listaTextFieldsDinamicos.get(3).setText(c.getEtapa());
                    listaTextFieldsDinamicos.get(4).setText(String.valueOf(c.getJuego().getIdJuego()));
                    listaTextFieldsDinamicos.get(5).setText(String.valueOf(c.getEquipoGanador().getIdEquipo()));
                    datosRellenados = true;
                }
            } else if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(2).getText().isEmpty() && !etapa.isEmpty()
                    && !listaTextFieldsDinamicos.get(4).getText().isEmpty()) {
                if (datosRellenados){
                    Competicion c = new Competicion();
                    c.setNombreCom(nombre);
                    LocalDate fechaInicioLD = LocalDate.parse(listaTextFieldsDinamicos.get(1).getText(), formatoFecha);
                    Date fechaInicio = Date.valueOf(fechaInicioLD);
                    c.setFechaInicio(fechaInicio);
                    LocalDate fechaFinLD = LocalDate.parse(listaTextFieldsDinamicos.get(2).getText(), formatoFecha);
                    Date fechaFin = Date.valueOf(fechaFinLD);
                    c.setFechaFin(fechaFin);
                    c.setEtapa(etapa);
                    Juego j = cv.buscarJuego(Integer.valueOf(listaTextFieldsDinamicos.get(4).getText()));
                    c.setJuego(j);
                    Equipo e = cv.buscarEquipo(Integer.valueOf(listaTextFieldsDinamicos.get(5).getText()));
                    c.setEquipoGanador(e);

                    cv.modificarCompeticion(c);
                    va.mostrarMensaje("Competición modificada correctamente.");
                    System.out.println("Competición modificada correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene correctamente las casillas.");
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla del nombre para poder clicar en el " +
                        "botón `Actualizar´ y obtener los demás datos.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con alguna fecha.\n" +ex.getMessage());
        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un competición.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un competición.\n" +ex.getMessage());
        }
    }
    /**
     * Consulta una competición en la base de datos.
     * @param nombre El nombre de la competición.
     * @param etapa La etapa de la competición.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void consultarCompeticion(String nombre, String etapa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            listaTextFieldsDinamicos.get(1).setText("");
            listaTextFieldsDinamicos.get(2).setText("");
            listaTextFieldsDinamicos.get(3).setText("");
            listaTextFieldsDinamicos.get(4).setText("");
            listaTextFieldsDinamicos.get(5).setText("");

            if (!nombre.isEmpty() && listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(2).getText().isEmpty() && etapa.isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(5).getText().isEmpty()){
                Competicion c = cv.buscarCompeticionPorNombre(nombre);
                LocalDate fechaInicioLD = c.getFechaInicio().toLocalDate();
                String fechaInicioS = fechaInicioLD.format(formatoFecha);
                listaTextFieldsDinamicos.get(1).setText(fechaInicioS);
                LocalDate fechaFinLD = c.getFechaInicio().toLocalDate();
                String fechaFinS = fechaFinLD.format(formatoFecha);
                listaTextFieldsDinamicos.get(2).setText(fechaFinS);
                listaTextFieldsDinamicos.get(3).setText(c.getEtapa());
                listaTextFieldsDinamicos.get(4).setText(String.valueOf(c.getJuego().getIdJuego()));
                listaTextFieldsDinamicos.get(5).setText(String.valueOf(c.getEquipoGanador().getIdEquipo()));
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con alguna fecha.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un competición.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un competición.\n" +ex.getMessage());
        }
    }

    // Operaciones con enfrentamientos
    /**
     * Elimina un enfrentamiento de la base de datos.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void borrarEnfrentamiento(ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!listaTextFieldsDinamicos.get(0).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(3).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(5).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(6).getText().isEmpty()){
                cv.borrarEnfrentamiento(Integer.parseInt(listaTextFieldsDinamicos.get(0).getText()));
                va.mostrarMensaje("Enfrentamiento eliminado correctamente.");
                System.out.println("Enfrentamiento eliminado correctamente.");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al ID.");

        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión del ID a un dato numérico.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un enfrentamiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un enfrentamiento.\n" +ex.getMessage());
        }
    }
    /**
     * Modifica un enfrentamiento existente en la base de datos.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void modificarEnfrentamiento(ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!listaTextFieldsDinamicos.get(0).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(3).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(5).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(6).getText().isEmpty()){
                if (!datosRellenados){
                    Enfrentamiento e = cv.buscarEnfrentamiento(Integer.parseInt(
                            listaTextFieldsDinamicos.get(0).getText()));
                    String horaEnfrentamiento = sdf.format(e.getHoraEnfrentamiento());
                    listaTextFieldsDinamicos.get(1).setText(horaEnfrentamiento);
                    listaTextFieldsDinamicos.get(2).setText(String.valueOf(e.getResultado1()));
                    listaTextFieldsDinamicos.get(3).setText(String.valueOf(e.getResultado2()));
                    listaTextFieldsDinamicos.get(4).setText(String.valueOf(e.getEquipo1().getIdEquipo()));
                    listaTextFieldsDinamicos.get(5).setText(String.valueOf(e.getEquipo2().getIdEquipo()));
                    listaTextFieldsDinamicos.get(6).setText(String.valueOf(e.getJornada().getIdJornada()));
                    datosRellenados = true;
                }
            } else if (!listaTextFieldsDinamicos.get(0).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(3).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(5).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(6).getText().isEmpty()) {
                if (datosRellenados){
                    Enfrentamiento e = new Enfrentamiento();
                    java.util.Date horaEnfrentamientoD = sdf.parse(listaTextFieldsDinamicos.get(1).getText());
                    Timestamp horaEnfrentamiento = new Timestamp(horaEnfrentamientoD.getTime());
                    //java.sql.Date horaEnfrentamientoSqlDate = new java.sql.Date(horaEnfrentamiento.getTime());
                    e.setHoraEnfrentamiento(horaEnfrentamiento);
                    e.setResultado1(Integer.parseInt(listaTextFieldsDinamicos.get(2).getText()));
                    e.setResultado2(Integer.parseInt(listaTextFieldsDinamicos.get(3).getText()));
                    Equipo equipo = new Equipo();
                    equipo.setIdEquipo(Integer.parseInt(listaTextFieldsDinamicos.get(4).getText()));
                    e.setEquipo1(equipo);
                    Equipo equipo2 = new Equipo();
                    equipo2.setIdEquipo(Integer.parseInt(listaTextFieldsDinamicos.get(5).getText()));
                    e.setEquipo2(equipo2);
                    Jornada jornada = new Jornada();
                    jornada.setIdJornada(Integer.parseInt(listaTextFieldsDinamicos.get(6).getText()));
                    e.setJornada(jornada);
                    cv.modificarEnfrentamiento(e);
                    va.mostrarMensaje("Enfrentamiento modificado correctamente.");
                    System.out.println("Enfrentamiento modificado correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene correctamente las casillas.");
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla del ID para poder clicar en el " +
                        "botón `Actualizar´ y obtener los demás datos.");

        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
        }
        catch (ParseException ex){
            System.out.println("Error relacionado con la hora del enfrentamiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error relacionado con la hora del enfrentamiento.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la modificación de un enfrentamiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un enfrentamiento.\n" +ex.getMessage());
        }
    }
    /**
     * Consulta un enfrentamiento en la base de datos y muestra sus detalles en los campos de texto dinámicos.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void consultarEnfrentamiento(ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            listaTextFieldsDinamicos.get(1).setText("");
            listaTextFieldsDinamicos.get(2).setText("");
            listaTextFieldsDinamicos.get(3).setText("");
            listaTextFieldsDinamicos.get(4).setText("");
            listaTextFieldsDinamicos.get(5).setText("");
            listaTextFieldsDinamicos.get(6).setText("");

            if (!listaTextFieldsDinamicos.get(0).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(3).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(4).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(5).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(6).getText().isEmpty()){

                Enfrentamiento e = cv.buscarEnfrentamiento(Integer.parseInt(
                        listaTextFieldsDinamicos.get(0).getText()));
                String horaEnfrentamiento = sdf.format(e.getHoraEnfrentamiento());
                listaTextFieldsDinamicos.get(1).setText(horaEnfrentamiento);
                listaTextFieldsDinamicos.get(2).setText(String.valueOf(e.getResultado1()));
                listaTextFieldsDinamicos.get(3).setText(String.valueOf(e.getResultado2()));
                listaTextFieldsDinamicos.get(4).setText(String.valueOf(e.getEquipo1().getIdEquipo()));
                listaTextFieldsDinamicos.get(5).setText(String.valueOf(e.getEquipo2().getIdEquipo()));
                listaTextFieldsDinamicos.get(6).setText(String.valueOf(e.getJornada().getIdJornada()));
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al ID.");

        }
        catch (ParseException ex){
            System.out.println("Error relacionado con la hora del enfrentamiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error relacionado con la hora del enfrentamiento.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un enfrentamiento.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un enfrentamiento.\n" +ex.getMessage());
        }
    }

    // Operaciones con jornadas
    /**
     * Elimina una jornada de la base de datos.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void borrarJornada(ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!listaTextFieldsDinamicos.get(0).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(3).getText().isEmpty()){
                cv.borrarJornada(Integer.parseInt(listaTextFieldsDinamicos.get(0).getText()));
                va.mostrarMensaje("Jornada eliminada correctamente.");
                System.out.println("Jornada eliminada correctamente.");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al ID.");

        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión del ID a un dato numérico.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de una jornada.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de una jornada.\n" +ex.getMessage());
        }
    }
    /**
     * Modifica una jornada en la base de datos.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void modificarJornada(ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!listaTextFieldsDinamicos.get(0).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(3).getText().isEmpty()){
                if (!datosRellenados){
                    Jornada jornada = cv.buscarJornada(Integer.valueOf(listaTextFieldsDinamicos.get(0).getText()));
                    listaTextFieldsDinamicos.get(1).setText(String.valueOf(jornada.getNumJornada()));
                    LocalDate fechaLD = jornada.getFechaJornada().toLocalDate();
                    String fechaS = fechaLD.format(formatoFecha);
                    listaTextFieldsDinamicos.get(2).setText(fechaS);
                    listaTextFieldsDinamicos.get(3).setText(String.valueOf(
                            jornada.getCompeticion().getIdCompeticion()));
                    datosRellenados = true;
                }
            } else if (!listaTextFieldsDinamicos.get(0).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && !listaTextFieldsDinamicos.get(3).getText().isEmpty()) {
                if (datosRellenados){
                    Jornada jornada = new Jornada();
                    jornada.setIdJornada(Integer.parseInt(listaTextFieldsDinamicos.get(0).getText()));
                    jornada.setNumJornada(Integer.parseInt(listaTextFieldsDinamicos.get(1).getText()));
                    LocalDate fechaLD = LocalDate.parse(listaTextFieldsDinamicos.get(2).getText(), formatoFecha);
                    Date fecha = Date.valueOf(fechaLD);
                    jornada.setFechaJornada(fecha);
                    Competicion c = cv.buscarCompeticion(Integer.parseInt(listaTextFieldsDinamicos.get(3).getText()));
                    jornada.setCompeticion(c);
                    cv.modificarJornada(jornada);
                    va.mostrarMensaje("Jornada modificada correctamente.");
                    System.out.println("Jornada modificada correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene correctamente las casillas.");
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla del ID para poder clicar en el " +
                        "botón `Actualizar´ y obtener los demás datos.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha.\n" +ex.getMessage());
        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la modificación de una jornada.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de una jornada.\n" +ex.getMessage());
        }
    }
    /**
     * Consulta una jornada en la base de datos y muestra sus detalles en los campos de texto dinámicos.
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void consultarJornada(ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            listaTextFieldsDinamicos.get(1).setText("");
            listaTextFieldsDinamicos.get(2).setText("");
            listaTextFieldsDinamicos.get(3).setText("");

            if (!listaTextFieldsDinamicos.get(0).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(1).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(2).getText().isEmpty()
                    && listaTextFieldsDinamicos.get(3).getText().isEmpty()){
                Jornada jornada = cv.buscarJornada(Integer.valueOf(listaTextFieldsDinamicos.get(0).getText()));
                listaTextFieldsDinamicos.get(1).setText(String.valueOf(jornada.getNumJornada()));
                LocalDate fechaLD = jornada.getFechaJornada().toLocalDate();
                String fechaS = fechaLD.format(formatoFecha);
                listaTextFieldsDinamicos.get(2).setText(fechaS);
                listaTextFieldsDinamicos.get(3).setText(String.valueOf(
                        jornada.getCompeticion().getIdCompeticion()));
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al ID.");

        }
        catch (DateTimeParseException ex){
            va.mostrarMensaje("Error relacionado con la fecha.\n" +ex.getMessage());
        }
        catch (NumberFormatException ex){
            va.mostrarMensaje("Error relacionado con la conversión de un dato numérico.\n" +ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Error en la consulta de una jornada.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de una jornada.\n" +ex.getMessage());
        }
    }

    // Operaciones con usuarios
    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param nombreUsuario Nombre de usuario del nuevo usuario.
     * @param contrasena Contraseña del nuevo usuario.
     * @param tipo Tipo de usuario ("A" para Administrador, "N" para Normal).
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void insertarUsuario(String nombreUsuario, String contrasena, String tipo,
                                ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombreUsuario.isEmpty() && !contrasena.isEmpty() && !tipo.isEmpty()) {

                if (tipo.equals("A") || tipo.equals("N")){

                    Usuario u = new Usuario();
                    u.setNomUsuario(nombreUsuario);
                    u.setContrasena(contrasena);
                    u.setTipo(tipo);
                    boolean insercionHecha = cv.insertarUsuario(u);
                    if (insercionHecha){
                        va.mostrarMensaje("Usuario insertado correctamente.");
                        System.out.println("Usuario insertado correctamente.");
                        limpiarCasillasVentana(listaTextFieldsDinamicos);
                    }

                }
                else {
                    va.mostrarMensaje("El tipo de usuario debe ser `A´ o `N´ (Administrador o Normal).");
                }

            }
            else {
                va.mostrarMensaje("Por favor, rellene todas las casillas.");
            }

        }
        catch (Exception ex){
            System.out.println("Error en la inserción de un usuario.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la inserción de un usuario.\n" +ex.getMessage());
        }
    }
    /**
     * Elimina un usuario de la base de datos.
     * @param nombreUsuario Nombre de usuario del usuario a eliminar.
     * @param contrasena Contraseña del usuario a eliminar.
     * @param tipo Tipo de usuario (no se utiliza en la eliminación).
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void borrarUsuario(String nombreUsuario, String contrasena, String tipo,
                              ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombreUsuario.isEmpty() && contrasena.isEmpty() && tipo.isEmpty()){
                cv.borrarUsuario(nombreUsuario);
                va.mostrarMensaje("Usuario eliminado correctamente.");
                System.out.println("Usuario eliminado correctamente.");
                limpiarCasillasVentana(listaTextFieldsDinamicos);
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la eliminación de un usuario.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la eliminación de un usuario.\n" +ex.getMessage());
        }
    }
    /**
     * Modifica un usuario existente en la base de datos.
     * @param nombreUsuario Nombre de usuario del usuario a modificar.
     * @param contrasena Nueva contraseña del usuario.
     * @param tipo Nuevo tipo de usuario ("A" para Administrador, "N" para Normal).
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos.
     */
    public void modificarUsuario(String nombreUsuario, String contrasena, String tipo,
                                 ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            if (!nombreUsuario.isEmpty() && contrasena.isEmpty() && tipo.isEmpty()){
                if (!datosRellenados){
                    Usuario u = cv.buscarUsuarioPorNombre(nombreUsuario);
                    listaTextFieldsDinamicos.get(1).setText(u.getContrasena());
                    listaTextFieldsDinamicos.get(2).setText(u.getTipo());
                    datosRellenados = true;
                }
            } else if (!nombreUsuario.isEmpty() && !contrasena.isEmpty() && !tipo.isEmpty()) {
                if (datosRellenados){
                    Usuario u = new Usuario();
                    u.setNomUsuario(nombreUsuario);
                    u.setContrasena(contrasena);
                    u.setTipo(tipo);
                    cv.modificarUsuario(u);
                    va.mostrarMensaje("Usuario modificado correctamente.");
                    System.out.println("Usuario modificado correctamente.");
                    limpiarCasillasVentana(listaTextFieldsDinamicos);
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
            System.out.println("Error en la modificación de un usuario.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la modificación de un usuario.\n" +ex.getMessage());
        }
    }
    /**
     * Consulta un usuario en la base de datos y muestra su información en los campos de texto dinámicos.
     * @param nombreUsuario Nombre de usuario del usuario a consultar.
     * @param contrasena Contraseña del usuario (no se utiliza en la consulta).
     * @param tipo Tipo de usuario (no se utiliza en la consulta).
     * @param listaTextFieldsDinamicos Lista de campos de texto dinámicos donde se mostrará la información del usuario.
     */
    public void consultarUsuario(String nombreUsuario, String contrasena, String tipo,
                                 ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            listaTextFieldsDinamicos.get(1).setText("");
            listaTextFieldsDinamicos.get(2).setText("");

            if (!nombreUsuario.isEmpty() && contrasena.isEmpty() && tipo.isEmpty()){
                Usuario u = cv.buscarUsuarioPorNombre(nombreUsuario);
                listaTextFieldsDinamicos.get(1).setText(u.getContrasena());
                listaTextFieldsDinamicos.get(2).setText(u.getTipo());
            }
            else
                va.mostrarMensaje("Por favor, rellene únicamente la casilla correspondiente al nombre.");

        }
        catch (Exception ex){
            System.out.println("Error en la consulta de un usuario.\n" +ex.getMessage());
            va.mostrarMensaje("Error en la consulta de un usuario.\n" +ex.getMessage());
        }
    }

    /**
     * Función para limpiar todas las casillas que hay en los CRUD.
     * Eliminará el contenido de todos los textfield que hay dentro del ArrayList, los cuales corresponden a
     * las columnas de una tabla de la BD.
     *
     * @author Lorena
     * @param listaTextFieldsDinamicos Es el ArrayList con los JTextFields que representan a las columnas de una tabla.
     */
    public void limpiarCasillasVentana(ArrayList<JTextField> listaTextFieldsDinamicos) {
        for (JTextField textField : listaTextFieldsDinamicos) {
            textField.setText("");
        }
    }
}