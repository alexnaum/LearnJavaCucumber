package steps;

import hooks.SessionManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.CarDetailsPage;
import pages.FindCarPage;

public class BasePageDefs{
  BasePage basePage = new BasePage();
 /* CarDetailsPage carDetailsPage = new CarDetailsPage();
  FindCarPage findCarPage = new FindCarPage();*/

  SessionManager sessionManager = new SessionManager();
    @Given("^Open OLX cars page$")
    public void openOLXCarsPage() {
        sessionManager.openUrl();
    }

    @When("^close cookies popup$")
    public void closeCookiesPopup() {
        basePage.closeCookieWindow();
    }

    @And("^close geo suggestion popup$")
    public void closeGeoSuggestionPopup() {
        basePage.closeGeoSuggestion();
    }
}
