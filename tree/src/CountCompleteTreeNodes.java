public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNoeds = countNodes(root.right);

        return leftNodes + rightNoeds + 1;
    }
}
