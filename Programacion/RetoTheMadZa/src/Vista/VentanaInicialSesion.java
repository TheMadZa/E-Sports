package Vista;

import Controlador.ControladoresVista.ControladorImagenes;
import Modelo.Competicion;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class VentanaInicialSesion extends JFrame {
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
    private JPanel panelJornadas;
    private JLabel vEquipo1;
    private JLabel vEquipo2;
    private JLabel vEquipo3;
    private JLabel vEquipo4;
    private JLabel vEquipo5;
    private JLabel pEquipo1;
    private JLabel pEquipo2;
    private JLabel pEquipo3;
    private JLabel pEquipo4;
    private JLabel pEquipo5;
    private JLabel equipo1;
    private JLabel equipo2;
    private JLabel equipo3;
    private JLabel equipo4;
    private JLabel equipo5;
    private JPanel panelNoticias;
    private JLabel ftNoticias;
    private JComboBox cbClasificacion;
    private JPanel panelFoot;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JLabel logoBlanco;
    private JLabel labelTextoHorizontal;
    private JPanel pPrincipal;

    private int indiceImagenes = 0;


    private String text = " TheMadZa, compañía líder en eSports, organiza dos competiciones activas: el Torneo de" +
            " TheMadZa Legends, con premios millonarios para equipos globales, y TheMadZa Clash, enfocado en nuevos" +
            " talentos. Recientemente, lanzaron su tienda online con productos exclusivos y personalizados. Los" +
            " jugadores pueden registrarse fácilmente para participar en competiciones y acceder a contenido" +
            " exclusivo, sorteos y descuentos especiales. Además, TheMadZa organiza eventos anuales como" +
            " TheMadZa GameCon para mantener a la comunidad activa y comprometida. ";
    private int currentIndex = 0;



    public VentanaInicialSesion() {
        mostrarImagenesFugaces();

        mostrarImagenesFugaces();

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

        // Cargar la imagen del equipo1 con tamaño específico
        ImageIcon iconoEquipo1 = ControladorImagenes.obtenerImagen("Equipo1", 55, 55);
        if (iconoEquipo1 != null) {
            equipo1.setIcon(iconoEquipo1);
        } else {
            System.err.println("La imagen Equipo1 no se encontró.");
        }

        // Cargar la imagen del equipo2 con tamaño específico
        ImageIcon iconoEquipo2 = ControladorImagenes.obtenerImagen("Equipo2", 55, 55);
        if (iconoEquipo2 != null) {
            equipo2.setIcon(iconoEquipo2);
        } else {
            System.err.println("La imagen Equipo2 no se encontró.");
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
        setTitle("Ventana Inicial Sesión");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, cbClasificacion, bFacebook,
                bTwitter, bInstagram};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        // Iniciar el desplazamiento del texto
        iniciarDesplazamientoTexto();

        setVisible(true);
    }

    private void iniciarDesplazamientoTexto() {
        Timer timer = new Timer(80, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String displayedText = text.substring(currentIndex) + text.substring(0, currentIndex);
                labelTextoHorizontal.setText(displayedText);
                currentIndex++;
                if (currentIndex >= text.length()) {
                    currentIndex = 0;
                }
            }
        });
        timer.start();
    }

    // Función para mostrar las imágenes transitorias.
    public void mostrarImagenesFugaces() {
        // Crear un temporizador que cambie la imagen después de unos 4 segundos.
        Timer timer = new Timer(3000, e -> {
            // Cambiar la imagen y actualizar el índice
            indiceImagenes = (indiceImagenes + 1) % 5; // Número de imágenes en el array
            // Obtener la imagen del array cargada en el ControladorImagenes
            ImageIcon icon = ControladorImagenes.obtenerImagen("Noticias" + indiceImagenes, 600, 600);
            if (icon != null) {
                ftNoticias.setIcon(icon);
            } else {
                System.err.println("La imagen Noticias" + indiceImagenes + " no se encontró.");
            }
        });
        // Comenzar el temporizador
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicialSesion ventana = new VentanaInicialSesion();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ventana.setVisible(true);
        });
    }

    // Getters y setters
    public JComboBox<String> getCbClasificacion() {
        return cbClasificacion;
    }

    public void setCbClasificacion(ArrayList<Competicion> listaCompeticiones) {
        // Poner que ningún elemento esté seleccionado, y por lo tanto, que la tabla esté vacía.
        this.cbClasificacion.insertItemAt("", -1);
        for (Competicion competicion : listaCompeticiones) {
            this.cbClasificacion.addItem(competicion.getNombreCom());
        }
    }

    public JLabel getvEquipo1() {
        return vEquipo1;
    }

    public void setvEquipo1(JLabel vEquipo1) {
        this.vEquipo1 = vEquipo1;
    }

    public JLabel getvEquipo2() {
        return vEquipo2;
    }

    public void setvEquipo2(JLabel vEquipo2) {
        this.vEquipo2 = vEquipo2;
    }

    public JLabel getvEquipo3() {
        return vEquipo3;
    }

    public void setvEquipo3(JLabel vEquipo3) {
        this.vEquipo3 = vEquipo3;
    }

    public JLabel getvEquipo4() {
        return vEquipo4;
    }

    public void setvEquipo4(JLabel vEquipo4) {
        this.vEquipo4 = vEquipo4;
    }

    public JLabel getvEquipo5() {
        return vEquipo5;
    }

    public void setvEquipo5(JLabel vEquipo5) {
        this.vEquipo5 = vEquipo5;
    }

    public JLabel getpEquipo1() {
        return pEquipo1;
    }

    public void setpEquipo1(JLabel pEquipo1) {
        this.pEquipo1 = pEquipo1;
    }

    public JLabel getpEquipo2() {
        return pEquipo2;
    }

    public void setpEquipo2(JLabel pEquipo2) {
        this.pEquipo2 = pEquipo2;
    }

    public JLabel getpEquipo3() {
        return pEquipo3;
    }

    public void setpEquipo3(JLabel pEquipo3) {
        this.pEquipo3 = pEquipo3;
    }

    public JLabel getpEquipo4() {
        return pEquipo4;
    }

    public void setpEquipo4(JLabel pEquipo4) {
        this.pEquipo4 = pEquipo4;
    }

    public JLabel getpEquipo5() {
        return pEquipo5;
    }

    public void setpEquipo5(JLabel pEquipo5) {
        this.pEquipo5 = pEquipo5;
    }

    public JLabel getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(JLabel equipo2) {
        this.equipo2 = equipo2;
    }

    public JLabel getEquipo3() {
        return equipo3;
    }

    public void setEquipo3(JLabel equipo3) {
        this.equipo3 = equipo3;
    }

    public JLabel getEquipo4() {
        return equipo4;
    }

    public void setEquipo4(JLabel equipo4) {
        this.equipo4 = equipo4;
    }

    public JLabel getEquipo5() {
        return equipo5;
    }

    public void setEquipo5(JLabel equipo5) {
        this.equipo5 = equipo5;
    }

    public JLabel getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(JLabel equipo1) {
        this.equipo1 = equipo1;
    }

    // Listeners
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
    public void addMJornadasAL(ActionListener al) {
        mJornadas.addActionListener(al);
    }
    public void addMClasificacionAL(ActionListener al) {
        mClasificacion.addActionListener(al);
    }
    public void addMEquiposAL(ActionListener al) {
        mequipos.addActionListener(al);
    }
    public void addCbClasificacionAL(ActionListener al) {
        cbClasificacion.addActionListener(al);
    }
}
