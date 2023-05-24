package utility;

import java.util.Random;

public class RandomUtility {
    private static Random random = new Random();

    public static Integer randomIntegerFromInDiaposon(Integer minValue, Integer maxValue) {
        return random.nextInt(maxValue - minValue) + minValue;
    }
}
