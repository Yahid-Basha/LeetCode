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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        // invert left sub tree
        invert(root.left);
        //invert right dub tree
        invert(root.right);

        //swap left and right childs
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return;
    }
}