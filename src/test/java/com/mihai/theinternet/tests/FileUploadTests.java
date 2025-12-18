package com.mihai.theinternet.tests;

import com.mihai.theinternet.pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class FileUploadTests extends BaseTest{

    @Test
    public void userUploadsFileSuccessfully(){

        FileUploadPage page = new FileUploadPage(driver);
        page.open();

        String filePath = Paths.get("src/test/resources/test.txt")
                .toAbsolutePath().toString();
        page.uploadFile(filePath);

        String uploaded = page.getUploadedFileName();
        Assert.assertEquals(uploaded, "test.txt",
        "Upload file name is not displayed correctly");
    }
}
