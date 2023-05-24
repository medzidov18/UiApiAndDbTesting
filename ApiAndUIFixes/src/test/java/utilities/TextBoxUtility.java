package utilities;

import aquality.selenium.elements.interfaces.*;

import java.text.*;
import java.util.*;

import static dataread.DataRead.*;

public class TextBoxUtility {
    private static SimpleDateFormat formatter = new SimpleDateFormat(configDataApiDTO.getSimpleDateFormat());

    public static List<Date> convertToListOfDate(List<ITextBox> textBoxes) {
        List<Date> myDates = new ArrayList<>();

        for (ITextBox date : textBoxes) {
            String myDate = date.getText().substring(0, date.getText().length() - 2);
            try {
                myDates.add(formatter.parse(myDate));
            } catch (ParseException e) {
                throw new IllegalStateException(e);
            }
        }

        return myDates;
    }
}
