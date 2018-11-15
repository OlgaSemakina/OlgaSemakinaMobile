package scenarios.nativeTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.Driver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "native", description = "Checks fields of Add Contact form")
public class SimpleNativeTests extends Driver {

    @Test(description = "This test clicks on button 'Add contact'")
    public void SimplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";

        // Click button "Add Contact"
        By buttonBy = By.id(app_package_name + "addContactButton");

        //// Button locator by xpath
        // By buttonBy = By.xpath("//android.widget.Button[@content-desc='Add Contact']");

        //// Button locator by className
        // By buttonBy = By.className("android.widget.Button");

        driver().findElement(buttonBy).click();

        // Check title "Target Account"
        buttonBy = By.xpath("//android.widget.TextView[@content-desc='Target Account']");
        assertEquals(driver().findElement(buttonBy).getText(), "Target Account");

        // Check text field for "Target Account" is displayed
        buttonBy = By.id(app_package_name + "accountSpinner");
        assertTrue(driver().findElement(buttonBy).isDisplayed());

        // Check title "Contact Name"
        buttonBy = By.xpath("//android.widget.TextView[@content-desc='Contact Name']");
        assertEquals(driver().findElement(buttonBy).getText(), "Contact Name");

        // Check text field for "Contact Name" is displayed
        buttonBy = By.id(app_package_name + "contactNameEditText");
        assertTrue(driver().findElement(buttonBy).isDisplayed());

        // Check title "Contact Phone"
        buttonBy = By.xpath("//android.widget.TextView[@content-desc='Contact Phone']");
        assertEquals(driver().findElement(buttonBy).getText(), "Contact Phone");

        // Check text field for "Contact Phone" is displayed
        buttonBy = By.id(app_package_name + "contactPhoneEditText");
        assertTrue(driver().findElement(buttonBy).isDisplayed());

        System.out.println("Simplest Appium test done");
    }
}
