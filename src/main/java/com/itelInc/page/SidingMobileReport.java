package com.itelInc.page;

import com.itelInc.constants.FilePath;
import com.itelInc.utils.CompareImage;
import com.itelInc.utils.FindElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SidingMobileReport {
    private WebDriver driver;

    private final String MATCHING_APP_RESULT_AVAILABLE= "A similar match is available";
    @FindBy(xpath = "//span[contains(@title,'CONTROL #')]")
    private WebElement controlNumber;
    @FindBy(xpath = "//span[@title='Customer']//following-sibling::span")
    private WebElement customer;
    @FindBy(xpath = "//span[@title='Cust. ID']//following-sibling::span")
    private WebElement customerId;
    @FindBy(xpath = "//span[@title='Adjuster']//following-sibling::span")
    private WebElement adjuster;
    @FindBy(xpath = "//span[@title='Additional']//following-sibling::span")
    private WebElement additional;
    @FindBy(xpath = "//span[@title='Contact']//following-sibling::span")
    private WebElement contact;
    @FindBy(xpath = "//span[@title='E-mail']//following-sibling::span")
    private WebElement email;
    @FindBy(xpath = "//span[@title='Fax']//following-sibling::span")
    private WebElement fax;
    @FindBy(xpath = "//span[@title='Date Invoiced']//following-sibling::span")
    private WebElement dateInvoiced;
    @FindBy(xpath = "//span[@title='Date Received']//following-sibling::span")
    private WebElement dateReceived;
    @FindBy(xpath = "(//span[@title='Insured Name'])[2]//following-sibling::span")
    private WebElement insuredName;
    @FindBy(xpath = "//span[@title='Claim #']//following-sibling::span")
    private WebElement claimNumber;
    @FindBy(xpath = "//span[@title='Loss Location']//following-sibling::span[3]")
    private WebElement lossLocation;
    @FindBy(xpath = "//span[@title='Area Damaged']//following-sibling::span")
    private WebElement areaDamaged;
    @FindBy(xpath = "//span[@title='Loss Date']//following-sibling::span")
    private WebElement lossDate;
    @FindBy(xpath = "//span[@title='MATCHING APP RESULT']//preceding::span[1]")
    private WebElement matchingAppResult;
    @FindBy(xpath = "//span[@title='MATCH 1']//following-sibling::span")
    private List<WebElement> match1;
    @FindBy(xpath = "//span[@title='Profile']//following-sibling::span")
    private WebElement profile;
    @FindBy(xpath = "//span[@title='Material']//following-sibling::span")
    private WebElement material;
    @FindBy(xpath = "//span[@title='Projection']//following-sibling::span")
    private WebElement projection;
    @FindBy(xpath = "//span[@title='Thickness']//following-sibling::span")
    private WebElement thickness;
    @FindBy(xpath = "//span[@title='Best Color Match*']//following-sibling::span")
    private List<WebElement> bestColorMatch;
    @FindBy(xpath = "//span[@title='Other Candidate Color Matches*']//following-sibling::span")
    private List<WebElement> otherCandidateColorMatches;
    @FindBy(xpath = "//span[@title='Manufacturer Info']//following::span[1]")
    private List<WebElement> manufactureInfo;

    @FindBy(xpath = "(//span[@title='Comments'])[1]//following::span")
    private List<WebElement> matchingAppResultComments;
    @FindBy(xpath = "(//span[@title='Comments'])[2]//following::span")
    private List<WebElement> matchingProductsComments;
    @FindBy(xpath = "//span[@title='Helpful Comments']//following::span")
    private List<WebElement> match1HelpfulComments;
    @FindBy(xpath = "//span[@title='ADDITIONAL COMMENTS']//following::span")
    private List<WebElement> additionalComments;


    private final  String htmlImages ="//*[name()='svg']//*[name()='g']//*[name()='image']";
    private String searchSuppliers ="";

    public SidingMobileReport(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public String getControlNumber(){
      return FindElement.isPresent(controlNumber)?Arrays.stream(controlNumber.getText()
              .split(":")).toList().get(1).trim(): "";

    }

    public String getCustomer(){
        return FindElement.isPresent(customer)?customer.getText():"";
    }

    public String getCustomerId(){
        return FindElement.isPresent(customerId)?customerId.getText().trim():"";
    }

    public String getAdjuster(){
        return FindElement.isPresent(adjuster)?adjuster.getText().trim():"";
    }

    public String getAdditional(){
        return FindElement.isPresent(additional)?additional.getText().trim():"";
    }

    public String getContact(){
        return FindElement.isPresent(contact)?contact.getText().trim():"";
    }

    public String getEmail(){
        return FindElement.isPresent(email)?email.getText().trim():"";
    }

    public String getFax(){
        return FindElement.isPresent(fax)?fax.getText().trim():"";
    }

    public String getDateInvoiced(){
        return FindElement.isPresent(dateInvoiced)?dateInvoiced.getText().trim():"";
    }
    public String getDateReceived(){
        return FindElement.isPresent(dateReceived)?dateReceived.getText().trim():"";
    }
    public String getInsuredName(){
        return FindElement.isPresent(insuredName)?insuredName.getText().trim():"";
    }
    public String getClaimNumber(){
        return FindElement.isPresent(claimNumber)?claimNumber.getText().trim():"";
    }
    public String getLossLocation(){
        return FindElement.isPresent(lossLocation)?lossLocation.getAttribute("title").trim():"";
    }
    public String getAreaDamage(){
        return FindElement.isPresent(areaDamaged)?areaDamaged.getText().trim():"";
    }

    public String getLossDate(){
        return FindElement.isPresent(lossDate)?lossDate.getText().trim():"";
    }
    public String getMatchingAppResult(){
        return FindElement.isPresent(matchingAppResult)?matchingAppResult.getText().replace(";",",").trim():"";
    }
    public String getMatch1(){
        return FindElement.isPresent(match1)?match1.stream().map(WebElement::getText).collect(Collectors.joining()).trim() :"";
    }
    public String getProfile(){
        return FindElement.isPresent(profile)?profile.getText().trim():"";
    }
    public String getMaterial(){
        return FindElement.isPresent(material)?material.getText().trim():"";
    }
    public String getProjection(){
        return FindElement.isPresent(projection)?projection.getText().replace('"',' ').trim():"";
    }
    public String getThickness(){
        return FindElement.isPresent(thickness)?thickness.getText().replace('"',' ').trim():"";
    }
    public String getBestColorMatch(){
        return  FindElement.isPresent(bestColorMatch)? bestColorMatch.stream().map(WebElement::getText).filter(x -> !x.isBlank()).findFirst().get().trim():"";

    }
    public String getOtherCandidateColorMatches(){
        if(FindElement.isPresent(otherCandidateColorMatches)){
            List<String> otherColorMatches= otherCandidateColorMatches.stream().map(x -> x.getAttribute("title")).filter(x -> !x.isBlank()).distinct().toList();
            int otherColorMatchesSize= otherColorMatches.size();
            return otherColorMatches.stream().skip(otherColorMatchesSize-1).findFirst().get();
        }else {
            return "";
        }
    }
    public String getManufacturerInfo(){
        return FindElement.isPresent(manufactureInfo)? manufactureInfo.stream().map(WebElement::getText).filter(x -> !x.isBlank()).findFirst().get().trim():"";
    }

    public Boolean findSuppliers(List<String> suppliers){
        String prefixXpath= "//*[";
        String baseXpath = "contains(@title,'?')";
        String endXpath ="]";
        List<WebElement> suppliersElements= new ArrayList<>();
        if (suppliers.size() > 1){
            searchSuppliers=searchSuppliers.concat(prefixXpath);
            searchSuppliers=searchSuppliers.concat(baseXpath.replace("?",suppliers.get(0)));
            suppliers.stream().skip(1).forEach(supplier->{
                searchSuppliers=searchSuppliers.concat(" or ");
                searchSuppliers=searchSuppliers.concat(baseXpath.replace("?",supplier));

            });
            searchSuppliers=searchSuppliers.concat(endXpath);
        }else{
            searchSuppliers= prefixXpath+ baseXpath.replace("?",suppliers.get(0)) +endXpath;
        }
        suppliersElements= driver.findElements(By.xpath(searchSuppliers));

        return FindElement.isPresent(suppliersElements);

    }

    public Boolean isSimilarMatchAvailable(){
        boolean isSimilarMatchAvailable= false;
        if (matchingAppResult.getText().contains(MATCHING_APP_RESULT_AVAILABLE)){
            driver.switchTo().frame(driver.findElements(By.tagName("object")).get(0));
            List<WebElement>elements=driver.findElements(By.xpath(htmlImages));
            if(FindElement.isPresent(elements)){
                List<String> imagesName= elements.stream().map(image -> image.getAttribute("xlink:href")).distinct().toList();
                isSimilarMatchAvailable= imagesName.stream()
                        .map(image -> new CompareImage()
                                .compare(FilePath.FILE_PATH_TEST_IMAGE.getFilePath() + "check.png", FilePath.FILE_PATH_SIDING_MOBILE_HTML_RESOURCES.getFilePath() + image))
                        .filter(result -> !result).toList().size() >= 1;

                driver.switchTo().defaultContent();
                return isSimilarMatchAvailable;

            }
        }
        driver.switchTo().defaultContent();
        return isSimilarMatchAvailable;
    }

    public Boolean isSimilarMatchUnavailable(){
        boolean isSimilarMatchUnavailable= false;
        if (matchingAppResult.getText().contains(MATCHING_APP_RESULT_AVAILABLE)){
            driver.switchTo().frame(driver.findElements(By.tagName("object")).get(0));
            List<WebElement>elements=driver.findElements(By.xpath(htmlImages));
            if(FindElement.isPresent(elements)){
                List<String> imagesName= elements.stream().map(image -> image.getAttribute("xlink:href")).distinct().toList();
                isSimilarMatchUnavailable= imagesName.stream()
                        .map(image -> new CompareImage()
                                .compare(FilePath.FILE_PATH_TEST_IMAGE.getFilePath() + "uncheck.png", FilePath.FILE_PATH_SIDING_MOBILE_HTML_RESOURCES.getFilePath() + image))
                        .filter(result -> !result).toList().size() >= 1;
                driver.switchTo().defaultContent();
                return isSimilarMatchUnavailable;

            }
        }
        driver.switchTo().defaultContent();
        return isSimilarMatchUnavailable;
    }

    public Boolean areTheImagesIncludedInReport(String expectedImage){
        boolean areTheImagesIncludedInReport= false;
        driver.switchTo().frame(driver.findElements(By.tagName("object")).get(1));
        List<WebElement>elements=driver.findElements(By.xpath(htmlImages));
        if(FindElement.isPresent(elements)){
            List<String> imagesName= elements.stream().map(image -> image.getAttribute("xlink:href")).distinct().toList();
            areTheImagesIncludedInReport= imagesName.stream()
                    .map(image -> new CompareImage()
                            .compare(FilePath.FILE_PATH_TEST_IMAGE.getFilePath() + expectedImage, FilePath.FILE_PATH_SIDING_MOBILE_HTML_RESOURCES.getFilePath() + image))
                    .filter(result -> !result).toList().size() >= 1;

            driver.switchTo().defaultContent();
            return areTheImagesIncludedInReport;
        }
        driver.switchTo().defaultContent();
        return areTheImagesIncludedInReport;
    }

    public String getMatchingAppResultComments(){
       return matchingAppResultComments.stream().map(result->result.getText()).takeWhile(text->
           !text.contains("MATCHING PRODUCTS")).collect(Collectors.joining()).trim().replace(";",",");

    }
    public String getMatchingProductComments(){
        return matchingProductsComments.stream().map(result->result.getText()).takeWhile(text->
                !text.contains("See PERSONALIZED")).collect(Collectors.joining()).trim().replace(";",",");
    }
    public String getMatching1HelpfulComments(){
        return match1HelpfulComments.stream().map(result->result.getText()).takeWhile(text->
                !text.contains("Matched with the ITEL Matching App")).collect(Collectors.joining()).trim().replace(";",",");
    }

    public String getAdditionalComments(){
        return additionalComments.stream().map(result->result.getText()).takeWhile(text->
                !text.contains("Print Date")).collect(Collectors.joining()).trim().replace(";",",");

    }

}
