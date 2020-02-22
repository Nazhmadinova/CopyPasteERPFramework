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

}
