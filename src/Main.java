import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        // the window definition
        MainWindow frame = new MainWindow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);

        // Create a list and add shapes
        ArrayList<Drawable> drawable = new ArrayList<Drawable>();
        drawable.add(new Point(100, 100));
        drawable.add(new Point(200, 200));
        drawable.add(new Point(300, 300));
        drawable.add(new Circle(new Point(100, 100), 50, Color.BLUE, false));
        drawable.add(new Hexagon(new Point(200, 200), 50, Color.BLUE, true));
        drawable.add(new Triangle(new Point(300, 300), new Point(400, 400),
                new Point(20, 30), Color.BLUE, true));
        drawable.add(new Line(new Point(100, 100), new Point(200, 200), Color.CYAN));
        drawable.add(new Rectangle(new Point(250, 200), new Point(70, 350), Color.RED, false));
        // sort by area


        // draw the shapes

        frame.setDraws(drawable);


        // sort by perimeter.
        // O(n^2)
        for (int i = 0; i < drawable.size(); i++) {
            for (int j = i + 1; j < drawable.size(); j++) {
                try {
                    int compare = CompareByPerimeter.compareByPerimeter(drawable.get(i),
                            drawable.get(j));
                    if (compare > 0) {
                        Drawable temp = drawable.get(i);
                        drawable.set(i, drawable.get(j));
                        drawable.set(j, temp);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // draw the shapes

        frame.setDraws(drawable);


        // save and load the shapes with file

        saveFile(drawable);
        drawable = readFile("My_path");
        frame.setDraws(drawable);

    }

    public static ArrayList<Drawable> readFile(String fileName) {

        ArrayList<Drawable> newDraws = new ArrayList<Drawable>();

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {

                if (line.startsWith("Point")) {
                    Point p_new = new Point();
                    p_new.loadFileText(line);

                    newDraws.add(p_new);
                }
                if (line.startsWith("Circle")) {
                    Circle c_new = new Circle();
                    c_new.loadFileText(line);

                    newDraws.add(c_new);
                }
                if (line.startsWith("Line")) {
                    Line l_new = new Line();
                    l_new.loadFileText(line);
                    newDraws.add(l_new);
                }
                if (line.startsWith("Triangle")) {
                    Triangle t_new = new Triangle();
                    t_new.loadFileText(line);
                    newDraws.add(t_new);
                }
                if (line.startsWith("Hexagon")) {
                    Hexagon h_new = new Hexagon();
                    h_new.loadFileText(line);
                    newDraws.add(h_new);
                }
                if (line.startsWith("Rectangle")) {
                    Rectangle r_new = new Rectangle();
                    r_new.loadFileText(line);
                    newDraws.add(r_new);
                }

                line = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return newDraws;

    }

    public static void saveFile(ArrayList<Drawable> draws) {
        try {
            FileWriter myWriter = new FileWriter("My_path");

            for (int i = 0; i < draws.size(); i++) {
                if (draws.get(i) instanceof Saveable) {
                    Saveable s = (Saveable) draws.get(i);
                    myWriter.write(s.getFileText() + "\n");
                }
            }
            myWriter.flush();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String translateColor(Color c) {
        if (c == Color.BLACK) {
            return "black";
        }
        if (c == Color.CYAN) {
            return "cyan";
        }
        if (c == Color.MAGENTA) {
            return "magenta";
        }
        if (c == Color.BLUE) {
            return "blue";
        }
        return "bad_color";
    }

    public static Color translateColor(String c) {
        if (c.equals("black"))
            return Color.BLACK;
        if (c.equals("cyan"))
            return Color.CYAN;
        if (c.equals("magenta"))
            return Color.MAGENTA;
        if (c.equals("blue"))
            return Color.BLUE;
        return Color.black;
    }

}
