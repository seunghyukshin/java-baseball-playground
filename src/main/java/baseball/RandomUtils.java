package baseball;

import java.util.Random;

public class RandomUtils {

    public static int createSingleDigitNumber() {
        Random random = new Random();

        return random.nextInt(9) + 1;  // 1 ~ 9
    }
}
