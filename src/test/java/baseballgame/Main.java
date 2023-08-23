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
    public static void main(String[] args){

        // 컴퓨터 난수 생성
        List<Integer> computerNumbers = _makeComputerNumbers();


    }


    @DisplayName("컴퓨터 난수 생성")
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
}
