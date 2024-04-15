package L03;


import java.util.*;


public class Mahat_Summer_2023B {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();


    public static void main(String[] args) {
        int ans;
        boolean bool;
        while (true) {
            System.out.println("Enter q number");
            int num = sc.nextInt();
            System.out.println("------------------------------------------");
            switch (num) {
                case 1:
                    int num1 = rd.nextInt(100);
                    int num2 = rd.nextInt(600);
                    bool = q1_a(num1, num2);
                    Queue<Integer> q = new LinkedList<Integer>() {{
                        add(rd.nextInt(140));
                    }};
                    int num3 = rd.nextInt(89);
                    q1_b(q, num3);
                    break;
                case 2:
                    break;
                case 3:
                    First[] arr = new First[5];
                    arr[0] = new First(13);
                    arr[1] = new First();
                    arr[2] = new Second();
                    arr[3] = new Second(5, arr[0]);
                    arr[4] = new Second(2, 3.7, arr[2]);

                    System.out.println(Arrays.toString(arr));


                    Shape s1 = new Shape();
                    Shape s2 = new Circle();
                    Shape s3 = new Cylinder();
                    Circle c = new Cylinder();

//                   Circle c0 = new Shape(); // הידור
//                   Circle c1 = s1;// הידור
                    Circle c2 = (Circle) s2; // תקין
                    Circle c3 = (Circle) s3; // תקין
                    Circle c4 = (Circle) s1; // run time
                    Triangle t = new Triangle(); // תקין
                    Shape s5 = t; // תקין
                    Circle c5 = (Circle) s5; // runtime
                    Shape s = (Circle) (new Cylinder()); // תקין
//                   Circle c = (Shape)(new Cylinder()); // הידור


                    break;
                case 4:
//                    Int2 x1 = new Int2(); // הידור - לא ניתן ליצר מופע של מחלקה אבסטרקטית (אינטרפייס)
//                    x1.doIt2();
//                    System.out.println(x1);

                    Int1 x2 = new Three();
                    Int2 y2 = (Int2)x2;
                    y2.doIt2();
                    System.out.println(x2);
                    System.out.println(y2);

//                    Three x3 = new One();
//                    x3.doIt1();
//                    System.out.println(x3);


//                    One x4 = new Two();
//                    Three y4 = (Three)x4;
//                    y4.doIt2();
//                    System.out.println(x4);
//                    System.out.println(y4);


                    Int2 x5 = new Three();
                    ((One)x5).doIt1();
                    System.out.println(x5);

//                    ((Three)x5).doIt1();
//                    ((One)x5).doIt1();
//                    ((Int1)x5).doIt1();
//                    ((Int2)x5).doIt1();
//                    ((Two)x5).doIt1();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case -1:
                    return;

            }
        }
    }

    //O(n)
    private static void q1_b(Queue<Integer> q, int num3) {

        //O(1)
        if (q == null || num3 < 0)
            return;

        Queue<Integer> s = new LinkedList<>(); //O(1)
        Queue<Integer> ns = new LinkedList<>(); //O(1)

        //O(n)
        while (!q.isEmpty()) {
            if (q1_a(q.peek(), num3))
                s.add(q.poll());
            else
                ns.add(q.poll());
        }
        //O(n)
        while (!s.isEmpty())
            q.add(s.poll());

        //O(n)
        while (!ns.isEmpty())
            q.add(ns.poll());

    }

    // n = min(num1,num2) - > O(n)
    private static boolean q1_a(int num1, int num2) {

        if (num1 < 0 || num2 < 0) //O(1)
            return false;

        // n = min(num1,num2) - > O(n)
        for (int i = 2, size = Math.min(num1, num2); i <= size; i++) {
            if (num1 % i == 0 && num2 % i == 0)
                return true;
        }

        return false;
    }


}

class Shape {
}

class Cylinder extends Circle {
}

class Circle extends Shape {
}

class Triangle extends Shape {


}

class First {
    protected int num;

    public First(int num) {
        this.num = num;
    }

    public First() {
        this.num = 10;
    }

    @Override
    public String toString() {
        return "First{" +
                "num=" + num +
                '}';
    }
}

class Second extends First {
    private double x;
    private First f;

    public Second() {
        super();
        this.num = num;
        x = 1.1;
        f = null;
    }

    public Second(int num, First f) {
        super(num);
        this.x = 1.1 * num;
        this.f = f;
    }

    public Second(int num, double x, First f) {
        super((int) (num + x));
        this.x = 1.1 * this.num;
        this.f = f;
    }

    @Override
    public String toString() {
        return "Second{" +
                "num=" + num +
                ", x=" + x +
                ", f=" + f +
                '}';
    }
}

interface Int1 {
    void doIt1();
}
interface Int2 {
    void doIt2();
}
abstract class One implements Int1 {
    private int a;

    public One() {
        System.out.println("ctor One");
        this.a = 0;
    }

    public void doIt1() {
        System.out.println("One:DoIt1()");
        this.a += 5;
    }

    public String toString() {
        return "One: a=" + this.a;
    }
}
class Two extends One {
    private int b;

    public Two() {
        System.out.println("ctor Two");
        this.b = 0;
    }
    public void doIt1() {
        System.out.println("Two: doIt1()");
        super.doIt1();
        this.b += 5;
    }

    public String toString() {
        return super.toString() + " Two: b=" + this.b;
    }
}

class Three extends One implements Int2 {
    private int c;

    public Three() {
        super();
        System.out.println("ctor1 Three");
        this.c = 0;
    }

    public void doIt1() {
        System.out.println("Three: doIt1()");
        super.doIt1();
        this.c += 5;
    }

    public void doIt2() {
        System.out.println("Three: doIt2()");
        super.doIt1();
        this.c += 10;
    }

    public String toString() {
        return super.toString() + " Three: c=" + this.c;
    }
}





