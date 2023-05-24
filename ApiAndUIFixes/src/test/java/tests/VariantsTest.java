package tests;

import org.testng.annotations.*;
import selenium.core.BaseTest;
import tests.steps.*;
import java.util.Map;

import static dataread.DataRead.*;

public class VariantsTest extends BaseTest {
    private Map<String, String> test;
    private final StepsOfVariant2 stepsOfVariant2 = new StepsOfVariant2();
    private final StepsOfVariant4 steplsOfVariant4 = new StepsOfVariant4();

    @Test
    public void variant2UiAndApiTest() {
        String token = stepsOfVariant2.getTokenByVariant(testDataApiDTO.getVariantToTakeTokenApiAndUi());
        stepsOfVariant2.assertTokenIsGenerated(token);

        String variant = stepsOfVariant2.passAuthSetTokenToCookieAndReturnTheVariant(token);
        stepsOfVariant2.assertThatVariantIsCorrectAndProjectPageDisplayed(variant, testDataApiDTO.getVariantToTakeTokenApiAndUi());

        String idOfNexageProject = stepsOfVariant2.getNexageProjectId();
        stepsOfVariant2.goToNexageProject();
        stepsOfVariant2.assertThatTestsOrderedByDescendingAndSameWithApiTests(idOfNexageProject);

        String nameOfProject = stepsOfVariant2.generateNameOfProject();
        stepsOfVariant2.createNewProject(nameOfProject);
        stepsOfVariant2.assertThatSuccessAlertDisplayed();

        stepsOfVariant2.closeWindow();
        stepsOfVariant2.assertThatFormIsClosedAndProjectAdded(nameOfProject);

        test = stepsOfVariant2.addProjectWithLogsAndScreenshot(nameOfProject);
        stepsOfVariant2.assertThatTestIsAdded(test.get(configDataApiDTO.getMethodNameParam()));
    }

    @Test (dependsOnMethods = "variant2UiAndApiTest")
    public void variant4UiAndDbTest() {
        String token = steplsOfVariant4.getTokenByVariant(testDataApiDTO.getVariantToTakeTokenUiAndDb());
        steplsOfVariant4.assertTokenIsGenerated(token);

        String variant = steplsOfVariant4.passAuthSetTokenToCookieAndReturnTheVariant(token);
        steplsOfVariant4.assertThatVariantIsCorrectAndProjectPageDisplayed(variant, testDataApiDTO.getVariantToTakeTokenUiAndDb());

        steplsOfVariant4.goToMyProject(test.get(configDataApiDTO.getProjectNameParam()));
        steplsOfVariant4.assertThatProjectPageDislayed(test.get(configDataApiDTO.getProjectNameParam()));

        steplsOfVariant4.deleteTest(test.get(configDataApiDTO.getTestIdParam()));
        steplsOfVariant4.assertThatTestIsDeleted(test.get(configDataApiDTO.getMethodNameParam()));

        steplsOfVariant4.deleteProject(test.get(configDataApiDTO.getProjectNameParam()));
        steplsOfVariant4.assertThatProjectIsDeleted(test.get(configDataApiDTO.getProjectNameParam()));
    }
}
