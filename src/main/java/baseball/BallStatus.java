package baseball;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public static boolean isBall(BallStatus ballStatus) {
        return ballStatus == BALL;
    }

    public static boolean isStrike(BallStatus ballStatus) {
        return ballStatus == STRIKE;
    }
}
