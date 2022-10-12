package com.itelInc;

import com.itelInc.constants.FilePath;
import com.itelInc.hooks.Driver;
import com.itelInc.page.AsphaltShingle30MReport;
import com.itelInc.page.IPAsphaltShingleReport;
import com.itelInc.page.MAsphaltShingleReport;
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
        MAsphaltShingleReport MAsphaltShingleReport = new MAsphaltShingleReport(driver);
        List<Map<String,String>> asphaltShingleMobileReportValuesExpected=CSVContent.getValue(FilePath.FILE_PATH_DATA_TEST.getFilePath() + pdfReportName+ "_data_expected.csv");
        assertThat(asphaltShingleMobileReportValuesExpected.get(0)).satisfies(valueExpected->{
            assertThat(MAsphaltShingleReport.getCustomer()).as("customer").isEqualTo(valueExpected.get("customer"));
            assertThat(MAsphaltShingleReport.getCustomerId()).as("customerId").isEqualTo(valueExpected.get("customerId"));
            assertThat(MAsphaltShingleReport.getAdjuster()).as("adjuster").isEqualTo(valueExpected.get("adjuster"));
            assertThat(MAsphaltShingleReport.getControlNumber()).as("controlNumber").isEqualTo(valueExpected.get("controlNumber"));
            assertThat(MAsphaltShingleReport.getDateReceived()).as("dateReceived").isEqualTo(valueExpected.get("dateReceived"));
            assertThat(MAsphaltShingleReport.getDateInvoiced()).as("dateInvoiced").isEqualTo(valueExpected.get("dateInvoiced"));
            assertThat(MAsphaltShingleReport.getAdditional()).as("additional").isEqualTo(valueExpected.get("additional"));
            assertThat(MAsphaltShingleReport.getVendorJobNumber()).as("vendorJobNumber").isEqualTo(valueExpected.get("vendorJobNumber"));
            assertThat(MAsphaltShingleReport.getContact()).as("contact").isEqualTo(valueExpected.get("contact"));
            assertThat(MAsphaltShingleReport.getCustomerInformationComments()).as("Customer information comments").isEqualTo(valueExpected.get("customerInformationComments"));
            assertThat(MAsphaltShingleReport.getClaimNumber()).as("Claim number").isEqualTo(valueExpected.get("claimNumber"));
            assertThat(MAsphaltShingleReport.getInsuredName()).as("Insured Name").isEqualTo(valueExpected.get("insuredName"));
            assertThat(MAsphaltShingleReport.getCityStateZip()).as("City,State,Zip").isEqualTo(valueExpected.get("cityStateZip"));
            assertThat(MAsphaltShingleReport.getLossDate()).as("Loss Date").isEqualTo(valueExpected.get("lossDate"));
            assertThat(MAsphaltShingleReport.getAreaDamaged()).as("Area Damaged").isEqualTo(valueExpected.get("areaDamaged"));
            assertThat(MAsphaltShingleReport.getInsuredInformationComments()).as("Insured Information Comments").isEqualTo(valueExpected.get("insuredInformationComments"));
            assertThat(MAsphaltShingleReport.getItelBenchmarkItems().stream().map(String::trim).collect(Collectors.joining(" "))).as("Itel benchmark items").isEqualTo(valueExpected.get("itelBenchmarkItems"));
            assertThat(MAsphaltShingleReport.getPricePerSquare()).as("Price Per Square").isEqualTo(valueExpected.get("pricePerSquare"));
            assertThat(MAsphaltShingleReport.getBenchMarkComments()).as("Itel Benchmark comments").contains(valueExpected.get("benchmarkComments"));
            assertThat(MAsphaltShingleReport.getClosestAPSType()).as("Closesr available product specifications type").isEqualTo(valueExpected.get("closestAPSType"));
            assertThat(MAsphaltShingleReport.getClosestAPSConstruction()).as("Closesr available product specifications construction").isEqualTo(valueExpected.get("closestAPSConstruction"));
            assertThat(MAsphaltShingleReport.getClosestAPSAlgaeResistant()).as("Closesr available product specifications Algae resistant").isEqualTo(valueExpected.get("closestAPSAlgaeResistant"));
            assertThat(MAsphaltShingleReport.getClosestAPSSolarReflective()).as("Closesr available product specifications Solar reflective").isEqualTo(valueExpected.get("closestAPSSolarReflective"));
            assertThat(MAsphaltShingleReport.getClosestAPSImpactResistant()).as("Closesr available product specifications Impact Resistant").isEqualTo(valueExpected.get("closestAPSImpactResistant"));
            assertThat(MAsphaltShingleReport.getClosestAPSWarranty()).as("Closesr available product specifications Warranty").isEqualTo(valueExpected.get("closestAPSWarranty"));
            assertThat(MAsphaltShingleReport.getClosestAPSComments()).as("Closesr available product specifications comments").isEqualTo(valueExpected.get("closestAPSComments"));
            assertThat(MAsphaltShingleReport.getAdditionalComments()).as("additional comments").isEqualTo(valueExpected.get("additionalComments"));

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

    @Test
    public void successful_integration_partner_ASP_report_generation(){
        String pdfReportName = "J3I8918817__10072022131624267-Seek Now Integrated ASP";
        ConvertPDFtoHTML convertPDFtoHTML = new ConvertPDFtoHTML();
        convertPDFtoHTML.convert(pdfReportName,false);
        driver = getDriver();
        driver.get("file://"+new File(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+pdfReportName+".html").getAbsoluteFile());
        IPAsphaltShingleReport IPAsphaltShingleReport = new IPAsphaltShingleReport(driver);
        List<Map<String,String>> asphaltShingleIReportValuesExpected=CSVContent.getValue(FilePath.FILE_PATH_DATA_TEST.getFilePath() + pdfReportName+ "_data_expected.csv");
        assertThat(asphaltShingleIReportValuesExpected.get(0)).satisfies(valueExpected->{
            assertThat(IPAsphaltShingleReport.getCustomer()).as("customer").isEqualTo(valueExpected.get("customer"));
            assertThat(IPAsphaltShingleReport.getCustomerId()).as("customerId").isEqualTo(valueExpected.get("customerId"));
            assertThat(IPAsphaltShingleReport.getAdjuster()).as("adjuster").isEqualTo(valueExpected.get("adjuster"));
            assertThat(IPAsphaltShingleReport.getControlNumber()).as("controlNumber").isEqualTo(valueExpected.get("controlNumber"));
            assertThat(IPAsphaltShingleReport.getDateReceived()).as("dateReceived").isEqualTo(valueExpected.get("dateReceived"));
            assertThat(IPAsphaltShingleReport.getDateInvoiced()).as("dateInvoiced").isEqualTo(valueExpected.get("dateInvoiced"));
            assertThat(IPAsphaltShingleReport.getAdditional()).as("additional").isEqualTo(valueExpected.get("additional"));
            assertThat(IPAsphaltShingleReport.getVendorJobNumber()).as("vendorJobNumber").isEqualTo(valueExpected.get("vendorJobNumber"));
            assertThat(IPAsphaltShingleReport.getContact()).as("contact").isEqualTo(valueExpected.get("contact"));
            assertThat(IPAsphaltShingleReport.getCustomerInformationComments()).as("Customer information comments").isEqualTo(valueExpected.get("customerInformationComments"));
            assertThat(IPAsphaltShingleReport.getClaimNumber()).as("Claim number").isEqualTo(valueExpected.get("claimNumber"));
            assertThat(IPAsphaltShingleReport.getInsuredName()).as("Insured Name").isEqualTo(valueExpected.get("insuredName"));
            assertThat(IPAsphaltShingleReport.getCityStateZip()).as("City,State,Zip").isEqualTo(valueExpected.get("cityStateZip"));
            assertThat(IPAsphaltShingleReport.getLossDate()).as("Loss Date").isEqualTo(valueExpected.get("lossDate"));
            assertThat(IPAsphaltShingleReport.getAreaDamaged()).as("Area Damaged").isEqualTo(valueExpected.get("areaDamaged"));
            assertThat(IPAsphaltShingleReport.getInsuredInformationComments()).as("Insured Information Comments").isEqualTo(valueExpected.get("insuredInformationComments"));
            assertThat(IPAsphaltShingleReport.getItelBenchmarkItems().stream().map(String::trim).collect(Collectors.joining(" "))).as("Itel benchmark items").isEqualTo(valueExpected.get("itelBenchmarkItems"));
            assertThat(IPAsphaltShingleReport.getPricePerSquare()).as("Price Per Square").isEqualTo(valueExpected.get("pricePerSquare"));
            assertThat(IPAsphaltShingleReport.getBenchMarkComments()).as("Itel Benchmark comments").contains(valueExpected.get("benchmarkComments"));
            assertThat(IPAsphaltShingleReport.getClosestAPSType()).as("Closesr available product specifications type").isEqualTo(valueExpected.get("closestAPSType"));
            assertThat(IPAsphaltShingleReport.getClosestAPSConstruction()).as("Closesr available product specifications construction").isEqualTo(valueExpected.get("closestAPSConstruction"));
            assertThat(IPAsphaltShingleReport.getClosestAPSAlgaeResistant()).as("Closesr available product specifications Algae resistant").isEqualTo(valueExpected.get("closestAPSAlgaeResistant"));
            assertThat(IPAsphaltShingleReport.getClosestAPSSolarReflective()).as("Closesr available product specifications Solar reflective").isEqualTo(valueExpected.get("closestAPSSolarReflective"));
            assertThat(IPAsphaltShingleReport.getClosestAPSImpactResistant()).as("Closesr available product specifications Impact Resistant").isEqualTo(valueExpected.get("closestAPSImpactResistant"));
            assertThat(IPAsphaltShingleReport.getClosestAPSWarranty()).as("Closesr available product specifications Warranty").isEqualTo(valueExpected.get("closestAPSWarranty"));
            assertThat(IPAsphaltShingleReport.getClosestAPSComments()).as("Closesr available product specifications comments").isEqualTo(valueExpected.get("closestAPSComments"));
            assertThat(IPAsphaltShingleReport.getAdditionalComments()).as("additional comments").isEqualTo(valueExpected.get("additionalComments"));
            assertThat(IPAsphaltShingleReport.areTheImagesIncludedInReport("IASP/completeSlope.png")).as("complete Slope image").isEqualTo(true);
            assertThat(IPAsphaltShingleReport.areTheImagesIncludedInReport("IASP/manufacturerTape.png")).as("manufacturer Tape image").isEqualTo(true);
            assertThat(IPAsphaltShingleReport.areTheImagesIncludedInReport("IASP/shingleWidth.png")).as("shingle Width image").isEqualTo(true);
            assertThat(IPAsphaltShingleReport.areTheImagesIncludedInReport("IASP/thickness.png")).as("thickness image").isEqualTo(true);
        });
    }

    @Test
    public void successful_30_minutes_ASP_mobile_report_generation(){
        String pdfReportName = "J3M8918816__10072022124534776-mobile 30-Minute ASP";
        ConvertPDFtoHTML convertPDFtoHTML = new ConvertPDFtoHTML();
        convertPDFtoHTML.convert(pdfReportName,false);
        driver = getDriver();
        driver.get("file://"+new File(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+pdfReportName+".html").getAbsoluteFile());
        AsphaltShingle30MReport asphaltShingle30MReport = new AsphaltShingle30MReport(driver);
        List<Map<String,String>> asphaltShingle30MReportValuesExpected=CSVContent.getValue(FilePath.FILE_PATH_DATA_TEST.getFilePath() + pdfReportName+ "_data_expected.csv");
        assertThat(asphaltShingle30MReportValuesExpected.get(0)).satisfies(valueExpected->{
            assertThat(asphaltShingle30MReport.getCustomer()).as("customer").isEqualTo(valueExpected.get("customer"));
            assertThat(asphaltShingle30MReport.getCustomerId()).as("customerId").isEqualTo(valueExpected.get("customerId"));
            assertThat(asphaltShingle30MReport.getAdjuster()).as("adjuster").isEqualTo(valueExpected.get("adjuster"));
            assertThat(asphaltShingle30MReport.getControlNumber()).as("controlNumber").isEqualTo(valueExpected.get("controlNumber"));
            assertThat(asphaltShingle30MReport.getDateReceived()).as("dateReceived").isEqualTo(valueExpected.get("dateReceived"));
            assertThat(asphaltShingle30MReport.getDateInvoiced()).as("dateInvoiced").isEqualTo(valueExpected.get("dateInvoiced"));
            assertThat(asphaltShingle30MReport.getAdditional()).as("additional").isEqualTo(valueExpected.get("additional"));
            assertThat(asphaltShingle30MReport.getVendorJobNumber()).as("vendorJobNumber").isEqualTo(valueExpected.get("vendorJobNumber"));
            assertThat(asphaltShingle30MReport.getContact()).as("contact").isEqualTo(valueExpected.get("contact"));
            assertThat(asphaltShingle30MReport.getCustomerInformationComments()).as("Customer information comments").isEqualTo(valueExpected.get("customerInformationComments"));
            assertThat(asphaltShingle30MReport.getClaimNumber()).as("Claim number").isEqualTo(valueExpected.get("claimNumber"));
            assertThat(asphaltShingle30MReport.getInsuredName()).as("Insured Name").isEqualTo(valueExpected.get("insuredName"));
            assertThat(asphaltShingle30MReport.getCityStateZip()).as("City,State,Zip").isEqualTo(valueExpected.get("cityStateZip"));
            assertThat(asphaltShingle30MReport.getLossDate()).as("Loss Date").isEqualTo(valueExpected.get("lossDate"));
            assertThat(asphaltShingle30MReport.getAreaDamaged()).as("Area Damaged").isEqualTo(valueExpected.get("areaDamaged"));
            assertThat(asphaltShingle30MReport.getInsuredInformationComments()).as("Insured Information Comments").isEqualTo(valueExpected.get("insuredInformationComments"));
            assertThat(asphaltShingle30MReport.getItelBenchmarkItems().stream().map(String::trim).collect(Collectors.joining(" "))).as("Itel benchmark items").isEqualTo(valueExpected.get("itelBenchmarkItems"));
            assertThat(asphaltShingle30MReport.getPricePerSquare()).as("Price Per Square").isEqualTo(valueExpected.get("pricePerSquare"));
            assertThat(asphaltShingle30MReport.getBenchMarkComments()).as("Itel Benchmark comments").contains(valueExpected.get("benchmarkComments"));
            assertThat(asphaltShingle30MReport.getClosestAPSType()).as("Closesr available product specifications type").isEqualTo(valueExpected.get("closestAPSType"));
            assertThat(asphaltShingle30MReport.getClosestAPSConstruction()).as("Closesr available product specifications construction").isEqualTo(valueExpected.get("closestAPSConstruction"));
            assertThat(asphaltShingle30MReport.getClosestAPSAlgaeResistant()).as("Closesr available product specifications Algae resistant").isEqualTo(valueExpected.get("closestAPSAlgaeResistant"));
            assertThat(asphaltShingle30MReport.getClosestAPSSolarReflective()).as("Closesr available product specifications Solar reflective").isEqualTo(valueExpected.get("closestAPSSolarReflective"));
            assertThat(asphaltShingle30MReport.getClosestAPSImpactResistant()).as("Closesr available product specifications Impact Resistant").isEqualTo(valueExpected.get("closestAPSImpactResistant"));
            assertThat(asphaltShingle30MReport.getClosestAPSWarranty()).as("Closesr available product specifications Warranty").isEqualTo(valueExpected.get("closestAPSWarranty"));
            assertThat(asphaltShingle30MReport.getClosestAPSComments()).as("Closesr available product specifications comments").isEqualTo(valueExpected.get("closestAPSComments"));
            assertThat(asphaltShingle30MReport.getAdditionalComments()).as("additional comments").isEqualTo(valueExpected.get("additionalComments"));
            assertThat(asphaltShingle30MReport.areTheImagesIncludedInReport("ASP30M/completeSlope.png")).as("complete Slope image").isEqualTo(true);
            assertThat(asphaltShingle30MReport.areTheImagesIncludedInReport("ASP30M/manufacturerTape.png")).as("manufacturer Tape image").isEqualTo(true);
            assertThat(asphaltShingle30MReport.areTheImagesIncludedInReport("ASP30M/shingleWidth.png")).as("shingle Width image").isEqualTo(true);
            assertThat(asphaltShingle30MReport.areTheImagesIncludedInReport("ASP30M/thickness.png")).as("thickness image").isEqualTo(true);

        });
    }

}
