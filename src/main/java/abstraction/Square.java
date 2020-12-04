package abstraction;

public class Square extends AbstractRectangle {

    @Override
    void setWidth(int width) {
//        AbstractRectangle.setWidth(width);
        setHeight(width);
    }

    @Override
    void setHeight(int height) {
        setWidth(height);
        setHeight(height);
    }

    public void g(AbstractRectangle abstractRectangle) {
        abstractRectangle.setHeight(4);
        abstractRectangle.setHeight(5);
//        assert(abstractRectangle.getHeight() * abstractRectangle.getWidth() == 20);
    }
}
