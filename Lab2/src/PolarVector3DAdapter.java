import static java.lang.Math.*;
public class PolarVector3DAdapter implements IPolarVectorAdapter{
    @Override
    public IVector fromPolar(double abs, double[] angels) {
        return new Vector3D(
                abs * sin(angels[1]) * cos(angels[0]),
                abs * sin(angels[1]) * sin(angels[0]),
                abs * cos(angels[1])
        );
    }
}
