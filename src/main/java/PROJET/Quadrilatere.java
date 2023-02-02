package PROJET;

public class Quadrilatere {

    private InterPoint[] sommet;

    Quadrilatere(InterPoint point1, InterPoint point2, InterPoint point3, InterPoint point4)
    {
        sommet = new InterPoint[4];
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


    public void affiche()
    {
        System.out.println(this);
    }
}
