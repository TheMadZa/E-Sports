package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaCarga extends JFrame {
    private JPanel pPrincipal;
    private JLabel cargando;

    public VentanaCarga() {
        setContentPane(pPrincipal);
        setTitle("Ventana Carga");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }
}