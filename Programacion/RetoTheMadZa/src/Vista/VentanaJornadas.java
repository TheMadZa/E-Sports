package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Esta clase representa la ventana de Jornadas.
 *
 * @author Ibai
 * @version 1.0
 */
public class VentanaJornadas extends JFrame{
    private JPanel panelUp;
    private JPanel PanelMenu;
    private JMenuBar mPrincipal;
    private JMenuItem mJornadas;
    private JMenuItem mClasificacion;
    private JPanel PanelLogo;
    private JButton ftThemadza;
    private JButton bInicio;
    private JButton bSalir;
    private JButton bTienda;
    private JPanel PanelMedio;
    private JPanel panelFoot;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JLabel logoBlanco;
    private JPanel pPrincipal;
    private JPanel panelJornadas;
    private JPanel panelEnfrentamiento1;
    private JLabel ftEquipo1Partido1;
    private JLabel ftEquipo2Partido1;
    private JLabel ftEquipo2Partido2;
    private JLabel ftEquipo2Partido3;
    private JLabel ftEquipo2Partido4;
    private JLabel ftEquipo1Partido2;
    private JLabel ftEquipo1Partido3;
    private JLabel ftEquipo1Partido4;
    private JLabel resultadoEquipo1Partido1;
    private JLabel resultadoEquipo2Partido1;
    private JLabel resultadoEquipo1Partido2;
    private JLabel resultadoEquipo2Partido2;
    private JLabel resultadoEquipo1Partido3;
    private JLabel resultadoEquipo2Partido3;
    private JLabel resultadoEquipo1Partido4;
    private JLabel resultadoEquipo2Partido4;
    private JComboBox<String> cbCompeticion;
    private JMenuItem mEquipos;
    private String Equipo1Partido1;
    private String Equipo2Partido1;
    private String Equipo1Partido2;
    private String Equipo2Partido2;
    private String Equipo1Partido3;
    private String Equipo2Partido3;
    private String Equipo1Partido4;
    private String Equipo2Partido4;

    /**
     * Constructor de la clase VentanaJornadas.
     *
     * @param ventanaEliminar La ventana que se eliminará cuando se abra esta ventana.
     */
    public VentanaJornadas(JFrame ventanaEliminar) {

        cargarImagenEstablecerIconoBoton(ftThemadza);
        cargarImagenEstablecerIcono("Tienda", bTienda);
        cargarImagenEstablecerIcono("Inicio", bInicio);
        cargarImagenEstablecerIcono("Salir", bSalir);
        cargarImagenEstablecerIcono("Twitter", bTwitter);
        cargarImagenEstablecerIcono("Instagram", bInstagram);
        cargarImagenEstablecerIcono("Facebook", bFacebook);
        cargarImagenEstablecerIcono("LogoBlanco", 100, 100, logoBlanco);

        cargarImagenEstablecerIcono("Equipo1", 75, 75, ftEquipo1Partido1);
        cargarImagenEstablecerIcono("Equipo1", 75, 75, ftEquipo2Partido1);
        cargarImagenEstablecerIcono("Equipo1", 75, 75, ftEquipo1Partido2);
        cargarImagenEstablecerIcono("Equipo1", 75, 75, ftEquipo2Partido2);
        cargarImagenEstablecerIcono("Equipo1", 75, 75, ftEquipo1Partido3);
        cargarImagenEstablecerIcono("Equipo1", 75, 75, ftEquipo2Partido3);
        cargarImagenEstablecerIcono("Equipo1", 75, 75, ftEquipo1Partido4);
        cargarImagenEstablecerIcono("Equipo1", 75, 75, ftEquipo2Partido4);

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Jornadas");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, bFacebook, bTwitter, bInstagram,
                ftThemadza};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        setVisible(true);

