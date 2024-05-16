package Controlador.ControladoresVista;

import Modelo.*;
import Vista.VentanaInicial;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ControladorVI {

    private VentanaInicial vi;
    private final ControladorVista cv;

    public ControladorVI(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        vi = new VentanaInicial();

        //llenarComboBox();

        // Action Listeners de los botones y demás.
        vi.addBTiendaAL(new BTiendaAL());
        vi.addBInicioAL(new BInicioAL());
        vi.addBSalirAL(new BSalirAL());
        vi.addBFacebookAL(new BFacebookAL());
        vi.addBInstagramAL(new BInstagramAL());
        vi.addBTwitterAL(new BTwitterAL());
        vi.addMJornadasAL(new MJornadasAL());
        vi.addMClasificacionAL(new MClasificacionAL());
        vi.addMEquiposAL(new MEquiposAL());
        //vi.addCbClasificacionAL(new CbClasificacionAL());
    }

    public class BTiendaAL implements ActionListener{
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

    /*public class CbClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nombreSeleccionado = vi.getCbClasificacion().getSelectedItem().toString();
                if (nombreSeleccionado != null && !nombreSeleccionado.isEmpty()){
                    validarBuscarCompeticionNombre(nombreSeleccionado); // TODO
                }
            }
            catch (Exception ex)
            {
                //vi.mostrarMensaje(ex.getMessage());
            }

        }
    }

    public void validarBuscarCompeticionNombre(String nombreSeleccionado) throws Exception {
        List<EquipoCompeticion> equipoCompeticiones = new ArrayList<>();

        equipoCompeticiones.clear();

        //Llenamos una lista con todos los equipos y sus competiciones
        equipoCompeticiones = cv.buscarTodosEquiposCompeticiones();

        //Buscamos el objeto competicion para conseguir el id
        Competicion c = cv.buscarCompeticionNombre(nombreSeleccionado);

        //Borramos de la lista los equipos que no tienen el id que queremos
        for (EquipoCompeticion equipoCompeticion : equipoCompeticiones){
            if (equipoCompeticion.getCompeticionByIdCompeticion() != c){
                equipoCompeticiones.remove(equipoCompeticion);
            }
        }

        //De los 5 mejores conseguir el logo, victorias y puntos
        List<EquipoCompeticion> primerosCinco = equipoCompeticiones.subList(0,5);

        vi.getvEquipo1().setText(String.valueOf(primerosCinco.get(0).getVictorias()));
        vi.getpEquipo1().setText(String.valueOf(primerosCinco.get(0).getPuntos()));
        vi.getvEquipo2().setText(String.valueOf(primerosCinco.get(1).getVictorias()));
        vi.getpEquipo2().setText(String.valueOf(primerosCinco.get(1).getPuntos()));
        vi.getvEquipo3().setText(String.valueOf(primerosCinco.get(2).getVictorias()));
        vi.getpEquipo3().setText(String.valueOf(primerosCinco.get(2).getPuntos()));
        vi.getvEquipo4().setText(String.valueOf(primerosCinco.get(3).getVictorias()));
        vi.getpEquipo4().setText(String.valueOf(primerosCinco.get(3).getPuntos()));
        vi.getvEquipo5().setText(String.valueOf(primerosCinco.get(4).getVictorias()));
        vi.getpEquipo5().setText(String.valueOf(primerosCinco.get(4).getPuntos()));

        vi.getEquipo1().setText(primerosCinco.get(0).getEquipoByIdEquipo().getLogo());
        vi.getEquipo2().setText(primerosCinco.get(1).getEquipoByIdEquipo().getLogo());
        vi.getEquipo3().setText(primerosCinco.get(2).getEquipoByIdEquipo().getLogo());
        vi.getEquipo4().setText(primerosCinco.get(3).getEquipoByIdEquipo().getLogo());
        vi.getEquipo5().setText(primerosCinco.get(4).getEquipoByIdEquipo().getLogo());

        URL Equipo1 = new URL(primerosCinco.get(0).getEquipoByIdEquipo().getLogo());
        BufferedImage imagenOriginal1 = ImageIO.read(Equipo1);
        BufferedImage bufferedImage1 = Scalr.resize(imagenOriginal1, 55);
        ImageIcon iconoEscalado1 = new ImageIcon(bufferedImage1);
        vi.getEquipo1().setIcon(iconoEscalado1);

        URL Equipo2 = new URL(primerosCinco.get(1).getEquipoByIdEquipo().getLogo());
        BufferedImage imagenOriginal2 = ImageIO.read(Equipo2);
        BufferedImage bufferedImage2 = Scalr.resize(imagenOriginal2, 55);
        ImageIcon iconoEscalado2 = new ImageIcon(bufferedImage2);
        vi.getEquipo2().setIcon(iconoEscalado2);

        URL Equipo3 = new URL(primerosCinco.get(2).getEquipoByIdEquipo().getLogo());
        BufferedImage imagenOriginal3 = ImageIO.read(Equipo3);
        BufferedImage bufferedImage3 = Scalr.resize(imagenOriginal3, 55);
        ImageIcon iconoEscalado3 = new ImageIcon(bufferedImage3);
        vi.getEquipo3().setIcon(iconoEscalado3);

        URL Equipo4 = new URL(primerosCinco.get(3).getEquipoByIdEquipo().getLogo());
        BufferedImage imagenOriginal4 = ImageIO.read(Equipo4);
        BufferedImage bufferedImage4 = Scalr.resize(imagenOriginal4, 55);
        ImageIcon iconoEscalado4 = new ImageIcon(bufferedImage4);
        vi.getEquipo4().setIcon(iconoEscalado4);

        URL Equipo5 = new URL(primerosCinco.get(4).getEquipoByIdEquipo().getLogo());
        BufferedImage imagenOriginal5 = ImageIO.read(Equipo5);
        BufferedImage bufferedImage5 = Scalr.resize(imagenOriginal5, 55);
        ImageIcon iconoEscalado5 = new ImageIcon(bufferedImage5);
        vi.getEquipo5().setIcon(iconoEscalado5);

    }

    public void llenarComboBox(){
        try {
            System.out.println("bien la funcion 1");
            vi.getCbClasificacion().removeAllItems();
            System.out.println("bien la funcion 2");
            List<Competicion> competiciones = cv.buscarTodasCompeticiones();

            System.out.println("bien la funcion 3");

            for (Competicion competicion : competiciones){
                vi.getCbClasificacion().addItem(competicion.getNombreCom());
            }
            System.out.println("bien la funcion 4");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }*/

}