package PROJET;

/**
 * The type Quadrilatere.
 */
public class Quadrilatere {

    private InterPoint[] sommet;

    /**
     * Instantiates a new Quadrilatere.
     *
     * @param point1 the point 1
     * @param point2 the point 2
     * @param point3 the point 3
     * @param point4 the point 4
     */
    Quadrilatere(InterPoint point1, InterPoint point2, InterPoint point3, InterPoint point4)
    {
        sommet = new InterPoint[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;
    }

    /**
     * Type string.
     *
     * @return the string
     */
    public String type()
    {
        return "quadrilatère quelconque.";
    }

    /**
     * Coordonnees string.
     *
     * @return the string
     */
    public String coordonnees()
    {

        StringBuilder sb = new StringBuilder();
        for (InterPoint point : sommet) {
            sb.append("(").append(point.getX()).append(",").append(point.getY()).append(")");
        }


        return sb.toString();

    }

    @Override
    public String toString()
    {
        return "Je suis un " + type() + "Mes sommmets ont pour " + coordonnees();
    }


    /**
     * Affiche.
     */
    public void affiche()
    {
        System.out.println(this);
    }
}
