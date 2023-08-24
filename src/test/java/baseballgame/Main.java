package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 컴퓨터 난수 생성
        List<Integer> computerNumbers = _makeComputerNumbers();
        char[] computerNumberChars = _convertListToCharArray(computerNumbers);
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");

            Scanner scanner = new Scanner(System.in);

            String userInputString = scanner.nextLine();
            char[] userInputChars = userInputString.toCharArray();
            System.out.println();

            String result = _calculateScore(computerNumberChars, userInputChars);
//            System.out.println(result);
        }

    }


    private static List<Integer> _makeComputerNumbers() {
        Random random = new Random();
        List<Integer> computerNumbers = new ArrayList<>();

        while (true) {
            if (computerNumbers.size() == 3) {
                break;
            }
            int randomValue = random.nextInt(9) + 1;  // 1 ~ 9
            if (!computerNumbers.contains(randomValue)) {
                computerNumbers.add(randomValue);
            }
        }

        return computerNumbers;
    }


    private static char[] _convertListToCharArray(List<Integer> list) {
        char[] charArray = new char[list.size()];

        for (int i = 0; i < list.size(); i++) {
            int intValue = list.get(i);
            charArray[i] = (char) intValue;
        }

        return charArray;
    }

}
