package Algorithms.lab4;

public class SearchTree {
    Node root;

    public SearchTree() {
        root = null;
    }
    public void insertNode(int item) {
        root = insertNodeRecursive(root, item);
    }
    public Node insertNodeRecursive(Node root, int item) {
        if(root==null) {
            return new Node(item);
        }
        if (item < root.item) {
            root.left = insertNodeRecursive(root.left, item);
        } else if (item > root.item) {
            root.right = insertNodeRecursive(root.right, item);
        }
        return root;
    }
    public void inorder() {
        inorderRec(root);
    }
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.item + " ");
            inorderRec(root.right);
        }
    }

    public void postorder() {
        postorderRec(root);
    }
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.right);
            System.out.print(root.item + " ");
            postorderRec(root.left);
        }
    }

    public void preorder() {
        preorderRec(root);
    }
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.item + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    public int minItem() {
        return minItemRec(root);
    }
    public int minItemRec(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minItemRec(root.left);
        return Math.min(root.item, leftMin);
    }
    public int maxItem() {
        return maxItemRec(root);
    }
    public int maxItemRec(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int rightMax = maxItemRec(root.right);
        return Math.max(root.item, rightMax);
    }
}
