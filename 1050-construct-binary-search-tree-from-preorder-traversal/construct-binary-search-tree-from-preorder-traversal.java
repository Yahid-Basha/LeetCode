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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length-1);
    }
    TreeNode build(int[] preorder, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int j = start;
        while(j < preorder.length && preorder[j] <= root.val) j++;
        root.left = build(preorder, start+1, j-1);
        root.right = build(preorder, j, end);
        return root;
    }
}