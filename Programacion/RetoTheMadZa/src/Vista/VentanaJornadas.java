package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaJornadas extends JFrame{
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
    private String Equipo1Partido1;
    private String Equipo2Partido1;
    private String Equipo1Partido2;
    private String Equipo2Partido2;
    private String Equipo1Partido3;
    private String Equipo2Partido3;
    private String Equipo1Partido4;
    private String Equipo2Partido4;

    public VentanaJornadas(JFrame ventanaEliminar) {

        cargarImagenEstablecerIcono("TheMadZaLogoSimple", 250, 250, ftThemadza);
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

        //equipos
       /* ImageIcon iconoEquipo1Partido1 = ControladorImagenes.obtenerImagen(Equipo1Partido1, 100, 100);
        ftEquipo1Partido1.setIcon(iconoEquipo1Partido1);

        ImageIcon iconoEquipo2Partido1 = ControladorImagenes.obtenerImagen(Equipo2Partido1, 100, 100);
        ftEquipo2Partido1.setIcon(iconoEquipo2Partido1);

        ImageIcon iconoEquipo1Partido2 = ControladorImagenes.obtenerImagen(Equipo1Partido2, 100, 100);
        ftEquipo1Partido2.setIcon(iconoEquipo1Partido2);

        ImageIcon iconoEquipo2Partido2 = ControladorImagenes.obtenerImagen(Equipo2Partido2, 100, 100);
        ftEquipo2Partido2.setIcon(iconoEquipo2Partido2);

        ImageIcon iconoEquipo1Partido3 = ControladorImagenes.obtenerImagen(Equipo1Partido3, 100, 100);
        ftEquipo1Partido3.setIcon(iconoEquipo1Partido3);

        ImageIcon iconoEquipo2Partido3 = ControladorImagenes.obtenerImagen(Equipo2Partido3, 100, 100);
        ftEquipo2Partido3.setIcon(iconoEquipo2Partido3);

        ImageIcon iconoEquipo1Partido4 = ControladorImagenes.obtenerImagen(Equipo1Partido4, 100, 100);
        ftEquipo1Partido4.setIcon(iconoEquipo1Partido4);

        ImageIcon iconoEquipo2Partido4 = ControladorImagenes.obtenerImagen(Equipo2Partido4, 100, 100);
        ftEquipo2Partido4.setIcon(iconoEquipo2Partido4);*/

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Jornadas");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, bFacebook, bTwitter, bInstagram};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        setVisible(true);

        // Destruir la ventana anterior.
        ventanaEliminar.dispose();
    }

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
        mequipos.addActionListener(al);
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

    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    public void setCbCompeticion(JComboBox<String> cbCompeticion) {
        this.cbCompeticion = cbCompeticion;
    }

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
