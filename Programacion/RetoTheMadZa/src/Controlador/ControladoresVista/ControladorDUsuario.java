package Controlador.ControladoresVista;

import Modelo.Usuario;
import Vista.DialogoUsuario;
import Vista.VentanaInicial;
import Vista.VentanaInicioSesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para el diálogo de usuario.
 */
public class ControladorDUsuario {

    private DialogoUsuario du;
    private ControladorVista cv;

    /**
     * Constructor del controlador de diálogo de usuario.
     *
     * @param cv El controlador de vista principal.
     */
    public ControladorDUsuario(ControladorVista cv) {
        this.cv = cv;
    }

    /**
     * Crea y muestra el diálogo de usuario.
     */
    public void crearMostrar() {
        du = new DialogoUsuario();

        du.addButtonOkAL(new ButtonOkAL());
        du.addButtonCancelAL(new ButtonCancelAL());

        du.setVisible(true);
    }

    /**
     * Manejador de eventos para el botón "OK" en el diálogo de usuario.
     */
    public class ButtonOkAL implements ActionListener {
        /**
         * Acción a realizar cuando se pulsa el botón "OK".
         *
         * @param e El evento de acción.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String nombre = du.getTfUsuario();
                String contrasena = du.getFtfContrasena();

                if (nombre.isEmpty() && contrasena.isEmpty()) {
                    throw new Exception("El nombre y la contraseña son campos obligatorios.");
                } else if (nombre.isEmpty()) {
                    throw new Exception("El nombre es obligatorio.");
                } else if (contrasena.isEmpty()) {
                    throw new Exception("La contraseña es obligatoria.");
                }

                Usuario usuario = new Usuario(nombre, contrasena, "N");

                boolean insercionHecha = cv.insertarUsuario(usuario);

                if (insercionHecha) {
                    du.mostrarMensaje("Usuario registrado");
                    System.out.println("Usuario registrado.");
                    du.vaciarCasillas();
                }

            } catch (Exception ex) {
                du.mostrarMensaje(ex.getMessage());
            }
        }
    }

    /**
     * Manejador de eventos para el botón "Cancelar" en el diálogo de usuario.
     */
    public class ButtonCancelAL implements ActionListener {
        /**
         * Acción a realizar cuando se pulsa el botón "Cancelar".
         *
         * @param e El evento de acción.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            du.mostrarMensaje("Debe registrar un usuario con rol `Normal´.");
        }
    }

}

