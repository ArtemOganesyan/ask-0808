package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class gichukiM {
    @Given("MG open url {string}")
    public void mgOpenUrl(String url) {
        getDriver().get(url);
    }

    @When("MG input email as {string}")
    public void mgInputEmailAs(String emailTeacher) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(emailTeacher);
    }

    @And("Input password as {string}")
    public void inputPasswordAs(String passwordTeacher) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(passwordTeacher);
    }

    @And("MG click on the sign-in button")
    public void mgClickOnTheSignInButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @And("MG wait for {int} sec")
    public void mgWaitForSec(int timeout) throws InterruptedException {
        Thread.sleep(3000);
    }

    @Then("MG redirected to {string} homepage")
    public void mgRedirectedToHomepage(String role) {
        getDriver().findElement(By.xpath("//p[contains(text(),'TEACHER')]")).isDisplayed();
    }

    @When("MG click on submissons")
    public void mgClickOnSubmissons(){
        getDriver().findElement(By.xpath("//span[contains(text(),'Go To Submissions')]")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(text(),'Submissions')]"))).click();
    }

    @And("MG click on automatic graded column")
    public void mgClickOnAutomaticGradedColumn() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[contains(text(),'Automatically Graded')]")).click();
    }

    @And("MG click on the filter icon")
    public void mgClickOnTheFilterIcon() {
        WebElement filter = getDriver().findElement(By.xpath("//span[@class='group-label']"));
        filter.click();
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='group-label']"))).click();
    }

    @And("Select group from group list")
    public void selectGroupFromGroupList() {
        getDriver().findElement(By.xpath("//span[contains(text(),'exp02')]")).click();
    }

    @And("MG clicks on review button for Bella Keys and quiz title is Test Multi-choice Quiz")
    public void mgClicksOnReviewButtonForBellaKeysAndQuizTitleIsTestMultiChoiceQuiz() {
        getDriver().findElement(By.xpath("//tbody/tr[2]/td[7]/a[1]/button[1]")).click();
    }
}
