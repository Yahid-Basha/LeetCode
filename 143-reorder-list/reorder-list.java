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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        tail = reverseList(tail);
        // Merge
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(head != null && tail != null){
            temp.next = head;
            temp = temp.next;
            head = head.next;

            temp.next = tail;
            tail = tail.next;
            temp = temp.next;
        }
        if(head == null){
            temp.next = tail;
        }else{
            temp.next = head;
        }
        head = dummy.next;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}