package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
    private JPanel PanelMedio;
    private JLabel ftEquipo1;
    private JPanel pPrincipal;
    private JButton bDerecha;
    private JLabel lImagen;
    private JButton bIzquierda;
    private JLabel lEquipo;

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
        cargarImagenEstablecerIcono("Equipo1", 400, 400, lImagen);

        cargarImagenEstablecerIcono("FlechaIzq", bIzquierda);
        cargarImagenEstablecerIcono("flechaDrch", bDerecha);



        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Equipos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);
        bIzquierda.setBorder(BorderFactory.createEmptyBorder());
        bDerecha.setBorder(BorderFactory.createEmptyBorder());

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, bFacebook,
                bTwitter, bInstagram};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        Color backgroundColor = Color.decode("#5B2C78");
        Color foregroundColor = Color.decode("#151135");

        /*
        JScrollBar verticalScrollBar = PanelMedio.getVerticalScrollBar();
        verticalScrollBar.setBackground(backgroundColor);
        verticalScrollBar.setForeground(foregroundColor);
        PanelMedio.getViewport().setBackground(backgroundColor);
        PanelMedio.setBackground(backgroundColor);
         */

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaEquipos ventana = new VentanaEquipos(null);
        });
    }

    // Funciones
    public void cargarImagenEstablecerIcono(String nombreImagen, int ancho, int alto, JLabel label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }
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

    public void setlImagen(JLabel lImagen) {
        this.lImagen = lImagen;
    }

    public JLabel getlEquipo() {
        return lEquipo;
    }

    public void setlEquipo(JLabel lEquipo) {
        this.lEquipo = lEquipo;
    }

    //ActionListeners
    public void addBFlechaDrchAL(ActionListener al){
        bDerecha.addActionListener(al);
    }
    public void addBFlechaIzquAL(ActionListener al){
        bIzquierda.addActionListener(al);
    }
}