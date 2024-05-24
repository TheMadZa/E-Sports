package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Ventana Tienda.
 * Esta clase representa la interfaz gráfica de usuario de la tienda de la aplicación.
 * Permite a los usuarios explorar productos disponibles y realizar compras.
 * @author Ibai, Lorena
 * @version 1.0
 */
public class VentanaTienda extends JFrame{
    private JPanel pPrincipal;
    private JPanel panelUp;
    private JPanel PanelMenu;
    private JMenuBar mPrincipal;
    private JMenuItem mJornadas;
    private JMenuItem mClasificacion;
    private JPanel PanelLogo;
    private JButton ftThemadza;
    private JButton bInicio;
    private JButton bSalir;
    private JPanel panelFoot;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JLabel logoBlanco;
    private JScrollPane PanelMedio;
    private JLabel tienda3;
    private JLabel tienda4;
    private JLabel tienda5;
    private JLabel tienda6;
    private JLabel tienda7;
    private JLabel tienda8;
    private JLabel tienda9;
    private JLabel tienda10;
    private JLabel tienda11;
    private JPanel tien;
    private JLabel tienda12;
    private JLabel separador1;
    private JLabel tienda1;
    private JButton bBuy1;
    private JButton bBuy2;
    private JButton bBuy3;
    private JButton bBuy4;
    private JButton bBuy5;
    private JButton bBuy6;
    private JButton bBuy7;
    private JButton bBuy8;
    private JButton bBuy9;
    private JPanel JPanel;
    private JButton bBuy10;
    private JButton bBuy11;
    private JButton bBuy12;
    private JLabel tienda2;
    private JPanel panelTienda1;
    private JMenuItem mEquipos;

    /**
     * Constructor de la clase VentanaTienda.
     * Crea una nueva ventana de la tienda y carga los componentes de la interfaz.
     * @param ventanaEliminar La ventana anterior que se eliminará al abrir la tienda.
     */
    public VentanaTienda(JFrame ventanaEliminar) {

        // Cargar las imágenes con un tamaño específico.
        cargarImagenEstablecerIconoBoton("TheMadZaLogoSimple", 250, 250, ftThemadza);
        cargarImagenEstablecerIcono("Inicio", bInicio);
        cargarImagenEstablecerIcono("Salir", bSalir);
        cargarImagenEstablecerIcono("Twitter", bTwitter);
        cargarImagenEstablecerIcono("Instagram", bInstagram);
        cargarImagenEstablecerIcono("Facebook", bFacebook);
        cargarImagenEstablecerIcono("LogoBlanco", 100, 100, logoBlanco);
        cargarImagenEstablecerIcono("Tienda1", 400, 400, tienda1);
        cargarImagenEstablecerIcono("Tienda2", 400, 400, tienda2);
        cargarImagenEstablecerIcono("Tienda3", 400, 400, tienda3);
        cargarImagenEstablecerIcono("Tienda4", 400, 400, tienda4);
        cargarImagenEstablecerIcono("Tienda5", 400, 400, tienda5);
        cargarImagenEstablecerIcono("Tienda6", 400, 400, tienda6);
        cargarImagenEstablecerIcono("Tienda7", 400, 400, tienda7);
        cargarImagenEstablecerIcono("Tienda8", 400, 400, tienda8);
        cargarImagenEstablecerIcono("Tienda9", 400, 400, tienda9);
        cargarImagenEstablecerIcono("Tienda10", 400, 400, tienda10);
        cargarImagenEstablecerIcono("Tienda11", 400, 400, tienda11);
        cargarImagenEstablecerIcono("Tienda12", 400, 400, tienda12);

        ImageIcon iconoBuy = ControladorImagenes.obtenerImagen("Buy", 50, 50);
        JButton[] botonesBuy = {bBuy1, bBuy2, bBuy3, bBuy4, bBuy5, bBuy6, bBuy7, bBuy8, bBuy9, bBuy10, bBuy11, bBuy12};
        for (JButton boton : botonesBuy) {
            boton.setIcon(iconoBuy);
        }

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Tienda");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bInicio, bSalir, bFacebook, bTwitter, bInstagram,
                bBuy1, bBuy2, bBuy3, bBuy4, bBuy5, bBuy6, bBuy7, bBuy8, bBuy9, bBuy10, bBuy11, bBuy12, ftThemadza};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        Color backgroundColor = Color.decode("#5B2C78");
        Color foregroundColor = Color.decode("#151135");

