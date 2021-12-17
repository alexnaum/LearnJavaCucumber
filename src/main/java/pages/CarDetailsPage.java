package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CarDetailsPage extends BasePage{


    SelenideElement mileage = $("ul.css-sfcl1s").shouldHave(Condition.text("Пробег"));

    public String getMileAge(){
        SelenideElement mileage = $("ul.css-sfcl1s").shouldHave(Condition.text("Пробег"));
        //mileage.getText().split(" ");
        mileage.getText().replace("Пробег: ", "");
        mileage.getText().replace(" км","");
        return mileage.getText();
    }
}
