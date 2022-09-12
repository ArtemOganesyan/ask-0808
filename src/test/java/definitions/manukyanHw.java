package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class manukyanHw {

    @Given("I open url {string}")
    public void iOpenUrl(String url) {
        getDriver().get(url);
    }

    @And("I type {string} into element with xpath {string}")
    public void iTypeStringIntoElementWithXpath(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }


    @Then("I click on element with xpath {string}")
    public void iClickOnElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }


    @And("element with xpath {string} is displayed")
    public void elementWithXpathStringIsDisplayed(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();

    }


    @And("I press on element with xpath {string}")
    public boolean iPressOnElementWithXpathString(String xpath) {
        boolean result = false;
        int attempts = 0;
        while (attempts<2) {try {
            getDriver().findElement(By.xpath(xpath)).click();
            result = true;
            break;
        } catch (StaleElementReferenceException e) {

        }
        attempts++;
        }
        return result;




    }

    @Then("element with xpath {string} should contain text {string}")
    public void elementWithXpathShouldContainText(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).contains(text);
    }

   
    }

