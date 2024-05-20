package Controlador.ControladoresVista;

import Modelo.Equipo;
import Vista.VentanaAdmin;
import Vista.VentanaInicioSesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVAdmin {

    private VentanaAdmin va;
    private ControladorVista cv;
    private String tablaElegida;
    private String accionElegida;

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

            tablaElegida = e.getActionCommand();
            switch (tablaElegida){
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

            try {

                accionElegida = e.getActionCommand();

                // Dependiendo de la tabla sobre la que queramos hacer una acción, y la acción en la BD que sea:
                switch (tablaElegida){

                    case "CRUD Equipos" -> {

                        switch (accionElegida){
                            case "Insertar" -> {
                                Equipo equipo = new Equipo(); // TODO : ¿pillar datos?
                                cv.insertarEquipo(equipo);
                            }
                            case "Eliminar" -> va.mostrarDatosJugadores();
                            case "Actualizar" -> va.mostrarDatosStaff();
                            case "Consultar" -> va.mostrarDatosPatrocinadores();
                        }

                    }
                    case "CRUD Jugadores" -> {

                    }
                    case "CRUD Staff" -> {

                    }
                    case "CRUD Patrocinadores" -> {

                    }
                    case "CRUD Juegos" -> {

                    }
                    case "CRUD Competiciones" -> {

                    }
                    case "CRUD Enfrentamientos" -> {

                    }
                    case "CRUD Jornadas" -> {

                    }

                }

            }
            catch (Exception ex){
                va.mostrarMensaje(ex.getMessage());
            }

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
