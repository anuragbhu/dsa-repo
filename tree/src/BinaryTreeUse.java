public class BinaryTreeUse {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
        root.left = rootLeft;
        root.right = rootRight;

        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<>(5);
        rootLeft.right = twoRight;
        rootRight.left = threeLeft;

//        preorderTraversal(root);
        printTreeDetailed(root);
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + ": ");
        if(root.left != null) {
            System.out.print("L" + root.left.data + ", ");
        }

        if(root.right != null) {
            System.out.print("R" + root.right.data + " ");
        }
        System.out.println();

        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static void preorderTraversal(BinaryTreeNode<Integer> root) {
        if(root == null) {
            System.out.print(-1 + " ");
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
