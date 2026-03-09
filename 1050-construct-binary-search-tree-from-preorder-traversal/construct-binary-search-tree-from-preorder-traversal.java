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
    TreeNode build(int[] preorder, int preStart, int preEnd){
        if(preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int j = preStart+1;
        while(j < preorder.length && preorder[j] < root.val) j++;
        int k = j - preStart - 1;

        root.left = build(preorder, preStart+1, preStart+k);
        root.right = build(preorder, preStart+k+1, preEnd);
        return root;
    }
}