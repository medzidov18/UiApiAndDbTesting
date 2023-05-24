package selenium.pageobjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import java.net.URL;

import static dataread.DataRead.*;

public class LoginForm extends Form {
    public LoginForm() {
        super(By.xpath("//body"), "Login Page With Alert");
    }

    @SneakyThrows
    public void authentificate() {
        URL myUrl = new URL(configDataApiDTO.getBaseUri() + configDataUiDTO.getWebAppPath());
        String protocol = myUrl.getProtocol();
        String loginAndPassword = String.format("%s:%s", configDataUiDTO.getUserLogin(), configDataUiDTO.getUserPassword());
        String domain = myUrl.getHost();
        String webApp = StringUtils.substringAfter(myUrl.toString(), domain);
        AqualityServices.getBrowser().goTo(String.format("%s://%s@%s%s", protocol, loginAndPassword, domain, webApp));
    }
}
