package PROJET;

public class Losange extends Quadrilatere {

    private Point[] sommet;

    Losange (Point point1, Point point2, Point point3, Point point4)
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

    public boolean verification()
    {
        if (côté(sommet[0], sommet[1]) == côté(sommet[1], sommet[2]) && côté(sommet[1], sommet[2]) == côté(sommet[2], sommet[3]) && côté(sommet[2], sommet[3]) == côté(sommet[3], sommet[0]))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

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
