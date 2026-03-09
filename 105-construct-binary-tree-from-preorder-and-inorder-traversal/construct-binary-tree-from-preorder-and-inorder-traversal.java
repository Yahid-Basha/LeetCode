/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int j = inStart;
        while(preorder[preStart] != inorder[j]) j++;

        int k = j - inStart;
        root.left = build(preorder, inorder, preStart+1, preStart+k, inStart, j-1);
        root.right = build(preorder, inorder, preStart+k+1, preEnd, inStart+k+1, inEnd);
        return root;
    }
}