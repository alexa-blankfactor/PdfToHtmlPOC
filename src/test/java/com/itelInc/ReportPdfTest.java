package com.itelInc;

import com.itelInc.constants.FilePath;
import com.itelInc.hooks.Driver;
import com.itelInc.page.SidingMobileReport;
import com.itelInc.utils.ConvertPDFtoHTML;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportPdfTest  extends Driver{

    private WebDriver driver;
    @Test
    public void testReportPdf(){
        String pdfReportName = "SidingMobile";
        ConvertPDFtoHTML convertPDFtoHTML = new ConvertPDFtoHTML();
        convertPDFtoHTML.convert(pdfReportName);
        driver = getDriver();
        driver.get("file://"+new File(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+pdfReportName+".html").getAbsoluteFile());
        SidingMobileReport sidingMobileReportPage= new SidingMobileReport(driver);
        System.out.println(sidingMobileReportPage.isSimilarMatchAvailable());
    }

}
