package com.mihai.theinternet.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeMethod
    public void setupBrowser() {
        ChromeOptions options = new ChromeOptions();

        boolean isCi = "true".equalsIgnoreCase(System.getenv("CI"));
        if (isCi) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

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
