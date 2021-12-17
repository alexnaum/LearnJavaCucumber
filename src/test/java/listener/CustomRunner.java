package listener;

import io.cucumber.junit.Cucumber;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

public class CustomRunner extends BlockJUnit4ClassRunner
{
    public CustomRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }
    @Override
    public void run(RunNotifier notifier){
        notifier.addListener(new CustomListener());
        super.run(notifier);
    }
}
