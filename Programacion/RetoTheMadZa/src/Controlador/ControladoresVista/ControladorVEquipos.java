package Controlador.ControladoresVista;

import Modelo.Equipo;
import Vista.VentanaEquipos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la ventana de visualización de equipos.
 */

public class ControladorVEquipos {

    private VentanaEquipos ve;
    private ControladorVista cv;
    private ControladorImagenes ci;
    private int posicionEquipo;
    private int posicionArray;
    private List<Equipo> equipos;

    /**
     * Constructor del controlador de equipos.
     * @param cv Controlador de la vista principal.
     */

    public ControladorVEquipos(ControladorVista cv)
    {
        this.cv = cv;
    }
    /**
     * Crea y muestra la ventana de equipos.
     * @param ventanaEliminar Ventana padre que se eliminará al abrir la ventana de equipos.
     */

    public void crearMostrar(JFrame ventanaEliminar) {

        ve = new VentanaEquipos(ventanaEliminar);

        try {
            obtenerEquipos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Agregar ActionListener a los botones y elementos de la ventana
        ve.addBFlechaIzquAL(new BFlechaIzquAL());
        ve.addBFlechaDrchAL(new BFlechaDrchAL());
        ve.addBTiendaAL(new BTiendaAL());
        ve.addBInicioAL(new BInicioAL());
        ve.addBSalirAL(new BSalirAL());
        ve.addBFacebookAL(new BFacebookAL());
        ve.addBInstagramAL(new BInstagramAL());
        ve.addBTwitterAL(new BTwitterAL());
        ve.addMJornadasAL(new MJornadasAL());
        ve.addMClasificacionAL(new MClasificacionAL());
        ve.addMEquiposAL(new MEquiposAL());

    }
    /**
     * Obtiene los equipos de la base de datos y muestra el primero en la ventana.
     * @throws Exception Si hay un error al obtener los equipos.
     */

    public void obtenerEquipos() throws Exception{
        try {
            equipos = cv.cargarEquiposDesdeBD();
            if (!equipos.isEmpty()) {
                ve.setNombreEquipo(equipos.get(0).getNomEquipo());
                ve.cargarImagenEstablecerIcono(equipos.get(0).getLogo(), 400, 400, ve.getlImagen());
                posicionEquipo = 0;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron equipos.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * ActionListener para el botón de flecha izquierda.
     */
    public class BFlechaIzquAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                posicionEquipo--;
                actualizarBotones();
                ve.cargarImagenEstablecerIcono("Equipo" + equipos.get(posicionEquipo).getIdEquipo(), 400, 400, ve.getlImagen());
                ve.setNombreEquipo(equipos.get(posicionEquipo).getNomEquipo());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        private void actualizarBotones() {
            ve.getbDerecha().setEnabled(posicionEquipo < equipos.size() - 1);
            ve.getbIzquierda().setEnabled(posicionEquipo > 0);
        }
    }

    /**
     * ActionListener para el botón de flecha derecha.
     */

    public class BFlechaDrchAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                posicionEquipo++;
                actualizarBotones();
                ve.cargarImagenEstablecerIcono("Equipo" + equipos.get(posicionEquipo).getIdEquipo(), 400, 400, ve.getlImagen());
                ve.setNombreEquipo(equipos.get(posicionEquipo).getNomEquipo());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        private void actualizarBotones() {
            ve.getbDerecha().setEnabled(posicionEquipo < equipos.size() - 1);
            ve.getbIzquierda().setEnabled(posicionEquipo > 0);
        }
    }

    /**
     * ActionListener para el botón de tienda.
     */

    public class BTiendaAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda(ve);
        }
    }
    /**
     * ActionListener para el botón de inicio.
     */

    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(ve);
        }
    }
    /**
     * ActionListener para el botón de salir.
     */
    public class BSalirAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.cerrarConexion();
                System.exit(0);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    /**
     * ActionListener para el botón de Facebook.
     */
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
    /**
     * ActionListener para el botón de Instagram.
     */
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
    /**
     * ActionListener para el botón de Twitter.
     */
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
    /**
     * Abre un enlace externo en el navegador predeterminado.
     * @param enlace Enlace a abrir.
     */
    private static void abrirEnlace(String enlace) {
        try {
            Desktop.getDesktop().browse(java.net.URI.create(enlace));
        } catch (java.io.IOException ex) {
            System.out.println("Error al abrir el enlace: " + ex.getMessage());
        }
    }
    /**
     * ActionListener para el menú de Jornadas.
     */
    public class MJornadasAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarJornadas(ve);
        }
    }
    /**
     * ActionListener para el menú de Clasificación.
     */
    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(ve);
        }
    }
    /**
     * ActionListener para el menú de Equipos.
     */
    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(ve);
        }
    }

}