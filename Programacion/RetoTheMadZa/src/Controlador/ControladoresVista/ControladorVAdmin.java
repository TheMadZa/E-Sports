package Controlador.ControladoresVista;

import Modelo.Equipo;
import Vista.VentanaAdmin;
import Vista.VentanaInicioSesion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        va.addMiVisualizarJornadasAL(new MiVisualizarJornadasAL()); // TODO
        va.addMiClasificacionJornadasAL(new MiClasificacionJornadasAL()); // TODO
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
            // TODO : en el insert, después de realizar la accion, mostraría un mensaje diciendo (a parte de que "todo correcto") que el ID ha sido... (para saberlo) (en println y en showmessagedialog)

            try {

                accionElegida = e.getActionCommand();

                // Dependiendo de la tabla sobre la que queramos hacer una acción, y la acción en la BD que sea:
                switch (tablaElegida){

                    case "CRUD Equipos" -> {

                        switch (accionElegida){
                            case "Insertar" -> {
                                // Obtener lista con los JTextFields para poder obtener los datos introducidos.
                                ArrayList<JTextField> listaTextFieldsDinamicos = va.getListaTextFieldsDinamicos();
                                // Crear un nuevo equipo y añadirle los atributos necesarios.
                                Equipo equipo = new Equipo();
                                equipo.setNomEquipo(listaTextFieldsDinamicos.get(0).getText());
                                //equipo.setFechaFundacion(listaTextFieldsDinamicos.get(0).getText()); // TODO : AAAAAA
                                equipo.setLogo(listaTextFieldsDinamicos.get(0).getText());
                                equipo.setColor(listaTextFieldsDinamicos.get(0).getText());
                                cv.insertarEquipo(equipo);
                            }
                            case "Eliminar" -> va.mostrarDatosJugadores();
                            case "Actualizar" -> va.mostrarDatosStaff();
                            case "Consultar" -> va.mostrarDatosPatrocinadores();
                        }

                    }
                    case "CRUD Jugadores" -> {

                    }
                    case "CRUD Staff" -> {

                    }
                    case "CRUD Patrocinadores" -> {

                    }
                    case "CRUD Juegos" -> {

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
    public class MiVisualizarJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
    public class MiClasificacionJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO : cerrar sesión
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
}
