public class Circle extends Shape{
    private double r;

    public Circle(String name,double r) {
        super(name);
        this.r = r;
    }

    @Override
    public double circumference() {
        double volume = (2 * Math.PI) * r;
        return volume;
    }

    @Override
    public double area() {
        double area = (r * r * Math.PI);
        return area;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
