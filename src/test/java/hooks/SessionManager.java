package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import pages.BasePage;
import pages.CarDetailsPage;
import pages.FindCarPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static common.Config.BROWSER_NAME;
import static org.openqa.selenium.logging.LogType.BROWSER;
import static variables.Variables.Urls.OLX_FIND_CAR_URL;

public class SessionManager{
    BasePage basePage = new BasePage();
   /* CarDetailsPage carDetailsPage = new CarDetailsPage();
    FindCarPage findCarPage = new FindCarPage();*/

    @Before
    public void openUrl(){
        Configuration.browser = BROWSER_NAME;
        open(OLX_FIND_CAR_URL);
        basePage.closeGeoSuggestion();
        basePage.closeCookieWindow();
    }

    @After
    public void closeSession(){
        closeWindow();
    }
}
