package definitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class kryvoruchko {

    @Given("I open page {string}")
    public void iOpenPage(String url) {
        getDriver().get(amLibrary.url);
    }

    @Given("VK open {string} page")
    public void vkOpenPage(String arg0) {
        {
            getDriver().get(amLibrary.url);

        }
    }

    @Then("VK type {string} into email field")
    public void vkTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath(amLibrary.emailXP)).sendKeys(email);
    }

    @And("VK type {string} into password field")
    public void vkTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath(amLibrary.passwordXP)).sendKeys(password);
    }

    @Then("VK click SignIn button")
    public void vkClickSignInButton() {
        getDriver().findElement(By.xpath(amLibrary.signInBtnXP)).click();

    }

    @And("VK wait {int} sec")
    public void vkWaitSec(int sec) throws InterruptedException {
        {
            sleep(sec * 1000);
        }
    }



    @And("VK go to My grates {string} page")
    public void vkGoToMyGratesPage(String arg0) {
        getDriver().findElement(By.xpath(XPathLibrary.myGradesMenuXpath)).click();
        assertThat(getDriver().findElement(By.xpath(XPathLibrary.myGradesTitleXpath)).isDisplayed());
    }

    @When("I click on grates")
    public void iClickOnGrates() {
        getDriver().findElement(By.xpath(XPathLibrary.myGradesMenuXpath)).click();
        assertThat(getDriver().findElement(By.xpath(XPathLibrary.myGradesTitleXpath)).isDisplayed());
    }
}





