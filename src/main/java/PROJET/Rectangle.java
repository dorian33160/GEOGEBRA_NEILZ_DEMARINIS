package PROJET;

/**
 * The type Rectangle.
 */
public class Rectangle extends Quadrilatere{

    private InterPoint[] sommet;

    /**
     * Instantiates a new Rectangle.
     *
     * @param point1 the point 1
     * @param point2 the point 2
     * @param point3 the point 3
     * @param point4 the point 4
     */
    Rectangle(InterPoint point1, InterPoint point2, InterPoint point3, InterPoint point4)
    {
        super(point1,point2, point3, point4);
        sommet = new InterPoint[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;
    }

    /**
     * Longueur 1 double.
     *
     * @param point1 the point 1
     * @param point2 the point 2
     * @return the double
     */
    public double longueur1(InterPoint point1, InterPoint point2)
    {
        double longueur1;

        longueur1 = point1.taille_segment(point2);

        return longueur1;

    }

    /**
     * Longueur 2 double.
     *
     * @param point3 the point 3
     * @param point4 the point 4
     * @return the double
     */
    public double longueur2(InterPoint point3, InterPoint point4)
    {
        double longueur2;

        longueur2 = point3.taille_segment(point4);

        return longueur2;

    }

    /**
     * Largeur 1 double.
     *
     * @param point2 the point 2
     * @param point3 the point 3
     * @return the double
     */
    public double largeur1(InterPoint point2, InterPoint point3)
    {
        double largeur1;

        largeur1 = point2.taille_segment(point3);

        return largeur1;

    }

    /**
     * Largeur 2 double.
     *
     * @param point4 the point 4
     * @param point1 the point 1
     * @return the double
     */
    public double largeur2(InterPoint point4, InterPoint point1)
    {
        double largeur2;

        largeur2 = point4.taille_segment(point1);

        return largeur2;

    }

    /**
     * Verification boolean.
     *
     * @return the boolean
     */
    public boolean verification()
    {
        if (this.largeur1(sommet[1], sommet[2]) == this.largeur2(sommet[3], sommet[0]) && this.longueur1(sommet[0], sommet[1]) == this.longueur2(sommet[2], sommet[3]))
        {
            return true;
        }
        else
        {
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
        return "Un rectangle ?? ses c??t??s oppos??s de m??me longueur.";
    }

    @Override
    public String type()
    {
        return "Rectangle";
    }

    @Override
    public String toString()
    {
        return "Je suis un " + type() + " de longueur " + longueur1(sommet[0], sommet[1]) + "et de largeur " + largeur1(sommet[1], sommet[2]) + ". " + propriete() + "Mes sommets sont " + coordonnees();
    }

}
