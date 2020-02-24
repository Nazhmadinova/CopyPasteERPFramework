package functionalityTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InvoicingModulePage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

public class InvoicingModuleTest {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    InvoicingModulePage invoicingModulePage = new InvoicingModulePage();



    @BeforeMethod
    public void login(){
        Driver.getDriver().get(Config.getProperties("url2"));
        loginPage.usernameInput.sendKeys(Config.getProperties("Username4"));
        loginPage.passwordInput.sendKeys(Config.getProperties("passwordUser4"));
        loginPage.loginButton.click();
        homePage.invoicingButton.click();

    }






}
