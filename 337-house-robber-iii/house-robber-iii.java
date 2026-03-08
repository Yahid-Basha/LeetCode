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
    public int rob(TreeNode root) {
        int[] ans = explore(root);
        return Math.max(ans[0],ans[1]);
    }
    int[] explore(TreeNode root){
        if(root == null) return new int[2];

        int[] left = explore(root.left);
        int[] right = explore(root.right);

        int robCurrent = root.val+left[1]+right[1];
        int skipCurrent = Math.max(left[0], left[1])+Math.max(right[0], right[1]);

        return new int[]{robCurrent, skipCurrent};
    }
}