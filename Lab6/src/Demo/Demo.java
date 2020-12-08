package Demo;

import Alarming.VFDUnit;
import Firefigters.Firefighter;

public class Demo {
    public static void main(String[] args) {
        HeadUnit headUnit = new HeadUnit();

        Firefighter f1 = new Firefighter("qaz", "qwerty", "1");
        Firefighter f2 = new Firefighter("wsx", "asdfgh", "2");
        Firefighter f3 = new Firefighter("edc", "zcvbbn", "3");
        Firefighter f4 = new Firefighter("rfv", "zcbzxgv", "4");
        Firefighter f5 = new Firefighter("tgb", "sfdg", "5");
        Firefighter f6 = new Firefighter("yhn", "sfger", "6");
        Firefighter f7 = new Firefighter("ujm", "wrtg", "7");
        Firefighter f8 = new Firefighter("ik,", "wergejh", "8");
        Firefighter f9 = new Firefighter("nhy", "wegyg", "9");
        Firefighter f10 = new Firefighter("mju", "4targ", "10");
        Firefighter f11 = new Firefighter("zaq", "Kowalski2444", "11");
        Firefighter f12 = new Firefighter("xsw", "4t", "12");
        Firefighter f13 = new Firefighter("cde", "segr", "13");
        Firefighter f14 = new Firefighter("vfe", "Kowalski242345", "14");
        Firefighter f15 = new Firefighter("bgt", "Kowalski23454", "15");

        VFDUnit j1 = new VFDUnit("Jednostka1");
        VFDUnit j2 = new VFDUnit("Jednostka2");
        VFDUnit j3 = new VFDUnit("Jednostka3");
        VFDUnit j4 = new VFDUnit("Jednostka4");
        VFDUnit j5 = new VFDUnit("Jednostka5");
        VFDUnit j6 = new VFDUnit("Jednostka6");
        VFDUnit j7 = new VFDUnit("Jednostka7");

        j1.addFirefighter(f1);
        j1.addFirefighter(f2);

        j2.addFirefighter(f3);
        j2.addFirefighter(f4);

        j3.addFirefighter(f5);
        j3.addFirefighter(f6);

        j4.addFirefighter(f7);
        j4.addFirefighter(f8);

        j5.addFirefighter(f9);
        j5.addFirefighter(f10);

        j6.addFirefighter(f11);
        j6.addFirefighter(f12);
        j6.addFirefighter(f13);

        j7.addFirefighter(f14);
        j7.addFirefighter(f15);


        headUnit.addUnit(j1);
        headUnit.addUnit(j2);
        headUnit.addUnit(j3);
        headUnit.addUnit(j4);
        headUnit.addUnit(j5);
        headUnit.addUnit(j6);
        headUnit.addUnit(j7);

        headUnit.run();

    }
}
