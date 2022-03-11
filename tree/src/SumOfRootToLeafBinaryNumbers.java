public class SumOfRootToLeafBinaryNumbers {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int val){
        if(root == null) return;

        val = val * 2 + root.val;
        if(root.left == null && root.right == null) sum += val; // this is leat node.

        dfs(root.left, val);
        dfs(root.right, val);
    }
}
