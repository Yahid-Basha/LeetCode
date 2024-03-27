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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHalf = slow.next;
        ListNode leftHalf = head;
        slow.next = null;
        ListNode LH = sortList(leftHalf);
        ListNode RH = sortList(rightHalf);
        return merge(LH,RH);
    }
    public ListNode merge(ListNode LH, ListNode RH){
        ListNode mergedLL = new ListNode(Integer.MIN_VALUE);
        ListNode merged = mergedLL;
        while(LH != null && RH != null){
            if(LH.val < RH.val){
                mergedLL.next =  LH;
                LH = LH.next;
            } else {
                mergedLL.next = RH;
                RH = RH.next;
            }
            mergedLL = mergedLL.next;
        }
        while(LH != null){
            mergedLL.next =  LH;
            LH = LH.next;
            mergedLL = mergedLL.next;
        }
        while(RH != null){
            mergedLL.next =  RH;
            RH = RH.next;
            mergedLL = mergedLL.next;
        }
        return merged.next;
    }
}