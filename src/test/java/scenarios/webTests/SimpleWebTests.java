package scenarios.webTests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import setup.Driver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "web", description = "Opens site and checks it opens correctly")
public class SimpleWebTests extends Driver {

    private String title = "Internet Assigned Numbers Authority";

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);

        // Check url is correct
        assertEquals(SUT + "/", driver().getCurrentUrl());

        // Check title is correct
        assertEquals(driver().getTitle() ,title);

        // Check http status code is 200
//        assertTrue(new HttpResponseCode().httpResponseCodeViaGet(SUT) == 200);
        assertTrue(RestAssured.get(SUT).statusCode() == 200);

        System.out.println("Site opening done");
    }
}
