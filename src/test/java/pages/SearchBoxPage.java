package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SearchBoxPage {
    public SearchBoxPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "login")
    public WebElement usernameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//span[@class='oe_menu_text'][contains(text(),'Invoicing')]")
    public WebElement InvoicingModule;
    @FindBy(xpath = "//li[contains(text(),'Customer Invoices')]")
    public WebElement HeaderTextCustomerInvoices;
    @FindBy(xpath = "//input[@type='text' and @class='o_searchview_input']")
    public WebElement searchBox;
    @FindBy(xpath = "//span[@title='Advanced Search...']")
    public WebElement searchSignBox;
    @FindBy(xpath = "(//div[@class='o_cp_right']//div/button)[1]")
    public WebElement FiltersModule;
    @FindBy(xpath = "//a[contains(text(),'Paid')]")
    public WebElement FiltersOptionPaid;
    @FindBy(xpath = "//span[@class='fa fa-bars']")
    public WebElement GroupByModule;
    @FindBy(xpath = "//span[@class='fa fa-star']")
    public WebElement FavoritesModule;
    @FindBy(xpath = "//div[@class='o_facet_values']")
    public WebElement SearchBoxPresetOption;
    @FindBy(xpath = "//ul[@class='dropdown-menu o_filters_menu']/li")
    public List<WebElement> listPresetOptions ;
    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td[2]")
    public List<WebElement> listNames;
    @FindBy(xpath = "//div[@class='o_cp_searchview']//div[@class= 'o_searchview_facet']")
    public List<WebElement> SearchBoxConfirmTag;
}
