package Vista;

import Modelo.Competicion;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

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
    private JComboBox cbClasificacion;
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

    private String text = " TheMadZa, compañía líder en eSports, organiza dos competiciones activas: el Torneo de" +
            " TheMadZa Legends, con premios millonarios para equipos globales, y TheMadZa Clash, enfocado en nuevos" +
            " talentos. Recientemente, lanzaron su tienda online con productos exclusivos y personalizados. Los" +
            " jugadores pueden registrarse fácilmente para participar en competiciones y acceder a contenido" +
            " exclusivo, sorteos y descuentos especiales. Además, TheMadZa organiza eventos anuales como" +
            " TheMadZa GameCon para mantener a la comunidad activa y comprometida. ";
    private int currentIndex = 0;



    public VentanaTienda() {


        try {
            // Cargar la imagen original
            URL imageUrl = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/TheMadZaLogoSimple.png?raw=true");
            BufferedImage imagenOriginal = ImageIO.read(imageUrl);

            // Escalar la imagen a un tamaño de 150x150 usando ImgScalr
            BufferedImage bufferedImage = Scalr.resize(imagenOriginal, 250);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado = new ImageIcon(bufferedImage);

            // Asignar el ImageIcon escalado al JLabel ftThemadza
            ftThemadza.setIcon(iconoEscalado);

            // Cargar la imagen Boton Inicio
            URL Inicio1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/inicio.png?raw=true");
            BufferedImage imagenOriginal4 = ImageIO.read(Inicio1);

            // Escalar la imagen
            BufferedImage bufferedImage4 = Scalr.resize(imagenOriginal4, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado4 = new ImageIcon(bufferedImage4);

            // Asignar el ImageIcon escalado al JLabel
            bInicio.setIcon(iconoEscalado4);

            // Cargar la imagen Boton Salir
            URL Salir1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/powerOff.png?raw=true");
            BufferedImage imagenOriginal5 = ImageIO.read(Salir1);

            // Escalar la imagen
            BufferedImage bufferedImage5 = Scalr.resize(imagenOriginal5, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado5 = new ImageIcon(bufferedImage5);

            // Asignar el ImageIcon escalado al JLabel
            bSalir.setIcon(iconoEscalado5);


            // Cargar la imagen Boton Twitter
            URL Twitter = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/TwitterLogo.png?raw=true");
            BufferedImage imagenOriginal6 = ImageIO.read(Twitter);

            // Escalar la imagen
            BufferedImage bufferedImage6 = Scalr.resize(imagenOriginal6, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado6 = new ImageIcon(bufferedImage6);

            // Asignar el ImageIcon escalado al JLabel
            bTwitter.setIcon(iconoEscalado6);

            // Cargar la imagen Boton Instagram
            URL Insta = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/InstagramLogo.png?raw=true");
            BufferedImage imagenOriginal7 = ImageIO.read(Insta);

            // Escalar la imagen
            BufferedImage bufferedImage7 = Scalr.resize(imagenOriginal7, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado7 = new ImageIcon(bufferedImage7);

            // Asignar el ImageIcon escalado al JLabel
            bInstagram.setIcon(iconoEscalado7);

            // Cargar la imagen Boton Facebook
            URL Facebook = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/FacebookLogo.png?raw=true");
            BufferedImage imagenOriginal8 = ImageIO.read(Facebook);

            // Escalar la imagen
            BufferedImage bufferedImage8 = Scalr.resize(imagenOriginal8, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado8 = new ImageIcon(bufferedImage8);

            // Asignar el ImageIcon escalado al JLabel
            bFacebook.setIcon(iconoEscalado8);

            // Cargar la imagen Boton Tienda
            URL Tienda = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/tienda.png?raw=true");
            BufferedImage imagenOriginal9 = ImageIO.read(Tienda);

            // Escalar la imagen
            BufferedImage bufferedImage9 = Scalr.resize(imagenOriginal9, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado9 = new ImageIcon(bufferedImage9);

            // Asignar el ImageIcon escalado al JLabel
            bTienda.setIcon(iconoEscalado9);

            // Cargar la imagen LogoBlanco
            URL LogoBlanco = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/SoloBlanco.png?raw=true");
            BufferedImage imagenOriginal10 = ImageIO.read(LogoBlanco);

            // Escalar la imagen
            BufferedImage bufferedImage10 = Scalr.resize(imagenOriginal10, 100);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado10 = new ImageIcon(bufferedImage10);

            // Asignar el ImageIcon escalado al JLabel
            logoBlanco.setIcon(iconoEscalado10);

            // Cargar la imagen tienda1
            URL Tienda1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/camiseta1.png?raw=true");
            BufferedImage imagenOriginal11 = ImageIO.read(Tienda1);

            // Escalar la imagen
            BufferedImage bufferedImage11 = Scalr.resize(imagenOriginal11, 400);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado11 = new ImageIcon(bufferedImage11);

            // Asignar el ImageIcon escalado al JLabel
            tienda1.setIcon(iconoEscalado11);


            // Cargar la imagen botonBuy1
            URL buy1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal12 = ImageIO.read(buy1);

            // Escalar la imagen
            BufferedImage bufferedImage12 = Scalr.resize(imagenOriginal12, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado12 = new ImageIcon(bufferedImage12);

            // Asignar el ImageIcon escalado al JLabel
            bBuy1.setIcon(iconoEscalado12);

            // Cargar la imagen botonBuy2
            URL buy2 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal13 = ImageIO.read(buy2);

            // Escalar la imagen
            BufferedImage bufferedImage13 = Scalr.resize(imagenOriginal13, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado13 = new ImageIcon(bufferedImage13);

            // Asignar el ImageIcon escalado al JLabel

            bBuy2.setIcon(iconoEscalado13);

            // Cargar la imagen botonBuy3
            URL buy3 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal14 = ImageIO.read(buy3);

            // Escalar la imagen
            BufferedImage bufferedImage14 = Scalr.resize(imagenOriginal14, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado14 = new ImageIcon(bufferedImage14);

            // Asignar el ImageIcon escalado al JLabel

            bBuy3.setIcon(iconoEscalado14);

            // Cargar la imagen botonBuy4
            URL buy4 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal15 = ImageIO.read(buy4);

            // Escalar la imagen
            BufferedImage bufferedImage15 = Scalr.resize(imagenOriginal15, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado15 = new ImageIcon(bufferedImage15);

            // Asignar el ImageIcon escalado al JLabel

            bBuy4.setIcon(iconoEscalado15);

            // Cargar la imagen botonBuy5
            URL buy5 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal16 = ImageIO.read(buy5);

            // Escalar la imagen
            BufferedImage bufferedImage16 = Scalr.resize(imagenOriginal16, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado16 = new ImageIcon(bufferedImage16);

            // Asignar el ImageIcon escalado al JLabel

            bBuy5.setIcon(iconoEscalado16);

            // Cargar la imagen botonBuy6
            URL buy6 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal17 = ImageIO.read(buy6);

            // Escalar la imagen
            BufferedImage bufferedImage17 = Scalr.resize(imagenOriginal17, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado17 = new ImageIcon(bufferedImage17);

            // Asignar el ImageIcon escalado al JLabel

            bBuy6.setIcon(iconoEscalado17);

            // Cargar la imagen botonBuy7
            URL buy7 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal18 = ImageIO.read(buy7);

            // Escalar la imagen
            BufferedImage bufferedImage18 = Scalr.resize(imagenOriginal18, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado18 = new ImageIcon(bufferedImage18);

            // Asignar el ImageIcon escalado al JLabel

            bBuy7.setIcon(iconoEscalado18);

            // Cargar la imagen botonBuy8
            URL buy8 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal19 = ImageIO.read(buy8);

            // Escalar la imagen
            BufferedImage bufferedImage19 = Scalr.resize(imagenOriginal19, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado19 = new ImageIcon(bufferedImage19);

            // Asignar el ImageIcon escalado al JLabel

            bBuy8.setIcon(iconoEscalado19);

            // Cargar la imagen botonBuy9
            URL buy9 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal20 = ImageIO.read(buy9);

            // Escalar la imagen
            BufferedImage bufferedImage20 = Scalr.resize(imagenOriginal20, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado20 = new ImageIcon(bufferedImage20);

            // Asignar el ImageIcon escalado al JLabel

            bBuy9.setIcon(iconoEscalado20);

            // Cargar la imagen botonBuy10
            URL buy10 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal21 = ImageIO.read(buy10);

            // Escalar la imagen
            BufferedImage bufferedImage21 = Scalr.resize(imagenOriginal21, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado21 = new ImageIcon(bufferedImage21);

            // Asignar el ImageIcon escalado al JLabel

            bBuy10.setIcon(iconoEscalado21);

            // Cargar la imagen botonBuy11
            URL buy11 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal22 = ImageIO.read(buy11);

            // Escalar la imagen
            BufferedImage bufferedImage22 = Scalr.resize(imagenOriginal22, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado22 = new ImageIcon(bufferedImage22);

            // Asignar el ImageIcon escalado al JLabel

            bBuy11.setIcon(iconoEscalado22);

            // Cargar la imagen botonBuy12
            URL buy12 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal23 = ImageIO.read(buy12);

            // Escalar la imagen
            BufferedImage bufferedImage23 = Scalr.resize(imagenOriginal23, 50);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado23 = new ImageIcon(bufferedImage23);

            // Asignar el ImageIcon escalado al JLabel

            bBuy12.setIcon(iconoEscalado23);

            // Cargar la imagen Tienda2
            URL Tienda2 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Tienda/mochilas.png?raw=true");
            BufferedImage imagenOriginal24 = ImageIO.read(Tienda2);

            // Escalar la imagen
            BufferedImage bufferedImage24 = Scalr.resize(imagenOriginal24, 400);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado24 = new ImageIcon(bufferedImage24);

            // Asignar el ImageIcon escalado al JLabel

            tienda2.setIcon(iconoEscalado24);

            // Tienda3
            URL Tienda3 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos" +
                    "/blob/main/Tienda/botellas.png?raw=true");
            BufferedImage imagenOriginal25 = ImageIO.read(Tienda3);
            BufferedImage bufferedImage25 = Scalr.resize(imagenOriginal25, 400);
            ImageIcon iconoEscalado25 = new ImageIcon(bufferedImage25);

            tienda3.setIcon(iconoEscalado25);


            // Tienda4
            URL Tienda4 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal26 = ImageIO.read(Tienda4);
            BufferedImage bufferedImage26 = Scalr.resize(imagenOriginal26, 400);
            ImageIcon iconoEscalado26 = new ImageIcon(bufferedImage26);

            tienda4.setIcon(iconoEscalado26);


            // Tienda5
            URL Tienda5 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal27 = ImageIO.read(Tienda5);
            BufferedImage bufferedImage27 = Scalr.resize(imagenOriginal27, 400);
            ImageIcon iconoEscalado27 = new ImageIcon(bufferedImage27);

            tienda5.setIcon(iconoEscalado27);


            // Tienda6
            URL Tienda6 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal28 = ImageIO.read(Tienda6);
            BufferedImage bufferedImage28 = Scalr.resize(imagenOriginal28, 400);
            ImageIcon iconoEscalado28 = new ImageIcon(bufferedImage28);

            tienda6.setIcon(iconoEscalado28);


            // Tienda7
            URL Tienda7 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal29 = ImageIO.read(Tienda7);
            BufferedImage bufferedImage29 = Scalr.resize(imagenOriginal29, 400);
            ImageIcon iconoEscalado29 = new ImageIcon(bufferedImage29);

            tienda7.setIcon(iconoEscalado29);


            // Tienda8
            URL Tienda8 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal30 = ImageIO.read(Tienda8);
            BufferedImage bufferedImage30 = Scalr.resize(imagenOriginal30, 400);
            ImageIcon iconoEscalado30 = new ImageIcon(bufferedImage30);

            tienda8.setIcon(iconoEscalado30);


            // Tienda9
            URL Tienda9 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal31 = ImageIO.read(Tienda9);
            BufferedImage bufferedImage31 = Scalr.resize(imagenOriginal31, 400);
            ImageIcon iconoEscalado31 = new ImageIcon(bufferedImage31);

            tienda9.setIcon(iconoEscalado31);


            // Tienda10
            URL Tienda10 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal32 = ImageIO.read(Tienda10);
            BufferedImage bufferedImage32 = Scalr.resize(imagenOriginal32, 400);
            ImageIcon iconoEscalado32 = new ImageIcon(bufferedImage32);

            tienda10.setIcon(iconoEscalado32);


            // Tienda11
            URL Tienda11 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal33 = ImageIO.read(Tienda11);
            BufferedImage bufferedImage33 = Scalr.resize(imagenOriginal33, 400);
            ImageIcon iconoEscalado33 = new ImageIcon(bufferedImage33);

            tienda11.setIcon(iconoEscalado33);


            // Tienda12
            URL Tienda12 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");
            BufferedImage imagenOriginal34 = ImageIO.read(Tienda12);
            BufferedImage bufferedImage34 = Scalr.resize(imagenOriginal34, 400);
            ImageIcon iconoEscalado34 = new ImageIcon(bufferedImage34);

            tienda12.setIcon(iconoEscalado34);






        } catch (IOException e) {
            e.printStackTrace();
        }

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Inicial");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(bInicio);
        bTienda.setBorder(BorderFactory.createEmptyBorder());
        bFacebook.setBorder(BorderFactory.createEmptyBorder());
        bTwitter.setBorder(BorderFactory.createEmptyBorder());
        bInstagram.setBorder(BorderFactory.createEmptyBorder());
        bSalir.setBorder(BorderFactory.createEmptyBorder());
        bInicio.setBorder(BorderFactory.createEmptyBorder());
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

        mPrincipal.setBorder(BorderFactory.createEmptyBorder());

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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaTienda ventana = new VentanaTienda();
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

