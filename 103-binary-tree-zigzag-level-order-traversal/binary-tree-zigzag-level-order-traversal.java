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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;

        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                curr.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(!leftToRight){
                Collections.reverse(curr);
            }
            ans.add(curr);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}