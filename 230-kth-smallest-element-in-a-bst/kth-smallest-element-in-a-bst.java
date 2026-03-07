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
    int[] a;
    public int kthSmallest(TreeNode root, int k) {
        a = new int[]{k};
        return inorder(root, a);
    }
    public int inorder(TreeNode root, int[] k){
        if(root == null) return -1;
        int left = inorder(root.left, k);
        if(left != -1) return left;
        k[0]--;
        if(k[0] == 0) return root.val;
        int right = inorder(root.right, k);
        if(right != -1) return right;
        return -1;
    }
}