package functionalityTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InvoicingModulePage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

public class InvoicingModuleTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    InvoicingModulePage invoicingModulePage = new InvoicingModulePage();



    @BeforeMethod
    public void login(){
        Driver.getDriver().get(Config.getProperties("url2"));
        loginPage.usernameInput.sendKeys(Config.getProperties("Username4"));
        loginPage.passwordInput.sendKeys(Config.getProperties("passwordUser4"));
        loginPage.loginButton.click();
        homePage.invoicingButton.click();

    }


    @Test(groups = {"Smoke"}, priority = 1)
    public void invoiceButtonIsDisplayed(){

        Assert.assertTrue(invoicingModulePage.CreateInvoicesTabButton.isDisplayed(),"Customer Invoices Tab Button is not Displayed");

    }



    @Test
    public void customerInvoicesPages(){
        Assert.assertTrue(invoicingModulePage.CreateInvoicesListButton.isDisplayed(),"Customer Invoices List Button is not Displayed");
        Assert.assertTrue(invoicingModulePage.CreateInvoicesCalendarButton.isDisplayed(),"Customer Invoices Calendar Button is not Displayed");
        Assert.assertTrue(invoicingModulePage.CreateInvoicesGraphButton.isDisplayed(),"Customer Invoices Graph Button is not Displayed");
        Assert.assertTrue(invoicingModulePage.CreateInvoicesKanbanButton.isDisplayed(),"Customer Invoices Kanban Button is not Displayed");
        Assert.assertTrue(invoicingModulePage.CreateInvoicesPivotButton.isDisplayed(),"Customer Invoices Pivot Button is not Displayed");
        Assert.assertTrue(invoicingModulePage.CreateInvoicesSearchButton.isDisplayed(),"Customer Invoices Search Button is not Displayed");
        Assert.assertTrue(invoicingModulePage.CreateInvoicesTabButton.isDisplayed(),"Customer Invoices Tab Button is not Displayed");
        Assert.assertTrue(invoicingModulePage.CreateInvoicesPreviousArrow.isDisplayed(),"Customer Invoices Previous Arrow is not Displayed");
        Assert.assertTrue(invoicingModulePage.CreateInvoicesNextArrow.isDisplayed(),"Customer Invoices Next Arrow is not Displayed");
        Assert.assertTrue(invoicingModulePage.CreateInvoicesTab.isDisplayed(),"Customer Invoices Create Invoice is not Displayed");
        Assert.assertTrue(invoicingModulePage.CustomerCreditNotes.isDisplayed(),"Customer Credit Notes is not Displayed");
        Assert.assertTrue(invoicingModulePage.FirstPayments.isDisplayed(),"Customer First Payment Tab is not Displayed");
        Assert.assertTrue(invoicingModulePage.LoginAvatarImage.isDisplayed(),"Customer Login Avatar Image is not Displayed");
    }
}
