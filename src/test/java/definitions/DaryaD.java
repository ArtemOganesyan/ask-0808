package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class DaryaD {
    @Given("I DD open url {string}")
    public void iDDOpenUrl(String url) {
        getDriver().get(url);
        assertThat(getDriver().getTitle()).containsIgnoringCase("Assessment Control @ Portnov");
    }

    @Then("Type DD the text {string} in the field with xpath {string}")
    public void typeTheTextStringInTheFieldWithXpathString(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
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

    @Then("Click DD the needed element with xpath {string}")
    public void clickDDTheNeededElementWithXpath(String xpath) {
        List<WebElement> array = getDriver().findElements(By.xpath(xpath));
        WebElement lastbutton = array.stream().reduce((first, second) -> second).orElseThrow();
        lastbutton.click();
    }

    @And("Verify DD that element with xpath {string} contain text {string}")
    public void verifyDDThatElementWithXpathContainText(String xpath, String text) {
        String actText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actText).containsIgnoringCase(text);
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
}
