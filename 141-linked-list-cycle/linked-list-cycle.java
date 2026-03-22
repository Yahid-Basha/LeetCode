/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next != null && fast != slow){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != null && fast == slow){
            return true;
        }
            return false;
        
    }
}