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
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validate(TreeNode root, long leftBound, long rightBound){
        if(root == null) return true;
        if(root.val <= leftBound  || root.val >= rightBound) return false;
        return validate(root.left, leftBound, Math.min(rightBound, root.val)) && validate(root.right, root.val, rightBound);
    }
}