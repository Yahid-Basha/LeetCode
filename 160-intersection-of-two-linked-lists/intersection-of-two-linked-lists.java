/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while(ptrA != ptrB){
            ptrA = ptrA != null ? ptrA.next : headB;
            ptrB = ptrB != null ? ptrB.next : headA;
        }

        return ptrA;
    }
}