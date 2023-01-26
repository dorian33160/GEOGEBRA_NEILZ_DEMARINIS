package TD1_FINI;

public class Rectangle extends Quadrilatere {

    private Point[] sommet;

    Rectangle(Point point1, Point point2, Point point3, Point point4)
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

        longueur1 = point1.taille_segment(point2);

        return longueur1;

    }

    public double longueur2(Point point3, Point point4)
    {
        double longueur2;

        longueur2 = point3.taille_segment(point4);

        return longueur2;

    }

    public double largeur1(Point point2, Point point3)
    {
        double largeur1;

        largeur1 = point2.taille_segment(point3);

        return largeur1;

    }

    public double largeur2(Point point4, Point point1)
    {
        double largeur2;

        largeur2 = point4.taille_segment(point1);

        return largeur2;

    }

    public String vérification(Point point1, Point point2, Point point3, Point point4)
    {
        if (this.largeur1(point2, point3) == this.largeur2(point4, point1) && this.longueur1(point1, point2) == this.longueur2(point3, point4))
        {
            return " Cette figure est bien un rectangle. ";
        } else {
            return " Cette figure n'est pas un rectangle. ";
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
        return "Un rectangle à ses côtés opposés de même longueur.";
    }

    @Override
    public String type()
    {
        return "Rectangle";
    }

    @Override
    public String toString()
    {
        return "Je suis un " + type() + " de longueur " + longueur1(sommet[0], sommet[1]) + "et de largeur " + largeur1(sommet[1], sommet[2]) + ". " + propriete() + vérification(sommet[0],sommet[1],sommet[2],sommet[3]) + "Mes sommets sont " + coordonnees();
    }

    @Override
    public void affiche()
    {
        System.out.println(this);
    }
}
