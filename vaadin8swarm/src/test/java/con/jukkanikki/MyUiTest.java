package con.jukkanikki;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.Dimension;

import static org.junit.Assert.*;

// Works manually, as test runners needs to start server first, and this is not yet defined
@Ignore
@RunWith(Arquillian.class)
public class MyUiTest {

    @Drone
    PhantomJSDriver browser;

    @Test
    public void testIt() throws Exception {
        browser.manage().window().setSize( new Dimension(1024, 768));
        browser.navigate().to("http://localhost:8080/");

        browser.findElementByClassName( "v-button" ).click();
        WebElement notification = browser.findElementByClassName("v-label");

        assertTrue( notification.getText().contains( "works" ));
    }
}
