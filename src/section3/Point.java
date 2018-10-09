package section3;

import java.awt.*;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }
}

class ColorPoint{
    private final Color color;
    private final Point point;

    public ColorPoint(int x, int y, Color color) {
        if (color==null)throw new NullPointerException();
        point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint)) {
            return false;
        }
        /*if (!(obj instanceof Point)) {
            return false;
        }
        return super.equals(obj) && ((ColorPoint) obj).color == color;*/
        ColorPoint cp= (ColorPoint) obj;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
