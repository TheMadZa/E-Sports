package Controlador.ControladoresVista;

import Modelo.Competicion;
import Vista.VentanaClasificacion;
import Vista.VentanaInicial;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;

public class ControladorVCompeticiones {
    private VentanaInicial vi;
    private VentanaClasificacion vc;
    private ControladorVista cv;

    public ControladorVCompeticiones(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(JFrame ventanaEliminar) {

        vc = new VentanaClasificacion(ventanaEliminar);

        llenarComboBox();

        vc.addBTiendaAL(new BTiendaAL());
        vc.addBInicioAL(new BInicioAL());
        vc.addBSalirAL(new BSalirAL());
        vc.addBFacebookAL(new BFacebookAL());
        vc.addBInstagramAL(new BInstagramAL());
        vc.addBTwitterAL(new BTwitterAL());
        vc.addMJornadasAL(new MJornadasAL());
        vc.addMClasificacionAL(new MClasificacionAL());
        vc.addMEquiposAL(new MEquiposAL());
        vc.addCbCompeticionAL(new CbClasificacionAL());

    }

    public void llenarComboBox(){
        try {
            vc.getCbClasificacion().removeAllItems();
            List<Competicion> listaCompeticiones = cv.buscarTodasCompeticiones();

            for (Competicion competicion : listaCompeticiones){
                vc.getCbClasificacion().addItem(competicion.getNombreCom());
            }

            vc.getCbClasificacion().setSelectedIndex(-1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public class BTiendaAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda(vc);
        }
    }

    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO : cerrar sesión y volver a v inicio sesion
            cv.mostrarInicioSesion(vc);
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
            cv.mostrarJornadas(vc);
        }
    }

    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(vi);
        }
    }

    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(vi);
        }
    }

    public void rellenarTablaEquiposCompeticion(String nombreSeleccionado) throws Exception {

        // Obtener un array multidimensional (5F·3C) con los datos de los equipos de la competición seleccionada.
        String[][] listaCompeticiones = cv.buscarEquiposPorNombreCom(nombreSeleccionado);

        // Aparecerán los 10 equipos con más victorias en orden "victoria - puntos"
        vc.getJLvictoriasPrimero().setText(String.valueOf(listaCompeticiones[0][1]));
        vc.getJLpuntosPrimer().setText(String.valueOf(listaCompeticiones[0][2]));
        vc.getJLvictoriasSegundo().setText(String.valueOf(listaCompeticiones[1][1]));
        vc.getJLpuntosSegundo().setText(String.valueOf(listaCompeticiones[1][2]));
        vc.getJLvictoriasTercero().setText(String.valueOf(listaCompeticiones[2][1]));
        vc.getJLpuntosTercero().setText(String.valueOf(listaCompeticiones[2][2]));
        vc.getJLvictoriasCuarto().setText(String.valueOf(listaCompeticiones[3][1]));
        vc.getJLpuntosCuarto().setText(String.valueOf(listaCompeticiones[3][2]));
        vc.getJLvictoriasQuinto().setText(String.valueOf(listaCompeticiones[4][1]));
        vc.getJLpuntosQuinto().setText(String.valueOf(listaCompeticiones[4][2]));
        vc.getJLvictoriasSexto().setText(String.valueOf(listaCompeticiones[5][1]));
        vc.getJLpuntosSexto().setText(String.valueOf(listaCompeticiones[5][2]));
        vc.getJLvictoriasSeptimo().setText(String.valueOf(listaCompeticiones[6][1]));
        vc.getJLpuntosSeptimo().setText(String.valueOf(listaCompeticiones[6][2]));
        vc.getJLvictoriasOctavo().setText(String.valueOf(listaCompeticiones[7][1]));
        vc.getJLpuntosOctavo().setText(String.valueOf(listaCompeticiones[7][2]));
        vc.getJLvictoriasNoveno().setText(String.valueOf(listaCompeticiones[8][1]));
        vc.getJLpuntosNoveno().setText(String.valueOf(listaCompeticiones[8][2]));
        vc.getJLvictoriasDecimo().setText(String.valueOf(listaCompeticiones[9][1]));
        vc.getJLpuntosDecimo().setText(String.valueOf(listaCompeticiones[9][2]));

        // Los nombres de los equipos.
        vc.getJLnomPrimer().setText(String.valueOf(listaCompeticiones[0][3]));
        vc.getJLnomSegundo().setText(String.valueOf(listaCompeticiones[1][3]));
        vc.getJLnomTercer().setText(String.valueOf(listaCompeticiones[2][3]));
        vc.getJLnomCuarto().setText(String.valueOf(listaCompeticiones[3][3]));
        vc.getJLnomQuinto().setText(String.valueOf(listaCompeticiones[4][3]));
        vc.getJLnomSexto().setText(String.valueOf(listaCompeticiones[5][3]));
        vc.getJLnomSeptimo().setText(String.valueOf(listaCompeticiones[6][3]));
        vc.getJLnomOctavo().setText(String.valueOf(listaCompeticiones[7][3]));
        vc.getJLnomNoveno().setText(String.valueOf(listaCompeticiones[8][3]));
        vc.getJLnomDecimo().setText(String.valueOf(listaCompeticiones[9][3]));

        // El nombre del juego.
        vc.getTfNombreJuego().setText(String.valueOf(listaCompeticiones[0][4]));

        vc.getJLNombreCompeticion().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));
        vc.getJLNombreCompeticion2().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));
        vc.getJLNombreCompeticion3().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));
        vc.getJLNombreCompeticion4().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));
        vc.getJLNombreCompeticion5().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));
        vc.getJLNombreCompeticion6().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));
        vc.getJLNombreCompeticion7().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));
        vc.getJLNombreCompeticion8().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));
        vc.getJLNombreCompeticion9().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));
        vc.getJLNombreCompeticion10().setText(String.valueOf(vc.getCbCompeticion().getSelectedItem()));

        //String Equipo1 = listaCompeticiones[0][0];
        //cargarImagenEstablecerIcono("Equipo1", 55, 55, vi.getEquipo1());

        // Poner las imágenes de sus logos.
        URL Equipo1 = new URL(listaCompeticiones[0][0]);
        BufferedImage imagenOriginal1 = ImageIO.read(Equipo1);
        BufferedImage bufferedImage1 = Scalr.resize(imagenOriginal1, 55);
        ImageIcon iconoEscalado1 = new ImageIcon(bufferedImage1);
        vc.getImgPrimer().setIcon(iconoEscalado1);

        URL Equipo2 = new URL(listaCompeticiones[1][0]);
        BufferedImage imagenOriginal2 = ImageIO.read(Equipo2);
        BufferedImage bufferedImage2 = Scalr.resize(imagenOriginal2, 55);
        ImageIcon iconoEscalado2 = new ImageIcon(bufferedImage2);
        vc.getImgSegundo().setIcon(iconoEscalado2);

        URL Equipo3 = new URL(listaCompeticiones[2][0]);
        BufferedImage imagenOriginal3 = ImageIO.read(Equipo3);
        BufferedImage bufferedImage3 = Scalr.resize(imagenOriginal3, 55);
        ImageIcon iconoEscalado3 = new ImageIcon(bufferedImage3);
        vc.getImgTercero().setIcon(iconoEscalado3);

        URL Equipo4 = new URL(listaCompeticiones[3][0]);
        BufferedImage imagenOriginal4 = ImageIO.read(Equipo4);
        BufferedImage bufferedImage4 = Scalr.resize(imagenOriginal4, 55);
        ImageIcon iconoEscalado4 = new ImageIcon(bufferedImage4);
        vc.getImgCuarto().setIcon(iconoEscalado4);

        URL Equipo5 = new URL(listaCompeticiones[4][0]);
        BufferedImage imagenOriginal5 = ImageIO.read(Equipo5);
        BufferedImage bufferedImage5 = Scalr.resize(imagenOriginal5, 55);
        ImageIcon iconoEscalado5 = new ImageIcon(bufferedImage5);
        vc.getImgQuinto().setIcon(iconoEscalado5);

        URL Equipo6 = new URL(listaCompeticiones[5][0]);
        BufferedImage imagenOriginal6 = ImageIO.read(Equipo6);
        BufferedImage bufferedImage6 = Scalr.resize(imagenOriginal6, 55);
        ImageIcon iconoEscalado6 = new ImageIcon(bufferedImage6);
        vc.getImgSexto().setIcon(iconoEscalado6);

        URL Equipo7 = new URL(listaCompeticiones[6][0]);
        BufferedImage imagenOriginal7 = ImageIO.read(Equipo7);
        BufferedImage bufferedImage7 = Scalr.resize(imagenOriginal7, 55);
        ImageIcon iconoEscalado7 = new ImageIcon(bufferedImage7);
        vc.getImgSeptimo().setIcon(iconoEscalado7);

        URL Equipo8 = new URL(listaCompeticiones[7][0]);
        BufferedImage imagenOriginal8 = ImageIO.read(Equipo8);
        BufferedImage bufferedImage8 = Scalr.resize(imagenOriginal8, 55);
        ImageIcon iconoEscalado8 = new ImageIcon(bufferedImage8);
        vc.getImgOctavo().setIcon(iconoEscalado8);

        URL Equipo9 = new URL(listaCompeticiones[8][0]);
        BufferedImage imagenOriginal9 = ImageIO.read(Equipo9);
        BufferedImage bufferedImage9 = Scalr.resize(imagenOriginal9, 55);
        ImageIcon iconoEscalado9 = new ImageIcon(bufferedImage9);
        vc.getImgNoveno().setIcon(iconoEscalado9);

        URL Equipo10 = new URL(listaCompeticiones[9][0]);
        BufferedImage imagenOriginal10 = ImageIO.read(Equipo10);
        BufferedImage bufferedImage10 = Scalr.resize(imagenOriginal10, 55);
        ImageIcon iconoEscalado10 = new ImageIcon(bufferedImage10);
        vc.getImgDecimo().setIcon(iconoEscalado10);

    }

    public class CbClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nombreSeleccionado = String.valueOf(vc.getCbClasificacion().getSelectedItem());
                if (nombreSeleccionado != null && !nombreSeleccionado.isEmpty()){
                    rellenarTablaEquiposCompeticion(nombreSeleccionado);
                }
            }
            catch (Exception ex) {
                vc.mostrarMensaje(ex.getMessage());
            }

        }
    }
}