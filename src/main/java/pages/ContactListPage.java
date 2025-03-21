package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage{

    public static final String TABLE_XPATH = "//table";
    public static final String CONTACT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    public static final String CONTACT_PHONE_FIELD_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'forceOutputPhone')]";
    public static final String CONTACT_OWNER_BY_ACCOUNT_NAME_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'uiOutputText')]";
    public static final String CONTACT_EMAIL_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//a[contains(@class, 'emailuiFormattedEmail')]";
    public static final String ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'uiOutputText')]";

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public String getExistContactName(String contactName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactName))).getText();
    }

    public String getExistAccountNameByContactName(String accountName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public String getExistPhoneNumberByContactName(String contactName) {
        return driver.findElement(By.xpath(String.format(CONTACT_PHONE_FIELD_XPATH, contactName))).getText();
    }

    public String getExistEmailByContactName(String contactName) {
        return driver.findElement(By.xpath(String.format(CONTACT_EMAIL_XPATH, contactName))).getText();
    }

    public String getExistAccountOwnerByAccountName(String contactName) {
        return driver.findElement(By.xpath(String.format(CONTACT_OWNER_BY_ACCOUNT_NAME_XPATH, contactName))).getText();
    }

    public String getExistAccountOwnerByContactName(String contactName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH, contactName))).getText();
    }

    public ContactPage clickOnContactName(String contactName) {
        driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactName))).click();
        return new ContactPage(driver);
    }
}
