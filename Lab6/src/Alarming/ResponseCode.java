package Alarming;

public enum ResponseCode {
    AlarmOK(true),
    AlarmError(false),
    TestOK(true),
    Error(false);

    boolean isOK;

    ResponseCode(boolean b) {
        isOK = b;
    }

    public boolean isOK() {
        return isOK;
    }
}
