package Vista;

import javax.swing.*;
import java.awt.event.*;

public class DialogoUsuario extends JDialog {
    private JPanel pPrincipal;
    private JButton buttonOK;
    private JButton buttonCancel;

    public DialogoUsuario() {
        setContentPane(pPrincipal);
        setTitle("Dialogo Usuario");
        setSize(600,600); // Poner bien
        setLocationRelativeTo(null);
        setResizable(true);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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

        setVisible(true);

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DialogoUsuario dialog = new DialogoUsuario();
    }
}
