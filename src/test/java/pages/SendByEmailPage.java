package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SendByEmailPage {

    public SendByEmailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Send']")
    public WebElement sendButton;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement closeButton;
}
