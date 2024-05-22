package Controlador.ControladoresVista;

import Modelo.Equipo;
import Modelo.Juego;
import Modelo.Jugador;
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
                case "CRUD Equipos" -> va.mostrarDatosEquipos();
                case "CRUD Jugadores" -> va.mostrarDatosJugadores();
                case "CRUD Staff" -> va.mostrarDatosStaff();
                case "CRUD Patrocinadores" -> va.mostrarDatosPatrocinadores();
                case "CRUD Juegos" -> va.mostrarDatosJuegos();
                case "CRUD Competiciones" -> va.mostrarDatosCompeticiones();
                case "CRUD Enfrentamientos" -> va.mostrarDatosEnfrentamientos();
                case "CRUD Jornadas" -> va.mostrarDatosJornadas();
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

                        switch (accionElegida){
                            case "Insertar" -> {
                                if (listaTextFieldsDinamicos.size() == 3) {
                                    Juego juego = new Juego();
                                    juego.setNombre(listaTextFieldsDinamicos.get(0).getText());
                                    juego.setEmpresa(listaTextFieldsDinamicos.get(1).getText());
                                    LocalDate fechaLanzamiento = LocalDate.parse(listaTextFieldsDinamicos.get(2).getText(), DateTimeFormatter.ofPattern("dd-MM-yy"));
                                    juego.setFechaLanzamiento(Date.valueOf(fechaLanzamiento));
                                    cv.insertarJuego(juego);
                                    Juego juegoInsertado = cv.buscarJuegoPorNombre(juego.getNombre());
                                    va.mostrarMensaje("El juego insertado tiene el ID ➤ " + juegoInsertado.getIdJuego() + ".");
                                    System.out.println("El juego insertado tiene el ID ➤ " + juegoInsertado.getIdJuego() + ".");
                                }
                                else
                                    System.out.println("Error por cantidad de atributos de juegos.");
                            }
                            case "Eliminar" -> {

                            }
                            case "Actualizar" -> {

                            }
                            case "Consultar" -> {

                            }
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

    public VentanaAdmin obtenerVentana(){
        return va;
    }
}
