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
        ListNode current1 = l1, current2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while(current1 != null || current2 != null){
            int num1 = current1 != null ? current1.val : 0;
            int num2 = current2 != null ? current2.val : 0;
            int sum = num1 + num2 + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            current.next = node;
            current = current.next;
            current1 = current1 != null ? current1.next : null;
            current2 = current2 != null ? current2.next : null;
        }
        if(carry > 0)
            current.next = new ListNode(carry);
        return dummy.next;
    }
}
