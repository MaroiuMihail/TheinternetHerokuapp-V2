package com.mihai.theinternet.tests;

import com.mihai.theinternet.pages.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxStateTests extends BaseTest {

    @Test
    public void userCanChangeCheckboxSelectionState() {

        CheckboxesPage checkboxes = new CheckboxesPage(driver);
        checkboxes.open();

        checkboxes.uncheckSecond();
        checkboxes.checkFirst();

        Assert.assertTrue(checkboxes.isFirstChecked(),
                "First checkbox should be checked");

        Assert.assertFalse(checkboxes.isSecondChecked(),
                "Second checkbox should be unchecked");
    }

}