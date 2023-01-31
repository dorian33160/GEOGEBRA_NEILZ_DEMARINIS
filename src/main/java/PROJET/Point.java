package PROJET;

public class Point {

    private double x;
    private double y;

    Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double taille_segment(Point p2)
    {
        return Math.sqrt(Math.pow((p2.x)-(this.x), 2)  +  Math.pow((p2.y)-(this.y), 2));
    }

    public static double calculerAngle(Point A, Point B, Point C) {
        double BAx = B.x - A.x;
        double BAy = B.y - A.y;
        double BCx = B.x - C.x;
        double BCy = B.y - C.y;
        double dotProduct = BAx * BCx + BAy * BCy;
        double BA = Math.sqrt(BAx * BAx + BAy * BAy);
        double BC = Math.sqrt(BCx * BCx + BCy * BCy);
        return Math.acos(dotProduct / (BA * BC)) * 180 / Math.PI;
    }

}
