package Vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import Modelo.Competicion;
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
    private JComboBox<String> cbClasificacion;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JMenuBar mPrincipal;
    private JPanel panelNoticias;
    private JMenu mTienda;
    private JMenuBar menuSoloTienda;
    private JLabel labelTextoHorizontal;
    private JButton bTienda;
    private int indiceImagenes = 0;
    private final String[] urls = {
            "https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Noticias/0b9235b8-f812-4629-8c04-e9a5d874134b.png?raw=true",
            "https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Noticias/84752ff3-2cd1-465d-832a-c661bb701549.png?raw=true",
            "https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Noticias/ba6db8a3-4203-42a0-a5f2-4075bd89e161.png?raw=true",
            "https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Noticias/ed187317-1ef3-49a0-86b1-d5387a83ccca.png?raw=true",
            "https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/Noticias/mano.png?raw=true"
    };

    private String text = " Za esta completamente loco                de verdad esta muy loco                     y encima es peruano" +
            "                   imaginate ser peruano                             pues za lo es. ";
    private int currentIndex = 0;



    public VentanaInicial() {
        mostrarImagenesFugaces();

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

            // Cargar la imagen equipo1
            URL Equipo1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/faze-clan-logo.png?raw=true");
            BufferedImage imagenOriginal1 = ImageIO.read(Equipo1);

            // Escalar la imagen
            BufferedImage bufferedImage1 = Scalr.resize(imagenOriginal1, 55);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado1 = new ImageIcon(bufferedImage1);

            // Asignar el ImageIcon escalado al JLabel
            equipo1.setIcon(iconoEscalado1);

            // Cargar la imagen equipo2
            URL Equipo2 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/fnatic-logo.png?raw=true");
            BufferedImage imagenOriginal2 = ImageIO.read(Equipo2);

            // Escalar la imagen
            BufferedImage bufferedImage2 = Scalr.resize(imagenOriginal2, 55);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado2 = new ImageIcon(bufferedImage2);

            // Asignar el ImageIcon escalado al JLabel
            equipo2.setIcon(iconoEscalado2);

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
        mPrincipal.setBorder(BorderFactory.createEmptyBorder());
        cbClasificacion.setBorder(BorderFactory.createEmptyBorder());

        // Iniciar el desplazamiento del texto
        iniciarDesplazamientoTexto();

        setVisible(true);
    }

    private void iniciarDesplazamientoTexto() {
        Timer timer = new Timer(200, new ActionListener() {
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
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar la imagen y actualizar el índice
                indiceImagenes = (indiceImagenes + 1) % urls.length;
                // Obtener la URL de la imagen actual del array
                String url = urls[indiceImagenes];
                try {
                    // Cargar la imagen desde la URL
                    URL imageUrl = new URL(url);
                    BufferedImage imagen = ImageIO.read(imageUrl);
                    // Escalar la imagen a un tamaño adecuado (opcional)
                    imagen = Scalr.resize(imagen, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, 600, 600);
                    // Crear un ImageIcon a partir del BufferedImage
                    ImageIcon icon = new ImageIcon(imagen);
                    // Establecer la imagen en el JLabel
                    ftNoticias.setIcon(icon);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        // Comenzar el temporizador
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicial ventana = new VentanaInicial();
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