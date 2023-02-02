package PROJET;

public class Point implements InterPoint{

    private double x;
    private double y;

    Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public double getX() {
        return x;
    }
    @Override
    public double getY() {
        return y;
    }

    public double taille_segment(InterPoint p2)
    {
        return Math.sqrt(Math.pow((p2.getX())-(this.x), 2)  +  Math.pow((p2.getY())-(this.y), 2));
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
