package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;

    private static final String INPUT_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@part, 'input-text')]//input";
    private static final String TEXT_AREA_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//textarea";
    private static final String COMBOBOX_FIELD_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//lightning-base-combobox";
    private static final String COMBOBOX_OPTION_XPATH = "//label[contains(text(),'%s')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//*[@title='%s']";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeTextToInput(String text) {
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }

    public void writeTextToTextArea(String text) {
        driver.findElement(By.xpath(String.format(TEXT_AREA_XPATH, label))).sendKeys(text);
    }

    public void writeTextToComboBox(String accountName) {
        driver.findElement(By.xpath(String.format(COMBOBOX_FIELD_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(COMBOBOX_OPTION_XPATH, label, accountName))).click();
    }
}
