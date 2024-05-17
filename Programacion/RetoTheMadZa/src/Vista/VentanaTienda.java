package Vista;

import Controlador.ControladoresVista.ControladorImagenes;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class VentanaTienda extends JFrame{
    private JPanel pPrincipal;
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
    private JLabel labelTextoHorizontal;
    private JScrollPane PanelMedio;
    private JLabel tienda3;
    private JLabel tienda4;
    private JLabel tienda5;
    private JLabel tienda6;
    private JLabel tienda7;
    private JLabel tienda8;
    private JLabel tienda9;
    private JLabel tienda10;
    private JLabel tienda11;
    private JPanel tien;
    private JLabel tienda12;
    private JLabel separador1;
    private JLabel tienda1;
    private JButton bBuy1;
    private JButton bBuy2;
    private JButton bBuy3;
    private JButton bBuy4;
    private JButton bBuy5;
    private JButton bBuy6;
    private JButton bBuy7;
    private JButton bBuy8;
    private JButton bBuy9;
    private JPanel JPanel;
    private JButton bBuy10;
    private JButton bBuy11;
    private JButton bBuy12;
    private JLabel tienda2;
    private JPanel panelTienda1;
    private final String text = " TheMadZa, compañía líder en eSports, organiza dos competiciones activas: el Torneo de" +
            " TheMadZa Legends, con premios millonarios para equipos globales, y TheMadZa Clash, enfocado en nuevos" +
            " talentos. Recientemente, lanzaron su tienda online con productos exclusivos y personalizados. Los" +
            " jugadores pueden registrarse fácilmente para participar en competiciones y acceder a contenido" +
            " exclusivo, sorteos y descuentos especiales. Además, TheMadZa organiza eventos anuales como" +
            " TheMadZa GameCon para mantener a la comunidad activa y comprometida. ";
    private int currentIndex = 0;

    public VentanaTienda() {


            ftThemadza.setIcon(ControladorImagenes.obtenerImagen("TheMadZaLogoSimple", 250, 250));
            bTienda.setIcon(ControladorImagenes.obtenerImagen("Tienda", 40, 40));
            bInicio.setIcon(ControladorImagenes.obtenerImagen("Inicio", 40, 40));
            bSalir.setIcon(ControladorImagenes.obtenerImagen("Salir", 40, 40));
            bTwitter.setIcon(ControladorImagenes.obtenerImagen("Twitter", 40, 40));
            bInstagram.setIcon(ControladorImagenes.obtenerImagen("Instagram", 40, 40));
            bFacebook.setIcon(ControladorImagenes.obtenerImagen("Facebook", 40, 40));
            logoBlanco.setIcon(ControladorImagenes.obtenerImagen("LogoBlanco", 100, 100));
            tienda1.setIcon(ControladorImagenes.obtenerImagen("Tienda1", 400, 400));
            tienda2.setIcon(ControladorImagenes.obtenerImagen("Tienda2", 400, 400));
            tienda3.setIcon(ControladorImagenes.obtenerImagen("Tienda3", 400, 400));
            tienda4.setIcon(ControladorImagenes.obtenerImagen("Tienda4", 400, 400));
            tienda5.setIcon(ControladorImagenes.obtenerImagen("Tienda5", 400, 400));
            tienda6.setIcon(ControladorImagenes.obtenerImagen("Tienda6", 400, 400));
            tienda7.setIcon(ControladorImagenes.obtenerImagen("Tienda7", 400, 400));
            tienda8.setIcon(ControladorImagenes.obtenerImagen("Tienda8", 400, 400));
            tienda9.setIcon(ControladorImagenes.obtenerImagen("Tienda9", 400, 400));
            tienda10.setIcon(ControladorImagenes.obtenerImagen("Tienda10", 400, 400));
            tienda11.setIcon(ControladorImagenes.obtenerImagen("Tienda11", 400, 400));
            tienda12.setIcon(ControladorImagenes.obtenerImagen("Tienda12", 400, 400));

            ImageIcon iconoBuy = ControladorImagenes.obtenerImagen("Buy", 50, 50);
            bBuy1.setIcon(iconoBuy);
            bBuy2.setIcon(iconoBuy);
            bBuy3.setIcon(iconoBuy);
            bBuy4.setIcon(iconoBuy);
            bBuy5.setIcon(iconoBuy);
            bBuy6.setIcon(iconoBuy);
            bBuy7.setIcon(iconoBuy);
            bBuy8.setIcon(iconoBuy);
            bBuy9.setIcon(iconoBuy);
            bBuy10.setIcon(iconoBuy);
            bBuy11.setIcon(iconoBuy);
            bBuy12.setIcon(iconoBuy);


        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Tienda");
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
        bBuy1.setBorder(BorderFactory.createEmptyBorder());
        bBuy2.setBorder(BorderFactory.createEmptyBorder());
        bBuy3.setBorder(BorderFactory.createEmptyBorder());
        bBuy4.setBorder(BorderFactory.createEmptyBorder());
        bBuy5.setBorder(BorderFactory.createEmptyBorder());
        bBuy6.setBorder(BorderFactory.createEmptyBorder());
        bBuy7.setBorder(BorderFactory.createEmptyBorder());
        bBuy8.setBorder(BorderFactory.createEmptyBorder());
        bBuy9.setBorder(BorderFactory.createEmptyBorder());
        bBuy10.setBorder(BorderFactory.createEmptyBorder());
        bBuy11.setBorder(BorderFactory.createEmptyBorder());
        bBuy12.setBorder(BorderFactory.createEmptyBorder());

        Color backgroundColor = Color.decode("#5B2C78");
        Color foregroundColor = Color.decode("#151135");

        JScrollBar verticalScrollBar = PanelMedio.getVerticalScrollBar();
        verticalScrollBar.setBackground(backgroundColor);
        verticalScrollBar.setForeground(foregroundColor);
        PanelMedio.getViewport().setBackground(backgroundColor);
        PanelMedio.setBackground(backgroundColor);

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
            VentanaTienda ventana = new VentanaTienda();
        });
    }

    // Funciones
    public void mostrarMensajeBuy() {

        Font font = new Font("Arial", Font.BOLD, 16);
        String message = "Añadido al carrito.";

        // Creación del panel de mensaje personalizado
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo degradado
                GradientPaint gradientPaint = new GradientPaint(
                        0, 0, new Color(68, 1, 84), 0, getHeight(),
                        new Color(213, 113, 112));
                g2.setPaint(gradientPaint);
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Dibujar ícono de mensaje entrante
                int iconSize = 40;
                Icon incomingMessageIcon = UIManager.getIcon("OptionPane.informationIcon");
                if (incomingMessageIcon != null) {
                    incomingMessageIcon.paintIcon(this, g2, 20, (getHeight() - iconSize) / 2);
                }

                // Configurar fuente y color del texto
                g2.setFont(font);
                g2.setColor(Color.WHITE);

                // Dibujar el mensaje centrado
                FontMetrics metrics = g2.getFontMetrics(font);
                int x = 70; // Ajustar posición X para el texto
                int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g2.drawString(message, x, y);
            }
        };

        // Configuración del panel
        panel.setPreferredSize(new Dimension(400, 100));

        // Mostrar el JOptionPane personalizado
        JOptionPane.showMessageDialog(null, panel, "Aviso", JOptionPane.PLAIN_MESSAGE);

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
    public void addBBuyAL(ActionListener al) {
        bBuy1.addActionListener(al);
        bBuy2.addActionListener(al);
        bBuy3.addActionListener(al);
        bBuy4.addActionListener(al);
        bBuy5.addActionListener(al);
        bBuy6.addActionListener(al);
        bBuy7.addActionListener(al);
        bBuy8.addActionListener(al);
        bBuy9.addActionListener(al);
        bBuy10.addActionListener(al);
        bBuy11.addActionListener(al);
        bBuy12.addActionListener(al);
    }
}

