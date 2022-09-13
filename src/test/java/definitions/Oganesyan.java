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

public class Oganesyan {

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
}


