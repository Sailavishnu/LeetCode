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
        if (head == null || head.next==null) return head;

        ListNode current = head;

        int count = 1 ;
        while(current.next != null) {
            current = current.next;
            count++;
        }

        current.next = head;

        k = k % count;

        int step_new_tail = count - k - 1;

        ListNode newtail = head;

        for (int i = 0 ;i < step_new_tail ; i++){
            newtail = newtail.next;
        }

        ListNode newhead = newtail.next;

        newtail.next = null;

        return newhead;
    }
}