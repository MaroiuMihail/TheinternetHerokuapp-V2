package com.mihai.theinternet.pages;

import com.mihai.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement jsAlertButton;
    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement jsConfirmButton;
    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement jsPromptButton;
    @FindBy(id = "result")
    private WebElement resultText;

    public void triggerJsAlert(){
    click(jsAlertButton);
    }

    public void triggerJsConfirm(){
        click(jsConfirmButton);
    }

    public void triggerJsPrompt(){
        click(jsPromptButton);
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void typeInAlert(String text){
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public String getResultText(){
        return resultText.getText();
    }
}
