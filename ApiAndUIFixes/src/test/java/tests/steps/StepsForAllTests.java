package tests.steps;

import api.requests.TokenRequests;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import selenium.pageobjects.*;
import utility.CoockiesUtility;

import static dataread.DataRead.configDataApiDTO;

public class StepsForAllTests {
    private final LoginForm loginForm = new LoginForm();
    private final ProjectsPageObject projectsPageObject = new ProjectsPageObject();

    public String getTokenByVariant(String variant) {
        return TokenRequests.getToken(variant);
    }

    public String passAuthSetTokenToCookieAndReturnTheVariant(String token) {
        loginForm.authentificate();
        CoockiesUtility.setTokenToCookie(configDataApiDTO.getTokenForCoockieParam(), token);
        AqualityServices.getBrowser().refresh();

        return projectsPageObject.getVariant();
    }

    public void assertTokenIsGenerated(String token) {
        Assert.assertFalse(token.isEmpty(), "Token is not generated");
    }

    public void assertThatVariantIsCorrectAndProjectPageDisplayed(String variantInSite, String expectedVariant) {
        Assert.assertTrue(projectsPageObject.state().isDisplayed(), "project page is not displayed");
        Assert.assertEquals(variantInSite, expectedVariant, "variant is not 2");
    }
}
