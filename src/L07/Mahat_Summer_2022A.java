package L07;


import java.util.*;


public class Mahat_Summer_2022A {

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


    public static void main(String[] args) throws Exception {
        int ans;
        boolean bool;
        while (true) {
            System.out.println("Enter q number");
            int num = sc.nextInt();
            System.out.println("------------------------------------------");
            switch (num) {
                case 1:
                    break;
                case 2:
                    Stack<Integer> st = new Stack<>() {{

                        for (int i = 10; 1 < i; i--) {

                            add((int) Math.pow(2, i) * i);
                        }
                    }};
                    System.out.println("Before -> " + st);
                    bool = isSortSum(st);
                    System.out.println(bool);
                    System.out.println(" After -> " + st);

                    System.out.println("--------------------------------");

                    Stack<Integer> st2 = new Stack<>() {{
                        int sum = 1;
                        for (int i = 2; i < 10; i++) {
                            sum *= i;
                            add(sum);
                        }
                    }};
                    System.out.println("Before -> " + st2);
                    bool = isSortSum(st2);
                    System.out.println(bool);
                    System.out.println("After -> " + st2);

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    int size = rd.nextInt(10);
                    Clown[] clowns = new Clown[size];
                    for (int i = 0; i < size; i++) {
                        clowns[i] = new Clown(i + "", rd.nextInt(size * size));
                        System.out.println(clowns[i]);
                    }

                    Pyramid pyramid = new Pyramid();
                    System.out.println("isStable -> " + pyramid.isStable());

                    for (int i = 0; i < size; i++) {
                        System.out.println("-------------- (" + i + ") -------------");
                        System.out.println("pyramid -> " + pyramid);
                        System.out.println("addClown -> " + pyramid.addClown(clowns[i]));
                        System.out.println("isStable -> " + pyramid.isStable());
                        System.out.println("pyramid -> " + pyramid);
                        Thread.sleep(1000);
                    }
                    System.out.println(pyramid.getClowns().poll());
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
    private static boolean isSortSum(Stack<Integer> st) {
        if (st == null || st.isEmpty()) {
            return true;
        }

        Stack<Integer> stTemp = new Stack<>();
        boolean bool = true;

        stTemp.push(st.pop());
        int sum = stTemp.peek();

        while (!st.isEmpty()) {
            int current = st.peek();
            if (current < sum) {
                bool = false;
            }
            sum += st.pop();
            stTemp.push(current);
        }

        while (!stTemp.isEmpty()) {
            st.push(stTemp.pop());
        }

        return bool;
    }

}

class Clown {
    private String name;
    private int weight;

    public Clown(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "name -> " + name + " weight -> " + weight;
    }
}

class Pyramid {
    private Queue<Clown> clowns;
    private int size;

    public Pyramid() {
        this.clowns = new LinkedList<>();
        this.size = 0;
    }

    public boolean isStable() {
        if (size == 0 || size == 1)
            return true;

        Clown previous = null;
        boolean isStable = true;

        for (int i = 0; i < size; i++) {
            Clown current = clowns.poll();
            if (previous != null && previous.getWeight() > current.getWeight()) {
                isStable = false;
            }
            clowns.add(current);
            previous = current;
        }
        return isStable;
    }

    public boolean addClown(Clown c) {
        if (!isStable())
            return false;

        if (size == 0) {
            clowns.add(c);
            size++;
            return true;
        }

        boolean inserted = false;
        int n = size;

        for (int i = 0; i < n; i++) {
            Clown current = clowns.poll();
            if (!inserted && current.getWeight() > c.getWeight()) {
                clowns.add(c);
                inserted = true;
                size++;
            }
            clowns.add(current);
        }

        if (!inserted) {
            clowns.add(c);
            size++;
        }

        return inserted;
    }

    @Override
    public String toString() {
        return "clowns -> " + clowns + " size -> " + size;
    }

    public Queue<Clown> getClowns() {
        return clowns;
    }
}

class Node<E> {

    private E value;
    private Node<E> next;
    private Node<E> prev;


    public Node(E value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Node(E value, Node<E> next, Node<E> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public boolean hasPrev() {
        return this.prev != null;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return value + "";
    }
}