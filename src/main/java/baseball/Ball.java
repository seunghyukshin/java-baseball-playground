package baseball;

public class Ball {
    int position;
    int value;

    public Ball(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public BallStatus match(Ball ball) {
        if (this.position != ball.position && this.value == ball.value) {
            return BallStatus.BALL;
        }
        if (this.position == ball.position && this.value == ball.value) {
            return BallStatus.STRIKE;
        }
        return BallStatus.NOTHING;
    }
}
