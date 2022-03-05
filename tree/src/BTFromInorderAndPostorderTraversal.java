public class BTFromInorderAndPostorderTraversal {
    int idx = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length-1;
        return buildTree(inorder, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int start, int end) {
        if(start > end) {
            return null;
        }

        int curr = postorder[idx];
        idx--;
        TreeNode node = new TreeNode(curr);

        if(start == end) {
            return node;
        }

        int pos = search(inorder, start, end, curr);
        node.right = buildTree(inorder, postorder, pos+1, end);
        node.left = buildTree(inorder, postorder, start, pos-1);

        return node;
    }

    private int search(int[] inorder, int start, int end, int curr) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == curr) {
                return i;
            }
        }

        return -1;
    }
}
