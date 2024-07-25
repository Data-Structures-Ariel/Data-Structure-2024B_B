package Les12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        BinNode<Integer> root =
                new BinNode<>(17, new
                        BinNode<>(36, new BinNode<>(12, new BinNode<>(10), new BinNode<>(42)), null), new BinNode<>(7, new BinNode<>(28,new BinNode<>(5),new BinNode<>(8)), new BinNode<>(0, null, new BinNode<>(1, null, new BinNode<>(70)))));
        System.out.println("-------------------inOrder----------------------");
        inOrder(root);
        System.out.println("\n-------------------preOrder----------------------");
        preOrder(root);
        System.out.println("\n-------------------postOrder----------------------");
        postOrder(root);
        System.out.println("\n-------------------levelOrder----------------------");
        levelOrder(root);

        ArrayList<BinNode<Integer>> al = new ArrayList<>();
        al.add(root);
        BinNode<Integer> current = al.remove(0);
        int L=3;
        int level = levelCount(root,L);
        System.out.println("\n----------------------------");
        System.out.println("count "+level);





    }

    private static int levelCount(BinNode<Integer> root, int l) {
        if(root == null)
            return 0;
        if(l==0)
            return 1;
        return levelCount(root.getLeft(),l-1)+levelCount(root.getRight(),l-1);
    }

    public static void inOrder(BinNode<Integer> root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getValue()+" ");
            inOrder(root.getRight());
        }
    }

    public static void preOrder(BinNode<Integer> root) {
        if (root != null) {
            System.out.print(root.getValue()+" ");
            inOrder(root.getLeft());
            inOrder(root.getRight());
        }
    }

    public static void postOrder(BinNode<Integer> root) {
        if (root != null) {
            inOrder(root.getLeft());
            inOrder(root.getRight());
            System.out.print(root.getValue()+" ");
        }
    }

    public static void levelOrder(BinNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinNode<Integer> current = q.remove();
            System.out.print(current.getValue()+" ");
            if (current.hasLeft())
                q.add(current.getLeft());
            if (current.hasRight())
                q.add(current.getRight());
        }
    }
}
