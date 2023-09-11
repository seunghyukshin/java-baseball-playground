package baseball;

public enum GameStatus {
    RESTART("1"), FINISH("2"), NOTHING("");

    String value;

    GameStatus(String value) {
        this.value = value;
    }

    public static boolean isRestart(String gameStatusString) {
        return RESTART.getValue().equals(gameStatusString);
    }

    private String getValue() {
        return value;
    }

}
