package TD1_FINI;

public class Cerfvolant extends Quadrilatere {

    private Point[] sommet;
    private double[] longueur;

    Cerfvolant(Point point1, Point point2, Point point3, Point point4)
    {
        super(point1,point2, point3, point4);
        sommet = new Point[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;
    }

    public String côté(Point point1, Point point2, Point point3, Point point4)
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
    public double côté1(Point point1, Point point2)
    {
        double côté1;

        côté1 = point1.taille_segment(point2);

        return côté1;

    }

    public double côté2(Point point2, Point point3)
    {
        double côté2;

        côté2 = point2.taille_segment(point3);

        return côté2;

    }

    public double côté3(Point point3, Point point4)
    {
        double côté3;

        côté3 = point3.taille_segment(point4);

        return côté3;

    }

    public double côté4(Point point4, Point point1)
    {
        double côté4;

        côté4 = point4.taille_segment(point1);

        return côté4;

    }

    public String vérification(Point point1, Point point2, Point point3, Point point4)
    {
        if (côté1(point1, point2) == côté2(point2, point3) && côté3(point3, point4) == côté4(point4, point1))
        {
            return "C'est un cerf-volant. ";
        }
        else
        {
            return "Ce n'est pas un cerf-volant. ";
        }
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
        return "Je suis un " + type() + " de longueur " + côté(sommet[0], sommet[1], sommet[2], sommet[3]) + ". " + propriete() + vérification(sommet[0],sommet[1],sommet[2],sommet[3]) + "Mes sommets sont " + coordonnees();
    }

    @Override
    public void affiche()
    {
        System.out.println(this);
    }
}
