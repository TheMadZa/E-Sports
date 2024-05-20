package Vista;

import javax.swing.*;

public class VentanaClasificacion extends JFrame{
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
    private JLabel JLnomSegundo;
    private JLabel JLnomCuarto;
    private JLabel JLnomTercer;
    private JComboBox cbCompeticion;
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

    public VentanaClasificacion(VentanaInicial vi) {

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Clasificación");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        setVisible(true);

        // Destruir la ventana de inicio de sesión.
        vi.dispose();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaClasificacion ventana = new VentanaClasificacion(null);
        });
    }
}