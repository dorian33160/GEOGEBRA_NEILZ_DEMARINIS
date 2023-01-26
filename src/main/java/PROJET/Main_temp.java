package PROJET;
public class Main_temp
{
    public static void main(String[] args)
    {
        Quadrilatere[] collection;
        Point p1 = new Point(0,7);
        Point p2 = new Point(3,6);
        Point p3 = new Point(2,8);
        Point p4 = new Point(4,8);

        Point p1_carré = new Point(0,7);
        Point p2_carré = new Point(0,0);
        Point p3_carré = new Point(7,0);
        Point p4_carré = new Point(7,7);

        Quadrilatere q = new Quadrilatere(p1,p2,p3,p4);

        Parallélogramme para = new Parallélogramme(p1,p2,p3,p4);

        Carré carre = new Carré(p1_carré, p2_carré, p3_carré, p4_carré);

        Losange losange = new Losange(p1_carré, p2_carré, p3_carré, p4_carré);

        Trapèze trapeze = new Trapèze(p1, p2, p3, p4);

        Rectangle rectangle = new Rectangle(p1_carré, p2_carré, p3_carré, p4_carré);

        collection = new Quadrilatere[6];
        collection[0] = q;
        collection[1] = para;
        collection[2] = carre;
        collection[3] = losange;
        collection[4] = trapeze;
        collection[5] = rectangle;

        for (Quadrilatere quadri : collection) {
            quadri.affiche();
        }

    }

}
