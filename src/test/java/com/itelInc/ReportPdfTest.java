package com.itelInc;

import com.itelInc.utils.ConvertPDFtoHTML;
import org.testng.annotations.Test;

public class ReportPdfTest {

    @Test
    public void testReportPdf(){
        ConvertPDFtoHTML convertPDFtoHTML = new ConvertPDFtoHTML();
        convertPDFtoHTML.convert("Pad.pdf");
    }
}
