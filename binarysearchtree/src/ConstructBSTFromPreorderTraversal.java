public class ConstructBSTFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int val : preorder) {
            root = insertIntoBST(root, val);
        }

        return root;
    }

    private TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
