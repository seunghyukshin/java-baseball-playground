package baseball;

public class Game {
    Score score;
    public Game() {
        score = new Score();
    }

    public void play(){
//        do{
            _playOneGame();
//        }while();
    }

    private void _playOneGame(){
        // 컴퓨터 난수 Balls 생성
        Balls computerBalls = new Balls();
        computerBalls.initRandomBalls();

        System.out.println(computerBalls);
        while(!score.isStrikeOut()) {
            Balls userBalls = new Balls();
            userBalls.makeBalls(InputView.getUserBalls());
            System.out.println(userBalls);

            // 점수계산
            score = computerBalls.compare(userBalls);
            ResultView.print(score);
        }
    }

}
