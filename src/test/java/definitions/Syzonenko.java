package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static support.TestContext.getDriver;

public class Syzonenko {
    private static final String logInEmailXpath = "//input[@formcontrolname='email']";
    private static final String  logInPasswordXpath = "//input[@formcontrolname='password']";
    private static final String logInSignInBtn = "//span[contains(text(),'Sign In')]";
    static final String DB_URL = "jdbc:mysql://44.205.92.189:3307/application?autoReconnect=true&useSSL=false";
    static final String USER = "testuser";
    static final String PASS = "password";
    private Integer userId;
    private String resetPasswordActivationCode;

    private static String getPasswordConfirmationCode(String userEmail) throws SQLException {
        String result = "No data";
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

        try(PreparedStatement pstmt = con.prepareStatement("SELECT id, activationCode FROM users WHERE email = ?")) {
            pstmt.setString(1, userEmail);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result = rs.getString("id") + ";" + rs.getString("activationCode");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static void activateUser(int userId, String activationCode) throws IOException {
        URL url = new URL("http://ask-stage.portnov.com/api/v1/activate/" + userId + "/" + activationCode);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "USER_AGENT");

        int responseCode = con.getResponseCode();
        System.out.println("Activation request response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response);
        } else {
            System.out.println("Error occurred while trying to send get request");
        }
    }
    private static void resetPassword (int userId, String resetPasswordActivationCode, String newPassword) throws IOException {
        String inputJson = "{\"password\":" + " " + '"' + newPassword + "\"}";
        System.out.println(inputJson);
        URL url = new URL("http://ask-stage.portnov.com/api/v1/reset-password/"+userId+"/"+resetPasswordActivationCode+"");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()){
            byte[] input = inputJson.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        int responseCode = con.getResponseCode();
        boolean statusCode = false;
        System.out.println("Response code is: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);
            Assert.assertFalse(statusCode);
        } else {
            System.out.println("Error occurred while trying to send POST request");
            //noinspection ConstantConditions
            Assert.assertTrue(statusCode);
        }

    }

    private void WaitUntillElementVisibility (String elementXpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementXpath)));
    }
    private void WaitUntillElementClickable (String elementXpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }


    @Given("SK open page {string}")
    public void iOpenPage(String url) {
        getDriver().get(url);
    }

    @And("SK log in as Teacher")
    public void iLogInAsTeacher(){
        getDriver().findElement(By.xpath(logInEmailXpath)).sendKeys("teacher.account@gmail.com");
        getDriver().findElement(By.xpath(logInPasswordXpath)).sendKeys("Teacher");
        getDriver().findElement(By.xpath(logInSignInBtn)).click();
        WaitUntillElementVisibility("//p[contains(text(),'TEACHER')]");
    }

    @Then("SK should see role as {string}")
    public void iShouldSeeRoleAs(String role) {
        String actualrole = getDriver().findElement(By.xpath("//div[@class='info']/p")).getText();
        Assert.assertEquals(actualrole, role);
    }

    @And("SK click Assigments button")
    public void iClickAssigmentsButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        Thread.sleep(4000);

    }

    @And("SK click Create New Assignment button")
    public void iClickCreateNewAssignmentButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Assignment')]")).click();
    }

    @And("SK select quiz {string} from 'Select quiz to assgin' drop-down list")
    public void iSelectQuizFromSelectQuizToAssginDropDownList(String quizName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(), '"+quizName+"')]")).click();
    }

    @And("SK select Student from 'Students list'")
    public void iSelectStudentFromStudentsList() {
        getDriver().findElement(By.xpath("//span[contains(text(),'TEST90')]/parent::div/preceding-sibling::mat-pseudo-checkbox")).click();
    }

    @And("SK click Give Assignment button")
    public void iClickGiveAssignmentButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
        Thread.sleep(4000);
    }

    @Then("SK should see quiz {string} assignment details on Assignments page")
    public void iShouldSeeQuizAssignmentDetailsOnAssignmentsPage(String quizName) {
        String actual = getDriver().findElement(By.xpath("//mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title[3]")).getText().substring(6);
        String dateDetails = getDriver().findElement(By.xpath("//mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title[1]")).getText().substring(17);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        Assert.assertEquals(actual, quizName);
        Assert.assertEquals(dateDetails, format.format(date));

    }

    @And("SK select group code {string} from Group filter drop-down list")
    public void iSelectGroupCodeFromGroupFilterDropDownList(String groupCode){
        getDriver().findElement(By.xpath("//mat-select[1]/div[1]/div[2]")).click();
        WaitUntillElementVisibility("//span[contains(text(),'"+groupCode+"')]/parent::mat-option");
        getDriver().findElement(By.xpath("//span[contains(text(),'"+groupCode+"')]/parent::mat-option")).click();
    }

    @And("SK click 'Select All' button")
    public void iClickSelectAllButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select All')]")).click();
    }

    @Then("SK should see 'Select at least one Student' error message")
    public void iShouldSeeSelectAtLeastOneStudentErrorMessage() {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//mat-error[contains(text(),'Select at least one Student')]")));
        String errormsg = getDriver().findElement(By.xpath("//mat-error[contains(text(),'Select at least one Student')]")).getText();
        Assert.assertEquals(errormsg, "Select at least one Student");
    }

    @Then("SK should see 'This field is required' error message")
    public void iShouldSeeThisFieldIsRequiredErrorMessage() {
        String errormsg = getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).getText();
        Assert.assertEquals(errormsg, "This field is required");
    }

    @And("SK log out from current account")
    public void iLogOutFromCurrentAccount() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        Thread.sleep(2000);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
        Thread.sleep(2000);
    }

    @And("SK log in as Student")
    public void iLogInAsStudent() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys("student.account@gmail.com");
        getDriver().findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Student");
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        Thread.sleep(3000);
    }

    @And("SK click My Assigments button")
    public void iClickMyAssigmentsButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Assignments')]")).click();
        Thread.sleep(3000);
    }

    @And("SK click Go to Assessment button for quiz {string}")
    public void iClickGoToAssessmentButton(String quizName) {
        getDriver().findElement(By.xpath("//td[contains(text(),'"+quizName+"')]/..//button")).click();
    }

    @And("SK select radio button number {int} as an anwser for question number {int}")
    public void iSelectRadioButtonNumberAsAnAnwserForQuestionNumber(int optionNumber, int questionNumber) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Question "+questionNumber+"')]/ancestor::mat-card//div/mat-radio-group/mat-radio-button["+optionNumber+"]/label/div/div[2]")).click();
    }

    @And("SK select check-box number {int} as an anwser for question number {int}")
    public void iSelectCheckBoxNumberAsAnAnwserForQuestionNumber(int optionNumber, int questionNumber) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Question "+questionNumber+"')]/ancestor::mat-card//mat-checkbox["+optionNumber+"]/label/div")).click();
    }

    @And("SK click Submit my Answer button")
    public void iClickSubmitMyAnswerButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Submit My Answers')]")).click();
        Thread.sleep(3000);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER);
        actions.perform();
    }

    @When("SK click My Grades button")
    public void iClickMyGradesButton() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Grades')]")).click();
    }

    @Then("SK should see quiz {string} with Status: {string}")
    public void iShouldSeeQuizWithStatus(String quizName, String status) {
        String actualStatus = getDriver().findElement(By.xpath(
                "//td[contains(text(),'"+quizName+"')]/following-sibling::td/span")).getText();
        String actualQuizName = getDriver().findElement(By.xpath("//td[contains(text(),'"+quizName+"')]")).getText();
        Assert.assertEquals(actualQuizName, quizName);
        Assert.assertEquals(actualStatus, status);
    }

    @Then("SK delete Assigments with quiz name {string}")
    public void iDeleteAssigmentsWithQuizName(String quizName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10,200);
        List<WebElement> allquizes = getDriver().findElements(By.xpath("//span[contains(text(),'"+quizName+"')]/ancestor::mat-panel-title/following-sibling::mat-panel-title/button/span/mat-icon"));

        for (int i= 0; i<= allquizes.size(); i++)
            try {
                allquizes.get(i).click();
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Delete Assignment')]")));
                getDriver().findElement(By.xpath("//span[contains(text(),'Delete Assignment')]")).click();
                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Delete')]")));
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")));
                actions.click();
                actions.perform();
                Thread.sleep(4000);
            } catch (StaleElementReferenceException e) {
                allquizes = getDriver().findElements(By.xpath("//span[contains(text(),'"+quizName+"')]/ancestor::mat-panel-title/following-sibling::mat-panel-title/button/span/mat-icon"));
                allquizes.get(i).click();
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Delete Assignment')]")));
                getDriver().findElement(By.xpath("//span[contains(text(),'Delete Assignment')]")).click();
                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Delete')]")));
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")));
                actions.click();
                actions.perform();
                Thread.sleep(4000);
            }
    }

    @And("SK click Settings button")
    public void skClickSettingsButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Settings')]")).click();
        Thread.sleep(1000);
    }

    @And("SK click Change Your Password")
    public void skClickChangeYourPassword() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Change Your Password')]")).click();
        Thread.sleep(2000);
    }

    @Then("SK type {string} in current Password field")
    public void skTypeInCurrentPasswordField(String oldPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(oldPassword);
    }

    @Then("SK type {string} in New Password field")
    public void skTypeInNewPasswordField(String newPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']")).sendKeys(newPassword);
    }

    @Then("SK type {string} in Confirm New Password")
    public void skTypeInConfirmNewPassword(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @Then("SK click Change button")
    public void skClickChangeButton() {
        getDriver().findElement(By.xpath("//button[@aria-label]//span[contains(text(),'Change')]")).click();
    }

    @Then("SK get password reset token")
    public void skGetPasswordResetToken() throws SQLException {
        String passwordConfirmationCode = getPasswordConfirmationCode("student.account@gmail.com");
        String[] values = passwordConfirmationCode.split(";");
        String id = values[0];
        String code = values[1];
        System.out.println("id value is:" + id + "and code value is:" + code);
    }

    @Then("SK type {string} in email field")
    public void skTypeInEmailField(String email) {
        getDriver().findElement(By.xpath(logInEmailXpath)).sendKeys(email);
    }

    @Then("SK type {string} in password field")
    public void skTypeInPasswordField(String password) {
        getDriver().findElement(By.xpath(logInPasswordXpath)).sendKeys(password);
    }

    @Then("SK click Sign In button")
    public void skClickSignInButton() throws InterruptedException {
        getDriver().findElement(By.xpath(logInSignInBtn)).click();
        Thread.sleep(3000);
    }

    @Then("SK click I forgot my password link")
    public void iClickIForgotMyPasswordLink() {
        getDriver().findElement(By.xpath("//a[contains(text(),'I forgot my password')]")).click();
    }

    @Then("SK type {string} into Reset password email field")
    public void iTypeIntoResetPasswordEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("SK click Request Password Reset button")
    public void iClickRequestPasswordResetButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Request Password Reset')]")).click();
        Thread.sleep(3000);
    }

    @Then("SK should see 'Your request is confirmd' message")
    public void iShouldSeeYourRequestIsConfirmdMessage() {
        String confirmMsg = getDriver().findElement(By.xpath("//h4[contains(text(),'Your request is confirmed')]")).getText();
        Assert.assertEquals(confirmMsg, "Your request is confirmed");
    }

    @And("SK get Reset Password activation code for user with email {string}")
    public void iGetResetPasswordActivationCodeForUserWithEmail(String email) throws SQLException {
        String response = getPasswordConfirmationCode(email);
        String[] values = response.split(";");
        userId = Integer.parseInt(values[0]);
        resetPasswordActivationCode = values[1];
        System.out.println("id value is:"+ userId + "" + "and activation code value is:" + resetPasswordActivationCode);

    }

    @Then("SK set new password as {string}")
    public void iSetNewPasswordAs(String newPassword) throws IOException {
        resetPassword(userId, resetPasswordActivationCode, newPassword);
    }

    @Then("SK click browser Back button")
    public void skClickBrowserBackButton() throws InterruptedException {
        getDriver().navigate().back();
        Thread.sleep(1500);
    }

    @Then("SK clikc 'Back to Log In' button")
    public void skClikcBackToLogInButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Back to Login')]")).click();
        Thread.sleep(1000);
    }
}
