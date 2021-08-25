public class Triangle extends Shape{
    private double a,b,c;

    public Triangle(String name,double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double circumference() {
        double s = (a + b + c ) / 2;
        double volume = Math.sqrt(s * (s-a) * (s-b) * (s-c));
        return volume;
    }

    @Override
    public double area() {
        double area = a + b + c;
        return area;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}