import java.util.Arrays;

public class Vector3DDecorator implements IVector{
    Vector2D vector2D;
    double z;

    public Vector3DDecorator(Vector2D vector2D, double z) {
        this.vector2D = vector2D;
        this.z = z;
    }
    double getX(){
        return vector2D.getX();
    }

    double getY(){
        return vector2D.getY();
   }

    double getZ(){
        return z;
    }

    @Override
    public double abs() {
        return Math.sqrt( vector2D.getX()*vector2D.getX() + vector2D.getY()*vector2D.getY() + z*z);
    }

    @Override
    public double[] getComponents() {
        return new double[]{vector2D.getX(), vector2D.getY(), this.z};
    }

    @Override
    public double[] getAngels() {
        return new double[]{vector2D.getAngels()[0], Math.acos(z/abs())};
    }

    @Override
    public double cdot(IVector vector) {
        if(vector == null){
            throw new NullPointerException();
        }
        if(vector.getClass().equals(Vector3D.class)){
            Vector3D vector3D = (Vector3D) vector;
            return vector2D.getX() * vector3D.getX() + vector2D.getY() * vector3D.getY() + z * vector3D.getZ();
        }
        throw new IllegalArgumentException("Podany arg musi byc Vector2D!");
    }

    public Vector3DDecorator crossProduct(Vector3DDecorator vector3D){
        double x = this.getY() * vector3D.z - this.z * vector3D.getY();
        double y = this.z * vector3D.getX() - this.getX() * vector3D.z;
        double z = this.getX() * vector3D.getY() - this.getY() * vector3D.getX();
        return new Vector3DDecorator(new Vector2D(x, y), z);
    }

    @Override
    public String toString() {
        return Arrays.toString(getComponents());
    }
}
