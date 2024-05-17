package Controlador.ControladoresVista;

import Vista.VentanaAdmin;
import Vista.VentanaCarga;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ControladorImagenes {
    private static VentanaCarga vc;

    private static Map<String, BufferedImage> imagenes = new HashMap<>();

    public static void cargarImagenes() {
        vc = new VentanaCarga();
        vc.setVisible(true);

        System.out.println("Cargando todas las imágenes al inicio...");
        cargarImagen("TheMadZaLogoSimple", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/TheMadZaLogoSimple.png?raw=true");
        cargarImagen("Tienda", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/tienda.png?raw=true");
        cargarImagen("Inicio", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/inicio.png?raw=true");
        cargarImagen("Salir", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/powerOff.png?raw=true");
        cargarImagen("Equipo1", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/faze-clan-logo.png?raw=true");
        cargarImagen("Equipo2", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/fnatic-logo.png?raw=true");
        cargarImagen("Twitter", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/TwitterLogo.png?raw=true");
        cargarImagen("Instagram", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/InstagramLogo.png?raw=true");
        cargarImagen("Facebook", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/FacebookLogo.png?raw=true");
        cargarImagen("LogoBlanco", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/SoloBlanco.png?raw=true");

        // Cargar array de URLs
        String[] urlsNoticias = {
                "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Noticias/0b9235b8-f812-4629-8c04-e9a5d874134b.png?raw=true",
                "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Noticias/84752ff3-2cd1-465d-832a-c661bb701549.png?raw=true",
                "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Noticias/ba6db8a3-4203-42a0-a5f2-4075bd89e161.png?raw=true",
                "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Noticias/ed187317-1ef3-49a0-86b1-d5387a83ccca.png?raw=true",
                "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Noticias/mano.png?raw=true"
        };

        cargarImagenesDesdeArray("Noticias", urlsNoticias);

        cargarImagen("Tienda1", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/camiseta1.png?raw=true");
        cargarImagen("Tienda2", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/mochilas.png?raw=true");
        cargarImagen("Tienda3", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/botellas.png?raw=true");
        cargarImagen("Tienda4", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/zapatilla1.png?raw=true");
        cargarImagen("Tienda5", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/boxers.png?raw=true");
        cargarImagen("Tienda6", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/raton.png?raw=true");
        cargarImagen("Tienda7", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/bikini.png?raw=true");
        cargarImagen("Tienda8", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/calcetines.png?raw=true");
        cargarImagen("Tienda9", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/chaqueta.png?raw=true");
        cargarImagen("Tienda10", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/gorra.png?raw=true");
        cargarImagen("Tienda11", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/guantes.png?raw=true");
        cargarImagen("Tienda12", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/pantalon.png?raw=true");
        cargarImagen("Buy", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/Tienda/buy.png?raw=true");

        cargarImagen("LogoColor", "https://github.com/IbaiSaenzDeBuruaga/E-SportsLogos/blob/main/RRSS/TheMadZaLogoSoloNegro.png?raw=true");

        System.out.println("Todas las imágenes han sido cargadas.");
        vc.setVisible(false);

    }

    private static void cargarImagen(String nombre, String urlStr) {
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

    private static void cargarImagenesDesdeArray(String baseNombre, String[] urls) {
        for (int i = 0; i < urls.length; i++) {
            cargarImagen(baseNombre + i, urls[i]);
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

    public static ImageIcon obtenerImagen(String nombre) {
        if (!imagenes.containsKey(nombre)) {
            System.err.println("Imagen no encontrada: " + nombre);
            return null;
        }
        return new ImageIcon(imagenes.get(nombre));
    }
}
