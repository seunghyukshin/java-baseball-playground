import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    static InputView inputView;

    public static void main(String[] args) {
        inputView = new InputView();

        do {
            _playBall();

            // 1(RESTART) 입력때까지 반복
        } while (_isOneMoreGame());
    }

    // 한 게임
    private static void _playBall() {
        char[] computerNumbers = _createComputerNumbers(); // 컴퓨터 난수 생성
        Score score = new Score();
        while (!score.isStrikeOut()) { // 3진 아웃 시 게임 종료
            char[] userNumbers = inputView.getUserNumbers(); // 사용자 숫자 입력

            score = _calculateScore(computerNumbers, userNumbers);// 점수 계산

            System.out.println(score); // 점수 출력
        }
    }

    // 컴퓨터 난수 생성
    private static char[] _createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() != 3) {
            _addRandomValue(computerNumbers); // 리스트에 난수 추가
        }

        return _convertListToCharArray(computerNumbers);
    }

    // 리스트에 난수 추가
    private static void _addRandomValue(List<Integer> computerNumbers) {
        Random random = new Random();
        int randomValue = random.nextInt(9) + 1;  // 1 ~ 9

        if (!computerNumbers.contains(randomValue)) { // 서로 다른 수
            computerNumbers.add(randomValue);
        }
    }

    // IntegerList to charArray
    private static char[] _convertListToCharArray(List<Integer> list) {
        char[] charArray = new char[list.size()];

        for (int i = 0; i < list.size(); i++) {
            int intValue = list.get(i);
            charArray[i] = Character.forDigit(intValue, 10);
        }

        return charArray;
    }

    // 점수계산
    private static Score _calculateScore(char[] computerNumberChars, char[] userInputChars) {
        Score score = new Score();

        // 세 숫자 비교
        for (int i = 0; i < 3; i++) {
            _compareNumbers(computerNumberChars, userInputChars, i, score);
        }

        return score;
    }

    private static void _compareNumbers(char[] computerNumberChars, char[] userInputChars, int index, Score score) {
        char targetChar = userInputChars[index];

        if (computerNumberChars[index] == targetChar) { // 값도 같고 index도 같다면 Strike
            score.strike();
            return;
        }
        String computerNumberString = String.valueOf(computerNumberChars);
        if (computerNumberString.contains(String.valueOf(targetChar))) {
            // 컴퓨터 숫자들 중 사용자 숫자 하나라도 포함하고 있으면 Ball
            score.ball();
        }
    }

    // 재시작 입력 시 true
    private static boolean _isOneMoreGame() {
        String finishingInput = inputView.getInputFinishing();

        return GameFinishDscdEnum.RESTART.getValue().equals(finishingInput);
    }

}
