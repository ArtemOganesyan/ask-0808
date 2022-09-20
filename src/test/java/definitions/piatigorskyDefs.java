package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class piatigorskyDefs {
    //private static String emailXpath = "//input[@formcontrolname='email']";
    //private static String passXpath = "//input[@formcontrolname='password']";

    @Given("lpr something")
    public void lprSomething() {
        System.out.println("First feature definition method");
    }

    @Given("LPR go to {string} page")
    public void lprGoToPage(String url) {
        getDriver().get(url);
    }

    @Then("LPR type {string} into email field")
    public void lprTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath(XPathLibrary.emailXpath)).sendKeys(email);
    }

    @And("LPR enter {string} as password")
    public void lprEnterAsPassword(String password) {
        getDriver().findElement(By.xpath(XPathLibrary.passXpath)).sendKeys(password);
    }

    @Then("LPR click SignIn button")
    public void lprClickSignInButton() {
        getDriver().findElement(By.xpath(XPathLibrary.signInBtnXpath)).click();
    }

    @And("LPR wait for {int} sec")
    public void lprWaitForSec(int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body")));
    }

    @When("LPR click on assignments")
    public void lprClickOnAssignments() {
        getDriver().findElement(By.xpath(XPathLibrary.myAssignmentsMenuXpath)).click();
        assertThat(getDriver().findElement(By.xpath(XPathLibrary.myAssignmentsTitleXpath)).isDisplayed());
    }


    @And("LPR wait for {int} sec until {string} is displayed")
    public void lprWaitForSecUntilIsDisplayed(int timeout, String menuItem) {
        /* wait until the left side menu item is displayed */
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menuItem)));
    }

    @When("LPR click on grades")
    public void lprClickOnGrades(){
        getDriver().findElement(By.xpath(XPathLibrary.myGradesMenuXpath)).click();
        assertThat(getDriver().findElement(By.xpath(XPathLibrary.myGradesTitleXpath)).isDisplayed());
    }

    private void WaitUntillElementVisibility (String elementXpath)
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementXpath)));
    }
    private void WaitUntillElementClickable (String elementXpath)
    {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }

    @And("LPR create new quiz")
    public void lprCreateNewQuiz()  throws InterruptedException {
        WaitUntillElementVisibility("//span[contains(text(),'Create New Quiz')]");
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();

        //getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.quizTitleXpath)).sendKeys("LPR Selenium Test quiz");
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.addQuestionBtnXpath)).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.textualQselXpath)).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(XPathLibrary.questionSliderXpath)).sendKeys(Keys.ARROW_LEFT);
        Thread.sleep(10000);
        getDriver().findElement(By.xpath("//textarea[@placeholder='Question *']")).sendKeys("What is the answer to this question?");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @Then("LPR click on quizzes")
    public void lprClickOnQuizzes(){
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
        WaitUntillElementVisibility(XPathLibrary.quizzesListTitleXpath);
        assertThat(getDriver().findElement(By.xpath(XPathLibrary.quizzesListTitleXpath)).isDisplayed());
    }

    @Then("LPR login as a teacher with credentials {string} and {string}")
    public void lprLoginAsATeacherWithCredentialsAnd(String email, String password) {
        getDriver().findElement(By.xpath(XPathLibrary.emailXpath)).sendKeys(email);
        getDriver().findElement(By.xpath(XPathLibrary.passXpath)).sendKeys(password);
        getDriver().findElement(By.xpath(XPathLibrary.signInBtnXpath)).click();

    }

    @Then("LPR find quiz by name {string}")
    public void lprFindQuizByName(String quizName) throws InterruptedException{
        WaitUntillElementVisibility("//mat-panel-title[contains(text(),'"+quizName+"')]");
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]")).click();
        Thread.sleep(3000);
    }

    @And("LPR delete quiz {string} from the list")
    public void lprDeleteQuizFromTheList(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]/../../..//span[contains(text(),'Delete')]")).click();

    }
}
