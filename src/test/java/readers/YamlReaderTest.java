package readers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YamlReaderTest {

    @Test
    public void testGetEnvironmentDefault() {
        YamlReader yamlReader = new YamlReader();
        String envUrl = yamlReader.getEnvironment();
        assertEquals("https://opensource-demo.orangehrmlive.com/", envUrl, "La URL debe coincidir con el perfil 'prod'");
    }

    @Test
    public void testGetEnvironmentProd() {
        YamlReader yamlReader = new YamlReader();
        String envUrl = yamlReader.getEnvForTest("prod");
        assertEquals("https://opensource-demo.orangehrmlive.com/", envUrl, "La URL debe coincidir con el perfil 'prod'");
    }

    @Test
    public void testGetEnvironmentQa() {
        YamlReader yamlReader = new YamlReader();
        String envUrl = yamlReader.getEnvForTest("qa");
        assertEquals("https://opensource-demo-qa.orangehrmlive.com/", envUrl, "La URL debe coincidir con el perfil 'prod'");
    }

    @Test
    public void testGetEnvironmentDev() {
        YamlReader yamlReader = new YamlReader();
        String envUrl = yamlReader.getEnvForTest("dev");
        assertEquals("https://opensource-demo-dev.orangehrmlive.com/", envUrl, "La URL debe coincidir con el perfil 'prod'");
    }

    @Test
    public void testGetEnvironmentWithMissingUrlForActiveProfile() {
        YamlReader yamlReader = new YamlReader();

        // Verifica que se lance una excepción al usar un perfil no existente.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            yamlReader.getEnvForTest("anyProfile");
        });

        // Verifica el mensaje de la excepción.
        assertEquals("Configuración para el perfil activo no encontrada.", exception.getMessage());
    }

    @Test
    public void testGetBrowserNameDefault() {
        YamlReader yamlReader = new YamlReader();
        String browserName = yamlReader.getBrowserName();
        assertEquals("chrome", browserName, "El nombre actual del browser en Application.yml no coincide");
    }

    @Test
    public void testGetBrowserPathDefault() {
        YamlReader yamlReader = new YamlReader();
        String browserPath = yamlReader.getBrowserPath();
        assertEquals("drivers/chrome/chromedriver.exe", browserPath, "La ruta actual del browser en Application.yml no coincide");
    }

    @Test
    public void testIsHeadlessDefault() {
        YamlReader yamlReader = new YamlReader();
        boolean isHeadless = yamlReader.isHeadless();
        assertTrue(isHeadless, "El modo actual de headless en Application.yml no coincide");
    }
}
