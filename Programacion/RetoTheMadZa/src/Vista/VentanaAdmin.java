package Vista;

import Controlador.ControladoresVista.ControladorImagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase que representa la ventana principal del administrador del sistema.
 * Esta ventana proporciona acceso a diferentes funciones administrativas y muestra diferentes paneles para CRUD.
 * También incluye botones para navegar por la aplicación y enlaces a redes sociales.
 *
 * La ventana contiene un menú superior con opciones para administrar jornadas, equipos, jugadores, staff, patrocinadores,
 * juegos, competiciones y enfrentamientos. Además, permite generar archivos XML.
 * La ventana también incluye botones para inicio de sesión y para salir de la aplicación.
 *
 * Esta clase es una subclase de JFrame.
 *
 * @author Lorena, Ibai
 * @version 1.0
 */
public class VentanaAdmin extends JFrame {
    private JPanel panelUp;
    private JPanel PanelMenu;
    private JMenuBar mPrincipal;
    private JMenu mJornadas;
    private JMenu mEquipos;
    private JPanel PanelLogo;
    private JLabel ftThemadza;
    private JButton bInicio;
    private JButton bSalir;
    private JPanel PanelMedio;
    private JPanel panelCRUD;
    private JPanel panelFoot;
    private JButton bTwitter;
    private JButton bInstagram;
    private JButton bFacebook;
    private JLabel logoBlanco;
    private JPanel pPrincipal;
    private JMenu mJugadores;
    private JMenu mStaff;
    private JMenu mPatrocinadores;
    private JMenu mJuegos;
    private JMenu mCompeticiones;
    private JMenu mEnfrentamientos;
    private JMenuItem miEquipos;
    private JMenuItem miJugadores;
    private JMenuItem miStaff;
    private JMenuItem miPatrocinadores;
    private JMenuItem miJuegos;
    private JMenuItem miCompeticiones;
    private JMenuItem miEnfrentamientos;
    private JMenuItem miJornadas;
    private JMenuItem miVisualizarJornadas;
    private JMenuItem miClasificacionJornadas;
    private JLabel tfImagenLogo;
    private JPanel pImagenLogo;
    private JButton bInsertar;
    private JTextField tfDato1;
    private JLabel jlDato1;
    private JButton bEliminar;
    private JButton bActualizar;
    private JButton bConsultar;
    private JPanel pBotones;
    private JPanel pDatos;
    private JMenuItem mGenerarXml;
    private JMenuItem miVisualizarEquipos;
    private JMenu mUsuarios;
    private JMenuItem miUsuarios;

    // Declarar la clase para colocar elementos que se le aplicará a los JLabel y JTextField en el pDatos.
    private final GridBagConstraints gbc;

    // Configurar el tipo de fuente general, tamaño de los JTextField y color que tendrán.
    private final Font labelFont = new Font("Inter Semi Bold", Font.PLAIN, 26);
    private final Dimension textFieldSize = new Dimension(350, 38);
    private final Color labelColor = new Color(0xF9FBFF);

    // Nuevas casillas para el ID de la competición relacionado con el JCheckBox.
    private JTextField tfIdCompeticion;
    private JLabel jlIdCompeticion;

    // Lista para almacenar los JTextFields y poder obtenerlos desde el ControladorVAdmin.
    private ArrayList<JTextField> listaTextFieldsDinamicos;

    /**
     * Constructor de la clase `VentanaAdmin`.
     * Crea una instancia de la ventana de administrador, inicializando sus componentes y configurando su comportamiento.
     *
     * @param vis La ventana de inicio de sesión que debe ser destruida al abrir esta ventana.
     */
    public VentanaAdmin(VentanaInicioSesion vis){

        panelCRUD.setVisible(false);

        listaTextFieldsDinamicos = new ArrayList<>();

        // Configurar Layout del pDatos.
        pDatos.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 20, 0, 20);

        // Cargar las imágenes con un tamaño específico.
        cargarImagenEstablecerIcono("TheMadZaLogoSimple", 250, 250, ftThemadza);
        cargarImagenEstablecerIcono("Inicio", bInicio);
        cargarImagenEstablecerIcono("Salir", bSalir);
        cargarImagenEstablecerIcono("Twitter", bTwitter);
        cargarImagenEstablecerIcono("Instagram", bInstagram);
        cargarImagenEstablecerIcono("Facebook", bFacebook);
        cargarImagenEstablecerIcono("LogoBlanco", 100, 100, logoBlanco);
        cargarImagenEstablecerIcono("LogoColor", 650, 650, tfImagenLogo);

