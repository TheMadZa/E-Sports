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

/**
 * Ventana de inicio de sesion.
 * @author Lorena
 */
public class VentanaInicioSesion extends JFrame {

    private JPanel pPrincipal;
    private JTextField tfUsuario;
    private JPasswordField ftfContrasena;
    private JButton bIniciarSesion;
    private JButton bRegistrarse;
    private JPanel pDatos;
    private JLabel tfImagenLogo;

    public VentanaInicioSesion(JFrame ventanaEliminar){

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

        // Poner la imagen centrada y superpuesta. // TODO : hay que ponerla bien


            cargarImagenEstablecerIcono("TheMadZaLogoColor", 200, 200, tfImagenLogo);



        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Inicio Sesión");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
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

    private void cargarImagenEstablecerIcono(String nombreImagen, int ancho, int alto, JLabel label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }
    private void cargarImagenEstablecerIcono(String nombreImagen, JButton button) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, 40, 40);
        if (icono != null) {
            button.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

}