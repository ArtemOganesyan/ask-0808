package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Helpers;

import java.io.IOException;
import java.sql.SQLException;

import static support.TestContext.getDriver;

public class OlegP {

    private static String emailXpath="//input[@formcontrolname='email']";
    private static String passXpath="//input[@formcontrolname='password']";
    private static String signinBtnXpath="//span[contains(text(),'Sign In')]";
    private static String studentLoggedIn="//p[contains(text(),'STUDENT')]";
    private static String myAssigmentsXpath="//h5[contains(text(),'My Assignments')]";
    private static String myGradesXpath="//h5[contains(text(),'My Grades')]";


    @Given("OP navigate to home page")
    public void opNavigateToHomePage() {
        getDriver().navigate().to("http://ask-stage.portnov.com/");
    }

    @Then("OP log in")
    public void opLogIn() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("olegp123@gmail.com");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("portnov123");
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//p[contains(text(),'STUDENT')]")).isDisplayed();
    }

    @Given("OP log out")
    public void opLogOut() throws InterruptedException{
        getDriver().navigate().to("http://ask-stage.portnov.com/");
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("olegp123@gmail.com");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("portnov123");
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//p[contains(text(),'STUDENT')]")).isDisplayed();
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).isDisplayed();

    }


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
        WebDriverWait wait= new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(studentLoggedIn)));

    }

    @Given("OP click {string} button")
    public void opClickButton (String myAssigments) throws InterruptedException {
        getDriver().findElement(By.xpath(myAssigmentsXpath)).click();
    }

    @Then("OP see their assigments within {int} seconds")
    public void opSeeTheirAssigmentsWithinSeconds(int timeout) throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'My Assignments')]")));
    }

    @Given("OP click on {string}")
    public void opClickOn(String arg0) {
        getDriver().findElement(By.xpath(myGradesXpath)).click();
    }

    @Then("OP see their grades within {int} seconds")
    public void opSeeTheirGradesWithinSeconds(int timeout) throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'My Grades')]")));
    }

    @Given("OP click {string}")
    public void opClick(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).isDisplayed();
    }

    @Given("OP start registering new student")
    public void opStartRegisteringNewStudent () throws InterruptedException{
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).isDisplayed();
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).click();
        getDriver().findElement(By.xpath("//span[contains (text(), 'Back to Login')]")).isDisplayed();
        Thread.sleep(1000);


    }

    @Then("OP fill out all fields required to register a new student")
    public void opFillOutAllFieldsRequiredForRegistration() throws InterruptedException{
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

    @Then("OP confirm registration email")
    public void opConfirmRegsitrationEmail() throws SQLException, IOException {
        String acToc= Helpers.getAccessToken("olegst@gmail.com");
        System.out.println(acToc);
        String[] resp=acToc.split(";");
        int userId=Integer.valueOf(resp[0]);
        String activationCode=resp[1];
        Helpers.activateUser(userId,activationCode);
    }


}
