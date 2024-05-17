package Vista;

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

        try {

            // Cargar la imagen original del logo
            URL imageUrl = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/TheMadZaLogoSimple.png?raw=true");
            BufferedImage imagenOriginal = ImageIO.read(imageUrl);

            // Escalar la imagen
            BufferedImage bufferedImage = Scalr.resize(imagenOriginal, 250);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado = new ImageIcon(bufferedImage);

            // Asignar el ImageIcon escalado al JLabel ftThemadza
            ftThemadza.setIcon(iconoEscalado);


            // Cargar la imagen Botón Tienda
            URL Tienda = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/tienda.png?raw=true");
            BufferedImage imagenTienda = ImageIO.read(Tienda);
            BufferedImage bufferedImageTienda = Scalr.resize(imagenTienda, 40);
            ImageIcon iconoTienda = new ImageIcon(bufferedImageTienda);
            bTienda.setIcon(iconoTienda);

            // Botón Inicio
            URL Inicio1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/inicio.png?raw=true");
            BufferedImage imagenInicio = ImageIO.read(Inicio1);
            BufferedImage bufferedImageInicio = Scalr.resize(imagenInicio, 40);
            ImageIcon iconoInicio = new ImageIcon(bufferedImageInicio);
            bInicio.setIcon(iconoInicio);

            // Botón Salir
            URL Salir1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/powerOff.png?raw=true");
            BufferedImage imagenSalir = ImageIO.read(Salir1);
            BufferedImage bufferedImageSalir = Scalr.resize(imagenSalir, 40);
            ImageIcon iconoSalir = new ImageIcon(bufferedImageSalir);
            bSalir.setIcon(iconoSalir);

            // Botón Twitter
            URL Twitter = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/TwitterLogo.png?raw=true");
            BufferedImage imagenTwitter = ImageIO.read(Twitter);
            BufferedImage bufferedImageTwitter = Scalr.resize(imagenTwitter, 40);
            ImageIcon iconoTwitter = new ImageIcon(bufferedImageTwitter);
            bTwitter.setIcon(iconoTwitter);

            // Botón Instagram
            URL Insta = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/InstagramLogo.png?raw=true");
            BufferedImage imagenInstagram = ImageIO.read(Insta);
            BufferedImage bufferedImageInstagram = Scalr.resize(imagenInstagram, 40);
            ImageIcon iconoInstagram = new ImageIcon(bufferedImageInstagram);
            bInstagram.setIcon(iconoInstagram);

            // Botón Facebook
            URL Facebook = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/FacebookLogo.png?raw=true");
            BufferedImage imagenFacebook = ImageIO.read(Facebook);
            BufferedImage bufferedImageFacebook = Scalr.resize(imagenFacebook, 40);
            ImageIcon iconoFacebook = new ImageIcon(bufferedImageFacebook);
            bFacebook.setIcon(iconoFacebook);

            // Imagen LogoBlanco
            URL LogoBlanco = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/SoloBlanco.png?raw=true");
            BufferedImage imagenLogoBlanco = ImageIO.read(LogoBlanco);
            BufferedImage bufferedImageLogoBlanco = Scalr.resize(imagenLogoBlanco, 100);
            ImageIcon iconoLogoBlanco = new ImageIcon(bufferedImageLogoBlanco);
            logoBlanco.setIcon(iconoLogoBlanco);

            // Imagen tienda1
            URL Tienda1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/camiseta1.png?raw=true");
            BufferedImage imagenOriginal11 = ImageIO.read(Tienda1);
            BufferedImage bufferedImage11 = Scalr.resize(imagenOriginal11, 400);
            ImageIcon iconoEscalado11 = new ImageIcon(bufferedImage11);
            tienda1.setIcon(iconoEscalado11);

            // Imagen Tienda2
            URL Tienda2 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/mochilas.png?raw=true");
            BufferedImage imagenOriginal24 = ImageIO.read(Tienda2);
            BufferedImage bufferedImage24 = Scalr.resize(imagenOriginal24, 400);
            ImageIcon iconoEscalado24 = new ImageIcon(bufferedImage24);
            tienda2.setIcon(iconoEscalado24);

            // Imagen Tienda3
            URL Tienda3 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos" +
                    "/blob/main/Tienda/botellas.png?raw=true");
            BufferedImage imagenOriginal25 = ImageIO.read(Tienda3);
            BufferedImage bufferedImage25 = Scalr.resize(imagenOriginal25, 400);
            ImageIcon iconoEscalado25 = new ImageIcon(bufferedImage25);
            tienda3.setIcon(iconoEscalado25);

            // Imagen Tienda4
            URL Tienda4 = new URL("https://github.com/IbaiSaenzDeBuruaga/" +
                    "E-SportsLogos/blob/main/Tienda/zapatilla1.png?raw=true");
            BufferedImage imagenOriginal26 = ImageIO.read(Tienda4);
            BufferedImage bufferedImage26 = Scalr.resize(imagenOriginal26, 400);
            ImageIcon iconoEscalado26 = new ImageIcon(bufferedImage26);
            tienda4.setIcon(iconoEscalado26);

            // Imagen Tienda5
            URL Tienda5 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/boxers.png?raw=true");
            BufferedImage imagenOriginal27 = ImageIO.read(Tienda5);
            BufferedImage bufferedImage27 = Scalr.resize(imagenOriginal27, 400);
            ImageIcon iconoEscalado27 = new ImageIcon(bufferedImage27);
            tienda5.setIcon(iconoEscalado27);

            // Imagen Tienda6
            URL Tienda6 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/raton.png?raw=true");
            BufferedImage imagenOriginal28 = ImageIO.read(Tienda6);
            BufferedImage bufferedImage28 = Scalr.resize(imagenOriginal28, 400);
            ImageIcon iconoEscalado28 = new ImageIcon(bufferedImage28);
            tienda6.setIcon(iconoEscalado28);

            // Imagen Tienda7
            URL Tienda7 = new URL("https://github.com/IbaiSaenzDeBuruaga/" +
                    "E-SportsLogos/blob/main/Tienda/bikini.png?raw=true");
            BufferedImage imagenOriginal29 = ImageIO.read(Tienda7);
            BufferedImage bufferedImage29 = Scalr.resize(imagenOriginal29, 400);
            ImageIcon iconoEscalado29 = new ImageIcon(bufferedImage29);
            tienda7.setIcon(iconoEscalado29);

            // Imagen Tienda8
            URL Tienda8 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/calcetines.png?raw=true");
            BufferedImage imagenOriginal30 = ImageIO.read(Tienda8);
            BufferedImage bufferedImage30 = Scalr.resize(imagenOriginal30, 400);
            ImageIcon iconoEscalado30 = new ImageIcon(bufferedImage30);
            tienda8.setIcon(iconoEscalado30);

            // Imagen Tienda9
            URL Tienda9 = new URL("https://github.com/IbaiSaenzDeBuruaga/" +
                    "E-SportsLogos/blob/main/Tienda/chaqueta.png?raw=true");
            BufferedImage imagenOriginal31 = ImageIO.read(Tienda9);
            BufferedImage bufferedImage31 = Scalr.resize(imagenOriginal31, 400);
            ImageIcon iconoEscalado31 = new ImageIcon(bufferedImage31);
            tienda9.setIcon(iconoEscalado31);

            // Imagen Tienda10
            URL Tienda10 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/gorra.png?raw=true");
            BufferedImage imagenOriginal32 = ImageIO.read(Tienda10);
            BufferedImage bufferedImage32 = Scalr.resize(imagenOriginal32, 400);
            ImageIcon iconoEscalado32 = new ImageIcon(bufferedImage32);
            tienda10.setIcon(iconoEscalado32);

            // Imagen Tienda11
            URL Tienda11 = new URL("https://github.com/IbaiSaenzDeBuruaga/" +
                    "E-SportsLogos/blob/main/Tienda/guantes.png?raw=true");
            BufferedImage imagenOriginal33 = ImageIO.read(Tienda11);
            BufferedImage bufferedImage33 = Scalr.resize(imagenOriginal33, 400);
            ImageIcon iconoEscalado33 = new ImageIcon(bufferedImage33);
            tienda11.setIcon(iconoEscalado33);

            // Imagen Tienda12
            URL Tienda12 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/pantalon.png?raw=true");
            BufferedImage imagenOriginal34 = ImageIO.read(Tienda12);
            BufferedImage bufferedImage34 = Scalr.resize(imagenOriginal34, 400);
            ImageIcon iconoEscalado34 = new ImageIcon(bufferedImage34);
            tienda12.setIcon(iconoEscalado34);

            // Imagen botonBuy (todos los botones buy)
            URL buy1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal12 = ImageIO.read(buy1);
            BufferedImage bufferedImage12 = Scalr.resize(imagenOriginal12, 50);
            ImageIcon iconoEscalado12 = new ImageIcon(bufferedImage12);
            bBuy1.setIcon(iconoEscalado12);
            bBuy2.setIcon(iconoEscalado12);
            bBuy3.setIcon(iconoEscalado12);
            bBuy4.setIcon(iconoEscalado12);
            bBuy5.setIcon(iconoEscalado12);
            bBuy6.setIcon(iconoEscalado12);
            bBuy7.setIcon(iconoEscalado12);
            bBuy8.setIcon(iconoEscalado12);
            bBuy9.setIcon(iconoEscalado12);
            bBuy10.setIcon(iconoEscalado12);
            bBuy11.setIcon(iconoEscalado12);
            bBuy12.setIcon(iconoEscalado12);

        } catch (IOException e) {
            e.printStackTrace();
        }

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

