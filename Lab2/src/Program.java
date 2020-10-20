import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Vector2D vec2 = new Vector2D(1, 2);
        System.out.println(vec2.cdot(new Vector2D(4, 5)));
        System.out.println(Arrays.toString(vec2.getComponents()));
        Vector3D vector3D = new Vector3D(5, 3, 2);
        System.out.println(vector3D.crossProduct(new Vector3D(4,8,1)));

        Vector3DDecorator vector3DDecorator = new Vector3DDecorator(vec2, 4);
        PolarVector2DAdapter polarVector2DAdapter = new PolarVector2DAdapter();
        Vector2D vector2D = (Vector2D) polarVector2DAdapter.fromPolar(vec2.abs(), vec2.getAngels());
        System.out.println(vector2D);
        System.out.println(vector3DDecorator);
    }
}
