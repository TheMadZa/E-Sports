package Controlador.ControladoresVista;

import Vista.VentanaInicioSesion;
import Vista.VentanaTienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVTienda {

    private VentanaTienda vt;
    private ControladorVista cv;

    public ControladorVTienda(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        vt = new VentanaTienda();

        // Action Listeners de los botones y demás.
        vt.addBTiendaAL(new BTiendaAL());
        vt.addBInicioAL(new BInicioAL());
        vt.addBSalirAL(new BSalirAL());
        vt.addBFacebookAL(new BFacebookAL());
        vt.addBInstagramAL(new BInstagramAL());
        vt.addBTwitterAL(new BTwitterAL());
        vt.addMJornadasAL(new MJornadasAL());
        vt.addMClasificacionAL(new MClasificacionAL());
        vt.addMEquiposAL(new MEquiposAL());
        vt.addBBuyAL(new BBuyAL());
    }

    public class BTiendaAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda();
        }
    }

    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion();
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

    public class MJornadasAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class BBuyAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vt.mostrarMensajeBuy();
        }
    }

}
