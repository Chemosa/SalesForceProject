package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import objects.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewContactModalPage extends BasePage{

    @FindBy(xpath = "//button[text() = 'Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[text() = 'Save & New']")
    public WebElement saveAndNewButton;

    @FindBy(xpath = "//button[text() = 'Cancel']")
    public WebElement cancelButton;

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    public NewContactModalPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public void createNewContact(Contact contact) {
        new Dropdown(driver, "Salutation").selectOption(contact.getSalutation());
        new Input(driver, "Last Name").writeTextToInput(contact.getContactLastName());
        new Input(driver, "Account Name").writeTextToComboBox(contact.getAccountName());
        new Input(driver, "Email").writeTextToInput(contact.getContactEmail());
        new Input(driver, "Mailing Street").writeTextToTextArea(contact.getMailingStreet());
        new Input(driver, "Phone").writeTextToInput(contact.getContactPhone());
        new Button(driver).clickButton(saveButton);
    }
}
