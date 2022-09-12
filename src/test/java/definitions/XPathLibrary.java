package definitions;/*
 * Created by Artem Oganesyan on 12.09.2022
 */

public class XPathLibrary {
    public static String emailXpath = "//input[@formcontrolname='email']";
    public static String passXpath = "//input[@formcontrolname='password']";
    public static String signInBtnXpath = "//span[contains(text(),'Sign In')]";
    public static String myAssignmentsMenuXpath = "//h5[contains(text(),'My Assignments')]";
    public static String myGradesMenuXpath = "//h5[contains(text(),'My Grades')]";
    public static String myAssignmentsTitleXpath = "//h4[contains(text(),'My Assignments')]";
    public static String myGradesTitleXpath = "//h4[contains(text(),'My Grades')]";
    public static String quizzesXpath = "//h5[contains(text(),'Quizzes')]";
    public static String createQuizBtnXpath = "//*[contains(text(), 'Create New Quiz')]";
    public static String quizTitleXpath = "//input[@formcontrolname='name']";
    public static String addQuestionBtnXpath = "//div/button/span/mat-icon";
    public static String textualQselXpath = "//mat-panel-title[contains(text(), 'Q1')]/../../..//*[contains(text(), 'Textual')]";
    public static String questionSliderXpath = "//mat-panel-title[contains(text(), 'Q1')]/../../..//mat-slider";
    //This string is added by Artem
}
