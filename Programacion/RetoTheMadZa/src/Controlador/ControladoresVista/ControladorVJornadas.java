package Controlador.ControladoresVista;

import Modelo.Competicion;
import Vista.VentanaJornadas;
import org.imgscalr.Scalr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;

public class ControladorVJornadas {

    private VentanaJornadas vj;
    private ControladorVista cv;

    public ControladorVJornadas(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(JFrame ventanaEliminar) {

        vj = new VentanaJornadas(ventanaEliminar);

        llenarComboBox();


        vj.addBTiendaAL(new BTiendaAL());
        vj.addBInicioAL(new BInicioAL());
        vj.addBSalirAL(new BSalirAL());
        vj.addBFacebookAL(new BFacebookAL());
        vj.addBInstagramAL(new BInstagramAL());
        vj.addBTwitterAL(new BTwitterAL());
        vj.addMJornadasAL(new MJornadasAL());
        vj.addMClasificacionAL(new MClasificacionAL());
        vj.addMEquiposAL(new MEquiposAL());
        vj.addCbCompeticionAL(new CbClasificacionAL());

    }

    public class BTiendaAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda(vj);
        }
    }

    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO : cerrar sesión y volver a v inicio sesion
            cv.mostrarInicioSesion(vj);
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
            cv.mostrarJornadas(vj);
        }
    }

    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(vj);
        }
    }

    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(vj);
        }
    }

    public class CbClasificacionAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nombreSeleccionado = String.valueOf(vj.getCbCompeticion().getSelectedItem());
                if (nombreSeleccionado != null && !nombreSeleccionado.isEmpty()){
                    //rellenarTablaEquiposCompeticion(nombreSeleccionado);
                }
            }
            catch (Exception ex) {
                vj.mostrarMensaje(ex.getMessage());
            }

        }
    }

    public void llenarComboBox(){
        try {
            vj.getCbCompeticion().removeAllItems();
            List<Competicion> listaCompeticiones = cv.buscarTodasCompeticiones();

            for (Competicion competicion : listaCompeticiones){
                vj.getCbCompeticion().addItem(competicion.getNombreCom());
                rellenarTablaEquiposJornadas(competicion.getNombreCom());
            }

            vj.getCbCompeticion().setSelectedIndex(-1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void rellenarTablaEquiposJornadas(String nombreCom) throws Exception {

        // Obtener un array multidimensional (5F·3C) con los datos de los equipos de la competición seleccionada.
        String[][] listaJornadas = cv.obtenerResultadosUltimaJornada(nombreCom);

        // Aparecerán los 10 equipos con más victorias en orden "victoria - puntos"
        vj.getResultadoEquipo1Partido1().setText(String.valueOf(listaJornadas[0][1]));






        //String Equipo1 = listaCompeticiones[0][0];
        //cargarImagenEstablecerIcono("Equipo1", 55, 55, vi.getEquipo1());

        // Poner las imágenes de sus logos.
        /*setEquipoImagen(vc.getImgPrimer(), "Equipo" + listaCompeticiones[0][5]);
        setEquipoImagen(vc.getImgSegundo(), "Equipo" + listaCompeticiones[1][5]);
        setEquipoImagen(vc.getImgTercero(), "Equipo" + listaCompeticiones[2][5]);
        setEquipoImagen(vc.getImgCuarto(), "Equipo" + listaCompeticiones[3][5]);
        setEquipoImagen(vc.getImgQuinto(), "Equipo" + listaCompeticiones[4][5]);
        setEquipoImagen(vc.getImgSexto(), "Equipo" + listaCompeticiones[5][5]);
        setEquipoImagen(vc.getImgSeptimo(), "Equipo" + listaCompeticiones[6][5]);
        setEquipoImagen(vc.getImgOctavo(), "Equipo" + listaCompeticiones[7][5]);
        setEquipoImagen(vc.getImgNoveno(), "Equipo" + listaCompeticiones[8][5]);
        setEquipoImagen(vc.getImgDecimo(), "Equipo" + listaCompeticiones[9][5]);*/
    }

    private void setEquipoImagen(JLabel label, String nombreImagen) {
        BufferedImage imagen = ControladorImagenes.obtenerImagen2(nombreImagen);
        if (imagen != null) {
            BufferedImage imagenEscalada = Scalr.resize(imagen, 55);
            ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
            label.setIcon(iconoEscalado);
        } else {
            System.err.println("Imagen no encontrada: " + nombreImagen);
        }
    }

}
