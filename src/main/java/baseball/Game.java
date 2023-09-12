package baseball;

public class Game {

    public Game() {
    }

    public void play() {
        do {
            _playOneGame();
        } while (GameStatus.isRestart(InputView.getRestartOrFinishInput()));
    }

    private void _playOneGame() {
        Score score = new Score();

        // 컴퓨터 난수 Balls 생성
        Balls computerBalls = new Balls();
        computerBalls.initRandomBalls();

//        System.out.println(computerBalls);
        while (!score.isStrikeOut()) {
            Balls userBalls = new Balls();
            String userBall = InputView.getUserBalls();

            try {
                userBalls.makeBalls(userBall);
            } catch (BallNumberOutOfBoundsException e) {
                userBall = InputView.getUserBalls();
            }

//            System.out.println(userBalls);

            // 점수계산
            score = computerBalls.compare(userBalls);
            ResultView.print(score);
        }
    }

}
