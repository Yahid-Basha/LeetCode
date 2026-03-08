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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                sum+=curr.val;
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            ans.add(sum/size);
        }
        return ans;
    }
}