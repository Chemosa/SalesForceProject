package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountListPage extends BasePage {
    public static final String TABLE_XPATH = "//table";
    public static final String ACCOUNT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    public static final String ACCOUNT_PHONE_FIELD_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'forceOutputPhone')]";
    public static final String ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'uiOutputText')]";
    public static final String ACCOUNT_OPTIONS_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'slds-icon_container')]";

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public String getExistAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public String getExistPhoneNumberByAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_PHONE_FIELD_XPATH, accountName))).getText();
    }

    public String getExistAccountOwnerByAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH, accountName))).getText();
    }

    public AccountPage clickOnAccountName(String accountName) {
        driver.findElement(By.xpath(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName))).click();
        return new AccountPage(driver);
    }

    public AccountListPage deleteAccount(String accountName) {
        openPage(ACCOUNT_LIST_URL);
        driver.findElement(By.xpath(String.format(ACCOUNT_OPTIONS_BY_ACCOUNT_NAME_XPATH, accountName))).click();
        driver.findElement(By.xpath("//a[contains(@title, 'Delete')]")).click();
        driver.findElement(By.xpath("//button[contains(@title, 'Delete')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName)))));
        return this;
    }
}
