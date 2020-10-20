import java.util.Arrays;

public class Vector2D implements IVector{
    private double x;
    private double y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    double getX(){
        return x;
    }
    double getY(){
        return y;
    }

    @Override
    public double abs() {
        return Math.sqrt( x*x + y*y );
    }

    @Override
    public double[] getComponents() {
        return new double[]{x, y};
    }

    @Override
    public double[] getAngels() {
        return new double[]{Math.atan2(y,x)};
    }

    @Override
    public double cdot(IVector vector) {
        if(vector == null){
            throw new NullPointerException();
        }
        if(vector.getClass().equals(Vector2D.class)){
            Vector2D vector2D = (Vector2D) vector;
            return x * vector2D.x + y * vector2D.y;
        }
        throw new IllegalArgumentException("Podany arg musi byc Vector2D!");
    }
    @Override
    public String toString() {
        return Arrays.toString(getComponents());
    }

}
