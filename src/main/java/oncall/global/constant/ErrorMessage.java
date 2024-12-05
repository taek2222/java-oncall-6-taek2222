package oncall.global.constant;

public enum ErrorMessage {
    INVALID_INPUT("유효하지 않은 입력 값입니다.");

    private static final String PREFIX = "[ERROR] ";
    private static final String RETRY = "다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message + RETRY;
    }

    public String get(Object... value) {
        return PREFIX + String.format(message, value) + RETRY;
    }
}