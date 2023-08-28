import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static InputView inputView;

    public static void main(String[] args) {
        inputView = new InputView();

        do {
            _playBall();
        } while (_isOneMoreGame());
    }

    private static void _playBall() {
        char[] computerNumbers = _createComputerNumbers(); // 컴퓨터 난수 생성
        Score score = new Score();
        // 3진 아웃 시 게임 종료
        while (!score.isStrikeOut()) {
            char[] userNumbers = inputView.getUserNumbers(); // 사용자 숫자 입력

            score = _calculateScore(computerNumbers, userNumbers);// 점수 계산

            System.out.println(score); // 점수 출력
        }
    }

    private static char[] _createComputerNumbers() {

        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() != 3) {
            _addRandomValue(computerNumbers);
        }

        return _convertListToCharArray(computerNumbers);
    }

    private static void _addRandomValue(List<Integer> computerNumbers) {
        Random random = new Random();
        int randomValue = random.nextInt(9) + 1;  // 1 ~ 9

        if (!computerNumbers.contains(randomValue)) {
            computerNumbers.add(randomValue);
        }
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

        // TODO : refactor 1depth
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

    private static boolean _isOneMoreGame() {
        String finishingInput = inputView.getInputFinishing();

        return GameFinishDscdEnum.RESTART.getValue().equals(finishingInput);
    }

}
