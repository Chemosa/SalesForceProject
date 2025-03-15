package tests;

import objects.Account;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest{

    @Test
    public void createAccountTest(){
        Account account = new Account();
        Random random = new Random();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("65564646155");
        account.setDescription("description test");
        loginPage
                .openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        softAssert.assertEquals(accountListPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        softAssert.assertEquals(accountListPage.getExistPhoneNumberByAccountName(account.getAccountName()), account.getPhone());
        softAssert.assertEquals(accountListPage.getExistAccountOwnerByAccountName(account.getAccountName()), "LVer");
        accountListPage
                .deleteAccount(account.getAccountName());
    }

    @Test
    public void profileAccountTest(){
        Account account = new Account();
        Random random = new Random();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("65564646155");
        account.setDescription("description test");
        loginPage
                .openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        softAssert.assertEquals(accountPage.getFieldValueByName("Account Name"), account.getAccountName());
        softAssert.assertEquals(accountPage.getFieldValueByName("Website"), account.getWebSite());
        softAssert.assertEquals(accountPage.getFieldValueByName("Type"), account.getType());
        softAssert.assertEquals(accountPage.getFieldValueByName("Description"), account.getDescription());
        softAssert.assertEquals(accountPage.getFieldValueByName("Phone"), account.getPhone());
        softAssert.assertAll();
        accountListPage
                .deleteAccount(account.getAccountName());
    }
}
