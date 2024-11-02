package client;

import storage.DoubleLinkedSeq;

/**
 * Demo used to manually test the program.
 * 
 * @author X
 * @version X
 */
public class Demo
{
    private static final double A = 1.1;
    private static final double B = 2.2;
    private static final double C = 3.3;
    private static final double D = 4.4;
    private static final double E = 5.5;
    private static final double F = 6.6;
    private static final double G = 7.7;
    private static final double H = 8.8;
    private static final double I = 9.9;
    private static final double A2 = 1.2;
    private static final double B3 = 2.3;

    /**
     * The main program.
     * Use this to manually test your sequence.
     * Some tests are already made for you.
     * 
     * @param args unused.
     */
    public static void main(String[] args)
    {
        

        System.out.println("New Test.");
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        DoubleLinkedSeq s2 = new DoubleLinkedSeq();
        s1.addAfter(A);
        System.out.println("S: "+s1);
        s1.addAfter(C);
        System.out.println("S: "+s1);
        s1.addBefore(B);
        System.out.println("S: "+s1);

        s2.addAfter(D);
        System.out.println("S: "+s2);
        s2.addAfter(E);
        System.out.println("S: "+s2);
        s2.addAfter(F);
        System.out.println("S: "+s2);

        s1.addAll(s2);
        System.out.println("S: "+s1);
        s1.addAll(s1);
        System.out.println("S Final: "+s1);
        

        // DoubleLinkedSeq s1 = test2(new DoubleLinkedSeq());

        // System.out.println("S: " + s);
        // System.out.println("S1: " + s1);

        // s.addAll(s1);

        // // S: <[7.7], 4.4, 3.3, 5.5, 2.2, 6.6, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3,
        // // 4.4>
        // System.out.println("S: " + s);

        // s.removeCurrent();
        // // S: <[4.4], 3.3, 5.5, 2.2, 6.6, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3, 4.4>
        // System.out.println("S: " + s);

        // s.removeCurrent();
        // // S: <[3.3], 5.5, 2.2, 6.6, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3, 4.4>
        // System.out.println("S: " + s);

        // s.advance();
        // s.removeCurrent();
        // // S: <3.3, [2.2], 6.6, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3, 4.4>
        // System.out.println("S: " + s);

        // s.advance();
        // s.removeCurrent();
        // // S: <3.3, 2.2, [1.1], 1.1, 6.6, 5.5, 2.2, 3.3, 4.4>
        // System.out.println("S: " + s);

        // s.advance();
        // s.advance();
        // s.advance();
        // s.advance();
        // s.advance();
        // s.advance();
        // s.removeCurrent();
        // // S: <3.3, 2.2, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3>
        // System.out.println("S: " + s);

        // s.start();
        // s.removeCurrent();
        // // S: <[2.2], 1.1, 1.1, 6.6, 5.5, 2.2, 3.3>
        // System.out.println("S: " + s);
    }

    /**
     * Test 1.
     * 
     * @param s
     *            the sequence.
     * @return a reference to the same sequence.
     */
    private static DoubleLinkedSeq test1(DoubleLinkedSeq s)
    {
        System.out.println(s);

        s.addBefore(A);
        System.out.println(s);

        s.addBefore(B);
        System.out.println(s);

        s.addBefore(C);
        System.out.println(s);

        s.addBefore(D);
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.addBefore(E);
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.addBefore(F);
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.addBefore(G);
        System.out.println(s);

        return s;
    }

    /**
     * test 2.
     * 
     * @param s1
     *            The sequence.
     * @return a reference to the same sequence.
     */
    private static DoubleLinkedSeq test2(DoubleLinkedSeq s1)
    {
        System.out.println(s1);

        s1.addAfter(A);
        System.out.println(s1);

        s1.addAfter(B);
        System.out.println(s1);

        s1.addAfter(C);
        System.out.println(s1);

        s1.addAfter(D);
        System.out.println(s1);

        s1.start();
        System.out.println(s1);

        s1.addAfter(E);
        System.out.println(s1);

        s1.addBefore(F);
        System.out.println(s1);

        return s1;
    }
}
