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
        if (!_validate(ball)) {
            return;
        }
        this.ballList.add(ball);
    }

    // add가능한 ball인지 검증
    private boolean _validate(Ball ball) {
        boolean check = true;

        // size가 3보다 작은지 검증
        if(this.ballList.size() > 3){
            check = false;
            return check;
        }

        // 1~9 숫자인지 검증
        if (ball.value <= 0 && ball.value > 9) {
            check = false;
            return check;
        }

        // 중복값 검증
        check = ballList.stream().allMatch(thisBall -> thisBall.value != ball.value);

        return check;

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

        if (hitBallStatus.isPresent()) {
            // Ball OR Strike
            return hitBallStatus.get();
        }

        return BallStatus.NOTHING;
    }

    public void initRandomBalls() {
        int index = this.ballList.size();
        while (this.ballList.size() != 3) {
            add(new Ball(index, RandomUtils.createSingleDigitNumber()));
        }
    }

    public Ball getBall(int position) {
        return this.ballList.get(position);
    }
}
