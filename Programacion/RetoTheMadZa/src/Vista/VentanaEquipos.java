package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Ventana de Equipos donde se muestran todos los equipos.
 * Esta clase representa la ventana de equipos en la que se muestran todos los equipos disponibles.
 * Contiene elementos como botones, etiquetas y menús para interactuar con la ventana.
 * También maneja la carga de imágenes y la configuración de íconos para los componentes visuales.
 *
 * @author Ibai, Julen
 * @version 1.0
 */
public class VentanaEquipos extends JFrame {
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
    private JPanel panelFoot;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JLabel logoBlanco;
    private JPanel PanelMedio;
    private JLabel ftEquipo1;
    private JPanel pPrincipal;
    private JButton bDerecha;
    private JLabel lImagen;
    private JButton bIzquierda;
    private JLabel lEquipo;
    private JMenuItem mEquipos;
    private JLabel nombreEquipo;

    /**
     * Constructor de la clase VentanaEquipos.
     * Crea una nueva instancia de la ventana de equipos y configura sus propiedades básicas.
     * También carga las imágenes y establece los iconos para los botones y etiquetas.
     * @param ventanaEliminar La ventana anterior que se debe eliminar al abrir esta ventana.
     */
    public VentanaEquipos(JFrame ventanaEliminar) {

        // Cargar las imágenes con un tamaño específico.
        cargarImagenEstablecerIconoBoton("TheMadZaLogoSimple", 250, 250, ftThemadza);
        cargarImagenEstablecerIcono("Tienda", bTienda);
        cargarImagenEstablecerIcono("Inicio", bInicio);
        cargarImagenEstablecerIcono("Salir", bSalir);
        cargarImagenEstablecerIcono("Twitter", bTwitter);
        cargarImagenEstablecerIcono("Instagram", bInstagram);
        cargarImagenEstablecerIcono("Facebook", bFacebook);
        cargarImagenEstablecerIcono("LogoBlanco", 100, 100, logoBlanco);
        cargarImagenEstablecerIcono("Equipo1", 400, 400, lImagen);

        cargarImagenEstablecerIconoBoton("FlechaIzq", 100,100, bIzquierda);
        cargarImagenEstablecerIconoBoton("flechaDrch",100,100, bDerecha);

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Equipos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, bFacebook,
                bTwitter, bInstagram, bIzquierda, bDerecha, ftThemadza};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        setVisible(true);

        // Ocultar la ventana anterior.
        ventanaEliminar.setVisible(false);
    }

    /**
     * Método principal para ejecutar la ventana de equipos.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaEquipos ventana = new VentanaEquipos(null);
        });
    }

    // Funciones

    /**
     * Carga una imagen y establece un ícono para un JLabel.
     * @param nombreImagen El nombre de la imagen a cargar.
     * @param ancho El ancho del ícono.
     * @param alto El alto del ícono.
     * @param label El JLabel al que se le establecerá el ícono.
     */
    public void cargarImagenEstablecerIcono(String nombreImagen, int ancho, int alto, JLabel label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

    /**
     * Carga una imagen y establece un ícono para un JButton.
     * @param nombreImagen El nombre de la imagen a cargar.
     * @param button El JButton al que se le establecerá el ícono.
     */
    public void cargarImagenEstablecerIcono(String nombreImagen, JButton button) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, 40, 40);
        if (icono != null) {
            button.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

    //Getters y setters

    public JLabel getlImagen() {
        return lImagen;
    }

    public JButton getbDerecha() {
        return bDerecha;
    }

    public JButton getbIzquierda() {
        return bIzquierda;
    }

    public void setNombreEquipo(String nombre) {
        this.nombreEquipo.setText(nombre);
    }

    //Listeners

    public void addBFlechaDrchAL(ActionListener al){
        bDerecha.addActionListener(al);
    }
    public void addBFlechaIzquAL(ActionListener al){
        bIzquierda.addActionListener(al);
    }
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
    public void addBThemadzaAL(ActionListener al) {
        ftThemadza.addActionListener(al);
    }

    /**
     * Carga una imagen y establece un ícono para un JButton.
     * @param nombreImagen El nombre de la imagen a cargar.
     * @param ancho El ancho del ícono.
     * @param alto El alto del ícono.
     * @param label El JButton al que se le establecerá el ícono.
     */
    private void cargarImagenEstablecerIconoBoton(String nombreImagen, int ancho, int alto, JButton label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

}