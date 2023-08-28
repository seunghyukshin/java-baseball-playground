public class Score {
    private int strikeCount;
    private int ballCount;

    public Score() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void strike() {
        this.strikeCount++;
    }

    public void ball() {
        this.ballCount++;
    }

    public boolean isStrikeOut() {
        return strikeCount == 3;
    }

    @Override
    public String toString() {
        if (strikeCount == 0 && ballCount == 0) {
            return "Nothing";
        }

        return strikeCount + "스트라이크 " + ballCount + "볼";
    }
}