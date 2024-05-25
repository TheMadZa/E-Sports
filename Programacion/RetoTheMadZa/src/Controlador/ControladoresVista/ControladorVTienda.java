package Controlador.ControladoresVista;

import Vista.VentanaTienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para la ventana de la tienda.
 */
public class ControladorVTienda {
    private VentanaTienda vt;
    private ControladorVista cv;

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
     * Acción para abrir Facebook en el navegador.
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
     * Acción para abrir Instagram en el navegador.
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
     * Acción para abrir Twitter en el navegador.
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
     * Acción para realizar una acción específica (a completar).
     */
    public class BThemadzaAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //cv.mostrarVPrincipal(vt,); // TODO : Poner que se muestre la VAdmin o VUser dependiendo de la V desde la que se activó la VTienda.
            // TODO : Poner para las ventanas de equipos, jornadas, clasificacion y xml también.
        }
    }
}