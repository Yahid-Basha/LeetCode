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
    public ListNode detectCycle(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        boolean cycle = false;
        int count = 0;
        while(fp != null && fp.next != null){
            sp = sp.next;
            fp = fp.next.next;
            if(sp == fp){
                cycle = true;
                break;
            }
        }
        if(cycle){
            sp = head;
            while(sp != fp){
                sp = sp.next;
                fp = fp.next;
                
            }
            return sp;
        }
        return null;
    }
}