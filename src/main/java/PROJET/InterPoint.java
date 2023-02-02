package PROJET;

public interface InterPoint {
    double getX();
    double getY();

    double calculerAngle(InterPoint p1, InterPoint p2, InterPoint p3);
    double taille_segment(InterPoint p2);
}
