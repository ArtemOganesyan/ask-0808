package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class DaryaD {
    private static String emailXpath = "//input[@formcontrolname='email']";
    private static String passwordXpath = "//input[@formcontrolname='password']";
    private static String signInBtn = "//span[contains(text(),'Sign In')]";
    private static String teacherTitle = "//p[contains(text(),'TEACHER')]";
    private static String studentTitle = "//p[contains(text(),'STUDENT')]";
    private static String stMyAssign = "//span[contains(text(),'Go To My Assignments')]";
//    private static String stGoToAssignBtn = "//span[contains(text(),'Go To Assessment')]";
    private static String stSubmAnsw = "//span[contains(text(),'Submit My Answers')]";
    private static String stMyGrades = "//h5[contains(text(),'My Grades')]";
    private static String stDetailsBtns = "//span[contains(text(),'Details')]";
    private static String otherTextArea = "//span[contains(text(),'Details')]";

    @Given("DD open url {string}")
    public void iDDOpenUrl(String url) {
        getDriver().get(url);
        assertThat(getDriver().getTitle()).containsIgnoringCase("Assessment Control @ Portnov");
    }

    @Then("Click DD on the Sign In button")
    public void clickDDOnTheSignInButton() {
        getDriver().findElement(By.xpath(signInBtn)).click();
    }

    @Then("Type DD the email {string} in the email field")
    public void typeDDTheEmailInTheEmailField(String email) {
        getDriver().findElement(By.xpath(emailXpath)).sendKeys(email);
    }

    @Then("Type DD the password {string} in the password field")
    public void typeDDThePasswordInThePasswordField(String pwd) {
        getDriver().findElement(By.xpath(passwordXpath)).sendKeys(pwd);
    }

    @Then("I DD wait for {int} sec")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }

    @Then("Click DD on the element with xpath {string}")
    public void clickOnTheElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @And("Verify than the element with xpath {string} contain text {string}")
    public void verifyThanTheElementWithXpathContainText(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).isEqualToIgnoringCase(text);
    }

    @Then("The element with xpath {string} presented")
    public void theElementWithXpathStringPresented(String xpath) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    @And("I DD take a screenshot")
    public void iTakeAScreenshot() throws Exception {
        TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
        File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("target/screenshot " + new Date() + ".png"));
    }

    @Then("Click DD on the Details button")
    public void clickDDOnTheDetailsButton() {
        List<WebElement> array = getDriver().findElements(By.xpath(stDetailsBtns));
        WebElement lastButton = array.stream().reduce((first, second) -> second).orElseThrow();
        lastButton.click();
    }

//    And Verify DD that element with xpath "//div[@class='ng-star-inserted']" contain text "Letters123!@#$%"
    @And("DD verify the Other text area contains provided text {string}")
    public void verifyDDThatElementWithXpathContainText(String text) {
        String actText = getDriver().findElement(By.xpath(otherTextArea)).getText();
        assertThat(actText).isEqualTo(text);
    }

    @Then("Assign the quiz to the student")
    public void assignTheQuizToTheStudent() throws InterruptedException {
        //login as a teacher
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("da.dreizina@gmail.com");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345Abc");
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        //assigne the quize
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Assignment')]")).click();
        Thread.sleep(4 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'N001')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'DaryaDre Quize Automation')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
        Thread.sleep(2 * 1000);
        //logout from teacher acc
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(4 * 1000);
    }

    @And("Delete DD assignment")
    public void deleteDDAssignment() {
        //logout as a student
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        //login as a teacher
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("da.dreizina@gmail.com");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345Abc");
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        //delete assignment
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'DaryaDre Quize Automation')]/parent::mat-panel-title/following::button")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete Assignment')]")).click();

    }

    @Then("DD wait {int} sec when page is loaded for Teacher")
    public void ddWaitSecWhenPageIsLoadedForTeacher(int timeout) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(teacherTitle)));
    }

    @Then("DD wait {int} sec when page is loaded for Student")
    public void ddWaitSecWhenPageIsLoadedForStudent(int timeout) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(studentTitle)));
    }

    @And("DD assign the quiz to the student")
    public void ddAssignTheQuizToTheStudent() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Assignment')]")).click();
        Thread.sleep(4 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'N001')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'DaryaDre Quize Automation')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
        Thread.sleep(2 * 1000);
    }

    @And("DD logout as a Teacher")
    public void ddLogoutAsATeacher() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Log Out')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Assessment Control')]")));
    }

    @Then("Click DD on the My Assignments")
    public void clickDDOnTheMyAssignments() throws InterruptedException {
        getDriver().findElement(By.xpath(stMyAssign)).click();
        Thread.sleep(2 * 1000);
//        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Go To Assessment')]")));
    }

    @Then("Click DD on the Go To Assessment button")
    public void clickDDOnTheGoToAssessmentButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Go To Assessment')]")).click();
        Thread.sleep(2 * 1000);
//        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Submit My Answers')]")));
    }

    @Then("DD Pass the quiz with the text {string} in the Other field")
    public void ddPassTheQuiz(String text) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Enter your answer']")).sendKeys("DaryaD");
        getDriver().findElement(By.xpath("//label[@for='mat-radio-3-input']")).click();
        getDriver().findElement(By.xpath("//label[@for='mat-checkbox-2-input']")).click();
        getDriver().findElement(By.xpath("//label[@for='mat-checkbox-3-input']")).click();
        getDriver().findElement(By.xpath("//textarea[@placeholder='Other']")).sendKeys(text);
    }

    @And("Click DD on the Submit My Answers button")
    public void ddClickOnTheSubmitMyAnswersButton() {
        getDriver().findElement(By.xpath(stSubmAnsw)).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your submission has been accepted')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
    }

    @Then("Click DD on the My Grades")
    public void clickDDOnTheMyGrades() {
        getDriver().findElement(By.xpath(stMyGrades)).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'My Grades')]")));
    }
}
