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
    private JLabel labelTextoHorizontal;
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
    private JComboBox cbCompeticion;
    private String Equipo1Partido1;
    private String Equipo2Partido1;
    private String Equipo1Partido2;
    private String Equipo2Partido2;
    private String Equipo1Partido3;
    private String Equipo2Partido3;
    private String Equipo1Partido4;
    private String Equipo2Partido4;
    private final String text = " TheMadZa, compañía líder en eSports, organiza dos competiciones activas: el Torneo de" +
            " TheMadZa Legends, con premios millonarios para equipos globales, y TheMadZa Clash, enfocado en nuevos" +
            " talentos. Recientemente, lanzaron su tienda online con productos exclusivos y personalizados. Los" +
            " jugadores pueden registrarse fácilmente para participar en competiciones y acceder a contenido" +
            " exclusivo, sorteos y descuentos especiales. Además, TheMadZa organiza eventos anuales como" +
            " TheMadZa GameCon para mantener a la comunidad activa y comprometida. ";
    private int currentIndex = 0;

    public VentanaJornadas() {


        System.out.println("Iniciando constructor de VentanaInicial.");

        // Cargar la imagen del logo con tamaño específico
        ImageIcon iconoLogo = ControladorImagenes.obtenerImagen("TheMadZaLogoSimple", 250, 250);
        if (iconoLogo != null) {
            ftThemadza.setIcon(iconoLogo);
        } else {
            System.err.println("La imagen TheMadZaLogoSimple no se encontró.");
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

        //equipos
        ImageIcon iconoEquipo1Partido1 = ControladorImagenes.obtenerImagen(Equipo1Partido1, 100, 100);
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
        ftEquipo2Partido4.setIcon(iconoEquipo2Partido4);


        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Inicial");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        mPrincipal.setBorder(BorderFactory.createEmptyBorder());
        bTienda.setBorder(BorderFactory.createEmptyBorder());
        bInicio.setBorder(BorderFactory.createEmptyBorder());
        bSalir.setBorder(BorderFactory.createEmptyBorder());
        bFacebook.setBorder(BorderFactory.createEmptyBorder());
        bTwitter.setBorder(BorderFactory.createEmptyBorder());
        bInstagram.setBorder(BorderFactory.createEmptyBorder());

        // Iniciar el desplazamiento del texto
        iniciarDesplazamientoTexto();

        setVisible(true);
    }

    private void iniciarDesplazamientoTexto() {
        Timer timer = new Timer(80, e -> {
            String displayedText = text.substring(currentIndex) + text.substring(0, currentIndex);
            labelTextoHorizontal.setText(displayedText);
            currentIndex++;
            if (currentIndex >= text.length()) {
                currentIndex = 0;
            }
        });
        timer.start();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaJornadas ventana = new VentanaJornadas();
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

}
