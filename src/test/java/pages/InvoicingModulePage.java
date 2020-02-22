package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class InvoicingModulePage {

    public InvoicingModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td[8]")
    public List<WebElement> tableTotal;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td[10]")
    public List<WebElement> tableStatus;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement CreateInvoicesTabButton;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public WebElement CreateInvoicesImportButton;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement CreateInvoicesSearchButton;

    @FindBy(xpath = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list active']")
    public WebElement CreateInvoicesListButton;

    @FindBy(xpath = "//button[@aria-label='kanban']")
    public WebElement CreateInvoicesKanbanButton;

    @FindBy(xpath = "//button[@class='btn btn-icon fa fa-lg fa-calendar o_cp_switch_calendar']")
    public WebElement CreateInvoicesCalendarButton;

    @FindBy(xpath = "//button[@class='btn btn-icon fa fa-lg fa-bar-chart o_cp_switch_graph']")
    public WebElement CreateInvoicesGraphButton;

    @FindBy(xpath = "//button[@aria-label='pivot']")
    public WebElement CreateInvoicesPivotButton;


    @FindBy(xpath = "//button[@aria-label='Previous']")
    public WebElement CreateInvoicesPreviousArrow;

    @FindBy(xpath = "//button[@aria-label='Next']")
    public WebElement CreateInvoicesNextArrow;

    @FindBy(xpath = "//span[contains(text(),'Customer Invoices')]")
    public WebElement CreateInvoicesTab;

    @FindBy(xpath = "//span[contains( text(),'Customer Credit Notes')]")
    public WebElement CustomerCreditNotes;

    @FindBy(xpath = "//a[@data-action-id='246']")
    public WebElement FirstPayments;

    @FindBy(xpath = "//img[@class='img-circle oe_topbar_avatar']")
    public WebElement LoginAvatarImage;


}
