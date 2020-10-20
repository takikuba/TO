import java.util.Arrays;

public interface IVector {
    double abs();
    double[] getComponents();
    double[] getAngels();
    double cdot(IVector iVector);

}
