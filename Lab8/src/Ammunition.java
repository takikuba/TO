public class Ammunition {

    private String name;
    private int diameter;
    private int quantity;

    public Ammunition(String name, int diameter, int quantity) {
        this.name = name;
        this.diameter = diameter;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getQuantity() {
        return quantity;
    }
}
