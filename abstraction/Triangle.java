package abstraction;

public class Triangle extends Shape<Poligon> {

    private int side;
    private int height;

    String convertShapeToString(Poligon poligon) {
        return "The surface of the triangle is: " + poligon.getHeight() * poligon.getLength() / 2;
    }
}
