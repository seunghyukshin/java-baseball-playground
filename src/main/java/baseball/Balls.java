package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // Balls와 Ball 비교
    private BallStatus _compare(Ball paramBall) {
        Optional<BallStatus> hitBallStatus = this.ballList.stream()
                .map(ball -> ball.match(paramBall))
                .filter(ballStatus -> BallStatus.isHit(ballStatus))
                .findAny();

        if(hitBallStatus.isPresent()){
            // Ball OR Strike
            return hitBallStatus.get();
        }

        return BallStatus.NOTHING;
    }
}
