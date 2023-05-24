package tests.steps;

import api.models.TestDTO;
import api.requests.*;
import aquality.selenium.browser.AqualityServices;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import selenium.pageobjects.*;
import utilities.StringUtility;
import utility.*;
import java.util.*;
import java.util.stream.Collectors;

import static dataread.DataRead.*;

public class StepsOfVariant2 extends StepsForAllTests {
    private final ProjectsPageObject projectsPageObject = new ProjectsPageObject();
    private final NexagePageObject nexagePageObject = new NexagePageObject();
    private final AddProjectForm addProjectForm = new AddProjectForm();
    private final AddedProjectPageObject addedProjectPageObject = new AddedProjectPageObject();

    public String getNexageProjectId() {
        return projectsPageObject.getIdOfProject(testDataApiDTO.getNexagePageName());
    }

    public void goToNexageProject() {
        projectsPageObject.goToNexageProject();
    }

    private List<Date> getDatesFromApi(String idOfProject) {
        List<TestDTO> listOfTestsFromAPI = TestsRequest.getTestsById(idOfProject);

        return StringUtility.getStartedDates(listOfTestsFromAPI);
    }

    public String generateNameOfProject() {
        return RandomStringUtils.randomAlphabetic(RandomUtility.randomIntegerFromInDiaposon(testDataUiDTO.getMinLenghtOfProjectName(), testDataUiDTO.getMaxLenghtOfProjectName()));
    }

    public void createNewProject(String nameOfProject) {
        nexagePageObject.goHome();
        projectsPageObject.clickToAddProject();
        addProjectForm.inputProjectNameAndSubmit(nameOfProject);
    }

    public void closeWindow() {
        JavaScriptUtility.closeWindow();
    }

    public Map<String, String> addProjectWithLogsAndScreenshot(String nameOfProject) {
        String idOfProject = projectsPageObject.getIdOfProject(nameOfProject);
        projectsPageObject.goToProjectWithName(nameOfProject);

        String nameOfClass = getClass().getName();
        String nameOfMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        String idOfTest = TestsRequest.addTest(nameOfProject, nameOfClass, nameOfMethod);

        TestsRequest.addLogsToTest(idOfTest);
        TestsRequest.addScreenShot(idOfTest, AqualityServices.getBrowser().getScreenshot());

        Map<String, String> test = new HashMap<String, String>();
        test.put(configDataApiDTO.getProjectIdParam(), idOfProject);
        test.put(configDataApiDTO.getProjectNameParam(), nameOfProject);
        test.put(configDataApiDTO.getTestIdParam(), idOfTest);
        test.put(configDataApiDTO.getClassNameParam()   , nameOfClass);
        test.put(configDataApiDTO.getMethodNameParam(), nameOfMethod);

        return test;
    }

    public void assertThatTestsOrderedByDescendingAndSameWithApiTests(String idOfNexageProject) {
        List<Date> datesFromAPI = getDatesFromApi(idOfNexageProject);
        List<Date> myDatesUI = nexagePageObject.getListOfDates();
        List<Date> sortedDescDatesUI = myDatesUI.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        Assert.assertEquals(myDatesUI, sortedDescDatesUI, "Dates are not descending");
        Assert.assertTrue(datesFromAPI.containsAll(myDatesUI), "Dates From UI are not corresponds from api request");
    }

    public void assertThatSuccessAlertDisplayed() {
        Assert.assertTrue(addProjectForm.isAlertDisplayed(), "Project is not added");
    }

    public void assertThatFormIsClosedAndProjectAdded(String nameOfProject) {
        Assert.assertFalse(addProjectForm.isFormDisplayed(), "Form is not closed!");
        AqualityServices.getBrowser().refresh();
        Assert.assertTrue(projectsPageObject.isProjectWithNameDisplayed(nameOfProject), "Project Does Not Exist");
    }

    public void assertThatTestIsAdded(String nameOfMethod) {
        Assert.assertTrue(addedProjectPageObject.doesTestExist(nameOfMethod), "Test in this project does not exist");
    }
}
