// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;

        if (root.val == val) {
            return root;
        } else {
            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        if(root == null) return root;

        while(root != null) {
            if(root.val == val){
                return root;
            } else{
                root = val < root.val ? root.left : root.right;
            }
        }
        return root; // Never comes.
    }
}
