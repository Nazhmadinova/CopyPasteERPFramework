package functionalityTesting;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchBoxPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class SearchBoxTest {

    SearchBoxPage searchBoxPage = new SearchBoxPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(Config.getProperties("url2"));
        searchBoxPage.usernameInput.sendKeys(Config.getProperties("UsernameManager3"));
        searchBoxPage.passwordInput.sendKeys(Config.getProperties("passwordManager3"));
        searchBoxPage.loginButton.click();
        searchBoxPage.InvoicingModule.click();
    }
    @Test
    public void searchBoxLocation() {
        Assert.assertTrue(searchBoxPage.searchBox.isDisplayed());
        Assert.assertTrue(searchBoxPage.searchSignBox.isDisplayed());
        searchBoxPage.searchSignBox.click();
        Assert.assertTrue(searchBoxPage.FiltersModule.isDisplayed());
        Assert.assertTrue(searchBoxPage.GroupByModule.isDisplayed());
        Assert.assertTrue(searchBoxPage.FavoritesModule.isDisplayed());
    }
    @Test
    public void verifyingSearchInvoiceValidName() {
        searchBoxPage.searchBox.sendKeys(Config.getProperties("validCustomerName")+ Keys.ENTER);
        SeleniumUtils.pauseWithTreadSleep(3);
        List<WebElement> list = searchBoxPage.listNames;
        for (WebElement name : list) {
            if (name.getText().contains(Config.getProperties("validCustomerName"))) {
                Assert.assertTrue(name.isDisplayed());
                SeleniumUtils.pauseWithTreadSleep(3);
            }
        }
    }
    @Test
    public void verifyPresetOptionsDisplayed() {
        //  searchBoxPage.searchSignBox.click();
        SeleniumUtils.pauseWithTreadSleep(2);
        searchBoxPage.FiltersModule.click();
        List<WebElement> list = searchBoxPage.listPresetOptions;
        for (WebElement element : list) {
            if (element.getText().equalsIgnoreCase(Config.getProperties("presetOption3"))) {
                element.click();
                SeleniumUtils.pauseWithTreadSleep(2);
                Assert.assertTrue(element.isDisplayed());
                break;
            }
        }
        List<WebElement> searchConfirmList = searchBoxPage.SearchBoxConfirmTag;
        for (WebElement elemSearchBox:searchConfirmList) {
            if(elemSearchBox.getText().equals(Config.getProperties("presetOption3"))){
                Assert.assertEquals(elemSearchBox.getText(),Config.getProperties("presetOption3"),"Chosen preset option is not displayed in search box");
                break;
            }
        }
    }
    // @AfterClass
    public void close(){
        Driver.quitDriver();
    }

}