package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
public class BasePage{
    private SelenideElement closeCookiesButton = $("button.cookie-close");
    private SelenideElement closeGeoSuggestionButton = $("a#geo-suggestions-close");

    public void closeCookieWindow(){
        if(closeCookiesButton.isDisplayed())
        closeCookiesButton.click();
    }
    public void closeGeoSuggestion(){
        if(closeGeoSuggestionButton.isDisplayed())
            closeGeoSuggestionButton.click();
    }
}
