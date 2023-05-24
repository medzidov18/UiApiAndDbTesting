package utilities;

import api.models.TestDTO;

import java.text.*;
import java.util.*;

import static dataread.DataRead.*;

public class StringUtility {
    public static List<Date> getStartedDates(List<TestDTO> tests) {
        List<Date> myDates = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat(configDataApiDTO.getSimpleDateFormat());

        try {
            for (TestDTO test : tests) {
                String myDate = test.getStartTime().substring(0, test.getStartTime().length() - 2);
                myDates.add(formatter.parse(myDate));
            }
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }
        return myDates;
    }
}
