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
    class Node{
        TreeNode node;
        long pos;
        
        Node(TreeNode node, long pos){
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            long firstPos = 0, lastPos = 0;
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                TreeNode curr = node.node;
                long pos = node.pos;
                if(i == 0) firstPos = pos;
                if(i == size-1) lastPos = pos; 
                if(curr.left != null){
                    queue.offer(new Node(curr.left, 2*pos));
                }
                if(curr.right != null){
                    queue.offer(new Node(curr.right, 2*pos+1));
                }
            }
            maxWidth = Math.max(maxWidth, (int)(lastPos - firstPos +1));
        }
        return maxWidth;
    }
}