package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {
    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@field-label='%s']//*[@slot='outputField']";
    public static final String FIELD_BY_NAME_XPATH = "//*[@field-label='%s']//span[text() = '%s']";

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public String getFieldValueByName(String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
    }

    public String getAccountNameValueByName(String fieldName, String accountName) {
        return driver.findElement(By.xpath(String.format(FIELD_BY_NAME_XPATH, fieldName, accountName))).getText();
    }
}
