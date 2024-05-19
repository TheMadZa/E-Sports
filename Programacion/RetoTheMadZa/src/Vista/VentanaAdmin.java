package Vista;

import Controlador.ControladoresVista.ControladorImagenes;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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
    private JButton bTienda;
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

    // Declarar la clase para colocar elementos que se le aplicará a los JLabel y JTextField en el pDatos.
    private final GridBagConstraints gbc;

    // Configurar el tipo de fuente general, tamaño de los JTextField y color que tendrán.
    private final Font labelFont = new Font("Inter Semi Bold", Font.PLAIN, 26);
    private final Dimension textFieldSize = new Dimension(350, 38);
    private final Color labelColor = new Color(0xF9FBFF);

    // Nuevas casillas para el ID de la competición relacionado con el JCheckBox.
    private JTextField tfIdCompeticion;
    private JLabel jlIdCompeticion;

    public VentanaAdmin(VentanaInicioSesion vis){

        panelCRUD.setVisible(false);

        // Configurar Layout del pDatos.
        pDatos.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 20, 0, 20);

        // Cargar las imágenes con un tamaño específico.
        cargarImagenEstablecerIcono("TheMadZaLogoSimple", 250, 250, ftThemadza);
        cargarImagenEstablecerIcono("Tienda", bTienda);
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

        JComponent[] componentesConBorde = {mPrincipal, bTienda, bInicio, bSalir, bFacebook, bTwitter, bInstagram};
        for (JComponent componente : componentesConBorde) {
            componente.setBorder(BorderFactory.createEmptyBorder());
        }

        setVisible(true);

        // Destruir la ventana de inicio de sesión.
        vis.dispose();
    }

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
    }
    public void addBAccionesAL(ActionListener al) {
        bInsertar.addActionListener(al);
        bEliminar.addActionListener(al);
        bActualizar.addActionListener(al);
        bConsultar.addActionListener(al);
    }
    public void addMiVisualizarJornadasAL(ActionListener al) {
        miVisualizarJornadas.addActionListener(al);
    }
    public void addMiClasificacionJornadasAL(ActionListener al) {
        miClasificacionJornadas.addActionListener(al);
    }

    // Funciones

    public void mostrarDatosEquipos(){

        // Agregar elementos al pDatos.

        agregarElemento("Nombre:", new JTextField(), gbc);

        //  Al darle al JCheckBox, aparecerá otro label y textfield para rellenar con el ID de la comp.
        //  Así no solo se podrá registrar el equipo "suelto", si no que también se podrá asociarlo a una competición.
        //  Al darle, también aparecerán los datos del equipo (a parte del nombre) si ya estaba registrado.
        //  Solo habrá que poner en nombre, seleccionar (o no) el CB, y continuar.
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
            } else {
                pDatos.remove(jlIdCompeticion);
                pDatos.remove(tfIdCompeticion);
            }
            pDatos.revalidate();
            pDatos.repaint();

        });

        agregarElemento("Fecha de fundación:", new JTextField(), gbc);
        agregarElemento("Logo:", new JTextField(), gbc);
        agregarElemento("Color:", new JTextField(), gbc);

    }

    public void mostrarDatosJugadores(){
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("Nickname:", new JTextField(), gbc);
        agregarElemento("Nacionalidad:", new JTextField(), gbc);
        agregarElemento("Rol:", new JTextField(), gbc);
        agregarElemento("Fecha de nacimiento:", new JTextField(), gbc);
        agregarElemento("Sueldo:", new JTextField(), gbc);
        agregarElemento("ID de su equipo:", new JTextField(), gbc);
    }

    public void mostrarDatosStaff(){
        agregarElemento("Puesto:", new JTextField(), gbc);
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("Fecha de nacimiento:", new JTextField(), gbc);
        agregarElemento("Sueldo:", new JTextField(), gbc);
        agregarElemento("ID de su equipo:", new JTextField(), gbc);
    }

    public void mostrarDatosPatrocinadores(){
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("ID de su equipo:", new JTextField(), gbc);
        // TODO : Puede patrocinar más de un equipo. Así que puede que solo habría que añadirlo a PATROCINADORES_EQUIPOS (o sea que no hay que insertar un nuevo patrocinador, ya que ese ya existe).
    }

    public void mostrarDatosJuegos(){
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("Empresa:", new JTextField(), gbc);
        agregarElemento("Fecha de lanzamiento:", new JTextField(), gbc);
    }

    public void mostrarDatosCompeticiones(){
        agregarElemento("Nombre:", new JTextField(), gbc);
        agregarElemento("Fecha de inicio:", new JTextField(), gbc);
        agregarElemento("Fecha de fin:", new JTextField(), gbc);
        agregarElemento("Estado de la etapa:", new JTextField(), gbc);
        agregarElemento("ID de su juego:", new JTextField(), gbc);
        agregarElemento("ID del equipo ganador:", new JTextField(), gbc); // TODO : Puede ser null.
    }

    public void mostrarDatosEnfrentamientos(){
        agregarElemento("Hora:", new JTextField(), gbc);
        agregarElemento("Resultado del equipo 1:", new JTextField(), gbc);
        agregarElemento("Resultado del equipo 2:", new JTextField(), gbc);
        agregarElemento("ID del equipo 1:", new JTextField(), gbc);
        agregarElemento("ID del equipo 2:", new JTextField(), gbc);
        agregarElemento("ID de la jornada:", new JTextField(), gbc);
    }

    public void mostrarDatosJornadas(){
        agregarElemento("Número de jornada:", new JTextField(), gbc);
        agregarElemento("Fecha:", new JTextField(), gbc);
        agregarElemento("ID de la competición:", new JTextField(), gbc);
    }

    // Función para cargar imágenes y establecer íconos (una función es para los JLabel y la otra para los JButton)
    private void cargarImagenEstablecerIcono(String nombreImagen, int ancho, int alto, JLabel label) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }
    private void cargarImagenEstablecerIcono(String nombreImagen, JButton button) {
        ImageIcon icono = ControladorImagenes.obtenerImagen(nombreImagen, 40, 40);
        if (icono != null) {
            button.setIcon(icono);
        } else {
            System.err.println("La imagen " + nombreImagen + " no se encontró.");
        }
    }

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

        // Actualizar el panel
        pDatos.revalidate();
        pDatos.repaint();
    }
}
