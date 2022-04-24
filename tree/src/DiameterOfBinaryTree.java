public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        // Base Condition/Case
        if (root == null) return 0;

        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // Induction
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
