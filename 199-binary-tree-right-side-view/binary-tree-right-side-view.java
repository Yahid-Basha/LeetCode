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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        que.offer(null);

        while(!que.isEmpty()){
            TreeNode curr = que.poll();
            if(curr == null){
                if(!que.isEmpty()) que.offer(null);
            }else{
                if(que.peek() == null){
                    ans.add(curr.val);
                }

                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
            }
        }
        return ans;
    }
}