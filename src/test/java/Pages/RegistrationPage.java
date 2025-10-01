package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RegistrationPage {
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy (id = "signup-toggle")
    WebElement signUpButton_id;

    @FindBy(id = "registration-heading")
    WebElement registrationPageTitle_id;

    @FindBy(id = "register-firstName")
    WebElement firstNameField_id;

    @FindBy(id = "register-lastName")
    WebElement lastNameField_id;

    @FindBy(id = "register-email")
    WebElement emailField_id;

    @FindBy(id = "register-password")
    WebElement passwordField_id;

    @FindBy(id = "register-confirmPassword")
    WebElement confirmPasswordField_id;

    @FindBy(id = "register-submit")
    WebElement CreateAccountButton_id;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton_id));
        signUpButton_id.click();
    }

    public void verifyRegistrationPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(registrationPageTitle_id));
        registrationPageTitle_id.isDisplayed();
    }

    public void enterFirstName(String Linda) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField_id));
        firstNameField_id.sendKeys(Linda);
    }

    public void enterLastName(String Mashego) {
        wait.until(ExpectedConditions.visibilityOf(lastNameField_id));
        lastNameField_id.sendKeys(Mashego);
    }

    //Invalid email format verification
    public void verifyInvalidEmailAlert(String lindagmail) {
        wait.until(ExpectedConditions.visibilityOf(emailField_id));
        emailField_id.sendKeys(lindagmail);
        wait.until(ExpectedConditions.visibilityOf(passwordField_id));
        passwordField_id.sendKeys("Linda123!");
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField_id));
        confirmPasswordField_id.sendKeys("Linda123!");
        wait.until(ExpectedConditions.elementToBeClickable(CreateAccountButton_id));
        CreateAccountButton_id.click();
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            throw new AssertionError("Please enter a valid email address");
        }
    }
    //Password mismatch verification
    public void verifyPasswordMismatchAlert(String firstName, String lastName, String email, String password, String confirmPassword) {
        firstNameField_id.clear();
        firstNameField_id.sendKeys(firstName);
        lastNameField_id.clear();
        lastNameField_id.sendKeys(lastName);
        emailField_id.clear();
        emailField_id.sendKeys(email);
        passwordField_id.clear();
        passwordField_id.sendKeys(password);
        confirmPasswordField_id.clear();
        confirmPasswordField_id.sendKeys(confirmPassword);
        CreateAccountButton_id.click();
        try {
            driver.switchTo().alert();
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            throw new AssertionError("Passwords do not match!");
        }
    }
    /**
     * Verifies that a successful registration shows the correct alert message.
     */
    public void verifySuccessfulRegistrationAlert(String firstName, String lastName, String email, String password, String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField_id));
        firstNameField_id.clear();
        firstNameField_id.sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(lastNameField_id));
        lastNameField_id.clear();
        lastNameField_id.sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(emailField_id));
        emailField_id.clear();
        emailField_id.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordField_id));
        passwordField_id.clear();
        passwordField_id.sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField_id));
        confirmPasswordField_id.clear();
        confirmPasswordField_id.sendKeys(confirmPassword);
        wait.until(ExpectedConditions.elementToBeClickable(CreateAccountButton_id));
        CreateAccountButton_id.click();
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            if (!"Registration successful! Please login with your credentials.".equals(alertText)) {
                throw new AssertionError("Unexpected alert text: " + alertText);
            }
            driver.switchTo().alert().accept(); // Optionally close the alert
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            throw new AssertionError("Success alert not displayed");
        }
    }
    /**
     * Verifies that an alert is displayed when the password is less than 8 characters.
     */
    public void verifyShortPasswordAlert(String firstName, String lastName, String email, String shortPassword, String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField_id));
        firstNameField_id.clear();
        firstNameField_id.sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(lastNameField_id));
        lastNameField_id.clear();
        lastNameField_id.sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(emailField_id));
        emailField_id.clear();
        emailField_id.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordField_id));
        passwordField_id.clear();
        passwordField_id.sendKeys(shortPassword);
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField_id));
        confirmPasswordField_id.clear();
        confirmPasswordField_id.sendKeys(confirmPassword);
        wait.until(ExpectedConditions.elementToBeClickable(CreateAccountButton_id));
        CreateAccountButton_id.click();
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            if (!"Password must be at least 8 characters".equals(alertText)) {
                throw new AssertionError("Unexpected alert text: " + alertText);
            }
            driver.switchTo().alert().accept(); // Optionally close the alert
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            throw new AssertionError("Short password alert not displayed");
        }
    }
}
