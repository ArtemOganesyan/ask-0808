package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;

public class gichuki {
    @When("I open the Portnov page")
    public void iOpenThePortnovPage() {
        getDriver().get("http://ask-stage.portnov.com");
        //getDriver().navigate().to("http://ask-stage.portnov.com");
    }

    @And("I input valid teacher email")
    public void iInputValidTeacherEmail() {
        WebElement teacherEmail = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
        teacherEmail.sendKeys("wangui918@gmail.com");
    }

    @And("I input valid teacher password")
    public void iInputValidTeacherPassword() {
        WebElement teacherPassword = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        teacherPassword.sendKeys("12345");
    }

    @And("I click on sign in button")
    public void iClickOnSignInButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("I should be redirected to teacher's homepage")
    public void iShouldBeRedirectedToTeacherSHomepage() {
        getDriver().findElement(By.xpath("//div[@class='info']")).isDisplayed();
    }

    @When("I select Quizzes on the sidebar menu")
    public void iSelectQuizzesOnTheSidebarMenu() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }

    @And("I create a new quiz")
    public void iCreateANewQuiz() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }

    @And("I input quiz title")
    public void iInputQuizTitle() {
        WebElement quizTitle = getDriver().findElement(By.xpath("//input[@formcontrolname='name']"));
        quizTitle.sendKeys("Ask-0808 Test Multichoice Quiz 1");
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }
}
