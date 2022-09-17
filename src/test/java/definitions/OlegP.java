package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java8.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Helpers;

import java.io.IOException;
import java.sql.SQLException;

import static support.TestContext.getDriver;

public class OlegP {

    private static String emailXpath = "//input[@formcontrolname='email']";
    private static String passXpath = "//input[@formcontrolname='password']";
    private static String signinBtnXpath = "//span[contains(text(),'Sign In')]";
    private static String studentLoggedIn = "//p[contains(text(),'STUDENT')]";
    private static String myAssigmentsXpath = "//h5[contains(text(),'My Assignments')]";
    private static String myGradesXpath = "//h5[contains(text(),'My Grades')]";
    private static String teacherLoggedIn="//p[contains(text(),'TEACHER')]";




    @Given("OP navigate to login page {string}")
    public void opNavigateToLoginPage(String url) {
        getDriver().get(url);
    }

    @Then("OP enter email {string}")
    public void opEnterEmail(String email) {
        getDriver().findElement(By.xpath(emailXpath)).sendKeys(email);
    }

    @Then("OP enter password {string}")
    public void opEnterPassword(String password) {
        getDriver().findElement(By.xpath(passXpath)).sendKeys(password);
    }


    @Then("OP click Sign-in button")
    public void opClickSignInButton() {
        getDriver().findElement(By.xpath(signinBtnXpath)).click();
    }

    @And("OP wait for {int} seconds")
    public void opWaitForSeconds(int timeout) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(studentLoggedIn)));

    }

    @Given("OP click {string} button")
    public void opClickButton(String myAssigments) throws InterruptedException {
        getDriver().findElement(By.xpath(myAssigmentsXpath)).click();
    }

    @Then("OP see their assigments within {int} seconds")
    public void opSeeTheirAssigmentsWithinSeconds(int timeout) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'My Assignments')]")));
    }

    @Given("OP click on {string}")
    public void opClickOn(String arg0) {
        getDriver().findElement(By.xpath(myGradesXpath)).click();
    }

    @Then("OP see their grades within {int} seconds")
    public void opSeeTheirGradesWithinSeconds(int timeout) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'My Grades')]")));
    }

    @Given("OP click {string}")
    public void opClick(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).isDisplayed();
    }



    @Given("OP go to login page {string}")
    public void opGoToLoginPage(String url) {
        getDriver().get(url);
    }

    @Given("OP fill out all fields required to register new student")
    public void opFillOutAllFieldsRequiredToRegisterNewStudent() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("Oleg");
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Pasish");
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("olegst@gmail.com");
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys("GRP123");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("portnov123");
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys("portnov123");
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//span[contains(text(),'Back to Login Page')]")).isDisplayed();
    }


    @Then("OP confirm the registration email")
    public void opConfirmTheRegistrationEmail() throws SQLException, IOException {
        String acToc = Helpers.getAccessToken("olegst@gmail.com");
        System.out.println(acToc);
        String[] resp = acToc.split(";");
        int userId = Integer.valueOf(resp[0]);
        String activationCode = resp[1];
        Helpers.activateUser(userId, activationCode);
    }


    @Given("OP fill in email {string} and password {string}")
    public void opFillInEmailAndPassword(String email, String password) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        Thread.sleep(1000);
    }

    @Then("OP  log in as Teacher")
    public void opLogInAsTeacher() {
        getDriver().findElement(By.xpath("//p[contains(text(),'TEACHER')]")).isDisplayed();
    }

    @Given("OP submit email {string} for password reset")
    public void opSumbitEmailForPasswordReset(String email) throws InterruptedException {
        getDriver().findElement(By.xpath("//a[contains(text(),'I forgot my password')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Request Password Reset')]")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//span[contains(text(),'Request Password Reset')]")).click();

    }

    @And("then OP wait for {int} seconds")
    public void thenOPWaitForSeconds(int timeout) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Your request is confirmed')]")));
    }


    @Then("OP confirm password reset email")
    public void opConfirmPasswordResetEmail() throws SQLException, IOException {
        String acToc = Helpers.getAccessToken("olegst@gmail.com");
        System.out.println(acToc);
        String[] resp = acToc.split(";");
        int userId = Integer.valueOf(resp[0]);
        String activationCode = resp[1];
        Helpers.activateUser(userId, activationCode);
        getDriver().findElement(By.xpath("//input[@placeholder='New Password']")).sendKeys("portnov123");
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm New Password']")).sendKeys("portnov123");
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm New Password']")).click();

    }


    @Given("OP log with teacher email:{string} and password {string}")
    public void opLogWithTeacherEmailAndPassword(String email, String password) throws InterruptedException {
        getDriver().findElement(By.xpath(emailXpath)).sendKeys(email);
        getDriver().findElement((By.xpath(passXpath))).sendKeys(password);
        getDriver().findElement(By.xpath(signinBtnXpath)).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(teacherLoggedIn)).isDisplayed();

    }

    @Then("OP delete user profile of student {string}")
    public void opDeleteUserProfileOfStudent(String user) throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Management')]")).click();
        getDriver().findElement(By.xpath("//h4[contains(text(),'Management')]")).isDisplayed();
        getDriver().findElement(By.xpath("//h4[contains(text(),'Oleg Pasish')]")).isDisplayed();
        WebElement element1=getDriver().findElement(By.xpath("//h4[contains(text(),'Oleg Pasish')]"));
        Actions action=new Actions(getDriver());
        action.moveToElement(element1);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//h4[contains(text(),'Oleg Pasish')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//td[contains(text(),'olegst@gmail.com')]")).isDisplayed();
        getDriver().findElement(By.xpath("//span/mat-icon[contains(text(), 'settings')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button/mat-icon[contains(text(), 'delete')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[contains(text(),'Students')]")).isDisplayed();
