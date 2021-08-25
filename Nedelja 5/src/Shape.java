public  abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }


    public abstract double circumference();

    public abstract  double area();


    @Override
    public String toString() {
        String result = "Shape " + this.name + "\n";
        result+= "Circumference: " + circumference() + "\n";
        result+= "Area: " + area() + "\n";

        return result;
    }
}
