package steps;

import dictionaries.SortingEnum;
import hooks.RetryRule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Rule;
import pages.CarDetailsPage;
import pages.FindCarPage;

import java.util.*;
import java.util.stream.Collectors;

public class FiltersDefs{
    FindCarPage findCarPage = new FindCarPage();
    //CarDetailsPage carDetailsPage = new CarDetailsPage();
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Then("^the values should be displayed in the same page$")
    public void theValuesShouldBeDisplayedInTheSamePage(String minV, String maxV) {
        Assert.assertTrue(findCarPage.getMinFilterParameter("param_motor_mileage").contains(minV));
        Assert.assertTrue(findCarPage.getMaxFilterParameter("param_motor_mileage").contains(maxV));
    }

    @When("sort by {string} price descending")
    public void sortByDescending(String arg0) {
        if(arg0.equals("Expensive")) findCarPage.selectItemFormSortingList(SortingEnum.Expensive.getVal());
    }

    @Then("^check that sorting in descending order of price worked correctly$")
    public void checkThatCorrectSortedListWasDisplayed() {
        var sortedListSite = findCarPage.getGeneralListOfPrice()
                .stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<Integer> sortedListReal = sortedListSite.stream().sorted(Comparator.reverseOrder()).toList();
        Assert.assertTrue(sortedListSite.stream().allMatch(new HashSet<>(sortedListReal)::contains));
    }

    @And("get list of sorting items")
    public void getListOfSortingItems() {
        var sortedListSite = findCarPage.getGeneralListOfPrice()
                .stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<Integer> sortedListReal = sortedListSite.stream().sorted(Comparator.reverseOrder()).toList();
    }

    @And("set Min mileage = (.*) and Max mileage = (.*)$")
    public void setAnd(String minV, String maxV) {
        findCarPage.inputMinMileage(minV);
        findCarPage.inputMaxMileage(maxV);
    }

    @Then("the values should be displayed Min mileage = (.*) and Max mileage = (.*) in the same page$")
    public void theValuesShouldBeDisplayedMinMileageAndMaxMileageInTheSamePage(String arg0, String arg1) {
        Assert.assertTrue(findCarPage.getMinFilterParameter("param_motor_mileage").contains(arg0));
        Assert.assertTrue(findCarPage.getMaxFilterParameter("param_motor_mileage").contains(arg1));
    }

    @And("get car mileage")
    public void getCarMileage() {
        findCarPage.getGeneralList().get(1).click();
        //carDetailsPage.getMileAge();
        //System.out.println(carDetailsPage.getMileAge());
        //List<Integer> sortedListReal = sortedListSite.stream().sorted(Comparator.reverseOrder()).toList();
    }
}
