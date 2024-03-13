import java.awt.Color;

public class Line implements Drawable, Saveable {
	
	//data
	private Point p0,p1;
	private Color color;
	
	//constructor
	public Line(Point p0,Point p1, Color color) {
		this.p0 = p0;
		this.p1 = p1;
		this.color = color;
	}

    public Line() {

    }

    //functions
	public Point getP0() {
		return p0;
	}
	
	public Point getP1() {
		return p1;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public boolean getFill() {
		return false;
	}

	@Override
	public double getArea() {
		return 1;
	}

	@Override
	public double getPerimeter() {
		return 2*this.getDistance();
	}

	private double getDistance() {
		return Math.sqrt(Math.pow(p0.getX()-p1.getX(), 2)+Math.pow(p0.getY()-p1.getY(), 2));
	}

	@Override
	public String getFileText() {
		return "Line*"+this.p0.getX()+"*"+this.p0.getY()+"*"+this.p1.getX()+"*"+this.p1.getY()+"*"+Main.translateColor(this.color);
	}

	@Override
	public void loadFileText(String data) {
		String[] parts = data.split("\\*");
		this.p0 = new Point(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
		this.p1 = new Point(Integer.parseInt(parts[3]),Integer.parseInt(parts[4]));
		this.color = Main.translateColor(parts[5]);
	}


}
