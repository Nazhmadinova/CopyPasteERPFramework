
package functionalityTesting;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class ValidateInvoiceTest {


    InvoicingModulePage invoicingModulePage = new InvoicingModulePage();
    ExistingCustomerInvoicePage existingCustomerInvoicePage = new ExistingCustomerInvoicePage();
    RegisterPaymentPage registerPaymentPage = new RegisterPaymentPage();
    SendByEmailPage sendByEmailPage = new SendByEmailPage();
    HomePage homePage = new HomePage();


    @BeforeSuite(alwaysRun = true)
    public void login(){

        SeleniumUtils.login(Config.getProperties("url2"),
                Config.getProperties("UsernameManager3"),
                Config.getProperties("passwordManager3"));

        SeleniumUtils.goToInvoicingModule();

    }

    @AfterMethod(alwaysRun = true)
    public void goToInvoicing(){
        SeleniumUtils.goToInvoicingModule();
    }

    @Test(groups = {"Smoke"}, priority = 5)
    public void validateButtonIsDisplayed(){

        List<WebElement> statuses = invoicingModulePage.tableStatus;

        for(WebElement status: statuses){
            if(status.getText().equals(Config.getProperties("invoiceStatusDraft"))){
                status.click();
                break;
            }
        }

        Assert.assertTrue(existingCustomerInvoicePage.validateButton.isDisplayed(),"Validate button is not displayed, test FAILED");
    }

    @Test(groups = {"Smoke"},priority = 6)
    public void validateButtonShouldNotDisplayed1(){

        List<WebElement> statuses = invoicingModulePage.tableStatus;

        for(WebElement status: statuses){
            if(status.getText().equals(Config.getProperties("invoiceStatusOpen"))){
                status.click();
                break;
            }
        }

        Assert.assertFalse(existingCustomerInvoicePage.validateButton.isDisplayed(),"Validate button is displayed, test FAILED");

    }

    @Test(groups = {"Smoke"},priority = 7)
    public void validateButtonShouldNotDisplayed2(){
        List<WebElement> statuses = invoicingModulePage.tableStatus;

        for(WebElement status: statuses){
            if(status.getText().equals(Config.getProperties("invoiceStatusPaid"))){
                status.click();
                break;
            }
        }

        Assert.assertFalse(existingCustomerInvoicePage.validateButton.isDisplayed(),"Validate button is displayed, test FAILED");

    }


    @Test(groups = {"Smoke"},priority = 8)
    public void validateWithPositiveAmountOfTotalAndRegisterPayment(){

        List<WebElement> totalAmount = invoicingModulePage.tableTotal;
        List<WebElement> statuses = invoicingModulePage.tableStatus;

        SeleniumUtils.pauseWithTreadSleep(2);
        for(int i = 0; i < totalAmount.size(); i++){
            String str = totalAmount.get(i).getText();
            String newStr = "";
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '-' || Character.isDigit(str.charAt(j)) || str.charAt(j) == '.'){
                    newStr += str.charAt(j);
                }
            }
            double eachAmount = Double.parseDouble(newStr);
            if(statuses.get(i).getText().equals(Config.getProperties("invoiceStatusDraft")) && eachAmount > 0){
                totalAmount.get(i).click();
                break;
            }
        }

        SeleniumUtils.explicitWaitForVisibility(existingCustomerInvoicePage.validateButton,2);
        existingCustomerInvoicePage.validateButton.click();
        SeleniumUtils.pauseWithTreadSleep(2);
        existingCustomerInvoicePage.registerPaymentButton.click();

        SeleniumUtils.pauseWithTreadSleep(2);
        registerPaymentPage.validateButton.click();

        SeleniumUtils.pauseWithTreadSleep(3);

        String status = existingCustomerInvoicePage.invoiceStatus.getAttribute("class");

        Assert.assertTrue(status.contains(Config.getProperties("invoiceStatusAttribute")));
    }

    @Test(groups = {"Smoke"},priority = 9)
    public void validateInvoiceWithNegativeAmountOfTotal(){

        List<WebElement> totalAmount = invoicingModulePage.tableTotal;
        SeleniumUtils.pauseWithTreadSleep(2);

        for(WebElement amount: totalAmount){
            String str = amount.getText();
            String newStr = "";
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '-' || Character.isDigit(str.charAt(i)) || str.charAt(i) == '.'){
                    newStr += str.charAt(i);
                }
            }
            double eachAmount = Double.parseDouble(newStr);
            if(eachAmount < 0){
                amount.click();
                break;
            }
        }

        SeleniumUtils.pauseWithTreadSleep(2);

        existingCustomerInvoicePage.validateButton.click();

        String warning = existingCustomerInvoicePage.negativeAmountValidateWarning.getText();

        Assert.assertTrue(warning.contains(Config.getProperties("negativeAmountValidateWarningMsg")));

        existingCustomerInvoicePage.wrongValidateWarningOkButton.click();

    }

    @Test(groups = {"Smoke"},priority = 10)
    public void validateInvoiceWithEmptyProductField(){

        List<WebElement> totalAmount = invoicingModulePage.tableTotal;
        List<WebElement> statuses = invoicingModulePage.tableStatus;
       // SeleniumUtils.pauseWithTreadSleep(2);
        boolean check = true;

        int a = 0;
        while (check){
            for(int i = a; i < totalAmount.size()-1; i++){
                String str = totalAmount.get(i).getText();
                String newStr = "";
                for(int j = 0; j < str.length(); j++){
                    if(str.charAt(j) == '-' || Character.isDigit(str.charAt(j)) || str.charAt(j) == '.'){
                        newStr += str.charAt(j);
                    }
                }
                double eachAmount = Double.parseDouble(newStr);
                if(statuses.get(i).getText().equals(Config.getProperties("invoiceStatusDraft")) && eachAmount == 0){
                    totalAmount.get(i).click();
                    a = i+1;
                    break;
                }
            }
            SeleniumUtils.pauseWithTreadSleep(2);

            try {
                existingCustomerInvoicePage.productFieldFirst.getText();
                homePage.invoicingButton.click();
            }catch (NoSuchElementException e){
                existingCustomerInvoicePage.validateButton.click();
                //SeleniumUtils.pauseWithTreadSleep(3);
                String warningMsg = existingCustomerInvoicePage.emptyProductFieldValidateWarning.getText();
                Assert.assertEquals(warningMsg,Config.getProperties("emptyProductFieldValidateWarningMsg"));
                SeleniumUtils.pauseWithTreadSleep(2);
                existingCustomerInvoicePage.wrongValidateWarningOkButton.click();
                break;
            }
        }

    }

    @Test(groups = {"Smoke"},priority = 11)
    public void sendByEmailInvoice(){

        List<WebElement> totalAmount = invoicingModulePage.tableTotal;
        List<WebElement> statuses = invoicingModulePage.tableStatus;
        //SeleniumUtils.pauseWithTreadSleep(4);
        for(int i = 0; i < totalAmount.size(); i++){
            String str = totalAmount.get(i).getText();
            String newStr = "";
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '-' || Character.isDigit(str.charAt(j)) || str.charAt(j) == '.'){
                    newStr += str.charAt(j);
                }
            }
            double eachAmount = Double.parseDouble(newStr);
            if(statuses.get(i).getText().equals(Config.getProperties("invoiceStatusDraft")) && eachAmount > 0){
                totalAmount.get(i).click();
                break;
            }
        }

        existingCustomerInvoicePage.validateButton.click();
        SeleniumUtils.explicitWaitForVisibility(existingCustomerInvoicePage.sendByEmailButton,5);
        existingCustomerInvoicePage.sendByEmailButton.click();

        if(sendByEmailPage.closeButton.isDisplayed()){
            sendByEmailPage.closeButton.click();
        }

        SeleniumUtils.explicitWaitForVisibility(sendByEmailPage.sendButton,5);
        sendByEmailPage.sendButton.click();

        String sendByEmailAttribute = existingCustomerInvoicePage.sendByEmailButtonAfterClicking.getAttribute("class");
        Assert.assertFalse(sendByEmailAttribute.contains(Config.getProperties("sendByEmailAttributeAfterClicking")));

    }

    @Test(groups = {"Smoke"},priority = 12)
    public void editButtonIsDisplayed(){
        List<WebElement> statuses = invoicingModulePage.tableStatus;

        for(WebElement status: statuses){
            if(status.getText().equals(Config.getProperties("invoiceStatusDraft"))){
                status.click();
                break;
            }
        }
        SeleniumUtils.pauseWithTreadSleep(2);
        Assert.assertTrue(existingCustomerInvoicePage.editButton.isDisplayed());
    }

    @AfterSuite(alwaysRun = true)
    public void quitBrowser(){
       Driver.quitDriver();
    }

}

