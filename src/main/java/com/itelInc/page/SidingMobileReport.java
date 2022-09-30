package com.itelInc.page;

import com.itelInc.constants.FilePath;
import com.itelInc.utils.CompareImage;
import com.itelInc.utils.FindElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

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
    @FindBy(xpath = "//span[@title='MATCH 1']//following-sibling::span[4]")
    private WebElement match1;
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

    private final  String htmlImages ="//*[name()='svg']//*[name()='g']//*[name()='image']";
    private String searchSuppliers ="";

    public SidingMobileReport(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public String getControlNumber(){
      return FindElement.isPresent(controlNumber)?Arrays.stream(controlNumber.getText()
              .split(":")).toList().get(1).trim(): null;

    }

    public String getCustomer(){
        return FindElement.isPresent(customer)?customer.getText():null;
    }

    public String getCustomerId(){
        return FindElement.isPresent(customerId)?customerId.getText():null;
    }

    public String getAdjuster(){
        return FindElement.isPresent(adjuster)?adjuster.getText():null;
    }

    public String getAdditional(){
        return FindElement.isPresent(additional)?additional.getText():null;
    }

    public String getContact(){
        return FindElement.isPresent(contact)?contact.getText():null;
    }

    public String getEmail(){
        return FindElement.isPresent(email)?email.getText():null;
    }

    public String getFax(){
        return FindElement.isPresent(fax)?fax.getText():null;
    }

    public String getDateInvoiced(){
        return FindElement.isPresent(dateInvoiced)?dateInvoiced.getText():null;
    }
    public String getDateReceived(){
        return FindElement.isPresent(dateReceived)?dateReceived.getText():null;
    }
    public String getDateInsuredName(){
        return FindElement.isPresent(insuredName)?insuredName.getText():null;
    }
    public String getClaimNumber(){
        return FindElement.isPresent(claimNumber)?claimNumber.getText():null;
    }
    public String getLossLocation(){
        return FindElement.isPresent(lossLocation)?lossLocation.getText():null;
    }
    public String getAreaDamage(){
        return FindElement.isPresent(areaDamaged)?areaDamaged.getText():null;
    }

    public String getLossDate(){
        return FindElement.isPresent(lossDate)?lossDate.getText():null;
    }
    public String getMatchingAppResult(){
        return FindElement.isPresent(matchingAppResult)?matchingAppResult.getText():null;
    }
    public String getMatch1(){
        return FindElement.isPresent(match1)?match1.getText():null;
    }
    public String getProfile(){
        return FindElement.isPresent(profile)?profile.getText():null;
    }
    public String getMaterial(){
        return FindElement.isPresent(material)?material.getText():null;
    }
    public String getProjection(){
        return FindElement.isPresent(projection)?projection.getText():null;
    }
    public String getThickness(){
        return FindElement.isPresent(thickness)?thickness.getText():null;
    }
    public String getBestColorMatch(){
        return  FindElement.isPresent(bestColorMatch)? bestColorMatch.stream().map(WebElement::getText).filter(x -> !x.isBlank()).findFirst().get():null;

    }
    public String getOtherCandidateColorMatches(){
        if(FindElement.isPresent(otherCandidateColorMatches)){
            List<String> otherColorMatches= otherCandidateColorMatches.stream().map(x -> x.getAttribute("title")).filter(x -> !x.isBlank()).distinct().toList();
            int otherColorMatchesSize= otherColorMatches.size();
            return otherColorMatches.stream().skip(otherColorMatchesSize-1).findFirst().get();
        }else {
            return null;
        }
    }
    public String getManufacturerInfo(){
        return FindElement.isPresent(manufactureInfo)? manufactureInfo.stream().map(WebElement::getText).filter(x -> !x.isBlank()).findFirst().get():null;
    }

    public Boolean findSuppliers(List<String> suppliers){
        String prefixXpath= "//*[";
        String baseXpath = "contains(@title,'?')";
        String endXpath ="]";
        List<WebElement> suppliersElements= null;
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
        if (matchingAppResult.getText().contains(MATCHING_APP_RESULT_AVAILABLE)){
            driver.switchTo().frame(driver.findElements(By.tagName("object")).get(0));
            List<WebElement>elements=driver.findElements(By.xpath(htmlImages));
            if(FindElement.isPresent(elements)){
                List<String> imagesName= elements.stream().map(image -> image.getAttribute("xlink:href")).distinct().toList();
                driver.switchTo().defaultContent();
                return imagesName.stream()
                        .map(image -> new CompareImage()
                                .compare(FilePath.FILE_PATH_TEST_IMAGE.getFilePath() + "check.png", FilePath.FILE_PATH_SIDING_MOBILE_HTML_RESOURCES.getFilePath() + image))
                        .filter(result -> !result).toList().size() >= 1;


            }
        }
        driver.switchTo().defaultContent();
        return false;
    }

    public Boolean isSimilarMatchUnavailable(){
        if (matchingAppResult.getText().contains(MATCHING_APP_RESULT_AVAILABLE)){
            driver.switchTo().frame(driver.findElements(By.tagName("object")).get(0));
            List<WebElement>elements=driver.findElements(By.xpath(htmlImages));
            if(FindElement.isPresent(elements)){
                List<String> imagesName= elements.stream().map(image -> image.getAttribute("xlink:href")).distinct().toList();
                driver.switchTo().defaultContent();
                return imagesName.stream()
                        .map(image -> new CompareImage()
                                .compare(FilePath.FILE_PATH_TEST_IMAGE.getFilePath() + "uncheck.png", FilePath.FILE_PATH_SIDING_MOBILE_HTML_RESOURCES.getFilePath() + image))
                        .filter(result -> !result).toList().size() >= 1;


            }
        }
        driver.switchTo().defaultContent();
        return false;
    }

    public Boolean areTheImagesIncludedInReport(String expectedImage){
        driver.switchTo().frame(driver.findElements(By.tagName("object")).get(1));
        List<WebElement>elements=driver.findElements(By.xpath(htmlImages));
        if(FindElement.isPresent(elements)){
            List<String> imagesName= elements.stream().map(image -> image.getAttribute("xlink:href")).distinct().toList();
            driver.switchTo().defaultContent();
          return imagesName.stream()
                    .map(image -> new CompareImage()
                            .compare(FilePath.FILE_PATH_TEST_IMAGE.getFilePath() + expectedImage, FilePath.FILE_PATH_SIDING_MOBILE_HTML_RESOURCES.getFilePath() + image))
                    .filter(result -> !result).toList().size() >= 1;


        }
        driver.switchTo().defaultContent();
        return false;
    }


}
