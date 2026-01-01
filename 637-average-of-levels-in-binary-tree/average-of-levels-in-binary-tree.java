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
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            Double sum = 0.0;
            for(int i =0; i < size; i++){
                TreeNode curr = que.poll();
                sum += curr.val;

                if(curr.right != null) que.offer(curr.right);
                if(curr.left != null) que.offer(curr.left);
            }
            ans.add(sum/size);
        }
        
        return ans;
    }
}