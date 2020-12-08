package Alarming;

public interface IVFDUnit {

    String name = null;
    byte[] codeTest = new byte[0];
    byte[] codeAlarm = new byte[0];

    ResponseCode notify(String CCIR_CODE);
}
