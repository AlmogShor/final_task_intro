

import java.awt.Color;

public class Circle implements Drawable, Saveable {

    //data
    private Point p;
    private int radius;
    private Color color;
    private boolean fill;


    //constructor

    public Circle(Point p, int radius, Color color, boolean fill) {
        this.p = p;
        this.radius = radius;
        this.color = color;
        this.fill = fill;
    }

    public Circle() {

    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean getFill() {
        return fill;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }


    public Point getP() {
        return p;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String getFileText() {
        return "Circle*" + this.p.getX() + "*" + this.p.getY() + "*" + this.radius + "*" + Main.translateColor(this.color) + "*" + this.fill;
    }

    @Override
    public void loadFileText(String data) {
        String[] parts = data.split("\\*");
        this.p = new Point(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        this.radius = Integer.parseInt(parts[3]);
        this.color = Main.translateColor(parts[4]);
        this.fill = Boolean.parseBoolean(parts[5]);
    }


}
