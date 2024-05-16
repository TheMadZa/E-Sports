package Controlador.ControladoresVista;

import Modelo.*;
import Vista.VentanaInicial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorVI {

    private VentanaInicial vi;
    private ControladorVista cv;

    public ControladorVI(ControladorVista cv)
    {
        this.cv = cv;
    }

    public void crearMostrar() {
        vi = new VentanaInicial();

        llenarComboBox();

        // Action Listeners de los botones y demás.
        vi.addBInicioAL(new BInicioAL());
        vi.addBSalirAL(new BSalirAL());
        vi.addBFacebookAL(new BFacebookAL());
        vi.addBInstagramAL(new BInstagramAL());
        vi.addBTwitterAL(new BTwitterAL());
        vi.addMJornadasAL(new MJornadasAL());
        vi.addMClasificacionAL(new MClasificacionAL());
        vi.addMEquiposAL(new MEquiposAL());
        vi.addCbClasificacionAL(new CbClasificacionAL());

        vi.setVisible(true);
        vi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vi.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vi.setResizable(true);
    }

    public class BInicioAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarInicioSesion();
        }
    }

    public static class BSalirAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class BFacebookAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String enlace = "https://www.facebook.com/?locale=es_ES";
            try {
                Desktop.getDesktop().browse(java.net.URI.create(enlace));
            } catch (java.io.IOException ex) {
                System.out.println("Error al abrir el enlace: " + ex.getMessage());
            }
        }
    }

    public class BInstagramAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String enlace = "https://www.instagram.com";
            try {
                Desktop.getDesktop().browse(java.net.URI.create(enlace));
            } catch (java.io.IOException ex) {
                System.out.println("Error al abrir el enlace: " + ex.getMessage());
            }
        }
    }

    public class BTwitterAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String enlace = "https://twitter.com/?logout=1715768138184";
            try {
                Desktop.getDesktop().browse(java.net.URI.create(enlace));
            } catch (java.io.IOException ex) {
                System.out.println("Error al abrir el enlace: " + ex.getMessage());
            }
        }
    }

    public class MJornadasAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class MClasificacionAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class MEquiposAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class CbClasificacionAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nombreSeleccionado = vi.getCbClasificacion().getSelectedItem().toString();
                if (nombreSeleccionado != null && !nombreSeleccionado.isEmpty()){
                    validarBuscarCompeticionNombre(nombreSeleccionado); // TODO
                }
            }
            catch (Exception ex)
            {
                //vi.mostrarMensaje(ex.getMessage());
            }

        }
    }

    public void validarBuscarCompeticionNombre(String nombreSeleccionado) throws Exception {
        List<EquipoCompeticion> equipoCompeticiones = new ArrayList<>();

        //Bsucamos el objeto competicion para conseguir el id
        Competicion c = cv.buscarCompeticionNombre(nombreSeleccionado);

        //Llenamos la lista con los equipos de una competicion específica
        for (EquipoCompeticion equipoCompeticion : c.getIdCompeticion()){
            if (equipoCompeticion.getCompeticionByIdCompeticion() != c){
                equipoCompeticiones.
            }
        }

        //De los 5 mejores conseguir el logo, victorias y puntos


        for (int x = 0; x < 5; x++) {
            EquipoCompeticion ec = ;
            vi.getvEquipo1().setText();
        }
    }



    public void llenarComboBox(){
        try {
            vi.getCbClasificacion().removeAllItems();

            List<Competicion> competiciones = cv.consultaTodasCompeticiones();

            for (Competicion competicion : competiciones){
                vi.getCbClasificacion().addItem(competicion.getNombreCom());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }


}
