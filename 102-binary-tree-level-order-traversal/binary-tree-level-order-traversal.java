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
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        List<Integer> list = new ArrayList<>();
        while(!que.isEmpty()){
            TreeNode curr = que.poll();
            if(curr == null){
                ans.add(list);
                list = new ArrayList<>();
                if(que.isEmpty()){
                    break;
                }else{
                    que.add(null);
                }
            }else{
                list.add(curr.val);
                if(curr.left != null)
                    que.offer(curr.left);
                if(curr.right != null)
                    que.offer(curr.right);
            }
        }
        return ans;
    }
}