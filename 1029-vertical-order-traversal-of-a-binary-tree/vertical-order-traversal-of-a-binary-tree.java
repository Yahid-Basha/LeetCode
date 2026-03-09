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

        Node(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
            val = node.val;
        }

        int getRow(){
            return row;
        }

        int getCol(){
            return col;
        }

        int getVal(){
            return val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        queue.add(new Node(root, 0, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                list.add(node);
                TreeNode curr = node.node;
                int row = node.row, col = node.col;
                if(curr.left != null) queue.offer(new Node(curr.left, row+1, col-1));
                if(curr.right != null) queue.offer(new Node(curr.right, row+1, col+1));
            }
        }
        list.sort(Comparator.comparing(Node::getCol).thenComparing(Node::getRow).thenComparing(Node::getVal));
        for(Node node: list){
            int key = node.col;
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(node.val);
        }
        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);
        for(int key: sortedKeys){
            ans.add(map.get(key));
        }
        return ans;
    }
}