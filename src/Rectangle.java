import java.awt.*;

public class Rectangle implements Drawable, Saveable {
    Point p1;
    Point p2;
    Color color;
    boolean fill;

    public Rectangle(Point p1, Point p2, Color color, boolean fill) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
        this.fill = fill;
    }

    public Rectangle(Point p1, Point p2, Color color) {
        this(p1, p2, color, false);
    }

    public Rectangle(Point p1, Point p2) {
        this(p1, p2, Color.BLACK);
    }

    public Rectangle(Point p1, Point p2, boolean fill) {
        this(p1, p2, Color.BLACK, fill);
    }

    public Rectangle() {

    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean getFill() {
        return this.fill;
    }

    @Override
    public double getArea() {
        return (p2.getX() - p1.getX()) * (p2.getY() - p1.getY());
    }

    public double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getX() - p2.getX(), 2));
    }

    public double getPerimeter() {
        return 2 * (getDistance(p1, p2) + getDistance(p2, p1));
    }

    public int getWidth() {
        return p2.getX() - p1.getX();
    }

    public int getHeight() {
        return p2.getY() - p1.getY();
    }

    public int[] getXs() {
        int[] xs = {p1.getX(), p2.getX()};
        return xs;
    }

    public int[] getYs() {
        int[] ys = {p1.getY(), p2.getY()};
        return ys;
    }
    public Point getP1(){
        return p1;
    }
    public Point getP2(){
        return p2;
    }

    @Override
    public String getFileText() {
        return "Rectangle*" + this.p1.getX() + "*" + this.p1.getY() + "*" + this.p2.getX() + "*" + this.p2.getY() + "*" + Main.translateColor(this.color) + "*" + this.fill;
    }

    @Override
    public void loadFileText(String data) {
        String[] dataArray = data.split("\\*");
        this.p1 = new Point(Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]));
        this.p2 = new Point(Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]));
        this.color = Main.translateColor(dataArray[5]);
        this.fill = Boolean.parseBoolean(dataArray[6]);
    }
}
