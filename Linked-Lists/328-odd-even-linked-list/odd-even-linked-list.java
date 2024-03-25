/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        if(head.next.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = even;
        ListNode temp = head.next.next;
        boolean flag = true;
        while(temp!=null){
            if(flag){
                odd.next = temp;
                odd = temp;
            } else {
                even.next = temp;
                even = temp;
            }
            temp = temp.next;
            flag = !flag;
        }
       odd.next = evenStart;
       even.next = null;
       return head;
    }
}