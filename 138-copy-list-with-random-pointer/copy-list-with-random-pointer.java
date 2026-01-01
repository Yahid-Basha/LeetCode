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
        Node curr = head;
        while(curr!=null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        Node original = head;
        while(original != null){
            if(original.random != null){
                original.next.random = original.random.next;
            }
            original = original.next.next;
        }
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while(curr!=null){
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;

            curr.next = curr.next.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}