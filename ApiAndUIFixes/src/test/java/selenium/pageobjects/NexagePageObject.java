package selenium.pageobjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.*;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import selenium.customelements.Table;
import utilities.TextBoxUtility;
import java.util.*;

public class NexagePageObject extends Form {
    private final Table table = AqualityServices.getElementFactory().getCustomElement(Table::new, By.id("allTests"), "Diagram", ElementState.EXISTS_IN_ANY_STATE);
    private final ILink homeLink = AqualityServices.getElementFactory().getLink(By.xpath("//ol[@class='breadcrumb']/li/a[contains(text(), 'Home')]"), "Home Link");

    public NexagePageObject() {
        super(By.xpath("//ol[@class='breadcrumb']/li[contains(text(), 'Nexage')]"), "Nexage Page");
    }

    public List<Date> getListOfDates() {
        AqualityServices.getConditionalWait().waitFor(() -> table.state().isDisplayed());
        List<ITextBox> allDates = AqualityServices.getElementFactory().findElements(By.xpath("//table//td[count(//table//th[contains(text(), 'Latest test start time')]/preceding-sibling::*) +1]"), ElementType.TEXTBOX);

        return TextBoxUtility.convertToListOfDate(allDates);
    }

    public void goHome() {
        homeLink.click();
    }
}
