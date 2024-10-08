package utils.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class ColoredConsoleFormatter extends Formatter {

    // Definimos los códigos ANSI para los colores
    public static final String RESET = "\u001B[0m"; // Reset
    public static final String RED = "\u001B[31m";  // Rojo
    public static final String YELLOW = "\u001B[33m"; // Amarillo
    public static final String WHITE = "\u001B[37m";  // Blanco

    @Override
    public String format(LogRecord record) {
        String color;

        // Seleccionamos el color basado en el nivel del log
        if (record.getLevel().equals(Level.SEVERE)) {
            color = RED;
        } else if (record.getLevel().equals(Level.WARNING)) {
            color = YELLOW;
        } else {
            color = WHITE;
        }

        // Formateamos la fecha y la clase de procedencia del log
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis()));
        String className = record.getSourceClassName();

        // Formateamos el mensaje con color
        return color + "[" + timestamp + "] [" + className + "] " + formatMessage(record) + RESET + "\n";
    }

    public static void setupLogger(Logger logger) {
        // Configuramos el logger para usar nuestra clase de formato de consola con colores
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new ColoredConsoleFormatter());
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false); // Evitar que los mensajes aparezcan dos veces
    }
}
