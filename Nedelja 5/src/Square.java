public class Square extends Shape{
    double a,b;

    public Square(String name,double a,double b) {
        super(name);
        this.a = a;
        this.b = b;

    }

    @Override
    public double circumference() {
        return 4 * a;
    }

    @Override
    public double area() {
        return a * a;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}