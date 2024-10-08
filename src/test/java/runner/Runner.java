package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // Ruta a los archivos .feature
        glue = {"stepDefinitions", "hooks"},        // Paquetes con las definiciones de pasos y hooks
        tags = "@LoginSuccessful",                  // Indica el tag específico que quieres ejecutar
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)
public class Runner {
}
