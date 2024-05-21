package Vista;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class VentanaInicioSesion extends JFrame {

    private JPanel pPrincipal;
    private JTextField tfUsuario;
    private JPasswordField ftfContrasena;
    private JButton bIniciarSesion; // TODO : poner bordes redondos
    private JButton bRegistrarse; // TODO : poner bordes redondos
    private JPanel pDatos;
    private JLabel tfImagenLogo;

    public VentanaInicioSesion(JFrame ventanaEliminar){

        setTitle("Ventana Inicio Sesión");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // PONER UN PANEL DEGRADADO DE FONDO.

        // Inicializar el panel del degradado y establecer los colores.
        pPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Colores para el degradado
                Color colorInicio = new Color(0x201641);
                Color colorFin = new Color(0xAE72C2);

                // Crear y configurar el objeto GradientPaint
                //GradientPaint gradientPaint = new GradientPaint(start, colorInicio, end, colorFin);
                GradientPaint gradientPaint = new GradientPaint(0,0,colorInicio,0,getHeight(),colorFin);

                // Aplicar el degradado al panel
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, getWidth(), getHeight());

            }
        };

        // Configurar el layout del panel principal como GridBagLayout para centrar el pDatos
        pPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Añadir tfImagenLogo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pPrincipal.add(tfImagenLogo, gbc);

        // Añadir pDatos
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 80, 0);
        pPrincipal.add(pDatos, gbc);

        // Poner la imagen centrada y superpuesta. // TODO : tengo que ponerla bien
        try {

            // Cargar la imagen original
            URL imageUrl = new URL("https://github.com/IbaiSaenzDeBuruaga" +
                    "/E-SportsLogos/blob/main/RRSS/TheMadZaLogoColor.png?raw=true");
            BufferedImage imagenOriginal = ImageIO.read(imageUrl);

            // Escalar la imagen usando ImgScalr
            BufferedImage bufferedImage = Scalr.resize(imagenOriginal, 200);

            // Crear un ImageIcon a partir del BufferedImage escalado
            ImageIcon iconoEscalado = new ImageIcon(bufferedImage);

            // Asignar el ImageIcon escalado al JLabel ftThemadza
            tfImagenLogo.setIcon(iconoEscalado);

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        setContentPane(pPrincipal);
        getRootPane().setDefaultButton(bIniciarSesion);
        setVisible(true);

        // Destruir la ventana inicial.
        ventanaEliminar.dispose();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicioSesion ventana = new VentanaInicioSesion(null);
        });
    }

    // Funciones
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    // Getters y setters
    public String getTfUsuario() {
        return tfUsuario.getText();
    }
    public void setTfUsuario(String usuario) {
        this.tfUsuario.setText(usuario);
    }
    public String getTfContrasena() {
        return ftfContrasena.getText();
    }
    public void setTfContrasena(String contrasena) {
        this.ftfContrasena.setText(contrasena);
    }

    // Listeners
    public void addBIniciarSesionAL(ActionListener al) {
        bIniciarSesion.addActionListener(al);
    }
    public void addBRegistroAL(ActionListener al) {
        bRegistrarse.addActionListener(al);
    }

}