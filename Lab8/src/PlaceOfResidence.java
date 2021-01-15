public class PlaceOfResidence {

    private int nrDomu;
    private String ulica;
    private int kodPocztowy;
    private String poczta;

    public PlaceOfResidence(int nrDomu, String ulica, int kodPocztowy, String poczta) {
        this.nrDomu = nrDomu;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }

    public int getNrDomu() {
        return nrDomu;
    }

    public String getUlica() {
        return ulica;
    }

    public int getKodPocztowy() {
        return kodPocztowy;
    }

    public String getPoczta() {
        return poczta;
    }

    public String getPlaceOfResidence(){
        return ulica + nrDomu + '\n' + kodPocztowy + poczta;
    }
}
