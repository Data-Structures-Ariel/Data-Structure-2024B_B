package L09;


import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


public class Mahat_Aviv_2022A {

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
                    Node<Integer> head = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4))));
                    print(head);
                    first(head);
                    print(head);

                    Node<Integer> chain = new Node<>(11, new Node<>(2, new Node<>(30, new Node<>(4))));
                    print(chain);
                    second_2(chain);
                    print(chain);

                    break;
                case 2:
                    Stack<Integer> st = new Stack() {{
                        add(6);
                        add(12);
                        add(2);
                        add(10);
                        add(7);
                        add(5);
                    }};
                    System.out.println(st);
                    sortStack(st);
                    System.out.println(st);
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


                    break;
                case 8:
                    BinNode<Character> root = new BinNode<>('a',
                            new BinNode<>('b',null,
                                    new BinNode<>('d')),
                            new BinNode<>('c',new BinNode<>('e',new BinNode<>('f'),null),null));
                    mystery(root);
                    System.out.println();
                     root = new BinNode<>('b',
                            new BinNode<>('a',new BinNode<>('c',null,new BinNode<>('d')),
                                    new BinNode<>('e',null,new BinNode<>('f'))),
                            new BinNode<>('k'));
                    mystery(root);
                    System.out.println();
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
                    BinNode<Stack<Integer>> bSt = null;
                    bigSum(bSt);
                    break;
                case -1:
                    return;

            }
        }
    }

    private static int bigSum(BinNode<Stack<Integer>> bSt) {
        if(bSt == null)
            return -1;

        int sum=0;
        if(bSt.getValue()!=null){
            Stack<Integer> st = bSt.getValue();
            while(!st.isEmpty()){
                sum+=st.pop();
            }
        }

        return Math.max(sum,Math.max(bigSum(bSt.getLeft()),bigSum(bSt.getRight())));
    }

    //O(n)
    private static void sortStack(Stack<Integer> st) {

        if (st == null)
            return;

        double avg = 0;
        int size = 0;
        int sum = 0;

        Stack<Integer> sTemp = new Stack<>();
        while (!st.isEmpty()) {
            sum += st.peek();
            size++;
            sTemp.push(st.pop());
        }
        avg = (double)sum / size;

        Stack<Integer> small = new Stack<>();
        Stack<Integer> big = new Stack<>();

        while(!sTemp.isEmpty()){
            int item = sTemp.pop();
            if(item>avg)
                big.push(item);
            else
                small.push(item);
        }

        while (!small.isEmpty())
            st.push(small.pop());

        while (!big.isEmpty())
            st.push(big.pop());

    }

    private static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.getValue() + " -> ");
            head = head.getNext();
        }
        System.out.println("null");

    }

    public static void first(Node<Integer> chain) {
        if (chain == null)
            return;

        while (chain != null) {
            Node<Integer> new_node = new Node(chain.getValue());
            new_node.setNext(chain.getNext());
            chain.setNext(new_node);
            chain = new_node.getNext();

        }
//        while(chain!=null){
//            Node<Integer> new_node =  new Node(chain.getValue(),chain.getNext());
//            chain.setNext(new_node);
//            chain=new_node.getNext();
//        }
    }

    public static void second(Node<Integer> chain) {
        if (chain == null)
            return;

        Node<Integer> cTemp = chain;
        int cnt = 1;
        while (cTemp.hasNext()) {
            cnt++;
            cTemp = cTemp.getNext();
        }

        while (cnt != 0) {
            cTemp.setNext(new Node<>(chain.getValue()));
            cnt--;
            chain = chain.getNext();
            cTemp = cTemp.getNext();

        }

    }

    public static void second_2(Node<Integer> chain) {
        if (chain == null)
            return;

        Node<Integer> new_chain = new Node<>(chain.getValue());
        Node<Integer> cTemp = new_chain;

        while ((chain = chain.getNext()) != null) {
            cTemp.setNext(new Node<>(chain.getValue()));
            cTemp = cTemp.getNext();

            if (!chain.hasNext()) {
                chain.setNext(new_chain);
                break;
            }
        }


    }

    public static void mystery(BinNode<Character> t)
    {
        if (t != null)
        {
            System.out.print (t.getValue() + " ");
            mystery (t.getLeft());
            System.out.print (t. getValue ()+ " ");
            mystery (t. getRight());
            System.out.print (t.getValue()+ " ");
        }
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