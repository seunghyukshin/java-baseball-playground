package baseball;

public class Ball {
    int position;
    int value; // TODO: Number Domain 생성

    public Ball(int position, int value) throws BallNumberOutOfBoundsException {
        // 입력값 검증
        _validate(value);

        this.position = position;
        this.value = value;
    }


    private void _validate(int value) throws BallNumberOutOfBoundsException {
        // 1~9 숫자인지 검증
        if (!NumberUtils.isSingleNaturalNumber(value)) {
            throw new BallNumberOutOfBoundsException(value);
        }
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

    @Override
    public String toString() {
        return "Ball{" +
                "position=" + position +
                ", value=" + value +
                '}';
    }
}
