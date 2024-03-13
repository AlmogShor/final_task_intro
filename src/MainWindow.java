import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MainWindow extends JFrame {

    //data
    private ArrayList<Drawable> drawable;


    //constructor
    public MainWindow() {
        super();
    }

    //functions

    @Override
    public void paint(Graphics g) {

        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        if (this.drawable != null) {
            for (Drawable value : this.drawable) {
                try {


                    if (value instanceof Point) {
                        Point p = (Point) value;
                        g.drawOval(p.getX(), p.getY(), 3, 3);
                    }

                    if (value instanceof Line) {
                        Line l = (Line) value;

                        g.setColor(l.getColor());
                        g.drawLine(l.getP0().getX(), l.getP0().getY(),
                                l.getP1().getX(), l.getP1().getY());
                    }

                    if (value instanceof Circle) {
                        Circle c = (Circle) value;

                        g.setColor(c.getColor());

                        if (c.getFill()) {
                            g.fillOval(c.getP().getX() - c.getRadius() / 2,
                                    c.getP().getY() - c.getRadius() / 2,
                                    c.getRadius(), c.getRadius());
                        } else {
                            g.drawOval(c.getP().getX() - c.getRadius() / 2,
                                    c.getP().getY() - c.getRadius() / 2,
                                    c.getRadius(), c.getRadius());
                        }


                    }

                    if (value instanceof Triangle) {
                        Triangle t = (Triangle) value;

                        g.setColor(t.getColor());

                        if (t.getFill()) {
                            g.fillPolygon(t.getXs(), t.getYs(), t.getXs().length);
                        } else {
                            g.drawPolygon(t.getXs(), t.getYs(), t.getXs().length);
                        }

                    }
                    if (value instanceof Rectangle) {
                        Rectangle r = (Rectangle) value;

                        g.setColor(r.getColor());

                        if (r.getFill()) {
                            g.fillRect(r.getP1().getX(), r.getP1().getY(),
                                    r.getWidth(), r.getHeight());
                        } else {
                            g.drawRect(r.getP1().getX(), r.getP1().getY(),
                                    r.getWidth(), r.getHeight());
                        }
                    }
                    if (value instanceof Hexagon) {
                        Hexagon h = (Hexagon) value;

                        g.setColor(h.getColor());

                        if (h.getFill()) {
                            g.fillPolygon(h.getHexagon().xpoints, h.getHexagon().ypoints, h.getpointCount());
                        } else {
                            g.drawPolygon(h.getHexagon().xpoints, h.getHexagon().ypoints, h.getpointCount());
                        }
                    }


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }


    public void setDraws(ArrayList<Drawable> drawable) {
        this.drawable = drawable;
        this.repaint();
    }


}