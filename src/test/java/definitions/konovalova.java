package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class konovalova {
    @Given("ZK open url {string}")
    public void zkOpenUrl(String arg0) {

    }

    @When("ZK type {string} into element with xpath {string}")
    public void zkTypeIntoElementWithXpath(String arg0, String arg1) {
    }

    @Then("type ZK {string} into element with xpath {string}")
    public void typeZKIntoElementWithXpath(String arg0, String arg1) {
    }

    @And("ZK click on the element with xpath {string}")
    public void zkClickOnTheElementWithXpath(String arg0) {
    }

    @And("ZK wait for {int} sec")
    public void zkWaitForSec(int arg0) {
    }

    @Then("ZK element with xpath {string} is displayed")
    public void zkElementWithXpathIsDisplayed(String arg0) {
    }

    @And("click ZK on the element with xpath {string}")
    public void clickZKOnTheElementWithXpath(String arg0) {
    }
}
