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

/**
 * Controlador para la vista de las jornadas.
 */
public class ControladorVJornadas {

    private VentanaJornadas vj;
    private ControladorVista cv;

    /**
     * Constructor de ControladorVJornadas.
     *
     * @param cv Controlador de la vista principal.
     */
    public ControladorVJornadas(ControladorVista cv) {
        this.cv = cv;
    }

    /**
     * Crea y muestra la ventana de las jornadas.
     *
     * @param ventanaEliminar Ventana que se va a eliminar.
     */
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

    /**
     * Acción para mostrar la tienda.
     */
    public class BTiendaAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda(vj);
        }
    }

    /**
     * Acción para mostrar la ventana de inicio de sesión.
     */
    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion(vj);
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
     * Acción para abrir Facebook en el navegador.
     */
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

    /**
     * Acción para abrir Instagram en el navegador.
     */
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

    /**
     * Acción para abrir Twitter en el navegador.
     */
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

    /**
     * Acción para mostrar las jornadas.
     */
    public class MJornadasAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarJornadas(vj);
        }
    }

    /**
     * Acción para mostrar la clasificación.
     */
    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(vj);
        }
    }

    /**
     * Acción para mostrar los equipos.
     */
    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(vj);
        }
    }

    /**
     * Acción para manejar la selección en el ComboBox de clasificación.
     */
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

    /**
     * Llena el ComboBox con las competiciones disponibles.
     */
    public void llenarComboBox(){
        try {
            vj.getCbCompeticion().removeAllItems();
            List<Competicion> listaCompeticiones = cv.buscarTodasCompeticiones();

            for (Competicion competicion : listaCompeticiones){
                vj.getCbCompeticion().addItem(competicion.getNombreCom());
            }

            // Verificar si hay competiciones y poblar la tabla con el primer ítem
            if (!listaCompeticiones.isEmpty()) {
                String nombreCom = listaCompeticiones.get(0).getNombreCom();
                rellenarTablaEquiposJornadas(nombreCom);
            }

            vj.getCbCompeticion().setSelectedIndex(0); // Seleccionar el primer ítem

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    /**
     * Rellena la tabla de equipos según la competición seleccionada.
     *
     * @param nombreCom Nombre de la competición seleccionada.
     * @throws Exception Si ocurre algún error.
     */
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

        // Poner las imágenes de los equipos
        setEquipoImagen(vj.getFtEquipo1Partido1(), "Equipo" + listaJornadas[0][2]);
        setEquipoImagen(vj.getFtEquipo2Partido1(), "Equipo" + listaJornadas[0][3]);
        setEquipoImagen(vj.getFtEquipo1Partido2(), "Equipo" + listaJornadas[1][2]);
        setEquipoImagen(vj.getFtEquipo2Partido2(), "Equipo" + listaJornadas[1][3]);
        setEquipoImagen(vj.getFtEquipo1Partido3(), "Equipo" + listaJornadas[2][2]);
        setEquipoImagen(vj.getFtEquipo2Partido3(), "Equipo" + listaJornadas[2][3]);
        setEquipoImagen(vj.getFtEquipo1Partido4(), "Equipo" + listaJornadas[3][2]);
        setEquipoImagen(vj.getFtEquipo2Partido4(), "Equipo" + listaJornadas[3][3]);

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
            BufferedImage imagenEscalada = Scalr.resize(imagen, 150);
            ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
            label.setIcon(iconoEscalado);
        } else {
            System.err.println("Imagen no encontrada: " + nombreImagen);
        }
    }

}
