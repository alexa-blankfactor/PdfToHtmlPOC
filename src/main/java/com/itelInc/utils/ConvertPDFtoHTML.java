package com.itelInc.utils;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.LocaleOptions;
import com.aspose.pdf.SaveFormat;
import com.itelInc.constants.FilePath;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;

public class ConvertPDFtoHTML {

    public void convert(String fileName){
        LocaleOptions.setLocale(new Locale("en", "US"));
        Document pdfDocument = new Document(FilePath.FILE_PATH_PDF_REPORT.getFilePath() +File.separator+fileName);
        HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
        htmlSaveOptions.setSplitIntoPages(true);
        htmlSaveOptions.setConvertMarkedContentToLayers(true);
        pdfDocument.save(FilePath.FILE_PATH_HTM_REPORT.getFilePath()+ File.separator+ fileName.replace("pdf","html"), htmlSaveOptions);
    }
}
