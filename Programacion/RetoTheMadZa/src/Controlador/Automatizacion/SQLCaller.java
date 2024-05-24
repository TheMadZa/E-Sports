package Controlador.Automatizacion;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase Complementaria Para Automatizar
 * La clase SQLCaller se encarga de llamar a funciones SQL simuladas y crear archivos XML en el escritorio del usuario.
 *
 * @author zahir
 */
public class SQLCaller {

    /**
     * Llama a una función SQL simulada según el tipo especificado y crea archivos XML en el escritorio del usuario.
     *
     * @param type el tipo de función SQL a llamar, puede ser "Clasificacion", "Jornadas" o "UltimaJornada".
     */
    public static void callSQLFunctionAndCreateXML(String type) {
        try {
            String resultDTD = "";
            String resultXSD = "";
            switch (type) {
                case "Clasificacion":
                    resultDTD = obtenerXMLClasificacionDTD();
                    resultXSD = obtenerXMLClasificacionXSD();
                    break;
                case "Jornadas":
                    resultDTD = obtenerXMLJornadasDTD();
                    resultXSD = obtenerXMLJornadasXSD();
                    break;
                case "UltimaJornada":
                    resultDTD = obtenerXMLUltimaJornadaDTD();
                    resultXSD = obtenerXMLUltimaJornadaXSD();
                    break;
                default:
                    throw new IllegalArgumentException("Tipo desconocido: " + type);
            }

            // Crear archivos XML en el escritorio
            saveToDesktop(type + "_DTD.xml", resultDTD);
            saveToDesktop(type + "_XSD.xml", resultXSD);

        } catch (Exception ex) {
            ex.printStackTrace();
            SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Error al obtener XML: " + ex.getMessage()));
        }
    }

    /**
     * Guarda el contenido especificado en un archivo en el escritorio del usuario dentro de un directorio con marca temporal.
     *
     * @param fileName el nombre del archivo a guardar.
     * @param content el contenido a escribir en el archivo.
     * @throws IOException si ocurre un error al escribir el archivo.
     */
    private static void saveToDesktop(String fileName, String content) throws IOException {
        // Obtener la ruta del escritorio del usuario y crear el directorio zaXML con la fecha y hora
        Path desktopDir = Paths.get(System.getProperty("user.home"), "Desktop", "zaXML");

        // Obtener la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = now.format(formatter);

        // Crear un nuevo subdirectorio con la fecha y hora actual
        Path timestampDir = desktopDir.resolve(formattedDateTime);
        if (!Files.exists(timestampDir)) {
            Files.createDirectories(timestampDir);
        }

        // Escribir el contenido en el archivo dentro del subdirectorio
        Path filePath = timestampDir.resolve(fileName);
        Files.write(filePath, content.getBytes());
    }

    // Métodos para obtener XML (simulación)

    /**
     * Obtiene un XML simulado para la clasificación en formato DTD.
     *
     * @return una cadena con el XML simulado de clasificación en DTD.
     */
    public static String obtenerXMLClasificacionDTD() {
        return "<Clasificacion>DTD Clasificacion</Clasificacion>";
    }

    /**
     * Obtiene un XML simulado para la clasificación en formato XSD.
     *
     * @return una cadena con el XML simulado de clasificación en XSD.
     */
    public static String obtenerXMLClasificacionXSD() {
        return "<Clasificacion>XSD Clasificacion</Clasificacion>";
    }

    /**
     * Obtiene un XML simulado para las jornadas en formato DTD.
     *
     * @return una cadena con el XML simulado de jornadas en DTD.
     */
    public static String obtenerXMLJornadasDTD() {
        return "<Jornadas>DTD Jornadas</Jornadas>";
    }

    /**
     * Obtiene un XML simulado para las jornadas en formato XSD.
     *
     * @return una cadena con el XML simulado de jornadas en XSD.
     */
    public static String obtenerXMLJornadasXSD() {
        return "<Jornadas>XSD Jornadas</Jornadas>";
    }

    /**
     * Obtiene un XML simulado para la última jornada en formato DTD.
     *
     * @return una cadena con el XML simulado de la última jornada en DTD.
     */
    public static String obtenerXMLUltimaJornadaDTD() {
        return "<UltimaJornada>DTD Ultima Jornada</UltimaJornada>";
    }

    /**
     * Obtiene un XML simulado para la última jornada en formato XSD.
     *
     * @return una cadena con el XML simulado de la última jornada en XSD.
     */
    public static String obtenerXMLUltimaJornadaXSD() {
        return "<UltimaJornada>XSD Ultima Jornada</UltimaJornada>";
    }
}

