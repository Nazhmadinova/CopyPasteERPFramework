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



}
