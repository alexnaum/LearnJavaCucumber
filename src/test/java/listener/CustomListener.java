package listener;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

public class CustomListener extends RunListener {
    @Override
    public void testStarted(Description d){
        System.out.println("Listener.testStarted: executed " + d.getDisplayName());
    }
    @Override
    public void testFinished(Description d){
        System.out.println("Listener.testFinished " + d.getDisplayName());
    }
}
