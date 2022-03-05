public class BTFromPreorderAndInorderTraversal {
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) {
            return null;
        }

        int curr = preorder[idx];
        idx++;
        TreeNode node = new TreeNode(curr);

        if(start == end) {
            return node;
        }

        int pos = search(inorder, start, end, curr);
        node.left = buildTree(preorder, inorder, start, pos-1);
        node.right = buildTree(preorder, inorder, pos+1, end);

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
