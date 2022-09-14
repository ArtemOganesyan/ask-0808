/*
 * Created by Artem Oganesyan on 09.09.2022
 */

package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Helpers;


import java.io.IOException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class
Oganesyan {
    private Integer userId;
    private String activationCode;

    @Given("something")
    public void something() {

    }

    @Given("OAV go to {string} page")
    public void oavGoToPage(String url) {
        getDriver().get(url);
    }

    @Then("OAV type {string} into email field")
    public void oavTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath(XPathLibrary.emailXpath)).sendKeys(email);
    }

    @And("OAV enter {string} as password")
    public void oavEnterAsPassword(String password) {
        getDriver().findElement(By.xpath(XPathLibrary.passXpath)).sendKeys(password);
    }

    @Then("OAV click SignIn button")
    public void oavClickSignInButton() {
        getDriver().findElement(By.xpath(XPathLibrary.signInBtnXpath)).click();
    }

    @And("OAV wait for {int} sec")
    public void oavWaitForSec(int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPathLibrary.quizzesXpath)));
    }

    @When("OAV click on assignments")
    public void oavClickOnAssignments() {
        getDriver().findElement(By.xpath(XPathLibrary.myAssignmentsMenuXpath)).click();
        assertThat(getDriver().findElement(By.xpath(XPathLibrary.myAssignmentsTitleXpath)).isDisplayed());
    }

    @When("OAV click on grades")
    public void oavClickOnGrades() {
        getDriver().findElement(By.xpath(XPathLibrary.myGradesMenuXpath)).click();
        assertThat(getDriver().findElement(By.xpath(XPathLibrary.myGradesTitleXpath)).isDisplayed());
    }

    @Then("OAV goto Quizzes")
    public void oavGotoQuizzes() throws InterruptedException {
        Thread.sleep(3000);
        getDriver().findElement(By.xpath(XPathLibrary.quizzesXpath)).click();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath(XPathLibrary.createQuizBtnXpath)).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.quizTitleXpath)).sendKeys("Test quiz");
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.addQuestionBtnXpath)).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.textualQselXpath)).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.questionSliderXpath)).sendKeys(Keys.ARROW_LEFT);
        Thread.sleep(10000);
    }

    @Given("OAV get activation code")
    public void oavGetActivationCode() throws SQLException, IOException {
        String acTok = Helpers.getAccessToken("jack@pirate.com");
        System.out.println(acTok);
        String[] resp = acTok.split(";");
        int userid = Integer.valueOf(resp[0]);
        String activationCode = resp[1];
        Helpers.activateUser(userid, activationCode);
    }

    @Given("OAV open url {string}")
    public void oavOpenUrl(String url) {
        getDriver().get(url);
    }

    @Then("OAV type {string} as firstname")
    public void oavTypeAsFirstname(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @Then("OAV type {string} as lastname")
    public void oavTypeAsLastname(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @Then("OAV type {string} as email")
    public void oavTypeAsEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("OAV type {string} as group code")
    public void oavTypeAsGroupCode(String group) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group);
    }

    @Then("OAV type {string} as password")
    public void oavTypeAsPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("OAV type {string} as confirm password")
    public void oavTypeAsConfirmPassword(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @And("OAV click on signup button")
    public void oavClickOnSignupButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("OAV get activation token for user {string}")
    public void oavGetActivationTokenForUser(String email) throws SQLException {
        String res = Helpers.getAccessToken(email);
        System.out.println("The result from DB: " + res);
        String[] val = res.split(";");
        userId = Integer.valueOf(val[0]);
        activationCode = val[1];
        System.out.println("Separated values: " + val[0] + "and" + val[1]);
    }

    @And("OAV send activation request")
    public void oavSendActivationRequest() throws IOException {
        Helpers.activateUser(userId, activationCode);
    }
}


