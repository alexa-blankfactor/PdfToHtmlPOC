package com.itelInc.page;

import com.itelInc.constants.FilePath;
import com.itelInc.utils.CompareImage;
import com.itelInc.utils.FindElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class IPAsphaltShingleReport {

    private WebDriver driver;
    @FindBy(xpath = "//span[@title='Customer']//following-sibling::span")
    private WebElement customer;
    @FindBy(xpath = "//span[@title='Cust ID']//following::span[1]")
    private WebElement customerId;
    @FindBy(xpath = "//span[@title='Adjuster']//preceding::span[3]")
    private WebElement adjuster;

    @FindBy(xpath = "//span[@title='Source']//preceding::span[3]")
    private WebElement source;
    @FindBy(xpath="//span[@title='Control #']//following::span[3]")
    private WebElement controlNumber;
    @FindBy(xpath = "//span[@title='Date Received']//following::span[3]")
    private WebElement dateReceived;
    @FindBy(xpath = "//span[@title='Date Invoiced']//following::span[3]")
    private WebElement dateInvoiced;
    @FindBy(xpath = "//span[@title='Additional']//following-sibling::span")
    private WebElement additional;
    @FindBy(xpath = "//span[@title='Vendor Job#']//following-sibling::span[2]")
    private WebElement vendorJobNumber;
    @FindBy(xpath = "//span[@title='Contact']//following::span")
    private List<WebElement> contact;
    @FindBy(xpath = "(//span[@title='Comments'])[1]//preceding::span[9]//following::span")
    private List<WebElement> customerInformationComments;
    @FindBy(xpath = "//span[@title='Claim #']//following::span[1]")
    private WebElement claimNumber;
    @FindBy(xpath = "//span[@title='Insured Name']//preceding::span[4]")
    private WebElement insuredName;
    @FindBy(xpath = "//span[@title='City,State,Zip']//preceding::span[7]")
    private WebElement cityStateZip;
    @FindBy(xpath = "//span[@title='Loss Date']//following::span[5]")
    private WebElement lossDate;
    @FindBy(xpath = "//span[@title='Area Damaged']//preceding::span[7]")
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

    private final  String htmlImages ="//*[name()='svg']//*[name()='g']//*[name()='image']";

    public IPAsphaltShingleReport(WebDriver driver) {
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
                !text.contains("Adjuster")).collect(Collectors.joining()).trim():"";
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
                !text.contains("Need help sourcing")).collect(Collectors.joining()).trim():"";
    }

    public Boolean areTheImagesIncludedInReport(String expectedImage){
        boolean areTheImagesIncludedInReport= false;
        driver.switchTo().frame(driver.findElements(By.tagName("object")).get(0));
        List<WebElement>elements=driver.findElements(By.xpath(htmlImages));
        if(FindElement.isPresent(elements)){
            List<String> imagesName= elements.stream().map(image -> image.getAttribute("xlink:href")).distinct().toList();
            areTheImagesIncludedInReport= imagesName.stream()
                    .map(image -> new CompareImage()
                            .compare(FilePath.FILE_PATH_TEST_IMAGE.getFilePath() + expectedImage, FilePath.FILE_PATH_IASP_HTML_RESOURCES.getFilePath() + image))
                    .filter(result -> !result).toList().size() >= 1;

            driver.switchTo().defaultContent();
            return areTheImagesIncludedInReport;
        }
        driver.switchTo().defaultContent();
        return areTheImagesIncludedInReport;
    }
}
