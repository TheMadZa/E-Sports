package Controlador.ControladoresVista;

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
                        /*
                        // El equipo tendrá nombre, fecha, logo, color, y puede que el id de la competición.

                        // Obtener lista con los JTextFields para poder obtener los datos introducidos.
                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        switch (accionElegida){
                            case "Insertar" -> {

                                // TODO : PONER FUNCIONES PARA TODO (PASARLE EL listaTextFieldsDinamicos)

                                // VERIFICAR LO DEL ID_COMPETICION.

                                // Verificar si la posición 4 del ArrayList existe y no es null. Si existe, entonces habrá que buscar el equipo y añadirlo a la competición.
                                if (listaTextFieldsDinamicos.size() > 4 && listaTextFieldsDinamicos.get(4) != null) {

                                    Equipo equipoExistir = cv.buscarEquipoPorNombre(listaTextFieldsDinamicos.get(0).getText());

                                    // Si el equipo ya existe:
                                    if (equipoExistir != null) {
                                        // Mostrar datos e insertarlo en la competición.
                                        listaTextFieldsDinamicos.get(1).setText(String.valueOf(equipoExistir.getFechaFundacion()));
                                        listaTextFieldsDinamicos.get(2).setText(equipoExistir.getLogo());
                                        listaTextFieldsDinamicos.get(3).setText(equipoExistir.getColor());
                                        int idCompeticion = Integer.parseInt(listaTextFieldsDinamicos.get(4).getText());
                                        cv.insertarEquipoCompeticion(equipoExistir.getIdEquipo(),idCompeticion);
                                    }
                                    else {
                                        // Insertar equipo e insertarlo en la competición.
                                        Equipo equipo = new Equipo();
                                        equipo.setNomEquipo(listaTextFieldsDinamicos.get(0).getText());
                                        //String fechaString = listaTextFieldsDinamicos.get(1).getText();
                                        //LocalDate fechaDate = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                        equipo.setFechaFundacion(Date.valueOf(listaTextFieldsDinamicos.get(1).getText()));
                                        equipo.setLogo(listaTextFieldsDinamicos.get(2).getText());
                                        equipo.setColor(listaTextFieldsDinamicos.get(3).getText());
                                        cv.insertarEquipo(equipo);
                                        Equipo equipoInsertado = cv.buscarEquipoPorNombre(equipo.getNomEquipo());
                                        int idCompeticion = Integer.parseInt(listaTextFieldsDinamicos.get(4).getText());
                                        cv.insertarEquipoCompeticion(equipoInsertado.getIdEquipo(),idCompeticion);
                                        // Ahora obtener el ID del equipo insertado.
                                        va.mostrarMensaje("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                                        System.out.println("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                                    }

                                }
                                else {
                                    // Crear un nuevo equipo y añadirle los atributos necesarios.
                                    Equipo equipo = new Equipo();
                                    equipo.setNomEquipo(listaTextFieldsDinamicos.get(0).getText());
                                    equipo.setFechaFundacion(Date.valueOf(listaTextFieldsDinamicos.get(1).getText()));
                                    equipo.setLogo(listaTextFieldsDinamicos.get(2).getText());
                                    equipo.setColor(listaTextFieldsDinamicos.get(3).getText());
                                    cv.insertarEquipo(equipo);
                                    // Ahora obtener el ID del equipo insertado.
                                    Equipo equipoInsertado = cv.buscarEquipoPorNombre(listaTextFieldsDinamicos.get(0).getText());
                                    va.mostrarMensaje("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                                    System.out.println("El equipo insertado tiene el ID --> " +equipoInsertado.getIdEquipo()+ ".");
                                }

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
                    case "CRUD Jugadores" -> {
                        /*

                        ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();

                        switch (accionElegida){
                            case "Insertar" -> {
                                agregarElemento("Nombre:", new JTextField(), gbc);
                                agregarElemento("Nickname:", new JTextField(), gbc);
                                agregarElemento("Nacionalidad:", new JTextField(), gbc);
                                agregarElemento("Rol:", new JTextField(), gbc);
                                agregarElemento("Fecha de nacimiento:", new JTextField(), gbc);
                                agregarElemento("Sueldo:", new JTextField(), gbc);
                                agregarElemento("ID de su equipo:", new JTextField(), gbc);

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

                    }
                    case "CRUD Patrocinadores" -> {

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

                    }
                    case "CRUD Enfrentamientos" -> {

                    }
                    case "CRUD Jornadas" -> {

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

    // Operaciones con juegos
    public void insertarJuego(String nombre, String empresa, ArrayList<JTextField> listaTextFieldsDinamicos){
        try {

            // Con todos los datos rellenados.
            if (!nombre.isEmpty() && !empresa.isEmpty() && !listaTextFieldsDinamicos.get(2).getText().isEmpty()) {
                Juego juego = new Juego();
                juego.setNombre(nombre);
                juego.setEmpresa(empresa);
                LocalDate fechaLanzamientoLD = LocalDate.parse(listaTextFieldsDinamicos.get(2).getText(), DateTimeFormatter.ofPattern("dd-MM-yy"));
                Date fechaLanzamiento = Date.valueOf(fechaLanzamientoLD);
                juego.setFechaLanzamiento(fechaLanzamiento);
                cv.insertarJuego(juego);
                Juego juegoInsertado = cv.buscarJuegoPorNombre(nombre);
                va.mostrarMensaje("El juego insertado tiene el ID ➤ " + juegoInsertado.getIdJuego() + ".");
                System.out.println("El juego insertado tiene el ID ➤ " + juegoInsertado.getIdJuego() + ".");
                limpiarCasillasJuego(listaTextFieldsDinamicos);
            }
            else {
                System.out.println("Por favor, rellene todas las casillas.");
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
                Juego juegoInsertado = cv.buscarJuegoPorNombre(nombre);
                cv.borrarJuego(juegoInsertado.getIdJuego());
                va.mostrarMensaje("Juego eliminado correctamente.");
                System.out.println("Juego eliminado correctamente.");
                limpiarCasillasJuego(listaTextFieldsDinamicos);
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
                    String fechaS = fechaLanzamientoLD.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
                    listaTextFieldsDinamicos.get(2).setText(fechaS);
                    datosRellenados = true;
                }
            } else if (!nombre.isEmpty() && !listaTextFieldsDinamicos.get(1).getText().isEmpty() &&
                    !listaTextFieldsDinamicos.get(2).getText().isEmpty()) {
                if (datosRellenados){
                    Juego juego = new Juego();
                    juego.setNombre(nombre);
                    juego.setEmpresa(empresa);
                    LocalDate fechaLanzamientoLD = LocalDate.parse(listaTextFieldsDinamicos.get(2).getText(), DateTimeFormatter.ofPattern("dd-MM-yy"));
                    Date fechaLanzamiento = Date.valueOf(fechaLanzamientoLD);
                    juego.setFechaLanzamiento(fechaLanzamiento);
                    cv.modificarJuego(juego);
                    va.mostrarMensaje("Juego modificado correctamente.");
                    System.out.println("Juego modificado correctamente.");
                    limpiarCasillasJuego(listaTextFieldsDinamicos);
                    datosRellenados = false;
                }
                else
                    va.mostrarMensaje("Por favor, rellene correctamente las casillas."); // TODO : Poner mejor el mensaje.
            }
            else
                va.mostrarMensaje("Por favor, rellene correctamente las casillas necesarias."); // TODO : Poner mejor el mensaje.
            // TODO : Poner más excepciones.

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
                String fechaS = fechaLanzamientoLD.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
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

    public void limpiarCasillasJuego(ArrayList<JTextField> listaTextFieldsDinamicos){
        listaTextFieldsDinamicos.get(0).setText("");
        listaTextFieldsDinamicos.get(1).setText("");
        listaTextFieldsDinamicos.get(2).setText("");
    }

}
