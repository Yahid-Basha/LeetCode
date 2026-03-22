/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copies = new HashMap<>();
        Node temp = head;
        while(temp != null){
            copies.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node curr = copies.get(temp);
            if(temp.next == null){
                curr.next = null;
            }else{
                curr.next = copies.get(temp.next);
            }
            if(temp.random == null){
                curr.random = null;
            }else{
                curr.random = copies.get(temp.random);
            }
            temp = temp.next;
        }
        return copies.get(head);
    }
}