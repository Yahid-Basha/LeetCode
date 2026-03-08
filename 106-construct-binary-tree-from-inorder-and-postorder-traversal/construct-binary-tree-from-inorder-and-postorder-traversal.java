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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, postorder.length-1, 0, inorder.length-1);
    }
    TreeNode build(int[] inorder, int[] postorder, int posStart, int posEnd, int inStart, int inEnd){
        if(posStart > posEnd) return null;
        TreeNode root = new TreeNode(postorder[posEnd]);
        int j = 0;
        while(inorder[j] != root.val){
            j++;
        }
        int k = j - inStart;
        root.left = build(inorder, postorder, posStart, posStart+k-1, inStart, j-1);
        root.right = build(inorder, postorder, posStart+k, posEnd-1, j+1, inEnd);
        return root;
    }
}