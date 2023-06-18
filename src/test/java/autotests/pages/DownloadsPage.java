package autotests.pages;

import com.codeborne.pdftest.PDF;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class DownloadsPage {

    private final String TEXT_FILE = "Базовые принципы ценообразования";
    ClassLoader cl = DownloadsPage.class.getClassLoader();


    public DownloadsPage openDownloadsPage() {
        open("/ru/downloads/");
        return this;
    }

    public DownloadsPage verifyDownloadedFileContainsText() throws Exception {
        File downloadedPdf = $("a[href='/price-policy-ru.pdf']").download();
        PDF content = new PDF(downloadedPdf);
        assertThat(content.text).contains(TEXT_FILE);
        return this;
    }
}
