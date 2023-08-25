package baseballgame;

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

            // 점수 계산
            Score score = _calculateScore(computerNumberChars, userInputChars);
            // 점수 출력
            System.out.println(score);
            if(score.isAllStrike()){
                // 2: exit
                if(_isExit()){
                    break;
                }

                // 1: restart
                computerNumbers = _makeComputerNumbers();
                computerNumberChars = _convertListToCharArray(computerNumbers);
            }
        }

    }

    private static boolean _isExit() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if("2".equals(input)){
            return true;
        }

        return false;
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
            charArray[i] = Character.forDigit(intValue, 10);
        }

        return charArray;
    }

    private static Score _calculateScore(char[] computerNumberChars, char[] userInputChars) {
        Score score = new Score();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (computerNumberChars[i] == userInputChars[j]) {
                    if (i == j) {
                        score.strike();
                        continue;
                    }
                    score.ball();
                }
            }
        }
        return score;
    }

    private static class Score {
        private int strikeCount;
        private int ballCount;

        public Score() {
            this.strikeCount = 0;
            this.ballCount = 0;
        }

        public Score(int strike, int ball) {
            this.strikeCount = strike;
            this.ballCount = ball;
        }

        public void strike() {
            this.strikeCount++;
        }

        public void ball() {
            this.ballCount++;
        }

        public boolean isAllStrike(){
            return strikeCount == 3;
        }

        @Override
        public String toString() {
            if (strikeCount == 0 && ballCount == 0) {
                return "Nothing";
            }

            return strikeCount + "스트라이크 " + ballCount + "볼";
        }
    }


}
