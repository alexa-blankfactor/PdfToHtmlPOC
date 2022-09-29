package com.itelInc.utils;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.SaveFormat;
import com.itelInc.constants.FilePath;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;

public class ConvertPDFtoHTML {

    public void convert(String fileName){
        Locale.setDefault(new Locale(("en-us")));
        Document pdfDocument = new Document(FilePath.FILE_PATH_PDF_REPORT.getFilePath() +fileName+".pdf");
        HtmlSaveOptions options = new HtmlSaveOptions();
        options.HtmlMarkupGenerationMode=HtmlSaveOptions.HtmlMarkupGenerationModes.WriteAllHtml;
        options.setSplitIntoPages(false);
        options.SpecialFolderForAllImages = FilePath.FILE_PATH_HTML_REPORT.getFilePath()+ fileName +"_images";
        options.setDocumentType(SaveFormat.Html);
        pdfDocument.save(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+ fileName+".html", options);
        addTittleAttribute(FilePath.FILE_PATH_HTML_REPORT.getFilePath()+ fileName+".html");
    }

    private void addTittleAttribute(String fileName){
        org.jsoup.nodes.Document doc = null;
        File file = new File(fileName);
        try {
            doc = Jsoup.parse(file.getAbsoluteFile());
            PrintWriter write = new PrintWriter(file,"UTF-8");
            doc.select("body > div .stl_view").select("div > span").forEach(element ->{
                element.attr("title",element.text().trim().replace(":",""));
            });

            doc.select("div.stl_01").forEach(elements->{
                Elements spanElements =elements.select("span");
                if(spanElements.size()> 1) {
                    for (int i = 0; i < spanElements.size()-1; i++) {
                        if (Arrays.stream(spanElements.get(i).attr("class").split(" ")).findFirst().equals(Arrays.stream(spanElements.get(i+1).attr("class").split(" ")).findFirst())) {
                            spanElements.get(i+1).attr("title",spanElements.get(i).attr("title")+spanElements.get(i+1).attr("title"));
                        }
                    }
                }
            });
            write.write(doc.html());
            write.flush();
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
