package Controlador.ControladoresVista;

import Vista.VentanaEquipos;

import javax.swing.*;
import java.awt.*;
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
        ve.addBTiendaAL(new BTiendaAL());
        ve.addBInicioAL(new BInicioAL());
        ve.addBSalirAL(new BSalirAL());
        ve.addBFacebookAL(new BFacebookAL());
        ve.addBInstagramAL(new BInstagramAL());
        ve.addBTwitterAL(new BTwitterAL());
        ve.addMJornadasAL(new MJornadasAL());
        ve.addMClasificacionAL(new MClasificacionAL());
        ve.addMEquiposAL(new MEquiposAL());

    }

    public class BFlechaIzquAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ve.getbDerecha().setEnabled(true);

                String equipo = ve.getlEquipo().getText();
                int numEquipo = Integer.parseInt(equipo.replace("Equipo", ""));

                if (numEquipo > 1) {
                    numEquipo--;  // Decrementar el número de equipo
                    String nuevoEquipo = "Equipo" + numEquipo;
                    ve.getlEquipo().setText(nuevoEquipo);
                    ve.cargarImagenEstablecerIcono(nuevoEquipo, 400, 400, ve.getlImagen());

                    if (numEquipo == 1) {
                        ve.getbIzquierda().setEnabled(false);
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
                ve.getbIzquierda().setEnabled(true);

                String equipo = ve.getlEquipo().getText();
                int numEquipo = Integer.parseInt(equipo.replace("Equipo", ""));

                if (numEquipo < 30) {
                    numEquipo++;  // Incrementar el número de equipo
                    String nuevoEquipo = "Equipo" + numEquipo;
                    ve.getlEquipo().setText(nuevoEquipo);
                    ve.cargarImagenEstablecerIcono(nuevoEquipo, 400, 400, ve.getlImagen());

                    if (numEquipo == 30) {
                        ve.getbDerecha().setEnabled(false);
                    }
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    public class BTiendaAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarTienda(ve);
        }
    }

    public class BInicioAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO : cerrar sesión y volver a v inicio sesion
            cv.mostrarInicioSesion(ve);
        }
    }

    public static class BSalirAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static class BFacebookAL implements ActionListener{
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
    public static class BInstagramAL implements ActionListener{

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
    public static class BTwitterAL implements ActionListener{

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
            cv.mostrarJornadas(ve);
        }
    }

    public class MClasificacionAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarClasificacion(ve);
        }
    }

    public class MEquiposAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarEquipos(ve);
        }
    }

}
