package PROJET;

public class Trapèze extends Quadrilatere{

    private Point[] sommet;
    private double[] longueur;

    Trapèze (Point point1, Point point2, Point point3, Point point4)
    {
        super(point1,point2, point3, point4);
        sommet = new Point[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;
    }

    public String côté (Point point1, Point point2, Point point3, Point point4)
    {
        double côté1;
        double côté2;
        double côté3;
        double côté4;

        longueur = new double[4];

        côté1 = point1.taille_segment(point2);
        côté2 = point2.taille_segment(point3);
        côté3 = point3.taille_segment(point4);
        côté4 = point4.taille_segment(point1);

        longueur[0] = côté1;
        longueur[1] = côté2;
        longueur[2] = côté3;
        longueur[3] = côté4;

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
        for (Point point : sommet) {
            sb.append("(").append(point.getX()).append(",").append(point.getY()).append(")");
        }

        return sb.toString();

    }

    public boolean verification()
    {
        if (longueur[0] == longueur[3] && longueur[1] == longueur[2])
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
