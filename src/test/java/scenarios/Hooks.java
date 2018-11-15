package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.Driver;

import static setup.PropertyFile.*;


/**
 * Code to be run before and after test suites.
 */
public class Hooks extends Driver {

    @BeforeSuite(groups = {"web"}, description = "Prepare driver to run Web test(s)")
    void setWeb() throws Exception {
        setPropertyFile(WEB);
        prepareDriver();
    }

    @BeforeSuite(groups = {"native"}, description = "Prepare driver to run Native test(s)")
    void setNative() throws Exception {
        setPropertyFile(NATIVE);
        prepareDriver();
    }

    @AfterSuite(groups = {"native", "web"}, description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
