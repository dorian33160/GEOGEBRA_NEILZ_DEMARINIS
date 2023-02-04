package PROJET;

/**
 * The type Point 2.
 */
public class Point2 implements InterPoint {
    private double angle;
    private double radius;

    /**
     * Instantiates a new Point 2.
     *
     * @param angle  the angle
     * @param radius the radius
     */
    public Point2(double angle, double radius) {
        this.angle = (Math.toRadians(angle));
        this.radius = radius;
    }

    @Override
    public double taille_segment(InterPoint p2)
    {
        return Math.sqrt(Math.pow((p2.getX())-(this.getX()), 2)  +  Math.pow((p2.getY())-(this.getY()), 2)); //calcul de la distance entre deux points
    }

    @Override
    public double getX() {
        return (int) radius * Math.cos(angle); //retourne la coordonnée x du point qui convertie l'angle en radian
    }

    @Override
    public double getY() {
        return (int) radius * Math.sin(angle); //retourne la coordonnée x du point qui convertie l'angle en radians
    }

    public double calculerAngle(InterPoint A, InterPoint B, InterPoint C) { //calcul de l'angle entre trois points
        double BAx = B.getX() - A.getX();
        double BAy = B.getY() - A.getY();
        double BCx = B.getX() - C.getX();
        double BCy = B.getY() - C.getY();
        double dotProduct = BAx * BCx + BAy * BCy;
        double BA = Math.sqrt(BAx * BAx + BAy * BAy);
        double BC = Math.sqrt(BCx * BCx + BCy * BCy);
        return Math.acos(dotProduct / (BA * BC)) * 180 / Math.PI;
    }
}
