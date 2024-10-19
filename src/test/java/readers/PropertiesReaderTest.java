package readers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PropertiesReaderTest {

    @Test
    public void testGetPasswordDefault() {
        PropertiesReader properties = new PropertiesReader();
        String currentPassword = properties.getProperty("password");
        assertEquals("mi_contrasena_segura", currentPassword, "");
    }

    @Test
    public void testGetPropertyUndefined() {
        PropertiesReader properties = new PropertiesReader();
        String key = "anyProfile";

        // Verifica que se lance una excepción al usar una clave no existente.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            properties.getProperty(key);
        });

        // Verifica el mensaje de la excepción.
        assertEquals("Clave " + key + " no encontrada.", exception.getMessage());
    }
}