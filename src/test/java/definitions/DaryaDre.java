/*
 * Created by Darya Dreizina on 09.14.2022
 */
package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//https://www.javatpoint.com/selenium-waits
import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class DaryaDre {
    private static String emailXpath = "//input[@formcontrolname='email']";
    private static String passwordXpath = "//input[@formcontrolname='password']";
    private static String signInBtn = "//span[contains(text(),'Sign In')]";

    @Given("DD open url {string}")
    public void iDDOpenUrl(String url) throws InterruptedException {
        getDriver().get(url);
        Thread.sleep(5 * 1000);
    }

    @Then("Type DD the email {string} in the email field")
    public void typeDDTheEmailInTheEmailField(String email) {
        getDriver().findElement(By.xpath(emailXpath)).sendKeys(email);
    }

    @Then("Type DD the password {string} in the password field")
    public void typeDDThePasswordInThePasswordField(String pwd) {
        getDriver().findElement(By.xpath(passwordXpath)).sendKeys(pwd);
    }

    @Then("Click DD on the Sign In button")
    public void clickDDOnTheSignInButton() throws InterruptedException {
        getDriver().findElement(By.xpath(signInBtn)).click();
        Thread.sleep(7 * 1000);
    }

    @And("DD assign the quiz to the student")
    public void ddAssignTheQuizToTheStudent() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        Thread.sleep(5 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Assignment')]")).click();
        Thread.sleep(5 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'N001')]")).click();
        Thread.sleep(5 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
        Thread.sleep(5 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'DaryaDre Quize Automation')]")).click();
        Thread.sleep(5 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
        Thread.sleep(5 * 1000);
    }

    @And("DD logout as a Teacher")
    public void ddLogoutAsATeacher() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(2 * 1000);
    }

    @Then("Click DD on the Go To Assessments button")
    public void clickDDOnTheGoToAssessmentsButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Go To My Assignments')]")).click();
        Thread.sleep(2 * 1000);
    }

    @Then("Click DD on the Go To Assessment button")
    public void clickDDOnTheGoToAssessmentButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Go To Assessment')]")).click();
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
    public void ddClickOnTheSubmitMyAnswersButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Submit My Answers')]")).click();
        Thread.sleep(2 * 1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
        Thread.sleep(2 * 1000);
    }

    @Then("Click DD on the My Home")
    public void clickDDOnTheMyHome() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Home')]")).click();
        Thread.sleep(3 * 1000);
    }

    @Then("Click DD on the Go To My Grades")
    public void clickDDOnTheGoToMyGrades() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Go To My Grades')]")).click();
        Thread.sleep(2 * 1000);
    }

    @Then("Click DD on the Details button")
    public void clickDDOnTheDetailsButton() {

        var items = getDriver().findElements(By.xpath("//span[contains(text(),'Details')]"));
        var lastbutton = items.get(items.size()-1);
        lastbutton.click();

//        List<WebElement> array = getDriver().findElements(By.xpath("//span[contains(text(),'Details')]"));
//        WebElement lastbutton = array.stream().reduce((first, second) -> second).orElseThrow();
//        lastbutton.click();
    }

    @And("DD verify the Other text area contains provided text {string}")
    public void verifyDDThatElementWithXpathContainText(String text) {
        String actText = getDriver().findElement(By.xpath("//div[@class='ng-star-inserted']")).getText();
        assertThat(actText).contains(text);
    }

    @And("Delete DD ALL assignments")
    public void deleteDDAssignment() throws InterruptedException {
        //logout as a student
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(3 * 1000);
        //login as a teacher
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("da.dreizina@gmail.com");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345Abc");
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        Thread.sleep(3 * 1000);
        //delete the assignment LOOP
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        Thread.sleep(1000);
        Optional<WebElement> quiz = Optional.ofNullable(getDriver().findElement(By.xpath("//*[contains(text(),'DaryaDre Quize Automation')]")));

        while (quiz.isPresent()) {
            System.out.println(quiz);
            WebElement btn = quiz.get().findElement(By.xpath("parent::mat-panel-title/following::mat-panel-title[1]/button"));
            btn.click();
            Thread.sleep(3 * 1000);
            WebElement menu = getDriver().findElement(By.xpath("//span[contains(text(),'Delete Assignment')]"));
            menu.click();
            Thread.sleep(3 * 1000);
            WebElement action = getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]"));
            action.click();
            Thread.sleep(5 * 1000);

            WebElement current;
            try {
                current = getDriver().findElement(By.xpath("//*[contains(text(),'DaryaDre Quize Automation')]"));
            } catch (NoSuchElementException e) {
                current = null;
            }
            quiz = Optional.ofNullable(current);
        }
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();

//    @Then("DD Pass the quiz with the {int} characters in the Other field")
//    public void ddTypeIntCharactersInTheOtherField(int number) {
//        getDriver().findElement(By.xpath("//textarea[@placeholder='Enter your answer']")).sendKeys("DaryaD");
//        getDriver().findElement(By.xpath("//label[@for='mat-radio-3-input']")).click();
//        getDriver().findElement(By.xpath("//label[@for='mat-checkbox-2-input']")).click();
//        getDriver().findElement(By.xpath("//label[@for='mat-checkbox-3-input']")).click();
//
//        boolean useletters = true;
//        boolean usenumbers = false;
//        String generatedString = RandomStringUtils.random(number, useletters, usenumbers);
//        getDriver().findElement(By.xpath("//textarea[@placeholder='Other']")).sendKeys(generatedString);
//
//        String randomText1000 = getDriver().findElement(By.xpath("//textarea[@placeholder='Other']")).getText();
//        randomText10001().
}
}
