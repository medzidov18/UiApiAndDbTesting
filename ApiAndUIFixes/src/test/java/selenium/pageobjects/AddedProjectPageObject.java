package selenium.pageobjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AddedProjectPageObject extends Form {
    private final ILink homeLink = AqualityServices.getElementFactory().getLink(By.xpath("//ol[@class='breadcrumb']/li/a[contains(text(), 'Home')]"), "Home Link");

    public AddedProjectPageObject() {
        super(By.id("allTests"), "Added Project Page object");
    }

    public boolean doesTestExist(String testMethodName) {
        ITextBox rowOfTestInTable = AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//tr[td//text()[contains(., '%s')]]", testMethodName)), "Test Of My Project");
        AqualityServices.getConditionalWait().waitFor(() -> rowOfTestInTable.state().isDisplayed());

        return rowOfTestInTable.state().isDisplayed();
    }

    public boolean doesTestNotExist(String testMethodName) {
        ITextBox rowOfTestInTable = AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//tr[td//text()[contains(., '%s')]]", testMethodName)), "Test Of My Project");
        rowOfTestInTable.state().waitForNotDisplayed();

        return rowOfTestInTable.state().isDisplayed();
    }

    public boolean isProjectDisplayed(String projectName) {
        ITextBox nameOfProjInHeader = AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//ol[@class='breadcrumb']/li[contains(text(), '%s')]", projectName)), String.format("Project %s", projectName));
        nameOfProjInHeader.state().waitForDisplayed();

        return nameOfProjInHeader.state().isDisplayed();
    }

    public void goHome() {
        homeLink.click();
    }
}
