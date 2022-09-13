package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


import static java.lang.Thread.sleep;
import static support.TestContext.getDriver;

public class baykov {
    @Given("AB open ask page")
    public void abOpenAskPage() {
        getDriver().get("http://ask-stage.portnov.com/");
    }

    @Then("AB type login {string} by link {string}")
    @And("AB type password {string} by link {string}")
    public void abTypeLoginByLink(String credential, String path) {

        var field = getDriver().findElement(By.xpath(path));
        field.sendKeys(credential);
    }

    @Then("AB click button login by link {string}")
    public void abClickButtonLoginByLink(String path) {
        getDriver().findElement(By.xpath(path)).click();
    }

    @And("AB wait {int} sec")
    public void waitSec(int sec) throws InterruptedException {
        sleep(sec * 1000);
    }

    @And("AB click menu settings by link {string}")
    @Then("AB click change your password by link {string}")
    public void abClickMenuSettingsByLink(String path) {
        getDriver().findElement(By.xpath(path)).click();
    }

    @Then("AB click button change by link {string}")
    public void abClickButtonChangeByLink(String path) {
        getDriver().findElement(By.xpath(path)).click();
    }


    @Then("AB type current password {string} in field by link {string}")
    @And("AB type new password {string} in field by link {string}")
    @When("AB type confirm new password {string} in field by link {string}")
    public void abTypeCurrentPasswordInFieldByLink(String credential, String path) {
        var field = getDriver().findElement(By.xpath(path));
        field.sendKeys(credential);
    }


    @Then("AB logout")
    public void logout() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[text()='Log Out']")).click();
        sleep(1000);
        getDriver().findElement(By.xpath("//button[./span[text()='Log Out']]")).click();
    }

    @Then("AB verify login with new password")
    public void abVerifyLoginWithNewPassword() {
        Assert.assertTrue(getDriver().findElement(By.xpath("//p[text()='STUDENT']")).isDisplayed());
    }
}
