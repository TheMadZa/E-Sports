package Controlador.ControladoresVista;

import Vista.VentanaClasificacion;
import Vista.VentanaXML;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVxml {
    public VentanaXML vx;

    public ControladorVista cv;

    public ControladorVxml(ControladorVista cv) {
        this.cv = cv;
    }
    public void crearMostrar(JFrame ventanaEliminar) {

        vx = new VentanaXML(ventanaEliminar);

        vx.addBTiendaAL(new BTiendaAL());
        vx.addBInicioAL(new BInicioAL());
        vx.addBSalirAL(new BSalirAL());
        vx.addBFacebookAL(new BFacebookAL());
        vx.addBInstagramAL(new BInstagramAL());
        vx.addBTwitterAL(new BTwitterAL());
        vx.addMJornadasAL(new MJornadasAL());
        vx.addMClasificacionAL(new MClasificacionAL());
        vx.addMEquiposAL(new MEquiposAL());
        vx.addXML(new CbXML());
        vx.addbtDTD(new btDTD());
        vx.addbtXSD(new btXSD());
    }

    public class BTiendaAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda(vx);
        }
    }

    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO : cerrar sesión y volver a v inicio sesion
            cv.mostrarInicioSesion(vx);
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
            cv.mostrarJornadas(vx);
        }
    }

    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(vx);
        }
    }

    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(vx);
        }
    }

    public class CbXML implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedItem = String.valueOf(vx.getCbXMLSelec().getSelectedItem());
                switch (selectedItem) {
                    case "Clasificacion":
                        try {
                            String resultDTD = cv.obtenerXMLClasificacionDTD();
                            String resultXSD = cv.obtenerXMLClasificacionXSD();
                            vx.getTaXMLDTD().setText(resultDTD);
                            vx.getTaXMLXSD().setText(resultXSD);
                        } catch (Exception ex) {
                            // Manejo más detallado de la excepción
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al obtener XML de Clasificación: " + ex.getMessage());
                        }
                        break;
                    case "Jornadas":
                        try {
                            String resultDTD = cv.obtenerXMLJornadasDTD();
                            String resultXSD = cv.obtenerXMLJornadasXSD();
                            vx.getTaXMLDTD().setText(resultDTD);
                            vx.getTaXMLXSD().setText(resultXSD);
                        } catch (Exception ex) {
                            // Manejo más detallado de la excepción
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al obtener XML de Clasificación: " + ex.getMessage());
                        }
                        break;
                    case "UltimaJornada":
                        try {
                            String resultDTD = cv.obtenerXMLUltimaJornadaDTD();
                            String resultXSD = cv.obtenerXMLUltimaJornadaXSD();
                            vx.getTaXMLDTD().setText(resultDTD);
                            vx.getTaXMLXSD().setText(resultXSD);
                        } catch (Exception ex) {
                            // Manejo más detallado de la excepción
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al obtener XML de Clasificación: " + ex.getMessage());
                        }
                        break;

                }

        }
    }
    public class btDTD implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener el texto del JTextArea
            String text = vx.getTaXMLDTD().getText();

            // Crear un StringSelection con el texto
            StringSelection stringSelection = new StringSelection(text);

            // Obtener el portapapeles del sistema
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Establecer el contenido del portapapeles
            clipboard.setContents(stringSelection, null);

            // Opcional: mostrar un mensaje de confirmación
            JOptionPane.showMessageDialog(null, "Texto copiado al portapapeles.");
        }
    }
    public class btXSD implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener el texto del JTextArea
            String text = vx.getTaXMLXSD().getText();

            // Crear un StringSelection con el texto
            StringSelection stringSelection = new StringSelection(text);

            // Obtener el portapapeles del sistema
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Establecer el contenido del portapapeles
            clipboard.setContents(stringSelection, null);

            // Opcional: mostrar un mensaje de confirmación
            JOptionPane.showMessageDialog(null, "Texto copiado al portapapeles.");
        }
    }

}
