package com.mihai.theinternet.pages;

import com.mihai.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @FindBy(id = "file-upload")
    private WebElement fileUpload;
    @FindBy(id = "file-submit")
    private WebElement fileSubmit;
    @FindBy(id = "uploaded-files")
    private WebElement fileUploaded;


    public void uploadFile(String filepath) {
        fileUpload.sendKeys(filepath);
        click(fileSubmit);
    }

    public String getUploadedFileName(){
        return fileUploaded.getText();

    }



}
