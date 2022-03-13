public class RangeSumBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val <= high && root.val >= low) {
            rangeSumBST(root.left, low, high);
            sum += root.val;
            rangeSumBST(root.right, low, high);
        } else if(root.val < high) {
            rangeSumBST(root.right, low, high);
        } else if(root.val > low) {
            rangeSumBST(root.left, low, high);
        }

        return sum;
    }
}
