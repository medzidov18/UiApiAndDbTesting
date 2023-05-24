package utility;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.Cookie;

public class CoockiesUtility {
    public static void setTokenToCookie(String nameOfParam, String token) {
        Cookie cookie = new Cookie(nameOfParam, token);
        AqualityServices.getBrowser().getDriver().manage().addCookie(cookie);
    }
}
