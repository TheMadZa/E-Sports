package Controlador.ControladoresVista;

import Modelo.Competicion;
import Vista.VentanaInicioSesion;
import Vista.VentanaUser;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;

public class ControladorVUser {

    private VentanaUser vu;
    private ControladorVista cv;

    public ControladorVUser(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(VentanaInicioSesion vis) {
        vu = new VentanaUser(vis);

        llenarComboBox();

        // Action Listeners de los botones y demás.
        vu.addBTiendaAL(new BTiendaAL());
        vu.addBInicioAL(new BInicioAL());
        vu.addBSalirAL(new BSalirAL());
        vu.addBFacebookAL(new BFacebookAL());
        vu.addBInstagramAL(new BInstagramAL());
        vu.addBTwitterAL(new BTwitterAL());
        vu.addMJornadasAL(new MJornadasAL());
        vu.addMClasificacionAL(new MClasificacionAL());
        vu.addMEquiposAL(new MEquiposAL());
        vu.addCbClasificacionAL(new CbClasificacionAL());
    }



    public class BTiendaAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda(vu);
        }
    }

    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO : cerrar sesión y volver a v inicio sesion
            cv.mostrarInicioSesion(vu);
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
            cv.mostrarJornadas(vu);
        }
    }

    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(vu);
        }
    }

    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(vu);
        }
    }

    public class CbClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nombreSeleccionado = String.valueOf(vu.getCbClasificacion().getSelectedItem());
                if (nombreSeleccionado != null && !nombreSeleccionado.isEmpty()){
                    rellenarTablaEquiposCompeticion(nombreSeleccionado);
                }
            }
            catch (Exception ex) {
                vu.mostrarMensaje(ex.getMessage());
            }

        }
    }

    /**
     * Función que muestra los datos de los equipos según la competición.
     * Se rellena la tabla con los 5 equipos con más victorias de la competición seleccionada en el JComboBox.
     *
     * @author Julen
     * @author Lorena
     * @param nombreSeleccionado
     * @throws Exception
     */
    public void rellenarTablaEquiposCompeticion(String nombreSeleccionado) throws Exception {

        // Obtener un array multidimensional (5F·3C) con los datos de los equipos de la competición seleccionada.
        String[][] listaCompeticiones = cv.buscarEquiposPorNombreCom(nombreSeleccionado);

        // Aparecerán los 5 equipos con más victorias.
        vu.getvEquipo1().setText(String.valueOf(listaCompeticiones[0][1]));
        vu.getpEquipo1().setText(String.valueOf(listaCompeticiones[0][2]));
        vu.getvEquipo2().setText(String.valueOf(listaCompeticiones[1][1]));
        vu.getpEquipo2().setText(String.valueOf(listaCompeticiones[1][2]));
        vu.getvEquipo3().setText(String.valueOf(listaCompeticiones[2][1]));
        vu.getpEquipo3().setText(String.valueOf(listaCompeticiones[2][2]));
        vu.getvEquipo4().setText(String.valueOf(listaCompeticiones[3][1]));
        vu.getpEquipo4().setText(String.valueOf(listaCompeticiones[3][2]));
        vu.getvEquipo5().setText(String.valueOf(listaCompeticiones[4][1]));
        vu.getpEquipo5().setText(String.valueOf(listaCompeticiones[4][2]));

        /*
        String Equipo1 = listaCompeticiones[0][0];
        cargarImagenEstablecerIcono("Equipo1", 55, 55, vi.getEquipo1());
        */

        // Poner las imágenes de sus logos.
        URL Equipo1 = new URL(listaCompeticiones[0][0]);
        BufferedImage imagenOriginal1 = ImageIO.read(Equipo1);
        BufferedImage bufferedImage1 = Scalr.resize(imagenOriginal1, 55);
        ImageIcon iconoEscalado1 = new ImageIcon(bufferedImage1);
        vu.getEquipo1().setIcon(iconoEscalado1);

        URL Equipo2 = new URL(listaCompeticiones[1][0]);
        BufferedImage imagenOriginal2 = ImageIO.read(Equipo2);
        BufferedImage bufferedImage2 = Scalr.resize(imagenOriginal2, 55);
        ImageIcon iconoEscalado2 = new ImageIcon(bufferedImage2);
        vu.getEquipo2().setIcon(iconoEscalado2);

        URL Equipo3 = new URL(listaCompeticiones[2][0]);
        BufferedImage imagenOriginal3 = ImageIO.read(Equipo3);
        BufferedImage bufferedImage3 = Scalr.resize(imagenOriginal3, 55);
        ImageIcon iconoEscalado3 = new ImageIcon(bufferedImage3);
        vu.getEquipo3().setIcon(iconoEscalado3);

        URL Equipo4 = new URL(listaCompeticiones[3][0]);
        BufferedImage imagenOriginal4 = ImageIO.read(Equipo4);
        BufferedImage bufferedImage4 = Scalr.resize(imagenOriginal4, 55);
        ImageIcon iconoEscalado4 = new ImageIcon(bufferedImage4);
        vu.getEquipo4().setIcon(iconoEscalado4);

        URL Equipo5 = new URL(listaCompeticiones[4][0]);
        BufferedImage imagenOriginal5 = ImageIO.read(Equipo5);
        BufferedImage bufferedImage5 = Scalr.resize(imagenOriginal5, 55);
        ImageIcon iconoEscalado5 = new ImageIcon(bufferedImage5);
        vu.getEquipo5().setIcon(iconoEscalado5);

    }

    public void llenarComboBox(){
        try {
            vu.getCbClasificacion().removeAllItems();
            List<Competicion> listaCompeticiones = cv.buscarTodasCompeticiones();

            for (Competicion competicion : listaCompeticiones){
                vu.getCbClasificacion().addItem(competicion.getNombreCom());
            }

            vu.getCbClasificacion().setSelectedIndex(-1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

}
