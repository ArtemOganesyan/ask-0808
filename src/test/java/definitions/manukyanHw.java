package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class manukyanHw {








    @Given("AM open Ask page")
    public void amOpenAskPage() {getDriver().get(amLibrary.url);
    }

    @Then("AM type {string} into email field")
    public void amTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath(amLibrary.emailXP)).sendKeys(email);
    }

    @And("AM type {string} into password field")
    public void amTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath(amLibrary.passwordXP)).sendKeys(password);
    }

    @Then("AM click SignIn button")
    public void amClickSignInButton() {
        getDriver().findElement(By.xpath(amLibrary.signInBtnXP)).click();
    }



    @And("AM wait {int} sec when all elements load")
    public void amWaitSecWhenAllElementsLoad(int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(),timeout);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(amLibrary.visibleElementXP)));
    }

    @And("AM goes to Assignments")
    public void amGoesToAssignments() throws InterruptedException {
        getDriver().findElement(By.xpath(amLibrary.assignmentsMenuXP)).click();
        Thread.sleep(4000);
    }

    @Then("AM click on Create New Assignment")
    public void amClickOnCreateNewAssignment() {
        getDriver().findElement(By.xpath(amLibrary.createAssignmentXP)).click();
    }

    @And("AM choose student Anna Manukyan from list of students")
    public void amChooseStudentAnnaManukyanFromListOfStudents() {
        getDriver().findElement(By.xpath(amLibrary.studentXP)).click();
    }

    @Then("AM select quiz from dropdown menu with name Unique Quiz")
    public void amSelectQuizFromDropdownMenuWithNameUniqueQuiz() {
        getDriver().findElement(By.xpath(amLibrary.quizDropDownAssignmentXP)).click();
        getDriver().findElement(By.xpath(amLibrary.uniqueQuizAssignmentXP)).click();
    }

    @And("AM create assignment")
    public void amCreateAssignment() throws InterruptedException {
        getDriver().findElement(By.xpath(amLibrary.giveAssignmentXP)).click();
        Thread.sleep(3000);

    }

    @Then("AM Log out")
    public void amLogOut() throws InterruptedException {
        getDriver().findElement(By.xpath(amLibrary.logOutButtonSideNavXP)).click();
        Thread.sleep(2000);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
        Thread.sleep(3000);

    }

    @And("AM Log in as Student")
    public void amLogInAsStudent() throws InterruptedException {
        getDriver().findElement(By.xpath(amLibrary.emailXP)).sendKeys(amLibrary.studentEmail);
        getDriver().findElement(By.xpath(amLibrary.passwordXP)).sendKeys(amLibrary.studentPassword);
        getDriver().findElement(By.xpath(amLibrary.signInBtnXP)).click();
        Thread.sleep(2000);

            }

    @And("AM go to My Assignments")
    public void amGoToMyAssignments() throws InterruptedException {
        getDriver().findElement(By.xpath(amLibrary.myAssignmentsMenuXP)).click();
        Thread.sleep(2000);

    }

    @And("AM choose last assigned quiz")
    public void amChooseLastAssignedQuiz() {
        getDriver().findElement(By.xpath(amLibrary.lastAssignmentXP)).click();

    }


    @And("AM type {string} for textual question")
    public void amTypeForTextualQuestion(String answer) {
        getDriver().findElement(By.xpath(amLibrary.textualAnswerXP)).sendKeys(answer);
    }

    @And("AM answer single choice question")
    public void amAnswerSingleChoiceQuestion() {
        getDriver().findElement(By.xpath(amLibrary.singleChAnswerXP)).click();
    }

    @And("AM answer multiply choice question")
    public void amAnswerMultiplyChoiceQuestion() {
        getDriver().findElement(By.xpath(amLibrary.multiplyCh1XP)).click();
        getDriver().findElement(By.xpath(amLibrary.multiplyCh2XP)).click();
    }

    @And("AM Submit my answers")
    public void amSubmitMyAnswers() {
        getDriver().findElement(By.xpath(amLibrary.submitMyAnswersXP)).click();
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER);
    }

    @And("AM go to My Grades")
    public void amGoToMyGrades() throws InterruptedException {
        getDriver().findElement(By.xpath(amLibrary.myGradesMenuXP)).click();
        Thread.sleep(2000);
    }

    @Then("AM verify that assignment status is {string}")
    public void amVerifyThatAssignmentStatusIs(String status) {
        String actualStatus = getDriver().findElement(By.xpath(amLibrary.myGradesStatusXP)).getText();
        assertThat(actualStatus).isEqualTo(status);
    }


    @Then("My Grades page is displayed")
    public void myGradesPageIsDisplayed() {
        assertThat(getDriver().findElement(By.xpath(amLibrary.myGradesPageXP)).isDisplayed());
    }

    @Then("AM see number of graded assignments in Grades statistics")
    public void amSeeNumberOfGradedAssignmentsInGradesStatistics() throws InterruptedException{
        assertThat(getDriver().findElement(By.xpath(amLibrary.gradedAssignmentsHPXP)).isDisplayed());
        Thread.sleep(2000);
        String number = getDriver().findElement(By.xpath("//p[contains (text(),'There are')]/span[1]")).getText();
        assertThat(number).containsOnlyDigits();
    }

    @Then("AM see number of assignments that need to be reviewed by teacher in Grades statistic")
    public void amSeeNumberOfAssignmentsThatNeedToBeReviewedByTeacherInGradesStatistic() throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//p[contains (.,'but was(re) not reviewed by teacher yet.')]/span[@class='bold'][2]")).isDisplayed());
        Thread.sleep(2000);
        String number = getDriver().findElement(By.xpath("//p[contains (text(),'There are')]/span[2]")).getText();
        assertThat(number).containsOnlyDigits();
    }

    @Then("AM see column named Submitted At")
    public void amSeeColumnNamedSubmittedAt() throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath(amLibrary.submittedAtMyGradesXP)).isDisplayed());
        Thread.sleep(3000);
    }

    @And("AM see that first assignment was submitted at {string}")
    public void amSeeThatFirstAssignmentWasSubmittedAt(String dateTime)    {
        String actualDateTime = getDriver().findElement(By.xpath(amLibrary.dateTimeSubmittedMyGradesXP)).getText();
        assertThat(actualDateTime).contains(dateTime);

    }

    @Then("AM see column named Graded At")
    public void amSeeColumnNamedGradedAt() {
        assertThat(getDriver().findElement(By.xpath(amLibrary.gradedAtMyGradesXP)).isDisplayed());
    }

    @Then("AM verify that Graded at is {string}")
    public void amVerifyThatGradedAtIs(String gardedAt) {
        String actualGradedAt = getDriver().findElement(By.xpath("//tr[@class='ng-star-inserted'][last()]/td[2]")).getText();
        assertThat(actualGradedAt).isEqualTo(gardedAt);
    }

    @And("AM see column Quiz with quizzes names")
    public void amSeeColumnQuizWithQuizzesNames() {
        assertThat(getDriver().findElement(By.xpath(amLibrary.quizMygradesXP)).isDisplayed());
        List<WebElement> quizNames = getDriver().findElements(By.xpath("//td[@class='quiz-name']"));
        for (WebElement quizName : quizNames) {
            assertThat(quizName.getText()).isNotEmpty();
        }
    }

    @And("AM see column Status")
    public void amSeeColumnStatus() {
        assertThat(getDriver().findElement(By.xpath(amLibrary.statusMygradesXP)).isDisplayed());
        List<WebElement> statuses = getDriver().findElements(By.xpath("//td[4]/span"));
        for (WebElement status : statuses)
        assertThat(status.getText()).isIn("PASSED", "PENDING", "FAILED");
    }

    @And("AM see column Score")
    public void amSeeColumnScore() {
        assertThat(getDriver().findElement(By.xpath(amLibrary.scoreMygradesXP)).isDisplayed());
    }


    @And("AM see {string} button next to Passed quiz")
    public void amSeeButtonNextToPassedQuiz(String details) {
        assertThat(getDriver().findElement(By.xpath("//tr/td[4]/span[contains(text(),'PASSED')]/../../td[6]//button")).isDisplayed());
        String button = getDriver().findElement(By.xpath("//td[6]//span")).getText();
        assertThat(button).isEqualTo(details);
    }


    @And("Score is listed if Status is PASSED or FAILED")
    public void scoreIsListedIfStatusIsPASSEDOrFAILED() {
        String scoreP = getDriver().findElement(By.xpath("//td[4]/span[contains(text(),'PASSED')]/../../td[contains(text(),'of')]")).getText();
        assertThat(scoreP).contains("of");
        String scoreF = getDriver().findElement(By.xpath("//td[4]/span[contains(text(),'FAILED')]/../../td[contains(text(),'of')]")).getText();
        assertThat(scoreF).contains("of");
    }

    @Then("AM see {string} button next to Failed quiz")
    public void amSeeButtonNextToFailedQuiz(String details) {
        assertThat(getDriver().findElement(By.xpath("//tr/td[4]/span[contains(text(),'FAILED')]/../../td[6]//button")).isDisplayed());
        String button = getDriver().findElement(By.xpath("//td[6]//span")).getText();
        assertThat(button).isEqualTo(details);


    }

    @Then("Am do not see {string} button next to Pending quiz")
    public void amDoNotSeeButtonNextToPendingQuiz(String details) {
        List<WebElement> button = getDriver().findElements(By.xpath("//tr/td[4]/span[contains(text(),'PENDING')]/../../td[6]//button"));
        assertThat(button).isEmpty();
            }

    @When("AM click Details button")
    public void amClickDetailsButton() {
        getDriver().findElement(By.xpath("//tr[2]//td[6]//button")).click();
    }

    @Then("AM see Grades details page")
    public void amSeeGradesDetailsPage() {
        assertThat(getDriver().findElement(By.xpath("//ac-grade-details-page")).isDisplayed()).isTrue();
    }

    @And("AM can see points earned")
    public void amCanSeePointsEarned() throws InterruptedException {

        List<WebElement> points = getDriver().findElements(By.xpath("//td/span"));
        Thread.sleep(2000);
        for (WebElement point : points)
            assertThat(point.getText()).contains("+");
                }



    @And("AM can see answers")
    public void amCanSeeAnswers() {
        assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'Answer')]")).isDisplayed());
    }

    @Then("AM go to Quizzes")
    public void amGoToQuizzes() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains (text(),'Quizzes')]")).click();
        Thread.sleep(2000);
    }

    @And("AM click on Create New Quiz")
    public void amClickOnCreateNewQuiz() throws InterruptedException{
        getDriver().findElement(By.xpath("//span[contains (text(),'Create New Quiz')]")).click();
        Thread.sleep(2000);
    }

    @Then("AM type {string} as a title")
    public void amTypeAsATitle(String quizName) {
        getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(quizName);
    }

    @And("AM click on Add Question button")
    public void amClickOnAddQuestionButton() throws InterruptedException{
        getDriver().findElement(By.xpath("//span[contains(.,'Add Question')]")).click();
        Thread.sleep(2000);
    }

    @And("AM choose textual type of question")
    public void amChooseTextualTypeOfQuestion() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//*[contains(text(),'Textual')]")).click();
    }

    @Then("AM types {string} in textual question")
    public void amTypesInTextualQuestion(String questionT) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='Question *']")).sendKeys(questionT);
    }

    @Then("AM choose single-choice type of question")
    public void amChooseSingleChoiceTypeOfQuestion() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]/../../..//*[contains(text(),'Single-Choice')]")).click();
    }

    @And("AM types {string} is single choice question")
    public void amTypesIsSingleChoiceQuestion(String questionSC) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@placeholder='Question *']")).sendKeys(questionSC);

    }

    @And("AM save the Quiz")
    public void amSaveTheQuiz() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        Thread.sleep(2000);
    }

    @And("AM type {string} in the first answer option and mark as right question")
    public void amTypeInTheFirstAnswerOptionAndMarkAsRightQuestion(String answer) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys(answer);
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']/../../../../..//mat-radio-button")).click();

    }

    @And("AM type {string} in the second answer option")
    public void amTypeInTheSecondAnswerOption(String answer) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).sendKeys(answer);
    }

    @And("AM search for {string}")
    public void amSearchFor(String quiz) {
        getDriver().findElement(By.xpath("//span[contains(.,'My cool quiz')]"));

    }


    @Then("AM delete the quiz {string}")
    public void amDeleteTheQuiz(String quizName) throws InterruptedException{
        WebElement quize = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]"));
        quize.click();
        Thread.sleep(2000);
        WebElement deleteBtn = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]/../../../div//button/span[contains(text(),'Delete')]"));
        deleteBtn.click();
        Thread.sleep(2000);
        WebElement closeDialog = getDriver().findElement(By.xpath("//ac-modal-confirmation//button[2]"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(closeDialog);
        actions.click();
        actions.perform();
        Thread.sleep(3000);




    }

    @Then("AM delete all quizzes {string}")
    public void amDeleteAllQuizzes(String quizName) throws InterruptedException {
        List<WebElement> quizes = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]"));
        for (int i= 0; i< quizes.size(); i++)
            try {
                quizes.get(i).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]/../../../div//button/span[contains(text(),'Delete')]")).click();
                Thread.sleep(2000);
                Thread.sleep(2000);
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.xpath("//ac-modal-confirmation//button[2]")));
                actions.click();
                actions.perform();
                Thread.sleep(4000);
            } catch (StaleElementReferenceException e) {
                quizes = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]"));
                quizes.get(i).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]/../../../div//button/span[contains(text(),'Delete')]")).click();
                Thread.sleep(2000);
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.xpath("//ac-modal-confirmation//button[2]")));
                actions.click();
                actions.perform();
                Thread.sleep(4000);
            }

    }
}

