package Controlador.Automatizacion;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Clase para Automatizar
 * La clase Scheduler se encarga de programar y ejecutar tareas de manera periódica utilizando un
 * ScheduledExecutorService.
 *
 * @author zahir
 */

public class Scheduler {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    /**
     * Inicia la tarea programada que llama a varias funciones SQL y crea archivos XML.
     * La tarea se ejecuta inmediatamente y luego se repite cada 7 días.
     */
    public static void startScheduledTask() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                SQLCaller.callSQLFunctionAndCreateXML("Clasificacion");
                SQLCaller.callSQLFunctionAndCreateXML("Jornadas");
                SQLCaller.callSQLFunctionAndCreateXML("UltimaJornada");
            }
        };

        // Programa la tarea para que se ejecute cada 7 días
        scheduler.scheduleAtFixedRate(task, 0, 7, TimeUnit.DAYS);
    }

}
