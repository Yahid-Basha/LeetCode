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
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root.left, root.right});
        
        while(!stack.isEmpty()){
            TreeNode[] curr = stack.pop();
            TreeNode left = curr[0];
            TreeNode right = curr[1];
            if(left == right) continue;
            if(left != null && right != null){
                if(left.val != right.val) return false;
                stack.push(new TreeNode[]{left.left, right.right});
                stack.push(new TreeNode[]{left.right, right.left});
                continue;
            }
            if(left == null || right == null){
                return false;
            }
        }
        return true;
    }
}