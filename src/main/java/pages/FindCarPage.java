package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FindCarPage extends BasePage {
    private SelenideElement minMileage = $("#param_motor_mileage input[class*='min-value-input']");
    private SelenideElement maxMileage = $("#param_motor_mileage input[class*='max-value-input']");
    private SelenideElement sortingList = $("#targetorder-select-gallery");

    public void inputMinMileage(String text){
       $("li#param_motor_mileage a.button-from").click();
       minMileage.clear();
       minMileage.val(text);
       minMileage.sendKeys(Keys.ENTER);
    }

    public void inputMaxMileage(String text){
        $("li#param_motor_mileage a.button-to").click();
        maxMileage.clear();
        maxMileage.val(text);
        maxMileage.sendKeys(Keys.ENTER);
    }

    public String getMinFilterParameter(String param) {
        $(By.id("searchbox")).click();
        return $("li#" + param + " a.button-from").getText();
    }

    public String getMaxFilterParameter(String param) {
        $(By.id("searchbox")).click();
        return $(By.cssSelector("li#" + param + " a.button-to")).getText();
    }

    public FindCarPage selectItemFormSortingList(int v) {
        sortingList.click();
        $("#targetorder-select-gallery ul li:nth-of-type(" + v + ")").click();
        return this;
    }

    public List<String> getGeneralListOfPrice() {
        //$("#listContainer > div.listOverlay");
        $(By.id("topLinkShowAll")).shouldBe(Condition.visible);
        List<SelenideElement> list = $$("#offers_table td.offer .price strong").stream().toList();
        return list.stream().map(w -> w.getText().replace(" ", "")
                .replace("грн.", "")).collect(Collectors.toList());
    }
    public List<SelenideElement> getGeneralList(){
        $(By.id("topLinkShowAll")).shouldBe(Condition.visible);
        List<SelenideElement> list = $$("#offers_table td.offer h3 a").stream().toList();
        return list;
    }
}
