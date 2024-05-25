package Controlador.ControladoresVista;

import Vista.VentanaXML;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador XMLs
 * ControladorVxml se encarga de manejar la lógica de la vista para la ventana de XML.
 *
 * @author Zahir
 */
public class ControladorVxml {
    private VentanaXML vx;
    private ControladorVista cv;

    /**
     * Constructor que inicializa el controlador con una instancia de ControladorVista.
     *
     * @param cv la instancia de ControladorVista.
     */
    public ControladorVxml(ControladorVista cv) {
        this.cv = cv;
    }

    /**
     * Crea y muestra la ventana de XML, agregando los ActionListeners correspondientes.
     *
     * @param ventanaEliminar la ventana que será reemplazada por la nueva ventana de XML.
     */
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

    /**
     * Clase interna que maneja el evento de acción para el botón de tienda.
     */
    public class BTiendaAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda(vx);
        }
    }

    /**
     * Clase interna que maneja el evento de acción para el botón de inicio.
     */
    public class BInicioAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(vx);
        }
    }

    /**
     * Clase interna que maneja el evento de acción para el botón de salir.
     */
    public class BSalirAL implements ActionListener {
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
     * Clase interna que maneja el evento de acción para el botón de Facebook.
     */
    public static class BFacebookAL implements ActionListener {
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
     * Clase interna que maneja el evento de acción para el botón de Instagram.
     */
    public static class BInstagramAL implements ActionListener {
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
     * Clase interna que maneja el evento de acción para el botón de Twitter.
     */
    public static class BTwitterAL implements ActionListener {
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
     * Clase interna que maneja el evento de acción para el menú de jornadas.
     */
    public class MJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarJornadas(vx);
        }
    }

    /**
     * Clase interna que maneja el evento de acción para el menú de clasificación.
     */
    public class MClasificacionAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(vx);
        }
    }

    /**
     * Clase interna que maneja el evento de acción para el menú de equipos.
     */
    public class MEquiposAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(vx);
        }
    }

    /**
     * Clase interna que maneja el evento de acción para la selección de XML en el ComboBox.
     */
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
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al obtener XML de Clasificación: " + ex.getMessage());
                    }
                    break;
            }
        }
    }

    /**
     * Clase interna que maneja el evento de acción para copiar el contenido DTD al portapapeles.
     */
    public class btDTD implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = vx.getTaXMLDTD().getText();
            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            JOptionPane.showMessageDialog(null, "Texto copiado al portapapeles.");
        }
    }

    /**
     * Clase interna que maneja el evento de acción para copiar el contenido XSD al portapapeles.
     */
    public class btXSD implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = vx.getTaXMLXSD().getText();
            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            JOptionPane.showMessageDialog(null, "Texto copiado al portapapeles.");
        }
    }
}
