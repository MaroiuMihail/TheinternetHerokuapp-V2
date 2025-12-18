package com.mihai.theinternet.pages;

import com.mihai.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public void selectByVisibleText(String text){
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public String getSelectedOption(){
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }


}
