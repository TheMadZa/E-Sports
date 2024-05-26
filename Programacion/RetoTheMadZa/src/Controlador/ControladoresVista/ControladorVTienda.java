package Controlador.ControladoresVista;

import Vista.VentanaTienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para la ventana de la tienda.
 *
 * @author Ibai, Lorena
 */
public class ControladorVTienda {
    private VentanaTienda vt;
    private final ControladorVista cv;
    private JFrame ventanaEliminar;

    /**
     * Constructor de ControladorVTienda.
     *
     * @param cv Controlador de la vista principal.
     */
    public ControladorVTienda(ControladorVista cv) {
        this.cv = cv;
    }

    /**
     * Crea y muestra la ventana de la tienda.
     *
     * @param ventanaEliminar Ventana principal que se va a ocultar.
     */
    public void crearMostrar(JFrame ventanaEliminar) {
        this.ventanaEliminar = ventanaEliminar;
        vt = new VentanaTienda(ventanaEliminar);

        // Action Listeners de los botones y demás.
        vt.addBSalirAL(new BSalirAL());
        vt.addBFacebookAL(new BFacebookAL());
        vt.addBInstagramAL(new BInstagramAL());
        vt.addBTwitterAL(new BTwitterAL());
        vt.addMJornadasAL(new MJornadasAL());
        vt.addMClasificacionAL(new MClasificacionAL());
        vt.addMEquiposAL(new MEquiposAL());
        vt.addBInicioAL(new BInicioAL());
        vt.addBBuyAL(new BBuyAL());
        vt.addBThemadzaAL(new BThemadzaAL());
    }

    /**
     * Acción para salir de la aplicación.
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
            abrirEnlace("https://www.facebook.com/?locale=es_ES");
        }
    }
    /**
     * ActionListener para el botón de Instagram.
     */
    public static class BInstagramAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            abrirEnlace("https://www.instagram.com");
        }
    }
    /**
     * ActionListener para el botón de Twitter.
     */
    public static class BTwitterAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            abrirEnlace("https://twitter.com/?logout=1715768138184");
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
     * Acción para mostrar las jornadas.
     */
    public class MJornadasAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarJornadas(vt);
        }
    }

    /**
     * Acción para mostrar la clasificación.
     */
    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(vt);
        }
    }

    /**
     * Acción para mostrar los equipos.
     */
    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(vt);
        }
    }

    /**
     * Acción para mostrar la ventana de inicio de sesión.
     */
    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(vt);
        }
    }

    /**
     * Acción para mostrar un mensaje de compra.
     */
    public class BBuyAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vt.mostrarMensajeBuy();
        }
    }

    /**
     * Acción para mostrar la ventana desde la que se activó la VTienda.
     * Esta ventana se eliminará y se mostrará la VAdmin o VUser (volverá a la anterior), como si fuese la ventana principal.
     */
    public class BThemadzaAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vt.dispose();
            ventanaEliminar.setVisible(true);
        }
    }
}