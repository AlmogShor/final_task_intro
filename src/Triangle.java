import java.awt.Color;

public class Triangle implements Drawable, Saveable {

    //data
    private Point p0, p1, p2;
    private Color color;
    private boolean fill;

    //constructor

    public Triangle(Point p0, Point p1, Point p2, Color color, boolean fill) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;

        this.color = color;
        this.fill = fill;
    }

    public Triangle() {

    }


    //functions
    public Color getColor() {
        return color;
    }

    public int[] getXs() {
        int[] ans = new int[3];
        ans[0] = p0.getX();
        ans[1] = p1.getX();
        ans[2] = p2.getX();
        return ans;
    }

    public int[] getYs() {
        int[] ans = new int[3];
        ans[0] = p0.getY();
        ans[1] = p1.getY();
        ans[2] = p2.getY();
        return ans;
    }


    @Override
    public boolean getFill() {
        return fill;
    }


    @Override
    public double getArea() {//Area=|(p1-p0)X(p2-p0)|
        return Math.abs((p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) - (p2.getX() - p0.getX()) * (p1.getY() - p0.getY()));
    }

    private double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getX() - p2.getX(), 2));
    }

    public double getPerimeter() {
        return getDistance(p0, p1) + getDistance(p1, p2) + getDistance(p2, p0);
    }

    @Override
    public String getFileText() {
        return "Triangle*" + this.p0.getX() + "*" + this.p0.getY() + "*" + this.p1.getX() + "*" + this.p1.getY() + "*" + this.p2.getX() + "*" + this.p2.getY() + "*" + Main.translateColor(this.color) + "*" + this.fill;
    }

    @Override
    public void loadFileText(String data) {
        String[] parts = data.split("\\*");
		this.p0 = new Point(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
		this.p1 = new Point(Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
		this.p2 = new Point(Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));
		this.color = Main.translateColor(parts[7]);
		this.fill = Boolean.parseBoolean(parts[8]);

    }

}
