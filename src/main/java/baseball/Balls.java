package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Ball> ballList;

    public Balls() {
        ballList = new ArrayList<>();
    }

    public void add(Ball ball) {
        this.ballList.add(ball);
    }

    public Score compare(Balls paramBalls) {
        Score score = new Score();
        List<Ball> paramBallList = paramBalls.ballList;
        for (int i = 0; i < 3; i++) {
            BallStatus ballStatus = _compare(paramBallList.get(i));
            score.update(ballStatus);
        }

        return score;
    }

    private BallStatus _compare(Ball paramBall) {

        // TODO : 구현필요
        for (int j = 0; j < 3; j++) {
            Ball thisBall = this.ballList.get(j);
            BallStatus ballStatus = paramBall.match(thisBall);
            if(BallStatus.isNothing(ballStatus)){

            }
        }

        return BallStatus.NOTHING;
    }
}
