package com.mihai.theinternet.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final int DEFAULT_WAIT_SECONDS = 10;

    public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForVisibility(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element){
    waitForClickable(element).click();
    }

    protected void type(WebElement element, String text){
    WebElement el = waitForVisibility(element);
    el.clear();
    el.sendKeys(text);
    }

    protected void clear(WebElement element){
        WebElement el = waitForVisibility(element);
        el.clear();
    }

    protected void clickJS(WebElement element){
        WebElement el = waitForVisibility(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", el);
    }

    protected String getText(WebElement element){
    return waitForVisibility(element).getText();
    }
}
