public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root,TreeNode x) {

        TreeNode ans = null;
        TreeNode curr = root;

        while(curr != null) {
            if(curr.val > x.val) {
                ans = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ans;
    }
}
