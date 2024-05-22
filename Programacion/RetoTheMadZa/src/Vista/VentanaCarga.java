package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaCarga extends JFrame {
    private JPanel pPrincipal;
    private JLabel cargando;

    public VentanaCarga() {
        setContentPane(pPrincipal);
        setTitle("Ventana Carga");
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this);
        } else {
            System.err.println("Pantalla completa no soportada");
            setExtendedState(JFrame.MAXIMIZED_BOTH); // Tamaño por defecto si pantalla completa no está soportada
            this.setVisible(true);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}