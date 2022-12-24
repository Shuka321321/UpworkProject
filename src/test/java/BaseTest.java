import aquality.selenium.browser.AqualityServices;
import models.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DataReader;

import static utils.DataReader.writeToModel;


public abstract class BaseTest {
    private final Config config = writeToModel(DataReader.TestdataContentConfig, Config.class);

    @BeforeMethod
    protected void beforeMethod() {
        AqualityServices.getBrowser().goTo(config.getBaseUrl());
        AqualityServices.getBrowser().maximize();
        AqualityServices.getBrowser().waitForPageToLoad();
    }

    @AfterMethod
    public void afterTest() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }

}
