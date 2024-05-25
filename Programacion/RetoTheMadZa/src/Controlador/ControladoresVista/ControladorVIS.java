package Controlador.ControladoresVista;

import Vista.VentanaInicial;
import Vista.VentanaInicioSesion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para la vista de inicio de sesión.
 */
public class ControladorVIS {

    private VentanaInicioSesion vis;
    private ControladorVista cv;

    /**
     * Constructor del controlador de la vista de inicio de sesión.
     *
     * @param cv El controlador de vista principal.
     */
    public ControladorVIS(ControladorVista cv) {
        this.cv = cv;
    }

    /**
     * Crea y muestra la ventana de inicio de sesión.
     *
     * @param ventanaEliminar La ventana padre para este diálogo.
     */
    public void crearMostrar(JFrame ventanaEliminar) {
        vis = new VentanaInicioSesion(ventanaEliminar);

        // Action Listeners de los botones y demás.
        vis.addBIniciarSesionAL(new BIniciarSesionAL());
        vis.addBRegistroAL(new BRegistroAL());

    }

    /**
     * Manejador de eventos para el botón "Iniciar Sesión".
     */
    public class BIniciarSesionAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                boolean userAdmin = cv.validarUsuario(vis.getTfUsuario(), vis.getTfContrasena());

                if (userAdmin)
                    cv.mostrarVAdmin(vis);
                else
                    cv.mostrarUser(vis);
            } catch (Exception ex) {
                vis.mostrarMensaje(ex.getMessage());
            }
        }
    }

    /**
     * Manejador de eventos para el botón "Registro".
     */
    public class BRegistroAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Aparecerá un dialog para meter los datos de un nuevo usuario (solo podrá ser "Normal) y se hará un insert.
            cv.mostrarDUsuario();
        }
    }

}

