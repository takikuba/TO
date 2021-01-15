import java.time.LocalDate;
import java.util.*;

public class Holder {

    private long pesel;
    private String name;
    private String surname;
    private PlaceOfResidence place;
    private String cel;
    private Map<Long, Weapon> weapons = new HashMap<>();
    private LocalDate lastControl = LocalDate.now();

    public Holder(long pesel, String name, String surname, PlaceOfResidence place, String cel) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.place = place;
        this.cel = cel;
    }

    public void addWeapon(Weapon weapon){
        weapons.put(weapon.getId(), weapon);
    }

    public void addCel(String cel){
        this.cel += cel;
    }

    public String toString(){
        return name + " " + surname + " " + pesel + " \n" + place.getPlaceOfResidence();
    }

    public LocalDate getLastControl() {
        return lastControl;
    }

    public void setLastControl(LocalDate lastControl) {
        this.lastControl = lastControl;
    }

    public PlaceOfResidence getPlace(){
        return place;
    }

    public Collection<Weapon> getWeapons() {
        return weapons.values();
    }
}
