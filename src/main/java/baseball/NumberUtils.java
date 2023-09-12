package baseball;

import java.util.Random;

public class NumberUtils {

    public static int createSingleDigitNumber() {
        Random random = new Random();

        return random.nextInt(9) + 1;  // 1 ~ 9
    }


    // 한자리 자연수 여부 반환
    public static boolean isSingleNaturalNumber(int number){
        return number > 0 && number <= 9;
    }
}
