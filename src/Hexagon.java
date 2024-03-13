import java.awt.*;

public class Hexagon implements Drawable, Saveable {

    //data
    private Point pCenter;
    private int radius;
    private Color color;
    private boolean fill;
    private Polygon hexagon;

    //constructor
    public Hexagon(Point pCenter, int radius, Color color, boolean fill) {
        this.pCenter = pCenter;
        this.radius = radius;
        this.color = color;
        this.fill = fill;
        this.hexagon = createHexagon();

    }

    public Hexagon(Hexagon h) {
        this(h.pCenter, h.radius, h.color, h.fill);
    }

    public Hexagon(Point pCenter, int radius) {
        this(pCenter, radius, Color.BLACK, false);
    }

    public Hexagon() {

    }

    private Polygon createHexagon() {
        Polygon polygon = new Polygon();

        for (int i = 0; i < 6; i++) {
            int xval = (int) (pCenter.getX() + radius
                    * Math.cos(i * 2 * Math.PI / 6D));
            int yval = (int) (pCenter.getY() + radius
                    * Math.sin(i * 2 * Math.PI / 6D));
            polygon.addPoint(xval, yval);
        }

        return polygon;
    }
    public Polygon getHexagon() {
        return this.hexagon;
    }
    public int getpointCount() {
        return this.hexagon.npoints;
    }
    public double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getX() - p2.getX(), 2));
    }

    public double getPerimeter() {
        //the hexagon has 6 sides. each side is the same length. so the perimeter is 6 times the length of a side.
        return 6 * getDistance(pCenter, new Point(pCenter.getX() + radius, pCenter.getY()));
    }

    public int getRadius() {
        return this.radius;
    }

    public Point getpCenter() {
        return this.pCenter;
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
        //the area of a hexagon is the area of a regular polygon with 6 sides and the same length of the radius.
        return (3 * Math.sqrt(3) * Math.pow(radius, 2)) / 2;
    }

    @Override
    public String getFileText() {
        return "Hexagon*" + this.pCenter.getX() + "*" + this.pCenter.getY() + "*" + this.radius + "*" + Main.translateColor(this.color) + "*" + this.fill;
    }

    @Override
    public void loadFileText(String data) {
        String[] parts = data.split("\\*");
        this.pCenter = new Point(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        this.radius = Integer.parseInt(parts[3]);
        this.color = Main.translateColor(parts[4]);
        this.fill = Boolean.parseBoolean(parts[5]);
        this.hexagon = createHexagon();
    }
}
