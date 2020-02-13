package functionalityTesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchBoxPage;
import utilities.Config;
import utilities.Driver;

public class SearchBoxTest {

    SearchBoxPage searchBoxPage = new SearchBoxPage();


    @BeforeClass
    public void setUp() {
        Driver.getDriver().get("http://app.briteerp.com/web/login");
    }

    @Test
    public void LoginPage() {
        searchBoxPage.usernameInput.sendKeys(Config.getProperties("UsernameManager3"));
        searchBoxPage.passwordInput.sendKeys(Config.getProperties("passwordManager3"));
        searchBoxPage.loginButton.click();
    }

    @Test
    public void selectInvoiceModule() {
        searchBoxPage.InvoicingModule.click();
        Assert.assertEquals(searchBoxPage.HeaderTextCustomerInvoices.getText(), "Customer Invoices");
    }

    @Test
    public void searchBoxLocation() {
        Assert.assertTrue(searchBoxPage.searchBox.isDisplayed());
    }

    @Test
    public void searchSignBox() {
        searchBoxPage.searchSignBox.click();
    }

    @Test
    public void verifiyngFiltersDisplayed() {
        Assert.assertTrue(searchBoxPage.FiltersModule.isDisplayed());
    }

    @Test
    public void verifiyngGroupByDisplayed() {
        Assert.assertTrue(searchBoxPage.GroupByModule.isDisplayed());
    }

    @Test
    public void verifiyngFavoritesDisplayed() {
        Assert.assertTrue(searchBoxPage.FavoritesModule.isDisplayed());
    }


    @AfterClass
    public void closeUp(){
        Driver.quitDriver();
}

















}