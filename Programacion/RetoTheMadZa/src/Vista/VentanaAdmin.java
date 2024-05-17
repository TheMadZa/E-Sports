package Vista;

import Controlador.ControladoresVista.ControladorImagenes;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class VentanaAdmin extends JFrame {
    private JPanel panelUp;
    private JPanel PanelMenu;
    private JMenuBar mPrincipal;
    private JMenu mJornadas;
    private JMenu mEquipos;
    private JPanel PanelLogo;
    private JLabel ftThemadza;
    private JButton bInicio;
    private JButton bSalir;
    private JButton bTienda;
    private JPanel PanelMedio;
    private JPanel panelCRUD;
    private JPanel panelFoot;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JLabel logoBlanco;
    private JPanel pPrincipal;
    private JMenu mJugadores;
    private JMenu mStaff;
    private JMenu mPatrocinadores;
    private JMenu mJuegos;
    private JMenu mCompeticiones;
    private JMenu mEnfrentamientos;
    private JMenuItem miEquipos;
    private JMenuItem miJugadores;
    private JMenuItem miStaff;
    private JMenuItem miPatrocinadores;
    private JMenuItem miJuegos;
    private JMenuItem miCompeticiones;
    private JMenuItem miEnfrentamientos;
    private JMenuItem miJornadas;
    private JMenuItem miVisualizarJornadas;
    private JMenuItem miClasificacionJornadas;
    private JLabel tfImagenLogo;
    private JPanel pImagenLogo;
    private JButton bInsertar;
    private JTextField tfDato1;
    private JLabel jlDato1;
    private JButton bEliminar;
    private JButton bActualizar;
    private JButton bConsultar;
    private JPanel pBotones;
    private JPanel pDatos;

    public VentanaAdmin(){

        panelCRUD.setVisible(false);


            // Cargar la imagen del botón Twitter con tamaño específico
            ImageIcon logoConColor = ControladorImagenes.obtenerImagen("LogoColor", 700, 700);
            if (logoConColor != null) {
                tfImagenLogo.setIcon(logoConColor);
            } else {
                System.err.println("La imagen logo no se encontró.");
            }

        // Cargar la imagen del botón Tienda con tamaño específico
        ImageIcon iconoTienda = ControladorImagenes.obtenerImagen("Tienda", 40, 40);
        if (iconoTienda != null) {
            bTienda.setIcon(iconoTienda);
        } else {
            System.err.println("La imagen Tienda no se encontró.");
        }

        // Cargar la imagen del botón Inicio con tamaño específico
        ImageIcon iconoInicio = ControladorImagenes.obtenerImagen("Inicio", 40, 40);
        if (iconoInicio != null) {
            bInicio.setIcon(iconoInicio);
        } else {
            System.err.println("La imagen Inicio no se encontró.");
        }

        // Cargar la imagen del botón Salir con tamaño específico
        ImageIcon iconoSalir = ControladorImagenes.obtenerImagen("Salir", 40, 40);
        if (iconoSalir != null) {
            bSalir.setIcon(iconoSalir);
        } else {
            System.err.println("La imagen Salir no se encontró.");
        }

        // Cargar la imagen del botón Twitter con tamaño específico
        ImageIcon iconoTwitter = ControladorImagenes.obtenerImagen("Twitter", 40, 40);
        if (iconoTwitter != null) {
            bTwitter.setIcon(iconoTwitter);
        } else {
            System.err.println("La imagen Twitter no se encontró.");
        }

        // Cargar la imagen del botón Instagram con tamaño específico
        ImageIcon iconoInstagram = ControladorImagenes.obtenerImagen("Instagram", 40, 40);
        if (iconoInstagram != null) {
            bInstagram.setIcon(iconoInstagram);
        } else {
            System.err.println("La imagen Instagram no se encontró.");
        }

        // Cargar la imagen del botón Facebook con tamaño específico
        ImageIcon iconoFacebook = ControladorImagenes.obtenerImagen("Facebook", 40, 40);
        if (iconoFacebook != null) {
            bFacebook.setIcon(iconoFacebook);
        } else {
            System.err.println("La imagen Facebook no se encontró.");
        }

        // Cargar la imagen del logo blanco con tamaño específico
        ImageIcon iconoLogoBlanco = ControladorImagenes.obtenerImagen("LogoBlanco", 100, 100);
        if (iconoLogoBlanco != null) {
            logoBlanco.setIcon(iconoLogoBlanco);
        } else {
            System.err.println("La imagen LogoBlanco no se encontró.");
        }



        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Administrador");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, bFacebook, bTwitter, bInstagram};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        /*
        mPrincipal.setBorder(BorderFactory.createEmptyBorder());
        bTienda.setBorder(BorderFactory.createEmptyBorder());
        bInicio.setBorder(BorderFactory.createEmptyBorder());
        bSalir.setBorder(BorderFactory.createEmptyBorder());
        bFacebook.setBorder(BorderFactory.createEmptyBorder());
        bTwitter.setBorder(BorderFactory.createEmptyBorder());
        bInstagram.setBorder(BorderFactory.createEmptyBorder());
         */

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaAdmin ventana = new VentanaAdmin();
        });
    }

    // Getters and Setters
    public JPanel getPanelCRUD() {
        return panelCRUD;
    }

    public void setPanelCRUD(JPanel panelCRUD) {
        this.panelCRUD = panelCRUD;
    }

    public JTextField getTfDato1() {
        return tfDato1;
    }

    public void setTfDato1(JTextField tfDato1) {
        this.tfDato1 = tfDato1;
    }

    public JLabel getJlDato1() {
        return jlDato1;
    }

    public void setJlDato1(String dato1) {
        this.jlDato1.setText(dato1);
    }

    public JPanel getpDatos() {
        return pDatos;
    }

    public void setpDatos(JPanel pDatos) {
        this.pDatos = pDatos;
    }

    // Listeners
    public void addMiCrudAL(ActionListener al) {
        miEquipos.addActionListener(al);
        miJugadores.addActionListener(al);
        miStaff.addActionListener(al);
        miPatrocinadores.addActionListener(al);
        miJuegos.addActionListener(al);
        miCompeticiones.addActionListener(al);
        miEnfrentamientos.addActionListener(al);
        miJornadas.addActionListener(al);
    }
    public void addMiVisualizarJornadasAL(ActionListener al) {
        miVisualizarJornadas.addActionListener(al);
    }
    public void addMiClasificacionJornadasAL(ActionListener al) {
        miClasificacionJornadas.addActionListener(al);
    }
    public void addBAccionesAL(ActionListener al) {
        bInsertar.addActionListener(al);
        bEliminar.addActionListener(al);
        bActualizar.addActionListener(al);
        bConsultar.addActionListener(al);
    }

    // Funciones
    public void mostrarDatosEquipos(){

        setJlDato1("Nombre:");
        JLabel jlFechaFundacion = new JLabel("Fecha de fundación:");
        JTextField tfFechaFundacion = new JTextField(20);
        JLabel jlLogo = new JLabel("Logo:");
        JTextField tfLogo = new JTextField(20);
        JLabel jlColor = new JLabel("Color:");
        JTextField tfColor = new JTextField(20);

        pDatos.add(jlFechaFundacion);
        pDatos.add(tfFechaFundacion);
        pDatos.add(jlLogo);
        pDatos.add(tfLogo);
        pDatos.add(jlColor);
        pDatos.add(tfColor);

        pDatos.revalidate();
        pDatos.repaint();

    }
}
