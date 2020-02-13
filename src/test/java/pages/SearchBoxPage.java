package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchBoxPage {
public SearchBoxPage(){
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
    @FindBy(xpath = "//span[@class='fa fa-filter']")
    public WebElement FiltersModule;
    @FindBy(xpath = "//a[.='Paid']")
    public WebElement FiltersOptionPaid;
    @FindBy(xpath = "//span[@class='fa fa-bars']")
    public WebElement GroupByModule;
    @FindBy(xpath = "//span[@class='fa fa-star']")
    public WebElement FavoritesModule;













}
