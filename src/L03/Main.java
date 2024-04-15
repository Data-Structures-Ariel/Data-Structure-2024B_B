package L03;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>(){{

            for (int i = 10; i >0; i--) {
                add(i);
            }
        }};

        Stack<Integer> st2 = new Stack<>(){{

            for (int i = 10; i > 0; i--) {
                add(i);
            }
        }};
        System.out.println(st);
        System.out.println(st2);
        Stack<Integer> m = merge(st,st2);

        System.out.println(m.toString());

    }

    private static Stack<Integer> merge(Stack<Integer> st1, Stack<Integer> st2) {

        if(st1==null && st2==null)
            return null;

        Stack<Integer> m = new Stack<>();
        while (!st1.isEmpty() && !st2.isEmpty())
            if(st1.peek() < st2.peek())
                m.add(st1.pop());
            else
                m.add(st2.pop());

        while (!st1.isEmpty())
                m.add(st1.pop());

        while (!st2.isEmpty())
            m.add(st2.pop());

        return m;
    }

}
