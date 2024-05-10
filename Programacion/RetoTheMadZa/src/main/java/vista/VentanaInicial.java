package Vista;

import javax.swing.*;
import java.awt.*;

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

    public VentanaInicial(){
        super("Ventana principal");
        setContentPane(pPrincipal);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> new VentanaInicial());
    }

}
