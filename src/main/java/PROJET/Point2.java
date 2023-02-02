package PROJET;

public class Point2 implements InterPoint {
    private double angle;
    private double radius;

    public Point2(double angle, double radius) {
        this.angle = (Math.toRadians(angle));
        this.radius = radius;
    }

    @Override
    public double taille_segment(InterPoint p2)
    {
        return Math.sqrt(Math.pow((p2.getX())-(this.getX()), 2)  +  Math.pow((p2.getY())-(this.getY()), 2));
    }

    @Override
    public double getX() {
        return (int) radius * Math.cos(angle);
    }

    @Override
    public double getY() {
        return (int) radius * Math.sin(angle);
    }

    public double calculerAngle(InterPoint A, InterPoint B, InterPoint C) {
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
