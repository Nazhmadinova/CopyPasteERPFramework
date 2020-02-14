package functionalityTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SearchBoxPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class SearchBoxTest {
    SearchBoxPage searchBoxPage = new SearchBoxPage();

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(Config.getProperties("url2"));
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
        Assert.assertTrue(searchBoxPage.searchSignBox.isDisplayed());
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


    @Test(priority = 1)
    public void verifyingSearchInvoiceValidName() {
        SeleniumUtils.pauseWithTreadSleep(3);
        searchBoxPage.searchBox.sendKeys(Config.getProperties("validCustomerName")+Keys.ENTER);
        SeleniumUtils.pauseWithTreadSleep(3);
        List<WebElement> list = searchBoxPage.listNames;

        for (WebElement name : list) {
            if (name.getText().contains(Config.getProperties("validCustomerName"))) {
                Assert.assertTrue(name.isDisplayed());
                SeleniumUtils.pauseWithTreadSleep(3);
            }
        }

    }


    @Test(priority = 2)
    public void verifyPresetOptionsDisplayed() {
        searchBoxPage.FiltersModule.click();
        String str = "";
        List<WebElement> list = searchBoxPage.listPresetOptions;

        for (WebElement element : list) {
            if (element.getText().equalsIgnoreCase(Config.getProperties("presetOption7"))) {
                element.click();
                SeleniumUtils.pauseWithTreadSleep(2);
                Assert.assertTrue(element.isDisplayed());
                str = element.getText();
                break;
            }
        }

        List<WebElement> searchConfirmList = searchBoxPage.SearchBoxConfirmTag;
        Assert.assertEquals(str, Config.getProperties("presetOption7"));
        for (WebElement elemSearchBox:searchConfirmList) {

            if(elemSearchBox.getText().equals(Config.getProperties("presetOption7"))){
                Assert.assertEquals(elemSearchBox.getText(),Config.getProperties("presetOption7"),"Chosen preset option is not displayed in search box");
                break;
            }
        }

    }
    @AfterClass
    public void close(){
        Driver.quitDriver();
    }
}
