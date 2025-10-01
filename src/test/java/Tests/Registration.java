package Tests;

import org.testng.annotations.Test;

public class Registration extends Base{

    @Test
    public void verifyHomePageIsDisplayedTests(){
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTests")
    public void clickLearningMaterialTests(){
        homePage.clickLearningMaterial();
    }

    @Test (dependsOnMethods = "clickLearningMaterialTests")
    public void clickRegisterTests(){
        registrationPage.clickSignUpButton();
    }

    @Test (dependsOnMethods = "clickRegisterTests")
    public void verifyRegistrationPageIsDisplayedTests() {
        registrationPage.verifyRegistrationPageIsDisplayed();
    }

    @Test (dependsOnMethods = "verifyRegistrationPageIsDisplayedTests")
    public void enterFirstnameTests() {
        registrationPage.enterFirstName("Linda");
    }

    @Test (dependsOnMethods = "enterFirstnameTests")
    public void enterLastnameTests() {
        registrationPage.enterLastName("Mashego");
    }


    @Test(dependsOnMethods = "enterLastnameTests")
    public void verifySuccessfulRegistrationAlertTests() {
        registrationPage.verifySuccessfulRegistrationAlert(
            "Linda", // firstName
            "Mashego", // lastName
            "lin@gmail.com", // email (should be unique for each test run)
            "Password123!", // password
            "Password123!" // confirmPassword (match)
        );
    }



}
