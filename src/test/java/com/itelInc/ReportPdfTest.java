package com.itelInc;

import com.itelInc.constants.FilePath;
import com.itelInc.hooks.Driver;
import com.itelInc.page.AsphaltShingleMobileReport;
import com.itelInc.page.SidingMobileReport;
import com.itelInc.utils.ConvertPDFtoHTML;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ReportPdfTest  extends Driver{

    private WebDriver driver;
    @Test
    public void testReportPdf(){
        String pdfReportName = "Asphalt_Shingle_Mobile";
        ConvertPDFtoHTML convertPDFtoHTML = new ConvertPDFtoHTML();
        convertPDFtoHTML.convert(pdfReportName);
        driver = getDriver();
        driver.get("file://"+new File(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+pdfReportName+".html").getAbsoluteFile());
        //SidingMobileReport sidingMobileReportPage= new SidingMobileReport(driver);
        AsphaltShingleMobileReport asphaltShingleMobileReport= new AsphaltShingleMobileReport(driver);
        System.out.println(asphaltShingleMobileReport.getAdditionalComments());

    }

}
