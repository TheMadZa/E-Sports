package Controlador.ControladoresVista;

import Modelo.*;
import Vista.VentanaInicial;
import org.imgscalr.Scalr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Clase ControladorVI que gestiona la primera ventana en aparecer.
 *
 * @author Julen, Ibai, Lorena, Zahir
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
            cv.mostrarInicioSesion(vi);
        }
    }

    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(vi);
        }
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

    /**
     * ActionListener para el botón de Facebook.
     */
    public static class BFacebookAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            abrirEnlace("https://www.facebook.com/?locale=es_ES");
        }
    }
    /**
     * ActionListener para el botón de Instagram.
     */
    public static class BInstagramAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            abrirEnlace("https://www.instagram.com");
        }
    }
    /**
     * ActionListener para el botón de Twitter.
     */
    public static class BTwitterAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            abrirEnlace("https://twitter.com/?logout=1715768138184");
        }
    }
    /**
     * Abre un enlace externo en el navegador predeterminado.
     * @param enlace Enlace a abrir.
     */
    private static void abrirEnlace(String enlace) {
        try {
            Desktop.getDesktop().browse(java.net.URI.create(enlace));
        } catch (java.io.IOException ex) {
            System.out.println("Error al abrir el enlace: " + ex.getMessage());
        }
    }

    public class MJornadasAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(vi);
        }
    }

    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(vi);
        }
    }

    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(vi);
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
     * @param nombreSeleccionado Es el nombre de la competición seleccionada en el JComboBox.
     * @throws Exception Si ocurre algún error inesperado.
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

        setEquipoImagen(vi.getEquipo1(), "Equipo" + listaCompeticiones[0][5]);
        setEquipoImagen(vi.getEquipo2(), "Equipo" + listaCompeticiones[1][5]);
        setEquipoImagen(vi.getEquipo3(), "Equipo" + listaCompeticiones[2][5]);
        setEquipoImagen(vi.getEquipo4(), "Equipo" + listaCompeticiones[3][5]);
        setEquipoImagen(vi.getEquipo5(), "Equipo" + listaCompeticiones[4][5]);

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

    public void llenarComboBox(){
        try {
            vi.getCbClasificacion().removeAllItems();
            List<Competicion> listaCompeticiones = cv.buscarTodasCompeticiones();

            for (Competicion competicion : listaCompeticiones){
                vi.getCbClasificacion().addItem(competicion.getNombreCom());
            }

            // Check if there are competitions and populate table with first item
            if (!listaCompeticiones.isEmpty()) {
                String nombreCom = listaCompeticiones.get(0).getNombreCom();
                rellenarTablaEquiposCompeticion(nombreCom);
            }

            vi.getCbClasificacion().setSelectedIndex(0); // Select the first item

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }


}