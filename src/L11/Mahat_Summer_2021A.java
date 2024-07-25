package L11;


import java.util.*;


public class Mahat_Summer_2021A {

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
                    Queue<Integer> q = new LinkedList<>() {{
                        add(2);
                        add(5);
                        add(5);
                        add(7);
                        add(2);
                        add(2);
                        add(4);
                        add(1);
                        add(3);
                        add(2);
                        add(5);
                        add(5);
                        add(1);
                    }};
                    System.out.println(q);

                    System.out.println(duplicate(q));
                    System.out.println(q);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    Memory memory = new Memory(137);
                    memory.add(97, false);
                    memory.add(342);
                    for (int i = 0; i < 0; i++) {
                        memory.add(rd.nextInt(512 - 30) + 30, rd.nextBoolean());
                    }
                    memory.print();
                    memory.firstFit(142);
                    memory.print();
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

    private static Queue<Integer> duplicate(Queue<Integer> q) {
        if (q == null)
            return null;
        Queue<Integer> newQ = new LinkedList<>();
        if (q.isEmpty())
            return newQ;

        int size = 0;

        while (!q.isEmpty()) {
            size++;
            newQ.add(q.poll());
        }
        while (!newQ.isEmpty()) {
            q.add(newQ.poll());
        }

        while(!q.isEmpty()) {
            int item = q.poll();
            int cnt = 1;
            size--;
            for (int j = 0; j < size; j++) {
                if (item == q.peek()) {
                    cnt++;
                    q.poll();
                    size--;
                } else
                    q.add(q.poll());
            }
            if (cnt > 2)
                newQ.add(item);
        }
        return newQ;
    }


}

class Data {
    private boolean free;
    private int size;

    //constructor
    public Data(int size) {
        this.free = true;
        this.size = size;
    }

    public Data(int size, boolean free) {
        this.free = free;
        this.size = size;
    }

    public boolean isFree() {
        return free;
    }

    public int getSize() {
        return size;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


class Memory {
    private Node<Data> start;

    public Memory(int totalSize) {
        this.start = new Node<Data>(new Data(totalSize));
    }

    public boolean firstFit(int num) {
        Node<Data> temp = start;

        while (temp != null) {
            if (temp.getValue().isFree() && temp.getValue().getSize() >= num)
                break;
            temp = temp.getNext();
        }

        if (temp == null)
            return false;

        Node<Data> newNode = new Node<>(new Data(num, false));
        int oldSize = temp.getValue().getSize();
        temp.getValue().setSize(oldSize - num);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);


        if (isDangerousState()) {
            temp.setNext(newNode.getNext());
            return false;
        }

        return true;


    }

    public boolean isDangerousState() {
        if (start == null)
            return false;
        Node<Data> temp = start;
        int total = 0;
        int size = 0;
        while (temp != null) {
            total += temp.getValue().getSize();
            if (!temp.getValue().isFree())
                size += temp.getValue().getSize();
            temp = temp.getNext();
        }

        return 1 - ((double) size / total) > 0.9;
    }

    public void add(int totalSize) {
        if (start == null)
            this.start = new Node<Data>(new Data(totalSize));
        else {
            Node<Data> temp = this.start;

            while (temp.hasNext())
                temp = temp.getNext();

            temp.setNext(new Node<Data>(new Data(totalSize)));
        }
    }

    public void add(int totalSize, boolean free) {
        if (start == null)
            this.start = new Node<Data>(new Data(totalSize, free));
        else {
            Node<Data> temp = this.start;

            while (temp.hasNext())
                temp = temp.getNext();

            temp.setNext(new Node<Data>(new Data(totalSize, free)));
        }
    }

    public void print() {

        Node<Data> temp = this.start;
        while (temp != null) {
            System.out.print("(" + temp.getValue().getSize() + ", " + temp.getValue().isFree() + ") -> ");
            temp = temp.getNext();
        }
        System.out.println("null");

    }

}

class Node<E> {

    private E value;
    private Node<E> next;


    public Node(E value) {
        this.value = value;
        this.next = null;

    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;

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


    @Override
    public String toString() {
        return value + "";
    }
}

class BinNode<E> {

    private E value;
    private BinNode<E> left;
    private BinNode<E> right;


    public BinNode(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinNode(E value, BinNode<E> left, BinNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BinNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinNode<E> left) {
        this.left = left;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public BinNode<E> getRight() {
        return right;
    }

    public void setRight(BinNode<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return value + "";
    }
}