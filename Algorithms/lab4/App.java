package Algorithms.lab4;

public class App {
    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        tree.insertNode(6);
        tree.insertNode(3);
        tree.insertNode(8);
        tree.insertNode(2);
        tree.insertNode(4);
        tree.insertNode(7);
        tree.insertNode(9);
        System.out.println("InOrder:");
        tree.inorder();
        System.out.println();
        System.out.println("PreOrder:");
        tree.preorder();
        System.out.println();
        System.out.println("PostOrder:");
        tree.postorder();
        System.out.println();
        System.out.printf("MinItem: %d\n", tree.minItem());
        System.out.printf("MaxItem: %d\n", tree.maxItem());
    }
}
