package day_7;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder c = new Cylinder(1,1);
        System.out.println(c.getRadius());
        c.setLength(100);
        c.setRadius(4);
        System.out.println(c.findArea());

        System.out.println(c.findvolume());
        System.out.println(c.findArea());
    }
}
