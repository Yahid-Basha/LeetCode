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
    class Rob{
        int skipCurrent;
        int robCurrent;
        Rob(int s, int r){
            skipCurrent = s;
            robCurrent = r;
        }
    }
    public int rob(TreeNode root) {
        Rob ans = explore(root);
        return Math.max(ans.robCurrent, ans.skipCurrent);
    }
    Rob explore(TreeNode root){
        if(root == null) return new Rob(0,0);
        Rob left = explore(root.left);
        Rob right = explore(root.right);

        int robCurrent = left.skipCurrent + right.skipCurrent + root.val;
        int skipCurrent = Math.max(left.robCurrent, left.skipCurrent)+ Math.max(right.robCurrent, right.skipCurrent);

        return new Rob(skipCurrent, robCurrent);
    }

}