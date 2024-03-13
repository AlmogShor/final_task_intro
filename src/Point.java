import java.awt.Color;

public class Point implements Drawable, Saveable {
	
	//data
	private int x,y;
	private boolean fill;
	private Color color;
	
	
	//constructor
	public Point(int x,int y,Color color,boolean fill) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.fill = fill;
	}
	public Point (Point p) {
		this(p.x,p.y,p.color,p.fill);
	}
	
	public Point(int x,int y) {
		this(x,y,Color.BLACK,false);
	}
	public Point() {
		
	}
	
	//functions
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public boolean getFill() {
		return fill;
	}
	
	public double getArea() {
		
		
		return 0;
	}
	public double getPerimeter() {
		return 0;
	}
	
	@Override
	public String getFileText() {
		//return "Point: ["+x+","+y+"]"+color; 
		return "Point*"+this.x+"*"+this.y+"*"+Main.translateColor(this.color)+"*"+this.fill;
	}
	@Override
	public void loadFileText(String data) {
		String[] point = data.split("\\*");
		this.x=Integer.parseInt(point[1]);
		this.y=Integer.parseInt(point[2]);
		this.color=Main.translateColor(point[3]);
		this.fill=Boolean.parseBoolean(point[4]);
	}

}
