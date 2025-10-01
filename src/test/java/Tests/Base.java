package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Pages.WebAutomationAdvance;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    HomePage homePage= PageFactory.initElements(driver,HomePage.class);
    RegistrationPage registrationPage= PageFactory.initElements(driver, RegistrationPage.class);
    LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
    WebAutomationAdvance webAutomationAdvance= PageFactory.initElements(driver, WebAutomationAdvance.class);


}