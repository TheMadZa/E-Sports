package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

import Controlador.ControladoresVista.ControladorImagenes;

/**
 * Ventana Inicial.
 * Esta clase representa la ventana inicial de la aplicación.
 * Muestra información sobre la compañía TheMadZa y sus actividades.
 * Contiene elementos como etiquetas, botones, menús desplegables y texto desplazable.
 * Además, carga imágenes y establece iconos para los componentes visuales.
 *
 * @author Ibai, Lorena, Zahir, Julen
 * @version 1.0
 */

public class VentanaInicial extends JFrame {
    private JPanel pPrincipal;
    private JPanel PanelMedio;
    private JLabel equipo2;
    private JLabel equipo3;
    private JLabel equipo4;
    private JLabel equipo5;
    private JLabel vEquipo1;
    private JLabel vEquipo2;
    private JLabel equipo1;
    private JLabel vEquipo3;
    private JLabel vEquipo4;
    private JLabel vEquipo5;
    private JLabel pEquipo1;
    private JLabel pEquipo2;
    private JLabel pEquipo3;
    private JLabel pEquipo4;
    private JLabel pEquipo5;
    private JLabel ftThemadza;
    private JPanel panelUp;
    private JPanel panelFoot;
    private JPanel panelJornadas;
    private JLabel ftNoticias;
    private JMenuItem mJornadas;
    private JMenuItem mClasificacion;
    private JMenuItem mEquipos;
    private JPanel PanelMenu;
    private JPanel PanelLogo;
    private JButton bInicio;
    private JButton bSalir;
    private JComboBox<String> cbClasificacion;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JMenuBar mPrincipal;
    private JPanel panelNoticias;
    private JMenu mTienda;
    private JMenuBar menuSoloTienda;
    private JLabel labelTextoHorizontal;
    private JButton bTienda;
    private JLabel logoBlanco;
    private int indiceImagenes = 0;
    private final String text = " TheMadZa, compañía líder en eSports, organiza dos competiciones activas: el Torneo " +
            "de TheMadZa Legends, con premios millonarios para equipos globales, y TheMadZa Clash, enfocado en nuevos" +
            " talentos. Recientemente, lanzaron su tienda online con productos exclusivos y personalizados. Los" +
            " jugadores pueden registrarse fácilmente para participar en competiciones y acceder a contenido" +
            " exclusivo, sorteos y descuentos especiales. Además, TheMadZa organiza eventos anuales como" +
            " TheMadZa GameCon para mantener a la comunidad activa y comprometida. ";
    private int currentIndex = 0;

    /**
     * Constructor de la clase VentanaInicial.
     * Crea una nueva instancia de la ventana inicial y configura sus propiedades básicas.
     * Además, carga imágenes y establece iconos para los componentes visuales.
     */
    public VentanaInicial() {
        mostrarImagenesFugaces();

        // TODO : SE PODRÍA REUTILIZAR ESTO (HACER UNA FUNCIÓN GENERAL PARA TODAS LAS VENTANAS)

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
        setTitle("Ventana Inicial");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, cbClasificacion, bFacebook,
                bTwitter, bInstagram, ftThemadza};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        // Iniciar el desplazamiento del texto
        iniciarDesplazamientoTexto();

        setVisible(true);
    }

    /**
     * Método para iniciar el desplazamiento del texto en la ventana.
     * Este método utiliza un temporizador para desplazar el texto de manera horizontal.
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
     * Función para mostrar imágenes fugaces.
     * Esta función utiliza un temporizador para cambiar la imagen después de unos segundos.
     */
    public void mostrarImagenesFugaces() {
        // Crear un temporizador que cambie la imagen después de unos 4 segundos.
        Timer timer = new Timer(3000, e -> {
            // Cambiar la imagen y actualizar el índice
            indiceImagenes = (indiceImagenes + 1) % 7; // Número de imágenes en el array
            // Obtener la imagen del array cargada en el ControladorImagenes
            ImageIcon icon = ControladorImagenes.obtenerImagen("Noticias" + indiceImagenes,600,600);
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
     * Método principal para iniciar la aplicación.
     * Este método crea una instancia de la clase VentanaInicial y la muestra en el hilo de eventos de Swing.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este método).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicial ventana = new VentanaInicial();
        });
    }

    // Getters y setters
    public JComboBox<String> getCbClasificacion() {
        return cbClasificacion;
    }

    public JLabel getvEquipo1() {
        return vEquipo1;
    }

    public JLabel getvEquipo2() {
        return vEquipo2;
    }

    public JLabel getvEquipo3() {
        return vEquipo3;
    }

    public JLabel getvEquipo4() {
        return vEquipo4;
    }

    public JLabel getvEquipo5() {
        return vEquipo5;
    }

    public JLabel getpEquipo1() {
        return pEquipo1;
    }

    public JLabel getpEquipo2() {
        return pEquipo2;
    }

    public JLabel getpEquipo3() {
        return pEquipo3;
    }

    public JLabel getpEquipo4() {
        return pEquipo4;
    }

    public JLabel getpEquipo5() {
        return pEquipo5;
    }

    public JLabel getEquipo2() {
        return equipo2;
    }

    public JLabel getEquipo3() {
        return equipo3;
    }

    public JLabel getEquipo4() {
        return equipo4;
    }

    public JLabel getEquipo5() {
        return equipo5;
    }

    public JLabel getEquipo1() {
        return equipo1;
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
     * Muestra un mensaje en un cuadro de diálogo.
     *
     * @param mensaje El mensaje que se mostrará en el cuadro de diálogo.
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    // Método auxiliar para cargar imágenes y establecer íconos (una función es para los JLabel y la otra para JButton)

    /**
     * Carga una imagen y la establece como ícono en un JLabel.
     *
     * @param nombreImagen El nombre de la imagen que se cargará.
     * @param ancho El ancho deseado para la imagen.
     * @param alto El alto deseado para la imagen.
     * @param label El JLabel donde se establecerá el ícono.
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
     * Carga una imagen y la establece como ícono en un JButton.
     *
     * @param nombreImagen El nombre de la imagen que se cargará.
     * @param button El JButton donde se establecerá el ícono.
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