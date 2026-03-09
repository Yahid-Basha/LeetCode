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
    public void flatten(TreeNode root) {
        flattener(root);
    }
    void flattener(TreeNode root){
        if(root == null) return;
        if(root.left == null) {
            flattener(root.right);
            return;
        }

        flattener(root.left);

        TreeNode curr = root.left;
        while(curr.right != null){
            curr = curr.right;
        }

        flattener(root.right);

        curr.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}