package com.itelInc.constants;

public enum FilePath {
    FILE_PATH_PDF_REPORT("src/test/resources/pdfReport/"),
    FILE_PATH_HTML_REPORT("src/test/resources/htmlReport/"),
    FILE_PATH_TEST_IMAGE("src/test/resources/testImage/"),

    FILE_PATH_DATA_TEST("src/test/resources/dataTest/"),
    FILE_PATH_SIDING_MOBILE_HTML_RESOURCES("src/test/resources/htmlReport/Siding_Mobile_files/"),
    FILE_PATH_IASP_HTML_RESOURCES("src/test/resources/htmlReport/J3I8918817__10072022131624267-Seek Now Integrated ASP_files/"),
    FILE_PATH_ASP30M_HTML_RESOURCES("src/test/resources/htmlReport/J3M8918816__10072022124534776-mobile 30-Minute ASP_files/");

    private String filePath;

    FilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }
}
