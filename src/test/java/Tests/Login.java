package Tests;

import org.testng.annotations.Test;

public class Login extends Base{
    @Test
    public void verifyHomePageIsDisplayedTests(){
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTests")
    public void clickLearningMaterialTests(){
        homePage.clickLearningMaterial();
    }

    @Test (dependsOnMethods = "clickLearningMaterialTests")
    public void verifyLoginPageIsDisplayedTests() {
        loginPage.verifyLoginPageIsDisplayed();
    }

    @Test (dependsOnMethods = "verifyLoginPageIsDisplayedTests")
    public void enterEmailAddressTests() {
        loginPage.enterEmailAddress("linda@gmail.com");
    }

    @Test (dependsOnMethods = "enterEmailAddressTests")
    public void enterPasswordTests() {
        loginPage.enterPassword("Linda@193");
    }

    @Test (dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        loginPage.clickLoginButton();
    }

    @Test (dependsOnMethods = "clickLoginButtonTests")
    public void verifyPracticePageIsDisplayedTests() {
        loginPage.verifyWelcomeAlert();





        }

}
