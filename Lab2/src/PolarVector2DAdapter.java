public class PolarVector2DAdapter implements IPolarVectorAdapter{
    @Override
    public IVector fromPolar(double abs, double[] angels) {
        return new Vector2D(abs*Math.cos(angels[0]), abs*Math.sin(angels[0]));
    }
}
