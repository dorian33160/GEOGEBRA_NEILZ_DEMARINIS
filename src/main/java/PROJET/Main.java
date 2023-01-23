package PROJET;

public class Main
{

    public static void main(String[] args)
    {
        Point p1 = new Point(0,7);
        Point p2 = new Point(3,6);
        Point p3 = new Point(2,8);
        Point p4 = new Point(4,8);

        Point p1_carré = new Point(0,7);
        Point p2_carré = new Point(0,0);
        Point p3_carré = new Point(7,0);
        Point p4_carré = new Point(7,7);

        Quadrilatere q = new Quadrilatere(p1,p2,p3,p4);
        q.affiche();

        Parallélogramme para = new Parallélogramme(p1,p2,p3,p4);
        para.affiche();

        Carré carre = new Carré(p1_carré, p2_carré, p3_carré, p4_carré);
        carre.affiche();

        Losange losange = new Losange(p1_carré, p2_carré, p3_carré, p4_carré);
        losange.affiche();

        Trapèze trapeze = new Trapèze(p1, p2, p3, p4);
        trapeze.affiche();

        Rectangle rectangle = new Rectangle(p1_carré, p2_carré, p3_carré, p4_carré);
        rectangle.affiche();

    }

}