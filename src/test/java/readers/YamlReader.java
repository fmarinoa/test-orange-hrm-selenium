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

    public String getEnv() {
        // Leer el archivo y mapearlo
        Map<String, Object> config = yaml.load(inputStream());
        // Acceder a las propiedades
        return getUrl(getSettings(config), getProfileActive(config));
    }
}