        // Configurar la ventana
        setContentPane(pPrincipal);
        setTitle("Ventana Administrador");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getRootPane().setDefaultButton(bInsertar);

        JComponent[] componentesConBorde = {mPrincipal, bInicio, bSalir, bFacebook, bTwitter, bInstagram};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        setVisible(true);

        // Destruir la ventana de inicio de sesión.
        vis.dispose();
    }

    /**
     * Método principal para ejecutar la ventana de administrador.
     * Crea una instancia de la ventana de administrador y la muestra.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaAdmin ventana = new VentanaAdmin(null);
        });
    }

    // Getters and Setters
    public JPanel getPanelCRUD() {
        return panelCRUD;
    }

    public void setPanelCRUD(JPanel panelCRUD) {
        this.panelCRUD = panelCRUD;
    }

    public JTextField getTfDato1() {
        return tfDato1;
    }

    public void setTfDato1(JTextField tfDato1) {
        this.tfDato1 = tfDato1;
    }

    public JLabel getJlDato1() {
        return jlDato1;
    }

    public void setJlDato1(String dato1) {
        this.jlDato1.setText(dato1);
    }

    public JPanel getpDatos() {
        return pDatos;
    }

    public void setpDatos(JPanel pDatos) {
        this.pDatos = pDatos;
    }

    public JButton getbInsertar() {
        return bInsertar;
    }

    public JButton getbActualizar() {
        return bActualizar;
    }

    public void addListaTextFieldsDinamicos(JTextField textField){
        listaTextFieldsDinamicos.add(textField);
    }

    public ArrayList<JTextField> getListaTextFieldsDinamicos() {
        return listaTextFieldsDinamicos;
    }

    // Listeners
    public void addMiCrudAL(ActionListener al) {
        miEquipos.addActionListener(al);
        miJugadores.addActionListener(al);
        miStaff.addActionListener(al);
        miPatrocinadores.addActionListener(al);
        miJuegos.addActionListener(al);
        miCompeticiones.addActionListener(al);
        miEnfrentamientos.addActionListener(al);
        miJornadas.addActionListener(al);
        miUsuarios.addActionListener(al);
    }
    public void addBAccionesAL(ActionListener al) {
        bInsertar.addActionListener(al);
        bEliminar.addActionListener(al);
        bActualizar.addActionListener(al);
        bConsultar.addActionListener(al);
    }
    public void addMiVisualizarEquiposAL(ActionListener al) {
        miVisualizarEquipos.addActionListener(al);
    }
    public void addMiVisualizarJornadasAL(ActionListener al) {
        miVisualizarJornadas.addActionListener(al);
    }
    public void addMiClasificacionJornadasAL(ActionListener al) {
        miClasificacionJornadas.addActionListener(al);
    }
    public void addMGenerarXmlAL(ActionListener al) {
        mGenerarXml.addActionListener(al);
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

    // Funciones

    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    /**
     * Muestra los datos relacionados con los equipos en el panel de datos.
     * Además, permite al usuario seleccionar si desea registrar el equipo en una competición.
     */
    public void mostrarDatosEquipos(){

        vaciarListaTextFields();

        // Agregar elementos al pDatos.

        agregarElemento("Nombre:", new JTextField(), gbc);

        //  Al darle al JCheckBox, aparecerá otro label y textfield para rellenar con el ID de la comp.
        //  Así no solo se podrá registrar el equipo "suelto", si no que también se podrá asociarlo a una competición.
        //  Al darle, también aparecerán los datos del equipo (a parte del nombre) si ya estaba registrado.
        //  Solo habrá que poner el nombre, seleccionar (o no) el CB, y continuar.
        //  Se buscarán los datos en la tabla EQUIPOS, y se insertarán en EQUIPOS y puede que en EQUIPOS_COMPETICIONES.

        // Crear y agregar el JCheckBox.
        JCheckBox cbRegistrarCompeticion = new JCheckBox("Quiero registrar el equipo en una competición.");
        cbRegistrarCompeticion.setFont(labelFont.deriveFont(22f));  // Fuente derivada con tamaño menor.
        cbRegistrarCompeticion.setForeground(labelColor);
        cbRegistrarCompeticion.setBackground(pDatos.getBackground());

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        pDatos.add(cbRegistrarCompeticion, gbc);
        gbc.gridwidth = 1;

        // Crear el campo del ID de la competición pero no agregarlo aún.
        jlIdCompeticion = new JLabel("ID de la competición:");
        jlIdCompeticion.setFont(labelFont);
        jlIdCompeticion.setForeground(labelColor);
        tfIdCompeticion = new JTextField();
        tfIdCompeticion.setPreferredSize(textFieldSize);
        tfIdCompeticion.setFont(labelFont);

        // Añadir listener para el JCheckBox.
        cbRegistrarCompeticion.addActionListener(e -> {

            if (cbRegistrarCompeticion.isSelected()) {
                gbc.gridx = 0;
                gbc.gridy++;
                pDatos.add(jlIdCompeticion, gbc);
                gbc.gridx = 1;
                pDatos.add(tfIdCompeticion, gbc);
                // Añadir a la lista la casilla del ID de la competición.
                addListaTextFieldsDinamicos(tfIdCompeticion);
            } else {
                pDatos.remove(jlIdCompeticion);
                pDatos.remove(tfIdCompeticion);
                // Eliminar de la lista la casilla del ID de la competición.
                listaTextFieldsDinamicos.remove(4);
            }
            pDatos.revalidate();
            pDatos.repaint();

        });

        agregarElemento("Fecha de fundación:", new JTextField(), gbc);
        agregarElemento("Logo:", new JTextField(), gbc);
        agregarElemento("Color:", new JTextField(), gbc);

    }

    /**
     * Muestra los datos relacionados con los jugadores en el panel de datos.
     * Los datos incluyen nombre, apodo, nacionalidad, rol, fecha de nacimiento, sueldo y ID del equipo.
     */
    public void mostrarDatosJugadores(){
        vaciarListaTextFields();
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("Nickname:", new JTextField(), gbc);
        agregarElemento("Nacionalidad:", new JTextField(), gbc);
        agregarElemento("Rol:", new JTextField(), gbc);
        agregarElemento("Fecha de nacimiento:", new JTextField(), gbc);
        agregarElemento("Sueldo:", new JTextField(), gbc);
        agregarElemento("ID de su equipo:", new JTextField(), gbc);
    }

    /**
     * Muestra los datos relacionados con el personal del equipo en el panel de datos.
     * Los datos incluyen puesto, nombre, fecha de nacimiento, sueldo y ID del equipo.
     */
    public void mostrarDatosStaff(){
        vaciarListaTextFields();
        agregarElemento("Puesto:", new JTextField(), gbc);
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("Fecha de nacimiento:", new JTextField(), gbc);
        agregarElemento("Sueldo:", new JTextField(), gbc);
        agregarElemento("ID de su equipo:", new JTextField(), gbc);
    }

    /**
     * Muestra los datos relacionados con los patrocinadores en el panel de datos.
     * Los datos incluyen nombre y ID del equipo.
     */
    public void mostrarDatosPatrocinadores(){
        vaciarListaTextFields();
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("ID de sus equipos:", new JTextField(), gbc);
    }

    /**
     * Muestra los datos relacionados con los juegos en el panel de datos.
     * Los datos incluyen nombre, empresa y fecha de lanzamiento.
     */
    public void mostrarDatosJuegos(){
        vaciarListaTextFields();
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("Empresa:", new JTextField(), gbc);
        agregarElemento("Fecha de lanzamiento:", new JTextField(), gbc);
    }

    /**
     * Muestra los datos relacionados con las competiciones en el panel de datos.
     * Los datos incluyen nombre, fecha de inicio, fecha de fin, estado de la etapa, ID del juego
     * y ID del equipo ganador (si lo hay).
     */
    public void mostrarDatosCompeticiones(){
        vaciarListaTextFields();
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("Fecha de inicio:", new JTextField(), gbc);
        agregarElemento("Fecha de fin:", new JTextField(), gbc);
        agregarElemento("Estado de la etapa:", new JTextField(), gbc);
        agregarElemento("ID de su juego:", new JTextField(), gbc);
        agregarElemento("ID del equipo ganador:", new JTextField(), gbc); // TODO : Puede ser null.
    }

    /**
     * Muestra los datos relacionados con los enfrentamientos en el panel de datos.
     * Los datos incluyen hora, resultado de los equipos, ID de los equipos y ID de la jornada.
     */
    public void mostrarDatosEnfrentamientos(){
        vaciarListaTextFields();
        agregarElemento("ID del enfrentamiento:", new JTextField(), gbc);
        agregarElemento("Hora:", new JTextField(), gbc);
        agregarElemento("Resultado del equipo 1:", new JTextField(), gbc);
        agregarElemento("Resultado del equipo 2:", new JTextField(), gbc);
        agregarElemento("ID del equipo 1:", new JTextField(), gbc);
        agregarElemento("ID del equipo 2:", new JTextField(), gbc);
        agregarElemento("ID de la jornada:", new JTextField(), gbc);
    }

    /**
     * Muestra los datos relacionados con las jornadas en el panel de datos.
     * Los datos incluyen número de jornada, fecha y ID de la competición.
     */
    public void mostrarDatosJornadas(){
        vaciarListaTextFields();
        agregarElemento("ID de jornada:", new JTextField(), gbc);
        agregarElemento("Número de jornada:", new JTextField(), gbc);
        agregarElemento("Fecha:", new JTextField(), gbc);
        agregarElemento("ID de la competición:", new JTextField(), gbc);
    }

    // TODO : JAVADOC
    public void mostrarDatosUsuarios(){
        vaciarListaTextFields();
        agregarElemento("Nombre de usuario:", new JTextField(), gbc);
        agregarElemento("Contraseña:", new JTextField(), gbc);
        agregarElemento("Tipo:", new JTextField(), gbc); // TODO : PONER COMO 2 CHECKBOX
    }

    /**
     * Vacía la lista de JTextField y el panel de datos.
     * Este método se utiliza para limpiar los campos de entrada de datos.
     */
    public void vaciarListaTextFields(){
        // Eliminar todos los elementos de la lista en donde se guardan los JTextField.
        listaTextFieldsDinamicos.clear();
        pDatos.removeAll();
        pDatos.revalidate();
        pDatos.repaint();
    }

    // Función para cargar imágenes y establecer íconos (una función es para los JLabel y la otra para los JButton)

    /**
     * Carga una imagen y la establece como ícono en un JLabel con el tamaño especificado.
     * Si la imagen no se encuentra, muestra un mensaje de error en la consola.
     * @param nombreImagen El nombre de la imagen a cargar.
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
     * Carga una imagen y la establece como ícono en un JButton con un tamaño predeterminado de 40x40 píxeles.
     * Si la imagen no se encuentra, muestra un mensaje de error en la consola.
     * @param nombreImagen El nombre de la imagen a cargar.
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

    /**
     * Agrega un elemento al panel de datos, que consiste en un JLabel y un JTextField con el texto y tamaño especificados.
     * Los elementos se colocan en la posición especificada por el GridBagConstraints.
     * Además, los JTextField se agregan a una lista para facilitar su acceso posteriormente desde el controlador.
     * @param labelText El texto del JLabel.
     * @param textField El JTextField.
     * @param gbc El GridBagConstraints que especifica la posición del elemento en el panel de datos.
     */
    private void agregarElemento(String labelText, JTextField textField, GridBagConstraints gbc) {
        // Configurar JLabel.
        JLabel label = new JLabel(labelText);
        label.setFont(labelFont);
        label.setForeground(labelColor);

        // Configurar JTextField.
        textField.setPreferredSize(textFieldSize);
        textField.setFont(labelFont);

        // Agregar al panel.
        gbc.gridx = 0;
        gbc.gridy++;
        pDatos.add(label, gbc);
        gbc.gridx = 1;
        pDatos.add(textField, gbc);

        // Añadirlos a la lista para luego poder obtenerlos desde el controlador.
        addListaTextFieldsDinamicos(textField);

        // Actualizar el panel
        pDatos.revalidate();
        pDatos.repaint();
    }
}
