package TD1_FINI;

public class Quadrilatere
{
    private Point[] sommet;

    Quadrilatere(Point point1, Point point2, Point point3, Point point4)
    {
        sommet = new Point[4];
        sommet[0] = point1;
        sommet[1] = point2;
        sommet[2] = point3;
        sommet[3] = point4;
    }

    public String type()
    {
        return "quadrilatère quelconque.";
    }

    public String coordonnees()
    {

        StringBuilder sb = new StringBuilder();
        for (Point point : sommet) {
            sb.append("(").append(point.getX()).append(",").append(point.getY()).append(")");
        }


        return sb.toString();

    }

    @Override
    public String toString()
    {
        return "Je suis un " + type() + "Mes sommmets ont pour " + coordonnees();
    }


    public void affiche()
    {
        System.out.println(this);
    }
}
