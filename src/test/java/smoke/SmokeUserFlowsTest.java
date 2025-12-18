package smoke;

import com.mihai.theinternet.pages.*;
import com.mihai.theinternet.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class SmokeUserFlowsTest extends BaseTest {

    @Test
    public void userCanLoginSuccessfully(){

    LoginPage login = new LoginPage(driver);
    login.open();
    login.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(login.getFlashAlert().contains("You logged into a secure area!"));
    }

    @Test
    public void userCanChangeCheckboxState(){

        CheckboxesPage checkboxes = new CheckboxesPage(driver);
        checkboxes.open();

        checkboxes.uncheckSecond();
        checkboxes.checkFirst();

        Assert.assertTrue(checkboxes.isFirstChecked());
    }

    @Test
    public void userCanSelectDropdownOption(){

        DropdownPage dropdown = new DropdownPage(driver);
        dropdown.open();
        dropdown.selectByVisibleText("Option 2");

        Assert.assertEquals(dropdown.getSelectedOption(), "Option 2");
    }

    @Test
    public void userCanUploadFile(){
        FileUploadPage fileUpload = new FileUploadPage(driver);
        fileUpload.open();

        String path = Paths.get("src/test/resources/test.txt")
                .toAbsolutePath().toString();

        fileUpload.uploadFile(path);

        Assert.assertEquals(fileUpload.getUploadedFileName(), "test.txt");
    }


    @Test
    public void userCanDismissJsConfirm(){

        AlertsPage alerts = new AlertsPage(driver);
        alerts.open();

        alerts.triggerJsConfirm();
        alerts.dismissAlert();

       Assert.assertEquals(alerts.getResultText(), "You clicked: Cancel");
    }
}
