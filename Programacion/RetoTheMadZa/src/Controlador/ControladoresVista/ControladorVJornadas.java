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

// TODO : JAVADOC
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
                    rellenarTablaEquiposJornadas(nombreSeleccionado);
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
            }

            // Check if there are competitions and populate table with first item
            if (!listaCompeticiones.isEmpty()) {
                String nombreCom = listaCompeticiones.get(0).getNombreCom();
                rellenarTablaEquiposJornadas(nombreCom);
            }

            vj.getCbCompeticion().setSelectedIndex(0); // Select the first item

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void rellenarTablaEquiposJornadas(String nombreCom) throws Exception {

        // Obtener un array multidimensional con los datos de los equipos de la competición seleccionada.
        String[][] listaJornadas = cv.obtenerResultadosUltimaJornada(nombreCom);

        // Colocar los resultados
        vj.getResultadoEquipo1Partido1().setText(String.valueOf(listaJornadas[0][0]));
        vj.getResultadoEquipo2Partido1().setText(String.valueOf(listaJornadas[0][1]));
        vj.getResultadoEquipo1Partido2().setText(String.valueOf(listaJornadas[1][0]));
        vj.getResultadoEquipo2Partido2().setText(String.valueOf(listaJornadas[1][1]));
        vj.getResultadoEquipo1Partido3().setText(String.valueOf(listaJornadas[2][0]));
        vj.getResultadoEquipo2Partido3().setText(String.valueOf(listaJornadas[2][1]));
        vj.getResultadoEquipo1Partido4().setText(String.valueOf(listaJornadas[3][0]));
        vj.getResultadoEquipo2Partido4().setText(String.valueOf(listaJornadas[3][1]));






        //String Equipo1 = listaCompeticiones[0][0];
        //cargarImagenEstablecerIcono("Equipo1", 55, 55, vi.getEquipo1());

        // Poner las imágenes de sus logos.
        setEquipoImagen(vj.getFtEquipo1Partido1(), "Equipo" + listaJornadas[0][2]);
        setEquipoImagen(vj.getFtEquipo2Partido1(), "Equipo" + listaJornadas[0][3]);
        setEquipoImagen(vj.getFtEquipo1Partido2(), "Equipo" + listaJornadas[1][2]);
        setEquipoImagen(vj.getFtEquipo2Partido2(), "Equipo" + listaJornadas[1][3]);
        setEquipoImagen(vj.getFtEquipo1Partido3(), "Equipo" + listaJornadas[2][2]);
        setEquipoImagen(vj.getFtEquipo2Partido3(), "Equipo" + listaJornadas[2][3]);
        setEquipoImagen(vj.getFtEquipo1Partido4(), "Equipo" + listaJornadas[3][2]);
        setEquipoImagen(vj.getFtEquipo2Partido4(), "Equipo" + listaJornadas[3][3]);

    }

    private void setEquipoImagen(JLabel label, String nombreImagen) {
        BufferedImage imagen = ControladorImagenes.obtenerImagen2(nombreImagen);
        if (imagen != null) {
            BufferedImage imagenEscalada = Scalr.resize(imagen, 150);
            ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
            label.setIcon(iconoEscalado);
        } else {
            System.err.println("Imagen no encontrada: " + nombreImagen);
        }
    }

}
