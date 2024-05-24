package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * La clase VentanaXML representa la interfaz de usuario para visualizar y manipular archivos XML.
 * Proporciona opciones para seleccionar archivos XML, mostrar su contenido y copiar su estructura DTD o XSD.
 * Extiende la clase JFrame de Swing para crear una ventana de aplicación.
 * Utiliza un controlador de imágenes para cargar iconos y logotipos.
 * Esta clase incluye varios componentes Swing como botones, áreas de texto y menús.
 * Permite la interacción con el usuario a través de acciones de botón y menú.
 * Implementa métodos para cargar imágenes, añadir listeners y mostrar mensajes.
 *
 * @author Zahir
 * @version 1.0
 */
public class VentanaXML extends JFrame{
    private JPanel panelUp;
    private JPanel PanelMenu;
    private JMenuBar mPrincipal;
    private JMenuItem mJornadas;
    private JMenuItem mClasificacion;
    private JMenuItem mEquipos;
    private JPanel PanelLogo;
    private JButton ftThemadza;
    private JButton bInicio;
    private JButton bSalir;
    private JButton bTienda;
    private JPanel panelFoot;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JLabel logoBlanco;
    private JPanel PanelMedio;
    private JComboBox cbXMLSelec;
    private JPanel pborde;
    private JTextArea taXMLDTD;
    private JPanel pPrincipal;
    private JButton btCopiarDTD;
    private JTextArea taXMLXSD;
    private JButton btCopiarXSD;

    /**
     * Constructor de la clase VentanaXML.
     * Crea una nueva ventana de la interfaz de usuario para manipular archivos XML.
     * Carga y establece los iconos para varios botones de la interfaz gráfica.
     * Configura la apariencia y el comportamiento de la ventana.
     * Destruye la ventana anterior pasada como parámetro.
     *
     * @param ventanaEliminar La ventana anterior que se eliminará al crear esta nueva ventana.
     */
    public VentanaXML(JFrame ventanaEliminar) {

        cargarImagenEstablecerIconoBoton("TheMadZaLogoSimple", 250, 250, ftThemadza);
        cargarImagenEstablecerIcono("Tienda", bTienda);
        cargarImagenEstablecerIcono("Inicio", bInicio);
        cargarImagenEstablecerIcono("Salir", bSalir);
        cargarImagenEstablecerIcono("Twitter", bTwitter);
        cargarImagenEstablecerIcono("Instagram", bInstagram);
        cargarImagenEstablecerIcono("Facebook", bFacebook);
        cargarImagenEstablecerIcono("LogoBlanco", 100, 100, logoBlanco);

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Clasificación");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInicio);

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, bFacebook,
                bTwitter, bInstagram};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        setVisible(true);

        // Destruir la ventana anterior.
        ventanaEliminar.dispose();
    }

    /**
     * Método principal de la clase VentanaXML.
     * Crea una instancia de VentanaXML y la muestra en el hilo de eventos de Swing.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaClasificacion ventana = new VentanaClasificacion(null);
        });
    }

    // Funciones

    /**
     * Carga una imagen y la establece como icono para un JLabel.
     *
     * @param nombreImagen El nombre de la imagen a cargar.
     * @param ancho        El ancho deseado para la imagen.
     * @param alto         El alto deseado para la imagen.
     * @param label        El JLabel al que se le establecerá el icono.
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
     * Carga una imagen y la establece como icono para un JButton.
     *
     * @param nombreImagen El nombre de la imagen a cargar.
     * @param button       El JButton al que se le establecerá el icono.
     */
    private void cargarImagenEstablecerIcono(String nombreImagen, JButton button) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, 40, 40);
        if (icono != null) {
            button.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

    public JMenuBar getmPrincipal() {
        return mPrincipal;
    }

    public void setmPrincipal(JMenuBar mPrincipal) {
        this.mPrincipal = mPrincipal;
    }

    public JMenuItem getmJornadas() {
        return mJornadas;
    }

    public void setmJornadas(JMenuItem mJornadas) {
        this.mJornadas = mJornadas;
    }

    public JMenuItem getmClasificacion() {
        return mClasificacion;
    }

    public void setmClasificacion(JMenuItem mClasificacion) {
        this.mClasificacion = mClasificacion;
    }

    public JMenuItem getmEquipos() {
        return mEquipos;
    }

    public void setmEquipos(JMenuItem mEquipos) {
        this.mEquipos = mEquipos;
    }

    public JButton getFtThemadza() {
        return ftThemadza;
    }

    public void setFtThemadza(JButton ftThemadza) {
        this.ftThemadza = ftThemadza;
    }

    public JButton getbInicio() {
        return bInicio;
    }

    public void setbInicio(JButton bInicio) {
        this.bInicio = bInicio;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }

    public JButton getbTienda() {
        return bTienda;
    }

    public void setbTienda(JButton bTienda) {
        this.bTienda = bTienda;
    }

    public JButton getbTwitter() {
        return bTwitter;
    }

    public void setbTwitter(JButton bTwitter) {
        this.bTwitter = bTwitter;
    }

    public JButton getbInstagram() {
        return bInstagram;
    }

    public void setbInstagram(JButton bInstagram) {
        this.bInstagram = bInstagram;
    }

    public JButton getbFacebook() {
        return bFacebook;
    }

    public void setbFacebook(JButton bFacebook) {
        this.bFacebook = bFacebook;
    }

    public JComboBox getCbXMLSelec() {
        return cbXMLSelec;
    }

    public void setCbXMLSelec(JComboBox cbXMLSelec) {
        this.cbXMLSelec = cbXMLSelec;
    }

    public JTextArea getTaXMLXSD() {
        return taXMLXSD;
    }

    public void setTaXMLXSD(JTextArea taXMLXSD) {
        this.taXMLXSD = taXMLXSD;
    }

    public JTextArea getTaXMLDTD() {
        return taXMLDTD;
    }

    public void setTaXMLDTD(JTextArea taXMLDTD) {
        this.taXMLDTD = taXMLDTD;
    }

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

    public void addXML(ActionListener al){
        cbXMLSelec.addActionListener(al);
    }
    public void addbtXSD(ActionListener al){
        btCopiarXSD.addActionListener(al);
    }
    public void addbtDTD(ActionListener al){
        btCopiarDTD.addActionListener(al);
    }

    /**
     * Muestra un mensaje de diálogo emergente con el mensaje especificado.
     *
     * @param mensaje El mensaje a mostrar en el diálogo.
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    /**
     * Carga una imagen y la establece como icono para un JButton.
     *
     * @param nombreImagen El nombre de la imagen a cargar.
     * @param ancho        El ancho deseado para la imagen.
     * @param alto         El alto deseado para la imagen.
     * @param label       El JButton al que se le establecerá el icono.
     */
    private void cargarImagenEstablecerIconoBoton(String nombreImagen, int ancho, int alto, JButton label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

}
