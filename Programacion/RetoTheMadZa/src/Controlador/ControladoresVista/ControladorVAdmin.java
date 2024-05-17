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
        va.addMiVisualizarJornadasAL(new MiVisualizarJornadasAL());
        va.addMiClasificacionJornadasAL(new MiClasificacionJornadasAL());
        va.addBAccionesAL(new BAccionesAL());
    }

    public class MiCrudAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            accion = e.getActionCommand();
            switch (accion){

                case "CRUD Equipos" -> va.mostrarDatosEquipos();

                case "CRUD Jugadores" -> {
                    va.setJlDato1("Nombre:");
                    //va.getpDatos().add();
                }
                case "CRUD Staff" -> {
                    va.setJlDato1("Puesto:");
                    //va.getpDatos().add();
                }
                case "CRUD Patrocinadores" -> {
                    va.setJlDato1("Nombre:");
                    //va.getpDatos().add();
                }
                case "CRUD Juegos" -> {
                    va.setJlDato1("Nombre:");
                    //va.getpDatos().add();
                }
                case "CRUD Competiciones" -> {
                    va.setJlDato1("Nombre:");
                    //va.getpDatos().add();
                }
                case "CRUD Enfrentamientos" -> {
                    va.setJlDato1("Hora:");
                    //va.getpDatos().add();
                }
                case "CRUD Jornadas" -> {
                    va.setJlDato1("Número:");
                    //va.getpDatos().add();
                }

            }

            va.getPanelCRUD().setVisible(true);

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
    public class BAccionesAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

}
