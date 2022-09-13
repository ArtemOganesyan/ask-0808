package definitions;

public class amLibrary {
    public static String url = "http://ask-stage.portnov.com/";
    public static String emailXP="//input[@formcontrolname='email']";
    public static String passwordXP = "//input[@formcontrolname='password']";
    public static String signInBtnXP = "//span[contains(text(),'Sign In')]";
    public static String myAssignmentsMenuXP = "//h5[contains(text(),'My Assignments')]";
    public static String createAssignmentXP = "//span[contains(text(),'Create New Assignment')]";
    public static String myGradesMenuXP = "//h5[contains(text(),'My Grades')]";
    public static String myAssignmentsTitleXP = "//h4[contains(text(),'My Assignments')]";
    public static String assignmentsMenuXP = "//h5[contains(text(),'Assignments')]";
    public static String myGradesTitleXP = "//h4[contains(text(),'My Grades')]";
    public static String quizzesXP = "//h5[contains(text(),'Quizzes')]";
    public static String createQuizBtnXP = "//*[contains(text(), 'Create New Quiz')]";
    public static String quizTitleXP = "//input[@formcontrolname='name']";
    public static String addQuestionBtnXP = "//span[contains(string(), 'Add Question')]";
    public static String textualQuestXP = "//mat-panel-title[contains(text(), 'Q1')]/../../..//*[contains(text(), 'Textual')]";
    public static String questionSliderXP = "//mat-panel-title[contains(text(), 'Q1')]/../../..//mat-slider";
    public static String studentXP= "//div[@class='mat-list-text' and contains (string(),'Anna Manukyan')]";
    public static String quizDropDownAssignmentXP = "//span[contains(text(), 'Select Quiz To Assign')]";
    public static String uniqueQuizAssignmentXP = "//span[contains(text(),'Unique Quiz')]";
    public static String giveAssignmentXP = "//span[contains (text(), 'Give Assignment')]";
    public static String logOutButtonSideNavXP = "//h5[contains(text(), 'Log Out')]";
    public static String logOutconfirmationXP = "//span[contains(text(),'Log Out')]";
    public static String studentEmail = "extreme66@cbarata.pro";
    public static String studentPassword = "12345";
    public static String lastAssignmentXP = "//tr[@class='ng-star-inserted'][9]//button";
    public static String textualAnswerXP = "//textarea[@placeholder='Enter your answer']";
    public static String singleChAnswerXP = "//label[@for='mat-radio-2-input']";
    public static String multiplyCh1XP = "//label[@for='mat-checkbox-1-input']";
    public static String multiplyCh2XP = "//label[@for='mat-checkbox-2-input']";
    public static String submitMyAnswersXP = "//span[contains (text(),'Submit My Answers')]";
    public static String myGradesStatusXP = "//tr[@class='ng-star-inserted'][last()]//span";
    public static String visibleElementXP = "//h5[contains(text(),'Assignments')]";
    public static String myGradesPageXP = "//ac-student-grades-page";
    public static String gradedAssignmentsHPXP = "//p[contains (.,'graded')]/span[@class='bold'][1]";
    public static String submittedAtMyGradesXP = "//th[contains(text(),'Submitted At')]";
    public static String gradedAtMyGradesXP = "//th[contains(text(),'Graded At')]";
    public static String quizMygradesXP = "//th[contains(text(),'Quiz')]";
    public static String statusMygradesXP = "//th[contains(text(),'Status')]";
    public static String dateTimeSubmittedMyGradesXP = "//tr[@class='ng-star-inserted'][1]/td[1]";


}
