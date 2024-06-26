package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Ventana Inicial 2.
 * Esta clase representa la ventana inicial para los usuarios.
 * Proporciona funcionalidades para cargar imágenes, establecerlas como iconos en componentes JLabel y JButton,
 * mostrar mensajes emergentes y configurar listeners para los elementos de la interfaz.
 * Además, contiene métodos para iniciar el desplazamiento de texto y mostrar imágenes fugaces.
 * @author Ibai, Lorena
 * @version 1.0
 */
public class VentanaUser extends JFrame {
    private JPanel panelUp;
    private JPanel PanelMenu;
    private JMenuBar mPrincipal;
    private JMenuItem mJornadas;
    private JMenuItem mClasificacion;
    private JPanel PanelLogo;
    private JLabel ftThemadza;
    private JButton bInicio;
    private JButton bSalir;
    private JButton bTienda;
    private JPanel PanelMedio;
    private JPanel panelJornadas;
    private JLabel vEquipo1;
    private JLabel vEquipo2;
    private JLabel vEquipo3;
    private JLabel vEquipo4;
    private JLabel vEquipo5;
    private JLabel pEquipo1;
    private JLabel pEquipo2;
    private JLabel pEquipo3;
    private JLabel pEquipo4;
    private JLabel pEquipo5;
    private JLabel equipo1;
    private JLabel equipo2;
    private JLabel equipo3;
    private JLabel equipo4;
    private JLabel equipo5;
    private JPanel panelNoticias;
    private JLabel ftNoticias;
    private JComboBox<String> cbClasificacion;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JLabel logoBlanco;
    private JLabel labelTextoHorizontal;
    private JPanel pPrincipal;
    private JMenuItem mEquipos;
    private JPanel panelFoot;
    private int indiceImagenes = 0;

    private final String text = " TheMadZa, compañía líder en eSports, organiza dos competiciones activas: el Torneo de" +
            " TheMadZa Legends, con premios millonarios para equipos globales, y TheMadZa Clash, enfocado en nuevos" +
            " talentos. Recientemente, lanzaron su tienda online con productos exclusivos y personalizados. Los" +
            " jugadores pueden registrarse fácilmente para participar en competiciones y acceder a contenido" +
            " exclusivo, sorteos y descuentos especiales. Además, TheMadZa organiza eventos anuales como" +
            " TheMadZa GameCon para mantener a la comunidad activa y comprometida. ";
    private int currentIndex = 0;

    /**
     * Constructor de la clase VentanaUser.
     * Crea una nueva instancia de la ventana de usuario normal.
     * @param vis La ventana de inicio de sesión que se desea cerrar al mostrar esta ventana.
     */
    public VentanaUser(VentanaInicioSesion vis) {
        mostrarImagenesFugaces();

        // Cargar las imágenes con un tamaño específico.
        cargarImagenEstablecerIcono("TheMadZaLogoSimple", 250, 250, ftThemadza);
        cargarImagenEstablecerIcono("Tienda", bTienda);
        cargarImagenEstablecerIcono("Inicio", bInicio);
        cargarImagenEstablecerIcono("Salir", bSalir);
        cargarImagenEstablecerIcono("Twitter", bTwitter);
        cargarImagenEstablecerIcono("Instagram", bInstagram);
        cargarImagenEstablecerIcono("Facebook", bFacebook);
        cargarImagenEstablecerIcono("LogoBlanco", 100, 100, logoBlanco);

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Usuario Normal");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, cbClasificacion, bFacebook,
                bTwitter, bInstagram, ftThemadza};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        iniciarDesplazamientoTexto();

        setVisible(true);

