package selenium.core;

import aquality.selenium.browser.*;
import database.connection.Database;
import org.testng.annotations.*;

import static dataread.DataRead.*;

public abstract class BaseTest {
    private final Browser browser = AqualityServices.getBrowser();

    @BeforeTest
    public void initializeDbConnection() {
        Database.initializeConnection();
    }

    @BeforeMethod
    public void initialize() {
        browser.maximize();
        browser.goTo(configDataApiDTO.getBaseUri() + configDataUiDTO.getWebAppPath());
        browser.waitForPageToLoad();
    }

    @AfterClass
    public void tearDown() {
            browser.quit();
    }

    @AfterTest
    public void closeDbConnection() {
        Database.closeConnection();
    }
}
