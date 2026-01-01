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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode tail = head;
        int n = 1;
        while(tail.next != null){
            n++;
            tail = tail.next;
        }

        tail.next = head;
        ListNode temp = head;
        ListNode prev = head;
        k = k%n;
        for(int i = 0; i < n-k; i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return temp;
    }
}