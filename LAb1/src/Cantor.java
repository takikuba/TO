import java.io.BufferedReader;

public class Cantor {

    static double getCash(String val1, String val2, Double val3) throws Exception {
        double[] info1 = getLine(val1);
        double[] info2 = getLine(val2);

        return (info1[0] / info1[1]) / (info2[0] / info2[1]) * val3;
    }

    static double getRate(String val1) throws Exception{
        double[] info1 = getLine(val1);
        return info1[0];
    }

    static double[] getLine(String var) throws Exception{
        new URLReader();
        BufferedReader data = URLReader.getData();
        String line, line2 = "one", line3;
        boolean is = false;
        double conventer = 0, exchengeRate = 0;
        while ((line = data.readLine()) != null){
            if(is){
                line3 = line.replaceAll(",", ".");
                exchengeRate = Double.parseDouble(line3.replaceAll("[^0-9.]", ""));
                is = false;
            }
            if( line.contains(var)){
                conventer = Double.parseDouble(line2.replaceAll("[^\\d.]",""));
                is = true;
            }
            line2 = line;

        }
        data.close();
        double []retval = {0, 0};
        retval[0] = exchengeRate;
        retval[1] = conventer;
        return retval;
    }

}
