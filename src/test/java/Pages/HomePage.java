package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "overview-section")
    WebElement homePageTitle_id;

    @FindBy(id = "nav-btn-practice")
    WebElement learningMaterialButton_id;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyHomePageIsDisplayed() {
        wait.until(visibilityOf(homePageTitle_id));
        homePageTitle_id.isDisplayed();
    }

    public void clickLearningMaterial() {
        wait.until(visibilityOf(learningMaterialButton_id));
        learningMaterialButton_id.click();
    }


}
