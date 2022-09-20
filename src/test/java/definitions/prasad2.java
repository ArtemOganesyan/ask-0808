package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class prasad2 {
    private static String emailXpath = "//input[@formcontrolname='email']";
    private static String passXpath = "//input[@formcontrolname='password']";
    private static String signInXpath = "//span[contains(text(),'Sign In')]";
    private static String myAssignmentsMenuXpath = "//h5[contains(text(),'My Assignments')]";
    private static String myGradesMenuXpath = "//h5[contains(text(),'My Grades')]";
    private static String myAssignmentstitleXpath = "//h4[contains(text(),'My Assignments')]";
    private static String myGradestitleXpath = "//h4[contains(text(),'My Grades')]";






    @Given("MP open url {string}")
    public void mpOpenUrl(String url) {
        getDriver().get(url);
    }

    @Then("MP click Register Now button")
    public void mpClickRegisterNowButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).click();
    }


    @Then("MP type {string} in firstName field")
    public void mpTypeInFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @Then("MP type {string} in lastName field")
    public void mpTypeInLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @Then("MP type {string} in email field")
    public void mpTypeInEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("MP type {string} in group field")
    public void mpTypeInGroupField(String group) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group);
    }

    @Then("MP type {string} in password field")
    public void mpTypeInPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("MP type {string} in confirmPassword field")
    public void mpTypeInConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @Then("MP type all required field")
    public void mpTypeAllRequiredField() {
        WebElement firstName=getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']"));firstName.sendKeys("Madhu");
        WebElement lastName=getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']"));lastName.sendKeys("T");
        WebElement email=getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));email.sendKeys("testteer051@gmail.com");
        WebElement group=getDriver().findElement(By.xpath("//input[@formcontrolname='group']"));group.sendKeys("ABC");
        WebElement password=getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));password.sendKeys("12345Abc");
        WebElement confirmPassword=getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']"));confirmPassword.sendKeys("12345Abc");


            }

    @And("MP click Register Me button")
    public void mpClickRegisterMeButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }


    @Given("MP navigate to url {string}")
    public void mpNavigateToUrl(String url) {
        getDriver().get(url);
    }


    @Then("MP fill out all required field")
    public void mpFillOutAllRequiredField() {
        WebElement firstName=getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']"));firstName.sendKeys("");
        WebElement lastName=getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']"));lastName.sendKeys("T");
        WebElement email=getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));email.sendKeys("testteer051@gmail.com");
        WebElement group=getDriver().findElement(By.xpath("//input[@formcontrolname='group']"));group.sendKeys("ABC");
        WebElement password=getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));password.sendKeys("12345Abc");
        WebElement confirmPassword=getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']"));confirmPassword.sendKeys("12345Abc");
    }

//    @Then("MP wait {int} sec")
//    public void mpWaitSec(int timeout) throws InterruptedException {
//        sleep(2000);
//    }

//    @Then("MP get error message")
//    public void mpGetErrorMessage() {
//        getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).isDisplayed();
//
//    }

    @Then("MP get registered message")
    public void mpGetRegisteredMessage() {
        getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).isDisplayed();
    }

    @Then("MP click SignIn button")
    public void mpClickSignInButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();

    }
    @And("MP wait {int} sec")
    public void mpWaitSec(int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(),timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myAssignmentsMenuXpath)));
    }



    @Then("MP click on Assignments")
    public void mpClickOnAssignments() {
        getDriver().findElement(By.xpath(myAssignmentsMenuXpath)).click();
        assertThat(getDriver().findElement(By.xpath(myAssignmentstitleXpath)).isDisplayed());
    }

    @Then("MP click on grades")
    public void mpClickOnGrades() {
        getDriver().findElement(By.xpath(myGradesMenuXpath)).click();
        assertThat(getDriver().findElement(By.xpath(myGradestitleXpath)).isDisplayed());
    }

    @Then("MP will wait {int} sec")
    public void mpWillWaitSec(int timeout) throws InterruptedException {
        Thread.sleep(1000);
    }


//    @Then("MP did not get registered message")
//    public void mpDidNotGetRegisteredMessage() {
//        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]"))).isDisplayed().isFalse;
//    }




//       @Then("MP get mat-error message")
//    public void mpGetMatErrorMessage() {
//     assertThatgetDriver().findElement(By.xpath("//mat-error-2[contains(text(),'Entered passwords should match')]")).isDisplayed()isTrue();
//   }
//
//
//    @Then("MP get text message")
//    public void mpGetTextMessage() {
//        assertThat(getDriver().findElement(By.xpath("//mat-error-2[contains(text(),'Entered passwords should match')]")).isDisplayed());
//
//    }

    }

