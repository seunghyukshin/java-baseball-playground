public enum GameFinishDscdEnum {
    RESTART("1"),
    FINISH("2");

    String value;
    GameFinishDscdEnum(String value) {
        this.value = value;
    }

    String getValue(){
        return value;
    }
}
