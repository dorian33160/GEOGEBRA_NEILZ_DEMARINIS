package PROJET;

public class Parallélogramme extends Quadrilatere{

    private InterPoint[] sommet;

    Parallélogramme(InterPoint point1, InterPoint point2, InterPoint point3, InterPoint point4)
    {
        super(point1,point2, point3, point4);
        sommet = new InterPoint[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;
    }

    public double longueur1(InterPoint point1, InterPoint point2)
    {
        double longueur1;

        longueur1 = point2.taille_segment(point1);

        return longueur1;

    }

    public double longueur2(InterPoint point3, InterPoint point4)
    {
        double longueur2;

        longueur2 = point3.taille_segment(point4);

        return longueur2;

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

    public boolean verification()
    {
        double longueur1 = longueur1(sommet[0], sommet[1]);
        double longueur2 = longueur2(sommet[1], sommet[2]);
        double longueur3 = longueur1(sommet[2], sommet[3]);
        double longueur4 = longueur2(sommet[3], sommet[0]);

        double angle1 = sommet[0].calculerAngle(sommet[0], sommet[1], sommet[2]);
        double angle2 = sommet[1].calculerAngle(sommet[1], sommet[2], sommet[3]);
        double angle3 = sommet[2].calculerAngle(sommet[2], sommet[3], sommet[0]);
        double angle4 = sommet[3].calculerAngle(sommet[3], sommet[0], sommet[1]);

        if (longueur1 == longueur3 && longueur2 == longueur4 && angle1 == angle3 && angle2 == angle4)
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
