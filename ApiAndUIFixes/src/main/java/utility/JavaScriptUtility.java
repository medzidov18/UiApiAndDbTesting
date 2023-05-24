package utility;

import aquality.selenium.browser.AqualityServices;

import static datareadmain.DataRead.*;

public class JavaScriptUtility {
    public static void closeWindow() {
        AqualityServices.getBrowser().executeScript(scriptsDTO.getCloseWindowJavaScriptCommand());
        AqualityServices.getBrowser().tabs().switchToLastTab();
    }
}
