package com.itelInc.utils;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.SaveFormat;
import com.itelInc.constants.FilePath;

import java.io.File;

public class ConvertPDFtoHTML {

    public void convert(String fileName){
        Document pdfDocument = new Document(FilePath.FILE_PATH_PDF_REPORT.getFilePath() +fileName);
        HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
        htmlSaveOptions.HtmlMarkupGenerationMode=HtmlSaveOptions.HtmlMarkupGenerationModes.WriteOnlyBodyContent;
        htmlSaveOptions.setSplitIntoPages(true);
        htmlSaveOptions.SpecialFolderForAllImages = FilePath.FILE_PATH_HTM_REPORT.getFilePath();
        pdfDocument.save(FilePath.FILE_PATH_HTM_REPORT.getFilePath()+ File.separator+pdfDocument.getFileName(), SaveFormat.Html);
    }
}
