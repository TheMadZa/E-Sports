package Controlador.ControladoresVista;

import Controlador.ControladoresBD.ControladorModelo;
import Modelo.Equipo;
import Vista.VentanaCarga;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase ControladorImagenes para cargar las imágenes.
 * Gestiona la carga inicial de todas las imágenes del proyecto.
 *
 * @author Ibai
 */
public class ControladorImagenes {
    private ControladorModelo cm;
    private VentanaCarga vc;
    private static Map<String, BufferedImage> imagenes = new HashMap<>();

    public ControladorImagenes(ControladorModelo cm) {
        this.cm = cm;
    }

    public void cargarImagenes() {
        vc = new VentanaCarga();
        vc.setVisible(true);

        System.out.println("Cargando todas las imágenes al inicio...");
        cargarImagenLocal("TheMadZaLogoSimple", "/Vista/Imagenes/logos/TheMadZaLogoSimple.png");
        cargarImagenLocal("Tienda", "/Vista/Imagenes/Botones/tienda.png");
        cargarImagenLocal("Inicio", "/Vista/Imagenes/Botones/inicio.png");
        cargarImagenLocal("Salir", "/Vista/Imagenes/Botones/powerOff.png");
        cargarImagenLocal("Twitter", "/Vista/Imagenes/RRSS/TwitterLogo.png");
        cargarImagenLocal("Instagram", "/Vista/Imagenes/RRSS/InstagramLogo.png");
        cargarImagenLocal("Facebook", "/Vista/Imagenes/RRSS/FacebookLogo.png");
        cargarImagenLocal("LogoBlanco", "/Vista/Imagenes/logos/SoloBlanco.png");

        // Cargar array de URLs
        String[] urlsNoticias = {
                "/Vista/Imagenes/Noticias/noticia1.png",
                "/Vista/Imagenes/Noticias/noticia2.png",
                "/Vista/Imagenes/Noticias/noticia3.png",
                "/Vista/Imagenes/Noticias/noticia4.png",
                "/Vista/Imagenes/Noticias/noticia5.png",
                "/Vista/Imagenes/Noticias/noticia6.png",
                "/Vista/Imagenes/Noticias/noticia7.png"
        };

        cargarImagenesDesdeArrayLocal("Noticias", urlsNoticias);

        cargarImagenLocal("Tienda1", "/Vista/Imagenes/Tienda/camiseta1.png");
        cargarImagenLocal("Tienda2", "/Vista/Imagenes/Tienda/mochilas.png");
        cargarImagenLocal("Tienda3", "/Vista/Imagenes/Tienda/botellas.png");
        cargarImagenLocal("Tienda4", "/Vista/Imagenes/Tienda/zapatilla1.png");
        cargarImagenLocal("Tienda5", "/Vista/Imagenes/Tienda/boxers.png");
        cargarImagenLocal("Tienda6", "/Vista/Imagenes/Tienda/raton.png");
        cargarImagenLocal("Tienda7", "/Vista/Imagenes/Tienda/bikini.png");
        cargarImagenLocal("Tienda8", "/Vista/Imagenes/Tienda/calcetines.png");
        cargarImagenLocal("Tienda9", "/Vista/Imagenes/Tienda/chaqueta.png");
        cargarImagenLocal("Tienda10", "/Vista/Imagenes/Tienda/gorra.png");
        cargarImagenLocal("Tienda11", "/Vista/Imagenes/Tienda/guantes.png");
        cargarImagenLocal("Tienda12", "/Vista/Imagenes/Tienda/pantalon.png");
        cargarImagenLocal("Buy", "/Vista/Imagenes/Tienda/buy.png");

        cargarImagenLocal("LogoColor", "/Vista/Imagenes/logos/TheMadZaLogoSoloNegro.png");
        cargarImagenLocal("TheMadZaLogoColor", "/Vista/Imagenes/logos/TheMadZaLogoColor.png");

        //Equipos
        cargarEquiposDesdeBD();

        //Flechas
        cargarImagenLocal("FlechaIzq","/Vista/Imagenes/Botones/flechaIzquierda.png");
        cargarImagenLocal("flechaDrch","/Vista/Imagenes/Botones/flechaDerecha.png");

        System.out.println("Todas las imágenes han sido cargadas.");
        vc.setVisible(false);

    }

    public  void cargarImagen(String nombre, String urlStr) {
        try {
            System.out.println("Intentando cargar la imagen: " + nombre + " desde " + urlStr);
            URL imageUrl = new URL(urlStr);
            BufferedImage imagenOriginal = ImageIO.read(imageUrl);
            if (imagenOriginal == null) {
                throw new RuntimeException("No se pudo cargar la imagen de: " + urlStr);
            }
            imagenes.put(nombre, imagenOriginal);
            System.out.println("Imagen cargada y almacenada correctamente: " + nombre);
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + nombre);
            e.printStackTrace();
        }
    }

    public void cargarImagenLocal(String nombre, String path) {
        try {
            System.out.println("Intentando cargar la imagen: " + nombre + " desde " + path);
            InputStream imageStream = getClass().getResourceAsStream(path);
            if (imageStream == null) {
                throw new RuntimeException("No se pudo encontrar la imagen en el path: " + path);
            }
            BufferedImage imagenOriginal = ImageIO.read(imageStream);
            if (imagenOriginal == null) {
                throw new RuntimeException("No se pudo cargar la imagen de: " + path);
            }
            imagenes.put(nombre, imagenOriginal);
            System.out.println("Imagen cargada y almacenada correctamente: " + nombre);
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + nombre);
            e.printStackTrace();
        }
    }

    private void cargarImagenesDesdeArray(String baseNombre, String[] urls) {
        for (int i = 0; i < urls.length; i++) {
            cargarImagen(baseNombre + i, urls[i]);
        }
    }

    private void cargarImagenesDesdeArrayLocal(String baseNombre, String[] urls) {
        for (int i = 0; i < urls.length; i++) {
            cargarImagenLocal(baseNombre + i, urls[i]);
        }
    }

    public static ImageIcon obtenerImagen(String nombre, int width, int height) {
        if (!imagenes.containsKey(nombre)) {
            System.err.println("Imagen no encontrada: " + nombre);
            return null;
        }
        BufferedImage imagenOriginal = imagenes.get(nombre);
        BufferedImage imagenEscalada = Scalr.resize(imagenOriginal, Scalr.Method.QUALITY, width, height);
        return new ImageIcon(imagenEscalada);
    }

    public  ImageIcon obtenerImagen(String nombre) {
        if (!imagenes.containsKey(nombre)) {
            System.err.println("Imagen no encontrada: " + nombre);
            return null;
        }
        return new ImageIcon(imagenes.get(nombre));
    }

    public static BufferedImage obtenerImagen2(String nombre) {
        return imagenes.get(nombre);
    }

    public void cargarEquiposDesdeBD() {

        try {
            List<Equipo> listaEquipos = cm.cargarEquiposDesdeBD(); // Obtener todos los equipos de la base de datos
            for (Equipo equipo : listaEquipos) {
                cargarImagen("Equipo" + equipo.getIdEquipo(), equipo.getLogo()); // Cargar la imagen del equipo
                System.out.println("Cargada imagen del equipo: " + equipo.getNomEquipo());
            }
        }
        catch (Exception e) {
            System.err.println("Error al cargar los equipos desde la base de datos: " + e.getMessage());
        }
    }
}