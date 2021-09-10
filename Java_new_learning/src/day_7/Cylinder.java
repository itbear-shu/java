package day_7;

public class Cylinder extends Circle{
    private double length;

//    public Cylinder() {
//        this.length = 1;
//    }
    //当父类只有有参构造时，子类也必须有参构造
    public Cylinder(double radius, double length) {
        super(radius);//必须写在第一行
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findvolume() {
        return super.findArea()*this.length;
    }

    @Override
    public double findArea() {
        return 2*this.getRadius()*3.14*getLength();
    }
}
