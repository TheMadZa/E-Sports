package Vista;

import javax.swing.*;
import java.awt.*;
/**
 * Ventana de carga para cargar las imágenes.
 * Esta clase representa una ventana de carga que se utiliza para mostrar un indicador de carga
 * mientras se cargan las imágenes en la aplicación.
 *
 * @author Ibai, Lorena
 * @version 1.0
 */
public class VentanaCarga extends JFrame {
    private JPanel pPrincipal;
    private JLabel cargando;

    /**
     * Constructor de la clase VentanaCarga.
     * Crea una nueva instancia de la ventana de carga y configura sus propiedades básicas.
     */
    public VentanaCarga() {
        setContentPane(pPrincipal);
        setTitle("Ventana Carga");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }
}