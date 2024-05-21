package Controlador.ControladoresVista;

import Vista.VentanaEquipos;
import Vista.VentanaInicial;
import Vista.VentanaUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVEquipos {

    private VentanaEquipos ve;
    private ControladorVista cv;
    private ControladorImagenes ci;
    private int numEquipo;

    public ControladorVEquipos(ControladorVista cv)
    {
        this.cv = cv;
    }

    public void crearMostrar(JFrame ventanaEliminar) {

        ve = new VentanaEquipos(ventanaEliminar);

        ve.addBFlechaIzquAL(new BFlechaIzquAL());
        ve.addBFlechaDrchAL(new BFlechaDrchAL());
        //

    }

    public class BFlechaIzquAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ve.getbDerecha().setEnabled(true);

                String equipo = ve.getlEquipo().getText();
                boolean encontrado = false;

                for (numEquipo=30; !encontrado; numEquipo--){

                    if (equipo.equalsIgnoreCase("Equipo"+numEquipo)){
                        ve.getlEquipo().setText("Equipo"+(numEquipo-1));
                        ve.cargarImagenEstablecerIcono("Equipo"+(numEquipo-1),400,400,
                                ve.getlImagen());
                        encontrado = true;
                    }
                }

                if (numEquipo == 1){
                    ve.getbIzquierda().setEnabled(false);
                } else if (numEquipo == 30) {
                    ve.getbDerecha().setEnabled(false);
                } else {
                    ve.getbIzquierda().setEnabled(true);
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class BFlechaDrchAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ve.getbIzquierda().setEnabled(true);

                String equipo = ve.getlEquipo().getText();
                boolean encontrado = false;

                for (numEquipo=1; !encontrado; numEquipo++){

                    if (equipo.equalsIgnoreCase("Equipo"+numEquipo)){
                        ve.getlEquipo().setText("Equipo"+(numEquipo+1));
                        ve.cargarImagenEstablecerIcono("Equipo"+(numEquipo+1),400,400,
                                ve.getlImagen());
                        encontrado = true;
                    }
                }

                if (numEquipo == 1){
                    ve.getbIzquierda().setEnabled(false);
                } else if (numEquipo == 30) {
                    ve.getbDerecha().setEnabled(false);
                } else {
                    ve.getbDerecha().setEnabled(true);
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
