package com.itelInc.page;

import com.itelInc.utils.FindElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AsphaltShingleMobileReport {

    private WebDriver driver;
    @FindBy(xpath = "//span[@title='Customer']//following-sibling::span")
    private WebElement customer;
    @FindBy(xpath = "//span[@title='Cust ID']//following::span[1]")
    private WebElement customerId;
    @FindBy(xpath = "//span[@title='Adjuster']//following::span[1]")
    private WebElement adjuster;
    @FindBy(xpath="//span[@title='Control #']//following::span[3]")
    private WebElement controlNumber;
    @FindBy(xpath = "//span[@title='Date Received']//following::span[3]")
    private WebElement dateReceived;
    @FindBy(xpath = "//span[@title='Date Invoiced']//following::span[3]")
    private WebElement dateInvoiced;
    @FindBy(xpath = "//span[@title='Additional']//following-sibling::span")
    private WebElement additional;
    @FindBy(xpath = "//span[@title='Vendor Job#']//following-sibling::span")
    private WebElement vendorJobNumber;
    @FindBy(xpath = "//span[@title='Contact']//following::span")
    private List<WebElement> contact;
    @FindBy(xpath = "(//span[@title='Comments'])[1]//following::span[1]")
    private List<WebElement> customerInformationComments;
    @FindBy(xpath = "//span[@title='Claim #']//following::span[1]")
    private WebElement claimNumber;
    @FindBy(xpath = "//span[@title='Insured Name']//preceding::span[5]")
    private WebElement insuredName;
    @FindBy(xpath = "//span[@title='City,State,Zip']//following::span[2]")
    private WebElement cityStateZip;
    @FindBy(xpath = "//span[@title='Loss Date']//following::span[2]")
    private WebElement lossDate;
    @FindBy(xpath = "//span[@title='Area Damaged']//following::span[2]")
    private WebElement areaDamaged;
    @FindBy(xpath = "(//span[@title='Comments'])[2]//following::span[2]")
    private List<WebElement> insuredInformationComments;
    @FindBy(xpath = "//span[@title='ITEL BENCHMARK']//following::span")
    private List<WebElement> itelBenchmarkItems;
    @FindBy(xpath = "//span[@title='Price Per Square']//following-sibling::span")
    private WebElement pricePerSquare;
    @FindBy(xpath = "//span[@title='Price Per Square']//following::span")
    private List<WebElement> benchmarkComments;
    @FindBy(xpath = "//span[@title='Type']//following::span[1]")
    private WebElement closestAPSType;
    @FindBy(xpath = "//span[@title='Construction']//preceding::span[10]")
    private WebElement closestAPSConstruction;
    @FindBy(xpath = "(//span[@title='Laminated'])[2]")
    private WebElement closestAPSLaminated;
    @FindBy(xpath = "//span[@title='Algae Resistant']//following::span[2]")
    private WebElement closestAPSAlgaeResistant;
    @FindBy(xpath = "//span[@title='Solar Reflective']//following::span[2]")
    private WebElement closestAPSSolarReflective;
    @FindBy(xpath = "//span[@title='Impact Resistant']//following::span[2]")
    private WebElement closestAPSImpactResistant;
    @FindBy(xpath = "//span[@title='Warranty']//following::span[1]")
    private WebElement closestAPSWarranty;
    @FindBy(xpath = "(//span[@title='Comments'])[3]//following::span")
    private List<WebElement> closestAPSComments;
    @FindBy(xpath = "//span[@title='ADDITIONAL COMMENTS']//following::span")
    private List<WebElement> additionalComments;

    public AsphaltShingleMobileReport(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getCustomer(){
        return FindElement.isPresent(customer)?customer.getText().trim():"";
    }

    public String getCustomerId(){
        return FindElement.isPresent(customerId)?customerId.getText().trim():"";
    }

    public String getControlNumber(){
        return FindElement.isPresent(controlNumber)?controlNumber.getText().trim():"";
    }
    public String getAdjuster(){
        return FindElement.isPresent(adjuster)?adjuster.getText().trim():"";
    }
    public String getDateReceived(){
        return FindElement.isPresent(dateReceived)?dateReceived.getText().trim():"";
    }
    public String getDateInvoiced(){
        return FindElement.isPresent(dateInvoiced)? dateInvoiced.getText().trim():"";
    }

    public String getAdditional(){
        return FindElement.isPresent(additional)?additional.getText().trim():"";
    }

    public String getVendorJobNumber(){
        return FindElement.isPresent(vendorJobNumber)?vendorJobNumber.getText().trim():"";
    }
    public String getContact(){
        return FindElement.isPresent(contact)?contact.stream().map(WebElement::getText).takeWhile(text->
                !text.contains("Comments")).collect(Collectors.joining()).trim():"";
    }

    public String getCustomerInformationComments(){
        return FindElement.isPresent(customerInformationComments)?customerInformationComments.stream().map(WebElement::getText).takeWhile(text->
                !text.contains("INSURED INFORMA")).collect(Collectors.joining()).trim():"";
    }

    public String getClaimNumber(){
        return FindElement.isPresent(claimNumber)?claimNumber.getText().trim():"";
    }

    public String getInsuredName(){
        return FindElement.isPresent(insuredName)?insuredName.getText().trim():"";
    }

    public String getCityStateZip(){
        return FindElement.isPresent(cityStateZip)?cityStateZip.getText().trim():"";
    }

    public String getLossDate(){
        return FindElement.isPresent(lossDate)?lossDate.getText().trim():"";
    }

    public String getAreaDamaged(){
        return FindElement.isPresent(areaDamaged)?areaDamaged.getText().trim():"";
    }

    public String getInsuredInformationComments(){
        return FindElement.isPresent(insuredInformationComments)?insuredInformationComments.stream().map(WebElement::getText).takeWhile(text->
                !text.contains("ITEL BENCHMARK")).collect(Collectors.joining()).trim():"";
    }

    public List<String> getItelBenchmarkItems(){
        return FindElement.isPresent(itelBenchmarkItems)?itelBenchmarkItems.stream().map(WebElement::getText).takeWhile(text->
                !text.contains("Price Per Square")).collect(Collectors.toList()) :null;
    }

    public String getPricePerSquare(){
        return FindElement.isPresent(pricePerSquare)?pricePerSquare.getText().trim():"";
    }
    public String getBenchMarkComments(){
        return FindElement.isPresent(benchmarkComments)?benchmarkComments.stream().map(WebElement::getText).skip(1).takeWhile(text->
                !text.contains("CLOSEST A")).collect(Collectors.joining()).trim():"";
    }

    public String getClosestAPSType(){
        return FindElement.isPresent(closestAPSType)?closestAPSType.getText().trim():"";
    }

    public String getClosestAPSConstruction(){
        return FindElement.isPresent(closestAPSConstruction)?closestAPSConstruction.getText().trim():"";
    }
    public  String getClosestAPSLaminated(){
        return FindElement.isPresent(closestAPSLaminated)?closestAPSLaminated.getText().trim():"";
    }

    public String getClosestAPSAlgaeResistant(){
        return FindElement.isPresent(closestAPSAlgaeResistant)?closestAPSAlgaeResistant.getText().trim():"";
    }

    public String getClosestAPSSolarReflective(){
        return FindElement.isPresent(closestAPSSolarReflective)?closestAPSSolarReflective.getText().trim():"";
    }
    public String getClosestAPSImpactResistant(){
        return FindElement.isPresent(closestAPSImpactResistant)?closestAPSImpactResistant.getText().trim():"";
    }

    public String getClosestAPSWarranty(){
        return FindElement.isPresent(closestAPSWarranty)?closestAPSWarranty.getText().trim():"";
    }

    public String getClosestAPSComments(){
        return FindElement.isPresent(closestAPSComments)?closestAPSComments.stream().map(WebElement::getText).takeWhile(text->
                !text.contains("ADDITIONAL COMMENTS")).collect(Collectors.joining()).trim():"";
    }

    public String getAdditionalComments(){
        return FindElement.isPresent(additionalComments)?additionalComments.stream().map(WebElement::getText).takeWhile(text->
                !text.contains("Evaluation Only.")).collect(Collectors.joining()).trim():"";
    }
}
