package selenium.pageobjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utility.*;

public class ProjectsPageObject extends Form {
    private final ITextBox textOfVariantInFooter = AqualityServices.getElementFactory().getTextBox(By.xpath("//p/span"), "Variant In Footer");

    private final IButton nexageProjectPage = AqualityServices.getElementFactory().getButton(By.xpath("//div[@class='list-group']/a[contains(text(), 'Nexage')]"), "Nexage Project Button");
    private final IButton addProjectButton = AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(@href, 'addProject')]"), "Add Project Button");

    public ProjectsPageObject() {
        super(By.xpath("//div[@class='list-group']/a[contains(@href, 'projectId')]/parent::div"), "Projects Page");
    }

    public String getVariant() {
        String textOfVariantElement = textOfVariantInFooter.getText();

        return StringUtility.getLastElementInString(textOfVariantElement);
    }

    public void goToNexageProject() {
        nexageProjectPage.click();
    }

    public void goToProjectWithName(String name) {
        getProject(name).click();
    }

    public void clickToAddProject() {
        addProjectButton.click();
    }

    public String getIdOfProject(String name) {
        IButton ProjectPage = AqualityServices.getElementFactory().getButton(By.xpath(String.format("//div[@class='list-group']/a[contains(text(), '%s')]", name)), "Nexage Project Button");

        return StringUtility.getLastElementInString(ProjectPage.getAttribute("href"));
    }

    public ITextBox getProject(String name) {
        return AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//div[@class='list-group']/a[contains(text(), '%s')]", name)), String.format("Project With Name %s", name));
    }

    public boolean isProjectWithNameDisplayed(String name) {
        return getProject(name).state().isDisplayed();
    }

    public boolean isProjectWithNameExist(String name) {
        getProject(name).state().waitForNotDisplayed();

        return getProject(name).state().isDisplayed();
    }
}
