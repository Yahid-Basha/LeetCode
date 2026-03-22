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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        ListNode beforeLeft = null, leftNode = null, afterRight = null, rightNode=null;
        while(temp != null){
            if(i == left-1){
                beforeLeft = temp;
            }
            if(i == left){
                leftNode = temp;
            }
            if( i == right){
                rightNode = temp;
                afterRight = temp.next;
            }
            temp = temp.next;
            i++;
        }
        beforeLeft.next = null;
        afterRight = rightNode.next; 
        rightNode.next = null;
        reverse(leftNode);
        beforeLeft.next = rightNode;
        leftNode.next = afterRight;
        return dummy.next;
    }
    public ListNode reverse(ListNode head) {
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