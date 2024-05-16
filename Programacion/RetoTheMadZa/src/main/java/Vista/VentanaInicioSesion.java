package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaInicioSesion extends JFrame {

    private JPanel pPrincipal;
    private JTextField tfUsuario;
    private JTextField tfContrasena;
    private JButton bIniciarSesion; // TODO : poner bordes redondos
    private JButton bRegistrarse; // TODO : poner bordes redondos
    private JPanel pDatos; // TODO : poner con forma cuadrada y centrado

    public VentanaInicioSesion(){

        setTitle("Ventana Inicio Sesión");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // PONER UN PANEL DEGRADADO DE FONDO.

        // Inicializar el panel del degradado y establecer los colores.
        pPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Coordenadas para el degradado (para que aparezca en diagonal)
                //Point2D start = new Point2D.Float(0, 0);
                //Point2D end = new Point2D.Float(getWidth(), getHeight());

                // Colores para el degradado
                Color colorInicio = new Color(0x5B2C78);
                Color colorFin = new Color(0xFDA2A1);

                // Crear y configurar el objeto GradientPaint
                //GradientPaint gradientPaint = new GradientPaint(start, colorInicio, end, colorFin);
                GradientPaint gradientPaint = new GradientPaint(0,0,colorInicio,0,getHeight(),colorFin);

                // Aplicar el degradado al panel
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, getWidth(), getHeight());

            }
        };

        // Añadir el panel principal al panel del degradado
        pPrincipal.add(pDatos, BorderLayout.CENTER);

        setContentPane(pPrincipal);
        getRootPane().setDefaultButton(bIniciarSesion);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicioSesion ventana = new VentanaInicioSesion();
        });
    }

    // Getters y setters
    public String getTfUsuario() {
        return tfUsuario.getText();
    }
    public void setTfUsuario(String usuario) {
        this.tfUsuario.setText(usuario);
    }
    public String getTfContrasena() {
        return tfContrasena.getText();
    }
    public void setTfContrasena(String contrasena) {
        this.tfContrasena.setText(contrasena);
    }

    // Listeners
    public void addBIniciarSesionAL(ActionListener al) {
        bIniciarSesion.addActionListener(al);
    }
    public void addBRegistroAL(ActionListener al) {
        bRegistrarse.addActionListener(al);
    }

}
