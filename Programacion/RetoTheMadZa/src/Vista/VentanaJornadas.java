package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

    public VentanaJornadas(JFrame ventanaEliminar) {

        cargarImagenEstablecerIconoBoton("TheMadZaLogoSimple", 250, 250, ftThemadza);
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
        ftThemadza.setBorder(BorderFactory.createEmptyBorder());

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

    private void cargarImagenEstablecerIconoBoton(String nombreImagen, int ancho, int alto, JButton label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
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

    public void setFtEquipo1Partido1(JLabel ftEquipo1Partido1) {
        this.ftEquipo1Partido1 = ftEquipo1Partido1;
    }

    public JLabel getFtEquipo2Partido1() {
        return ftEquipo2Partido1;
    }

    public void setFtEquipo2Partido1(JLabel ftEquipo2Partido1) {
        this.ftEquipo2Partido1 = ftEquipo2Partido1;
    }

    public JLabel getFtEquipo2Partido2() {
        return ftEquipo2Partido2;
    }

    public void setFtEquipo2Partido2(JLabel ftEquipo2Partido2) {
        this.ftEquipo2Partido2 = ftEquipo2Partido2;
    }

    public JLabel getFtEquipo2Partido3() {
        return ftEquipo2Partido3;
    }

    public void setFtEquipo2Partido3(JLabel ftEquipo2Partido3) {
        this.ftEquipo2Partido3 = ftEquipo2Partido3;
    }

    public JLabel getFtEquipo2Partido4() {
        return ftEquipo2Partido4;
    }

    public void setFtEquipo2Partido4(JLabel ftEquipo2Partido4) {
        this.ftEquipo2Partido4 = ftEquipo2Partido4;
    }

    public JLabel getFtEquipo1Partido2() {
        return ftEquipo1Partido2;
    }

    public void setFtEquipo1Partido2(JLabel ftEquipo1Partido2) {
        this.ftEquipo1Partido2 = ftEquipo1Partido2;
    }

    public JLabel getFtEquipo1Partido3() {
        return ftEquipo1Partido3;
    }

    public void setFtEquipo1Partido3(JLabel ftEquipo1Partido3) {
        this.ftEquipo1Partido3 = ftEquipo1Partido3;
    }

    public JLabel getFtEquipo1Partido4() {
        return ftEquipo1Partido4;
    }

    public void setFtEquipo1Partido4(JLabel ftEquipo1Partido4) {
        this.ftEquipo1Partido4 = ftEquipo1Partido4;
    }

    public JLabel getResultadoEquipo1Partido1() {
        return resultadoEquipo1Partido1;
    }

    public void setResultadoEquipo1Partido1(JLabel resultadoEquipo1Partido1) {
        this.resultadoEquipo1Partido1 = resultadoEquipo1Partido1;
    }

    public JLabel getResultadoEquipo2Partido1() {
        return resultadoEquipo2Partido1;
    }

    public void setResultadoEquipo2Partido1(JLabel resultadoEquipo2Partido1) {
        this.resultadoEquipo2Partido1 = resultadoEquipo2Partido1;
    }

    public JLabel getResultadoEquipo1Partido2() {
        return resultadoEquipo1Partido2;
    }

    public void setResultadoEquipo1Partido2(JLabel resultadoEquipo1Partido2) {
        this.resultadoEquipo1Partido2 = resultadoEquipo1Partido2;
    }

    public JLabel getResultadoEquipo2Partido2() {
        return resultadoEquipo2Partido2;
    }

    public void setResultadoEquipo2Partido2(JLabel resultadoEquipo2Partido2) {
        this.resultadoEquipo2Partido2 = resultadoEquipo2Partido2;
    }

    public JLabel getResultadoEquipo1Partido3() {
        return resultadoEquipo1Partido3;
    }

    public void setResultadoEquipo1Partido3(JLabel resultadoEquipo1Partido3) {
        this.resultadoEquipo1Partido3 = resultadoEquipo1Partido3;
    }

    public JLabel getResultadoEquipo2Partido3() {
        return resultadoEquipo2Partido3;
    }

    public void setResultadoEquipo2Partido3(JLabel resultadoEquipo2Partido3) {
        this.resultadoEquipo2Partido3 = resultadoEquipo2Partido3;
    }

    public JLabel getResultadoEquipo1Partido4() {
        return resultadoEquipo1Partido4;
    }

    public void setResultadoEquipo1Partido4(JLabel resultadoEquipo1Partido4) {
        this.resultadoEquipo1Partido4 = resultadoEquipo1Partido4;
    }

    public JLabel getResultadoEquipo2Partido4() {
        return resultadoEquipo2Partido4;
    }

    public void setResultadoEquipo2Partido4(JLabel resultadoEquipo2Partido4) {
        this.resultadoEquipo2Partido4 = resultadoEquipo2Partido4;
    }
}
