package scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidNative();
//        prepareAndroidWeb();
    }


    @Test(description = "This test clicks on button 'Add contact'")
    public void SimplestTest() {
        String app_package_name = "com.example.android.contactmanager:id/";

        // Button locator by id
//        By buttonBy = By.id(app_package_name + "addContactButton");

        // Button locator by xpath
//        By buttonBy = By.xpath("//android.widget.Button[@content-desc='Add Contact']");

        //Button locator by className
        By buttonBy = By.className("android.widget.Button");

        driver.findElement(buttonBy).click();
        System.out.println("Simplest Appium test done");
    }


    //    @Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get("http://iana.org");
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
