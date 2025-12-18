package com.mihai.theinternet.tests;

import com.mihai.theinternet.pages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertBehaviourTests extends BaseTest{

    @Test
    public void dismissJsConfirmAlert(){

        AlertsPage alertspage = new AlertsPage(driver);
        alertspage.open();

        alertspage.triggerJsConfirm();
        alertspage.dismissAlert();

        Assert.assertEquals(alertspage.getResultText(),"You clicked: Cancel");

    }
}

