import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import listener.CustomRunner;
import listener.ListenerPlugin;
import org.junit.runner.RunWith;

@RunWith(CustomRunner.class)
@CucumberOptions(plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "features",
        glue = "steps",
        tags = "@FilterTests")
public class RunCucumberTest {
}
