package Messaging;

public class Alarm {

    private int isArmed = 0;

    public void runAlarm() {
        switch(isArmed){
            case(0):
                System.out.println("Alarm not armed!");
                break;
            case(1):
                //code to run alarm
                break;
            default:
                System.out.println("Alarm default...");
                break;
        }
    }

    public void armAlarm(){
        isArmed = 1;
    }
    public void unarmedAlarm(){
        isArmed = 0;
    }

}
