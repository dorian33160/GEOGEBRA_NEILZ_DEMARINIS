package PROJET;

/**
 * The type Trapèze.
 */
public class Trapèze extends Quadrilatere{

    private InterPoint[] sommet;
    private double[] longueur;

    /**
     * Instantiates a new Trapèze.
     *
     * @param point1 the point 1
     * @param point2 the point 2
     * @param point3 the point 3
     * @param point4 the point 4
     */
    Trapèze (InterPoint point1, InterPoint point2, InterPoint point3, InterPoint point4)
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
    public String côté (InterPoint point1, InterPoint point2, InterPoint point3, InterPoint point4)
    {

        StringBuilder sb = new StringBuilder();
        for (double cote : longueur) {
            sb.append(cote).append(" , ");
        }

        return sb.toString();

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

        if (longueur1 == longueur3 && angle1 == angle4 && angle2 == angle3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Propriete string.
     *
     * @return the string
     */
    public String propriete()
    {
        return "Un trapèze est un quadrilatère qui deux côtés parallèles";
    }

    @Override
    public String type()
    {
        return "Trapèze";
    }

    @Override
    public String toString()
    {
        return "Je suis un " + type() + " de côté " + côté(sommet[0], sommet[1], sommet[2], sommet[3]) + ". " + propriete() + ". Mes sommets sont " + coordonnees();
    }

}
