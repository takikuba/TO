public class Currency {
    String name;
    double exchangeRate;
    int converter;

    Currency(String name) {
        this.name = name;
    }
    Currency(String name, double exchangeRate, int converter){
        this.name = name;
        this.exchangeRate = exchangeRate;
        this.converter = converter;
    }
}
