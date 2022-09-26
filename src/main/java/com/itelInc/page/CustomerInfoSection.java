package com.itelInc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomerInfoSection {

    @FindBy(xpath = "//div//span[contains(text(),'Customer')]//following-sibling::span|(//div//span[contains(text(),'Customer')])[1]//following::span[3]|//div//span[contains(text(),'Customer')]//following-sibling::span")
    private WebElement customerName;

    @FindBy(xpath = "//div//span[contains(text(),'Control')]//following::span[1]|//div//span[contains(text(),'CONTROL')]|//div//span[contains(text(),'Control Number')]//following::span[3]")
    private WebElement controlNumber;

    @FindBy(xpath = "//div//span[contains(text(),'Cust. ID')]//following::span[1]|//div//span[contains(text(),'Cust. ID')]//following::span[2]|//div//span[contains(text(),'Customer ID')]//following::span[3]|//div//span[contains(text(),'Cust ID')]//following::span[3]")
    private WebElement customertId;

    @FindBy(xpath = "//div//span[contains(text(),'Date Received')]//following-sibling::span|(//div//span[contains(text(),'Date Received')])[2]//preceding::span[1]|//div//span[contains(text(),'Date Received')]//following::span[3]")
    private WebElement dateReceived;

    @FindBy(xpath = "//div//span[contains(text(),'Date Invoiced')]//following::span[1]|(//div//span[contains(text(),'Date Invoiced')])[1]//following::span[3]|//div//span[contains(text(),'Date Invoiced')]//following::span[2]|(//div//span[contains(text(),'Date Invoiced')])[2]//following::span[2]")
    private WebElement dateInvoiced;

    public CustomerInfoSection(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String getCustomerName(){
        return customerName.getText().isEmpty() ? null : customerName.getText();
    }
    public String getControlNumber(){
        return controlNumber.getText().isEmpty() ? null : controlNumber.getText();
    }
    public String getCustomerId(){
        return customertId.getText().isEmpty()? null : customertId.getText();
    }
    public String getDateReceived(){
        return dateReceived.getText().isEmpty()? null : dateReceived.getText();
    }
    public String getDateInvoiced(){return dateInvoiced.getText().isEmpty()? null: dateInvoiced.getText();}
}
