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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root){
        if(root == null) return 0;

        int lsum = maxSum(root.left);
        int rsum = maxSum(root.right);

        max = Math.max(lsum + rsum + root.val, max);
        int curr = Math.max(lsum, rsum) + root.val;
        return curr > 0 ? curr : 0;
    }
}