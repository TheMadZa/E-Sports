package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaClasificacion extends JFrame{
    private JPanel panelUp;
    private JPanel PanelMenu;
    private JMenuBar mPrincipal;
    private JMenuItem mJornadas;
    private JMenuItem mClasificacion;
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
    private JLabel JLnomSegundo;
    private JLabel JLnomCuarto;
    private JLabel JLnomTercer;
    private JComboBox<String> cbCompeticion;
    private JTextField tfNombreJuego;
    private JLabel JLNombreJuego;
    private JLabel JLnomPrimer;
    private JLabel JLnomQuinto;
    private JPanel pPrimerPuesto;
    private JLabel JLnomSexto;
    private JLabel JLnomSeptimo;
    private JLabel JLnomOctavo;
    private JLabel JLnomNoveno;
    private JLabel JLnomDecimo;
    private JLabel ImgPrimer;
    private JLabel ImgSegundo;
    private JLabel ImgTercero;
    private JLabel ImgCuarto;
    private JLabel ImgQuinto;
    private JLabel ImgSexto;
    private JLabel ImgSeptimo;
    private JLabel ImgOctavo;
    private JLabel ImgNoveno;
    private JLabel ImgDecimo;
    private JLabel JLpuntosDecimo;
    private JLabel JLpuntosNoveno;
    private JLabel JLpuntosOctavo;
    private JLabel JLpuntosSeptimo;
    private JLabel JLpuntosSexto;
    private JLabel JLpuntosQuinto;
    private JLabel JLpuntosCuarto;
    private JLabel JLpuntosTercero;
    private JLabel JLpuntosSegundo;
    private JLabel JLpuntosPrimer;
    private JLabel JLvictoriasPrimero;
    private JLabel JLvictoriasSegundo;
    private JLabel JLvictoriasTercero;
    private JLabel JLvictoriasCuarto;
    private JLabel JLvictoriasQuinto;
    private JLabel JLvictoriasSexto;
    private JLabel JLvictoriasSeptimo;
    private JLabel JLvictoriasOctavo;
    private JLabel JLvictoriasNoveno;
    private JLabel JLvictoriasDecimo;
    private JLabel JLNombreCompeticion;
    private JLabel JLNombreCompeticion2;
    private JLabel JLNombreCompeticion3;
    private JLabel JLNombreCompeticion4;
    private JLabel JLNombreCompeticion5;
    private JLabel JLNombreCompeticion7;
    private JLabel JLNombreCompeticion8;
    private JLabel JLNombreCompeticion10;
    private JLabel JLNombreCompeticion9;
    private JLabel JLNombreCompeticion6;
    private JPanel pPrincipal;
    private JMenuItem mEquipos;

    public VentanaClasificacion(JFrame ventanaEliminar) {

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
        setTitle("Ventana Clasificación");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, bFacebook,
                bTwitter, bInstagram};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        setVisible(true);

        // Destruir la ventana anterior.
        ventanaEliminar.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaClasificacion ventana = new VentanaClasificacion(null);
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

    //Getters y setters

    public JComboBox<String> getCbClasificacion() {
        return cbCompeticion;
    }

    public JPanel getPanelUp() {
        return panelUp;
    }

    public void setPanelUp(JPanel panelUp) {
        this.panelUp = panelUp;
    }

    public JLabel getJLnomSegundo() {
        return JLnomSegundo;
    }

    public void setJLnomSegundo(JLabel JLnomSegundo) {
        this.JLnomSegundo = JLnomSegundo;
    }

    public JLabel getJLnomCuarto() {
        return JLnomCuarto;
    }

    public void setJLnomCuarto(JLabel JLnomCuarto) {
        this.JLnomCuarto = JLnomCuarto;
    }

    public JLabel getJLnomTercer() {
        return JLnomTercer;
    }

    public void setJLnomTercer(JLabel JLnomTercer) {
        this.JLnomTercer = JLnomTercer;
    }

    public JComboBox getCbCompeticion() {
        return cbCompeticion;
    }

    public void setCbCompeticion(JComboBox cbCompeticion) {
        this.cbCompeticion = cbCompeticion;
    }

    public JTextField getTfNombreJuego() {
        return tfNombreJuego;
    }

    public void setTfNombreJuego(JTextField tfNombreJuego) {
        this.tfNombreJuego = tfNombreJuego;
    }

    public JLabel getJLnomPrimer() {
        return JLnomPrimer;
    }

    public void setJLnomPrimer(JLabel JLnomPrimer) {
        this.JLnomPrimer = JLnomPrimer;
    }

    public JLabel getJLnomQuinto() {
        return JLnomQuinto;
    }

    public void setJLnomQuinto(JLabel JLnomQuinto) {
        this.JLnomQuinto = JLnomQuinto;
    }

    public JPanel getpPrimerPuesto() {
        return pPrimerPuesto;
    }

    public void setpPrimerPuesto(JPanel pPrimerPuesto) {
        this.pPrimerPuesto = pPrimerPuesto;
    }

    public JLabel getJLnomSexto() {
        return JLnomSexto;
    }

    public void setJLnomSexto(JLabel JLnomSexto) {
        this.JLnomSexto = JLnomSexto;
    }

    public JLabel getJLnomSeptimo() {
        return JLnomSeptimo;
    }

    public void setJLnomSeptimo(JLabel JLnomSeptimo) {
        this.JLnomSeptimo = JLnomSeptimo;
    }

    public JLabel getJLnomOctavo() {
        return JLnomOctavo;
    }

    public void setJLnomOctavo(JLabel JLnomOctavo) {
        this.JLnomOctavo = JLnomOctavo;
    }

    public JLabel getJLnomNoveno() {
        return JLnomNoveno;
    }

    public void setJLnomNoveno(JLabel JLnomNoveno) {
        this.JLnomNoveno = JLnomNoveno;
    }

    public JLabel getJLnomDecimo() {
        return JLnomDecimo;
    }

    public void setJLnomDecimo(JLabel JLnomDecimo) {
        this.JLnomDecimo = JLnomDecimo;
    }

    public JLabel getImgPrimer() {
        return ImgPrimer;
    }

    public void setImgPrimer(JLabel imgPrimer) {
        ImgPrimer = imgPrimer;
    }

    public JLabel getImgSegundo() {
        return ImgSegundo;
    }

    public void setImgSegundo(JLabel imgSegundo) {
        ImgSegundo = imgSegundo;
    }

    public JLabel getImgTercero() {
        return ImgTercero;
    }

    public void setImgTercero(JLabel imgTercero) {
        ImgTercero = imgTercero;
    }

    public JLabel getImgCuarto() {
        return ImgCuarto;
    }

    public void setImgCuarto(JLabel imgCuarto) {
        ImgCuarto = imgCuarto;
    }

    public JLabel getImgQuinto() {
        return ImgQuinto;
    }

    public void setImgQuinto(JLabel imgQuinto) {
        ImgQuinto = imgQuinto;
    }

    public JLabel getImgSexto() {
        return ImgSexto;
    }

    public void setImgSexto(JLabel imgSexto) {
        ImgSexto = imgSexto;
    }

    public JLabel getImgSeptimo() {
        return ImgSeptimo;
    }

    public void setImgSeptimo(JLabel imgSeptimo) {
        ImgSeptimo = imgSeptimo;
    }

    public JLabel getImgOctavo() {
        return ImgOctavo;
    }

    public void setImgOctavo(JLabel imgOctavo) {
        ImgOctavo = imgOctavo;
    }

    public JLabel getImgNoveno() {
        return ImgNoveno;
    }

    public void setImgNoveno(JLabel imgNoveno) {
        ImgNoveno = imgNoveno;
    }

    public JLabel getImgDecimo() {
        return ImgDecimo;
    }

    public void setImgDecimo(JLabel imgDecimo) {
        ImgDecimo = imgDecimo;
    }

    public JLabel getJLpuntosDecimo() {
        return JLpuntosDecimo;
    }

    public void setJLpuntosDecimo(JLabel JLpuntosDecimo) {
        this.JLpuntosDecimo = JLpuntosDecimo;
    }

    public JLabel getJLpuntosNoveno() {
        return JLpuntosNoveno;
    }

    public void setJLpuntosNoveno(JLabel JLpuntosNoveno) {
        this.JLpuntosNoveno = JLpuntosNoveno;
    }

    public JLabel getJLpuntosOctavo() {
        return JLpuntosOctavo;
    }

    public void setJLpuntosOctavo(JLabel JLpuntosOctavo) {
        this.JLpuntosOctavo = JLpuntosOctavo;
    }

    public JLabel getJLpuntosSeptimo() {
        return JLpuntosSeptimo;
    }

    public void setJLpuntosSeptimo(JLabel JLpuntosSeptimo) {
        this.JLpuntosSeptimo = JLpuntosSeptimo;
    }

    public JLabel getJLpuntosSexto() {
        return JLpuntosSexto;
    }

    public void setJLpuntosSexto(JLabel JLpuntosSexto) {
        this.JLpuntosSexto = JLpuntosSexto;
    }

    public JLabel getJLpuntosQuinto() {
        return JLpuntosQuinto;
    }

    public void setJLpuntosQuinto(JLabel JLpuntosQuinto) {
        this.JLpuntosQuinto = JLpuntosQuinto;
    }

    public JLabel getJLpuntosCuarto() {
        return JLpuntosCuarto;
    }

    public void setJLpuntosCuarto(JLabel JLpuntosCuarto) {
        this.JLpuntosCuarto = JLpuntosCuarto;
    }

    public JLabel getJLpuntosTercero() {
        return JLpuntosTercero;
    }

    public void setJLpuntosTercero(JLabel JLpuntosTercero) {
        this.JLpuntosTercero = JLpuntosTercero;
    }

    public JLabel getJLpuntosSegundo() {
        return JLpuntosSegundo;
    }

    public void setJLpuntosSegundo(JLabel JLpuntosSegundo) {
        this.JLpuntosSegundo = JLpuntosSegundo;
    }

    public JLabel getJLpuntosPrimer() {
        return JLpuntosPrimer;
    }

    public void setJLpuntosPrimer(JLabel JLpuntosPrimer) {
        this.JLpuntosPrimer = JLpuntosPrimer;
    }

    public JLabel getJLvictoriasPrimero() {
        return JLvictoriasPrimero;
    }

    public void setJLvictoriasPrimero(JLabel JLvictoriasPrimero) {
        this.JLvictoriasPrimero = JLvictoriasPrimero;
    }

    public JLabel getJLvictoriasSegundo() {
        return JLvictoriasSegundo;
    }

    public void setJLvictoriasSegundo(JLabel JLvictoriasSegundo) {
        this.JLvictoriasSegundo = JLvictoriasSegundo;
    }

    public JLabel getJLvictoriasTercero() {
        return JLvictoriasTercero;
    }

    public void setJLvictoriasTercero(JLabel JLvictoriasTercero) {
        this.JLvictoriasTercero = JLvictoriasTercero;
    }

    public JLabel getJLvictoriasCuarto() {
        return JLvictoriasCuarto;
    }

    public void setJLvictoriasCuarto(JLabel JLvictoriasCuarto) {
        this.JLvictoriasCuarto = JLvictoriasCuarto;
    }

    public JLabel getJLvictoriasQuinto() {
        return JLvictoriasQuinto;
    }

    public void setJLvictoriasQuinto(JLabel JLvictoriasQuinto) {
        this.JLvictoriasQuinto = JLvictoriasQuinto;
    }

    public JLabel getJLvictoriasSexto() {
        return JLvictoriasSexto;
    }

    public void setJLvictoriasSexto(JLabel JLvictoriasSexto) {
        this.JLvictoriasSexto = JLvictoriasSexto;
    }

    public JLabel getJLvictoriasSeptimo() {
        return JLvictoriasSeptimo;
    }

    public void setJLvictoriasSeptimo(JLabel JLvictoriasSeptimo) {
        this.JLvictoriasSeptimo = JLvictoriasSeptimo;
    }

    public JLabel getJLvictoriasOctavo() {
        return JLvictoriasOctavo;
    }

    public void setJLvictoriasOctavo(JLabel JLvictoriasOctavo) {
        this.JLvictoriasOctavo = JLvictoriasOctavo;
    }

    public JLabel getJLvictoriasNoveno() {
        return JLvictoriasNoveno;
    }

    public void setJLvictoriasNoveno(JLabel JLvictoriasNoveno) {
        this.JLvictoriasNoveno = JLvictoriasNoveno;
    }

    public JLabel getJLvictoriasDecimo() {
        return JLvictoriasDecimo;
    }

    public void setJLvictoriasDecimo(JLabel JLvictoriasDecimo) {
        this.JLvictoriasDecimo = JLvictoriasDecimo;
    }

    public JLabel getJLNombreCompeticion() {
        return JLNombreCompeticion;
    }

    public void setJLNombreCompeticion(JLabel JLNombreCompeticion) {
        this.JLNombreCompeticion = JLNombreCompeticion;
    }

    public JLabel getJLNombreCompeticion2() {
        return JLNombreCompeticion2;
    }

    public void setJLNombreCompeticion2(JLabel JLNombreCompeticion2) {
        this.JLNombreCompeticion2 = JLNombreCompeticion2;
    }

    public JLabel getJLNombreCompeticion3() {
        return JLNombreCompeticion3;
    }

    public void setJLNombreCompeticion3(JLabel JLNombreCompeticion3) {
        this.JLNombreCompeticion3 = JLNombreCompeticion3;
    }

    public JLabel getJLNombreCompeticion4() {
        return JLNombreCompeticion4;
    }

    public void setJLNombreCompeticion4(JLabel JLNombreCompeticion4) {
        this.JLNombreCompeticion4 = JLNombreCompeticion4;
    }

    public JLabel getJLNombreCompeticion5() {
        return JLNombreCompeticion5;
    }

    public void setJLNombreCompeticion5(JLabel JLNombreCompeticion5) {
        this.JLNombreCompeticion5 = JLNombreCompeticion5;
    }

    public JLabel getJLNombreCompeticion7() {
        return JLNombreCompeticion7;
    }

    public void setJLNombreCompeticion7(JLabel JLNombreCompeticion7) {
        this.JLNombreCompeticion7 = JLNombreCompeticion7;
    }

    public JLabel getJLNombreCompeticion8() {
        return JLNombreCompeticion8;
    }

    public void setJLNombreCompeticion8(JLabel JLNombreCompeticion8) {
        this.JLNombreCompeticion8 = JLNombreCompeticion8;
    }

    public JLabel getJLNombreCompeticion10() {
        return JLNombreCompeticion10;
    }

    public void setJLNombreCompeticion10(JLabel JLNombreCompeticion10) {
        this.JLNombreCompeticion10 = JLNombreCompeticion10;
    }

    public JLabel getJLNombreCompeticion9() {
        return JLNombreCompeticion9;
    }

    public void setJLNombreCompeticion9(JLabel JLNombreCompeticion9) {
        this.JLNombreCompeticion9 = JLNombreCompeticion9;
    }

    public JLabel getJLNombreCompeticion6() {
        return JLNombreCompeticion6;
    }

    public void setJLNombreCompeticion6(JLabel JLNombreCompeticion6) {
        this.JLNombreCompeticion6 = JLNombreCompeticion6;
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



    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
}
