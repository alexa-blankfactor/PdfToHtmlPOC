package com.itelInc;

import com.itelInc.constants.FilePath;
import com.itelInc.hooks.Driver;
import com.itelInc.page.AsphaltShingleMobileReport;
import com.itelInc.page.SidingMobileReport;
import com.itelInc.utils.CSVContent;
import com.itelInc.utils.ConvertPDFtoHTML;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReportPdfTest  extends Driver{

    private WebDriver driver;
    @Test
    public void testReportPdf(){
        String pdfReportName = "Asphalt_Shingle_Mobile";
        ConvertPDFtoHTML convertPDFtoHTML = new ConvertPDFtoHTML();
        convertPDFtoHTML.convert(pdfReportName,true);
        driver = getDriver();
        driver.get("file://"+new File(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+pdfReportName+".html").getAbsoluteFile());
        SidingMobileReport sidingMobileReportPage= new SidingMobileReport(driver);

    }

    @Test
    public void successful_ASP_mobile_report_generation(){
        String pdfReportName = "Asphalt_Shingle_Mobile";
        ConvertPDFtoHTML convertPDFtoHTML = new ConvertPDFtoHTML();
        convertPDFtoHTML.convert(pdfReportName,true);
        driver = getDriver();
        driver.get("file://"+new File(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+pdfReportName+".html").getAbsoluteFile());
        AsphaltShingleMobileReport asphaltShingleMobileReport= new AsphaltShingleMobileReport(driver);
        List<Map<String,String>> asphaltShingleMobileReportValuesExpected=CSVContent.getValue(FilePath.FILE_PATH_DATA_TEST.getFilePath() + pdfReportName+ "_data_expected.csv");
        assertThat(asphaltShingleMobileReportValuesExpected.get(0)).satisfies(valueExpected->{
            assertThat(asphaltShingleMobileReport.getCustomer()).as("customer").isEqualTo(valueExpected.get("customer"));
            assertThat(asphaltShingleMobileReport.getCustomerId()).as("customerId").isEqualTo(valueExpected.get("customerId"));
            assertThat(asphaltShingleMobileReport.getAdjuster()).as("adjuster").isEqualTo(valueExpected.get("adjuster"));
            assertThat(asphaltShingleMobileReport.getControlNumber()).as("controlNumber").isEqualTo(valueExpected.get("controlNumber"));
            assertThat(asphaltShingleMobileReport.getDateReceived()).as("dateReceived").isEqualTo(valueExpected.get("dateReceived"));
            assertThat(asphaltShingleMobileReport.getDateInvoiced()).as("dateInvoiced").isEqualTo(valueExpected.get("dateInvoiced"));
            assertThat(asphaltShingleMobileReport.getAdditional()).as("additional").isEqualTo(valueExpected.get("additional"));
            assertThat(asphaltShingleMobileReport.getVendorJobNumber()).as("vendorJobNumber").isEqualTo(valueExpected.get("vendorJobNumber"));
            assertThat(asphaltShingleMobileReport.getContact()).as("contact").isEqualTo(valueExpected.get("contact"));
            assertThat(asphaltShingleMobileReport.getCustomerInformationComments()).as("Customer information comments").isEqualTo(valueExpected.get("customerInformationComments"));
            assertThat(asphaltShingleMobileReport.getClaimNumber()).as("Claim number").isEqualTo(valueExpected.get("claimNumber"));
            assertThat(asphaltShingleMobileReport.getInsuredName()).as("Insured Name").isEqualTo(valueExpected.get("insuredName"));
            assertThat(asphaltShingleMobileReport.getCityStateZip()).as("City,State,Zip").isEqualTo(valueExpected.get("cityStateZip"));
            assertThat(asphaltShingleMobileReport.getLossDate()).as("Loss Date").isEqualTo(valueExpected.get("lossDate"));
            assertThat(asphaltShingleMobileReport.getAreaDamaged()).as("Area Damaged").isEqualTo(valueExpected.get("areaDamaged"));
            assertThat(asphaltShingleMobileReport.getInsuredInformationComments()).as("Insured Information Comments").isEqualTo(valueExpected.get("insuredInformationComments"));
            assertThat(asphaltShingleMobileReport.getItelBenchmarkItems().stream().map(String::trim).collect(Collectors.joining(" "))).as("Itel benchmark items").isEqualTo(valueExpected.get("itelBenchmarkItems"));
            assertThat(asphaltShingleMobileReport.getPricePerSquare()).as("Price Per Square").isEqualTo(valueExpected.get("pricePerSquare"));
            assertThat(asphaltShingleMobileReport.getBenchMarkComments()).as("Itel Benchmark comments").contains(valueExpected.get("benchmarkComments"));
            assertThat(asphaltShingleMobileReport.getClosestAPSType()).as("Closesr available product specifications type").isEqualTo(valueExpected.get("closestAPSType"));
            assertThat(asphaltShingleMobileReport.getClosestAPSConstruction()).as("Closesr available product specifications construction").isEqualTo(valueExpected.get("closestAPSConstruction"));
            assertThat(asphaltShingleMobileReport.getClosestAPSAlgaeResistant()).as("Closesr available product specifications Algae resistant").isEqualTo(valueExpected.get("closestAPSAlgaeResistant"));
            assertThat(asphaltShingleMobileReport.getClosestAPSSolarReflective()).as("Closesr available product specifications Solar reflective").isEqualTo(valueExpected.get("closestAPSSolarReflective"));
            assertThat(asphaltShingleMobileReport.getClosestAPSImpactResistant()).as("Closesr available product specifications Impact Resistant").isEqualTo(valueExpected.get("closestAPSImpactResistant"));
            assertThat(asphaltShingleMobileReport.getClosestAPSWarranty()).as("Closesr available product specifications Warranty").isEqualTo(valueExpected.get("closestAPSWarranty"));
            assertThat(asphaltShingleMobileReport.getClosestAPSComments()).as("Closesr available product specifications comments").isEqualTo(valueExpected.get("closestAPSComments"));
            assertThat(asphaltShingleMobileReport.getAdditionalComments()).as("additional comments").isEqualTo(valueExpected.get("additionalComments"));

        });
    }

    @Test
    public void successful_siding_mobile_report_generation(){
        String pdfReportName = "Siding_Mobile";
        ConvertPDFtoHTML convertPDFtoHTML = new ConvertPDFtoHTML();
        convertPDFtoHTML.convert(pdfReportName,false);
        driver = getDriver();
        driver.get("file://"+new File(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+pdfReportName+".html").getAbsoluteFile());
        SidingMobileReport sidingMobileReportPage= new SidingMobileReport(driver);
        List<Map<String,String>> sidingMobileReportValuesExpected=CSVContent.getValue(FilePath.FILE_PATH_DATA_TEST.getFilePath() + pdfReportName+ "_data_expected.csv");
        assertThat(sidingMobileReportPage.getCustomer().trim()).as("customer").isEqualTo(sidingMobileReportValuesExpected.get(0).get("customer"));
        assertThat(sidingMobileReportPage.getCustomerId()).as("customer Id").isEqualTo(sidingMobileReportValuesExpected.get(0).get("customerId"));
        assertThat(sidingMobileReportPage.getAdjuster()).as("adjuster").isEqualTo(sidingMobileReportValuesExpected.get(0).get("adjuster"));
        assertThat(sidingMobileReportPage.getControlNumber()).as("control Number").isEqualTo(sidingMobileReportValuesExpected.get(0).get("controlNumber"));
        assertThat(sidingMobileReportPage.getDateReceived()).as("date Received").isEqualTo(sidingMobileReportValuesExpected.get(0).get("dateReceived"));
        assertThat(sidingMobileReportPage.getDateInvoiced()).as("date Invoiced").isEqualTo(sidingMobileReportValuesExpected.get(0).get("dateInvoiced"));
        assertThat(sidingMobileReportPage.getAdditional()).as("additional").isEqualTo(sidingMobileReportValuesExpected.get(0).get("additional"));
        assertThat(sidingMobileReportPage.getContact()).as("contact").isEqualTo(sidingMobileReportValuesExpected.get(0).get("contact"));
        assertThat(sidingMobileReportPage.getEmail()).as("email").isEqualTo(sidingMobileReportValuesExpected.get(0).get("email"));
        assertThat(sidingMobileReportPage.getFax()).as("fax").isEqualTo(sidingMobileReportValuesExpected.get(0).get("fax"));
        assertThat(sidingMobileReportPage.getClaimNumber()).as("claimNumber").isEqualTo(sidingMobileReportValuesExpected.get(0).get("claimNumber"));
        assertThat(sidingMobileReportPage.getInsuredName()).as("insuredName").isEqualTo(sidingMobileReportValuesExpected.get(0).get("insuredName"));
        assertThat(sidingMobileReportPage.getLossLocation()).as("lossLocation").isEqualTo(sidingMobileReportValuesExpected.get(0).get("lossLocation"));
        assertThat(sidingMobileReportPage.getLossDate()).as("lossDate").isEqualTo(sidingMobileReportValuesExpected.get(0).get("lossDate"));
        assertThat(sidingMobileReportPage.getAreaDamage()).as("areaDamaged").isEqualTo(sidingMobileReportValuesExpected.get(0).get("areaDamaged"));
        assertThat(sidingMobileReportPage.getMatchingAppResult()).as("matchingAppResult").isEqualTo(sidingMobileReportValuesExpected.get(0).get("matchingAppResult"));
        assertThat(sidingMobileReportPage.isSimilarMatchAvailable()).as("matching App Result is available").isEqualTo(true);
        assertThat(sidingMobileReportPage.getMatch1()).as("Match 1").isEqualTo(sidingMobileReportValuesExpected.get(0).get("match1"));
        assertThat(sidingMobileReportPage.getProfile()).as("profile").isEqualTo(sidingMobileReportValuesExpected.get(0).get("profile"));
        assertThat(sidingMobileReportPage.getMaterial()).as("material").isEqualTo(sidingMobileReportValuesExpected.get(0).get("material"));
        assertThat(sidingMobileReportPage.getProjection()).as("projection").isEqualTo(sidingMobileReportValuesExpected.get(0).get("projection"));
        assertThat(sidingMobileReportPage.getThickness()).as("thickness").isEqualTo(sidingMobileReportValuesExpected.get(0).get("thickness"));
        assertThat(sidingMobileReportPage.getBestColorMatch()).as("best Color Match").isEqualTo(sidingMobileReportValuesExpected.get(0).get("bestColorMatch"));
        assertThat(sidingMobileReportPage.getOtherCandidateColorMatches()).as("other Candidate Color Matches").isEqualTo(sidingMobileReportValuesExpected.get(0).get("otherCandidateColorMatches"));
        assertThat(sidingMobileReportPage.getManufacturerInfo()).as("manufactureInfo").isEqualTo(sidingMobileReportValuesExpected.get(0).get("manufactureInfo"));
        assertThat(sidingMobileReportPage.getMatchingAppResultComments()).as("matching App Result Comments").isEqualTo(sidingMobileReportValuesExpected.get(0).get("matchingAppResultComments"));
        assertThat(sidingMobileReportPage.getMatchingProductComments()).as("matching Products Comments").isEqualTo(sidingMobileReportValuesExpected.get(0).get("matchingProductsComments"));
        assertThat(sidingMobileReportPage.getMatching1HelpfulComments()).as("match1 Helpful Comments").isEqualTo(sidingMobileReportValuesExpected.get(0).get("match1HelpfulComments"));
        assertThat(sidingMobileReportPage.getAdditionalComments()).as("additional Comments").isEqualTo(sidingMobileReportValuesExpected.get(0).get("additionalComments"));
        assertThat(sidingMobileReportPage.findSuppliers(Arrays.stream(sidingMobileReportValuesExpected.get(0).get("suppliers").split(",")).toList())).as("suppliers").isEqualTo(true);
        assertThat(sidingMobileReportPage.areTheImagesIncludedInReport("sidingMobile/noProductImageAvailable.png")).as("images").isEqualTo(true);

    }

}
