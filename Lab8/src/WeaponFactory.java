import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class WeaponFactory {

    private static HashMap<String, WeaponType> weapons = new HashMap<>();

    public static WeaponType getWeaponType(String model, Ammunition amunition, int power){
        WeaponType reval = weapons.get(model);
        if( reval == null ){
            reval = new WeaponType(model, amunition, power);
            weapons.put(model, reval);
        }
        return reval;
    }

    public static Collection<WeaponType> getWeapons(){
        return weapons.values();
    }

}
