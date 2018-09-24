public class SquareTester {
    public static void main(String[] args)
    {
        Square s = new Square(6);
        Square p = new Square(6);
        Rectangle q = new Rectangle(3, 12);
        Rectangle w = new Rectangle(4, 5);
        System.out.println(s == p);
        System.out.println(q == w);
        System.out.println(s.equals(p));
        System.out.println(q.equals(w));
    }
}
