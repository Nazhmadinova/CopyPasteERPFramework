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
    public WebElement negativeAmountValidateWarningOkButton;
    


}
