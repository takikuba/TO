public class Weapon {

    private WeaponType type;
    private long id;

    public Weapon(WeaponType type, long id) {
        this.type = type;
        this.id = id;
    }

    public WeaponType getType() {
        return type;
    }

    public long getId() {
        return id;
    }

}
