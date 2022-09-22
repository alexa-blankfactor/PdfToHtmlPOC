package com.itelInc.constants;

public enum FilePath {
    FILE_PATH_PDF_REPORT("src/test/resources/pdfReport"),
    FILE_PATH_HTM_REPORT("src/test/resources/htmlReport");

    private String filePath;

    FilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }
}
