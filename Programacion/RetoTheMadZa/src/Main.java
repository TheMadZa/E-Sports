import Controlador.Automatizacion.Scheduler;
import Controlador.ControladorPrincipal;

/**
 * Clase Main que ejecutará el programa al completo.
 * Contiene el código para ejecutar el controlador principal y la Automatizacion.
 *
 * @author Ibai
 * @author Lorena
 * @author Julen
 * @author Zahir
 * @version 1.0 24/05/2024
 */
public class Main {

    /**
     * Punto de entrada principal del programa.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa)
     */
    public static void main(String[] args) {

        ControladorPrincipal c = new ControladorPrincipal();


        Scheduler.startScheduledTask();

    }
}