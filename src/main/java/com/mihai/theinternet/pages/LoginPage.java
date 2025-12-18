package com.mihai.theinternet.pages;

import com.mihai.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }


    @FindBy(id = "username")
    private WebElement usernameElement;
    @FindBy(id = "password")
    private WebElement passwordElement;
    @FindBy(css = "button[type='submit']")
    private WebElement submitElement;
    @FindBy(id = "flash")
    private WebElement flashAlert;


    public void setUsernameElement(String username){
        type(usernameElement, username);
    }

    public void setPasswordElement(String password){
        type(passwordElement, password);
    }

    public void clickLoginButton(){
        click(submitElement);
    }

    public String getFlashAlert(){
        return getText(flashAlert);
    }

    public void login(String username, String password){
    setUsernameElement(username);
    setPasswordElement(password);
    clickLoginButton();
    }

}
