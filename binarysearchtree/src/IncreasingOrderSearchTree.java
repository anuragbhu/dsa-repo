public class IncreasingOrderSearchTree {
    TreeNode res = new TreeNode(-1); // Define any dummy value;
    TreeNode newRoot = res;

    public TreeNode increasingBST(TreeNode root) {

        increasingOrder(root);
        return newRoot.right;
    }

    public void increasingOrder(TreeNode root) {
        if(root == null)
            return;

        increasingOrder(root.left);
        res.right = new TreeNode(root.val);
        res = res.right; // Move to the right --> Similar to Linked List
        increasingOrder(root.right);
    }
}
