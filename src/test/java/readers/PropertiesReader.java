package readers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    Properties loadProperties() {
        Properties properties = new Properties();

        // Utilizando try-with-resources para manejar el recurso automáticamente
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("data.properties")) {

            if (input == null) {
                throw new IllegalArgumentException("Archivo data.properties no encontrado.");
            }

            properties.load(input);
            return properties;
        } catch (IOException e) {
            // Manejo del error con un logger y un mensaje claro
            throw new IllegalArgumentException("Failed to load properties file.", e);
        }
    }

    public String getProperty(String key) {
        String property = loadProperties().getProperty(key);

        if (property == null) {
            throw new IllegalArgumentException("Clave " + key + " no encontrada.");
        }

        return property;
    }
}