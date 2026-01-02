/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p) return p;
        if(root == q) return q;
        
        TreeNode left = root.left != null ? lowestCommonAncestor(root.left,p,q) : null;
        TreeNode right = root.right != null ? lowestCommonAncestor(root.right,p,q) : null;
        if(left != null && right != null) return root;
        
        return left == null ? right : left;
    }
}