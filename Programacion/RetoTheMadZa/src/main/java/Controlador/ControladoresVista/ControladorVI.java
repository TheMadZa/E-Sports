package Controlador.ControladoresVista;

import Vista.VentanaInicial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVI {
    private VentanaInicial vi;
    private ControladorVista cv;

    public ControladorVI(ControladorVista cv)
    {
        this.cv = cv;
    }

    public void crearMostrar() {
        vi = new VentanaInicial();

        // TODO : aquí estarían los action listeners de los botones y demás.

        vi.addBInicioAL(new BInicioAL());
        vi.addBSalirAL(new BSalirAL());
        vi.addBFacebookAL(new BFacebookAL());
        vi.addBInstagramAL(new BInstagramAL());
        vi.addBTwitterAL(new BTwitterAL());
        vi.addMJornadasAL(new MJornadasAL());
        vi.addMClasificacionAL(new MClasificacionAL());
        vi.addMEquiposAL(new MEquiposAL());

        vi.setVisible(true);
        vi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vi.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vi.setResizable(true);
    }

    public class BInicioAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class BSalirAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

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

        }
    }

    public class BTwitterAL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

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

}
