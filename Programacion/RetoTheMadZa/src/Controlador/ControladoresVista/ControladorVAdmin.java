package Controlador.ControladoresVista;

import Vista.VentanaAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVAdmin {

    private VentanaAdmin va;
    private ControladorVista cv;
    private String accion;

    public ControladorVAdmin(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        va = new VentanaAdmin();

        // Action Listeners de los botones y demás.
        va.addMiCrudAL(new MiCrudAL());
        va.addBAccionesAL(new BAccionesAL());
        va.addMiVisualizarJornadasAL(new MiVisualizarJornadasAL());
        va.addMiClasificacionJornadasAL(new MiClasificacionJornadasAL());
    }

    public class MiCrudAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            va.getpDatos().removeAll();

            accion = e.getActionCommand();
            switch (accion){

                case "CRUD Equipos" -> va.mostrarDatosEquipos();

                case "CRUD Jugadores" -> va.mostrarDatosJugadores();

                case "CRUD Staff" -> System.out.println("puesto staff");

                case "CRUD Patrocinadores" -> System.out.println("nombre patrocinador");

                case "CRUD Juegos" -> System.out.println("nombre juego");

                case "CRUD Competiciones" -> System.out.println("nombre competicion");

                case "CRUD Enfrentamientos" -> System.out.println("hora enfrentamiento");

                case "CRUD Jornadas" -> System.out.println("numero jornada");

            }

            if (!va.getPanelCRUD().isVisible())
                va.getPanelCRUD().setVisible(true);

        }
    }
    public class BAccionesAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO : en el insert, después de realizar la accion, mostraría un mensaje diciendo (a parte de que "todo correcto") que el ID ha sido... (para saberlo) (en println y en showmessagedialog)
        }
    }
    public class MiVisualizarJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
    public class MiClasificacionJornadasAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
}
