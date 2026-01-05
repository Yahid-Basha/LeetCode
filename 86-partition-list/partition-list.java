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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode tempA = small;
        ListNode big = new ListNode(0);
        ListNode tempB = big;

        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            if(curr.val < x){
                curr.next = null;
                tempA.next = curr;
                tempA = tempA.next;
            }else{
                curr.next = null;
                tempB.next = curr;
                tempB = tempB.next;
            }
             curr = next;
        }

        tempA.next = big.next;
        return small.next;
    }
}