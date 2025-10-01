package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login-heading")
    WebElement loginPageTitle_id;
    @FindBy(id = "login-email")
    WebElement emailField_id;
    @FindBy(id = "login-password")
    WebElement passwordField_id;
    @FindBy (id = "login-submit")
    WebElement loginButton_id;
    @FindBy(id = "practice-heading")
    WebElement welcomeAlert_id;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginPageIsDisplayed() {
        loginPageTitle_id.isDisplayed();
    }

    public void enterEmailAddress(String email) {
        emailField_id.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField_id.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton_id.click();
    }

    public void verifyWelcomeAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(welcomeAlert_id));
        if (!welcomeAlert_id.isDisplayed()) {
            throw new AssertionError("Welcome alert is not displayed after login.");
        }
    }

}
