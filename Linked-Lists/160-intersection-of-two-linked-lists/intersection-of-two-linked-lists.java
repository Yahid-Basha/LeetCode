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
        ListNode tempA = headA, tempB = headB;
        int a = 0,b = 0, length;
        while(tempA != null){
            a++;
            tempA = tempA.next;
        }

        while(tempB != null){
            b++;
            tempB = tempB.next;
        }
        
        if(a>b){
            length = a-b;
            while(length>0){
                headA = headA.next;
                length--;
            }
        }
        else if(a<b){
            length = b - a;
            while(length>0){
                headB = headB.next;
                length--;
            }
        }

        while(headA!= null && headB!=null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}