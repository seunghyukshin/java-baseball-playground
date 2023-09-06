package baseball;

public class Ball {
    int position;
    int value;

    public Ball(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public BallStatus match(Ball ball) {
        if (!isEqualPosition(ball) && isEqualValue(ball)) {
            return BallStatus.BALL;
        }
        if (isEqualPosition(ball) && isEqualValue(ball)) {
            return BallStatus.STRIKE;
        }
        return BallStatus.NOTHING;
    }

    public boolean isEqualValue(Ball ball) {
        return this.value == ball.value;
    }

    public boolean isEqualPosition(Ball ball) {
        return this.position == ball.position;
    }

}
