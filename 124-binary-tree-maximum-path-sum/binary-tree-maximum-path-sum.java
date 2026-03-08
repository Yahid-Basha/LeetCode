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
        explore(root);
        return max;
    }
    int explore(TreeNode root){
        if(root == null) return 0;

        int lsum = explore(root.left);
        int rsum = explore(root.right);
        
        int currSum = Math.max(root.val+lsum, root.val+rsum);
        max = Math.max(max, root.val+lsum+rsum);

        return  currSum > 0 ? currSum : 0;
    }

}