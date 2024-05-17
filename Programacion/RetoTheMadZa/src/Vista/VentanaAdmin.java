package Vista;

import Controlador.ControladoresVista.ControladorImagenes;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

        // Cargar las imágenes con un tamaño específico.
        cargarImagenEstablecerIcono("TheMadZaLogoSimple", 250, 250, ftThemadza);
        cargarImagenEstablecerIcono("Tienda", bTienda);
        cargarImagenEstablecerIcono("Inicio", bInicio);
        cargarImagenEstablecerIcono("Salir", bSalir);
        cargarImagenEstablecerIcono("Twitter", bTwitter);
        cargarImagenEstablecerIcono("Instagram", bInstagram);
        cargarImagenEstablecerIcono("Facebook", bFacebook);
        cargarImagenEstablecerIcono("LogoBlanco", 100, 100, logoBlanco);
        cargarImagenEstablecerIcono("LogoColor", 600, 600, tfImagenLogo);

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

        // TODO : PONER BIEN TODO

        setJlDato1("Nombre:");
        JLabel jlFechaFundacion = new JLabel("Fecha de fundación:");
        JTextField tfFechaFundacion = new JTextField(); //20
        JLabel jlLogo = new JLabel("Logo:");
        JTextField tfLogo = new JTextField();
        JLabel jlColor = new JLabel("Color:");
        JTextField tfColor = new JTextField();

        pDatos.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pDatos.add(getJlDato1(), gbc);
        gbc.gridy++;
        pDatos.add(jlFechaFundacion, gbc);
        gbc.gridy++;
        pDatos.add(tfFechaFundacion, gbc);
        gbc.gridy++;
        pDatos.add(jlLogo, gbc);
        gbc.gridy++;
        pDatos.add(tfLogo, gbc);
        gbc.gridy++;
        pDatos.add(jlColor, gbc);
        gbc.gridy++;
        pDatos.add(tfColor, gbc);

        //pDatos.revalidate();
        //pDatos.repaint();

    }

    // Método auxiliar para cargar imágenes y establecer íconos (una función es para los JLabel y la otra para JButton)
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
