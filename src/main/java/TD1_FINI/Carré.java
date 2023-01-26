package TD1_FINI;

public class Carré extends Quadrilatere {

    private Point[] sommet;

    Carré (Point point1, Point point2, Point point3, Point point4)
    {
        super(point1,point2, point3, point4);
        sommet = new Point[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;
    }

    public double côté (Point point1, Point point2)
    {
        double côté;
        côté = point2.taille_segment(point1);
        return côté;

    }

    @Override
    public String coordonnees()
    {

        StringBuilder sb = new StringBuilder();
        for (Point point : sommet) {
            sb.append("(").append(point.getX()).append(",").append(point.getY()).append(")");
        }

        return sb.toString();

    }

    public String vérification()
    {
        if (côté(sommet[0], sommet[1]) == côté(sommet[1], sommet[2]) && côté(sommet[1], sommet[2]) == côté(sommet[2], sommet[3]) && côté(sommet[2], sommet[3]) == côté(sommet[3], sommet[0]))
        {
            return " Je suis un carré ";
        }
        else
        {
            return " Je ne suis pas un carré ";
        }
    }

    public String propriete()
    {
        return "Un carré est un quadrilatère qui a ses quatre côtés de la même longueur et ses quatre angles droits";
    }

    @Override
    public String type()
    {
        return "Carré";
    }

    @Override
    public String toString()
    {
        return "Je suis un " + type() + " de côté " + côté(sommet[0], sommet[1]) + ". " + propriete() + vérification() + ". Mes sommets sont " + coordonnees();
    }

    @Override
    public void affiche()
    {
        System.out.println(this);
    }
}
