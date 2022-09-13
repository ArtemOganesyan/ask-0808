package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class Sawant {
    private static String emailXpath = "//input[@formcontrolname='email']";
    private static String passXpath = "//input[@formcontrolname='password']";
    private static String signInBtnXpath = "//span[contains(text().'Sign In')]";
    
    @Given("I like to verify")
    public void iLikeToVerify() {
        
    }

    @Then("I do some other stuff")
    public void iDoSomeOtherStuff() {

    }

    @Given("SS go to {string} page")
    public void ssGoToPage(String url) {
        getDriver().get(url);
    }

    @Then("SS type {string} into email field")
    public void ssTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath(emailXpath)).sendKeys(email);
    }

    @Then("SS enter {string} as password")
    public void ssEnterAsPassword(String password) {
        getDriver().findElement(By.xpath(passXpath)).sendKeys(password);
    }

    @Then("SS click SignIn button")
    public void ssClickSignInButton() {
        getDriver().findElement(By.xpath(signInBtnXpath)).click();
    }

    @And("SS wait for {int} sec ")
    public void ssWaitForSec(int timeout) throws InterruptedException {
        Thread.sleep(1000);



    }
}
