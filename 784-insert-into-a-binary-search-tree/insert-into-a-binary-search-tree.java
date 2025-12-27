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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        return insert(root, node);
        //  root;
    }
    public TreeNode insert(TreeNode root, TreeNode node){
        if(root == null) return node;

        if(root.val < node.val){
            root.right = insert(root.right, node);
        }else{
            root.left = insert(root.left, node);
        }
        return root;
    }
}