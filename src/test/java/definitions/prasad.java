//package definitions;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import org.openqa.selenium.By;
//
//
//public class prasad {
//    @Given("MAP open url")
//    public void mapOpenUrl() {
//
//    }
//
//    @And("MAP type email and password")
//    public void mapTypeEmailAndPassword() {
//
//    }
//
//    @Given("MAP open url {string}")
//    public void mapOpenUrl(String url) {
//        getDriver().get("http://ask-stage.portnov.com");
//
//    }
//
//    @Then("MAP click on Register Now button")
//    public void mapClickOnRegisterNowButton() {
//        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).click();
//
//    }
//
//    @Then("MAP type {string} as firstName")
//    public void mapTypeAsFirstName(String firstName) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
//
//    }
//
//    @Then("MAP type {string} as lastName")
//    public void mapTypeAsLastName(String lastName) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
//
//    }
//
//    @Then("MAP type {string} as email")
//    public void mapTypeAsEmail(String email) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
//
//    }
//
//    @And("MAP type {string} as Group Code")
//    public void mapTypeAsGroupCode(String group) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group);
//
//    }
//
//    @Then("MAP type {string} as Password")
//    public void mapTypeAsPassword(String password) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
//
//    }
//
//    @Then("MAP click on Register Me button")
//    public void mapClickOnRegisterMeButton() {
//        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
//
//    }
//
//    @Then("MAP get registered message")
//    public void mapGetRegisteredMessage() {
//        //assertThatgetDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).isDisplayed();
//
//    }
//
//    @And("MAP type {string} as Confirm Password field")
//    public void mapTypeAsConfirmPasswordField(String confirmPassword) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
//    }
//
//    @Then("MAP get error message")
//    public void mapGetErrorMessage() {
//        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).isDisplayed());
//
//
//    }
//
//    @Then("MAP did not get registered message")
//    public void mapDidNotGetRegisteredMessage() {
//      assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).isDisplayed()).isFalse;
//
//    }
//
//    @Then("MAP get error message for mismatch of password")
//    public void mapGetErrorMessageForMismatchOfPassword() {
//        //assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).isDisplayed());
//
//    }
//}
