package com.itelInc.utils;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.itelInc.constants.FilePath;
import java.io.File;
import java.util.Locale;

public class ConvertPDFtoHTML {

    public void convert(String fileName){
        Locale.setDefault(new Locale(("en-us")));
        Document pdfDocument = new Document(FilePath.FILE_PATH_PDF_REPORT.getFilePath() +File.separator+fileName);
        HtmlSaveOptions options = new HtmlSaveOptions();
        options.HtmlMarkupGenerationMode=HtmlSaveOptions.HtmlMarkupGenerationModes.WriteAllHtml;
        options.setSplitIntoPages(true);
        options.SpecialFolderForAllImages= FilePath.FILE_PATH_HTM_REPORT.getFilePath()+ File.separator+ fileName.replace("pdf","");
        pdfDocument.save(FilePath.FILE_PATH_HTM_REPORT.getFilePath()+ File.separator+ fileName.replace("pdf","html"), options);
    }
}
