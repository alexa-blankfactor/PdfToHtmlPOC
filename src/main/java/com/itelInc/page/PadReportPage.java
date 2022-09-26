package com.itelInc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PadReportPage {



    public PadReportPage(WebDriver driver ) {
        PageFactory.initElements(driver,this);
    }


}
