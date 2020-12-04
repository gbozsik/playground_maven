package abstraction;

public abstract class Shape<T> {

    public Shape() {
    }

    public void sayHello() {
        System.out.println("hello");
    }

    public void drawShape(T shape) {
        System.out.println(convertShapeToString(shape));
    }

    abstract String convertShapeToString(T shape);

}
