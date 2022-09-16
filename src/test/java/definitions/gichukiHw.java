package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import support.Helpers;

import java.io.IOException;
import java.sql.SQLException;

import static support.TestContext.getDriver;

public class gichukiHw {
    private static String emailXpath = "//input[@formcontrolname='email']";
    private static String passwordXpath= "//input[@formcontrolname='password']";
    private static String signinXpath = "//button[@type='submit']";
    private static Integer userId;
    private static String activationCode;

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

    @And("MG click on {string} button")
    public void mgClickOnButton(String registration) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" +registration+"')]")).click();
    }

    @And("MG type {string} as firstname")
    public void mgTypeAsFirstname(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("MG type {string} as lastname")
    public void mgTypeAsLastname(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("MG type {string} as email")
    public void mgTypeAsEmail(String validEmailA) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(validEmailA);
    }

    @And("MG type group as {string}")
    public void mgTypeGroupAs(String group) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group);
    }

    @And("MG type password as {string}")
    public void mgTypePasswordAs(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("MG type confirm password as {string}")
    public void mgTypeConfirmPasswordAs(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @And("MG click on {string}")
    public void mgClickOn(String registerButton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" +registerButton+"')]")).click();
    }

    @Then("MG get activation code for user {string}")
    public void mgGetActivationCodeForUser(String userEmail) throws SQLException {
        String res = Helpers.getAccessToken(userEmail);
        System.out.println("The result from DB:" +res);
        String[] val = res.split(";");
        userId = Integer.valueOf(val[0]);
        activationCode = val[1];
        System.out.println("Separated values: " +val[0]+ "and" +val[1]);
    }

    @And("MG send activation request")
    public void mgSendActivationRequest() throws IOException {
        Helpers.activateUser(userId,activationCode);
    }
}