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
    private JLabel ftEquipo5;
    private JLabel ftEquipo6;
    private JLabel ftEquipo11;
    private JLabel ftEquipo16;
    private JLabel ftEquipo9;
    private JLabel ftEquipo14;
    private JLabel ftEquipo19;
    private JLabel ftEquipo10;
    private JLabel ftEquipo15;
    private JPanel tien;
    private JLabel ftEquipo20;
    private JLabel separador1;
    private JLabel ftEquipo4;
    private JPanel panelTienda1;
    private JLabel ftEquipo1;
    private JPanel pPrincipal;
    private JLabel Equipo1;
    private JLabel Equipo2;
    private JLabel Equipo3;
    private JLabel Equipo4;
    private JLabel Equipo5;
    private JLabel Equipo6;
    private JLabel Equipo8;
    private JLabel Equipo7;
    private JLabel Equipo9;
    private JLabel Equipo11;
    private JLabel Equipo12;
    private JLabel Equipo13;
    private JLabel Equipo14;
    private JLabel Equipo15;
    private JLabel Equipo16;
    private JLabel Equipo17;
    private JLabel Equipo18;
    private JLabel Equipo19;
    private JLabel Equipo20;
    private JLabel Equipo21;
    private JLabel Equipo22;
    private JLabel Equipo23;
    private JLabel Equipo24;
    private JLabel Equipo25;
    private JLabel Equipo26;
    private JLabel Equipo27;
    private JLabel Equipo28;
    private JLabel Equipo29;
    private JLabel Equipo30;
    private JLabel ftEquipo2;
    private JLabel ftEquipo3;
    private JLabel ftEquipo7;
    private JLabel ftEquipo8;
    private JLabel ftEquipo12;
    private JLabel ftEquipo13;
    private JLabel ftEquipo17;
    private JLabel ftEquipo18;
    private JLabel ftEquipo21;
    private JLabel ftEquipo22;
    private JLabel ftEquipo23;
    private JLabel ftEquipo24;
    private JLabel ftEquipo25;
    private JLabel ftEquipo26;
    private JLabel ftEquipo27;
    private JLabel ftEquipo28;
    private JLabel ftEquipo29;
    private JLabel ftEquipo30;

    public VentanaEquipos() {

        // Cargar las imágenes con un tamaño específico.
        cargarImagenEstablecerIcono("TheMadZaLogoSimple", 250, 250, ftThemadza);
        cargarImagenEstablecerIcono("Tienda", bTienda);
        cargarImagenEstablecerIcono("Inicio", bInicio);
        cargarImagenEstablecerIcono("Salir", bSalir);
        cargarImagenEstablecerIcono("Twitter", bTwitter);
        cargarImagenEstablecerIcono("Instagram", bInstagram);
        cargarImagenEstablecerIcono("Facebook", bFacebook);
        cargarImagenEstablecerIcono("LogoBlanco", 100, 100, logoBlanco);

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
            VentanaEquipos ventana = new VentanaEquipos();
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