public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        return root == null || isSymmetricBT(root.left, root.right);
    }

    private boolean isSymmetricBT(TreeNode left, TreeNode right) {
        if(left == null || right == null) {
            return left == right;
        }

        if(left.val != right.val) return false;

        return isSymmetricBT(left.left, right.right) && isSymmetricBT(left.right, right.left);
    }
}
