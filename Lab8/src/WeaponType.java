public class WeaponType {

    private String model;
    private Ammunition ammunition;
    private int power;

    public WeaponType(String model, Ammunition ammunition, int power) {
        this.model = model;
        this.ammunition = ammunition;
        this.power = power;
    }

    public String toString() {
        return model + " " + power;
    }
}
