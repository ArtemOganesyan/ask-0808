package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Helpers;

import java.io.IOException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Sawant {
    private static String emailXpath = "//input[@formcontrolname='email']";
    private static String passXpath = "//input[@formcontrolname='password']";
    private static String signInBtnXpath = "//span[contains(text(),'Sign In')]";
    private static String myAssignmentsMenuXpath = "//h5[contains(text(),'My Assignments')]";
    private static String myGradesMenuXpath = "//h5[contains(text(),'My Grades')]";
    private static String myAssignmentsTitleXpath = "//h4[contains(text(),'My Assignments')]";
    private static String myGradesTitleXpath = "//h4[contains(text(),'My Grades')]";
    private static String quizzesXpath = "//h5[contains(text(),'Quizzes')]";
    private static String createQuizBtnXpath = "//*[contains(text(), 'Create New Quiz')]";
    private static String quizTitleXpath = "//input[@formcontrolname='name']";
    private static String addQuestionBtnXpath = "//div/button/span/mat-icon";
    private static String textualQselXpath = "//mat-panel-title[contains(text(), 'Q1')]/../../..//*[contains(text(), 'Textual')]";
    private static String questionSliderXpath = "//mat-panel-title[contains(text(), 'Q1')]/../../..//mat-slider";


    @Given("SS go to the {string} page")
    public void ssGoToThePage(String url) {
        getDriver().get(url);
    }

    @Then("SS type {string} into email field")
    public void ssTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath(emailXpath)).sendKeys(email);
    }

    @And("SS enter {string} as password")
    public void ssEnterAsPassword(String password) {
        getDriver().findElement(By.xpath(passXpath)).sendKeys(password);
    }

    @Then("SS click SignIn button")
    public void ssClickSignInButton() {
        getDriver().findElement(By.xpath(signInBtnXpath)).click();
    }

    @And("SS wait for {int} sec")
    public void ssWaitForSec(int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myAssignmentsMenuXpath)));
    }

    @When("SS click on assignments")
    public void ssClickOnAssignments() {
        getDriver().findElement(By.xpath(myAssignmentsMenuXpath)).click();
        Assertions.assertThat(getDriver().findElement(By.xpath(myAssignmentsTitleXpath)).isDisplayed());

    }

    @When("SS click on grades")
    public void ssClickOnGrades() {
        getDriver().findElement(By.xpath(myGradesMenuXpath)).click();
        Assertions.assertThat(getDriver().findElement(By.xpath(myGradesTitleXpath)).isDisplayed());

    }

    @Then("SS go the quizzes")
    public void ssGoTheQuizzes() throws InterruptedException {
        Thread.sleep(3000);
        getDriver().findElement(By.xpath(XPathLibrary.quizzesXpath)).click();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath(XPathLibrary.createQuizBtnXpath)).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.quizTitleXpath)).sendKeys("Sandy's quiz");
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.addQuestionBtnXpath)).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.textualQselXpath)).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.questionSliderXpath)).sendKeys(Keys.ARROW_LEFT);
        Thread.sleep(10000);
    }

    @Given("SS get activation code")
    public void ssGetActivationCode() throws SQLException, IOException {
        String acTok = Helpers.getAccessToken("");
        System.out.println(acTok);
        String[] resp = acTok.split(";");
        int userid = Integer.valueOf(resp[0]);
        String activationCode = resp[1];
        Helpers.activateUser(userid, activationCode);
        {

        }
    }

    @Given("SS open url {string}")
    public void ssOpenUrl(String arg0) {
        getDriver().get("http://ask-stage.portnov.com/#/registration");
    }
}