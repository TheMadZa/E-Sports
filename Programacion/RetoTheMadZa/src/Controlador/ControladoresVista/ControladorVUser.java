package Controlador.ControladoresVista;

import Modelo.Competicion;
import Vista.VentanaInicioSesion;
import Vista.VentanaUser;
import org.imgscalr.Scalr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Controlador para la vista de usuario.
 *
 * @author Ibai, Lorena
 */
public class ControladorVUser {

    private VentanaUser vu;
    private final ControladorVista cv;

    /**
     * Constructor de ControladorVUser.
     *
     * @param cv Controlador de la vista principal.
     */
    public ControladorVUser(ControladorVista cv) {
        this.cv = cv;
    }

    /**
     * Crea y muestra la ventana de usuario.
     *
     * @param vis Ventana de inicio de sesión asociada.
     */
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

    /**
     * Acción para mostrar la tienda.
     */
    public class BTiendaAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda(vu);
        }
    }

    /**
     * Acción para mostrar la ventana de inicio de sesión.
     */
    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(vu);
        }
    }

    /**
     * Acción para salir de la aplicación.
     */
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

    /**
     * Acción para mostrar las jornadas.
     */
    public class MJornadasAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarJornadas(vu);
        }
    }

    /**
     * Acción para mostrar la clasificación.
     */
    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(vu);
        }
    }

    /**
     * Acción para mostrar los equipos.
     */
    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(vu);
        }
    }

    /**
     * Acción para manejar la selección en el ComboBox de clasificación.
     */
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
     * Rellena la tabla de equipos según la competición seleccionada.
     *
     * @param nombreSeleccionado Nombre de la competición seleccionada.
     * @throws Exception Si ocurre algún error.
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

        // Poner las imágenes de sus logos.
        setEquipoImagen(vu.getEquipo1(), "Equipo" + listaCompeticiones[0][5]);
        setEquipoImagen(vu.getEquipo2(), "Equipo" + listaCompeticiones[1][5]);
        setEquipoImagen(vu.getEquipo3(), "Equipo" + listaCompeticiones[2][5]);
        setEquipoImagen(vu.getEquipo4(), "Equipo" + listaCompeticiones[3][5]);
        setEquipoImagen(vu.getEquipo5(), "Equipo" + listaCompeticiones[4][5]);

    }

    /**
     * Establece la imagen del equipo en un JLabel.
     *
     * @param label       JLabel donde se establecerá la imagen.
     * @param nombreImagen Nombre de la imagen del equipo.
     */
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

    /**
     * Llena el ComboBox con las competiciones disponibles.
     */
    public void llenarComboBox() {
        try {
            vu.getCbClasificacion().removeAllItems();
            List<Competicion> listaCompeticiones = cv.buscarTodasCompeticiones();

            for (Competicion competicion : listaCompeticiones) {
                vu.getCbClasificacion().addItem(competicion.getNombreCom());
            }

            // Verificar si hay competiciones y poblar la tabla con el primer ítem
            if (!listaCompeticiones.isEmpty()) {
                String nombreCom = listaCompeticiones.get(0).getNombreCom();
                rellenarTablaEquiposCompeticion(nombreCom);
            }

            vu.getCbClasificacion().setSelectedIndex(0); // Seleccionar el primer ítem

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
