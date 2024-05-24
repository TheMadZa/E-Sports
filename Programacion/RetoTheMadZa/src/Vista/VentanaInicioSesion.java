package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Ventana de inicio de sesión.
 * Esta ventana proporciona una interfaz para que los usuarios inicien sesión en el sistema.
 * También permite la visualización de la imagen de logo de la aplicación.
 * La ventana incluye campos para el nombre de usuario, contraseña y botones para iniciar sesión y registrarse.
 *
 * @author Lorena, Ibai
 * @version 1.0
 */
public class VentanaInicioSesion extends JFrame {

    private JPanel pPrincipal;
    private JTextField tfUsuario;
    private JPasswordField ftfContrasena;
    private JButton bIniciarSesion;
    private JButton bRegistrarse;
    private JPanel pDatos;
    private JLabel tfImagenLogo;

    /**
     * Constructor de la clase VentanaInicioSesion.
     * Crea una nueva instancia de la ventana de inicio de sesión y la muestra en la pantalla.
     *
     * @param ventanaEliminar La ventana que se eliminará después de que se muestre esta ventana de inicio de sesión.
     */
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
                Color colorFin = new Color(0xC892DC);

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

        cargarImagenEstablecerIcono(tfImagenLogo);

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

    /**
     * Método principal para iniciar la aplicación.
     * Este método crea una instancia de la clase VentanaInicioSesion y la muestra en el hilo de eventos de Swing.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este método).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicioSesion ventana = new VentanaInicioSesion(null);
        });
    }

    // Funciones

    /**
     * Muestra un mensaje emergente en la pantalla.
     * Este método muestra un cuadro de diálogo emergente con el mensaje proporcionado.
     *
     * @param mensaje El mensaje que se mostrará en el cuadro de diálogo.
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    // Getters y setters
    public String getTfUsuario() {
        return tfUsuario.getText();
    }
    public String getTfContrasena() {
        return ftfContrasena.getText();
    }

    // Listeners
    public void addBIniciarSesionAL(ActionListener al) {
        bIniciarSesion.addActionListener(al);
    }
    public void addBRegistroAL(ActionListener al) {
        bRegistrarse.addActionListener(al);
    }

    /**
     * Carga una imagen y la establece como icono en un JLabel con el ancho y alto especificados.
     * Si la imagen se carga correctamente, se establece como icono en el JLabel proporcionado.
     * Si la imagen no se encuentra, se imprime un mensaje de error en la consola.
     *
     * @param label El JLabel en el que se establecerá la imagen.
     */
    private void cargarImagenEstablecerIcono(JLabel label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen("TheMadZaLogoColor", 200, 200);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + "TheMadZaLogoColor" + " no se encontró.");
        }
    }
}