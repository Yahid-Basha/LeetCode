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
    TreeNode prev;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        explore(root);
        return min;
    }
    void explore(TreeNode root){
        if(root == null) return;
        explore(root.left);
        if(prev != null){
            min = Math.min(min, Math.abs(root.val - prev.val));
        }
        prev = root;
        explore(root.right);
    }
}