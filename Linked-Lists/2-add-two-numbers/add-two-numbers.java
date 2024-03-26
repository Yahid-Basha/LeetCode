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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;
        ListNode newL = new ListNode();
        ListNode nnL = newL;
        int sum=0, carry = 0;
        while(t1 != null && t2 != null){
            sum = t1.val+t2.val+carry;
            carry = 0;
            if(sum>9){
                carry = 1;
                newL.val = sum%10;
            } else {
                newL.val = sum;
            }
            if((t1.next != null) && (t2.next != null)){
            newL.next = new ListNode();
            newL = newL.next;
            } 
            t1 = t1.next;
            t2 = t2.next;
        }
        if(t1 == null){
            while(t2!=null){
                newL.next = new ListNode();
                newL = newL.next;
                sum = t2.val+carry;
                newL.val = sum>9 ? sum%10 : sum;
                carry = sum>9 ? 1: 0;
                t2 = t2.next; 
            }
            if(carry==1){
                newL.next = new ListNode();
                newL = newL.next;
                newL.val = 1;
                carry = 0;
            }
        }
       if(t2 == null){
            while(t1!=null){
                newL.next = new ListNode();
                newL = newL.next;
                sum = t1.val+carry;
                newL.val = sum>9 ? sum%10 : sum;
                carry = sum>9 ? 1: 0;
                t1 = t1.next; 
            }
            if(carry==1){
                newL.next = new ListNode();
                newL = newL.next;
                newL.val = 1;
            }
        }
        return nnL;
    }
}