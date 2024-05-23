package Vista;

import javax.swing.*;
import java.awt.event.*;

public class DialogoUsuario extends JDialog {
    private JPanel pPrincipal;
    private JButton buttonOk;
    private JPanel pDatos;
    private JTextField tfUsuario;
    private JButton buttonCancel;
    private JPasswordField ftfContrasena;

    public DialogoUsuario() {
        setContentPane(pPrincipal);
        setTitle("Dialogo Usuario");
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(true);
        setModal(true);
        getRootPane().setDefaultButton(buttonOk);

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

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DialogoUsuario dialog = new DialogoUsuario();
    }

    // Funciones
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void vaciarCasillas(){
        tfUsuario.setText("");
        ftfContrasena.setText("");
    }

    // Getters
    public String getTfUsuario() {
        return tfUsuario.getText();
    }
    public String getFtfContrasena() {
        return ftfContrasena.getText();
    }


    // Listeners
    public void addButtonOkAL(ActionListener al) {
        buttonOk.addActionListener(al);
    }
    public void addButtonCancelAL(ActionListener al) {
        buttonCancel.addActionListener(al);
    }
}