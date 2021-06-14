package _06_inheritance.exercise;

public class Point3D extends Point2D{
    private float z = 0.0f;
    public Point3D(){}
    public Point3D(float x,float y, float z){
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ() {
        float[] getXYZ = {super.getX(), super.getY(), getZ()};
        return getXYZ;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        setZ(z);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x = " + super.getX() +
                ", y = " + super.getY() +
                ", z =" + this.getZ() +
                '}';
    }

    public static void main(String[] args) {
        Point3D point3D = new Point3D(3, 1.5f, 5);
        System.out.println(point3D.toString());
        point3D.setXYZ(7,8,10.5f);
        System.out.println(point3D);
    }
}
