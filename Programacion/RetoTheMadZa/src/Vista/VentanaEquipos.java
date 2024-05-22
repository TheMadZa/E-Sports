package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

        cargarImagenEstablecerIcono("FlechaIzq", bIzquierda);
        cargarImagenEstablecerIcono("flechaDrch", bDerecha);



        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Equipos");
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this);
        } else {
            System.err.println("Pantalla completa no soportada");
            setExtendedState(JFrame.MAXIMIZED_BOTH); // Tamaño por defecto si pantalla completa no está soportada
            this.setVisible(true);
        }
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

        // Destruir la ventana anterior.
        ventanaEliminar.dispose();
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

    public JButton getbDerecha() {
        return bDerecha;
    }

    public void setbDerecha(JButton bDerecha) {
        this.bDerecha = bDerecha;
    }

    public JButton getbIzquierda() {
        return bIzquierda;
    }

    public void setbIzquierda(JButton bIzquierda) {
        this.bIzquierda = bIzquierda;
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

    private void cargarImagenEstablecerIconoBoton(String nombreImagen, int ancho, int alto, JButton label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

}