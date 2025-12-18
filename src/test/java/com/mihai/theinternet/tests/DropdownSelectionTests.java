package com.mihai.theinternet.tests;

import com.mihai.theinternet.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownSelectionTests extends BaseTest {


    @Test
    public void userSelectsOptionFromDropdown(){

        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.open();

        dropdownPage.selectByVisibleText("Option 2");

        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption, "Option 2",
                "Selected option is not the expected one");

    }
}