        JScrollBar verticalScrollBar = PanelMedio.getVerticalScrollBar();
        verticalScrollBar.setBackground(backgroundColor);
        verticalScrollBar.setForeground(foregroundColor);
        PanelMedio.getViewport().setBackground(backgroundColor);
        PanelMedio.setBackground(backgroundColor);
        ftThemadza.setBorder(BorderFactory.createEmptyBorder());

        setVisible(true);

        // Destruir la ventana anterior.
        ventanaEliminar.dispose();
    }

    /**
     * Método principal de la clase para iniciar la aplicación.
     * Crea una nueva instancia de VentanaTienda y la muestra en la interfaz gráfica.
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaTienda ventana = new VentanaTienda(null);
        });
    }

    // Funciones

    /**
     * Muestra un mensaje de confirmación de compra personalizado en la interfaz.
     * Este mensaje indica que un artículo ha sido añadido al carrito de compras.
     */
    public void mostrarMensajeBuy() {

        Font font = new Font("Arial", Font.BOLD, 20);
        String message = "Añadido al carrito.";

        // Creación del panel de mensaje personalizado
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo degradado
                GradientPaint gradientPaint = new GradientPaint(
                        0, 0, new Color(68, 1, 84), 0, getHeight(),
                        new Color(213, 113, 112));
                g2.setPaint(gradientPaint);
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Dibujar ícono de mensaje entrante
                int iconSize = 40;
                Icon incomingMessageIcon = UIManager.getIcon("OptionPane.informationIcon");
                if (incomingMessageIcon != null) {
                    incomingMessageIcon.paintIcon(this, g2, 20, (getHeight() - iconSize) / 2);
                }

                // Configurar fuente y color del texto
                g2.setFont(font);
                g2.setColor(Color.WHITE);

                // Dibujar el mensaje centrado
                FontMetrics metrics = g2.getFontMetrics(font);
                int x = 70; // Ajustar posición X para el texto
                int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g2.drawString(message, x, y);
            }
        };

        // Configuración del panel
        panel.setPreferredSize(new Dimension(400, 100));

        // Mostrar el JOptionPane personalizado
        JOptionPane.showMessageDialog(null, panel, "Aviso", JOptionPane.PLAIN_MESSAGE);

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
     * Carga una imagen y la establece como icono en un componente JButton con el tamaño especificado.
     * Si la imagen no se encuentra, imprime un mensaje de error en la consola.
     * @param nombreImagen El nombre de la imagen que se va a cargar.
     * @param ancho El ancho deseado para la imagen.
     * @param alto El alto deseado para la imagen.
     * @param label El JButton en el que se establecerá la imagen como icono.
     */
    private void cargarImagenEstablecerIconoBoton(String nombreImagen, int ancho, int alto, JButton label) {
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
    public void addBBuyAL(ActionListener al) {
        bBuy1.addActionListener(al);
        bBuy2.addActionListener(al);
        bBuy3.addActionListener(al);
        bBuy4.addActionListener(al);
        bBuy5.addActionListener(al);
        bBuy6.addActionListener(al);
        bBuy7.addActionListener(al);
        bBuy8.addActionListener(al);
        bBuy9.addActionListener(al);
        bBuy10.addActionListener(al);
        bBuy11.addActionListener(al);
        bBuy12.addActionListener(al);
    }
    public void addBThemadzaAL(ActionListener al) {
        ftThemadza.addActionListener(al);
    }
}

