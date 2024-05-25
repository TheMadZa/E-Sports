package Controlador.ControladoresVista;

import Vista.VentanaTienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO : JAVADOC
public class ControladorVTienda {
    private VentanaTienda vt;
    private ControladorVista cv;

    public ControladorVTienda(ControladorVista cv) {
        this.cv = cv;
    }

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

    public class MJornadasAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarJornadas(vt);
        }
    }

    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(vt);
        }
    }

    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(vt);
        }
    }

    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(vt);
        }
    }

    public class BBuyAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vt.mostrarMensajeBuy();
        }
    }

    public class BThemadzaAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //cv.mostrarVPrincipal(vt,); // TODO : Poner que se muestre la VAdmin o VUser dependiendo de la V desde la que se activó la VTienda.
            // TODO : Poner para las ventanas de equipos, jornadas, clasificacion y xml también.
        }
    }
}