package PROJET;

/**
 * The type Losange.
 */
public class Losange extends Quadrilatere {

    private InterPoint[] sommet; // tableau de points

    /**
     * Instantiates a new Losange.
     *
     * @param point1 the point 1
     * @param point2 the point 2
     * @param point3 the point 3
     * @param point4 the point 4
     */
    Losange (InterPoint point1, InterPoint point2, InterPoint point3, InterPoint point4)
    {
        super(point1,point2, point3, point4);
        sommet = new InterPoint[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;
    }

    /**
     * Côté double.
     *
     * @param point1 the point 1
     * @param point2 the point 2
     * @return the double
     */
    public double côté (InterPoint point1, InterPoint point2)
    {
        double côté;
        côté = point2.taille_segment(point1);
        return côté;

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
        if (sommet[0].calculerAngle(sommet[0], sommet[1], sommet[2]) == sommet[0].calculerAngle(sommet[0], sommet[3], sommet[2]))
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
        return "Un losange est un quadrilatère qui a ses quatre côtés de même longueur et ses quatre sommets distincts";
    }

    @Override
    public String type()
    {
        return "Losange";
    }

    @Override
    public String toString()
    {
        return "Je suis un " + type() + " de côté " + côté(sommet[0], sommet[1]) + ". " + propriete() + ". Mes sommets sont " + coordonnees();
    }

}
