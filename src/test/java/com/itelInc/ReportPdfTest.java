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
        convertPDFtoHTML.convert(pdfReportName);
        driver = getDriver();
        driver.get("file://"+new File(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+pdfReportName+".html").getAbsoluteFile());
        SidingMobileReport sidingMobileReportPage= new SidingMobileReport(driver);

    }

    @Test
    public void successful_ASP_mobile_report_generation(){
        String pdfReportName = "Asphalt_Shingle_Mobile";
        ConvertPDFtoHTML convertPDFtoHTML = new ConvertPDFtoHTML();
        convertPDFtoHTML.convert(pdfReportName);
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

}
