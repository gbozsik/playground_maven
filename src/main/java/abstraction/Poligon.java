package abstraction;

public class Poligon {

    private int height;
    private int length;

    private Poligon(int height, int length) {
        this.height = height;
        this.length = length;
    }

    public static Poligon of(int height, int length) {
        return new Poligon(height, length);
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}
