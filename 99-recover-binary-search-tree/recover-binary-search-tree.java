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
    TreeNode prev = null, first = null, second = null;
    public void recoverTree(TreeNode root) {
        explore(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    void explore(TreeNode root){
        if(root == null) return;
        explore(root.left);
        TreeNode curr = root;
        if(prev != null && prev.val > curr.val){
            if(first == null){
                first = prev;
                second = curr;
            }else{
                second = curr;
            }
        }
        prev = root;
        explore(root.right);
    }
}