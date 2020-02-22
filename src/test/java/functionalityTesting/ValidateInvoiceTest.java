//package functionalityTesting;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.ExistingCustomerInvoicePage;
//import pages.HomePage;
//import pages.InvoicingModulePage;
//import pages.LoginPage;
//import utilities.Config;
//import utilities.Driver;
//
//import java.util.List;
//
//public class ValidateInvoiceTest {

//    LoginPage loginPage = new LoginPage();
//    HomePage homePage = new HomePage();
//    InvoicingModulePage invoicingModulePage = new InvoicingModulePage();
//    ExistingCustomerInvoicePage existingCustomerInvoicePage = new ExistingCustomerInvoicePage();
//
//
//    @BeforeMethod
//    public void login(){
//        Driver.getDriver().get(Config.getProperties("url2"));
//        loginPage.usernameInput.sendKeys(Config.getProperties("UsernameManager3"));
//        loginPage.passwordInput.sendKeys(Config.getProperties("passwordManager3"));
//        loginPage.loginButton.click();
//        homePage.invoicingButton.click();
//    }
//
//    @Test(priority = 1)
//    public void validateButtonIsDisplayed(){
//
//        List<WebElement> statuses = invoicingModulePage.tableStatus;
//
//        for(WebElement status: statuses){
//            if(status.getText().equals(Config.getProperties("invoiceStatusDraft"))){
//                status.click();
//                break;
//            }
//        }
//
//        Assert.assertTrue(existingCustomerInvoicePage.validateButton.isDisplayed(),"Validate button is not displayed, test FAILED");
//    }
//
//    @Test(priority = 2)
//    public void validateButtonShouldNotDisplayed1(){
//
//        List<WebElement> statuses = invoicingModulePage.tableStatus;
//
//        for(WebElement status: statuses){
//            if(status.getText().equals(Config.getProperties("invoiceStatusOpen"))){
//                status.click();
//                break;
//            }
//        }
//
//        Assert.assertFalse(existingCustomerInvoicePage.validateButton.isDisplayed(),"Validate button is displayed, test FAILED");
//
//    }
//
//    @Test(priority = 3)
//    public void validateButtonShouldNotDisplayed2(){
//        List<WebElement> statuses = invoicingModulePage.tableStatus;
//
//        for(WebElement status: statuses){
//            if(status.getText().equals(Config.getProperties("invoiceStatusPaid"))){
//                status.click();
//                break;
//            }
//        }
//
//        Assert.assertFalse(existingCustomerInvoicePage.validateButton.isDisplayed(),"Validate button is displayed, test FAILED");
//
//    }
//
//
//    @Test(priority = 4,  dependsOnMethods = "")
//    public void validateWithPositiveAmountOfTotalAndRegisterPayment(){
//
//    }
//
//    @Test(priority = 5)
//    public void validateInvoiceWithNegativeAmountOfTotal() throws InterruptedException{
//        Thread.sleep(5000);
//        List<WebElement> totalAmount = invoicingModulePage.tableTotal;
//
//
//        for(WebElement amount: totalAmount){
//            String str = amount.getText();
//            String newStr = "";
//            for(int i = 0; i < str.length(); i++){
//                if(str.charAt(i) == '-' || Character.isDigit(str.charAt(i)) || str.charAt(i) == '.'){
//                    newStr += str.charAt(i);
//                }
//            }
//            double eachAmount = Double.parseDouble(newStr);
//            if(eachAmount < 0){
//                amount.click();
//                break;
//            }
//        }
//        Thread.sleep(5000);
//
//        existingCustomerInvoicePage.validateButton.click();
//
//        String warning = existingCustomerInvoicePage.negativeAmountValidateWarning.getText();
//
//        Assert.assertTrue(warning.contains(Config.getProperties("negativeAmountValidateWarningMsg")));
//        Thread.sleep(5000);
//       existingCustomerInvoicePage.negativeAmountValidateWarningOkButton.click();
//
//    }
//
//    @Test(priority = 6)
//    public void sendByEmailInvoice(){
//
//    }
//
//
//
//}
