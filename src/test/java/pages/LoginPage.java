package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "")
    public WebElement usernameInput;

    @FindBy(id = "")
    public WebElement passwordInput;

    @FindBy(id = "")
    public WebElement loginButton;
}
