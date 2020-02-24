package functionalityTesting;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ExistingCustomerInvoicePage;
import pages.HomePage;
import pages.InvoicingModulePage;
import pages.SearchBoxPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class EditInvoiceTest {

    InvoicingModulePage invoicingModulePage = new InvoicingModulePage();
    ExistingCustomerInvoicePage existingCustomerInvoicePage = new ExistingCustomerInvoicePage();
    SearchBoxPage searchBoxPage = new SearchBoxPage();
    HomePage homePage = new HomePage();
    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("http://app.briteerp.com/web/login");
        searchBoxPage.usernameInput.sendKeys(Config.getProperties("UsernameManager4"));
        searchBoxPage.passwordInput.sendKeys(Config.getProperties("passwordManager4"));
        searchBoxPage.loginButton.click();
        homePage.invoicingButton.click();
        // existingCustomerInvoicePage.existingCustomer.click();
    }


    @Test
    public void clickOnExistingCus(){
        existingCustomerInvoicePage.existingCustomer.click();
    }

    @Test
    public void clickOnEditButton(){
        SeleniumUtils.pauseWithTreadSleep(5);
        // homePage.invoicingButton.click();
        existingCustomerInvoicePage.existingCustomer.click();
        existingCustomerInvoicePage.editButton.click();
    }

    @Test
    public void verifyNavigatingToCustomersInvoice() {
        Assert.assertTrue(existingCustomerInvoicePage.verifyNavigationCustomerInvoice.isDisplayed());
    }
    @Test
    public void verifyEditButtonClickable(){
        existingCustomerInvoicePage.existingCustomer.click();
        Assert.assertTrue(existingCustomerInvoicePage.editButton.isEnabled());
    }

    //open invoice
    @Test
    public void verifyOpenStatusDisplayed() {
        Assert.assertTrue(existingCustomerInvoicePage.invoiceStatusOpen.isDisplayed());
    }
    @Test
    public void verifyPaidStatusDisplayed(){
        Assert.assertTrue(existingCustomerInvoicePage.invoiceStatus.isDisplayed());
    }
    @Test
    public void verifyEditingSalesChannel(){
        Assert.assertTrue(existingCustomerInvoicePage.invoiceStatusOpen.isDisplayed());
        //existingCustomerInvoicePage.existingCustomer
        existingCustomerInvoicePage.editButton.click();
        Assert.assertTrue(existingCustomerInvoicePage.salesChannelDropdown.isEnabled());
    }
    //    @Test
//        public void verifyEditingSalesChannelPaid() {
//        SeleniumUtils.pauseWithTreadSleep(5);
//       Assert.assertTrue(existingCustomerInvoicePage.invoiceStatus.isDisplayed());
//        existingCustomerInvoicePage.existingCustomerPaid.click();
//        existingCustomerInvoicePage.editButton.click();
//        existingCustomerInvoicePage.salesChannelDropdown.isDisplayed();
//    }
//
//
//    }
//    @Test
//    public void clickOnEditButtonPaid() {
//      //  SeleniumUtils.pauseWithTreadSleep(5);
//
//        // Assert.assertTrue(existingCustomerInvoicePage.invoiceStatus.isDisplayed());
//        existingCustomerInvoicePage.existingCustomerPaid.click();
//        existingCustomerInvoicePage.editButton.click();
//       // existingCustomerInvoicePage.discardButton.click();
//
//    }
    @AfterClass
    public void closeUp(){
        Driver.quitDriver();
    }


}
