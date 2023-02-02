package PROJET;

public class FabriquePoint {
    public static InterPoint create(String type, double x, double y) {
        if (type.equals("Point")) {
            return new Point(x, y);
        } else if (type.equals("Point2")) {
            return new Point2(x, y);
        }
        return null;
    }
}

