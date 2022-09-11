package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static support.TestContext.getDriver;

public class Syzonenko {
    @Given("I open page {string}")
    public void iOpenPage(String url) {
        getDriver().get(url);
    }

    @And("I log in as Teacher")
    public void iLogInAsTeacher() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("teacher.account@gmail.com");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Teacher");
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        Thread.sleep(2000);
    }

    @Then("I should see role as {string}")
    public void iShouldSeeRoleAs(String role) {
        String actualrole = getDriver().findElement(By.xpath("//div[@class='info']/p")).getText();
        Assert.assertEquals(actualrole, role);
    }

    @And("I click Assigments button")
    public void iClickAssigmentsButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        Thread.sleep(3000);
    }

    @And("I click Create New Assignment button")
    public void iClickCreateNewAssignmentButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Assignment')]")).click();
    }

    @And("I select quiz {string} from 'Select quiz to assgin' drop-down list")
    public void iSelectQuizFromSelectQuizToAssginDropDownList(String quizName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(), '"+quizName+"')]")).click();
    }

    @And("I select Student from 'Students list'")
    public void iSelectStudentFromStudentsList() {
        getDriver().findElement(By.xpath("//span[contains(text(),'TEST90')]/parent::div/preceding-sibling::mat-pseudo-checkbox")).click();
    }

    @And("I click Give Assignment button")
    public void iClickGiveAssignmentButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
        Thread.sleep(2000);
    }

    @Then("I should see quiz {string} assignment details on Assignments page")
    public void iShouldSeeQuizAssignmentDetailsOnAssignmentsPage(String quizName) {
        String actual = getDriver().findElement(By.xpath("//mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title[3]")).getText().substring(6);
        String dateDetails = getDriver().findElement(By.xpath("//mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title[1]")).getText().substring(17);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        Assert.assertEquals(actual, quizName);
        Assert.assertEquals(dateDetails, format.format(date));

    }

    @And("I select group code {string} from Group filter drop-down list")
    public void iSelectGroupCodeFromGroupFilterDropDownList(String groupCode) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-select[1]/div[1]/div[2]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'"+groupCode+"')]/parent::mat-option")).click();
    }

    @And("I click 'Select All' button")
    public void iClickSelectAllButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select All')]")).click();
    }

    @Then("I should see 'Select at least one Student' error message")
    public void iShouldSeeSelectAtLeastOneStudentErrorMessage() {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//mat-error[contains(text(),'Select at least one Student')]")));
        String errormsg = getDriver().findElement(By.xpath("//mat-error[contains(text(),'Select at least one Student')]")).getText();
        Assert.assertEquals(errormsg, "Select at least one Student");
    }

    @Then("I should see 'This field is required' error message")
    public void iShouldSeeThisFieldIsRequiredErrorMessage() {
        String errormsg = getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).getText();
        Assert.assertEquals(errormsg, "This field is required");
    }

    @And("I log out from current account")
    public void iLogOutFromCurrentAccount() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        Thread.sleep(2000);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
        Thread.sleep(2000);
    }

    @And("I log in as Student")
    public void iLogInAsStudent() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys("student.account@gmail.com");
        getDriver().findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Student");
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        Thread.sleep(3000);
    }

    @And("I click My Assigments button")
    public void iClickMyAssigmentsButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Assignments')]")).click();
        Thread.sleep(2000);
    }

    @And("I click Go to Assessment button")
    public void iClickGoToAssessmentButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Go To Assessment')]")).click();
    }

    @And("I select radio button number {int} as an anwser for question number {int}")
    public void iSelectRadioButtonNumberAsAnAnwserForQuestionNumber(int optionNumber, int questionNumber) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Question "+questionNumber+"')]/ancestor::mat-card//div/mat-radio-group/mat-radio-button["+optionNumber+"]/label/div/div[2]")).click();
    }

    @And("I select check-box number {int} as an anwser for question number {int}")
    public void iSelectCheckBoxNumberAsAnAnwserForQuestionNumber(int optionNumber, int questionNumber) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Question "+questionNumber+"')]/ancestor::mat-card//mat-checkbox["+optionNumber+"]/label/div")).click();
    }

    @And("I click Submit my Answer button")
    public void iClickSubmitMyAnswerButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Submit My Answers')]")).click();
        Thread.sleep(1000);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER);
        actions.perform();
    }

    @When("I click My Grades button")
    public void iClickMyGradesButton() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Grades')]")).click();
    }

    @Then("I should see quiz {string} with Status: {string}")
    public void iShouldSeeQuizWithStatus(String quizName, String status) {
        String actualStatus = getDriver().findElement(By.xpath(
                "//td[contains(text(),'"+quizName+"')]/following-sibling::td/span")).getText();
        String actualQuizName = getDriver().findElement(By.xpath("//td[contains(text(),'"+quizName+"')]")).getText();
        Assert.assertEquals(actualQuizName, quizName);
        Assert.assertEquals(actualStatus, status);
    }

    @Then("I delete Assigments with quiz name {string}")
    public void iDeleteAssigmentsWithQuizName(String quizName) throws InterruptedException {
        List<WebElement> allquizes = getDriver().findElements(By.xpath("//span[contains(text(),'"+quizName+"')]/ancestor::mat-panel-title/following-sibling::mat-panel-title/button/span"));
        for (int i =0; i<allquizes.size(); i++) {
            try {
                allquizes.get(i).click();
                getDriver().findElement(By.xpath("//span[contains(text(),'Delete Assignment')]")).click();
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")));
                actions.click();
                actions.perform();
//                actions.pause(2);
//                actions.sendKeys(Keys.TAB);
//                actions.sendKeys(Keys.ENTER);
//                actions.perform();
            }
            catch (StaleElementReferenceException | ElementClickInterceptedException e)
            {
                allquizes = getDriver().findElements(By.xpath("//span[contains(text(),'"+quizName+"')]/ancestor::mat-panel-title/following-sibling::mat-panel-title/button/span"));
                allquizes.get(i).click();
                getDriver().findElement(By.xpath("//span[contains(text(),'Delete Assignment')]")).click();

                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")));
                actions.click();
                actions.perform();
//                actions.pause(2);
//                actions.sendKeys(Keys.TAB);
//                actions.sendKeys(Keys.ENTER);
//                actions.perform();
            }

        }

    }
}
