package baseball;

public class Score {

    private int strikeCount;
    private int ballCount;

    public Score() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void update(BallStatus ballStatus) {
        if(BallStatus.isStrike(ballStatus)){
            this.strikeCount ++;
            return;
        }
        if(BallStatus.isBall(ballStatus)){
            this.ballCount ++;
            return;
        }

    }

    public boolean isStrikeOut() {
        return this.strikeCount == 3;
    }
}
