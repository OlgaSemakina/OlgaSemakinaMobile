package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;


/**
 * Initialize a driver with test properties
 */
public class Driver extends TestProperties {

    private static AppiumDriver driver;
    private static WebDriverWait wait;
    protected DesiredCapabilities capabilities;

    // Properties to be read
    protected static String SUT; // site under testing
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String DEVICE_NAME;
    protected static String UDID;
    protected static String APP_PACKAGE;
    protected static String APP_ACTIVITY;


    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        String t_sut = getProperty("sut");
        SUT = t_sut == null ? null : "https://" + t_sut;
        TEST_PLATFORM = getProperty("platform");
        DRIVER = getProperty("driver");
        DEVICE_NAME = getProperty("deviceName");
        UDID = getProperty("udid");
        APP_PACKAGE = getProperty("appPackage");
        APP_ACTIVITY = getProperty("appActivity");

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                browserName = "Chrome";
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);

                break;
            case "iOS":
                browserName = "Safari";
                capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, web
        if (APP_PACKAGE != null && APP_ACTIVITY != null && SUT == null) {
            // Native
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        } else if (SUT != null && APP_PACKAGE == null && APP_ACTIVITY == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // Init driver for local Appium server with capabilities have been set
        if (driver == null) {
            driver = new AppiumDriver(new URL(DRIVER), capabilities);
        }

        // Set an object to handle timeouts
        if (wait == null) {
            wait = new WebDriverWait(driver(), 10);
        }
    }

    protected AppiumDriver driver() throws Exception {
        if (driver == null) prepareDriver();
        return driver;
    }

    protected WebDriverWait driverWait() throws Exception {
        return wait;
    }
}
