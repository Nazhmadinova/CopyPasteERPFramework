package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExistingCustomerInvoicePage {

    public ExistingCustomerInvoicePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Validate']")
    public WebElement validateButton;

    @FindBy(xpath = "//div[@class='o_dialog_warning modal-body']")
    public WebElement negativeAmountValidateWarning;

    @FindBy(xpath = "//span[.='Ok']")
    public WebElement wrongValidateWarningOkButton;

    @FindBy(xpath = "//button[.='Register Payment']")
    public WebElement registerPaymentButton;

    @FindBy(xpath = "//button[.='Print Invoice']")
    public WebElement printInvoiceButton;

    @FindBy(xpath = "//button[.='Send by Email'][1]")
    public WebElement sendByEmailButton;

    @FindBy(xpath = "//button[.='Send by Email'][2]")
    public WebElement sendByEmailButtonAfterClicking;

    @FindBy(xpath = "//button[@data-value='paid']")
    public WebElement invoiceStatus;
    
    @FindBy(xpath = "(//td[@class='o_data_cell'])[1]")
    public WebElement productFieldFirst;

    @FindBy(xpath = "//div[@class='o_dialog_warning modal-body']")
    public WebElement emptyProductFieldValidateWarning;

    @FindBy(xpath = "//td[@class='o_data_cell o_readonly_modifier o_required_modifier'][1]")   //tr[@class='o_data_row text-info']/td[2])[1]
    public WebElement existingCustomer;

    @FindBy(xpath = "//td[@class='o_data_cell o_readonly_modifier o_required_modifier']")
    public WebElement existingCustomerPaid;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement editButton;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm o_form_button_cancel']")
    public WebElement discardButton;

    @FindBy(xpath = "//input[@class='o_input ui-autocomplete-input']")
    public WebElement salesChannelDropdown;

    @FindBy(xpath = "//button[@data-value='open']")
    public WebElement invoiceStatusOpen;

    @FindBy(xpath = "(//label[@class='o_form_label o_readonly_modifier o_required_modifier'])")
    public WebElement verifyNavigationCustomerInvoice;

}
