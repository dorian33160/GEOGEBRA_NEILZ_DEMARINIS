package PROJET;

/**
 * The type Cerfvolant.
 */
public class Cerfvolant extends Quadrilatere{

    private InterPoint[] sommet;
    private double[] longueur;

    /**
     * Instantiates a new Cerfvolant.
     *
     * @param point1 the point 1
     * @param point2 the point 2
     * @param point3 the point 3
     * @param point4 the point 4
     */
    Cerfvolant(InterPoint point1, InterPoint point2, InterPoint point3, InterPoint point4)
    {
        super(point1,point2, point3, point4);
        sommet = new InterPoint[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;

        longueur = new double[4];

        longueur[0] = point1.taille_segment(point2);
        longueur[1] = point2.taille_segment(point3);
        longueur[2] = point3.taille_segment(point4);
        longueur[3] = point4.taille_segment(point1);
    }

    /**
     * Côté string.
     *
     * @param point1 the point 1
     * @param point2 the point 2
     * @param point3 the point 3
     * @param point4 the point 4
     * @return the string
     */
    public String côté(InterPoint point1, InterPoint point2, InterPoint point3, InterPoint point4)
    {
        StringBuilder sb = new StringBuilder();
        for (double cote : longueur) {
            sb.append(cote).append(" , ");
        }

        return sb.toString();

    }

    /**
     * Côté 1 double.
     *
     * @param point1 the point 1
     * @param point2 the point 2
     * @return the double
     */
    public double côté1(InterPoint point1, InterPoint point2)
    {
        double côté1;

        côté1 = point1.taille_segment(point2);

        return côté1;

    }

    /**
     * Côté 2 double.
     *
     * @param point2 the point 2
     * @param point3 the point 3
     * @return the double
     */
    public double côté2(InterPoint point2, InterPoint point3)
    {
        double côté2;

        côté2 = point2.taille_segment(point3);

        return côté2;

    }

    /**
     * Côté 3 double.
     *
     * @param point3 the point 3
     * @param point4 the point 4
     * @return the double
     */
    public double côté3(InterPoint point3, InterPoint point4)
    {
        double côté3;

        côté3 = point3.taille_segment(point4);

        return côté3;

    }

    /**
     * Côté 4 double.
     *
     * @param point4 the point 4
     * @param point1 the point 1
     * @return the double
     */
    public double côté4(InterPoint point4, InterPoint point1)
    {
        double côté4;

        côté4 = point4.taille_segment(point1);

        return côté4;

    }

    /**
     * Verification boolean.
     *
     * @return the boolean
     */
    public boolean verification()
    {
        double longueur1 = longueur[1];
        double longueur3 = longueur[3];

        double angle1 = sommet[0].calculerAngle(sommet[0], sommet[1], sommet[2]);
        double angle2 = sommet[1].calculerAngle(sommet[1], sommet[2], sommet[3]);
        double angle3 = sommet[2].calculerAngle(sommet[2], sommet[3], sommet[0]);
        double angle4 = sommet[3].calculerAngle(sommet[3], sommet[0], sommet[1]);

        if (longueur1 == longueur3 && angle1 == 90 && angle2 == 90 && angle3 == 90 && angle4 == 90) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String coordonnees()
    {

        StringBuilder sb = new StringBuilder();
        for (InterPoint point : sommet) {
            sb.append("(").append(point.getX()).append(",").append(point.getY()).append(")");
        }

        return sb.toString();

    }

    /**
     * Propriete string.
     *
     * @return the string
     */
    public String propriete()
    {
        return "Un cerf-volant à une somme de ses angles à 180 degrès.";
    }

    @Override
    public String type()
    {
        return "Cerf-volant";
    }

    @Override
    public String toString()
    {
        return "Je suis un " + type() + " de longueur " + côté(sommet[0], sommet[1], sommet[2], sommet[3]) + ". " + propriete() + "Mes sommets sont " + coordonnees();
    }

}
