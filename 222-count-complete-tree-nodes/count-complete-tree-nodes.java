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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode curr = root;
        int ldepth = 0;
        while(curr != null){
            ldepth++;
            curr = curr.left;
        }
        int rdepth = 0;
        curr = root;
        while(curr != null){
            rdepth++;
            curr = curr.right;
        }
        if(ldepth == rdepth){
            return (int)Math.pow(2, ldepth)-1;
        }

        return 1+countNodes(root.left)+countNodes(root.right);
    }
}