        // Destruir la ventana de inicio de sesión.
        vis.dispose();
    }

    /**
     * Inicia el desplazamiento horizontal del texto en la ventana.
     * Este método crea un temporizador que cambia el texto de manera cíclica para simular un efecto de desplazamiento.
     */
    private void iniciarDesplazamientoTexto() {
        Timer timer = new Timer(80, e -> {
            String displayedText = text.substring(currentIndex) + text.substring(0, currentIndex);
            labelTextoHorizontal.setText(displayedText);
            currentIndex++;
            if (currentIndex >= text.length()) {
                currentIndex = 0;
            }
        });
        timer.start();
    }

    // Función para mostrar las imágenes transitorias.

    /**
     * Muestra imágenes fugaces en la ventana.
     * Este método cambia la imagen mostrada en intervalos regulares para simular un efecto de diapositivas.
     */
    public void mostrarImagenesFugaces() {
        // Crear un temporizador que cambie la imagen después de unos 4 segundos.
        Timer timer = new Timer(3000, e -> {
            // Cambiar la imagen y actualizar el índice
            indiceImagenes = (indiceImagenes + 1) % 7; // Número de imágenes en el array
            // Obtener la imagen del array cargada en el ControladorImagenes
            ImageIcon icon = ControladorImagenes.obtenerImagen("Noticias" + indiceImagenes, 600, 600);
            if (icon != null) {
                ftNoticias.setIcon(icon);
            } else {
                System.err.println("La imagen Noticias" + indiceImagenes + " no se encontró.");
            }
        });
        // Comenzar el temporizador
        timer.start();
    }

    /**
     * Método principal de la clase VentanaUser.
     * Este método es el punto de entrada principal para la aplicación.
     * Inicia la interfaz de usuario en un hilo de despacho de eventos de Swing para garantizar la seguridad de la interfaz.
     * Crea una instancia de la ventana de usuario normal y la muestra.
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaUser ventana = new VentanaUser(null);
        });
    }

    // Getters y setters
    public JComboBox<String> getCbClasificacion() {
        return cbClasificacion;
    }

    public JLabel getvEquipo1() {
        return vEquipo1;
    }

    public void setvEquipo1(JLabel vEquipo1) {
        this.vEquipo1 = vEquipo1;
    }

    public JLabel getvEquipo2() {
        return vEquipo2;
    }

    public void setvEquipo2(JLabel vEquipo2) {
        this.vEquipo2 = vEquipo2;
    }

    public JLabel getvEquipo3() {
        return vEquipo3;
    }

    public void setvEquipo3(JLabel vEquipo3) {
        this.vEquipo3 = vEquipo3;
    }

    public JLabel getvEquipo4() {
        return vEquipo4;
    }

    public void setvEquipo4(JLabel vEquipo4) {
        this.vEquipo4 = vEquipo4;
    }

    public JLabel getvEquipo5() {
        return vEquipo5;
    }

    public void setvEquipo5(JLabel vEquipo5) {
        this.vEquipo5 = vEquipo5;
    }

    public JLabel getpEquipo1() {
        return pEquipo1;
    }

    public void setpEquipo1(JLabel pEquipo1) {
        this.pEquipo1 = pEquipo1;
    }

    public JLabel getpEquipo2() {
        return pEquipo2;
    }

    public void setpEquipo2(JLabel pEquipo2) {
        this.pEquipo2 = pEquipo2;
    }

    public JLabel getpEquipo3() {
        return pEquipo3;
    }

    public void setpEquipo3(JLabel pEquipo3) {
        this.pEquipo3 = pEquipo3;
    }

    public JLabel getpEquipo4() {
        return pEquipo4;
    }

    public void setpEquipo4(JLabel pEquipo4) {
        this.pEquipo4 = pEquipo4;
    }

    public JLabel getpEquipo5() {
        return pEquipo5;
    }

    public void setpEquipo5(JLabel pEquipo5) {
        this.pEquipo5 = pEquipo5;
    }

    public JLabel getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(JLabel equipo2) {
        this.equipo2 = equipo2;
    }

    public JLabel getEquipo3() {
        return equipo3;
    }

    public void setEquipo3(JLabel equipo3) {
        this.equipo3 = equipo3;
    }

    public JLabel getEquipo4() {
        return equipo4;
    }

    public void setEquipo4(JLabel equipo4) {
        this.equipo4 = equipo4;
    }

    public JLabel getEquipo5() {
        return equipo5;
    }

    public void setEquipo5(JLabel equipo5) {
        this.equipo5 = equipo5;
    }

    public JLabel getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(JLabel equipo1) {
        this.equipo1 = equipo1;
    }

    // Listeners
    public void addMJornadasAL(ActionListener al) {
        mJornadas.addActionListener(al);
    }
    public void addMClasificacionAL(ActionListener al) {
        mClasificacion.addActionListener(al);
    }
    public void addMEquiposAL(ActionListener al) {
        mEquipos.addActionListener(al);
    }
    public void addBTiendaAL(ActionListener al) {
        bTienda.addActionListener(al);
    }
    public void addBInicioAL(ActionListener al) {
        bInicio.addActionListener(al);
    }
    public void addBSalirAL(ActionListener al) {
        bSalir.addActionListener(al);
    }
    public void addBFacebookAL(ActionListener al) {
        bFacebook.addActionListener(al);
    }
    public void addBInstagramAL(ActionListener al) {
        bInstagram.addActionListener(al);
    }
    public void addBTwitterAL(ActionListener al) {
        bTwitter.addActionListener(al);
    }
    public void addCbClasificacionAL(ActionListener al) {
        cbClasificacion.addActionListener(al);
    }

    // Funciones

    /**
     * Muestra un mensaje emergente con el mensaje especificado.
     * @param mensaje El mensaje que se desea mostrar en el mensaje emergente.
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    /**
     * Carga una imagen y la establece como icono en un componente JLabel con el tamaño especificado.
     * Si la imagen no se encuentra, imprime un mensaje de error en la consola.
     * @param nombreImagen El nombre de la imagen que se va a cargar.
     * @param ancho El ancho deseado para la imagen.
     * @param alto El alto deseado para la imagen.
     * @param label El JLabel en el que se establecerá la imagen como icono.
     */
    private void cargarImagenEstablecerIcono(String nombreImagen, int ancho, int alto, JLabel label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

    /**
     * Carga una imagen y la establece como icono en un componente JButton con un tamaño predeterminado de 40x40 píxeles.
     * Si la imagen no se encuentra, imprime un mensaje de error en la consola.
     * @param nombreImagen El nombre de la imagen que se va a cargar.
     * @param button El JButton en el que se establecerá la imagen como icono.
     */
    private void cargarImagenEstablecerIcono(String nombreImagen, JButton button) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, 40, 40);
        if (icono != null) {
            button.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }
}