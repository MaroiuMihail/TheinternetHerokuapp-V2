package com.mihai.theinternet.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeMethod
    public void setupBrowser() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(BASE_URL);
    }

    @AfterMethod
    public void teardownBrowser() {
    if (driver != null) {
        driver.quit();
        }
    }

}
