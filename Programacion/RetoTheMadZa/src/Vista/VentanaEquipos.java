package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.*;

public class VentanaEquipos extends JFrame {
    private JPanel panelUp;
    private JPanel PanelMenu;
    private JMenuBar mPrincipal;
    private JMenu mJornadas;
    private JMenu mClasificacion;
    private JMenu mequipos;
    private JPanel PanelLogo;
    private JLabel ftThemadza;
    private JButton bInicio;
    private JButton bSalir;
    private JButton bTienda;
    private JPanel panelFoot;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JLabel logoBlanco;
    private JScrollPane PanelMedio;
    private JLabel ftEquipo1;
    private JPanel pPrincipal;
    private JPanel PnaelMedio;
    private JButton bDerecha;

    public VentanaEquipos(VentanaInicial vi) {

        // Cargar las imágenes con un tamaño específico.
        cargarImagenEstablecerIcono("TheMadZaLogoSimple", 250, 250, ftThemadza);
        cargarImagenEstablecerIcono("Tienda", bTienda);
        cargarImagenEstablecerIcono("Inicio", bInicio);
        cargarImagenEstablecerIcono("Salir", bSalir);
        cargarImagenEstablecerIcono("Twitter", bTwitter);
        cargarImagenEstablecerIcono("Instagram", bInstagram);
        cargarImagenEstablecerIcono("Facebook", bFacebook);
        cargarImagenEstablecerIcono("LogoBlanco", 100, 100, logoBlanco);
        cargarImagenEstablecerIcono("Equipo1", 400, 400, ftEquipo1);

        cargarImagenEstablecerIcono("FlechaIzq", 400, 400, ftEquipo1);
        cargarImagenEstablecerIcono("flechaDrch", 400, 400, ftEquipo1);



        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Equipos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, bFacebook,
                bTwitter, bInstagram};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        Color backgroundColor = Color.decode("#5B2C78");
        Color foregroundColor = Color.decode("#151135");

        JScrollBar verticalScrollBar = PanelMedio.getVerticalScrollBar();
        verticalScrollBar.setBackground(backgroundColor);
        verticalScrollBar.setForeground(foregroundColor);
        PanelMedio.getViewport().setBackground(backgroundColor);
        PanelMedio.setBackground(backgroundColor);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaEquipos ventana = new VentanaEquipos(null);
        });
    }

    // Funciones
    private void cargarImagenEstablecerIcono(String nombreImagen, int ancho, int alto, JLabel label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }
    private void cargarImagenEstablecerIcono(String nombreImagen, JButton button) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, 40, 40);
        if (icono != null) {
            button.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }
}