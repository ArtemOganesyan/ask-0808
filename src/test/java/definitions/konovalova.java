package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Helpers;
import org.junit.Assert;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Thread.sleep;
import static support.TestContext.getDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class konovalova {
    @Given("ZK open url {string}")
    public void zkOpenUrl(String url) {
        getDriver().get(url);
    }


    @When("ZK type {string} into element with xpath {string}")
    public void zkTypeIntoElementWithXpath(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }


    @Then("type ZK {string} into element with xpath {string}")
    public void typeZKIntoElementWithXpath(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @And("ZK click on the element with xpath {string}")
    public void zkClickOnTheElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @And("ZK wait for {int} sec")
    public void zkWaitForSec(int sec) throws InterruptedException{
    sleep(sec * 1000);
    }

    @Then("ZK element with xpath {string} is displayed")
    public void zkElementWithXpathIsDisplayed(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
    }

    @And("click ZK on the element with xpath {string}")
    public void clickZKOnTheElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }
}
