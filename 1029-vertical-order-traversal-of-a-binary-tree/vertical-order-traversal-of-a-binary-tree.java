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
            this.val = node.val;
        }

        int getCol(){
            return col;
        }

        int getRow(){
            return row;
        }

        int getVal(){
            return val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        queue.offer(new Node(root, 0, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                list.add(node);
                TreeNode curr = node.node;
                int col = node.col;
                int row = node.row;
                if(curr.left != null){
                    queue.offer(new Node(curr.left, col-1, row+1));
                }
                if(curr.right != null){
                    queue.offer(new Node(curr.right, col+1, row+1));
                }
            }
        }
        list.sort(Comparator.comparing(Node::getCol).thenComparing(Node::getRow).thenComparing(Node::getVal));
        for(Node node: list){
            if(!map.containsKey(node.col)){
                map.put(node.col, new ArrayList<>());
            }
            map.get(node.col).add(node.val);
        }
        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);
        for(int key : sortedKeys){
            ans.add(map.get(key));
        }
        return ans;
    }
}