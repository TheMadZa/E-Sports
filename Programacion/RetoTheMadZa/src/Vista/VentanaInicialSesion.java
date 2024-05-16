package Vista;

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

    private String text = " TheMadZa, compañía líder en eSports, organiza dos competiciones activas: el Torneo de" +
            " TheMadZa Legends, con premios millonarios para equipos globales, y TheMadZa Clash, enfocado en nuevos" +
            " talentos. Recientemente, lanzaron su tienda online con productos exclusivos y personalizados. Los" +
            " jugadores pueden registrarse fácilmente para participar en competiciones y acceder a contenido" +
            " exclusivo, sorteos y descuentos especiales. Además, TheMadZa organiza eventos anuales como" +
            " TheMadZa GameCon para mantener a la comunidad activa y comprometida. ";
    private int currentIndex = 0;



    public VentanaInicialSesion() {
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
