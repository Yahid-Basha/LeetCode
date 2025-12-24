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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> currLvl = new ArrayList<>();
            int currSize = que.size();
            for(int i = 0; i < currSize; i++){
                TreeNode currNode = que.poll();
                currLvl.add(currNode.val);
                if(currNode.left != null)
                    que.offer(currNode.left);
                if(currNode.right != null)
                    que.offer(currNode.right);
            }
            ans.add(currLvl);
        }
        return ans;
     }
}