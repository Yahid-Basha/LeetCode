/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        copy(node, map);
        return map.get(node);
    }
    Node copy(Node original, Map<Node, Node> map){
        if(original == null) return null;
        if(map.containsKey(original)) return map.get(original);
        Node copyNode = new Node(original.val);
        copyNode.neighbors = new ArrayList<>();
        map.put(original, copyNode);
        for(Node n: original.neighbors){
            Node x = copy(n, map);
            if(x != null)
            copyNode.neighbors.add(x);
        }
        return copyNode;
    }
}