        // Ocultar la ventana anterior.
        ventanaEliminar.setVisible(false);
    }

    /**
     * Método principal para ejecutar la ventana de Jornadas.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaJornadas ventana = new VentanaJornadas(null);
        });
    }

    // Listeners
    public void addMJornadasAL(ActionListener al) {
        mJornadas.addActionListener(al);
    }
    public void addMClasificacionAL(ActionListener al) {
        mClasificacion.addActionListener(al);
    }
    public void addMEquiposAL(ActionListener al) {
        mEquipos.addActionListener(al);
    }
    public void addBTiendaAL(ActionListener al) {
        bTienda.addActionListener(al);
    }
    public void addBInicioAL(ActionListener al) {
        bInicio.addActionListener(al);
    }
    public void addBSalirAL(ActionListener al) {
        bSalir.addActionListener(al);
    }
    public void addBFacebookAL(ActionListener al) {
        bFacebook.addActionListener(al);
    }
    public void addBInstagramAL(ActionListener al) {
        bInstagram.addActionListener(al);
    }
    public void addBTwitterAL(ActionListener al) {
        bTwitter.addActionListener(al);
    }
    public void addCbCompeticionAL(ActionListener al) {
        cbCompeticion.addActionListener(al);
    }
    public JComboBox<String> getCbCompeticion() {
        return cbCompeticion;
    }
    public void addBThemadzaAL(ActionListener al) {
        ftThemadza.addActionListener(al);
    }

    /**
     * Muestra un mensaje en una ventana emergente.
     *
     * @param mensaje El mensaje que se mostrará.
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    /**
     * Carga una imagen desde un archivo y establece esa imagen como icono en un JLabel,
     * dimensionándola al ancho y alto proporcionados.
     * @param nombreImagen El nombre del archivo de la imagen.
     * @param ancho El ancho deseado para la imagen.
     * @param alto El alto deseado para la imagen.
     * @param label El JLabel en el que se establecerá la imagen.
     */
    private void cargarImagenEstablecerIcono(String nombreImagen, int ancho, int alto, JLabel label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

    /**
     * Carga una imagen desde un archivo y establece esa imagen como icono en un JButton,
     * dimensionándola a 40x40 píxeles.
     * @param nombreImagen El nombre del archivo de la imagen.
     * @param button El JButton en el que se establecerá la imagen.
     */
    private void cargarImagenEstablecerIcono(String nombreImagen, JButton button) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, 40, 40);
        if (icono != null) {
            button.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

    /**
     * Carga una imagen desde un archivo y establece esa imagen como icono en un JButton,
     * dimensionándola al ancho y alto proporcionados.
     *
     * @param label El JButton en el que se establecerá la imagen.
     */
    private void cargarImagenEstablecerIconoBoton(JButton label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen("TheMadZaLogoSimple", 250, 250);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + "TheMadZaLogoSimple" + " no se encontró.");
        }
    }

    //getters

    public JPanel getPanelUp() {
        return panelUp;
    }

    public void setPanelUp(JPanel panelUp) {
        this.panelUp = panelUp;
    }

    public JLabel getFtEquipo1Partido1() {
        return ftEquipo1Partido1;
    }

    public JLabel getFtEquipo2Partido1() {
        return ftEquipo2Partido1;
    }

    public JLabel getFtEquipo2Partido2() {
        return ftEquipo2Partido2;
    }

    public JLabel getFtEquipo2Partido3() {
        return ftEquipo2Partido3;
    }

    public JLabel getFtEquipo2Partido4() {
        return ftEquipo2Partido4;
    }

    public JLabel getFtEquipo1Partido2() {
        return ftEquipo1Partido2;
    }

    public JLabel getFtEquipo1Partido3() {
        return ftEquipo1Partido3;
    }

    public JLabel getFtEquipo1Partido4() {
        return ftEquipo1Partido4;
    }

    public JLabel getResultadoEquipo1Partido1() {
        return resultadoEquipo1Partido1;
    }

    public JLabel getResultadoEquipo2Partido1() {
        return resultadoEquipo2Partido1;
    }

    public JLabel getResultadoEquipo1Partido2() {
        return resultadoEquipo1Partido2;
    }

    public JLabel getResultadoEquipo2Partido2() {
        return resultadoEquipo2Partido2;
    }

    public JLabel getResultadoEquipo1Partido3() {
        return resultadoEquipo1Partido3;
    }

    public JLabel getResultadoEquipo2Partido3() {
        return resultadoEquipo2Partido3;
    }

    public JLabel getResultadoEquipo1Partido4() {
        return resultadoEquipo1Partido4;
    }

    public JLabel getResultadoEquipo2Partido4() {
        return resultadoEquipo2Partido4;
    }
}
