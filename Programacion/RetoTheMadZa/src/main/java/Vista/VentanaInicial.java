package Vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import org.imgscalr.Scalr;


public class VentanaInicial extends JFrame {
    private JPanel pPrincipal;
    private JPanel PanelMedio;
    private JLabel equipo2;
    private JLabel equipo3;
    private JLabel equipo4;
    private JLabel equipo5;
    private JLabel vEquipo1;
    private JLabel vEquipo2;
    private JLabel equipo1;
    private JLabel vEquipo3;
    private JLabel vEquipo4;
    private JLabel vEquipo5;
    private JLabel pEquipo1;
    private JLabel pEquipo2;
    private JLabel pEquipo3;
    private JLabel pEquipo4;
    private JLabel pEquipo5;
    private JLabel ftThemadza;
    private JPanel panelUp;
    private JPanel panelFoot;
    private JPanel panelJornadas;
    private JLabel ftNoticias;
    private JMenu mJornadas;
    private JMenu mClasificacion;
    private JMenu mequipos;
    private JPanel PanelMenu;
    private JPanel PanelLogo;
    private JButton bInicio;
    private JButton bSalir;
    private JComboBox cbClasifiacion;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JMenuBar mPrincipal;

    public VentanaInicial() {

        try {
            // Cargar la imagen original
            URL imageUrl = new URL("https://github.com/TheMadZa/E-Sports/blob/main/Programacion/RetoTheMadZa/src/main/java/Vista/Imagenes/TheMadZaLogoSimple.png?raw=true");
            BufferedImage imagenOriginal = ImageIO.read(imageUrl);

            // Escalar la imagen a un tamaño de 150x150 usando ImgScalr
            BufferedImage bufferedImage = Scalr.resize(imagenOriginal, 250);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado = new ImageIcon(bufferedImage);

            // Asignar el ImageIcon escalado al JLabel ftThemadza
            ftThemadza.setIcon(iconoEscalado);

            // Cargar la imagen Noticias
            URL Noticia1 = new URL("https://raw.githubusercontent.com/IbaiSaenzDeBuruaga/E-SportsLogos/1b853f57103aeb0b09c40566e475ec6503098592/OIG1.jpg");
            BufferedImage imagenOriginal3 = ImageIO.read(Noticia1);

            // Escalar la imagen
            BufferedImage bufferedImage3 = Scalr.resize(imagenOriginal3, 500);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado3 = new ImageIcon(bufferedImage3);

            // Asignar el ImageIcon escalado al JLabel
            ftNoticias.setIcon(iconoEscalado3);

            // Cargar la imagen Boton Inicio
            URL Inicio1 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/inicio.png?raw=true");
            BufferedImage imagenOriginal4 = ImageIO.read(Inicio1);

            // Escalar la imagen
            BufferedImage bufferedImage4 = Scalr.resize(imagenOriginal4, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado4 = new ImageIcon(bufferedImage4);

            // Asignar el ImageIcon escalado al JLabel
            bInicio.setIcon(iconoEscalado4);

            // Cargar la imagen Boton Salir
            URL Salir1 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/powerOff.png?raw=true");
            BufferedImage imagenOriginal5 = ImageIO.read(Salir1);

            // Escalar la imagen
            BufferedImage bufferedImage5 = Scalr.resize(imagenOriginal5, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado5 = new ImageIcon(bufferedImage5);

            // Asignar el ImageIcon escalado al JLabel
            bSalir.setIcon(iconoEscalado5);


            // Cargar la imagen equipo1
            URL Equipo1 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/faze-clan-logo.png?raw=true");
            BufferedImage imagenOriginal1 = ImageIO.read(Equipo1);

            // Escalar la imagen
            BufferedImage bufferedImage1 = Scalr.resize(imagenOriginal1, 55);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado1 = new ImageIcon(bufferedImage1);

            // Asignar el ImageIcon escalado al JLabel
            equipo1.setIcon(iconoEscalado1);


            // Cargar la imagen equipo1
            URL Equipo2 = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/fnatic-logo.png?raw=true");
            BufferedImage imagenOriginal2 = ImageIO.read(Equipo2);

            // Escalar la imagen
            BufferedImage bufferedImage2 = Scalr.resize(imagenOriginal2, 55);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado2 = new ImageIcon(bufferedImage2);

            // Asignar el ImageIcon escalado al JLabel
            equipo2.setIcon(iconoEscalado2);


            // Cargar la imagen Boton Twitter
            URL Twitter = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/TwitterLogo.png?raw=true");
            BufferedImage imagenOriginal6 = ImageIO.read(Twitter);

            // Escalar la imagen
            BufferedImage bufferedImage6 = Scalr.resize(imagenOriginal6, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado6 = new ImageIcon(bufferedImage6);

            // Asignar el ImageIcon escalado al JLabel
            bTwitter.setIcon(iconoEscalado6);


            // Cargar la imagen Boton Instagram
            URL Insta = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/InstagramLogo.png?raw=true");
            BufferedImage imagenOriginal7 = ImageIO.read(Insta);

            // Escalar la imagen
            BufferedImage bufferedImage7 = Scalr.resize(imagenOriginal7, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado7 = new ImageIcon(bufferedImage7);

            // Asignar el ImageIcon escalado al JLabel
            bInstagram.setIcon(iconoEscalado7);


            // Cargar la imagen Boton Facebook
            URL Facebook = new URL("https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/FacebookLogo.png?raw=true");
            BufferedImage imagenOriginal8 = ImageIO.read(Facebook);

            // Escalar la imagen
            BufferedImage bufferedImage8 = Scalr.resize(imagenOriginal8, 40);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado8 = new ImageIcon(bufferedImage8);

            // Asignar el ImageIcon escalado al JLabel
            bFacebook.setIcon(iconoEscalado8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Inicial");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bFacebook.setBorder(BorderFactory.createEmptyBorder());
        bTwitter.setBorder(BorderFactory.createEmptyBorder());
        bInstagram.setBorder(BorderFactory.createEmptyBorder());
        bSalir.setBorder(BorderFactory.createEmptyBorder());
        bInicio.setBorder(BorderFactory.createEmptyBorder());
        mPrincipal.setBorder(BorderFactory.createEmptyBorder());
        cbClasifiacion.setBorder(BorderFactory.createEmptyBorder());


        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicial ventana = new VentanaInicial();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);
        });
    }
}