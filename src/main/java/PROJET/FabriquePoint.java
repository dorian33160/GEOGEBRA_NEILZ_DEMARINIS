package PROJET;

/**
 * The type Fabrique point.
 */
public class FabriquePoint {
    /**
     * Create inter point.
     *
     * @param type the type
     * @param x    the x
     * @param y    the y
     * @return the inter point
     */
    public static InterPoint create(String type, double x, double y) {
        if (type.equals("Point")) {
            return new Point(x, y);
        } else if (type.equals("Point2")) {
            return new Point2(x, y);
        }
        return null;
    }
}

