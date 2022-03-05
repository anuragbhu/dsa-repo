public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {

        // If Balanaced then it will return the height.
        // Else it will return the value -1.
        return countNodes(root) != -1;
    }

    public int countNodes(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftNodes = countNodes(root.left);
        if(leftNodes == -1) return -1;
        int rightNodes = countNodes(root.right);
        if(rightNodes == -1) return -1;

        if(Math.abs(leftNodes - rightNodes) > 1) return -1;

        return Math.max(leftNodes, rightNodes) + 1;
    }
}
