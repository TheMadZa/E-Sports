package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.event.*;

/**
 * Clase que representa un diálogo para ingresar datos de usuario.
 * Este diálogo permite al usuario ingresar un nombre de usuario y una contraseña.
 * Proporciona métodos para mostrar un mensaje, vaciar las casillas de texto y obtener los valores ingresados.
 *
 * Este diálogo contiene dos campos de texto: uno para el nombre de usuario y otro para la contraseña.
 * También incluye botones para confirmar o cancelar la operación.
 * El diálogo se muestra modalmente, lo que significa que bloquea la interacción con otras ventanas hasta que se cierra.
 *
 * Esta clase es una subclase de JDialog.
 *
 * @author Lorena
 * @version 1.0
 */
public class DialogoUsuario extends JDialog {
    private JPanel pPrincipal;
    private JButton buttonOk;
    private JPanel pDatos;
    private JTextField tfUsuario;
    private JButton buttonCancel;
    private JPasswordField ftfContrasena;
    private JLabel ftLogo;



    /**
     * Constructor de la clase DialogoUsuario.
     * Crea una instancia del diálogo de usuario, inicializando sus componentes y configurando su comportamiento.
     */
    public DialogoUsuario() {
        setContentPane(pPrincipal);
        setTitle("Dialogo Usuario");
        setSize(600,800);
        setLocationRelativeTo(null);
        setResizable(true);
        setModal(true);
        getRootPane().setDefaultButton(buttonOk);
        cargarImagenEstablecerIcono("TheMadZaLogoColor", 200, 200, ftLogo);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    /**
     * Método invocado cuando se cancela el diálogo.
     * Agrega aquí tu código si es necesario.
     */
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    /**
     * Método principal para ejecutar el diálogo de usuario.
     * Crea una instancia del diálogo de usuario y lo muestra.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        DialogoUsuario dialog = new DialogoUsuario();
    }

    // Funciones

    /**
     * Muestra un mensaje en un cuadro de diálogo emergente.
     *
     * @param mensaje El mensaje a mostrar.
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    /**
     * Vacía las casillas de texto del diálogo.
     */
    public void vaciarCasillas(){
        tfUsuario.setText("");
        ftfContrasena.setText("");
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

    // Getters
    public String getTfUsuario() {
        return tfUsuario.getText();
    }
    public String getFtfContrasena() {
        return ftfContrasena.getText();
    }


    // Listeners
    /**
     * Agrega un ActionListener al botón "Ok".
     *
     * @param al El ActionListener a agregar.
     */
    public void addButtonOkAL(ActionListener al) {
        buttonOk.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al botón "Cancelar".
     *
     * @param al El ActionListener a agregar.
     */
    public void addButtonCancelAL(ActionListener al) {
        buttonCancel.addActionListener(al);
    }
}