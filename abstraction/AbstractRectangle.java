package abstraction;

public abstract class AbstractRectangle {

    private int width;
    private int height;

    abstract void setWidth(int width);
    abstract void setHeight(int height);

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}
