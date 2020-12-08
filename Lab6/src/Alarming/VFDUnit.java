package Alarming;

import Firefigters.Firefighter;
import Messaging.Alarm;

import java.util.ArrayList;

public class VFDUnit implements IVFDUnit {

    private String name;
    private ArrayList<Firefighter> firefighters = new ArrayList<>();
    private Alarm alarm = new Alarm();

    public VFDUnit(String name){
        this.name = name;
    }

    public void addFirefighter(Firefighter firefighter){
        if(!firefighters.contains(firefighter)){
            firefighters.add(firefighter);
        }
    }
    public void rmFirefighter(Firefighter firefighter){
        firefighters.remove(firefighter);
    }

    public String getName(){
        return name;
    }

    @Override
    public ResponseCode notify(String CCIR_CODE) {
        if(CCIR_CODE.startsWith("A")){
            try{
                for(Firefighter f: firefighters){
                    f.sendSms("alarm");
                }
                alarm.armAlarm();
                alarm.runAlarm();
                alarm.unarmedAlarm();
                return ResponseCode.AlarmOK;
            } catch (Exception e){
                e.printStackTrace();
            }
            return ResponseCode.AlarmError;
        } else if(CCIR_CODE.startsWith("T")){
            return ResponseCode.TestOK;
        } else {
            return ResponseCode.Error;
        }
    }

}






