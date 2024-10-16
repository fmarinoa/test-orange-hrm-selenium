package readers;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;

public class YamlReader {

    private final Yaml yaml = new Yaml(new Constructor(Map.class, new LoaderOptions()));

    private InputStream inputStream() {
        InputStream inputStream = YamlReader.class
                .getClassLoader()
                .getResourceAsStream("application.yml");

        if (inputStream == null) {
            throw new IllegalArgumentException("Archivo application.yml no encontrado.");
        }

        return inputStream;
    }

    private String getProfileActive(Map<String, Object> config) {
        Map<String, Object> profiles = (Map<String, Object>) config.get("profiles");
        if (profiles == null || !profiles.containsKey("active")) {
            throw new IllegalArgumentException("Perfil activo no encontrado en la configuración.");
        }
        return (String) profiles.get("active");
    }

    private Map<String, Object> getSettings(Map<String, Object> config) {
        return (Map<String, Object>) config.get("settings");
    }

    private String getUrl(Map<String, Object> settings, String activeProfile) {
        if (settings == null || !settings.containsKey(activeProfile)) {
            throw new IllegalArgumentException("Configuración para el perfil activo no encontrada.");
        }
        return (String) ((Map<String, Object>) settings.get(activeProfile)).get("url");
    }

    public String getEnvironment() {
        // Leer el archivo y mapearlo
        Map<String, Object> config = yaml.load(inputStream());
        // Acceder a las propiedades
        return getUrl(getSettings(config), getProfileActive(config));
    }

    String getEnvForTest(String profile) {
        Map<String, Object> config = yaml.load(inputStream());
        return getUrl(getSettings(config), profile);
    }

    private Map<String, Object> getConfigDriver() {
        Map<String, Object> config = yaml.load(inputStream());
        return (Map<String, Object>) config.get("driver");
    }

    public String getBrowserName() {
        return (String) getConfigDriver().get("browser");
    }

    public String getBrowserPath() {
        return (String) getConfigDriver().get("path");
    }

    public boolean isHeadless() {
        return (boolean) getConfigDriver().get("headless");
    }

    private Map<String, Object> getDriver(Map<String, Object> config) {
        return (Map<String, Object>) config.get("driver");
    }
}
