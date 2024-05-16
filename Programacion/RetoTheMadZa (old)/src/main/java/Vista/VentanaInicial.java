package Vista;

import javax.imageio.ImageIO;
import javax.swing.*;
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
    private JLabel logoBlanco;
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
    private final String text = " TheMadZa, compañía líder en eSports, organiza dos competiciones activas: el Torneo de" +
            " TheMadZa Legends, con premios millonarios para equipos globales, y TheMadZa Clash, enfocado en nuevos" +
            " talentos. Recientemente, lanzaron su tienda online con productos exclusivos y personalizados. Los" +
            " jugadores pueden registrarse fácilmente para participar en competiciones y acceder a contenido" +
            " exclusivo, sorteos y descuentos especiales. Además, TheMadZa organiza eventos anuales como" +
            " TheMadZa GameCon para mantener a la comunidad activa y comprometida. ";
    private int currentIndex = 0;

    public VentanaInicial() {
        mostrarImagenesFugaces();

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

            // Imagen equipo1
            // TODO : HABRÍA QUE CARGAR LOS DATOS (LA IMAGEN DEL EQUIPO DESDE LA BD)
            URL Equipo1 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/faze-clan-logo.png?raw=true");
            BufferedImage imagenEquipo1 = ImageIO.read(Equipo1);
            BufferedImage bufferedImageEquipo1 = Scalr.resize(imagenEquipo1, 55);
            ImageIcon iconoEquipo1 = new ImageIcon(bufferedImageEquipo1);
            equipo1.setIcon(iconoEquipo1);

            // Imagen equipo2
            URL Equipo2 = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/fnatic-logo.png?raw=true");
            BufferedImage imagenEquipo2 = ImageIO.read(Equipo2);
            BufferedImage bufferedImageEquipo2 = Scalr.resize(imagenEquipo2, 55);
            ImageIcon iconoEquipo2 = new ImageIcon(bufferedImageEquipo2);
            equipo2.setIcon(iconoEquipo2);

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

        } catch (IOException e) {
            e.printStackTrace();
        }

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
        cbClasificacion.setBorder(BorderFactory.createEmptyBorder());
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

    // Función para mostrar las imágenes transitorias.
    public void mostrarImagenesFugaces() {
        // Crear un temporizador que cambie la imagen después de unos 4 segundos.
        Timer timer = new Timer(3000, e -> {
            // Cambiar la imagen y actualizar el índice
            indiceImagenes = (indiceImagenes + 1) % urls.length;
            // Obtener la URL de la imagen actual del array
            String url = urls[indiceImagenes];
            try {
                // Cargar la imagen desde la URL
                URL imageUrl = new URL(url);
                BufferedImage imagen = ImageIO.read(imageUrl);
                // Escalar la imagen a un tamaño adecuado
                imagen = Scalr.resize(imagen, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, 600, 600);
                ImageIcon icon = new ImageIcon(imagen);
                ftNoticias.setIcon(icon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        // Comenzar el temporizador
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicial ventana = new VentanaInicial();
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
    public void addCbClasificacionAL(ActionListener al) {
        cbClasificacion.addActionListener(al);
    }
}