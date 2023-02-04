package PROJET;

/**
 * The interface Inter point.
 */
public interface InterPoint {
    /**
     * Gets x.
     *
     * @return the x
     */
    double getX();

    /**
     * Gets y.
     *
     * @return the y
     */
    double getY();

    /**
     * Calculer angle double.
     *
     * @param p1 the p 1
     * @param p2 the p 2
     * @param p3 the p 3
     * @return the double
     */
    double calculerAngle(InterPoint p1, InterPoint p2, InterPoint p3);

    /**
     * Taille segment double.
     *
     * @param p2 the p 2
     * @return the double
     */
    double taille_segment(InterPoint p2);
}
