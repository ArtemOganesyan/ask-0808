package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class manukyanHw {



//    @And("I press on element with xpath {string}")
//    public boolean iPressOnElementWithXpathString(String xpath) {
//        boolean result = false;
//        int attempts = 0;
//        while (attempts<2) {try {
//            getDriver().findElement(By.xpath(xpath)).click();
//            result = true;
//            break;
//        } catch (StaleElementReferenceException e) {
//
//        }
//        attempts++;
//        }
//        return result;





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
        Thread.sleep(3000);
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
        assertThat(getDriver().findElement(By.xpath(amLibrary.myGradesPageXP)).isDisplayed()).isTrue();
    }

    @Then("AM see number of graded assignments in Grades statistics")
    public void amSeeNumberOfGradedAssignmentsInGradesStatistics() {
        assertThat(getDriver().findElement(By.xpath(amLibrary.gradedAssignmentsHPXP)).isDisplayed()).isTrue();
    }

    @Then("AM see number of assignments that need to be reviewed by teacher in Grades statistic")
    public void amSeeNumberOfAssignmentsThatNeedToBeReviewedByTeacherInGradesStatistic() {
        assertThat(getDriver().findElement(By.xpath("//p[contains (.,'but was(re) not reviewed by teacher yet.')]/span[@class='bold'][2]")).isDisplayed()).isTrue();
    }

    @Then("AM see column named Submitted At")
    public void amSeeColumnNamedSubmittedAt() throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath(amLibrary.submittedAtMyGradesXP)).isDisplayed()).isTrue();
        Thread.sleep(3000);
    }

    @And("AM see that first assignment was submitted at {string}")
    public void amSeeThatFirstAssignmentWasSubmittedAt(String dateTime)    {
        String actualDateTime = getDriver().findElement(By.xpath(amLibrary.dateTimeSubmittedMyGradesXP)).getText();
        assertThat(actualDateTime).contains(dateTime);

    }

    @Then("AM see column named Graded At")
    public void amSeeColumnNamedGradedAt() {
        assertThat(getDriver().findElement(By.xpath(amLibrary.gradedAtMyGradesXP)).isDisplayed()).isTrue();
    }

    @Then("AM verify that Graded at is {string}")
    public void amVerifyThatGradedAtIs(String gardedAt) {
        String actualGradedAt = getDriver().findElement(By.xpath("//tr[@class='ng-star-inserted'][last()]/td[2]")).getText();
        assertThat(actualGradedAt).isEqualTo(gardedAt);
    }

    @And("AM see column Quiz with quizzes names")
    public void amSeeColumnQuizWithQuizzesNames() {
        assertThat(getDriver().findElement(By.xpath(amLibrary.quizMygradesXP)).isDisplayed()).isTrue();
    }

    @And("AM see column Status")
    public void amSeeColumnStatus() {
        assertThat(getDriver().findElement(By.xpath(amLibrary.statusMygradesXP)).isDisplayed()).isTrue();
        String status = getDriver().findElement(By.xpath("//tr[@class='ng-star-inserted'][1]/td[4]")).getText();
        assertThat(status).isEqualToIgnoringCase("passed");
    }
}

