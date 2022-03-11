public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return (p == null && q == null) || isSame(p, q);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            return p == q;
        }

        if(p.val != q.val) return false;

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
