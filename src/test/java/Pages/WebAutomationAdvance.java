package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class   WebAutomationAdvance {

    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "tab-btn-web")
    WebElement webAutomationAdvanceButton_id;
    @FindBy (id = "deviceType")
    WebElement deviceType_id;




    public WebAutomationAdvance(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void clickWebAutomationAdvance() {
        webAutomationAdvanceButton_id.click();
    }

    public void selectDeviceType(String deviceType) {
        deviceType_id.sendKeys(deviceType);
    }


}
