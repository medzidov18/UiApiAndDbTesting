package tests.steps;

import aquality.selenium.browser.AqualityServices;
import database.commands.*;
import org.testng.Assert;
import selenium.pageobjects.*;

public class StepsOfVariant4 extends StepsForAllTests {
    private final ProjectsPageObject projectsPageObject = new ProjectsPageObject();
    private final AddedProjectPageObject addedProjectPageObject = new AddedProjectPageObject();

    public void goToMyProject(String nameOfProject) {
        projectsPageObject.goToProjectWithName(nameOfProject);
    }

    public void deleteTest(String idOfTest){
        DbCommands.deleteTestById(idOfTest);
    }

    public void deleteProject(String idOfProject){
        addedProjectPageObject.goHome();
        DbCommands.deleteProjectById(idOfProject);
    }

    public void assertThatProjectPageDislayed(String nameOfProject) {
        Assert.assertTrue(addedProjectPageObject.isProjectDisplayed(nameOfProject), "Project does not displayed");
    }

    public void assertThatTestIsDeleted(String nameOfMethod) {
        Assert.assertFalse(addedProjectPageObject.doesTestNotExist(nameOfMethod), "Test in this project is exist");
    }

    public void assertThatProjectIsDeleted(String nameOfProject) {
        AqualityServices.getBrowser().refresh();
        Assert.assertFalse(projectsPageObject.isProjectWithNameExist(nameOfProject), "Project is exist in this page");
    }
}
