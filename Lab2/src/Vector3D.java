import java.util.Arrays;

public class Vector3D extends Vector2D {

    private double z;

    public Vector3D(double x, double y, double z) {
        super(x,y);
        this.z = z;
    }

    double getZ(){
        return z;
    }

    @Override
    public double abs() {
        return Math.sqrt( getX()*getX() + getY()*getY() + z*z);
    }

    @Override
    public double[] getComponents() {
        return new double[]{getX(), getY(), this.z};
    }

    @Override
    public double[] getAngels() {
        return new double[]{super.getAngels()[0], Math.acos(z/abs())};
    }

    @Override
    public double cdot(IVector vector) {
        if(vector == null){
            throw new NullPointerException();
        }
        if(vector.getClass().equals(Vector3D.class)){
            Vector3D vector3D = (Vector3D) vector;
            return getX() * vector3D.getX() + getY() * vector3D.getY() + z * vector3D.z;
        }
        throw new IllegalArgumentException("Podany arg musi byc Vector2D!");
    }

    public Vector3D crossProduct(Vector3D vector3D){
        double x = this.getY() * vector3D.z - this.z * vector3D.getY();
        double y = this.z * vector3D.getX() - this.getX() * vector3D.z;
        double z = this.getX() * vector3D.getY() - this.getY() * vector3D.getX();
        return new Vector3D(x, y, z);
    }

}
