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
    List<Long> allSums;
    public int maxProduct(TreeNode root) {
        allSums = new ArrayList<>();
        long totalSum = calculateSums(root);
        long maxSum = -1;
        for(Long s: allSums){
            maxSum = Math.max(maxSum, (totalSum - s)*s);
        }
        return (int) (maxSum % 1000000007);
    }
    public Long calculateSums(TreeNode root){
        if(root == null) return (long)0;
        long currSum = root.val + calculateSums(root.left)+calculateSums(root.right);
        allSums.add(currSum);
        return currSum;
    }

}