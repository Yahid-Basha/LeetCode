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
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp != null ){
            temp = temp.next;
            size++;
        }

        if(size == 1){
            head = head.next;
            return head;
        }

        int n = (int)size/2;
        int i =1;
        ListNode prev = head;
        while(i<n){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}