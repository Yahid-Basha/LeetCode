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
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        ListNode kFromFront = head;
        int i = 1;
        while(i<k){
            kFromFront = kFromFront.next;
            i++;
        }


        ListNode kFromBack = head;
        i = 1;
        while(i<=(size-k)){
            kFromBack = kFromBack.next;
            i++;
        }

        int tmp = kFromFront.val;
        kFromFront.val = kFromBack.val;
        kFromBack.val = tmp;
        return head;
    }
}