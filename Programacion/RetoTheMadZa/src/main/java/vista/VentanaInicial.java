package Vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.imgscalr.Scalr;


public class VentanaInicial extends JFrame {
    private JPanel pPrincipal;
    private JButton button1;
    private JPanel Equipo1;
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
    private JMenu mJornadas;
    private JMenu mClasificacion;
    private JMenu mEquipos;
    private JLabel ftThemadza;

    public VentanaInicial() {
        super("Ventana principal");
        setContentPane(pPrincipal);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        try {
            // Cargar la imagen original
            URL imageUrl = new URL("https://raw.githubusercontent.com/TheMadZa/E-Sports/main/Programacion" +
                    "/RetoTheMadZa/src/main/java/vista/Imagenes/TheMadZaLogoSimple.png");
            BufferedImage imagenOriginal = ImageIO.read(imageUrl);

            // Escalar la imagen a un tamaño de 150x150 usando ImgScalr
            BufferedImage bufferedImage = Scalr.resize(imagenOriginal, 250);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado = new ImageIcon(bufferedImage);

            // Asignar el ImageIcon escalado al JLabel ftThemadza
            ftThemadza.setIcon(iconoEscalado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicial ventana = new VentanaInicial();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);
        });
    }
}
