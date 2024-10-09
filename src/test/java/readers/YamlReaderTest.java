package readers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class YamlReaderTest {

    @Test
    public void testGetEnvDefault() {
        YamlReader yamlReader = new YamlReader();
        String envUrl = yamlReader.getEnv();
        assertEquals("https://opensource-demo.orangehrmlive.com/", envUrl, "La URL debe coincidir con el perfil 'prod'");
    }

    @Test
    public void testGetEnvProd() {
        YamlReader yamlReader = new YamlReader();
        String envUrl = yamlReader.getEnvForTest("prod");
        assertEquals("https://opensource-demo.orangehrmlive.com/", envUrl, "La URL debe coincidir con el perfil 'prod'");
    }

    @Test
    public void testGetEnvQa() {
        YamlReader yamlReader = new YamlReader();
        String envUrl = yamlReader.getEnvForTest("qa");
        assertEquals("https://opensource-demo-qa.orangehrmlive.com/", envUrl, "La URL debe coincidir con el perfil 'prod'");
    }

    @Test
    public void testGetEnvDev() {
        YamlReader yamlReader = new YamlReader();
        String envUrl = yamlReader.getEnvForTest("dev");
        assertEquals("https://opensource-demo-dev.orangehrmlive.com/", envUrl, "La URL debe coincidir con el perfil 'prod'");
    }

    @Test
    public void testGetEnvWithMissingUrlForActiveProfile() {
        YamlReader yamlReader = new YamlReader();

        // Verifica que se lance una excepción al usar un perfil no existente.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            yamlReader.getEnvForTest("anyProfile");
        });

        // Verifica el mensaje de la excepción.
        assertEquals("Configuración para el perfil activo no encontrada.", exception.getMessage());
    }
}
