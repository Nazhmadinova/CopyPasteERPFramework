package functionalityTesting;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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


    @BeforeMethod
    public void login(){

        SeleniumUtils.login(Config.getProperties("url2"),
                Config.getProperties("UsernameManager3"),
                Config.getProperties("passwordManager3"));

        SeleniumUtils.goToInvoicingModule();

    }

    @Test(priority = 1)
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

    @Test(priority = 2)
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

    @Test(priority = 3)
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


    @Test(priority = 4)
    public void validateWithPositiveAmountOfTotalAndRegisterPayment(){

        List<WebElement> totalAmount = invoicingModulePage.tableTotal;
        List<WebElement> statuses = invoicingModulePage.tableStatus;

        SeleniumUtils.pauseWithTreadSleep(10);
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

        //SeleniumUtils.explicitWaitForVisibility(existingCustomerInvoicePage.validateButton,5);
        SeleniumUtils.pauseWithTreadSleep(5);
        existingCustomerInvoicePage.validateButton.click();
        SeleniumUtils.pauseWithTreadSleep(5);
        existingCustomerInvoicePage.registerPaymentButton.click();

        SeleniumUtils.pauseWithTreadSleep(2);
        registerPaymentPage.validateButton.click();

        SeleniumUtils.pauseWithTreadSleep(3);

        String status = existingCustomerInvoicePage.invoiceStatus.getAttribute("class");

        Assert.assertTrue(status.contains(Config.getProperties("invoiceStatusAttribute")));
    }

    @Test(priority = 5)
    public void validateInvoiceWithNegativeAmountOfTotal(){

        List<WebElement> totalAmount = invoicingModulePage.tableTotal;
        SeleniumUtils.pauseWithTreadSleep(5);

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

        SeleniumUtils.pauseWithTreadSleep(5);

        existingCustomerInvoicePage.validateButton.click();

        String warning = existingCustomerInvoicePage.negativeAmountValidateWarning.getText();

        Assert.assertTrue(warning.contains(Config.getProperties("negativeAmountValidateWarningMsg")));

        SeleniumUtils.pauseWithTreadSleep(5);

        existingCustomerInvoicePage.wrongValidateWarningOkButton.click();

    }

    @Test(priority = 6)
    public void validateInvoiceWithEmptyProductField(){

        List<WebElement> totalAmount = invoicingModulePage.tableTotal;
        List<WebElement> statuses = invoicingModulePage.tableStatus;
        SeleniumUtils.pauseWithTreadSleep(4);

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
                SeleniumUtils.pauseWithTreadSleep(3);
                String warningMsg = existingCustomerInvoicePage.emptyProductFieldValidateWarning.getText();
                Assert.assertEquals(warningMsg,Config.getProperties("emptyProductFieldValidateWarningMsg"));
                existingCustomerInvoicePage.wrongValidateWarningOkButton.click();
                break;
            }
        }

    }

    @Test(priority = 7)
    public void sendByEmailInvoice(){

        List<WebElement> totalAmount = invoicingModulePage.tableTotal;
        List<WebElement> statuses = invoicingModulePage.tableStatus;
        SeleniumUtils.pauseWithTreadSleep(4);
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
        SeleniumUtils.explicitWaitForVisibility(sendByEmailPage.sendButton,5);
        sendByEmailPage.sendButton.click();

        String sendByEmailAttribute = existingCustomerInvoicePage.sendByEmailButtonAfterClicking.getAttribute("class");
        Assert.assertFalse(sendByEmailAttribute.contains(Config.getProperties("sendByEmailAttributeAfterClicking")));

    }

}
