package utils.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    static {
        // Configuramos el logger para usar el formateador de colores
        ColoredConsoleFormatter.setupLogger(logger);
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void logError(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static void logException(String message, Exception e) {
        logger.log(Level.SEVERE, message, e);
    }
}
