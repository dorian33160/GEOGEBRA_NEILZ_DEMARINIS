package PROJET;

public class Parallélogramme extends Quadrilatere{

    private Point[] sommet;

    Parallélogramme(Point point1, Point point2, Point point3, Point point4)
    {
        super(point1,point2, point3, point4);
        sommet = new Point[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;
    }

    public double longueur1(Point point1, Point point2)
    {
        double longueur1;

        longueur1 = point2.taille_segment(point1);

        return longueur1;

    }

    public double longueur2(Point point3, Point point4)
    {
        double longueur2;

        longueur2 = point3.taille_segment(point4);

        return longueur2;

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
        if (longueur1(sommet[0], sommet[1]) == longueur1(sommet[2], sommet[3]) && longueur2(sommet[0], sommet[1]) == longueur2(sommet[2], sommet[3]))
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
        return "Un parallèlogramme à des côtés opposés de même longueur. Ses diagnolase se coupent en leur milieu.";
    }

    @Override
    public String type()
    {
        return "Parallèlogramme";
    }

    @Override
    public String toString()
    {
        return "Je suis un " + type() + " de longueur " + longueur1(sommet[0], sommet[1]) + "et de largeur " + longueur2(sommet[2], sommet[3]) + ". " + propriete() + "Mes sommets sont " + coordonnees();
    }
}
