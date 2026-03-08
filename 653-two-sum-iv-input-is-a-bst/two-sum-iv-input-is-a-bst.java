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
    List<Integer> list = new ArrayList<>();
    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int i = 0;
        int j = list.size()-1;

        while(i < j){
            if(list.get(i)+list.get(j) == k) return true;
            if(list.get(i)+list.get(j) < k){
                i++;
            }else{
                j--;
            }
        }

        return false;
    }
}