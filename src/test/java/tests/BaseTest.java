package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest implements ITestConstants, IConstants {
    WebDriver driver;
    AccountPage accountPage;
    AccountListPage accountListPage;
    HomePage homePage;
    LoginPage loginPage;
    ContactPage contactPage;
    ContactListPage contactListPage;
    NewAccountModalPage newAccountModalPage;
    NewContactModalPage newContactModalPage;
    SoftAssert softAssert;

    public void initPages(){
        accountPage = new AccountPage(driver);
        accountListPage = new AccountListPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        contactPage = new ContactPage(driver);
        contactListPage = new ContactListPage(driver);
        newAccountModalPage = new NewAccountModalPage(driver);
        newContactModalPage = new NewContactModalPage(driver);
    }

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        initPages();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void quitTest() {
        driver.quit();
    }
}
