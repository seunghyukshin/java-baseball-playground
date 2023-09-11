package baseball;

public class Score {

    private int ballCount;
    private int strikeCount;

    public Score() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void update(BallStatus ballStatus) {
        if(BallStatus.isBall(ballStatus)){
            this.ballCount ++;
            return;
        }
        if(BallStatus.isStrike(ballStatus)){
            this.strikeCount ++;
            return;
        }

    }

    public boolean isStrikeOut() {
        return this.strikeCount == 3;
    }

    @Override
    public String toString() {
        if(ballCount == 0 && strikeCount == 0){
            return "Nothing";
        }

        String ballString = "";
        if(ballCount != 0){
            ballString = ballCount + "볼 ";
        }

        String strikeString = "";
        if(strikeCount != 0){
            strikeString = strikeCount + "스트라이크";
        }

        return ballString + strikeString;
    }
}
