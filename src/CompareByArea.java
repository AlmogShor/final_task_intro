import java.util.Comparator;

public class CompareByArea implements Comparator<Drawable> {

	@Override
	public int compare(Drawable first, Drawable second) {
		if (first.getArea() > second.getArea()) { return 1;}
		if (first.getArea() < second.getArea()) { return -1;}
		return 0;
	}
}

