package Controlador.ControladoresVista;

import Vista.VentanaAdmin;
import Vista.VentanaInicioSesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVAdmin {

    private VentanaAdmin va;
    private ControladorVista cv;
    private String accion;

    public ControladorVAdmin(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar(VentanaInicioSesion vis) {
        va = new VentanaAdmin(vis);

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
                case "CRUD Staff" -> va.mostrarDatosStaff();
                case "CRUD Patrocinadores" -> va.mostrarDatosPatrocinadores();
                case "CRUD Juegos" -> va.mostrarDatosJuegos();
                case "CRUD Competiciones" -> va.mostrarDatosCompeticiones();
                case "CRUD Enfrentamientos" -> va.mostrarDatosEnfrentamientos();
                case "CRUD Jornadas" -> va.mostrarDatosJornadas();
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
