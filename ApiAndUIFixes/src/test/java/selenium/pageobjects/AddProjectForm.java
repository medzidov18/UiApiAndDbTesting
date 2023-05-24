package selenium.pageobjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AddProjectForm extends Form {
    private final ITextBox inputNameOfProject = AqualityServices.getElementFactory().getTextBox(By.id("projectName"), "Input Name TextBox");
    private final ITextBox successAlert = AqualityServices.getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-success')]"), "Success Alert");

    private final IButton submitButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Submit Button");

    public AddProjectForm() {
        super(By.id("addProjectForm"), "Add Project Form");
    }

    public void inputProjectNameAndSubmit(String name) {
        AqualityServices.getBrowser().tabs().switchToLastTab();
        inputNameOfProject.sendKeys(name);
        submitButton.click();
    }

    public boolean isAlertDisplayed() {
        return successAlert.state().isDisplayed() && successAlert.state().isExist();
    }

    public boolean isFormDisplayed() {
        return inputNameOfProject.state().isDisplayed();
    }
}
