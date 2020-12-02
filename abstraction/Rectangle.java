package abstraction;

public class Rectangle extends Shape<Rectangle> {

    private int length;
    private int height;

    protected Rectangle() {
    }

    private Rectangle(int length, int height) {
        super();
        this.length = length;
        this.height = height;
    }

    public Rectangle drawShape() {
        super.drawShape(this);
        return this;
    }

//    @Override
//    public void sayHello() {
//        System.out.println("say hello from rectangle");
//    }

    public static Rectangle of(int length, int height) {
        return new Rectangle(length, height);
    }

    @Override
    String convertShapeToString(Rectangle rectangle) {
        return "The surface of rectangle is: " + rectangle.getHeight() * rectangle.getLength();
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

}
