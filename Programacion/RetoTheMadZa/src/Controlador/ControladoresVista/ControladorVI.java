package Controlador.ControladoresVista;

import Modelo.*;
import Vista.VentanaInicial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clase ControladorVI que gestiona la primera ventana en aparecer.
 *
 * @author Julen
 */
public class ControladorVI {
    private VentanaInicial vi;
    private final ControladorVista cv;

    public ControladorVI(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        vi = new VentanaInicial();

        llenarComboBox();

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
        vi.addCbClasificacionAL(new CbClasificacionAL());
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

    public class CbClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nombreSeleccionado = String.valueOf(vi.getCbClasificacion().getSelectedItem());
                if (nombreSeleccionado != null && !nombreSeleccionado.isEmpty()){
                    rellenarTablaEquiposCompeticion(nombreSeleccionado);
                }
            }
            catch (Exception ex) {
                vi.mostrarMensaje(ex.getMessage());
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
        vi.getvEquipo1().setText(String.valueOf(listaCompeticiones[0][1]));
        vi.getpEquipo1().setText(String.valueOf(listaCompeticiones[0][2]));
        vi.getvEquipo2().setText(String.valueOf(listaCompeticiones[1][1]));
        vi.getpEquipo2().setText(String.valueOf(listaCompeticiones[1][2]));
        vi.getvEquipo3().setText(String.valueOf(listaCompeticiones[2][1]));
        vi.getpEquipo3().setText(String.valueOf(listaCompeticiones[2][2]));
        vi.getvEquipo4().setText(String.valueOf(listaCompeticiones[3][1]));
        vi.getpEquipo4().setText(String.valueOf(listaCompeticiones[3][2]));
        vi.getvEquipo5().setText(String.valueOf(listaCompeticiones[4][1]));
        vi.getpEquipo5().setText(String.valueOf(listaCompeticiones[4][2]));

        // TODO : PONER LAS IMÁGENES

        /*
        //Borramos de la lista los equipos que no tienen el id que queremos

        for (EquipoCompeticion equipoCompeticion : equipoCompeticiones){
            if (!equipoCompeticion.getCompeticion().equals(c)){
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

        vi.getEquipo1().setText(primerosCinco.get(0).getEquipo().getLogo());
        vi.getEquipo2().setText(primerosCinco.get(1).getEquipo().getLogo());
        vi.getEquipo3().setText(primerosCinco.get(2).getEquipo().getLogo());
        vi.getEquipo4().setText(primerosCinco.get(3).getEquipo().getLogo());
        vi.getEquipo5().setText(primerosCinco.get(4).getEquipo().getLogo());

        URL Equipo1 = new URL(primerosCinco.get(0).getEquipo().getLogo());
        BufferedImage imagenOriginal1 = ImageIO.read(Equipo1);
        BufferedImage bufferedImage1 = Scalr.resize(imagenOriginal1, 55);
        ImageIcon iconoEscalado1 = new ImageIcon(bufferedImage1);
        vi.getEquipo1().setIcon(iconoEscalado1);

        URL Equipo2 = new URL(primerosCinco.get(1).getEquipo().getLogo());
        BufferedImage imagenOriginal2 = ImageIO.read(Equipo2);
        BufferedImage bufferedImage2 = Scalr.resize(imagenOriginal2, 55);
        ImageIcon iconoEscalado2 = new ImageIcon(bufferedImage2);
        vi.getEquipo2().setIcon(iconoEscalado2);

        URL Equipo3 = new URL(primerosCinco.get(2).getEquipo().getLogo());
        BufferedImage imagenOriginal3 = ImageIO.read(Equipo3);
        BufferedImage bufferedImage3 = Scalr.resize(imagenOriginal3, 55);
        ImageIcon iconoEscalado3 = new ImageIcon(bufferedImage3);
        vi.getEquipo3().setIcon(iconoEscalado3);

        URL Equipo4 = new URL(primerosCinco.get(3).getEquipo().getLogo());
        BufferedImage imagenOriginal4 = ImageIO.read(Equipo4);
        BufferedImage bufferedImage4 = Scalr.resize(imagenOriginal4, 55);
        ImageIcon iconoEscalado4 = new ImageIcon(bufferedImage4);
        vi.getEquipo4().setIcon(iconoEscalado4);

        URL Equipo5 = new URL(primerosCinco.get(4).getEquipo().getLogo());
        BufferedImage imagenOriginal5 = ImageIO.read(Equipo5);
        BufferedImage bufferedImage5 = Scalr.resize(imagenOriginal5, 55);
        ImageIcon iconoEscalado5 = new ImageIcon(bufferedImage5);
        vi.getEquipo5().setIcon(iconoEscalado5);
        */

    }

    public void llenarComboBox(){
        try {
            vi.getCbClasificacion().removeAllItems();
            List<Competicion> listaCompeticiones = cv.buscarTodasCompeticiones();

            for (Competicion competicion : listaCompeticiones){
                vi.getCbClasificacion().addItem(competicion.getNombreCom());
            }

            vi.getCbClasificacion().setSelectedIndex(-1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

}