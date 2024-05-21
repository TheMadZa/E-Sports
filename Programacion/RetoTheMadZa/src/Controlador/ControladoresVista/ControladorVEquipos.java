package Controlador.ControladoresVista;

import Vista.VentanaEquipos;
import Vista.VentanaInicial;

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

    public void crearMostrar(VentanaInicial vi) {

        ve = new VentanaEquipos(vi);

        ve.addBFlechaIzquAL(new BFlechaIzquAL());
        ve.addBFlechaDrchAL(new BFlechaDrchAL());
        //

    }

    public class BFlechaIzquAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String equipo = ve.getlEquipo().getText();
                boolean encontrado = false;

                for (numEquipo=1; !encontrado; numEquipo--){
                    if (numEquipo == 0){
                        numEquipo=30;
                    }
                    if (equipo.equalsIgnoreCase("Equipo"+numEquipo)){
                        ve.getlEquipo().setText("Equipo"+(numEquipo-1));
                        ve.cargarImagenEstablecerIcono("Equipo"+(numEquipo-1),400,400,
                                ve.getlImagen());
                        encontrado = true;
                    }
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
                String equipo = ve.getlEquipo().getText();
                boolean encontrado = false;

                for (numEquipo=1; !encontrado; numEquipo++){
                    if (numEquipo == 31){
                        numEquipo=1;
                    }
                    if (equipo.equalsIgnoreCase("Equipo"+numEquipo)){
                        ve.getlEquipo().setText("Equipo"+(numEquipo+1));
                        ve.cargarImagenEstablecerIcono("Equipo"+(numEquipo+1),400,400,
                                ve.getlImagen());
                        encontrado = true;
                    }
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
