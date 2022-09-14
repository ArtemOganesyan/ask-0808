package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class OlegP {
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
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]"));

    }
}