//        WebElement element= getDriver().findElement(By.xpath("//h4[contains(text(),'Oleg Pasish')]"));
//        Assert.assertNull(element);
    }

    @Given("OP log in Teacher account")
    public void opLogInTeacherAccount() throws InterruptedException {
        getDriver().findElement(By.xpath(emailXpath)).sendKeys("olegteacher@gmail.com");
        getDriver().findElement(By.xpath(passXpath)).sendKeys("portnov123");
        getDriver().findElement(By.xpath(signinBtnXpath)).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath(teacherLoggedIn)).isDisplayed();
        Thread.sleep(1500);
    }

    @Then("OP change Student role to Teacher")
    public void opChangeStudentRoleToTeacher() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Management')]")).click();
        getDriver().findElement(By.xpath("//h4[contains(text(),'Management')]")).isDisplayed();
        getDriver().findElement(By.xpath("//h4[contains(text(),'Oleg P')]")).isDisplayed();
        WebElement element1=getDriver().findElement(By.xpath("//h4[contains(text(),'Oleg P')]"));
        Actions action=new Actions(getDriver());
        action.moveToElement(element1);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//h4[contains(text(),'Oleg P')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//td[contains(text(),'oleg.pasishnychenko+ta@gmail.com')]")).isDisplayed();
        getDriver().findElement(By.xpath("//span/mat-icon[contains(text(), 'settings')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button/mat-icon[contains(text(),'school')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Change Role')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//td[contains(text(),'TEACHER')]")).isDisplayed();



    }

    @Given("OP sign in Teacher account")
    public void opSignInTeacherAccount() throws InterruptedException{
        getDriver().findElement(By.xpath(emailXpath)).sendKeys("olegteacher@gmail.com");
        getDriver().findElement(By.xpath(passXpath)).sendKeys("portnov123");
        getDriver().findElement(By.xpath(signinBtnXpath)).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath(teacherLoggedIn)).isDisplayed();
        Thread.sleep(1500);

    }

    @Then("OP change Teacher role to Student")
    public void opChangeTeacherRoleToStudent() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Management')]")).click();
        getDriver().findElement(By.xpath("//h4[contains(text(),'Management')]")).isDisplayed();
        getDriver().findElement(By.xpath("//div[contains(text(),'Teachers')]")).click();
        WebDriverWait wait=new WebDriverWait(getDriver(),2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Oleg P')]")));
        WebElement element1=getDriver().findElement(By.xpath("//h4[contains(text(),'Oleg P')]"));
        Actions action=new Actions(getDriver());
        action.moveToElement(element1);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//h4[contains(text(),'Oleg P')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//td[contains(text(),'oleg.pasishnychenko+ta@gmail.com')]")).isDisplayed();
        getDriver().findElement(By.xpath("//span/mat-icon[contains(text(), 'settings')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button/mat-icon[contains(text(),'school')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Change Role')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//td[contains(text(),'STUDENT')]")).isDisplayed();
    }
}