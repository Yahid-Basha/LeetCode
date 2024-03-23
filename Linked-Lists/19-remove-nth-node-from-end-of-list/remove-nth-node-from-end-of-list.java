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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size =1;
        ListNode temp = head;
        while(temp.next!=null){ 
            temp = temp.next;
            size++;
        }

        if(n==size){
            head = head.next;
            return head;
        }

        int i = 1;
        int nToDeleteFromFirst = size - n;
        ListNode prev = head;

        while(i<nToDeleteFromFirst){
            prev = prev.next;
            i++;
        } 

        prev.next = prev.next.next;
        return head;
    }
}