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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode node : lists){
            if(node != null)
            pq.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;
            if(temp.next != null){
                pq.offer(temp.next);
            }
        }
        return dummy.next;

    }
}