package tests;

import objects.Account;
import objects.Contact;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactTest extends BaseTest{

    @Test
    public void createContactTest() {
        Contact contact = new Contact();
        Account account = new Account();
        Random random = new Random();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("65564646155");
        account.setDescription("description test");
        contact.setContactLastName("Smith");
        contact.setSalutation("Mr.");
        contact.setAccountName(account.getAccountName());
        contact.setContactPhone("80291258963");
        contact.setMailingStreet("prospect Rechitskiy");
        contact.setContactEmail("venerka.o@yandex.ru");
        loginPage
                .openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactModalPage
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage
                .openPage(CONTACT_LIST_URL);
        softAssert.assertEquals(contactListPage.getExistContactName(contact.getContactLastName()), contact.getContactLastName());
        softAssert.assertEquals(contactListPage.getExistAccountNameByContactName(contact.getContactLastName()), contact.getAccountName());
        softAssert.assertEquals(contactListPage.getExistPhoneNumberByContactName(contact.getContactLastName()), contact.getContactPhone());
        softAssert.assertEquals(contactListPage.getExistEmailByContactName(contact.getContactLastName()), contact.getContactEmail());
        softAssert.assertEquals(contactListPage.getExistAccountOwnerByContactName(contact.getContactLastName()), "LVer");
        accountListPage
                .deleteAccount(account.getAccountName());
    }

    @Test
    public void profileContactTest() {
        Contact contact = new Contact();
        Account account = new Account();
        Random random = new Random();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("65564646155");
        account.setDescription("description test");
        contact.setContactLastName("Smith");
        contact.setSalutation("Mr.");
        contact.setAccountName(account.getAccountName());
        contact.setContactPhone("80291258963");
        contact.setMailingStreet("prospect Rechitskiy");
        contact.setContactEmail("venerka.o@yandex.ru");
        loginPage
                .openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactModalPage
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        softAssert.assertEquals(contactPage.getFieldValueByName("Name"), contact.getSalutation() + " " + contact.getContactLastName());
        softAssert.assertEquals(contactPage.getAccountNameValueByName("Account Name", account.getAccountName()), account.getAccountName());
        softAssert.assertEquals(contactPage.getFieldValueByName("Phone"), contact.getContactPhone());
        softAssert.assertEquals(contactPage.getFieldValueByName("Email"), contact.getContactEmail());
        softAssert.assertEquals(contactPage.getFieldValueByName("Mailing Address"), contact.getMailingStreet());
        softAssert.assertAll();
        accountListPage
                .deleteAccount(account.getAccountName());
    }
}
