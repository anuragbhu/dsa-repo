public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        return delete(root, key);
    }

    private TreeNode inorderSuccessor(TreeNode root) {
        TreeNode curr = root;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    private TreeNode delete(TreeNode root, int key) {
        if(root == null) {
            return root;
        }

        if(key < root.val) {
            root.left = delete(root.left, key);
        } else if(key > root.val) {
            root.right = delete(root.right, key);
        } else {
            if(root.left == null && root.right == null) { // CASE 1: Leaf Node
                root = null;
                return root;
            } else if(root.left != null && root.right == null) { // CASE 2(A): One child as left
                TreeNode temp = root.left;
                root = temp;
                return root;
            } else if(root.left == null && root.right != null) { // CASE 2(B): One child as right
                TreeNode temp = root.right;
                root = temp;
                return root;
            } else { // // CASE 3: both children are present
                TreeNode temp = inorderSuccessor(root.right);
                root.val = temp.val; // swap values
                root.right = delete(root.right, temp.val); // to delete the inorder successor node
                return root;
            }
        }

        return root;
    }
}