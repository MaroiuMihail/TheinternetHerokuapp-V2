package com.mihai.theinternet.pages;

import com.mihai.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    private WebElement firstCheckbox;
    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    private WebElement secondCheckbox;

    public void checkFirst() {
        if (!firstCheckbox.isSelected()){
            click(firstCheckbox);
        }
    }

    public void uncheckFirst() {
        if (firstCheckbox.isSelected()) {
            click(firstCheckbox);
        }
    }

    public boolean isFirstChecked() {
            return firstCheckbox.isSelected();
        }

    public void checkSecond() {
        if (!secondCheckbox.isSelected()) {
            click(secondCheckbox);
        }
    }

    public void uncheckSecond () {
        if (secondCheckbox.isSelected()){
            click(secondCheckbox);
        }
    }

    public boolean isSecondChecked() {
        return secondCheckbox.isSelected();
    }

}
