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
        int row;
        int col;
        int val;

        Node(TreeNode node, int col, int row){
            this.node = node;
            this.row = row;
            this.col = col;
        }

        int getCol(){
            return col;
        }

        int getRow(){
            return row;
        }

        int getVal(){
            return node.val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));
        List<Node> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                TreeNode curr = node.node;
                int col = node.col, row = node.row;
                list.add(node);
                if(curr.left!= null){
                    queue.offer(new Node(curr.left, col-1, row+1));
                }
                if(curr.right!= null){
                    queue.offer(new Node(curr.right, col+1, row+1));
                }
            }
        }
        list.sort(Comparator.comparing(Node::getCol).thenComparing(Node::getRow).thenComparing(Node::getVal));
        for(Node node: list){
            map.computeIfAbsent(node.col, k -> new ArrayList<>()).add(node.node.val);
        }
        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);
        for(int key: sortedKeys){
            ans.add(map.get(key));
        }
        return ans;
    }
}