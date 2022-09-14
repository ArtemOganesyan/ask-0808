package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class gichukiHw {
    private static String emailXpath = "//input[@formcontrolname='email']";
    private static String passwordXpath= "//input[@formcontrolname='password']";
    private static String signinXpath = "//button[@type='submit']";

    @Given("MG open site with url {string}")
    public void mgOpenSiteWithUrl(String url) {
        getDriver().get(url);
    }

    @And("MG type the password {string}")
    public void mgTypeThePassword(String password) {
        getDriver().findElement(By.xpath(passwordXpath)).sendKeys(password);
    }

    @And("MG clicks on the sign in button")
    public void mgClicksOnTheSignInButton() {
        getDriver().findElement(By.xpath(signinXpath)).click();
    }

    @Then("Text is displayed as {string} below email input field")
    public void textIsDisplayedAsBelowEmailInputField(String noEmailText) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'" +noEmailText+"')]")).isDisplayed();
    }

    @And("MG type email as {string}")
    public void mgTypeEmailAs(String wrongEmailFormat) {
        getDriver().findElement(By.xpath(emailXpath)).sendKeys(wrongEmailFormat);
    }

    @And("MG click in password text field")
    public void mgClickInPasswordTextField() {
        getDriver().findElement(By.xpath(passwordXpath)).click();
    }

    @Then("MG text is displayed as {string} below email input field")
    public void mgTextIsDisplayedAsBelowEmailInputField(String wrongEmailFormat) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'" +wrongEmailFormat+ "')]")).isDisplayed();
    }

    @And("MG input correct email as {string}")
    public void mgInputCorrectEmailAs(String correctEmail) {
        getDriver().findElement(By.xpath(emailXpath)).sendKeys(correctEmail);
    }

    @And("MG input correct password as {string}")
    public void mgInputCorrectPasswordAs(String correctPassword) {
        getDriver().findElement(By.xpath(passwordXpath)).sendKeys(correctPassword);
    }

    @And("MG wait for {int} seconds")
    public void mgWaitForSeconds(int timeout) throws InterruptedException {
        Thread.sleep(3000);
    }

    @Then("MG verify role is {string}")
    public void mgVerifyRoleIs(String role) {
        getDriver().findElement(By.xpath("//p[contains(text(),'" +role+ "')]")).isDisplayed();
    }

    @And("MG input wrong password as {string}")
    public void mgInputWrongPasswordAs(String wrongPassword) {
        getDriver().findElement(By.xpath(passwordXpath)).sendKeys(wrongPassword);
    }

    @Then("MG text is displayed as {string}")
    public void mgTextIsDisplayedAs(String authenticationFailed) {
        getDriver().findElement(By.xpath("//div[contains(text(),'" +authenticationFailed+ "')]")).isDisplayed();
    }
}
